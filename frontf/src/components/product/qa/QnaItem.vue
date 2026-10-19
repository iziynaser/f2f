<template>
    <div class="qna-item border p-3 mb-2 cursor-pointer hover:bg-gray-50">
        <h4>{{ question.subject || 'بدون عنوان' }}</h4>
        <p>{{ question.body }}</p>
        <div class="text-sm text-gray-500">: {{ (question.answers && question.answers.length) || 0 }}</div>

    </div>
</template>

<script>
export default {
    props: {
        question: Object
    }
}
</script>
