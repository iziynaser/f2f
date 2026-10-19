<template>
  <div>
    <b-input-group>
      <b-form-input
          readonly
          :disabled="disabled"
          :value="displayValue"
          placeholder="انتخاب حساب"
          @click="open"
      />
      <b-input-group-append>
        <b-button variant="outline-secondary" :disabled="disabled" @click="open">
          انتخاب
        </b-button>
        <b-button v-if="value" variant="outline-danger" :disabled="disabled" @click="clearSelection">
          پاک
        </b-button>
      </b-input-group-append>
    </b-input-group>

    <!-- مودال شخصی‌سازی‌شده -->
    <div v-if="show" class="modal-overlay" @click.self="close">
      <div class="modal-dialog modal-lg" @click.stop>
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">انتخاب حساب</h5>
            <button type="button" class="close" @click="close">&times;</button>
          </div>

          <div class="modal-body">
            <b-form-input
                v-model="search"
                placeholder="جستجوی حساب..."
                class="mb-2"
            />
            <div class="tree-box">
              <account-tree-node
                  v-for="acc in filteredTree"
                  :key="'node-' + acc.id"
                  :account="acc"
                  :selected-id="currentSelected ? currentSelected.id : null"
                  @select="selectNode"
                  @confirm="confirmNode"
              />
            </div>
          </div>

          <div class="modal-footer">
            <b-button variant="secondary" @click="close">بستن</b-button>
            <b-button variant="primary" :disabled="!canConfirm" @click.prevent="confirmSelection">
              تایید
            </b-button>
          </div>
        </div>
      </div>
      <!-- backdrop -->
      <div class="modal-backdrop fade show"></div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex"
import AccountTreeNode from "./AccountTreeNode.vue"

export default {
  name: "AccountTreePicker",
  components: { AccountTreeNode },
  props: {
    title: String,
    value: [Number, String],
    disabled: { type: Boolean, default: false }
  },
  data() {
    return {
      show: false,
      search: "",
      loaded: false,
      selectedAccount: null,
      currentSelected: null
    }
  },
  computed: {
    ...mapGetters("account", ["tree", "loading"]),
    displayValue() {
      if (!this.selectedAccount) return ""
      return this.selectedAccount.code + " - " + this.selectedAccount.name
    },
    canConfirm() {
      if (!this.currentSelected) return false
      // فقط گره‌های برگ (بدون فرزند) قابل تأیید هستند
      return !this.currentSelected.children || this.currentSelected.children.length === 0
    },
    filteredTree() {
      if (!this.search) return this.tree
      const term = this.search.toLowerCase()
      const filter = nodes =>
          nodes
              .map(n => {
                const children = n.children ? filter(n.children) : []
                if (
                    (n.code && n.code.toLowerCase().includes(term)) ||
                    (n.name && n.name.toLowerCase().includes(term)) ||
                    children.length
                ) {
                  return { ...n, children }
                }
                return null
              })
              .filter(Boolean)
      return filter(this.tree)
    }
  },
  watch: {
    async value(v) {
      if (!v) {
        this.selectedAccount = null
        return
      }
      if (!this.loaded) {
        await this.$store.dispatch("account/fetchTree")
        this.loaded = true
      }
      this.selectedAccount = this.findAccountById(this.tree, v)
    }
  },
  methods: {
    findAccountById(nodes, id) {
      if(!nodes){
        return null;
      }
      for (const n of nodes) {
        if (String(n.id) === String(id)) return n
        if (n.children) {
          const f = this.findAccountById(n.children, id)
          if (f) return f
        }
      }
      return null
    },
    async open() {
      if (this.disabled) return
      if (!this.loaded) {
        await this.$store.dispatch("account/fetchTree")
        this.loaded = true
      }
      this.currentSelected = this.selectedAccount
      this.show = true
    },
    close() {
      console.log('this close is called')
      this.show = false
    },
    selectNode(account) {
      this.currentSelected = account
    },
    confirmNode(account) {
      // اگر گره دارای فرزند بود، کاری نکن (صرفاً expand/collapse)
      if (account.children && account.children.length) return
      this.currentSelected = account
      this.confirmSelection()
    },
    confirmSelection() {
      if (!this.canConfirm) return
      this.selectedAccount = this.currentSelected
      this.$emit("input", this.selectedAccount.id)
      this.$emit("change", this.selectedAccount)
      this.close()
    },
    clearSelection() {
      this.selectedAccount = null
      this.currentSelected = null
      this.$emit("input", null)
      this.$emit("change", null)
    }
  }
}
</script>

<style scoped>
.tree-box {
  max-height: 400px;
  overflow: auto;
  border: 1px solid #ddd;
  padding: 10px;
  border-radius: 4px;
}

.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 1050;
}

.modal-dialog {
  z-index: 1060;
}
</style>
