<template>

  <b-modal
      ref="modal"
      :title="mode==='create' ? 'ایجاد حساب' : 'ویرایش حساب'"
      hide-footer
  >

    <b-form @submit.prevent="save">

      <b-form-group label="نام حساب">
        <b-form-input
            v-model="form.name"
            required
        />
      </b-form-group>

      <b-form-group label="توضیحات">
        <b-form-textarea
            v-model="form.description"
        />
      </b-form-group>

      <b-form-checkbox v-model="form.postable">
        قابل ثبت
      </b-form-checkbox>

      <b-form-checkbox v-model="form.active">
        فعال
      </b-form-checkbox>

      <div class="mt-3">

        <b-button
            type="submit"
            variant="success"
        >
          ذخیره
        </b-button>

        <b-button
            variant="secondary"
            class="mr-2"
            @click="close"
        >
          انصراف
        </b-button>

      </div>

    </b-form>

  </b-modal>

</template>

<script>

export default {

  name: "AccountFormModal",

  data() {
    return {

      mode: "create",
      parent: null,
      editId: null,

      form: {
        name: "",
        description: "",
        postable: true,
        active: true
      }

    }
  },

  methods: {

    openCreate(parent) {

      this.mode = "create"
      this.parent = parent
      this.editId = null

      this.form = {
        name: "",
        description: "",
        postable: true,
        active: true
      }

      this.$refs.modal.show()

    },

    openEdit(account) {

      this.mode = "edit"
      this.editId = account.id

      this.form = {
        name: account.name,
        description: account.description,
        postable: account.postable,
        active: account.active
      }

      this.$refs.modal.show()

    },

    close() {
      this.$refs.modal.hide()
    },

    async save() {

      if (this.mode === "create") {

        let payload = {
          name: this.form.name,
          description: this.form.description,
          postable: this.form.postable,
          active: this.form.active,
          parentId: null
        }

        if (this.parent) {
          payload.parentId = this.parent.id
        }

        await this.$store.dispatch("accounts/createAccount", payload)

      } else {

        await this.$store.dispatch("accounts/updateAccount", {
          id: this.editId,
          payload: this.form
        })

      }

      this.close()

      this.$emit("saved")

    }

  }

}

</script>
