<template>
    <div class="container">
        <div class="card-deck">            
            <div class="card" v-for="smp in similarProducts" :key="smp.id">
                    <div class="card-body">
                        <h5 class="card-title"> {{ smp.name }} </h5>
                        <p class="card-text">{{smp.imgUrl}}</p>
                        <p class="card-text"><small class="text-muted">{{smp.shortDesc}}</small></p>
                        <p class="card-text"><small class="text-muted">{{smp.amazingDesc}}</small></p>
                        <p class="card-text"><small class="text-muted">{{smp.price}}</small></p>
                    </div>
                </div>
        </div>
    </div>
</template>

<script>


import axios from 'axios'

export default {
    name:'similarProduct',
    props:{
          } ,
    data(){
      return {
        similarProducts: []
      }
    } ,
    mounted(){
        this.listofsimilarProducts();
    },
    methods:{
        listofsimilarProducts(){
            var self = this;
            axios.get('/relatedProducts/list',{
                params : {
                    productId : 1
                }
            })
            .then(function(res){
                //console.log(res);
                self.similarProducts = res.data ;
            })
            .catch(function(error){
                console.log(error);
            })
        }
    } ,   
}
</script>

<style scoped>

</style>