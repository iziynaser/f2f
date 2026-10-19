<template>
    <div>
           <f2fTable :searchResult="items"  :searchFields="fields" caption="mm"  />                  
    </div>
</template>

<script>

import * as axios from 'axios';
import f2fTable from '../../base/f2fTable'

export default {
    name:'userRoles',
    props:{
        items:[],    
    },
    data(){
      return {
        isBusy:false,
        errors:{},  
        fields:[
            {key:"id",label:'title'},
            {key:"roleName",label:'role name'}
        ],            
      } 
    },
    methods:{
        listOfCategoriesRelatedToProduct(){
                var self = this;
                this.errors= {};
                this.isBusy = true;
                axios({
                    method:'GET',
                    url:'/management/user/list',
                })
                .then(function(res){
                      console.log(res.data);  
                      self.items = res.data.data; 
                })
                .catch(function(error){
                    console.log(error)    ;
                });
        },
    },
    components:{
        f2fTable
    } ,
    mounted(){
            this.listOfCategoriesRelatedToProduct();
    }      
}
</script>

<style scoped>

</style>