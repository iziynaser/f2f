<template>
    <div v-if="isSucceed">
        {{ name }}
        <b-badge variant="primary" pill>{{ localCount }}</b-badge>
    </div>
    <div v-else>
        {{ name }}
        <b-badge variant="secondary" pill>0</b-badge>
    </div>
</template>

<script>
import axiosInstance from '@/api/axiosInstance';

export default {
    name: 'f2fBadge',
    props: {
        name: { type: String, required: true },
        address: { type: String, default: '' },
        initialCount: { type: Number, default: 0 },
        params: { // پارامترهای دلخواه که به API ارسال می‌شوند
            type: Object,
            default: () => ({})
        }
    },
    data() {
        return {
            isSucceed: true,
            localCount: this.initialCount,
        };
    },
    methods: {
        async fetchCount() {
            if (!this.address) {
                this.isSucceed = this.localCount > 0;
                return;
            }
            try {
                const response = await axiosInstance.get(this.address, { params: this.params });
                // فرض: پاسخ سرور عدد خام است. در غیر اینصورت مقدار مناسب را استخراج کن.
                this.localCount = typeof response.data === 'number' ? response.data : 0;
                this.isSucceed = this.localCount > 0;
            } catch (error) {
                this.isSucceed = false;
            }
        }
    },
    mounted() {
        this.fetchCount();
    }
};
</script>

<style scoped>
/* در صورت نیاز استایل اضافه کن */
</style>
