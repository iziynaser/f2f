<template>
    <div>
            <router-link :to="{
                name:'createProduct',
                params:{id:0,title:''}
            }">
                create product      
            </router-link>

          <b-card>
                  <b-table striped hover :items="searchResult" small
                           :fields="searchFields"  head-variant="dark" responsive caption-top  
                           :busy="isBusy"
                           >

                           <template v-slot:table-caption>search results</template>   
                           <template v-slot:table-busy>
                                 <div class="text-center text-danger my-2">
                                    <b-spinner class="align-middle"></b-spinner>
                                    <strong>loading</strong>
                                 </div>  
                           </template>

                           <template v-slot:cell(name)="data">                               
                                    <router-link :to="{
                                                        name:'product',
                                                        params:{id:data.item.id,title:data.item.name}
                                                      }">
                                          show detail of product      
                                    </router-link>
                           </template>

                           <template v-slot:cell(title)="data">                               
                                {{data.name}} 
                           </template>

                           <template v-slot:cell(comment)="data">
                               {{data.comment}}
                           </template>

                           <template v-slot:cell(index)="data">
                                   {{data.index+1}}
                           </template>                           

                  </b-table>                
          </b-card>
    </div>
</template>

<script>


import axios from 'axios'

export default {
    name:'findPayment',
    props:{
          } ,
    data(){
      return {
        id:'',
        name:'',
        title:'',
        productType:'',
        description:'',
        productDimension:'',
        isBusy:false,
        errors:{},
        searchResult:[],    
        searchFields:[
              {key:'id',label: this.$t('id')},
              {key:'name',label: this.$t('name')},
              {key:'title',label: this.$t('title')},
              {key:'comment',label: this.$t('description')},
        ],            
      }
    } ,
    methods:{
        onSearchResult() {                
                var self = this;
                this.errors= {};
                this.isBusy = true;
                axios({
                    method:'GET',
                    url:'/f2f/products',
                })
                .then(function(res){
                      self.searchResult = res.data; 
                      self.isBusy=false;
                })
                .catch(function(error){
                    console.log(error)    ;
                });
          }
    }      ,
    mounted(){
        this.onSearchResult();
    }
}
</script>

<style scoped>

</style>