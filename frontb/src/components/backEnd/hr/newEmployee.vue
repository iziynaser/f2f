<template>
    <div>

            <div>
                new employees form
                <b-row>
                    <b-col><b-button>new Employee</b-button></b-col>
                </b-row>

            </div>
            <b-form>

                  <b-form-group>
                      <b-row>
                        <b-col  class="col-2">{{$t('EMPLOYEES_name')}}</b-col>
                        <b-col  class="col-4">
                          <b-form-input id="name" readonly required :placeholder="this.$t('EMPLOYEES_name')" />
                        </b-col>                
                        </b-row>
                  </b-form-group>

                  <b-form-group>
                      <b-row>
                        <b-col  class="col-2">{{$t('EMPLOYEES_family')}}</b-col>
                        <b-col  class="col-4">
                          <b-form-input id="creattor" readonly required :placeholder="this.$t('EMPLOYEES_family')" />
                        </b-col>                
                        </b-row>
                  </b-form-group>

                  <b-form-group>
                      <b-row>
                        <b-col  class="col-2">{{$t('EMPLOYEES_internalCode')}}</b-col>
                        <b-col  class="col-4">
                          <b-form-input id="creattor" readonly required />
                        </b-col>                
                        </b-row>
                  </b-form-group>

                  <b-form-group>
                      <b-row>
                        <b-col  class="col-2">{{$t('EMPLOYEES_department')}}</b-col>
                        <b-col  class="col-4">
                          <b-form-input id="creattor" readonly required />
                        </b-col>                
                        </b-row>
                  </b-form-group>

                  <b-form-group>
                      <b-row>
                        <b-col  class="col-2">{{$t('EMPLOYEES_mrOrms')}}</b-col>
                        <b-col  class="col-4">
                          <b-form-input id="creattor" readonly required />
                        </b-col>                
                        </b-row>
                  </b-form-group>


              <b-form-group>
                <b-button variant="success" @click="saveinvoice">{{$t('EMPLOYEES_search')}}</b-button>
              </b-form-group>

            </b-form> 
    </div>
</template>

<script>


import axios from 'axios'

export default {
    name:'newEmployee',
    props:{
          } ,
    data(){
      return {
        id:'',
        name:'',
        title:'',
        productType:'',
        description:'',
        productDimension:'',
        isBusy:false,
        errors:{},
        searchResult:[],    
        searchFields:[
            {key:"title",label:'آقا/خانم'},
            {key:"firstName",label:'نام '},
            {key:"lastName",label:'نام خانوادگی'},
            {key:"dateOfBirth",label:'تاریخ تولد'},
            {key:"address",label:'داخلی'},
            {key:"description",label:'واحد'}
        ],            
      }
    } ,
    methods:{
          onSearchResult() {                
                var self = this;
                this.errors= {};
                this.isBusy = true;
                axios({
                    method:'GET',
                    url:'/person',
                })
                .then(function(res){
                      self.searchResult = res.data; 
                      console.log(res.data);
                      self.isBusy=false;
                })
                .catch(function(error){
                    console.log(error)    ;
                });
          }
    }      ,
    mounted(){
        this.onSearchResult();
    }
}
</script>

<style scoped>

</style>