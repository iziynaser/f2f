<template>
    <div class="container my-3">
        <h5 class="mb-3" >{{ $t('PRODUCT_RELATED_PRODUCT') }}</h5>

        <div class="row row-cols-2 row-cols-md-3 row-cols-lg-4 g-3">
            <div class="col" v-for="smp in similarProducts" :key="smp.id">
                <div class="card h-100 shadow-sm small-card">
                    <img v-if="smp.imgUrl" :src="smp.imgUrl" class="card-img-top" alt="Product Image" />
                    <div class="card-body p-2 d-flex flex-column">
                        <h6 class="card-title mb-1 text-primary" style="font-size: 0.85rem">
                            {{ smp.name }}
                        </h6>
                        <p class="text-muted mb-1 small">{{ smp.shortDesc }}</p>
                        <p class="text-success mb-1 small">{{ smp.amazingDesc }}</p>
                        <p class="mt-auto mb-0 fw-bold text-end text-dark" style="font-size: 0.9rem">
                            {{ smp.price }}
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axiosInstance from '@/api/axiosInstance';

export default {
    name: 'similarProduct',
    props: {
        productId: {
            type: [String, Number],
            default: 1
        }
    },
    data() {
        return {
            similarProducts: []
        };
    },
    mounted() {
        this.listOfSimilarProducts();
    },
    methods: {
        listOfSimilarProducts() {
          axiosInstance
                .get('/relatedProducts/list', {
                    params: { productId: this.productId }
                })
                .then((res) => {
                    this.similarProducts = res.data;
                })
                .catch((error) => {
                    console.error(error);
                });
        }
    }
};
</script>

<style scoped>
.card-img-top {
    height: 120px;
    object-fit: cover;
}

.small-card {
    font-size: 0.85rem;
    min-height: 270px;
}
</style>
