<template>
    <div>
        menus
        <b-row>
            <b-col>
                <categoryBrowser  :cType="Number(9)" @categoryChanged="categoryChanged"/>
            </b-col>
            <b-col>
                <b-row>
                                    the content saved in menu {{category.cName}}
                <br/>
                <b-button v-on:click="save">{{$t('C_PRODUCT_FEATURE_SAVE_FINAL')}}</b-button>

                </b-row>
                <b-row>
                    <createQuickCategory :categoryType="Number(9)" :categoryCode="category.cCode" />
                </b-row>
            </b-col>            
        </b-row>        
    </div>
</template>

<script>

import {mapGetters} from 'vuex'
import axiosInstance from '@/api/axiosInstance';
import categoryBrowser from '../../base/categoryBrowser'
import createQuickCategory from './createQuickCategory'

export default {
    name:'contentMenus',
    props:{
            id:Number,
            title:String
          } ,
    data(){
      return {
          form:{
              productId:this.id,
              treeData : {}
          },
          category:{
              cCode : "" ,
              cName: ""
          }
      } 
    },
        components:{
        categoryBrowser ,
        createQuickCategory
    },
    methods:{
        ...mapGetters(['getProductId']),
        categoryChanged(form){
            this.category.cCode = form.cCode ;
            this.category.cName = form.cName ;
        },
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
            axiosInstance.post(url,self.form,
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
    },created(){}    
}
</script>

<style scoped>

</style>