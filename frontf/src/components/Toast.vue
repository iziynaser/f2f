<template>
    <b-toast :show="toast.show" :variant="toast.variant || 'info'" solid auto-hide :no-auto-hide="false" :delay="3000"
        toaster="b-toaster-bottom-left">
        {{ toast.text || '' }}
    </b-toast>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
    name: 'Toast',
    computed: {
        ...mapGetters('toast', ['toast'])
    }
};
</script>
