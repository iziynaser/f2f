<template>
    <div>
        <b-row class="my-1">
            <b-col sm="9">
                <!-- اگر در حالت ثبت هستیم، فرم نمایش داده شود -->
                <div v-if="registerBtnClicked">
                    <qna-create :id="id" :target-type="targetType" @question-saved="onQuestionSaved" />
                </div>
                <div v-else>
                    <!-- future diagram maybe -->
                </div>

                <qna-tabs :id="id" :target-type="targetType" />
            </b-col>

            <b-col sm="3">
                <div>{{ $t('QNA_REG_DESCR') }}</div>
                <b-button pill variant="primary" @click="registerBtnClick">
                    {{ $t('QNA_REG_NEW_QUESTION') }}
                </b-button>
            </b-col>
        </b-row>
    </div>
</template>

<script>
import QnaCreate from './qna/QnaCreate.vue'
import QnaTabs from './qna/QnaTabs.vue'

export default {
    name: 'QAndA',
    components: {
        QnaCreate,
        QnaTabs
    },
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
    data() {
        return {
            registerBtnClicked: false
        }
    },
    methods: {
        registerBtnClick() {
            this.registerBtnClicked = true
        },
        onQuestionSaved() {
            this.registerBtnClicked = false
        }
    }
}
</script>
