<template>
    <div class="carousel-wrapper w-100">
        <b-carousel :interval="4000" 
                    id="homeCarousel" 
                    fade
                    background="#ababab" 
                    indicators 
                    controls>
          
                    <b-carousel-slide caption="first slide">
                      <template #img>
                       <img :src="urlI('/images/download1.jpg')" class="carousel-img"/>
                      </template>   
                    </b-carousel-slide>

          <b-carousel-slide caption="second slide" >
            <template #img>
               <img :src="urlI('/images/download2.jpg')" class="carousel-img"/>
            </template>
          </b-carousel-slide>
        
          <b-carousel-slide caption="third slide">
            <template #img>
              <img :src="urlI('/images/download3.jpg')" class="carousel-img"/>
            </template>
          </b-carousel-slide>
        </b-carousel>

    </div>
</template>

<script>
import {baseUrl} from '../../api/util'
  export default {
    name:'carousels',
    methods:{
      urlI(u){
        return baseUrl(u)
      }
    }
  }
</script>
<style lang="css">
    .carousel-wrapper {
      position: relative;
      width: 100%;
      padding: 10px;
      padding-top: 56.25%;
    }

        .carousel-wrapper .carousel,
        .carousel-wrapper .carousel-inner,
        .carousel-wrapper .carousel-item,
        .carousel-wrapper img {
          position: absolute;
          top: 0;
          left: 0;
          width: 100%;
          height: 100%;
          object-fit: cover;
        }

.carousel-img{
  height: 100%;
  width: 100%;
  border-radius: 20px;
  object-fit: cover;
}

</style>