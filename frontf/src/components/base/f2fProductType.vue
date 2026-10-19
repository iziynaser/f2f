<template>
    <div>
          <b-row>
                 <b-col class="col-2">
                       {{labell}}
                 </b-col>
                 <b-col class="col-4">
                        <select class="m-2" id="t" v-model="invoiceType">
                              <option disabled value="" selected="selected">{{selectOptionLabel}}</option>
                              <option v-for="item in invoiceTypes" :key="item.id" v-bind:value="item.id">
                                    {{item.name}}
                              </option>
                        </select>
                 </b-col>
          </b-row>

    </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';

export default {
    name:'f2fProductType',
    props:{
          labell: String,
          fetchUrl: String,
          selectOptionLabel:String,
          },
    data(){
      return {
        invoiceTypes:[],
        invoiceType:'',
      }
    } ,
    mounted(){
      var self = this;
      axios({
                method:'GET',
                url:self.fetchUrl,
                params:{
                  },
                withCredentials:true
            })
              .then(function (response) {
                  self.invoiceTypes = response.data; 
            }).catch(function (error) {              
                  console.log(error);              
      }) ;


    },
    methods:{

    }      
}
</script>

<style scoped>

</style>