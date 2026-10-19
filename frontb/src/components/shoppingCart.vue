<template>
    <div>

        <b-dropdown no-caret variant="link" toggle-class="text-decoration-none">
            <template slot="button-content">
                <b-button variant="outline-primary">
                    <b-icon-bucket-fill></b-icon-bucket-fill>
                </b-button>    
            </template>

                <div v-if="!cartSize">
                    <b-dropdown-item>
                        {{$t('SHOPPING_CART_bucketIsEmpty')}}
                    </b-dropdown-item>    
                </div>
                <div v-else>
                    <b-dropdown-item>
                        <div class="container">
                        <div class="row">
                            <div class="col">
                                <span>{{cartSize}} {{$t('SHOPPING_CART_product')}}</span>
                            </div>
                            <div class="col">
                                <span>{{$t('SHOPPING_CART_seeListOfProducts')}}</span>
                            </div>
                        </div>                                            
                        </div>
                    </b-dropdown-item>

                    <b-dropdown-divider/>

                <div v-for="product in listOfCarts" :key="product.id">
                <b-dropdown-item>      

                    <b-row cols="3">
                        
                        <b-col>
                            <b-icon icon="plus" @click="addToCart(product.id)" variant="success" class="border rounded">

                            </b-icon>
                        </b-col>

                        <b-col>
                                {{product.name}}
                                {{product.quantity}}
                        </b-col>

                        <b-col>
                            <b-icon icon="trash" @click="removeFromCart(product.id)" variant="danger" class="border rounded"></b-icon>
                        </b-col>
                    </b-row>

                </b-dropdown-item>    
                </div>

            <b-dropdown-divider/>

            <b-dropdown-item>
                <div class="container">
                    <div class="row">{{$t('SHOPPING_CART_payableSum')}} {{cartTotalAmount}}</div>
                    <div class="row">
                        <b-button variant="danger" size="sm" to="/bucketView">
                                {{$t('SHOPPING_CART_registerOrder')}}
                        </b-button>
                    </div>
                </div>
            </b-dropdown-item>

                </div>    

        </b-dropdown>

    </div>
</template>

<script>

import {mapGetters} from 'vuex'

export default {
    name:'shoppingCart',
    props:{
          } ,
    data(){
      return {
      }
    } ,
    computed:{
        ...mapGetters(["cartSize","cartTotalAmount","listOfCarts"])
    },
    methods:{
        addToCart(id){
            this.$store.dispatch("addToCart",id);            
        },
        removeFromCart(id){
            this.$store.dispatch("removeFromCart",id);
        },
        deleteFromCart(id){
            this.$store.dispatch("deleteFromCart",id);
        }
    }
}
</script>

<style scoped>

</style>