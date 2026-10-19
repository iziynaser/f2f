<template>
    <div>
                         <!-- <span v-if="id">id : {{id}}</span>
                 and <span v-if="title">title : {{title}}</span> -->
        productFeatures                    
        <b-button v-on:click="save">{{$t('C_PRODUCT_FEATURE_SAVE_FINAL')}}</b-button>
        <f2fTree :id="Number(id)" v-model="form.treeData" v-on:selectedRootEvent="handleTreeData" /> 
    </div>
</template>

<script>

import f2fTree from '../../../base/f2fTree'
import {mapGetters} from 'vuex'
import * as axios from 'axios'

export default {
    name:'cProductFeature',
    props:{
            id:Number,
            title:String
          } ,
    data(){
      return {
          form:{
              productId:this.id,
              treeData : {}
          }
      } 
    },
        components:{
        f2fTree
    },
    methods:{
        ...mapGetters(['getProductId']),
        saveFeature(){
            let self = this;
                                            
            let productId = self.getProductId();
            console.log('product id is'+ productId);
        },
        handleTreeData(e){
            this.form.treeData= e;
        },
        save(){
            var self = this;

            const url = `/productFeatureGroup/save`;
            axios.post(url,self.form,
            {
                headers:{
                },
                params:{
                }
            }
            )
                        .then((res)=>{
                            if(res.data.id)
                                self.setProductId(res.data.id);
                        })
                        .catch((err) => {
                            console.log(err);
                        });
        },
        // load(){
        //     var self = this;
            
        //     if(self.id==0)
        //         return
            
        //     const url = `/productFeatureGroup/load`;
        //     axios.get(url,{
        //         params:{
        //             productId: self.id
        //         }
        //     })
        //         .then(function(res){
        //             self.form.treeData = res.data;
        //             console.log("treeData:"+self.form.treeData); 
        //         })
        //         .catch(function(error){
        //             console.log(error)    ;
        //         });
        // }
    },created(){
       // this.load();
    }    
}
</script>

<style scoped>

</style>