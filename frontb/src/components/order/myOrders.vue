<template>
    <div>

        <b-row>
            <b-col>
                current 
                <b-badge variant="success" pill>20</b-badge>
            </b-col>
            <b-col>
                delivered 
                <b-badge variant="success" pill>20</b-badge>
            </b-col>
            <b-col>
                returned 
                <b-badge variant="success" pill>20</b-badge>
            </b-col>
            <b-col>
                canceled 
                <b-badge variant="success" pill>20</b-badge>
            </b-col>
        </b-row>

        <div>
            <b-card>
                date: 1398/01/01
                order id: 7998798
                status:
                sum amount: 879879788
                <hr/>
                see your order :
                    sum amount <br/>
                    delivery date<br/>
                    cost of delivery<br/>
                    items:
                        name<br/>
                        features<br/>
                        unnit cost<br/>
                        add comment<br/>
                        buy again<br/>
                <hr/>
                see your invoice
                    (pdf file : name of saler ,adress,postal code, company code , invoice id , )
                    (buyer: name , adress , postal code,date,code peygiri,)
                    items
                        product code,supplier,unit cost,number of item,amount , amount after promotion,tax,etc,sum
                        sum amount
                    items
                    delivery date,
                    time of delivery
                <br/>
                list of orders(with a link to refer product) 
            </b-card>      
        </div>
              
    </div>
</template>

<script>

export default {
    name:'myOrders',
    props:{
          } ,
    data(){
      return {
        
      }
    } ,
    methods:{

    },
    components:{

}
}
</script>

<style scoped>

</style>