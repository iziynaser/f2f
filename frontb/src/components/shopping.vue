<template>
    <div id="shoppinglist">
        <v-btn v-on:click="addItem">click to add an Item</v-btn>
        <div>{{title}}</div>
        <ul>
            <li v-for="prod in items" :key="prod.id" v-bind:value="prod.id">
                <div>
                    <input type="checkbox" v-model="prod.product.checked"/>
                     {{prod.product.name}}
                     {{prod.product.type}}
                     {{prod.product.model}}
                     {{prod.product.size}}
                     {{prod.product.color}}
                     {{prod.product.price}}
                </div>
            </li>
            <!-- </li> -->
        </ul>        
    </div>
</template>

<script>

export default {
    name:'shopping' ,
    data(){
        return{
            newItem:'',
            title:'shopping list' ,
            items:[
                {product:{id:'1',name:'Asus Tablet',type:'Full HD',model:'A9',size:'8pix',color:'Black',price:'250000',checked:true}},
                {product:{id:'2',name:'Shirt',type:'Simple',model:'xl',size:'45',color:'white',price:'13000',checked:false}},
                {product:{id:'3',name:'Pen',type:'Tombow',model:'5.1',size:'0.5',color:'black',price:'2000',checked:true}},
            ]
        }
    },
    methods:{
        addItem:function(){
            var p ;
            //p.product = {name:'test',type:'test',model:'A1',color:'b',price:'222',checked:true}
            this.items.push({name:'test',type:'test',model:'A1',color:'b',price:'222',checked:true});

            //this.items.push(p);
        }
    }
}

</script>

<style scoped>

</style>
