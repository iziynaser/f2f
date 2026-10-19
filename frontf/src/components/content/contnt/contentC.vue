<template>
  <div class="my-4">
    <!-- نمایش بارگذاری -->
    <div v-if="loading" class="text-muted">در حال بارگذاری محتوا...</div>

    <!-- نمایش پیام خطا -->
    <div v-else-if="errorMessage" class="alert alert-warning">
      {{ errorMessage }}
    </div>

    <!-- نمایش محتوا -->
    <div v-else-if="content && content.content" class="card">
      <div class="card-header">
        <strong>{{ content.title ? content.title : 'توضیحات محصول' }}</strong>
      </div>
      <div class="card-body">
        <div v-html="content.content"></div>
      </div>
    </div>

    <!-- پیام عدم وجود محتوا -->
    <div v-else class="text-muted">
      توضیحی برای این محصول ثبت نشده است.
    </div>
  </div>
</template>

<script>
import axiosInstance from '@/api/axiosInstance';

export default {
  name: 'contentC',
  props: {
    id: {
      type: Number,
      required: true
    },
    language: {
      type: String,
      default: 'fa'
    }
  },
  data() {
    return {
      content: null,
      loading: false,
      errorMessage: null
    }
  },
  methods: {
    async loadContent() {
      this.loading = true
      this.errorMessage = null
      try {
        const response = await axiosInstance.get('/pages/by-target', {
          params: {
            targetId: this.id,
            targetType: 'PRODUCT',
            language: this.language
          }
        })

        if (response && response.data && response.data.status === 'OK' && response.data.body) {
          this.content = response.data.body
        } else {
          this.errorMessage = (response && response.data && response.data.message) || 'محتوایی یافت نشد.'
        }
      } catch (error) {
        console.error(error)
        this.errorMessage =
          (error && error.response && error.response.data && error.response.data.message) ||
          'خطایی در دریافت محتوا رخ داده است.'
      } finally {
        this.loading = false
      }
    }
  },
  mounted() {
    this.loadContent()
  }
}
</script>

<style scoped>
.card {
  border-radius: 0.75rem;
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.05);
}

.card-body {
  line-height: 1.8;
}
</style>
