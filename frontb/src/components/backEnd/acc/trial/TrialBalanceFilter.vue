<template>
  <b-card class="mb-3 shadow-sm">
    <b-form @submit.prevent="onSubmit">
      <b-row>
        <b-col md="4" sm="12">
          <b-form-group label="دوره مالی" label-for="period-select">
            <b-form-select
                id="period-select"
                v-model="localFilter.periodId"
                :options="periodOptions"
                value-field="value"
                text-field="text"
            >
            </b-form-select>
          </b-form-group>
        </b-col>

        <b-col md="3" sm="12">
          <b-form-group label="جستجو در حساب‌ها">
            <b-form-input
                v-model.trim="localFilter.search"
                placeholder="کد یا نام حساب..."
            />
          </b-form-group>
        </b-col>

        <b-col md="2" sm="6">
          <b-form-group label="نمایش مانده صفر">
            <b-form-checkbox v-model="localFilter.showZeroBalance" switch>
              بله
            </b-form-checkbox>
          </b-form-group>
        </b-col>

        <b-col md="3" sm="6" class="d-flex align-items-end">
          <b-button type="submit" variant="primary" class="ml-2" block>
            دریافت گزارش
          </b-button>
        </b-col>
      </b-row>
    </b-form>
  </b-card>
</template>

<script>
export default {
  name: 'TrialBalanceFilter',
  props: {
    value: {
      type: Object,
      required: true
    },
    periodOptions: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      localFilter: {
        periodId: null,
        search: '',
        showZeroBalance: true
      }
    };
  },
  watch: {
    value: {
      immediate: true,
      deep: true,
      handler(val) {
        this.localFilter = {
          periodId: val.periodId || null,
          search: val.search || '',
          showZeroBalance: typeof val.showZeroBalance === 'boolean' ? val.showZeroBalance : true
        };
      }
    }
  },
  methods: {
    onSubmit() {
      this.$emit('input', { ...this.localFilter });
      this.$emit('submit', { ...this.localFilter });
    }
  }
};
</script>
