<template>
    <div class="answer-form mt-4">
        <h5>ارسال پاسخ جدید:</h5>
        <textarea v-model="body" class="w-full border p-2" rows="3" placeholder="پاسخ خود را بنویسید..."></textarea>
        <button @click="submit" class="btn btn-primary mt-2">ارسال</button>
    </div>
</template>

<script>
import axiosInstance from '@/api/axiosInstance';

export default {
    props: {
        questionId: Number
    },
    data() {
        return {
            body: ''
        }
    },
    methods: {
        submit() {
          axiosInstance.post('/qas/questions/' + this.questionId + '/answers', {
                body: this.body,
                userId: 1001 // ثابت، برای تست. در حالت واقعی از auth باید بیاد
            }).then(() => {
                this.body = ''
                this.$emit('submitted')
            })
        }
    }
}
</script>
