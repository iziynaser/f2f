<template>
  <div class="d-flex align-items-center ">
    <div v-for="(attr, index) in attributes" :key="index" class="mx-2 text-center">
      <b-icon :icon="attr.icon" font-scale="1.7" class="mb-1 text-primary" />
      <small class="d-block text-muted" style="font-size: 11px;">{{ attr.label }}</small>
    </div>
  </div>
</template>

<script>
export default {
  name: 'productAttribute',
  data() {
    return {
      attributes: [
        { label: 'اصالت کالا', icon: 'award' },
        { label: 'هدیه همراه', icon: 'gift' },
        { label: 'بازگشت کالا', icon: 'arrow-counterclockwise' },
        { label: 'تحویل سریع', icon: 'truck' },
        { label: 'پرداخت در محل', icon: 'credit-card' }
      ]
    }
  }
}
</script>
