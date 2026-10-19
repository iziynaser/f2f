<template>
    <div>
        <div>
            <b-row class="my-1">
                <b-col>
                <template>
                    <b-breadcrumb>
                        <b-breadcrumb-item href="#home" @click="loadCategories(1,'all categories')">
                            <b-icon-house-fill scale="1.25" shift-v="1.25" aria-hidden="true"></b-icon-house-fill>
                        </b-breadcrumb-item>
                        <b-breadcrumb-item v-for="breadcrumb in breadcrumbItems" 
                                           :key="breadcrumb.id" 
                                           href="#" 
                                           @click="loadCategories(breadcrumb.id,breadcrumb.text)">
                            {{breadcrumb.text}}
                        </b-breadcrumb-item>
                    </b-breadcrumb>
                </template>
                </b-col>
            </b-row>
            <b-row class="my-1">
                <b-col>
                    <b-card>
                    <b-form-radio-group  stacked name="checkButton">       
                        <b-form-radio :value="option.id" v-for="option in cols1"                         
                                      :key="option.id" 
                                      @change="loadCategories(option.id,option.name)">
                            {{option.name}}
                        </b-form-radio>
                    </b-form-radio-group>
                    </b-card>
                </b-col>
            </b-row>
        </div>
    </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';

export default {
    name:'categoryBrowser',
    props:{
            cType:{
                type:Number,
                default:8
            },
            cCode:{
                type:Number ,
                default : 1
            }
          } ,
    data(){
      return {
        value:[],
        cols1:[],
        breadcrumbItems:[],
        form:{
            cName:"",
            cCode:"",
        }            
      }
    } ,
    methods:{
        loadCategories(idv,idt){
                console.log('idv:'+idv+',idt:'+idt);
                var self = this;

                if(idv==1 && self.breadcrumbItems.length>1){
                    self.breadcrumbItems = self.breadcrumbItems.splice(0);
                }
                
                //self.form.categoryId=idv;
                self.form.cName = idt;
                self.form.cCode = idv;

                const url = `/Category/listById`;
                axiosInstance.get(url,{
                params:{id:idv,cId:self.cType}
            })
                .then(function(res){
                    if(res){
                        self.cols1 = res.data;
                        if(idv!==1){
                            let exist=false;
                            let idx=-1;
                            for(const [i,b] of self.breadcrumbItems.entries()){
                                if(b.id==idv){
                                     exist = true;
                                     idx=i;
                                }                                    
                            }
                            if(exist==false)        
                                self.breadcrumbItems.push({text:idt,id:idv,href:'#'});
                            else{
                                let L = self.breadcrumbItems.length-1 ;
                                if(L!==idx)
                                    var k = 0;
                                    while(k<L-idx){
                                         self.breadcrumbItems.pop();
                                         k++;   
                                    }                                        
                            }
                                
                        }else{
                            self.breadcrumbItems=[];
                        }

                        //load brands
                        //self.loadBrands(idv);
                        self.$emit('categoryChanged',self.form);
                    }                        
                })
                .catch(function(error){
                    console.log(error)    ;
                });
        },
    }
    ,created(){
        this.loadCategories(this.cCode,'همه دسته ها');
    }      
}
</script>

<style scoped>

</style>