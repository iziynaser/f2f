<template>
  <div>
    <b-container fluid>

      <b-form>

        <b-row class="my-1">
          <b-col sm="2">{{ $t('current_date') }}</b-col>
          <b-col sm="4">
            <b-form-input id="" required="" placeholder="" />
          </b-col>
          <b-col sm="2">{{ $t('date') }}</b-col>
          <b-col sm="4">
            <b-form-input id="" required="" placeholder="" />
          </b-col>
        </b-row>


        <b-row class="my-1">
          <b-col sm="2">title</b-col>
          <b-col sm="4">
            <b-form-input id="" required="" placeholder="" />
          </b-col>
          <b-col sm="2">{{ $t('description') }}</b-col>
          <b-col sm="4">
            <b-form-input id="" required="" placeholder="" />
          </b-col>
        </b-row>

        <b-row class="my-1">
          <b-col sm="2">{{ $t('creator') }}</b-col>
          <b-col sm="4">
            <b-form-input id="" required="" placeholder="" />
          </b-col>
          <b-col sm="2">{{ $t('fromPerson') }}</b-col>
          <b-col sm="4">
            <b-form-input id="" required="" placeholder="" />
          </b-col>
        </b-row>

        <b-row class="my-1">
          <b-col sm="2">{{ $t('toPerson') }}</b-col>
          <b-col sm="4">
            <b-form-input id="" required="" placeholder="" />
          </b-col>
          <b-col sm="2">{{ $t('invoiceType') }}</b-col>
          <b-col sm="4">
            <b-form-input id="" required="" placeholder="" />
          </b-col>
        </b-row>


      </b-form>
      <b-card>
        <f2fTable :searchResult="searchResult" :searchFields="searchFields" :busy="isBusy"
          :caption="this.$t('searchResults')" />
      </b-card>
    </b-container>
  </div>
</template>

<script>
import f2fTable from '../../base/f2fTable'

export default {
  name: 'invoiceItems',
  props: {
  },
  data() {
    return {
      isBusy: false,
      visible: true,
      errors: [],
      searchResult: [],
      searchFields: [],
      form: {

      }
    }
  },
  components: {
    f2fTable
  },
  methods: {

  }
}
</script>

<style scoped></style>