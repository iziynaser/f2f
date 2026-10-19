<template>
<div>
  <div>
    <div>
      <b-container fluid>
        <b-row class="my-1">
          <b-col sm="3">
            <label for="fname">name:</label>
          </b-col>
          <b-col sm="9">
            <b-form-input v-model="fname" ref="fname" id="fname" type="text"></b-form-input>
          </b-col>
        </b-row>
        <b-row class="my-1">
          <b-col sm="3">
            <label for="fname">value:</label>
          </b-col>
          <b-col sm="9">
            <b-form-input v-model="fvalue" ref="fvalue" id="fvalue" type="text"></b-form-input>
          </b-col>
        </b-row>        
      </b-container>
      
    </div>  
    <div>
            <ul id="demo">
                <treeItem
                    class="item"
                    :item="treeData"
                    @make-folder="makeFolder"
                    @add-item="addItem"
                ></treeItem>
                
            </ul>
    </div>
  </div>
</div>    
</template>

<script>

import Vue from 'vue'
import treeItem from './treeItem'

export default {
    name:'f2Categories',
    props:{

          } ,
    data(){
      return {
        treeData : {
            name: "My Tree",
            fname:"",
            fvalue:"",
            children: [
                { name: "hello" },
                { name: "wat" },
                {
                  name: "child folder",
                  children: [
                    {
                        name: "child folder",
                        children: [{ name: "hello" }, { name: "wat" }]
                    },
                    { name: "hello" },
                    { name: "wat" },
                    {
                      name: "child folder",
                      children: [{ name: "hello" }, { name: "wat" }]
                    }
                  ]
                }
            ]
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
              name: "new stuff"
            });
          }
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