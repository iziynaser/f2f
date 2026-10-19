<template>
  <div>
    <div>
      invoice
    </div>
    <div>
      <b-card no-body>
        <b-tabs pills card>
          <b-tab :title="this.$t('INVOICE_MTAB_findInvoice')">
            <findInvoice />
          </b-tab>
          <b-tab :title="this.$t('INVOICE_MTAB_header')">
            <invoiceHeader />
          </b-tab>
          <b-tab :title="this.$t('INVOICE_MTAB_items')">
            <invoiceItems />
          </b-tab>
          <b-tab :title="this.$t('INVOICE_MTAB_overview')">
            <invoiceOverview />
          </b-tab>
          <b-tab :title="this.$t('INVOICE_MTAB_content')">
            content
          </b-tab>
          <b-tab :title="this.$t('INVOICE_MTAB_payments')">
            payments
          </b-tab>
          <b-tab :title="this.$t('INVOICE_MTAB_notes')">
            notes
          </b-tab>
        </b-tabs>
      </b-card>
    </div>


  </div>
</template>
<script>

import findInvoice from './findInvoice'
import invoiceHeader from './invoiceHeader.vue'
import invoiceItems from './invoiceItems.vue'
import invoiceOverview from './invoiceOverview'

export default {
  name: 'invoice',
  props: {
  },
  data() {
    return {
      visible: true,
      errors: [],
      form: {

      }
    }
  },
  methods: {

  },
  components: {
    findInvoice,
    invoiceHeader,
    invoiceItems,
    invoiceOverview
  }
}
</script>

<style scoped></style>