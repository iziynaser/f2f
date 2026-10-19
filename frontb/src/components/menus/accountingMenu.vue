<template>
    <div>
        <b-nav-item-dropdown :text="$t('ACCOUNTING_SITE')" right>

          <b-dropdown-item href="#" v-for="item in cp" :key="item.id">
            <b-button  size="sm" variant="link" @click="createAcTabs(item)">{{item.title}}</b-button>
          </b-dropdown-item>

        </b-nav-item-dropdown>

    </div>
</template>

<script>
import budget from '../backEnd/acc/budget.vue'
import fixedAssets from '../backEnd/acc/fixedAssets.vue'
import aggreement from '../backEnd/acc/aggreement.vue'
// import billingAccount from '../backEnd/acc/billingAccount.vue'
import createPayment from '../backEnd/payment/createPayment.vue'
import FinAccountMain from '../backEnd/acc/fin/FinAccountMain'
import invoice from '../backEnd/invoice/invoice'
import findInvoice from '../backEnd/invoice/findInvoice.vue'
import chartOfAccount from '../backEnd/acc/chartOfAccount/ChartOfAccounts.vue'
import transactionQuery from '../backEnd/acc/transactionQuery/TransactionsPage.vue'
import JournalEntries from '../backEnd/acc/journal/JournalEntries.vue'
import JournalSummary from '../backEnd/acc/journal/JournalSummary.vue'
import AccountJournal from '../backEnd/acc/journal/AccountJournal.vue'
import TrialBalance from '../backEnd/acc/trial/TrialBalanceReportPage.vue'
import TransactionsMain from '../backEnd/acc/transactions/TransactionsMain.vue'

export default {
    name: 'accountingMenu',
    props: {
    },
    data() {
        return {
      cp: [
        {id:8,title:this.$t('ACCOUNTING_budget') ,contnt:budget},
        {id:7,title:this.$t('ACCOUNTING_fixedAssets'),contnt:fixedAssets},
        {id:4,title:this.$t('ACCOUNTING_aggreement'),contnt:aggreement}      ,
        {id:2,title:'createPayment',contnt:createPayment}      ,
        {id:5,title:this.$t('ACCOUNTING_financialAccount'),contnt:FinAccountMain}      ,
        {id:3,title:'invoice',contnt:invoice}      ,
        {id:6,title:this.$t('ACCOUNTING_invoices'),contnt:findInvoice}      ,
        {id:1,title:'chart of acc',contnt:chartOfAccount}      ,
        {id:9,title:'chart of accounts',contnt:chartOfAccount}      ,
        {id:10,title:'transaction query',contnt:transactionQuery}      ,
        {id:11,title:'دفتر روزنامه / لیست اسناد',contnt:JournalEntries}      ,
        {id:12,title:'دفتر روزنامه / خلاصه اسناد',contnt:JournalSummary}      ,
        {id:13,title:'دفتر روزنامه / گردش اسناد',contnt:AccountJournal}      ,
        {id:14,title:'تراز ازمایشی',contnt:TrialBalance},
        {id: 15, title: 'اسناد حسابداری', contnt: TransactionsMain }
           ]
        }
    },
  methods: {
    createAcTabs(item) {
      let atab = {
        id: item.id ,
        name: item.title,
        contnt : item.contnt
      }
      atab.id = (atab.id + 20);
      //console.log(atab);
      this.$emit('createAppTab',atab);
    }
  },
    components: {
        // createPayment
    }
}
</script>

<style scoped></style>