<template>
  <div class="d-flex justify-content-end" style="gap: 8px;">
    <!-- DRAFT -->
    <template v-if="tx.transactionStatus === 'DRAFT'">
      <b-button variant="success" @click="$emit('save')">ذخیره</b-button>
      <b-button variant="primary" :disabled="!tx.id || !isBalanced" @click="$emit('post')">
        ثبت قطعی (POST)
      </b-button>
      <b-button variant="outline-danger" v-if="tx.id" @click="$emit('delete')">حذف</b-button>
      <b-button variant="outline-warning" v-if="tx.id" @click="$emit('cancel')">لغو</b-button>
    </template>

    <!-- POSTED -->
    <template v-else-if="tx.transactionStatus === 'POSTED'">
      <b-button variant="warning" @click="$emit('lock')">قفل (LOCK)</b-button>
      <b-button variant="danger" @click="$emit('reverse')">صدور سند معکوس (REVERSE)</b-button>
    </template>

    <!-- LOCKED / REVERSED / CANCELLED -->
    <template v-else>
      <b-alert show variant="info" class="mb-0">
        این سند در وضعیت <strong>{{ tx.transactionStatus }}</strong> فقط قابل مشاهده است.
      </b-alert>
    </template>
  </div>
</template>

<script>
export default {
  props: {
    tx: { type: Object, required: true },
    isBalanced: { type: Boolean, default: false },
    isEditable: { type: Boolean, default: false },
  },
};
</script>
