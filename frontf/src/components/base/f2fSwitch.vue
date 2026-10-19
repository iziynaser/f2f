<template>
  <div className="p-2 my-2 border">
    <b-form-checkbox
        v-model="localValue"
        name="checkButton"
        switch
    >
      {{ label }}
    </b-form-checkbox>
  </div>
</template>

<script>
export default {
  name: 'f2fSwitch',
  props: {
    modelValue: { // برای پشتیبانی از v-model
      type: Boolean,
      default: false
    },
    label: { // متن کنار سوئیچ
      type: String,
      default: 'Just available product'
    }
  },
  computed: {
    localValue: {
      get() {
        return this.modelValue
      },
      set(val) {
        this.$emit('update:modelValue', val) // ارسال تغییر به والد
      }
    }
  }
}
</script>

<style scoped>
</style>
