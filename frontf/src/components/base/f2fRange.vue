<template>
  <div class="p-2 my-2 border rounded shadow-sm">
    <!-- دکمه بازشو -->
    <b-button
        v-b-toggle="collapseId"
        variant="light"
        class="w-100 d-flex justify-content-between align-items-center"
    >
      <span>{{ label }}</span>

    </b-button>

    <!-- محتوای داخلی -->
    <b-collapse :id="collapseId" v-model="isCollapsed" class="mt-2">
      <!-- اسلایدرها -->
      <div class="my-2">
        <b-form-input
            type="range"
            :min="min"
            :max="max"
            :step="step"
            v-model.number="internalValue[0]"
        />
        <b-form-input
            type="range"
            :min="min"
            :max="max"
            :step="step"
            v-model.number="internalValue[1]"
        />
      </div>

      <!-- input های عددی از و تا -->
      <div class="d-flex justify-content-between mt-2 gap-2">
        <b-form-input
            type="number"
            :min="min"
            :max="internalValue[1]"
            v-model.number="internalValue[0]"
            placeholder="از"
        />
        <b-form-input
            type="number"
            :min="internalValue[0]"
            :max="max"
            v-model.number="internalValue[1]"
            placeholder="تا"
        />
      </div>

      <!-- نمایش مقادیر فعلی -->
      <div class="d-flex justify-content-between mt-1">
        <span>{{ internalValue[0] }}</span>
        <span>{{ internalValue[1] }}</span>
      </div>
    </b-collapse>
  </div>
</template>

<script>
import { debounce } from 'lodash';

export default {
  name: 'F2FRange',
  props: {
    label: { type: String, default: 'محدوده قیمت' },
    min: { type: Number, default: 0 },
    max: { type: Number, default: 100 },
    step: { type: Number, default: 1 },
    modelValue: { type: Array, default: () => [0, 100] }
  },
  emits: ['update:modelValue'],
  data() {
    return {
      collapseId: 'rangeCollapse-' + Math.random().toString(36).substr(2, 9),
      internalValue: [...this.modelValue],
      isCollapsed: true
    };
  },
  watch: {
    internalValue: {
      handler: debounce(function (val) {
        // اطمینان از اینکه مقدار اول <= مقدار دوم است
        const [from, to] = val;
        const newVal = [Math.min(from, to), Math.max(from, to)];
        this.$emit('update:modelValue', [...newVal]);
      }, 200),
      deep: true
    },
    modelValue(val) {
      if (val && val.length === 2) {
        this.internalValue = [...val];
      }
    }
  }
};
</script>

<style scoped>
.p-2 {
  padding: 0.5rem;
}
.border {
  border-color: #dcdcdc;
}
.shadow-sm {
  box-shadow: 0 0.125rem 0.25rem rgba(0, 0, 0, 0.075);
}
.mt-1 {
  margin-top: 0.25rem;
}
.mt-2 {
  margin-top: 0.5rem;
}
.my-2 {
  margin-top: 0.5rem;
  margin-bottom: 0.5rem;
}
.d-flex {
  display: flex;
}
.justify-content-between {
  justify-content: space-between;
}
.align-items-center {
  align-items: center;
}
.gap-2 {
  gap: 0.5rem;
}
</style>
