<template>
    <div >
        <h2>pomodor</h2>   {{title}}
        <span>{{minute}}:{{second}}</span>
    </div>
</template>

<script>

export default {    
    name:'pomodor' ,
    pomodorState: '',
    minute:0,
    second:0,
    state:'',
    data(){
        return{
            promodoro:[]
        }
    },
    methods:{
        start:function(){
            this.state = 'start'
        },
        stop:function(){
            this.state =  'stop'
        },
        pause:function(){
            this.state = 'pause'
        }
    },
    computed:{
        title:function(){
            return this.pomodorState === '' ? 'Work' : 'Rest!'
        }
    }
}


</script>

<style scoped>

</style>
