<template>
    <div class="p-1">

        <b-card>
            <div>
                {{product.name}}
            </div>

            <router-link :to="{
                        name:'product',
                        params:{id:product.id,title:product.name}
                    }">
                <b-img :src="cardImage"/>      
            </router-link>

            <b-card-header>
                {{product.title}}
            </b-card-header>

            <b-card-body
                        :title="product.name"
                        :sub-title="product.subtitle"> 
                        <p class="card-text mt-3 text-justify">
                               {{$t('CART_minPrice')}}
                               <b>{{product.price}}</b>
                        </p >
                        <p class="card-text">
                               {{$t('CART_comments')}}
                        </p>
                        <p class="card-text">
                               {{$t('CART_availableOnWarehouse')}}
                               {{product.quantity}}
                        </p>
                        <p>
                            {{$t('CART_compare')}}
                        </p>
                        <p v-if="product.quantity>0" class="h3">
                            <b-icon size="lg" icon="plus" @click="addToCart(product.id)" :disabled="!inCartQuantity"
                                    variant="success" class="border rounded">
                                    {{inCartQuantity ? "Add to cart" : "Out of stock"}}
                            </b-icon>
                        </p>
                        <p v-else>
                            finished
                        </p>
            </b-card-body>
            <b-card-footer>
                <p>
                    promotions
                </p>
                <p>
                    sale position
                </p>
            </b-card-footer>
        </b-card>

    </div>

</template>

<script>

export default {
    name:'cards',
    props:["cardImage","product"] ,
    data(){
        return{
            clor : ["red","blue"]
        }
    },
    methods:{
        showProduct:function(){
            console.log('show product');
        },
        addToCart(id){
            this.$store.dispatch("addToCart",id);
        }
    },
    computed:{
      inCartQuantity(){
        return this.product.quantity
      }
    }
}
</script>

<style scoped>

</style>
