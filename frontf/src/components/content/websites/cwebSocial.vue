<template>
    <div>
                            <b-container fluid>
                                  <b-row  class="my-1">
                                      <b-col sm="3">
                                           <label>{{$t('C_SOCIAL_LINKEDIN_ADDRESS')}}</label> 
                                      </b-col>
                                      <b-col sm="6">
                                           <b-form-input v-model="form.linkedInAddress" 
                                                         size="sm" 
                                                         type="text"></b-form-input> 
                                      </b-col>
                                      <b-col sm="3">
                                         <b-form-checkbox name="linkedIncheckButton" switch>{{label}}</b-form-checkbox>
                                      </b-col>
                                  </b-row>            
                                  <b-row   class="my-1">
                                      <b-col sm="3">
                                           <label>{{$t('C_SOCIAL_APARAT_ADDRESS')}}</label> 
                                      </b-col>
                                      <b-col sm="6">
                                           <b-form-input v-model="form.aparatAddress" 
                                                         size="sm" 
                                                         type="text"></b-form-input> 
                                      </b-col>
                                      <b-col sm="3">
                                         <b-form-checkbox name="aparatcheckButton" switch>{{label}}</b-form-checkbox>
                                      </b-col>

                                  </b-row>      
                                  <b-row   class="my-1">
                                      <b-col sm="3">
                                           <label>{{$t('C_SOCIAL_INSTAGRAM_ADDESS')}}</label> 
                                      </b-col>
                                      <b-col sm="6">
                                           <b-form-input  v-model="form.instaAddress" 
                                                          size="sm" 
                                                          type="text"></b-form-input> 
                                      </b-col>
                                       <b-col sm="3">
                                         <b-form-checkbox name="instacheckButton" switch>{{label}}</b-form-checkbox>
                                      </b-col>
                                  </b-row>  
                                  <b-row   class="my-1">
                                      <b-col sm="3">
                                           <label>{{$t('C_SOCAIL_TWIITER_ADDRESS')}}</label> 
                                      </b-col>
                                      <b-col sm="6">
                                           <b-form-input v-model="form.twitterAddress" 
                                                         size="sm" 
                                                         type="text"></b-form-input> 
                                      </b-col>
                                       <b-col sm="3">
                                         <b-form-checkbox name="twittcheckButton" switch>{{label}}</b-form-checkbox>
                                      </b-col>
                                  </b-row>      
                        <b-row class="my-1">
                            <b-col>
                                <b-button size="small" variant="primary" v-on:click="saveSocialSetting">{{$t('C_WEB_SAVE')}}</b-button>
                            </b-col>
                        </b-row>

                            </b-container>
    </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';


export default {
    name:'cwebSocial',
    components:{
      
    },
    props:{
          } ,
    data(){
      return {
          form:{
               linkedInAddress:"",
               aparatAddress:"",
               twitterAddress:"",
               instagramAddress:"" 
          }        
      }
    } ,
    methods:{
        clearForm(){
            var self = this;
            self.productId="";
            self.productCode="";
            self.internalName="";
            self.name="";
            self.comment="";
            //self.isVirtual="";
            self.introDate="";
            self.releaseDate="";
            self.disContinuedDate="";
            self.brand="";
        },
        saveSocialSetting(){
            var self = this ;
            const url = `/socialSetting/saveOrUpdate`
            axiosInstance.post(url,self)
                .then((res)=>{
                     console.log(res);   
                })
                .catch((err)=>{
                    console.log(err);
                });
        },
        saveProduct(){
            var self = this;
            const url = `/products/save`;
            axiosInstance.post(url,self.product)
                        .then((res)=>{
                            console.log(res);
                        })
                        .catch((err) => {
                            console.log(err);
                        });
    }
    }      
}
</script>

<style scoped>

</style>