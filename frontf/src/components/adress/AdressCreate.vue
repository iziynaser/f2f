<template>
    <div>
        <b-form @submit.prevent="saveForm">
            <b-form-group>
                <!-- استان -->
                <b-row class="my-1">
                    <b-col>{{ $t('Adress_OSTAN') }}</b-col>
                    <b-col>
                        <b-form-select v-model="form.ostanId" @change="loadCity">
                            <template v-slot:first>
                                <b-form-select-option :value="null" disabled>
                                    {{ $t('select_ostan') }}
                                </b-form-select-option>
                            </template>
                            <b-form-select-option v-for="ostan in ostanList" :key="ostan.id" :value="ostan.id">
                                {{ ostan.name }}
                            </b-form-select-option>
                        </b-form-select>
                    </b-col>
                </b-row>

                <!-- شهر -->
                <b-row class="my-1">
                    <b-col>{{ $t('Adress_SHAHR') }}</b-col>
                    <b-col>
                        <b-form-select v-model="form.shahrId">
                            <template v-slot:first>
                                <b-form-select-option :value="null" disabled>
                                    {{ $t('select_shahr') }}
                                </b-form-select-option>
                            </template>
                            <b-form-select-option v-for="shahr in shahrList" :key="shahr.id" :value="shahr.id">
                                {{ shahr.name }}
                            </b-form-select-option>
                        </b-form-select>
                    </b-col>
                </b-row>

                <!-- سایر فیلدها -->
                <b-row class="my-1" v-for="(label, key) in formFields" :key="key">
                    <b-col>{{ $t(label) }}</b-col>
                    <b-col>
                        <b-form-input v-model="form[key]" type="text" />
                    </b-col>
                </b-row>
            </b-form-group>

            <b-button variant="primary" type="submit">{{ $t('save') }}</b-button>
        </b-form>
    </div>
</template>

<script>
import axiosInstance from '@/api/axiosInstance';

export default {
    name: 'AdressCreate',
    data() {
        return {
            form: {
                ostanId: '',
                shahrId: '',
                postalAddress: '',
                pelak: '',
                unit: '',
                postalCode: '',
                deliverName: '',
                deliverFamily: '',
                nationalCode: '',
                mobileNo1: '',
                mobileNo2: '',
                whoisGetter: '',
                latitude: '',
                longitude: ''
            },
            ostanList: [],
            shahrList: [],
            formFields: {
                postalCode: 'Adress_POSTAL_CODE',
                postalAddress: 'Adress_POSTAL_ADDRESS',
                pelak: 'Adress_PELAK',
                unit: 'Adress_VAHED',
                mobileNo1: 'Adress_mobile1',
                mobileNo2: 'Adress_mobile2',
                deliverName: 'Adress_name',
                deliverFamily: 'Adress_family',
                whoisGetter: 'Adress_is_getter_myself',
                nationalCode: 'Adress_nationalCode'
            }
        };
    },
    methods: {
        async loadOstan() {
            try {
                const res = await axiosInstance.get('/ostan/list');
                this.ostanList = res.data;
            } catch (error) {
                console.error(error);
                this.showToast(this.$t('Adress_ostanLoadFailed'), 'danger');
            }
        },
        async loadCity() {
            if (!this.form.ostanId) return;
            try {
                const res = await axiosInstance.get('/shahr/list', {
                    params: { id: this.form.ostanId }
                });
                this.shahrList = res.data;
            } catch (error) {
                console.error(error);
                this.showToast(this.$t('Adress_shahrLoadFailed'), 'danger');
            }
        },
        async saveForm() {
            try {
                await axiosInstance.post('/delivery/save', this.form);
                this.showToast(this.$t('Adress_saved'), 'success');
                this.$emit('addressSaved');
            } catch (err) {
                console.error(err);
                this.showToast(this.$t('Adress_saveFailed'), 'danger');
            }
        },
        showToast(message, variant) {
            this.$store.dispatch('toast/triggerToast', {
                text: message,
                variant: variant || 'info'
            }, { root: true });
        }
    },
    created() {
        this.loadOstan();
    }
};
</script>

<style scoped>
/* اختیاری: برای بهبود استایل */
</style>
