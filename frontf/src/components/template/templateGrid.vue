<template>
    <div>
           <f2fTable :searchResult="items"  :searchFields="fields"  />                  
    </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';
import f2fTable from '../../base/f2fTable'

export default {
    name:'templateGrid',
    data(){
      return {
        isBusy:false,
        errors:{},
        items:[],    
        fields:[
            {key:"title",label:'title'},
        ],            

      } 
    },
    components:{
      f2fTable
    },
    mounted(){
        this.loadTable();
    },
    methods:{
          loadTable() {                
                var self = this;
                this.errors= {};
                this.isBusy = true;
                axios({
                    method:'GET',
                    url:'/person',
                })
                .then(function(res){
                      self.items = res.data; 
                      console.log(res.data);
                      self.isBusy=false;
                })
                .catch(function(error){
                    console.log(error)    ;
                });
          }
    },created(){
       this.load();
    }    
}
</script>

<style scoped>

</style>