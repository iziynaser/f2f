<template>
    <div>
        <h1> {{title}} </h1>
        <span v-if="showSummery">
            <div>
                {{user.summery}}
            </div>
        </span>
        <span v-else>
            <div>
                click here to show details of user
            </div>
        </span>
        <div>
            contact info:
            <ul>
                <li v-for="m in contacts">
                    {{m.contact}}
                </li>
            </ul>
        </div>
        <button v-on:click="showVCard()">show vCard</button>
    </div>
</template>

<script>
export default {
    name:'test' ,
    data(){
        return {
            title:'test component',
            user:{
                firstName:'naser',
                lastName:'iziy',
                summery:'an experienced j2ee developer that tries to create an open source erp'
            },
            showSummery:true,
            contacts:[
                {contact:'09192008250'},
                {contact:'02127313145'},
                {contact:'iziy_naser@yahoo.com'},
                {contact:'iziy@behsazan.net'}                
            ]
            }
    },
    methods:{
        showVCard: function(){            
            
        }
    }
}
</script>

<style scoped>

</style>
