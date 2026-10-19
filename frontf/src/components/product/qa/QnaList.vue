<template>
    <div class="qna-list">
        <qna-item v-for="q in questions" :key="q.id" :question="q" @click.native="$emit('show-answers', q.id)" />
    </div>
</template>

<script>
import QnaItem from './QnaItem.vue'

export default {
    components: { QnaItem },
    props: {
        questions: Array
    }
}
</script>
