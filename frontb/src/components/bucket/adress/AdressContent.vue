<template>
    <div>
        {{$t('AdressContent_selectDeliveryAdress')}}
        <hr/>
        <div>
            <div v-for="address in deliveryList" :ref="address.id" :key="address.id">
                <b-card>
                    <b-card-title>
                        <i>
                        {{$t('AdressContent_chooseThisAdress')}}
                        </i>
                        <hr/>
                    </b-card-title>
                    <b-card-text>
                    <b-icon-house-door></b-icon-house-door>
                           <b>
                            {{address.ostan.name}}
                            {{address.shahr.name}}
                            {{address.postalAdress}}
                           {{$t('Adress_VAHED')}}: {{address.unit}}
                           {{$t('Adress_PELAK')}}: {{address.pelak}}
                           </b>
                    </b-card-text>
                    <b-card-body>
                    <b-row>
                        <b-icon-phone></b-icon-phone>{{address.mobileNo1}}
                    </b-row>
                    <b-row>
                        <b-icon-people-circle/>{{address.deliverName}} {{address.deliverFamily}}
                    </b-row>                    
                    <b-row>
                        <b-icon-envelope></b-icon-envelope>{{address.postalCode}}
                    </b-row>
                    <b-row>
                            <b-link >{{$t('AdressContent_edit')}}</b-link>
                            <span class="border m-1"/>
                            <b-link @click="deleteDelivery(address)">{{$t('AdressContent_delete')}}</b-link>
                    </b-row>

                    </b-card-body>                    
                </b-card>
            </div>
        </div>          
    </div>
</template>

<script>

import * as axios from 'axios';

export default {
    name:'AdressContent',
    props:{
          } ,
    data(){
      return {
          form:{
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
          deliveryList:[]
      }
    } ,
    methods:{
        deleteDelivery(delivery){
            
            //visable div ref
            
            //delivery.id

            //var self = this;
            console.log("delete:"+delivery.id);
            const url = `/Delivery/delete`;
            axios.delete(url,{data:delivery})
                .then(function(res){
                    console.log(res); 
                })
                .catch(function(error){
                    console.log(error)    ;
                });
        },
        loadAdressDeliveryList(){
            var self = this;
            const url = `/Delivery/list`;
            axios.get(url,{
                params:{}
            })
                .then(function(res){
                    self.deliveryList = res.data;
                    console.log(self.deliveryList); 
                })
                .catch(function(error){
                    console.log(error)    ;
                });
        }
    } ,
    created() {
            this.loadAdressDeliveryList();
    },       
}
</script>

<style scoped>

</style>