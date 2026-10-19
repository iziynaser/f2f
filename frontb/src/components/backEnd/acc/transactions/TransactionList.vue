<template>

  <b-container fluid class="py-4" dir="rtl">
    <b-card header="اسناد حسابداری">
      <div class="d-flex justify-content-between align-items-center mb-3">
        <b-button variant="success" :to="{ name: 'transactions.create' }">صدور سند جدید</b-button>
      </div>
      <b-overlay :show="loading" rounded="sm">
      <b-table :items="transactions" :fields="fields" hover striped responsive>
        <template #cell(transactionStatus)="ctx">
          <b-badge :variant="statusVariant(ctx.value)">
            {{ ctx.value }}
          </b-badge>
        </template>

        <template #cell(actions)="ctx">
          <b-button size="sm" variant="outline-primary" :to="{ name: 'transactions.edit', params: { id: String(ctx.item.id) } }">
            مشاهده / ویرایش
          </b-button>
        </template>
      </b-table>
      </b-overlay>
    </b-card>
  </b-container>
</template>
<script>
import { mapGetters } from "vuex"

export default {
  computed:{
    ...mapGetters("transactions",["transactions","loading"])
  },
  data(){
    return{
      fields:[
        { key:"transactionNumber",label:"شماره" },
        { key:"transactionDate",label:"تاریخ" },
        { key:"description",label:"شرح" },
        { key:"transactionStatus",label:"وضعیت" },
        { key:"actions",label:"عملیات" }
      ]
    }
  },
  methods:{
    statusVariant(s){
      const map = {
        DRAFT:"secondary",
        POSTED:"primary",
        LOCKED:"dark",
        CANCELLED:"danger",
        REVERSED:"warning",
      }
      return map[s] || "info"
    }
  },
  mounted(){
    this.$store.dispatch("transactions/fetchTransactions")
  }
}
</script>
