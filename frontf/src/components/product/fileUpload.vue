<template>
  <div id="app">
    <div class="container">

      <!-- load list of images -->
      <div>
        <strong>{{ $t('list_of_images_on_server')}}</strong>
        <ul>
          <li v-for="item in listOfImages" :key="item">
            <!-- <b-img :src="item" class="img-responsive img-thumnail"> -->
            <b-img rounded thumbnail fluid :src="item"></b-img>
          </li>
        </ul>
      </div>


      <!--UPLOAD-->
      <form enctype="multipart/form-data" novalidate v-if="isInitial || isSaving">
        <strong>{{$t('Upload_images')}}</strong>


        <div class="dropbox">
          <input type="file" multiple :name="uploadFieldName" :disabled="isSaving" @change="filesChange($event.target.name, $event.target.files); fileCount = $event.target.files.length"
            accept="image/*" class="input-file">
            <p v-if="isInitial">
              Drag your file(s) here to begin<br> or click to browse
            </p>
            <p v-if="isSaving">
              Uploading {{ fileCount }} files...
            </p>
        </div>
      </form>

      <!--SUCCESS-->
      <div v-if="isSuccess">
        <strong>Uploaded {{ uploadedFiles.length }} file(s) successfully.</strong>
        <p>
          <a href="javascript:void(0)" @click="reset()">Upload again</a>
        </p>
        <ul class="list-unstyled">
          <li v-for="item in uploadedFiles" :key="item.url">
            <b-img :src="item.uri" class="img-responsive img-thumbnail" :alt="item.originalName"/>
          </li>
        </ul>
      </div>
      <!--FAILED-->
      <div v-if="isFailed">
        <strong>Uploaded failed.</strong>
        <p>
          <a href="javascript:void(0)" @click="reset()">Try again</a>
        </p>
        <pre>{{ uploadError }}</pre>
      </div>
    </div>
  </div>
</template>

<script>
  // swap as you need
  //import { upload } from './file-upload.fake.service'; // fake service
  import { upload, loadListOfImages } from './file-upload.service';   // real service
  import { wait } from './utils';

  const STATUS_INITIAL = 0, STATUS_SAVING = 1, STATUS_SUCCESS = 2, STATUS_FAILED = 3;

  export default {
    name: 'fileUpload',
    props:{
      type:{
        required:true,
        type:String
      },
      productId:{
        required:true,
        type:Number
      }
    },
    data() {
      return {
        uploadedFiles: [],
        uploadError: null,
        currentStatus: null,
        uploadFieldName: 'photos',
        listOfImages:[]
      }
    },
    computed: {
      isInitial() {
        return this.currentStatus === STATUS_INITIAL;
      },
      isSaving() {
        return this.currentStatus === STATUS_SAVING;
      },
      isSuccess() {
        return this.currentStatus === STATUS_SUCCESS;
      },
      isFailed() {
        return this.currentStatus === STATUS_FAILED;
      }
    },
    methods: {
      reset() {
        // reset form to initial state
        this.currentStatus = STATUS_INITIAL;
        this.uploadedFiles = [];
        this.uploadError = null;

        //call list of uploaded server files
        if(this.productId==0)
          return

        loadListOfImages(this.productId,this.type)
          .then(x => {
            this.listOfImages = [].concat(x);
            console.log("list of uploaded server files:"+ this.listOfImages);
          })
          .catch(err => {
            //this.uploadError = err.response;
            console.log(err);
          });


      },
      save(formData) {
        // upload data to the server
        this.currentStatus = STATUS_SAVING;

        upload(formData)
          .then(wait(1500)) // DEV ONLY: wait for 1.5s 
          .then(x => {

            this.uploadedFiles = [].concat(x);
            console.log(x);
            //console.log(this.uploadedFiles);
        
            this.currentStatus = STATUS_SUCCESS;
          })
          .catch(err => {
            this.uploadError = err.response;
            this.currentStatus = STATUS_FAILED;
          });
      },
      filesChange(fieldName, fileList) {
        var self = this ;
        // handle file changes
        const formData = new FormData();

        if (!fileList.length) return;

        //new change
        console.log("p:"+self.productId+",type:"+self.type);
        formData.append("productId",this.productId);
        formData.append("type",this.type);
       //end new changes

        // append the files to FormData
        Array
          .from(Array(fileList.length).keys())
          .map(x => {
            formData.append(fieldName, fileList[x], fileList[x].name);
          });

        // save it
        this.save(formData);
      }
    },
    mounted() {
      this.reset();
    },
  }

</script>

<style >
/* <style lang="scss"> */
  .dropbox {
    outline: 2px dashed grey; /* the dash box */
    outline-offset: -10px;
    background: lightcyan;
    color: dimgray;
    padding: 10px 10px;
    min-height: 200px; /* minimum height */
    position: relative;
    cursor: pointer;
  }
  
  .input-file {
    opacity: 0; /* invisible but it's there! */
    width: 100%;
    height: 200px;
    position: absolute;
    cursor: pointer;
  }
  
  .dropbox:hover {
    background: lightblue; /* when mouse over to the drop zone, change color */
  }
  
  .dropbox p {
    font-size: 1.2em;
    text-align: center;
    padding: 50px 0;
  }
</style>