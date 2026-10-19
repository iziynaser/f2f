<template>

  <b-card class="mb-3">

    <h5 class="mb-3">جستجوی اسناد حسابداری</h5>

    <b-form @submit.prevent="search">

      <b-row>

        <b-col md="3">
          <b-form-group label="شماره سند">

            <b-form-input
                v-model="filter.documentNumber"
            />

          </b-form-group>
        </b-col>


        <b-col md="3">
          <b-form-group label="از تاریخ">

            <b-form-input
                type="date"
                v-model="filter.fromDate"
            />

          </b-form-group>
        </b-col>


        <b-col md="3">
          <b-form-group label="تا تاریخ">

            <b-form-input
                type="date"
                v-model="filter.toDate"
            />

          </b-form-group>
        </b-col>


        <b-col md="3">
          <b-form-group label="وضعیت">

            <b-form-select
                v-model="filter.status"
                :options="statusOptions"
            />

          </b-form-group>
        </b-col>

      </b-row>


      <b-row>

        <b-col md="3">
          <b-form-group label="حداقل مبلغ">

            <b-form-input
                type="number"
                v-model="filter.minAmount"
            />

          </b-form-group>
        </b-col>


        <b-col md="3">
          <b-form-group label="حداکثر مبلغ">

            <b-form-input
                type="number"
                v-model="filter.maxAmount"
            />

          </b-form-group>
        </b-col>


        <b-col md="3">
          <b-form-group label="حساب">

            <account-tree-picker
                v-model="filter.accountId"
                @change="onAccountChanged"
            />


          </b-form-group>
        </b-col>


        <b-col md="3">
          <b-form-group label="دوره مالی">

            <b-form-input
                v-model="filter.periodId"
            />

          </b-form-group>
        </b-col>

      </b-row>


      <b-button
          type="submit"
          variant="primary"
      >
        جستجو
      </b-button>

      <b-button
          variant="secondary"
          class="mr-2"
          @click="reset"
      >
        پاک کردن
      </b-button>

    </b-form>

  </b-card>

</template>



<script>
import AccountTreePicker from "../picker/AccountTreePicker.vue"

export default{
  components:{
    AccountTreePicker
  },
  data(){

    return{

      filter:{
        documentNumber:null,
        fromDate:null,
        toDate:null,
        minAmount:null,
        maxAmount:null,
        status:null,
        accountId:null,
        periodId:null
      },

      statusOptions:[
        {value:null,text:"همه"},
        {value:"DRAFT",text:"پیش نویس"},
        {value:"POSTED",text:"ثبت شده"},
        {value:"CANCELLED",text:"باطل شده"}
      ]

    }

  },

  methods:{
    onAccountChanged(account) {
      this.selectedAccount = account
    },
    search(){

      this.$emit("search",this.filter)

    },

    reset(){

      this.filter={
        documentNumber:null,
        fromDate:null,
        toDate:null,
        minAmount:null,
        maxAmount:null,
        status:null,
        accountId:null,
        periodId:null
      }

      this.search()

    }

  }

}

</script>
