<template>
    <div>
        <b-button pressed="false" v-b-toggle.quickCategoryCreate>+</b-button>
        <b-collapse id="quickCategoryCreate" >
        <b-container fluid>
            <!-- {{categoryCode}} -->
            <b-row  class="my-1">
                <b-col sm="5">
                    <label for="categoryCode">{{$t('CATEGORIES_MAIN_categoryCode')}}</label> 
                </b-col>
                <b-col sm="7">
                    <b-form-input id="categoryCode" v-model="form.categoryCode" size="sm" type="text"></b-form-input> 
                </b-col>
            </b-row>            
            <b-row  class="my-1">
                <b-col sm="5">
                    <label for="categoryName">{{$t('CATEGORIES_MAIN_categoryName')}}</label> 
                </b-col>
                <b-col sm="7">
                    <b-form-input id="categoryName" v-model="form.name" size="sm" type="text"></b-form-input> 
                </b-col>
            </b-row>
            <b-row  class="my-1">
                <b-col sm="5">
                    <label for="categoryDesc">{{$t('CATEGORIES_MAIN_categoryDesc')}}</label> 
                </b-col>
                <b-col sm="7">
                    <b-form-input id="categoryDesc" v-model="form.description"  size="sm" type="text"></b-form-input> 
                </b-col>
            </b-row>
            <b-row class="my-1">
                <b-col>
                    <b-button size="small" variant="primary" v-on:click="save">
                        {{$t('CATEGORIES_MAIN_save')}}
                    </b-button>
                </b-col>
            </b-row>
        </b-container>          
        </b-collapse>
    </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';

export default {
    name:'createQuickCategory',
    props:{
        categoryCode:{
          type: Number,
          default:1
        },
        categoryType:{
            type: Number ,
            default:8
        }
    } ,
    data(){
      return {
        form:{
            name:"",
            parentCategory:"",
            description:"",
            categoryCode:"",
            categoryType:""
        },
        categoryList:[],
      }
    } ,
    methods:{
        clear(){
            this.form.name="",
            this.form.parentCategory="",
            this.form.description="",
            this.form.categoryCode="",
            this.form.categoryType=""
        },
        save(){
            var self = this;
            self.form.parentCategory = self.categoryCode;
            self.form.categoryType = self.categoryType;

            const url = `/Category/save`;
            axiosInstance.post(url,self.form)
                 .then((res)=>{
                     //console.log(res);
                     if(res!=undefined){
                        self.$emit('loadCategories',res.data);
                        self.clear();
                     }
                    //if(res.data.id)
                    //    self.setProductId(res.data.id);
                    })
                 .catch((err) => {
                    console.log(err);
            });
        },
    },created(){}      
}
</script>

<style scoped>

</style>