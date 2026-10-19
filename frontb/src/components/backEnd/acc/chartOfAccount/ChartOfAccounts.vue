<template>

  <div class="container-fluid rtl">

    <b-row>

      <b-col cols="5">

        <h5 class="mb-3">چارت حساب ها</h5>

        <account-tree
            :nodes="tree"
            :selected-id="selectedId"
            @select="selectAccount"
        />

      </b-col>

      <b-col cols="3">

        <b-card>

          <h6 class="mb-3">عملیات</h6>

          <b-button
              block
              variant="success"
              class="mb-2"
              :disabled="!selected"
              @click="createChild"
          >
            افزودن زیر حساب
          </b-button>

          <b-button
              block
              variant="primary"
              class="mb-2"
              :disabled="!selected"
              @click="editAccount"
          >
            ویرایش
          </b-button>

          <b-button
              block
              variant="danger"
              :disabled="!selected"
              @click="deleteAccountAction"
          >
            حذف
          </b-button>

        </b-card>

      </b-col>

      <b-col>

        <b-card v-if="selected">

          <h5>{{selected.name}}</h5>

          <p>کد حساب : {{selected.code}}</p>

          <p>سطح : {{selected.accountLevel}}</p>

        </b-card>

      </b-col>

    </b-row>

    <account-form-modal
        ref="formModal"
        @saved="loadTree"
    />

  </div>

</template>

<script>

import { mapGetters } from "vuex"

import AccountTree from "./AccountTree.vue"
import AccountFormModal from "./AccountFormModal.vue"

export default {

  name: "ChartOfAccounts",

  components: {
    AccountTree,
    AccountFormModal
  },

  data() {
    return {
      selected: null
    }
  },

  computed: {

    ...mapGetters("account", [
      "tree",
      "loading"
    ]),

    selectedId() {

      if (!this.selected) {
        return null
      }

      return this.selected.id

    }

  },

  mounted() {
    this.loadTree()
  },

  methods: {

    async loadTree() {
      await this.$store.dispatch("account/fetchTree")
    },

    selectAccount(node) {
      this.selected = node
    },

    createChild() {
      this.$refs.formModal.openCreate(this.selected)
    },

    editAccount() {
      this.$refs.formModal.openEdit(this.selected)
    },

    async deleteAccountAction() {

      if (!this.selected) {
        return
      }

      if (!confirm("حذف حساب انجام شود؟")) {
        return
      }

      await this.$store.dispatch(
          "account/deleteAccount",
          this.selected.id
      )

      this.selected = null

    }

  }

}

</script>

<style>

.rtl{
  direction:rtl;
  text-align:right;
}

</style>
