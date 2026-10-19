<template>
    <div class="answer-list mt-4">
        <h5>پاسخ‌ها:</h5>
        <div v-if="answers.length === 0">هیچ پاسخی وجود ندارد.</div>
        <ul>
            <li v-for="a in answers" :key="a.id">
                <p>{{ a.body }}</p>
                <small class="text-muted">کاربر {{ a.userId }} - رای‌ها: 👍{{ a.likes || 0 }} 👎{{ a.dislikes || 0
                }}</small>
            </li>
        </ul>
    </div>
</template>

<script>
import axiosInstance from '@/api/axiosInstance';

export default {
    props: { questionId: Number },
    data() {
        return { answers: [] }
    },
    watch: {
        questionId: {
            immediate: true,
            handler(newId) {
              axiosInstance.get(`/api/qas/questions/${newId}/answers`).then(res => {
                    this.answers = res.data
                })
            }
        }
    }
}
</script>
