<template>
<div>
        <div v-for="person in persons" :key="person.id" v-bind:value="person.id">
            <div>
                <b-img :src="person.img"/>
                <!-- <h3 @click="gotoDetail()">{{person.title}} {{person.name}}</h3> -->
            </div>    
        </div>
    <div>
            <b-container fluid>
                <b-row  class="my-1">
                    <b-col sm="3">
                        <label>{{$t('c_WEB_COMPANY_NAME')}}</label> 
                    </b-col>
                    <b-col sm="9">
                        <h3>{{form.companyName}}</h3> 
                    </b-col>
                </b-row> 
                <b-row  class="my-1">
                    <b-col sm="3">
                        <label>{{$t('C_WEB_COMPANY_ADDRESS')}}</label> 
                    </b-col>
                    <b-col sm="9">
                        {{form.address}} 
                    </b-col>
                </b-row>    
                <b-row  class="my-1">
                    <b-col sm="3">
                        <label>{{$t('C_WEB_COMPANY_EMAIL')}}</label> 
                    </b-col>
                    <b-col sm="9">
                        {{form.email}} 
                    </b-col>
                </b-row>      
                <b-row  class="my-1">
                    <b-col sm="3">
                        <label>{{$t('C_WEB_COMPANY_FAX')}}</label> 
                    </b-col>
                    <b-col sm="9">
                        {{form.fax}} 
                    </b-col>
                </b-row>  
                <b-row  class="my-1">
                    <b-col sm="3">
                        <label>{{$t('C_WEB_COMPANY_TEL')}}</label> 
                    </b-col>
                    <b-col sm="9">
                        {{form.tel}} 
                    </b-col>
                </b-row>  
                <b-row  class="my-1">
                    <b-col sm="3">
                        <label>{{$t('C_WEB_COMPANY_OTHER_DES')}}</label> 
                    </b-col>
                    <b-col sm="9">
                        {{form.desc}} 
                    </b-col>
                </b-row>  
                <!-- <b-row class="my-1">
                            <b-col>
                                <b-button size="small" variant="primary" v-on:click="saveProduct">{{$t('C_WEB_SAVE')}}</b-button>
                            </b-col>
                </b-row>       -->
            </b-container>
    </div>



</div>

</template>

<script>

import axiosInstance from "../api/axiosInstance";
export default {    
    name:'aboutUs' ,
    data(){
        return {
        form:{
              companyName:""  ,
              address:"",
              email:"" ,
              fax:"",
              tel:"",
              desc:""
          },
            textInput:'',
            persons:[
                {
                    name:'iziy',
                    img:'/images/logo/logo.png',
                    title:'naser',
                    id:17566
                },
            ]
        }
    },
    methods:{
        load(){
            //var self = this;
            const url = `/aboutUs/list/`;
          axiosInstance.get(url,{
                params:{
                }
            })
                .then((res)=>{
                    //self.product = res.data;
                    console.log(res);
                    this.form = res.data ;
                })
                .catch((err) => {
                    console.log(err);
                });
        },
},
    created() {
                this.load();
            }
}


</script>

<style scoped>

</style>
