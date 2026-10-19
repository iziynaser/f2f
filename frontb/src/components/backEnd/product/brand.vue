<template>
  <div>
    <b-form inline>

      <label class="sr-only" for="inline-form-name">name:</label>
      <b-input id="inline-form-name" class="mb-2 mr-sm mb-sm-0" placeholder="name"></b-input>

      <label class="sr-only" for="inline-form-value">value:</label>
      <b-input id="inline-form-value" class="mb-2 mr-sm mb-sm-0" placeholder="value"></b-input>

      <f2fTable :items="items" @row-selected="rowSelected" />

      <!-- <b-table striped hover :items="items" 
                       selectable
                       select-mode="single" 
                       selected-variant="success"
                       @row-selected="rowSelected"
              >
              </b-table> -->

      {{ selected }}
      <b-button variant="primary">{{ this.$t('save') }}</b-button>
    </b-form>
  </div>
</template>

<script>

import f2fTable from '../../base/f2fTable'

export default {
  name: 'brand',
  props: {
  },
  data() {
    return {
      items: [
        { id: 1, name: 'ali', value: "value1" },
        { id: 2, name: 'ali', value: "value1" },
        { id: 3, name: 'ali', value: "value1" }
      ],
      selected: []
    }
  },
  methods: {
    rowSelected: function (items) {
      this.selected = items
    },
    components: {
      f2fTable
    }
  }
}
</script>

<style scoped></style>
