<template>
    <div>
        <div class="tabs mb-3">
            <button @click="tab = 'latest'" :class="{ active: tab === 'latest' }">جدیدترین پرسش‌ها</button>
            <button @click="tab = 'most'" :class="{ active: tab === 'most' }">بیشترین پاسخ</button>
        </div>

        <div v-if="loading">در حال بارگذاری...</div>
        <qna-list v-else :questions="displayedQuestions" @show-answers="loadAnswers" />

        <div v-if="selectedQuestion">
            <answer-list :question-id="selectedQuestion.id" />
            <answer-form :question-id="selectedQuestion.id" @submitted="loadAnswers(selectedQuestion.id)" />
        </div>
    </div>
</template>

<script>
import QnaList from './QnaList.vue'
import AnswerList from './AnswerList.vue'
import AnswerForm from './AnswerForm.vue'
import axiosInstance from '@/api/axiosInstance';

export default {
    props: {
        id: {
            type: Number,
            required: true
        },
        targetType: {
            type: String,
            required: true
        }
    },
    components: {
        QnaList,
        AnswerList,
        AnswerForm
    },
    data() {
        return {
            tab: 'latest',
            latestQuestions: [],
            mostAnsweredQuestions: [],
            selectedQuestion: null,
            loading: false
        }
    },
    computed: {
        displayedQuestions() {
            return this.tab === 'latest'
                ? this.latestQuestions
                : this.mostAnsweredQuestions
        }
    },
    created() {
        this.fetchLatest()
        this.fetchMostAnswered()
    },
    methods: {
        fetchLatest() {
            this.loading = true
            const idNum = Number(this.id);
            if (!this.targetType || isNaN(idNum)) {
                console.error('Invalid targetType or id:', this.targetType, this.id);
                return;
            }

          axiosInstance
                .get(`/qas/questions/latest/${this.targetType}/${this.id}`)
                .then(res => {
                    this.latestQuestions = res.data && res.data.content ? res.data.content : []
                })
                .catch(err => {
                    console.error('خطا در دریافت جدیدترین پرسش‌ها:', err)
                })
                .finally(() => {
                    this.loading = false
                })
        },
        fetchMostAnswered() {
            this.loading = true
            const idNum = Number(this.id);
            if (!this.targetType || isNaN(idNum)) {
                console.error('Invalid targetType or id:', this.targetType, this.id);
                return;
            }

          axiosInstance
                .get(`/qas/questions/most-answers/${this.targetType}/${this.id}`)
                .then(res => {
                    this.mostAnsweredQuestions = res.data && res.data.content ? res.data.content : []
                })
                .catch(err => {
                    console.error('خطا در دریافت پرسش‌های با بیشترین پاسخ:', err)
                })
                .finally(() => {
                    this.loading = false
                })
        },
        loadAnswers(questionId) {
            this.selectedQuestion = this.displayedQuestions.find(q => q && q.id === questionId)
        }
    }
}
</script>

<style scoped>
.tabs {
    display: flex;
    gap: 1rem;
}

.tabs button {
    padding: 0.5rem 1rem;
    border: none;
    background: #f0f0f0;
    cursor: pointer;
    font-weight: bold;
    border-radius: 4px;
}

.tabs button.active {
    background-color: #d3e5ff;
}
</style>
