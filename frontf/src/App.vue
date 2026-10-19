<template>
  <div id="app" class="app-wrapper global-bg">
    <headers/>
    <Toast />
    <main class="container py-3 " role="main">
      <router-view></router-view>
    </main>
    <footers />
  </div>
</template>

<script>
import footers from './components/footers'
import headers from './components/headers.vue'
import Toast from './components/Toast'

export default {
  name: 'App',
  components: {
    headers,
    footers,
    Toast
  },
  async created() {
    try {
      //await this.$store.dispatch('cart/initializeCart')
    } catch (error) {
      console.error('خطا در مقداردهی اولیه سبد خرید:', error)
    }
  },
  data() {
    return {}
  },
  methods: {}
}
</script>

<style scoped>
body {
  font-family: 'IRANSans', 'Roboto', sans-serif;
  background-color: #f9fbfe;
}

.app-wrapper {
  margin-top: 10px;
}

.global-bg {
  background-color: white;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center center;
  min-height: 100vh;
}
</style>
