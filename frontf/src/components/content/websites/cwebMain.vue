<template>
    <div>
            <b-container fluid>
                <b-row  class="my-1">
                    <b-col sm="3">
                        <label>{{$t('c_WEB_COMPANY_NAME')}}</label> 
                    </b-col>
                    <b-col sm="9">
                        <b-form-input v-model="form.companyName" size="sm" type="text"></b-form-input> 
                    </b-col>
                </b-row> 
                <b-row  class="my-1">
                    <b-col sm="3">
                        <label>{{$t('C_WEB_COMPANY_ADDRESS')}}</label> 
                    </b-col>
                    <b-col sm="9">
                        <b-form-input v-model="form.address" size="sm" type="text"></b-form-input> 
                    </b-col>
                </b-row>    
                <b-row  class="my-1">
                    <b-col sm="3">
                        <label>{{$t('C_WEB_COMPANY_EMAIL')}}</label> 
                    </b-col>
                    <b-col sm="9">
                        <b-form-input v-model="form.email" size="sm" type="text"></b-form-input> 
                    </b-col>
                </b-row>      
                <b-row  class="my-1">
                    <b-col sm="3">
                        <label>{{$t('C_WEB_COMPANY_FAX')}}</label> 
                    </b-col>
                    <b-col sm="9">
                        <b-form-input v-model="form.fax" size="sm" type="text"></b-form-input> 
                    </b-col>
                </b-row>  
                <b-row  class="my-1">
                    <b-col sm="3">
                        <label>{{$t('C_WEB_COMPANY_TEL')}}</label> 
                    </b-col>
                    <b-col sm="9">
                        <b-form-input v-model="form.tel" size="sm" type="text"></b-form-input> 
                    </b-col>
                </b-row>  
                <b-row  class="my-1">
                    <b-col sm="3">
                        <label>{{$t('C_WEB_COMPANY_OTHER_DES')}}</label> 
                    </b-col>
                    <b-col sm="9">
                        <b-form-input v-model="form.desc" size="sm" type="text"></b-form-input> 
                    </b-col>
                </b-row>  
                <b-row class="my-1">
                            <b-col>
                                <b-button size="small" variant="primary" v-on:click="save">{{$t('C_WEB_SAVE')}}</b-button>
                            </b-col>
                </b-row>      
            </b-container>
    </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';

export default {
    name:'cwebMain',
    components:{
       
    },
    props:{
          } ,
    data(){
      return {
          form:{
              companyName:""  ,
              address:"",
              email:"" ,
              fax:"",
              tel:"",
              desc:""
          }
        
      }
    } ,
    methods:{
        clearForm(){
            var self = this.form;
              self.companyName = "";
              self.address = "" ;
              self.email= "";
              self.fax = "";
              self.tel= "";
              self.desc= "";
        },
        save(){
               var self = this;
               const url="/aboutUs/save" ;
               self.form.product= self.id;
               axiosInstance.post(url,self.form)
                    .then((res) => {
                        console.log(res);
                    })
                    .catch((err) => {
                        console.log(err);
                    })            
        },
        load(){
                        var self = this;
            const url = `/aboutUs/list`;
            axiosInstance.get(url,{
                params:{
                    form: self.form
                }
            })
                .then(function(res){
                    self.form = res.data;
                    //self.loadKeyowrds(); 
                })
                .catch(function(error){
                    console.log('error load keywords....');
                    console.log(error)    ;
                });
        }
    },
    created() {
            this.load();
    },  
}
</script>

<style scoped>

</style>