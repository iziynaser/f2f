<template>
    <div>
          <b-form-group>
              <b-row class="my-1">
                  <b-col >
                      {{$t('Adress_OSTAN')}}
                  </b-col>
                  <b-col >
                    <b-form-select v-model="form.ostanId" v-on:change="loadCity">
                        <template v-slot:first> 
                            <b-form-select-option :value="null" disabled>select an ostan</b-form-select-option>
                        </template>
                        <b-form-select-option :value="ostan.id" v-for="ostan in ostanList" :key="ostan.id">
                            {{ostan.name}}
                        </b-form-select-option>
                    </b-form-select>                    
                  </b-col>
              </b-row>
              <b-row class="my-1">
                  <b-col>{{$t('Adress_SHAHR')}}</b-col>
                  <b-col>
                      <b-form-select v-model="form.shahrId" >
                           <template v-slot:first>
                               <b-form-select-option :value="null" disabled>select a shahr</b-form-select-option>
                           </template> 
                               <b-form-select-option :value="shahr.id" v-for="shahr in shahrList" :key="shahr.id">
                                   {{shahr.name}}
                               </b-form-select-option>
                      </b-form-select>
                  </b-col>
              </b-row>
              <b-row class="my-1">
                  <b-col>{{$t('Adress_POSTAL_CODE')}}</b-col>
                  <b-col>
                      <b-input v-model="form.postalCode" type="text"/>
                  </b-col>
              </b-row>
              <b-row class="my-1">
                  <b-col>{{$t('Adress_POSTAL_ADDRESS')}}</b-col>
                  <b-col>
                      <b-input v-model="form.postalAdress" type="text"/>
                  </b-col>
              </b-row>
              <b-row class="my-1">
                  <b-col>{{$t('Adress_PELAK')}}</b-col>
                  <b-col>
                      <b-input v-model="form.pelak" type="text"/>
                  </b-col>
              </b-row>
              <b-row class="my-1">
                  <b-col>{{$t('Adress_VAHED')}}</b-col>
                  <b-col>
                      <b-input v-model="form.vahed" type="text"/>
                  </b-col>
              </b-row>
              <b-row class="my-1">
                  <b-col>{{$t('Adress_mobile1')}}</b-col>
                  <b-col>
                      <b-input v-model="form.mobileNo1" type="text"/>
                  </b-col>
              </b-row>
              <b-row class="my-1">
                  <b-col>{{$t('Adress_mobile2')}}</b-col>
                  <b-col>
                      <b-input v-model="form.mobileNo2" type="text"/>
                  </b-col>
              </b-row>
              <b-row class="my-1">
                  <b-col>{{$t('Adress_name')}}</b-col>
                  <b-col>
                      <b-input v-model="form.deliverName"  type="text"/>
                  </b-col>
              </b-row>
              <b-row class="my-1">
                  <b-col>{{$t('Adress_family')}}</b-col>
                  <b-col>
                      <b-input v-model="form.deliverFamily" type="text"/>
                  </b-col>
              </b-row>
              <b-row class="my-1">
                  <b-col>{{$t('Adress_is_getter_myself')}}</b-col>
                  <b-col>
                      <b-input v-model="form.whoisGetter" type="text"/>
                  </b-col>
              </b-row>
              <b-row class="my-1">
                  <b-col>{{$t('Adress_nationalCode')}}</b-col>
                  <b-col>
                      <b-input v-model="form.nationalCode" type="text"/>
                  </b-col>
              </b-row>
          </b-form-group>
          <b-button variant="info" v-on:click="saveForm">save</b-button>                  
    </div>
</template>

<script>

import * as axios from 'axios'

export default {
    name:'AdressCreate',
    props:{
          } ,
    data(){
      return {
        form:{
                userName:'',
                ostanId:'',
                shahrId:'',
                postalAdress:'',
                pelak:'',
                unit:'',
                postalCode:'',
                deliverName:'',
                deliverFamily:'',
                nationalCode:'',
                mobileNo1:'',
                mobileNo2:'',
                whoisGetter:'',
                geoCode:'',
        } ,
        ostanList:[],
        shahrList:[]
      }
    } ,
    methods:{
            loadOstan(){
                var self = this;
                const url = `/ostan/list`;
                axios.get(url,{
                    params:{
                    }
                })
                .then(function(res){
                    self.ostanList = res.data; 
                })
                .catch(function(error){
                    console.log(error)    ;
                });
            },
            loadCity(){
                var self = this;
                const url = `/shahr/list`;
                axios.get(url,{
                    params:{
                        id:self.form.ostanId,
                    }
                })
                .then(function(res){
                    self.shahrList = res.data;
                })
                .catch(function(error){
                    console.log(error)    ;
                });
            },
            saveForm(){
               var self = this;
               const url="/Delivery/save" ;
               axios.post(url,self.form)
                    .then((res) => {
                        console.log(res);
                    })
                    .catch((err) => {
                        console.log(err);
                    })         
            }
    },created(){        
        this.loadOstan();        
    }      
}
</script>

<style scoped>

</style>