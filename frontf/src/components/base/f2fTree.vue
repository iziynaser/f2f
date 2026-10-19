<template>
<div>
  <div>
    <div>
      <b-container fluid>

       <b-row>
          <b-col>
        <b-row class="my-1">
          <b-col sm="3">
            <label for="fname">{{$t('C_PRODUCT_FEATURE_NAME')}}</label>
          </b-col>
          <b-col sm="9">
            <b-form-input v-model="fname" ref="fname" id="fname" type="text"></b-form-input>
          </b-col>
        </b-row>
        <b-row class="my-1">
          <b-col sm="3">
            <label for="fname">{{$t('C_PRODUCT_FEATURE_VALUE')}}</label>
          </b-col>
          <b-col sm="9">
            <b-form-input v-model="fvalue" ref="fvalue" id="fvalue" type="text"></b-form-input>
          </b-col>
        </b-row>  
                <b-row>
          <b-col>
            <b-button v-on:click="changeItem()">{{$t('C_PRODUCT_FEATURE_SAVE')}}</b-button>
          </b-col>
        </b-row>  
          </b-col>
          <b-col>
    <div>
            <ul id="demo">
                <treeItem
                    class="item"
                    :item="treeData"
                    @make-folder="makeFolder"
                    @add-item="addItem"
                    @select-item="selectItem"
                ></treeItem>
                
            </ul>
    </div>
          </b-col>
       </b-row>   
   

      </b-container>
      
    </div>  

  </div>
</div>    
</template>

<script>

import Vue from 'vue'
import treeItem from './treeItem'
import axiosInstance from '@/api/axiosInstance';

export default {
    name:'f2fTree',
    props:{
              id:Number
          } ,
    data(){
      return {
        fname: "",
        fvalue:"",
        item:Object,
        treeData : {
            // name: this.$t('C_PRODUCT_MAIN_FEATURES'),
            // value:"a9" ,
            // children: [
            //     { name: this.$t('C_PRODUCT_FEATURE_') , value:"a8" },
            //     { name: this.$t('C_PRODUCT_FEATURE_') , value:"a7" },
            //     {
            //       name: this.$t('C_PRODUCT_MAIN_OFEATURES'),
            //       value:"a10" ,
            //       children: [ { name: this.$t('C_PRODUCT_MAIN_OFEATURES_one') , value:"a7" },]
            //     }
            // ]
        },
       // treeData: treeData
      }
    } ,
    methods: {
          makeFolder: function(item) {
            Vue.set(item, "children", []);
            //Vue.set(item, "children", [{name:this.fname}]);
            this.addItem(item);
          },
          addItem: function(item) {
            item.children.push({
              name: this.$t('C_PRODUCT_FEATURE_')
            });
          },
          selectItem:function(item){
            this.fname = item.name ;
            this.fvalue = item.value ;
            this.item = item;
            console.log('child:'+this.treeData);
            this.$emit('selectedRootEvent',this.treeData);
          },
          changeItem:function(){
              this.item.name = this.fname;
              this.item.value = this.fvalue;
          },
          load(){
            var self = this;
            
            if(self.id==0)
                return
            
            const url = `/productFeatureGroup/load`;
            axiosInstance.get(url,{
                params:{
                    productId: self.id
                }
            })
                .then(function(res){
                    //self.form.treeData = res.data;
                    if(res!=undefined){
                      self.treeData = res.data.treeData;
                      console.log("treeData:"+self.treeData); 
                    }
                })
                .catch(function(error){
                    console.log(error)    ;
                });
        }
    },
    created(){
        this.load();
    },
    components:{
      treeItem
    }     
}
</script>

<style scoped>
    body {
        font-family: Menlo, Consolas, monospace;
        color: #444;
    }
    .item {
        cursor: pointer;
    }
    .bold {
        font-weight: bold;
    }
    ul {
        padding-left: 1em;
        line-height: 1.5em;
        list-style-type: dot;
    }
</style>