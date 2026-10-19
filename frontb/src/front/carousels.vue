<template>
    <div>
        <b-carousel :interval="4000" id="homeCarousel" style="text-shadow: 0px 0px 2px #000" fade
                    background="#ababab"   img-height="1024" img-width="480" indicators controls>
          <b-carousel-slide caption="fist slide" :img-src="urlI('/images/download1.jpg')"></b-carousel-slide>
          <b-carousel-slide caption="second slide" :img-src="urlI('/images/download2.jpg')"></b-carousel-slide>
          <b-carousel-slide caption="thirs slide" :img-src="urlI('/images/download3.jpg')"></b-carousel-slide>
        </b-carousel>
    </div>
</template>

<script>
import {baseUrl} from '../api/util'  
  export default {
    name:'carousels',
    methods:{
      urlI(u){
        return baseUrl(u)
      }
    }
  }
</script>