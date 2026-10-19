<template>
    <div>
        <b-container fluid>
            <b-row  class="my-1">
                <b-col sm="3">
                    <label for="categoryCode">{{$t('CATEGORIES_MAIN_categoryCode')}}</label> 
                </b-col>
                <b-col sm="9">
                    <b-form-input id="categoryCode" v-model="form.categoryCode" size="sm" type="text"></b-form-input> 
                </b-col>
            </b-row>            
            <b-row  class="my-1">
                <b-col sm="3">
                    <label for="name">{{$t('CATEGORIES_MAIN_categoryName')}}</label> 
                </b-col>
                <b-col sm="9">
                    <b-form-input id="name" v-model="form.name" size="sm" type="text"></b-form-input> 
                </b-col>
            </b-row>
			<b-row   class="my-1">
                <b-col sm="3">
                    <label for="productType">{{$t('CPRODUCT_MAIN_productType')}}</label> 
                </b-col>
                <b-col sm="9">
                    <f2fInvoiceType id="productType"
                                    fetchUrl="/ProductType/list"
                                    :selectOptionLabel="this.$t('CPRODUCT_MAIN_productType_select')"/> 
                </b-col>
            </b-row>            
            <b-row  class="my-1">
                <b-col sm="3">
                    <label for="description">{{$t('CATEGORIES_MAIN_categoryDesc')}}</label> 
                </b-col>
                <b-col sm="9">
                    <b-form-input id="description" v-model="form.description"  size="sm" type="text"></b-form-input> 
                </b-col>
            </b-row>
            <b-row  class="my-1">
                <b-col sm="3">
                    <label for="parentCategory">{{$t('CATEGORIES_MAIN_parentCategory')}}</label> 
                </b-col>
                <b-col sm="9">
                    <b-form-select id="parentCategory" v-model="form.parentCategory">
                        <template v-slot:first>
                            <b-form-select-option :value="null" disabled >select a parent category code</b-form-select-option>
                        </template>
                        <b-form-select-option :value="category.id" v-for="category in categoryList" :key="category.id">
                            {{category.name}}
                        </b-form-select-option>
                    </b-form-select>
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
    </div>
</template>

<script>

import * as axios from 'axios'

export default {
    name:'categoriesMain',
    props:{
    } ,
    data(){
      return {
        form:{
            name:"",
            parentCategory:"",
            description:"",
            categoryCode:"1",
        },
        categoryList:[],
      }
    } ,
    methods:{
        save(){
            var self = this;
            const url = `/Category/save`;
            axios.post(url,self.form)
                 .then((res)=>{
                     console.log(res);
                    //if(res.data.id)
                    //    self.setProductId(res.data.id);
                    })
                 .catch((err) => {
                    console.log(err);
            });
        },
        loadCategories(){
                var self = this;
                const url = `/Category/list`;
                axios.get(url,{
                params:{}
            })
                .then(function(res){
                    if(res)
                        self.categoryList = res.data;
                })
                .catch(function(error){
                    console.log(error)    ;
                });
        },
    },created(){
        this.loadCategories();
    }      
}
</script>

<style scoped>

</style>