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
      <!-- حالت رادیویی -->
      <div v-if="mode === 'radio'">
        <b-form-radio-group
            v-model="internalValue"
            name="yesno-radio"
            stacked
        >
          <b-form-radio
              v-for="option in options"
              :key="option.value"
              :value="option.value"
              :class="optionClass(option.value)"
          >
            {{ option.text }}
          </b-form-radio>
        </b-form-radio-group>
      </div>

      <!-- حالت کشویی (select) -->
      <div v-if="mode === 'select'">
        <b-form-select
            v-model="internalValue"
            :options="options"
            class="w-100"
        />
      </div>

      <!-- حالت سوییچ -->
      <div v-if="mode === 'switch'">
        <b-form-checkbox
            switch
            v-model="internalValue"
            :value="options[0].value"
            :unchecked-value="options[1].value"
            :class="switchClass"
        >
          {{ internalValue === options[0].value ? options[0].text : options[1].text }}
        </b-form-checkbox>
      </div>
    </b-collapse>
  </div>
</template>

<script>
export default {
  name: 'YesNo',
  props: {
    label: {
      type: String,
      required: true
    },
    modelValue: {
      type: String, // 'yes' یا 'no'
      default: null
    },
    mode: {
      type: String, // 'radio' | 'select' | 'switch'
      default: 'switch'
    },
    options: {
      type: Array,
      default: function () {
        return [
          { text: 'بله', value: 'yes' },
          { text: 'خیر', value: 'no' }
        ];
      }
    }
  },
  emits: ['update:modelValue'],
  data: function () {
    return {
      collapseId: 'ynCollapse-' + Math.random().toString(36).substr(2, 9),
      internalValue: this.modelValue,
      isCollapsed: true
    };
  },
  computed: {
    switchClass: function () {
      return this.internalValue === this.options[0].value ? 'switch-yes' : 'switch-no';
    }
  },
  methods: {
    optionClass: function (value) {
      return value === 'yes' ? 'text-success font-weight-bold' : 'text-danger font-weight-bold';
    }
  },
  watch: {
    internalValue: function (val) {
      this.$emit('update:modelValue', val);
    },
    modelValue: function (val) {
      this.internalValue = val;
    }
  }
};
</script>

<style scoped>
/* استایل مدرن و حرفه‌ای */
.border {
  border-color: #dcdcdc;
}

.switch-yes .custom-control-label::before {
  background-color: #28a745;
}

.switch-no .custom-control-label::before {
  background-color: #dc3545;
}

.b-form-radio .text-success {
  color: #28a745 !important;
}

.b-form-radio .text-danger {
  color: #dc3545 !important;
}

.b-form-radio-group .b-form-radio {
  margin-bottom: 0.5rem;
}
</style>
