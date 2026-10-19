<template>
    <div>
        <OrderCard v-for="order in orders" :key="order.id" :order="order" />
    </div>
</template>

<script>
import OrderCard from './OrderCard.vue'

export default {
    name: 'OrderTab',
    props: {
        orders: { type: Array, required: true }
    },
    components: {
        OrderCard
    }
}
</script>
