<template>
    <div>
          <!-- <aliveProduct/> -->
          <b-button to="/delivery">
            select delivery
          </b-button>

          <hr/>


          <div>
            <h4>list of basket</h4>
            <!-- <b-card-group deck> -->
                <div v-for="product in listOfCarts" :key="product.id" class="mt-4">                  
                  <b-card :img-src="urlI('/images/product/8/medium/pic1.jpg')" img-width="70" img-height="70" img-left >
                      <h4>{{product.name}},{{product.quantity}}</h4>
                      <b-card-text>
                        description of product
                      </b-card-text>
                      <b-row>
                        <b-col>
                            <b-icon icon="plus" @click="addToCart(product.id)" variant="success" class="border rounded"></b-icon>
                        </b-col>
                        <b-col>
                            <b-icon icon="trash" @click="removeFromCart(product.id)" variant="danger" class="border rounded"></b-icon>
                        </b-col>
                      </b-row>
                  </b-card>
                </div>
            <!-- </b-card-group> -->
          </div>
    </div>
</template>

<script>

// import aliveProduct from './aliveProduct'
import {mapGetters} from 'vuex'
import {baseUrl} from '../../api/util'

export default {
    name:'bucketView',
    props:{
          } ,
    data(){
      return {
        
      }
    } ,
    methods:{
      urlI(u){
        return baseUrl(u)
      }
    },
    components:{
      // aliveProduct,
    },
    computed:{
          ...mapGetters(["listOfCarts"])

    }

}
</script>

<style scoped>

</style>