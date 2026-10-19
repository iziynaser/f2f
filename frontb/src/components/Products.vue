<template>
    <div>
        <div class="container mt-5py-2">
            <h1>products {{this.productSize}}</h1>
            <div class="row">
                <div v-for="product in listOfProducts" :key="product.id" >
                    <cards :product="product"   :cardImage="urlI('/images/flw/f1.jpg')">
                    </cards>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

import { mapActions,mapGetters } from 'vuex';
import cards from './cards'

import {baseUrl} from '../api/util'

export default {
    name:'Products',
    props:{
          } ,
    data(){
      return {
        
      }
    } ,
    methods:{
              urlI(u){
        return baseUrl(u)
      },
        ...mapActions(['fetchProducts'])
    },
    components:{
         cards
    },
    computed:{
        ...mapGetters(['productSize','listOfProducts']),
    },
    created(){
        this.fetchProducts();
    }
}
</script>

<style scoped>

</style>