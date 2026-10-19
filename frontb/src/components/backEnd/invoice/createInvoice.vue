<template>
      <div>
            <b-card title="sales invoice">
                  <div>
                        <b-button v-b-modal.modal-scrollable>{{ this.$t('find') }}</b-button>
                        <b-modal id="modal-scrollable" scrollable title="find parties" footer-bg-variant="primary"
                              content-class="shadow" cancel-disabled="true" header-bg-variant="primary">

                              <p class="m-4">

                              </p>
                        </b-modal>
                  </div>
            </b-card>

            <b-card title="purchase invoice">

            </b-card>
      </div>
</template>

<script>
export default {
      name: 'createInvoice',
      props: {
      },
      data() {
            return {

            }
      },
      methods: {

      }
}
</script>

<style scoped></style>