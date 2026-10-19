<template>

  <div>

    <transaction-search-form
        @search="search"
    />

    <transaction-table
        :items="transactions"
        @select="openDetail"
    />

    <transaction-detail ref="detail"/>

  </div>

</template>


<script>

import {mapGetters} from "vuex";
import TransactionSearchForm from "./TransactionSearchForm.vue"
import TransactionTable from "./TransactionTable.vue"
import TransactionDetail from "./TransactionDetail.vue"

//import {searchTransactions} from "../../../../store/modules/trans/transactionService"

export default{

  components:{
    TransactionSearchForm,
    TransactionTable,
    TransactionDetail
  },
  computed:{
    ...mapGetters("transactions",[
        "transactions",
        "loading"
    ])
  },
  data(){ return {} }
,

  methods:{

    async search(filter){
      await this.$store.dispatch(
          "transactions/searchTransactions",
          filter
      )
    }
,

    openDetail(row){

      this.$refs.detail.open(row.id)

    }

  }

}

</script>
