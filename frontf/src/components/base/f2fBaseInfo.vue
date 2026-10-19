<template>
<div>
    <div v-if="label">
        {{label}}
        <hr/>
    </div>
    <div>
        <b-container fluid>
            <b-row  class="my-1">
                <b-col sm="5">
                    <span class="border-bottom border-dark">{{$t('feature_Name')}}</span> 
                </b-col>
                <b-col sm="5">
                    <span class="border-bottom  border-dark">{{$t('Value')}}</span> 
                </b-col>
                <b-col sm="2">
                    <span class="border-bottom  border-dark">Value</span>
                </b-col>
            </b-row> 
            <b-row  class="my-1">
                <b-col sm="5">
                     <b-form-input v-model="fname"  size="sm"  type="text"></b-form-input>  
                </b-col>
                <b-col sm="5">
                    <b-form-input v-model="fvalue"  size="sm"  type="text"></b-form-input> 
                </b-col>
                <b-col sm="2">
                    <b-button  size="sm" variant="success" v-on:click="addToFeature()">add</b-button>
                </b-col>
            </b-row> 
        </b-container>
    </div>
    <div>
        <b-table responsive="sm" 
                 small 
                 striped
                 caption-top 
                 head-variant="dark"
                 selectable
                 select-mode="single" 
                 ref="featuresTable"
                 :fields="fields"
                 :items="features">
                
                <template v-slot:table-caption>list of features for this product</template>

                <template v-slot:cell(action)="row">
                    <b-button size="sm" variant="outline-primary" class="my-1">
                        <b-icon-arrow-up  size="sm" @click="upClick(row.index)">
                        </b-icon-arrow-up>
                    </b-button>
                    <b-button size="sm" variant="outline-primary" class="my-1">
                        <b-icon-arrow-down  variant="dark" size="sm" @click="downClick(row.index)" >
                        </b-icon-arrow-down>
                    </b-button>    
                    <b-button size="sm" variant="outline-primary" class="my-1">
                        <b-icon-trash  variant="info" size="sm" @click="deleteR(row.item)">
                        </b-icon-trash>
                    </b-button>
                </template>

                <template v-slot:cell(index)="data">
                    {{data.index + 1}}
                </template>

                <template v-slot:cell(fname)="data">
                        {{data.item.fanme}}
                </template>

                <template v-slot:cell(fvalue)="data">
                    {{data.item.fvalue}}
                </template>

        </b-table>
    </div>
    </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';

export default {
    name:'f2fBaseInfo',
    props:{
        url:{
            type:String,
            required:true
        },
        saveUrl:{
            type:String ,
            required:true
        },
        deleteUrl:{
            type:String,
            required:true
        },
        label:{
            type:String,
            required:false
        }
    } ,
    data(){
      return {
          fname : '',
          fvalue: '',
          fields:[
              {key:'index',label:'row'},
              {key:'id',label:'id'},
              {key:'name',label:'attribute name'},
              {key:'value',label:'attribute values'},
              {key:'action',label:'actions'},
          ],
          features:[],
          filteredSubArray:[]
      }
    } ,
    methods:{
        save(){
                var self = this;
                const url = self.saveUrl;                
                let len = this.features.length + 1 ;
                axios.post(url,{id:len,name:this.fname,value:this.fvalue})
                .then((res)=>{
                    //if(res.data.id)
                       // self.setProductId(res.data.id);
                       console.log(res);
                })
                .catch((err) => {
                    console.log(err);
                });        
        },
        sortListAgain(){
          let callbackRuns = 1;  
          this.features.forEach((element)=>{
              element.id = callbackRuns;
              callbackRuns++;
          })        
        },
        addToFeature(){
            let len = this.features.length + 1 ;
            this.features.push({id:len,fname:this.fname,fvalue:this.fvalue});
            this.save();
            this.fname="";
            this.fvalue="";
        },
        deleteR(item){
            this.features = this.features.filter(feature=> feature.id !== item.id)
        },
        downClick(index){
            if(this.features.length==1)
                return ;
            if(this.features.length-1==index)
                return ;
            let s = this.features[index]    ;
            this.features[index] = this.features[index+1] ;
            this.features[index+1] = s ;
            this.$refs.featuresTable.refresh();
        },
        upClick(index){
            if(index==0)
                return;
            let s = this.features[index]    ;
            this.features[index] = this.features[index-1] ;
            this.features[index-1] = s ;
            this.$refs.featuresTable.refresh();
        },
        onSearchResult() {                
            var self = this;
            axios({
                method:'GET',
                url:self.url,
                params:{},
                withCredentials:true
            })
              .then(function (response) {
                  self.features = response.data; 
            }).catch(function (error) {              
                  console.log(error);              
            }) ;
        }
    },
    mounted(){
         this.onSearchResult();
    }      
}
</script>

<style scoped>

</style>