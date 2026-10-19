<template>
    <div>
                         <!-- <span v-if="id">id : {{id}}</span>
                 and <span v-if="title">title : {{title}}</span> -->

                            <b-container fluid>
                                  <b-row  class="my-1">
                                      <b-col sm="3">
                                           <label for="productCode">{{$t('CPRODUCT_MAIN_productCode')}}</label> 
                                      </b-col>
                                      <b-col sm="9">
                                           <b-form-input id="productCode"
                                                         v-model="product.productCode" 
                                                         size="sm" 
                                                         type="text"></b-form-input> 
                                      </b-col>
                                  </b-row>            
                                  <b-row   class="my-1">
                                      <b-col sm="3">
                                           <label for="internalName">{{$t('CPRODUCT_MAIN_InternalName')}}</label> 
                                      </b-col>
                                      <b-col sm="9">
                                           <b-form-input id="internalName"
                                                         v-model="product.internalName" 
                                                         size="sm" 
                                                         type="text"></b-form-input> 
                                      </b-col>
                                  </b-row>      
                                  <b-row   class="my-1">
                                      <b-col sm="3">
                                           <label for="productName">{{$t('CPRODUCT_MAIN_Name')}}</label> 
                                      </b-col>
                                      <b-col sm="9">
                                           <b-form-input  id="productName"
                                                          v-model="product.name" 
                                                          size="sm" 
                                                          type="text"></b-form-input> 
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
                                  <b-row   class="my-1">
                                      <b-col sm="3">
                                           <label for="productComment">{{$t('CPRODUCT_MAIN_Comment')}}</label> 
                                      </b-col>
                                      <b-col sm="9">
                                           <b-form-input id="productComment"
                                                         v-model="product.comment" 
                                                         size="sm" 
                                                         type="text"></b-form-input> 
                                      </b-col>
                                  </b-row>      
                                  <b-row   class="my-1">
                                      <b-col sm="3">
                                           <label for="productBrand">{{$t('CPRODUCT_MAIN_Brand')}}</label> 
                                      </b-col>
                                      <b-col sm="9">
                                           <b-form-input id="productBrand"
                                                         v-model="product.brand" 
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
                                <!-- <b-list-group-item>
                                    <b-form-group :label="$t('CPRODUCT_MAIN_is_virtual')">
                                        <b-form-radio v-model="product.isVirtual" name="isVirtual" value="0">no</b-form-radio>
                                        <b-form-radio v-model="product.isVirtual" name="isVirtual" value="1">yes</b-form-radio>
                                    </b-form-group>
                                </b-list-group-item> -->
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
//import ToastVue from '../../../Toast.vue';
import {mapActions} from 'vuex'

export default {
    name:'cProductMain',
    components:{
        datePicker:VuePersianDateTimePicker
    },
    props:{
            id:Number,
            title:String
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
            brand:"",
            id:0
          }
      }
    } ,
    methods:{
        ...mapActions(['setProductId']),
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
        loadProduct(){
            var self = this;
            const url = `/products/loadProductMainPart/`;
            axios.get(url,{
                params:{
                    productId: self.id
                }
            })
                .then((res)=>{
                    self.product = res.data;
                })
                .catch((err) => {
                    console.log(err);
                });
        },
        saveProduct(){
            var self = this;

            const url = `/products/save`;
            axios.post(url,self.product)
                        .then((res)=>{
                            if(res.data.id)
                                self.setProductId(res.data.id);
                            //console.log(res);
                        })
                        .catch((err) => {
                            console.log(err);
                        });
    }
    } ,
    created() {
            //this.$store.commit("showToast","the product page loaded....");
            if(this.id!==0){
                this.loadProduct();
            }
    },     
}
</script>

<style scoped>

</style>