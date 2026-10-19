<template>
    <div>
        {{$t('PRODUCT_AVAL_COLORS')}}:                                
        <ol class="mt-4">
            <b-button 
                      v-for="(filter_item, index) in filter_list.slice(0,limit_by)" :key="index"  
                      pill 
                      variant="outline" 
                      size="sm"
                      class="static m-1" 
                      :style="{ background: filter_item }" >{{filter_item}}</b-button>
        </ol>
        <a href="javascript:void(0)" class="mt-1"
          @click="simple_toggle(default_limit,filter_list.length)">        
                <span v-if="limit_by==3">+ {{$t('showOtherColor')}}  </span>
                <span v-else>- {{$t('showLess')}} </span>
        </a>
    </div>
</template>

<script>
export default {
    name:'colorMoreLess',
    props:{
          } ,
    data(){
      return {
        filter_list:[
            "blue" ,
            "yellow" ,
            "red" ,
            "black" ,
            "green" ,
            "purple" ,
            "gray"
        ] ,
        default_limit: 3,
        limit_by: 3
      }
    } ,
    methods:{
        simple_toggle(defult_limit,filters_length){
            this.limit_by = (this.limit_by === defult_limit) ? filters_length : defult_limit ;
        }
    }      
}
</script>

<style scoped>

</style>