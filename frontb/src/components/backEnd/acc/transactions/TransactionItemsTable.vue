<template>
  <div>
    <div class="d-flex justify-content-between align-items-center mb-2">
      <div class="h6 mb-0">اقلام سند</div>
      <b-button v-if="!readonly" size="sm" variant="outline-primary" @click="addLine">
        + افزودن سطر
      </b-button>
    </div>

    <b-table-simple bordered responsive small class="text-center">
      <b-thead head-variant="light">
        <b-tr>
          <b-th style="width: 30%">حساب</b-th>
          <b-th style="width: 15%">بدهکار</b-th>
          <b-th style="width: 15%">بستانکار</b-th>
          <b-th>شرح سطر</b-th>
          <b-th v-if="!readonly" style="width: 70px">حذف</b-th>
        </b-tr>
      </b-thead>

      <b-tbody>
        <b-tr v-for="(line, idx) in internalValue" :key="line.uid || idx">
          <b-td class="text-right">

            <AccountTreePicker
                id="tree-picker"
                v-model="line.accountId"
                :disabled="readonly"
            />

          </b-td>

          <b-td>
            <b-form-input
                type="number"
                min="0"
                v-model.number="line.debit"
                :disabled="readonly"
                @input="onDebitInput(line)"
            />
          </b-td>

          <b-td>
            <b-form-input
                type="number"
                min="0"
                v-model.number="line.credit"
                :disabled="readonly"
                @input="onCreditInput(line)"
            />
          </b-td>

          <b-td class="text-right">
            <b-form-input v-model.trim="line.description" :disabled="readonly" />
          </b-td>

          <b-td v-if="!readonly">
            <b-button size="sm" variant="danger" @click="removeLine(idx)">×</b-button>
          </b-td>
        </b-tr>
      </b-tbody>
    </b-table-simple>
  </div>
</template>

<script>

import AccountTreePicker from "../picker/AccountTreePicker.vue";

export default {
  name: "TransactionItemsTable",
  components:{
    AccountTreePicker
  },
  props: {
    value: { type: Array, required: true }, // v-model
    readonly: { type: Boolean, default: false },
  },
  data() {
    return {
      internalValue: this.clone(this.value),
    };
  },
  computed: {
    accountOptions() {
      if (this.$store && this.$store.getters && this.$store.getters.accountsOptions) {
        return this.$store.getters.accountsOptions;
      }

      return [{ value: null, text: "انتخاب حساب..." }];
    },
  },
  methods: {
    clone(v) {
      return JSON.parse(JSON.stringify(v || []));
    },
    emitAll() {
      this.$emit("input", this.clone(this.internalValue));
      this.emitTotals();
    },
    emitTotals() {
      const debit = this.internalValue.reduce((s, l) => s + (Number(l.debit) || 0), 0);
      const credit = this.internalValue.reduce((s, l) => s + (Number(l.credit) || 0), 0);
      this.$emit("totals", { debit, credit });
    },
    addLine() {
      let r = Math.floor(Math.random()*100)+1
      this.internalValue.push({
        uid: r,
        id: r, accountId: null, debit: 0, credit: 0, description: "" });
      this.emitAll();
      console.log(r)
    },
    removeLine(idx) {
      this.internalValue.splice(idx, 1);
      if (!this.internalValue.length) this.addLine();
      else this.emitAll();
    },
    onDebitInput(line) {
      const debit = Number(line.debit) || 0;
      if (debit > 0) line.credit = 0; // جلوگیری از debit+credit همزمان
      this.emitAll();
    },
    onCreditInput(line) {
      const credit = Number(line.credit) || 0;
      if (credit > 0) line.debit = 0;
      this.emitAll();
    },
  },
  watch: {
    value: {
      deep: true,
      handler(v) {
        if(JSON.stringify(v) !== JSON.stringify(this.internalValue)){
          this.internalValue = this.clone(v);
          this.emitTotals();
        }
      },
    },    
  },
  mounted() {
    this.emitTotals();
    if(!this.internalValue || this.internalValue.length === 0)
      this.addLine();
    console.log(this.internalValue)
  },
};
</script>
