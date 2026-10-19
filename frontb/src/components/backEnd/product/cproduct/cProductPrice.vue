<template>
    <div>

        <!-- <span v-if="id">id : {{id}}</span>
        and <span v-if="title">title : {{title}}</span> -->
        
          <f2fTable  :searchResult="searchResult" :searchFields="searchFields" :caption="this.$t('list_of_prices_related_to_this_product')" /> 

          <b-container fluid>
                <b-row  class="my-1">
                    <b-col sm="3">
                        <label for="priceType">{{$t('priceType')}}</label> 
                    </b-col>
                    <b-col sm="9">
                        <f2fPriceType             id="priceType"
                                                  v-model="form.priceType"  
                                                  fetchUrl="/priceType/list"
                                                  :selectOptionLabel="this.$t('C_PRICE_TYPE')"/> 
                    </b-col>
                </b-row>      
                <b-row class="my-1">
                    <b-col sm="3">{{$t('CPRODUCT_PRICE_fromDate')}}</b-col>
                    <b-col sm="9">
                         <date-picker v-model="form.fromDate" type="date"></date-picker> 
                    </b-col>
                </b-row>
                <b-row class="my-1">
                    <b-col sm="3">{{$t('CPRODUCT_PRICE_toDate')}}</b-col>
                    <b-col sm="9">
                        <date-picker v-model="form.toDate" type="date"></date-picker>
                    </b-col>
                </b-row>
                <b-row class="my-1">
                    <b-col sm="3">{{$t('CPRODUCT_PRICE_price')}}</b-col>
                    <b-col sm="9">
                        <b-form-input v-model="form.price" type="text"></b-form-input> 
                    </b-col>
                </b-row>
                <b-row class="my-1">
                    <b-col sm="3">{{$t('CPRODUCT_PRICE_currency')}}</b-col>
                    <b-col sm="9">
                        <b-form-input v-model="form.currencyType" type="text"></b-form-input> 
                    </b-col>
                </b-row>
                <b-row class="my-1">
                    <b-col sm="3">{{$t('CPRODUCT_PRICE_tax')}}</b-col>
                    <b-col sm="9">
                        <b-form-input v-model="form.tax" type="text"></b-form-input> 
                    </b-col>
                </b-row>

          </b-container>     
          <b-button v-on:click="save()" variant="primary">{{$t('CPRODUCT_PRICE_saveBtn')}}</b-button>
                   
    </div>
</template>

<script>

import * as axios from 'axios';
import f2fPriceType from '../../../base/f2fPriceType' ;
import VuePersianDateTimePicker from 'vue-persian-datetime-picker'
import f2fTable from '../../../base/f2fTable'

export default {
    name:'cProductPrice',
    props:{
            id:Number,
            title:String
          } ,
    data(){
      return {
        searchResult:[],
          searchFields:[
              {key:'id',label: this.$t('id')},
              {key:'fromDate',label: this.$t('fromDate')},
              {key:'toDate',label: this.$t('toDate')},
              {key:'price',label:this.$t('price')},
              {key:'tax',label:this.$t('pricing')},
              {key:'currency',label: this.$t('currency')},
          ] ,
          form:{
              priceType:0 ,
              fromDate:"" ,
              toDate:"",
              price:"",
              currencyType:"",
              tax:"",
              product:1
          }
      }
    } ,
    mounted(){
        if(this.id!==0)
            this.listOfPricesRelatedToProduct();
    },
    components:{
        f2fPriceType,
        f2fTable ,
        datePicker:VuePersianDateTimePicker
    },
    methods:{
        clear(){
            this.form.priceType="" ,
              this.form.fromDate="" ,
              this.form.toDate="",
              this.form.price="",
              this.form.currencyType="",
              this.form.tax=""
        },
        listOfPricesRelatedToProduct(){
                var self = this;
                this.errors= {};
                this.isBusy = true;
                axios({
                    method:'GET',
                    url:'/ProductPrice/list',
                    params: {productId : self.id}
                })
                .then(function(res){
                    console.log("list of product prices.");
                    self.items = res.data; 
                })
                .catch(function(error){
                    console.log(error)    ;
                });
        },
        save(){
            var self = this;

            const url = `/ProductPrice/save`;
            axios.post(url,self.form,
            {
                params:{
                }
            }).then((res)=>{
                    self.$store.commit("showToast","the product price Saved....");
                    self.listOfPricesRelatedToProduct();
                    console.log(res.id);
            }).catch((err) => {
                console.log(err);
            });
        }
        },
        list(){

        }
    }
</script>

<style scoped>

</style>