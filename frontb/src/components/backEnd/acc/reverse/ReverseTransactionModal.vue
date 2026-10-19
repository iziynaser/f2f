<template>
  <b-modal
      id="reverse-modal"
      title="Reverse Transaction"
      ok-title="Reverse"
      ok-variant="danger"
      @ok="submitReverse"
  >

    <b-alert show variant="warning">
      This action will create a reversal transaction.
      The original transaction will remain in the system.
    </b-alert>

    <b-form-group label="Transaction Number">
      <b-form-input :value="transaction.transactionNumber" disabled />
    </b-form-group>

    <b-form-group label="Date">
      <b-form-input :value="transaction.transactionDate" disabled />
    </b-form-group>

    <b-form-group label="Reason">
      <b-form-textarea
          v-model="reason"
          rows="3"
          placeholder="Enter reason for reversal"
      />
    </b-form-group>

  </b-modal>
</template>

<script>
export default {
  props: {
    transaction: Object
  },

  data() {
    return {
      reason: ''
    }
  },

  methods: {

    async submitReverse() {

      try {

        await this.$axios.post(
            `/api/accounting/transactions/${this.transaction.id}/reverse`,
            { reason: this.reason }
        )

        this.$bvToast.toast('Transaction reversed successfully', {
          variant: 'success'
        })

        this.$emit('reversed')

      } catch (e) {

        this.$bvToast.toast('Reverse failed', {
          variant: 'danger'
        })

      }

    }

  }
}
</script>
