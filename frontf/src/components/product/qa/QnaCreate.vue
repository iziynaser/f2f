<template>
    <div>
        <b-input v-model="form.subject" :placeholder="$t('QNA_ENTER_TITLE')" class="mb-2"></b-input>
        <rEditor v-on:editorContentChanged="onContentChanged" />

        <b-button variant="success" @click="saveQuestion">
            {{ $t('save') }}
        </b-button>
    </div>
</template>

<script>
import rEditor from '../rEditor.vue'
import axiosInstance from '@/api/axiosInstance';

export default {
    name: 'QnaCreate',
    props: {
        id: Number,
        targetType: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            form: {
                subject: '',
                body: '',
                targetId: 0
            }
        }
    },
    methods: {
        onContentChanged(content) {
            this.form.body = content
        },
        saveQuestion() {
            this.form.targetId = this.id;
          axiosInstance.post('/qa/questions', this.form)
                .then(() => {
                    this.$emit('question-saved')
                })
                .catch(console.error)
        }
    },
    components: {
        rEditor
    }
}
</script>
