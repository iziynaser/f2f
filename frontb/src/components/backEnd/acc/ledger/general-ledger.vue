<template>
  <div class="container-fluid mt-3">

    <b-card class="mb-3">

      <h4 class="mb-3">
        دفتر کل
      </h4>

      <b-form @submit.prevent="loadGeneralLedger">

        <b-row>

          <b-col md="4">

            <b-form-group label="دوره مالی">

              <b-form-select
                  v-model="periodId"
                  :options="periodOptions">
              </b-form-select>

            </b-form-group>

          </b-col>

          <b-col md="2" class="align-self-end">

            <b-button
                type="submit"
                variant="primary"
                block>

              نمایش دفتر کل

            </b-button>

          </b-col>

        </b-row>

      </b-form>

    </b-card>

    <div
        v-if="generalLedger">

      <b-card
          v-for="(acc, index) in generalLedger.accounts"
          :key="index"
          class="mb-4">

        <div class="d-flex justify-content-between mb-3">

          <div>

            <h5>

              {{ acc.account.accountCode }}
              -
              {{ acc.account.name }}

            </h5>

          </div>

          <div>

            <b-badge variant="primary">

              {{ acc.entries.length }}
              گردش

            </b-badge>

          </div>

        </div>

        <b-table
            striped
            bordered
            hover
            responsive
            small
            :items="acc.entries"
            :fields="fields">

          <template #cell(debit)="data">
            {{ formatNumber(data.item.debit) }}
          </template>

          <template #cell(credit)="data">
            {{ formatNumber(data.item.credit) }}
          </template>

          <template #cell(balance)="data">
            {{ formatNumber(data.item.balance) }}
          </template>

        </b-table>

      </b-card>

    </div>

  </div>
</template>

<script>

import ledgerService from '@/services/ledgerService'

export default {

  name: 'GeneralLedger',

  data() {
    return {

      periodId: null,

      generalLedger: null,

      fields: [
        {
          key: 'date',
          label: 'تاریخ'
        },
        {
          key: 'transactionNumber',
          label: 'شماره سند'
        },
        {
          key: 'description',
          label: 'شرح'
        },
        {
          key: 'debit',
          label: 'بدهکار'
        },
        {
          key: 'credit',
          label: 'بستانکار'
        },
        {
          key: 'balance',
          label: 'مانده'
        }
      ],

      periodOptions: [
        {
          value: null,
          text: 'انتخاب دوره مالی'
        }
      ]

    }
  },

  methods: {

    async loadGeneralLedger() {

      if (!this.periodId) {

        this.$bvToast.toast('دوره مالی را انتخاب کنید', {
          title: 'خطا',
          variant: 'danger',
          solid: true
        })

        return
      }

      try {

        const response = await ledgerService.getGeneralLedger(
            this.periodId
        )

        this.generalLedger = response.data

      } catch (e) {

        console.error(e)

        this.$bvToast.toast('خطا در دریافت اطلاعات', {
          title: 'خطا',
          variant: 'danger',
          solid: true
        })
      }

    },

    formatNumber(value) {

      if (value == null) {
        return 0
      }

      return new Intl.NumberFormat().format(value)
    },

    async loadPeriods() {

      /*
      اتصال به API واقعی
      */

      this.periodOptions = [
        {
          value: null,
          text: 'انتخاب دوره مالی'
        },
        {
          value: 1,
          text: 'دوره مالی 1404'
        }
      ]
    }

  },

  async mounted() {

    await this.loadPeriods()

  }

}
</script>

<style scoped>

.container-fluid {
  direction: rtl;
}

</style>
