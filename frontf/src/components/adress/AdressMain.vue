<template>
    <div>
        <h5 class="mb-3">{{ $t('AdressMain_title') }}</h5>
        <b-card no-body>
            <b-tabs pills card vertical v-model="activeTab">
                <b-tab :title="$t('AdressMain_selectFromExisting')">
                    <AdressContent ref="content" />
                </b-tab>
                <b-tab :title="$t('AdressMain_addNewAdress')">
                    <AdressCreate @addressSaved="reloadAddresses" />
                </b-tab>
                <b-tab :title="$t('AdressMain_selectCompanyAdress')">
                    <AdressCompany />
                </b-tab>
            </b-tabs>
        </b-card>

    </div>
</template>

<script>

import AdressCreate from './AdressCreate.vue'
import AdressContent from './AdressContent.vue'
import AdressCompany from './AdressCompany.vue'

export default {
    name: 'AdressMain',
    components: {
        AdressCreate, AdressContent, AdressCompany
    },
    props: {
    },
    data() {
        return {
            activeTab: 0,
        }
    },
    methods: {
        reloadAddresses() {
            this.$refs.content.loadAdressDeliveryList();
            this.activeTab = 0; // بعد ذخیره، به تب اول برگردد
        }
    }
}
</script>

<style scoped></style>