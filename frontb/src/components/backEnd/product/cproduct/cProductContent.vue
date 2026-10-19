<template>
    <div>
                         <!-- <span v-if="id">id : {{id}}</span>
                 and <span v-if="title">title : {{title}}</span> -->

        <b-card no-body>
            <b-tabs card vertical pills>
               <b-tab :title="$t('CPRODUCT_CONTENT_small_images')">
                   <b-card-text>
                       <fileUpload type="small" :productId="id"/>                       
                   </b-card-text>    
               </b-tab>
                <b-tab :title="$t('CPRODUCT_CONTENT_medium_images')">
                    <b-card-text>
                            <fileUpload type="medium" :productId="Number(id)" /> 
                    </b-card-text>
                </b-tab>
               <b-tab :title="$t('CPRODUCT_CONTENT_large_images')">
                   <b-card-text>
                            <fileUpload type="large" :productId="Number(id)" /> 
                   </b-card-text>             
               </b-tab>
               <b-tab :title="$t('CPRODUCT_CONTENT_detail_images')">
                   <b-card-text>
                            <fileUpload type="detail" :productId="Number(id)" /> 
                   </b-card-text>            
               </b-tab>
               <b-tab :title="$t('CPRODUCT_CONTENT_original_images')">
                   <b-card-text>
                           <fileUpload type="original" :productId="Number(id)"/> 
                   </b-card-text> 
               </b-tab>
               
            </b-tabs>
        </b-card>
    </div>
</template>

<script>

import fileUpload from '../fileUpload'
import {mapGetters} from 'vuex'

export default {
    name:'cProductContent',
    props:{
            id:Number,
            title:String
          } ,
    data(){
      return {
        //productId:"0"
      }
    } ,
    methods:{
        ...mapGetters(['getProductId']),
    },
    components:{
        fileUpload
    }  ,
    mounted(){
        this.productId=this.getProductId;
        //if(this.productId=="")
        //    this.productId=this.id;

        console.log("pId:"+this.productId);
    }    
}
</script>

<style scoped>

</style>