<template>
  <div class="container mt-4">
    <!-- نوار انتخاب تب‌ها -->
    <div class="d-flex justify-content-start flex-nowrap overflow-auto mb-4 custom-scroll">
      <b-button
          v-for="section in sections"
          :key="section.key"
          :variant="activeSection === section.key ? 'primary' : 'outline-secondary'"
          :class="[
          'mx-2',
          'px-4',
          'py-2',
          'flex-shrink-0',
          activeSection === section.key ? 'shadow fw-bold rounded-pill' : ''
        ]"
          @click="activeSection = section.key"
      >
        <b-icon :icon="section.icon" class="ml-2" />
        {{ $t(section.label) }}
      </b-button>
    </div>

    <!-- محتوای تب فعال -->
    <div>
      <!-- ارسال prop visible فقط به ProductFeature -->
      <component
          :is="currentComponent"
          :id="Number(id)"
          :target-type="targetType"
          v-bind="currentComponent === 'ProductFeature' ? { visible: true } : {}"
      />
    </div>
  </div>
</template>

<script>
import CommentMain from './comment/CommentMain.vue'
import ProductFeature from './productFeature.vue'
import ContentC from '../content/contnt/contentC.vue'
import QAndA from './QAndA.vue'

export default {
  name: 'ProductSectionTabs',
  props: {
    id: {
      type: [Number, String],
      required: true
    },
    targetType: {
      type: String,
      default: 'PRODUCT'
    }
  },
  components: {
    CommentMain,
    ProductFeature,
    ContentC,
    QAndA
  },
  data() {
    return {
      activeSection: 'comments',
      sections: [
        { key: 'comments', label: 'PRODUCT_comments', icon: 'chat-square-text', component: 'CommentMain' },
        { key: 'features', label: 'PRODUCT_features', icon: 'list-check', component: 'ProductFeature' },
        { key: 'review', label: 'PRODUCT_REVIEW', icon: 'file-earmark-text', component: 'ContentC' },
        { key: 'qna', label: 'PRODUCT_quesAndAns', icon: 'question-circle', component: 'QAndA' }
      ]
    }
  },
  computed: {
    currentComponent() {
      const found = this.sections.find(s => s.key === this.activeSection)
      return found ? found.component : null
    }
  }
}
</script>
