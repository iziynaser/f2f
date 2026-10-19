<template>
  <div v-if="visible">
    <div v-if="!isBusy">
      <div v-if="featuresGrouped.length">
        <b-container v-for="group in featuresGrouped" :key="group.groupId" class="mb-4">
          <h5 class="mb-2 font-weight-bold">{{ group.groupName }}</h5>
          <b-table :thead="false" :items="group.items" :fields="['name', 'values']" bordered small responsive>
            <template #cell(name)="data">
              {{ data.item.itemName }}
            </template>
            <template #cell(values)="data">
              <span v-for="(val, index) in data.item.values" :key="index">
                {{ val }}<span v-if="index !== data.item.values.length - 1">، </span>
              </span>
            </template>
          </b-table>
        </b-container>
      </div>
      <div v-else class="text-muted text-center">
        هیچ مشخصاتی برای این کالا ثبت نشده است.
      </div>
    </div>
    <b-spinner v-else label="در حال بارگذاری..."></b-spinner>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';

export default {
  name: 'ProductFeature',
  props: {
    id: { type: [Number, String], required: true },
    visible: { type: Boolean, default: false } // فقط وقتی true باشه، لود می‌کنه
  },
  computed: {
    ...mapState('feature', ['isBusy', 'featuresGrouped', 'loadedProductId'])
  },
  watch: {
    visible(newVal) {
      if (newVal && this.loadedProductId !== this.id) {
        this.loadFeatures(this.id);
      }
    }
  },
mounted() {
  if (this.visible && this.loadedProductId !== this.id) {
    this.loadFeatures(this.id);
  }
},
  methods: {
    ...mapActions('feature', ['loadFeatures'])
  }
};
</script>

<style scoped>
h5 {
  border-bottom: 1px solid #ccc;
  padding-bottom: 4px;
}
</style>
