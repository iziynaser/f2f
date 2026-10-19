<template>
    <div>
        <div>
            <categoryBrowser @categoryChanged="loadBrands"/>
            <b-row class="my-1">
                <b-col sm="9">
                    <b-card>
                        <b>
                        {{$t('BRAND_MAIN_listOfBrands')}}
                        </b>
                        {{cName}}
                        <hr/>
                        <b-list-group horizontal >
                            <b-list-group-item v-for="(brand,idx) in brands" :key="brand.id" :variant="variantColors(idx)">
                                {{brand.name}}
                            </b-list-group-item>
                        </b-list-group>
                    </b-card>                    
                </b-col>
            </b-row>
        </div>

        <div>
          <b-row>
              <b-col>
                  {{$t('BRAND_MAIN_NAME')}}
              </b-col>
              <b-col>
                  <b-input v-model="form.name"/>
              </b-col>
              <b-col>
                  {{$t('BRAND_MAIN_VALUE')}}
              </b-col>
              <b-col>
                  <b-input v-model="form.value"/>
              </b-col>
              <b-col>
                  <b-button variant="success" @click="saveBrand">+</b-button>
              </b-col>
          </b-row>
        </div>
    </div>
</template>

<script>

import * as axios from 'axios'
import categoryBrowser from '../../../base/categoryBrowser'

export default {
    name:'brandMain',
    props:{
          } ,
    data(){
      return {
        value:[],
        cols1:[],
        breadcrumbItems:[],
        brands:[],
        cCode:"",
        cName:"",
        form:{
            name:"",
            value:"",
            categoryId:""
        }
      }
    } ,
    components:{
        categoryBrowser
    },
    methods:{
        variantColors(idx){
            return idx % 2==0 ? "light" : "info" ;
        },
        saveBrand(){
               var self = this;
               const url="/brand/save" ;
               axios.post(url,self.form)
                    .then((res) => {
                        console.log(res);
                        //self.brands.push({name:self.form.cName,value:self.form.cValue})
                    })
                    .catch((err) => {
                        console.log(err);
                    }) 
        },
        loadBrands(form){
            var self = this;
            // self.form.categoryId=cId;
            self.form.categoryId=form.cCode;
            const url = `/brand/byCategoryId`;
            axios.get(url,{
                params:{
                    // categoryId: cId
                    categoryId: form.cCode
                }
            })
                .then(function(res){
                    self.brands = res.data;
                })
                .catch(function(error){
                    console.log(error)    ;
                });
        }
    }
    ,created(){}      
}
</script>

<style scoped>

</style>