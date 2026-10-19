<template>
    <div id="user">
            <form v-on:submit="addUser">
                user name:<input type="text" v-model="newUser.name" placeholder="enter your name:"/>
                <br/>
                password:<input type="text" v-model="newUser.email" placeholder="enter your email"/>
                <br/>
                <input type="submit" :value="submit"/>
            </form>
    </div>
</template>

<script>

export default {
    name:'user' ,
    data(){
        return{
            newUser:{},
            users:[]
        }
    },
    methods:{
        addUser:function(e){
            this.users.push({                
                name:this.newUser.name ,
                email:this.newUser.email
            });
            
            e.preventDefault();            
        }
    },
    created:function(){
        
    }
}


</script>

<style scoped>

</style>
