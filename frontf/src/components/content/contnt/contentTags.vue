<template>
    <div>
        <div>content:{{content.id}},{{content.name}}</div>
        <div>
            <label>tag name :</label>
            <b-input type="text"/>
            <b-button variant="success" class="m-1">save tag</b-button>
        </div>
        <hr/>

        <b-form-group
            label="Filter"
            label-cols-sm="3"
            label-align-sm="right"
            label-size="sm"
            label-for="filterInput"
            class="mb-0"
        >
            <!-- <b-input-group size="sm">
                <b-form-input
                    v-model="filter"
                    type="search"
                    id="filterInput"
                    placeholder="type to search"></b-form-input>
                    <b-input-group-append>
                        <b-button :disabled="!filter" @click="filter = ''">
                            clear
                        </b-button>
                    </b-input-group-append>
                    </b-input-group> -->
        </b-form-group>
          
        <f2fTable :searchFields="fields" :searchResult="items" caption="list of tags" /> 

    </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';
import f2fTable from '../../base/f2fTable'

export default {
    name:'contentTags',
    props:{
        content:{type:Object},
          } ,
    data(){
      return {
          isBusy:false,
          errors:{},
          items:[],
          fields:[
              {key:'id',label:'شناسه'},
              {key:'tagName',label:'نام تگ'},
              {key:'count',label:'تعداد'},
              {key:'edit',label:'ویرایش'},
              {key:'delete',label:'حذف'},
          ] ,                
      }
    } ,
    methods:{
        listOfOtherSellers(){
                var self = this;
                this.errors= {};
                this.isBusy = true;
                axiosInstance({
                    method:'GET',
                    url:'/ProductPrice/list',
                })
                .then(function(res){
                      self.items = res.data; 
                })
                .catch(function(error){
                    console.log(error)    ;
                });
        },
    } ,
    components:{
        f2fTable
    },
    mounted(){
        //this.listOfOtherSellers();
    }        
}
</script>

<style scoped>

</style>