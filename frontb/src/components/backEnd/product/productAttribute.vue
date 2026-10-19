<template>
    <div>
                  <div class="p-2 row">
          <b-col>
             <b-button variant="outline-primary">
                zemanate asl boodane kala
                <b-img :src="urlI('/images/icon/warranti.png')" 
                     class="w-25 img-rounded" 
                     @click="showProduct()"/>
             </b-button>
          </b-col>
          <b-col>
            <b-button variant="outline-primary">
                <b-img :src="urlI('/images/icon/gift.png')"      
                     class="w-25 img-rounded" 
                     @click="showProduct()"/>  
            </b-button>    
          </b-col>
          <b-col>
            <b-button variant="outline-primary">
              emkan bazgasht kala
              <b-img :src="urlI('/images/icon/exam.png')"      
                   class="w-25 img-rounded" 
                   @click="showProduct()"/>  
            </b-button>  
          </b-col>
          <b-col>
            <b-button variant="outline-primary">
                express delivery and other
                <b-img :src="urlI('/images/icon/delivery.png')"  
                     class="w-25 img-rounded" 
                     @click="showProduct()"/>  
            </b-button>    
          </b-col>
          <b-col>
            <b-button variant="outline-primary">
                emkan pardakht dar mahal
                <b-img :src="urlI('/images/icon/buy.png')"   
                     class="w-25 img-rounded" 
                     @click="showProduct()"/>            
            </b-button>    
          </b-col>
        </div>

    </div>
</template>

<script>
import {baseUrl} from '../../../api/util'
export default {
    name:'productAttribute',
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
    }      
}
</script>

<style scoped>

</style>