<b-button
    variant="danger"
    size="sm"
    @click="openReverseModal"
    v-if="transaction.transactionStatus === 'POSTED'"
>
Reverse Transaction
</b-button>
