<template>
    <div>
        <b-tabs @input="() => { }">
            <b-tab title="جاری" :title-link-class="activeTab === 'CURRENT' ? 'font-weight-bold' : ''"
                :active="activeTab === 'CURRENT'" @click="selectTab('CURRENT')">
                <OrderTab :orders="orders" />
            </b-tab>

            <b-tab title="ایجاد شده" :title-link-class="activeTab === 'CREATED' ? 'font-weight-bold' : ''"
                :active="activeTab === 'CREATED'" @click="selectTab('CREATED')">
                <OrderTab :orders="orders" />
            </b-tab>


            <b-tab title="تحویل داده شده" :title-link-class="activeTab === 'DELIVERED' ? 'font-weight-bold' : ''"
                :active="activeTab === 'DELIVERED'" @click="selectTab('DELIVERED')">
                <OrderTab :orders="orders" />
            </b-tab>

            <b-tab title="لغو شده" :title-link-class="activeTab === 'CANCELED' ? 'font-weight-bold' : ''"
                :active="activeTab === 'CANCELED'" @click="selectTab('CANCELED')">
                <OrderTab :orders="orders" />
            </b-tab>

            <b-tab title="مرجوعی" :title-link-class="activeTab === 'RETURNED' ? 'font-weight-bold' : ''"
                :active="activeTab === 'RETURNED'" @click="selectTab('RETURNED')">
                <OrderTab :orders="orders" />
            </b-tab>
        </b-tabs>
    </div>
</template>

<script>
import OrderTab from './OrderTab.vue'
import axiosInstance from '@/api/axiosInstance';

export default {
    name: 'myOrders',
    components: { OrderTab },
    data() {
        return {
            activeTab: 'CURRENT', // مقدار پیش‌فرض رشته‌ای صحیح
            customerId: 1,
            orders: []
        }
    },
    methods: {
        fetchOrders() {
            //console.log('درخواست برای وضعیت:', this.activeTab); // اکنون مقدار رشته‌ای مثل 'CURRENT' است
          axiosInstance.get(`/orders/customer/${this.customerId}/${this.activeTab}`)
                .then(res => {
                    this.orders = res.data
                })
                .catch(err => {
                    console.error('خطا در دریافت سفارش‌ها', err)
                })
        },
        selectTab(status) {
            this.activeTab = status;
            this.fetchOrders();
        }
    },
    mounted() {
        this.fetchOrders()
    }
}
</script>
