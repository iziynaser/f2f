<template>
    <div class="rounded">
        <div></div>
        <div></div>
        <b-carousel :interval="0" id="homeCarousel" style="text-shadow: 0px 0px 2px #000" fade
                    background="#ababab"   img-height="1024" img-width="480" ref="productImage">

          <b-carousel-slide v-for="idx in productImages" :key="idx" :img-src="idx">              
          </b-carousel-slide>

        </b-carousel>

        <div>
            <b-container fluid class="mb-2 p-4">
                <b-row>                    
                    <b-col v-for="idx in thumbnailImages" :key="idx">
                        <b-img rounded thumbnail fluid :src="idx" v-on:click="thumbnailImageClicked"></b-img>
                    </b-col>
                </b-row>
            </b-container>            
        </div>
    </div>    
</template>

<script>
  
  export default {
    name:'sImages',
    props:{
        thumbnailImages:Array,
        productImages:Array
    },
    data(){
        return{
        }
    },
    methods:{
        loadThumnailImages(){

        },
        loadProductImages(){

        },
        thumbnailImageClicked(){
            this.$refs.productImage.next()
        }
    },computed:{

    }    
  }
</script>