<template>
  <div>
    <b-row class="my-1">
      <b-col sm="9">
        <div v-if="registerBtnClicked">
          <qna-create :id="Number(id)" :targetType="targetType" @question-saved="onQuestionSaved" />
        </div>
        <div v-else>
          <qna-tabs :id="Number(id)" :targetType="targetType" />
        </div>
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
import QnaCreate from './qa/QnaCreate.vue'
import QnaTabs from './qa/QnaTabs.vue'

export default {
  name: 'QAndA',
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
  },
  components: {
    QnaCreate,
    QnaTabs
  }
}
</script>

<style scoped>
/* استایل دلخواه */
</style>
