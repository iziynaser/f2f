<template>
    <div>
        {{$t('PRODUCT_SUMMARY_FEATURES')}}
        <ul class="mt-4">
            <li v-for="(filter_item, index) in filter_list.slice(0,limit_by)" :key="index">
                {{filter_item}}
            </li>
        </ul>
        <a href="javascript:void(0)" class="mt-1"
          @click="simple_toggle(default_limit,filter_list.length)">        
                <span v-if="limit_by==3">+ {{$t('more')}}  </span>
                <span v-else>- {{$t('close')}} </span>
        </a>
    </div>
</template>

<script>
export default {
    name:'moreLess',
    props:{
          } ,
    data(){
      return {
        filter_list:[
            "one" ,
            "two" ,
            "three" ,
            "four" ,
            "five" ,
            "six" ,
            "seven"
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
    ul{
        list-style: none;
    }

    ul li::before{
        content: "\2022" ;
        color:rebeccapurple ;
        font-weight: bold;
        width: 1em;
        display:inline-block;
    }

</style>