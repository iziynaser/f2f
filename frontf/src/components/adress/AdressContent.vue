<template>
    <div>
        <b-spinner small v-if="isLoading" label="Loading..."></b-spinner>

        <h6>{{ $t('AdressContent_selectDeliveryAdress') }}</h6>
        <hr />

        <div v-if="deliveryList.length > 0">
            <b-card v-for="address in deliveryList" :key="address.id" class="mb-3 shadow-sm">
                <b-card-title>
                    <i>{{ $t('AdressContent_chooseThisAdress') }}</i>
                    <hr />
                </b-card-title>

                <b-card-text>
                    <b-icon icon="house-door" />
                    <b>
                        {{ address.ostanName }} {{ address.shahrName }}
                        {{ address.postalAddress }}
                    </b><br />
                    {{ $t('Adress_VAHED') }}: {{ address.unit }} |
                    {{ $t('Adress_PELAK') }}: {{ address.pelak }}
                </b-card-text>

                <b-card-body>
                    <b-row>
                        <b-col><b-icon icon="phone" /> {{ address.mobileNo1 }}</b-col>
                    </b-row>
                    <b-row>
                        <b-col><b-icon icon="people-circle" /> {{ address.deliverName }} {{ address.deliverFamily
                            }}</b-col>
                    </b-row>
                    <b-row>
                        <b-col><b-icon icon="envelope" /> {{ address.postalCode }}</b-col>
                    </b-row>

                    <b-row class="mt-2">
                        <b-col>
                            <b-link @click="editDelivery(address)">{{ $t('AdressContent_edit') }}</b-link>
                            <span class="mx-2">|</span>
                            <b-link @click="deleteDelivery(address)">{{ $t('AdressContent_delete') }}</b-link>
                        </b-col>
                    </b-row>

                    <b-button variant="primary" class="mt-3 w-100" @click="selectAddress(address)">
                        {{ $t('AdressContent_select') }}
                    </b-button>
                </b-card-body>
            </b-card>
        </div>

        <div v-else-if="!isLoading">
            <b-alert show variant="info">{{ $t('AdressContent_noDeliveryFound') }}</b-alert>
        </div>
    </div>
</template>

<script>
import axiosInstance from '@/api/axiosInstance';

export default {
    name: 'AdressContent',
    data() {
        return {
            isLoading: false,
            deliveryList: []
        };
    },
    methods: {
        async selectAddress(address) {
            try {
                await this.$store.dispatch('delivery/setDefaultDelivery', address.id);
                this.$router.push('/delivery');
            } catch (err) {
                console.error(err);
                this.$store.dispatch('toast/triggerToast', {
                    text: this.$t('AdressContent_selectFailed'),
                    variant: 'danger'
                }, { root: true });
            }
        },

        getUserId() {
            return localStorage.getItem('userId') || 1;
        },

        async loadAdressDeliveryList() {
            this.isLoading = true;
            const userId = this.getUserId();
            try {
                const res = await axiosInstance.get(`/delivery/user/${userId}`);
                this.deliveryList = res.data;
            } catch (err) {
                console.error(err);
                this.$store.dispatch('toast/triggerToast', {
                    text: this.$t('AdressContent_loadFailed'),
                    variant: 'danger'
                }, { root: true });
            } finally {
                this.isLoading = false;
            }
        },

        async deleteDelivery(address) {
            const confirmDelete = confirm(this.$t('AdressContent_confirmDelete'));
            if (!confirmDelete) return;

            try {
                await axiosInstance.delete(`/delivery/${address.id}/user/${address.userAccountId}`);
                this.deliveryList = this.deliveryList.filter(d => d.id !== address.id);
                this.$store.dispatch('toast/triggerToast', {
                    text: this.$t('AdressContent_deleted'),
                    variant: 'success'
                }, { root: true });
            } catch (err) {
                console.error(err);
                this.$store.dispatch('toast/triggerToast', {
                    text: this.$t('AdressContent_deleteFailed'),
                    variant: 'danger'
                }, { root: true });
            }
        },

        editDelivery(address) {
            this.$emit('editDelivery', address);
        }
    },
    created() {
        this.loadAdressDeliveryList();
    }
};
</script>
