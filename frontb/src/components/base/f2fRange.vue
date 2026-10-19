<template>
    <div>            
             <div>
               <label for="">{{titleOfRange}}</label>     
               range:{{defaultValue}}
              </div>     
            <b-form-input type="range" :min="minValue" :max="maxValue" v-model="defaultValue"></b-form-input>
            <b-button>filter</b-button>           
    </div>
</template>

<script>
export default {
    name:'f2fRange',
    props:{
          } ,
    data(){
      return {
        titleOfRange:'laptop range',
        minValue:0,
        maxValue:1000000,
        defaultValue:500
      }
    } ,
    methods:{

    }      
}
</script>

<style scoped>

</style>