<template>

  <b-modal
      ref="modal"
      title="جزئیات سند حسابداری"
      size="lg"
      hide-footer
  >

    <b-row>

      <b-col>
        <p>شماره سند: {{ transaction && transaction.transactionNumber }}</p>
        <p>تاریخ: {{ transaction.transactionDate }}</p>
        <p>شرح: {{ transaction.description }}</p>
        <p>وضعیت: {{ transaction.transactionStatus }}</p>
      </b-col>

    </b-row>

    <b-table
        striped
        :items="details"
        :fields="fields"
    />

  </b-modal>

</template>

<script>

import { mapGetters } from "vuex"

export default {

  data() {

    return {

      fields: [

        { key: "accountCode", label: "کد حساب" },
        { key: "accountName", label: "نام حساب" },
        { key: "debit", label: "بدهکار" },
        { key: "credit", label: "بستانکار" },
        { key: "description", label: "شرح" }

      ]

    }

  },

  computed: {

    ...mapGetters("transactions", [

      "transaction"

    ]),

    details() {

      if (
          this.transaction &&
          this.transaction.details
      ) {
        return this.transaction.details
      }

      return []

    }

  },

  methods: {

    async open(id) {

      await this.$store.dispatch(
          "transactions/fetchTransaction",
          id
      )

      this.$refs.modal.show()

    }

  }

}

</script>
