<template>
  <div class="p-2 my-2 border rounded shadow-sm">
    <!-- دکمه بازشو -->
    <b-button
        v-b-toggle="collapseId"
        variant="light"
        class="w-100 d-flex justify-content-between align-items-center"
    >
      <span>{{ label }}</span>
      <span>
      </span>
    </b-button>

    <!-- محتوای داخلی -->
    <b-collapse :id="collapseId" v-model="isCollapsed" class="mt-2">
      <div
          v-for="(group, index) in colors"
          :key="index"
          class="mb-3"
      >
        <div class="fw-bold mb-2">{{ group.name }}</div>
        <b-form-checkbox-group
            v-model="internalValue"
            :options="group.items || []"
            value-field="value"
            text-field="text"
            stacked
        />
      </div>
    </b-collapse>
  </div>
</template>

<script>
export default {
  name: 'F2FColori',
  props: {
    label: {
      type: String,
      default: 'انتخاب رنگ'
    },
    colors: {
      type: Array,
      default: function () {
        return [
          {
            name: 'Basic',
            items: [
              { text: 'Red', value: 'red' },
              { text: 'Blue', value: 'blue' }
            ]
          }
        ];
      }
    },
    modelValue: {
      type: Array,
      default: function () {
        return [];
      }
    }
  },
  emits: ['update:modelValue'],
  data() {
    return {
      collapseId: 'colorCollapse-' + Math.random().toString(36).substr(2, 9),
      internalValue: Array.isArray(this.modelValue) ? this.modelValue : [],
      isCollapsed: true
    };
  },
  watch: {
    internalValue(val) {
      this.$emit('update:modelValue', val);
    },
    modelValue(val) {
      this.internalValue = Array.isArray(val) ? val : [];
    }
  }
};
</script>

<style scoped>
/* دکمه بازشو */
.b-button {
  cursor: pointer;
}

/* کنترل نمایش آیکون‌ها */
.collapsed > .when-opened,
:not(.collapsed) > .when-closed {
  display: none;
}

/* استایل بهتر گروه رنگ‌ها */
.b-form-checkbox-group .custom-control {
  margin-bottom: 0.5rem;
}

.border {
  border-color: #dcdcdc;
}
</style>
