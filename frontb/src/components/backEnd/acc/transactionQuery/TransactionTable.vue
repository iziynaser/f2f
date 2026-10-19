<template>

  <b-table
      striped
      hover
      :items="items"
      :fields="fields"
      @row-click:row="rowClicked"
  />

</template>


<script>

export default{

  props:["items"],

  data(){

    return{

      fields:[

        {key:"id",label:"شماره سند"},
        {key:"documentNumber",label:"شماره"},
        {key:"transactionDate",label:"تاریخ"},
        {key:"description",label:"شرح"},
        {key:"totalAmount",label:"مبلغ"},
        {key:"status",label:"وضعیت"}

      ]

    }

  },

  methods:{

    rowClicked(row){

      this.$emit("select",row)

    }

  }

}

</script>
