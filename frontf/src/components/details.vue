<template>
<div>
    details {{this.$route.params.pid}}
    <div>
        number:<input type="text" placeholder="enter your number you want" v-model="num"/>
        <br/>
        <input type="text" placeholder="enter your amount" v-model="amnt"/>
        <br/>
        result
        <div v-html="numMultiplyWithAmount"/>
    </div>
</div>    
</template>

<script>

export default {    
    name:'details' ,
    data(){
        return {
            num:'',
            amnt:''
        }
    },
    computed:{
        numMultiplyWithAmount:function(){
            return this.num * this.amnt
        }
    }
}


</script>

<style scoped>

</style>
