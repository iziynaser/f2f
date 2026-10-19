<template>
    <div>
              <div :v-if="address">
                <b-card>
                  <b-card-header>
                      <b-row>
                        <b-col sm="3">
                          <i>
                              {{$t('AdressContent_chooseThisAdress')}}
                          </i>
                        </b-col>
                        <b-col sm="9">
                        select your address
                        <b-link to="/Adress">
                            select another address
                        </b-link>
                        <span class="border m-1" />
                        select an store from avalable products.
                        <b-link to="/Adress">select company stores</b-link>
                        </b-col>
                      </b-row>
                  </b-card-header>
                    <b-card-body>                    
                    <b-row>
                    <b-icon-house-door></b-icon-house-door>                    
                           <b>
                            {{address.ostan.name}}
                            {{address.shahr.name}}
                            {{address.postalAdress}}
                           {{$t('Adress_VAHED')}}: {{address.unit}}
                           {{$t('Adress_PELAK')}}: {{address.pelak}}
                           </b>
                    </b-row>
                    <b-row>
                        <b-icon-phone></b-icon-phone>{{address.mobileNo1}}
                    </b-row>
                    <b-row>
                        <b-icon-people-circle/>{{address.deliverName}} {{address.deliverFamily}}
                    </b-row>                    
                    <b-row>
                        <b-icon-envelope></b-icon-envelope>{{address.postalCode}}
                    </b-row>
                    </b-card-body>
                </b-card>
            </div>

          <b-button-group vertical>
              <b-button>a1</b-button>
              <b-button>a2</b-button>
              <b-button>a3</b-button>
          </b-button-group>
          <b-form-group label="select a day for delivery">
            <b-form-radio-group 
                id="weeks" 
                name="weeks" 
                v-model="selected" 
                :options="options" 
                buttons 
                button-variant="outline-dark" 
                size="sm">
            </b-form-radio-group>
          </b-form-group>

              <b-form-group label="sdlfhslfhsfhskjhfsdkhfsdkh">
                <b-form-radio-group stacked>
                  <b-form-radio  size="lg">                    
                    <span class="border-top">8-10 am</span>
                  </b-form-radio>
                  <b-form-radio  size="lg">
                    <span class="border-top">8-10 am</span>
                   </b-form-radio>
                  <b-form-radio  size="lg">
                    <span class="border-top">8-10 am</span>
                  </b-form-radio>
                  <b-form-radio  size="lg">
                    <span class="border-top">8-10 am</span>
                  </b-form-radio>
                  <b-form-radio  size="lg">
                     <span class="border-top">8-10 am</span>
                  </b-form-radio>
                  <b-form-radio  size="lg">
                     <span class="border-top">8-10 am</span>
                  </b-form-radio>                
                </b-form-radio-group>
              </b-form-group>  



        other specific criteria for delivery of your product
        <b-textarea>
        </b-textarea>
        <b-button to="/registerOrder">
          register Order
        </b-button>
    </div>
</template>

<script>

import * as axios from 'axios'

export default {
    name:'delivery',
    props:{
          } ,
    data(){
      //return {
        const now = new Date()
        const today = new Date(now.getFullYear(),now.getMonth(),now.getDate());
        const minDate = new Date(today);

        const maxDate = new Date(today);
        maxDate.setMonth(minDate.getMonth()+1);

        return {
          address:{
              id:'',
              postalAdress:'',
              pelak:'',
              unit:'',
              postalCode:'',
              mobileNo1:'',
              deliverName:'',
              deliverFamily:'',
              ostan:{
                  id:'',
                  name:''
              },
              shahr:{
                  id:'',
                  name:''
              },

          },
          value:'',
          min : minDate,
          max : maxDate,
          textDelivery :'' ,
          selected:'shanbe',
          options:[
            {text:'shanbe',value:'shanbe',disabled:false},
            {text:'1shanbe',value:'1shanbe',disabled:false},
            {text:'2shanbe',value:'2shanbe',disabled:false},
            {text:'3shanbe',value:'3shanbe',disabled:false},
            {text:'4shanbe',value:'4shanbe',disabled:false},
            {text:'5shanbe',value:'5shanbe',disabled:false},
            {text:'6shanbe',value:'6shanbe',disabled:false},
          ]
        }
      //}
    } ,
    methods:{
      dateDisabled(ymd,date){
        const weekday = date.getDay();
        const day = date.getDate();
        console.log(day);
        return weekday === 0 || weekday === 6 || weekday === 13
      },
      loadDefaultDelivery(){
            var self = this;
            const url = `/Delivery/defaultDelivery`;
            axios.get(url,{
                params:{}
            })
                .then(function(res){
                    //console.log("default delivery:"+res); 
                    self.address=res.data;
                })
                .catch(function(error){
                    console.log(error)    ;
                });
      }
    } ,created(){  
        this.loadDefaultDelivery();
    }   
}
</script>

<style scoped>

</style>