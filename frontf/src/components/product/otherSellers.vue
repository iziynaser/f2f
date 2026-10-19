<template>
    <div class="container">
        <div class="card-deck">            
            <div class="card" v-for="ops in otherProductSellers" :key="ops.id">
                    <div class="card-body">
                        <h5 class="card-title"> {{ ops.name }} </h5>
                        <p class="card-text">{{ops.imgUrl}}</p>
                        <!-- <p class="card-text"><small class="text-muted">{{smp.shortDesc}}</small></p>
                        <p class="card-text"><small class="text-muted">{{smp.amazingDesc}}</small></p>
                        <p class="card-text"><small class="text-muted">{{smp.price}}</small></p> -->
                    </div>
                </div>
        </div>
    </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';


export default {
    name:'otherSellers',
    props:{
          } ,
    data(){
      return {
           otherProductSellers : [],    
      }
    } ,
    methods:{
        listOfOtherSellers(){
            var self = this;
            axios.get('/otherSellers/list',{
                params : {
                    productId : 1
                }
            })
            .then(function(res){
                //console.log(res);
                self.otherProductSellers = res.data ;
            })
            .catch(function(error){
                console.log(error);
            })
        },
    } ,
    components:{
        
    },
    mounted(){
        this.listOfOtherSellers();
    }        
}
</script>

<style scoped>

</style>