<template>
    <div id="searchBar">
            <b-form-input size="sm" class="mr-sm-2" type="submit" placeholder="Search"></b-form-input>
            <searchBar @termChange="onTermChange" category="root"/>
    </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';

    export default {
        name:'searchBar' ,
        props:{
            category:{type:String} ,
            witchPart:{type:String}               
        },
        methods:{
            onTermChange:function(searchTerm){
                console.log(searchTerm);
                axios.get('/hello',
                {
                  params:{
                         }
                })
                .then(function (response) {
                    console.log(response.data);                
                }).catch(function (error) {
                    console.log(error.data);                          
            }) ;        
        },      
      doSearch(){
        
      }
        }
    }
</script>

<style scoped>

</style>
