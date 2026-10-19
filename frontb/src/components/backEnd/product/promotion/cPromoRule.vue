<template>
    <div>
          <b-table>
              <!-- <b-table-lite>list of pricess related to this product<b-table-lite -->
          </b-table>
          <b-container fluid>
                <b-row  class="my-1">
                    <b-col sm="3">
                        <label for="priceType">priceType</label> 
                    </b-col>
                    <b-col sm="9">
                        default,minimum,maximum,box,wholesale,promotional,list price
                        <f2fPriceType             id="priceType"
                                                  v-model="form.priceType" 
                                                  :labell="this.$t('PROFILE_emailType')" 
                                                  fetchUrl="/InvoiceType/list"
                                                  :selectOptionLabel="this.$t('PROFILE_selectEmailType')"/> 
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
                        <b-form-input v-model="tax" type="text"></b-form-input> 
                    </b-col>
                </b-row>

          </b-container>     
          <b-button variant="primary">{{$t('CPRODUCT_PRICE_saveBtn')}}</b-button>
                   
    </div>
</template>

<script>

import f2fPriceType from '../../../base/f2fPriceType' ;
import VuePersianDateTimePicker from 'vue-persian-datetime-picker'

export default {
    name:'cPromoRule',
    props:{
          } ,
    data(){
      return {
          form:{
              priceType:"" ,
              fromDate:"" ,
              toDate:"",
              price:"",
              currencyType:"",
              tax:""
          }
      }
    } ,
    methods:{

    },components:{
        f2fPriceType,
        datePicker:VuePersianDateTimePicker
    }
}
</script>

<style scoped>

</style>