<template>
    <div>
        {{ $t('PRODUCT_AVAL_COLORS') }}:
        <ol class="mt-4">
            <b-button v-for="(filter_item, index) in filter_list.slice(0, limit_by)" :key="index" pill variant="outline"
                size="sm" class="static m-1" :style="{ background: filter_item }">
                {{ filter_item }}
            </b-button>
        </ol>
        <a v-if="filter_list.length > default_limit" href="javascript:void(0)" class="mt-1"
            @click="simple_toggle(default_limit, filter_list.length)">
            <span v-if="limit_by == 3">+ {{ $t('showOtherColor') }} </span>
            <span v-else>- {{ $t('showLess') }} </span>
        </a>
    </div>
</template>

<script>
import axiosInstance from '@/api/axiosInstance';

export default {
    name: 'colorMoreLess',
    props: {
        productId: {
            type: [Number, String],
            required: true
        }
    },
    data() {
        return {
            filter_list: [],
            default_limit: 3,
            limit_by: 3
        }
    },
    methods: {
        simple_toggle(defult_limit, filters_length) {
            this.limit_by = (this.limit_by === defult_limit) ? filters_length : defult_limit;
        },
        fetchColors() {
            console.log('fetch colors of product with id = ' + this.productId);
          axiosInstance.get('/productColors/list', {
                params: {
                    productId: this.productId
                }
            }).then((res) => {
                this.filter_list = res.data.map(color => color.code || color.value);
            }).catch((error) => {
                console.log('error fetching product colors', error);
            });
        }
    }, mounted() {
        console.log("Received productId:", this.productId);

        if (this.productId) {
            this.fetchColors();
        }
    }, watch: {
        productId(newVal) {
            if (newVal) {
                this.fetchColors();
            }
        }
    }
}
</script>

<style scoped></style>