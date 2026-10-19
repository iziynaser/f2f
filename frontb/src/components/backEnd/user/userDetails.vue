<template>
    <div>
           
           <b-row>
               <b-col>nickName</b-col>
               <b-col>{{userDetailsForm.nickName}}</b-col>
           </b-row>
           <b-row>
               <b-col>mobile</b-col>
               <b-col>{{userDetailsForm.mobile}}</b-col>
           </b-row>
           <b-row>
               <b-col>city</b-col>
               <b-col>{{userDetailsForm.city}}</b-col>
           </b-row>
           <b-row>
               <b-col>address</b-col>
               <b-col>{{userDetailsForm.address}}</b-col>
           </b-row>
    </div>
</template>

<script>

export default {
    name:'userDetails',
    props:{
        userDetailsForm:{},
    },
    data(){
      return {
        isBusy:false,
        errors:{},  
      } 
    },
    methods:{

    },
    components:{
        
    } ,
    mounted(){
       
    }      
}
</script>

<style scoped>

</style>