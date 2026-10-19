<template>
    <div>
                            <b-container fluid>
                                  <b-row  class="my-1">
                                      <b-col sm="3">
                                           <label>{{$t('CPRODUCT_MAIN_productCode')}}</label> 
                                      </b-col>
                                      <b-col sm="9">
                                           <b-form-input v-model="product.productCode" 
                                                         size="sm" 
                                                         type="text"></b-form-input> 
                                      </b-col>
                                  </b-row>            
                                  <b-row   class="my-1">
                                      <b-col sm="3">
                                           <label>{{$t('CPRODUCT_MAIN_InternalName')}}</label> 
                                      </b-col>
                                      <b-col sm="9">
                                           <b-form-input v-model="product.internalName" 
                                                         size="sm" 
                                                         type="text"></b-form-input> 
                                      </b-col>
                                  </b-row>      
                                  <b-row   class="my-1">
                                      <b-col sm="3">
                                           <label>{{$t('CPRODUCT_MAIN_Name')}}</label> 
                                      </b-col>
                                      <b-col sm="9">
                                           <b-form-input  v-model="product.name" 
                                                          size="sm" 
                                                          type="text"></b-form-input> 
                                      </b-col>
                                  </b-row>  
                                                                    <b-row   class="my-1">
                                      <b-col sm="3">
                                           <label>{{$t('CPRODUCT_MAIN_productType')}}</label> 
                                      </b-col>
                                      <b-col sm="9">
                                           <f2fInvoiceType id="productType"
                                                           :labell="this.$t('INVOICE_TYPE_COMMON_select')" 
                                                           fetchUrl="/ProductType/list"
                                                           :selectOptionLabel="this.$t('INVOICE_TYPE_COMMON_selectOptionLabel')"/> 
                                      </b-col>
                                  </b-row>
                                  <b-row   class="my-1">
                                      <b-col sm="3">
                                           <label>{{$t('CPRODUCT_MAIN_Comment')}}</label> 
                                      </b-col>
                                      <b-col sm="9">
                                           <b-form-input v-model="product.comment" 
                                                         size="sm" 
                                                         type="text"></b-form-input> 
                                      </b-col>
                                  </b-row>      
                                  <b-row   class="my-1">
                                      <b-col sm="3">
                                           <label>{{$t('CPRODUCT_MAIN_Brand')}}</label> 
                                      </b-col>
                                      <b-col sm="9">
                                           <b-form-input v-model="product.brand" 
                                                         size="sm" 
                                                         type="text"></b-form-input> 
                                      </b-col>
                                  </b-row>      
                            <b-list-group>
                                <b-list-group-item>
                                    <b-row>
                                        <b-col>
                                            {{$t('CPRODUCT_MAIN_intro_date')}}
                                            <date-picker type="date"  v-model="product.introDate"></date-picker>
                                        </b-col>
                                        <b-col>
                                            {{$t('CPRODUCT_MAIN_release_date')}}
                                            <date-picker type="date"  v-model="product.releaseDate"></date-picker>
                                        </b-col>
                                        <b-col>
                                            {{$t('CPRODUCT_MAIN_sales_discontinuation')}}
                                            <date-picker type="date"  v-model="product.disContinuedDate"></date-picker>
                                        </b-col>
                                    </b-row>
                                </b-list-group-item>
                                <b-list-group-item>
                                    <!-- <b-form-group :label="$t('CPRODUCT_MAIN_is_virtual')">
                                        <b-form-radio v-model="product.isVirtual" name="isVirtual" value="0">no</b-form-radio>
                                        <b-form-radio v-model="product.isVirtual" name="isVirtual" value="1">yes</b-form-radio>
                                    </b-form-group> -->
                                </b-list-group-item>
                            </b-list-group>

                        <b-row class="my-1">
                            <b-col>
                                <b-button size="small" variant="primary" v-on:click="saveProduct">{{$t('save_product')}}</b-button>
                            </b-col>
                        </b-row>

                            </b-container>
    </div>
</template>

<script>

import * as axios from 'axios';
import VuePersianDateTimePicker from 'vue-persian-datetime-picker'

export default {
    name:'cPromoMain',
    components:{
        datePicker:VuePersianDateTimePicker
    },
    props:{
          } ,
    data(){
      return {
          product:{
            productId:"",
            productCode:"",
            internalName:"",
            name:"",
            comment:"",
            //isVirtual:"true",
            introDate:"",
            releaseDate:"",
            disContinuedDate:"",
            brand:""
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
        saveProduct(){
            var self = this;

            const url = `/products/save`;
            axios.post(url,self.product,
            {
            })
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