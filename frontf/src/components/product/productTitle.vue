<template>
    <div class="mb-3">
        <h1 class="h5 font-weight-bold text-dark mb-2">
            {{ title }}
        </h1>
        <p class="text-muted small mb-0" v-if="productId">
            شناسه محصول: {{ productId }}
        </p>
    </div>
</template>

<script>
export default {
    name: "ProductTitle",
    props: {
        title: {
            type: String,
            required: true,
            default : ''
        },
        productId: {
            type: [String, Number],
            required: false
        }
    }
};
</script>

<style scoped>
/* می‌توان در صورت نیاز رنگ یا فونت خاص افزود */
</style>
