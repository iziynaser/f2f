<template>
    <div>
        <b-row class="my-1">
            <b-col>
                fin account type
            </b-col>
            <b-col>
                <b-form-select v-model="form.finaccounttype" :options="finaccounttype"></b-form-select>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                {{ this.$t('status') }}
            </b-col>
            <b-col>
                <b-form-select v-model="form.status" :options="status"></b-form-select>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>fin account name</b-col>
            <b-col>
                <b-input type="text" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>fin account code</b-col>
            <b-col>
                <b-input type="text" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                fin account pin
            </b-col>
            <b-col>
                <b-input type="text" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                currency
            </b-col>
            <b-col>
                <b-form-select v-model="form.currency" :options="currency"></b-form-select>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                {{ $t('CONTENT_CREATE_purpose') }}
            </b-col>
            <b-col>
                <b-form-select v-model="form.purposeType" :options="purposeTypeOptions">
                </b-form-select>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                {{ $t('CONTENT_CREATE_fromDate') }}
            </b-col>
            <b-col>
                <b-input v-model="form.fromDate" type="date"></b-input>
            </b-col>
        </b-row>
        <b-row>
            <b-col>
                {{ $t('CONTENT_CREATE_toDate') }}
            </b-col>
            <b-col>
                <b-input v-model="form.toDate" type="date"></b-input>
            </b-col>
        </b-row>
        <b-row>
            <b-col>
                actual balance
            </b-col>
            <b-col>
                6456456
            </b-col>
        </b-row>
        <b-row>
            <b-col>
                available balance
            </b-col>
            <b-col>
                45345
            </b-col>
        </b-row>
        <b-button>
            {{ $t('save') }}
        </b-button>
    </div>
</template>

<script>
export default {
    name: 'FinAccount',
    props: {
    },
    data() {
        return {
            purposeTypeOptions: [
                { value: 0, text: 'select a purpose' },
                { value: 0, text: 'company info' },
                { value: 0, text: 'general Info' },
                { value: 0, text: 'product Info' },
                { value: 0, text: 'project Info' },
                { value: 0, text: 'sub content' },
                { value: 0, text: 'topic' },
                { value: 0, text: 'feedback' },
                { value: 0, text: 'advertisement' },
                { value: 0, text: 'main content' },
                { value: 0, text: 'article' },
                { value: 0, text: 'comment' },
                { value: 0, text: 'description' },
                { value: 0, text: 'ledgal info' },
                { value: 0, text: 'response' },
                { value: 0, text: 'faq' },
                { value: 0, text: 'owner' },
                { value: 0, text: 'user' },
                { value: 0, text: 'personal info' },
            ], currency: [
                { value: 0, text: 'dollar' },
                { value: 1, text: 'rial' },
                { value: 2, text: 'shahi' },
                { value: 3, text: 'darhem' },
            ],
            status: [
                { value: 0, text: 'active' },
                { value: 1, text: 'negative pending relenishment' },
                { value: 2, text: 'manually frozen' },
                { value: 3, text: 'cancelled' },
            ],
            finaccounttype: [
                { value: 0, text: 'bank account' },
                { value: 1, text: 'credit card account' },
                { value: 2, text: 'deposite account' },
                { value: 3, text: 'equitty line account' },
                { value: 4, text: 'gift certificate' },
                { value: 5, text: 'investment account' },
                { value: 6, text: 'replenish account' },
                { value: 7, text: 'service credit account' },
                { value: 8, text: 'store credit account' }
            ],
            form: {
                name: '',
                title: '',
                description: '',
                seq: '',
                fromDate: '',
                toDate: '',
                contentType: '',
                purposeType: '',
                isPublic: '',
            }
        }
    },
    methods: {

    }
}
</script>

<style scoped></style>