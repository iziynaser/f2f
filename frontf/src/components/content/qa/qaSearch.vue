<template>
    <div>
        <b-row class="my-1">
            <b-col>{{ this.$t('product_id') }}</b-col>
            <b-col>
                <b-input />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>{{ this.$t('fromDate') }}</b-col>
            <b-col>
                <b-input />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>{{ this.$t('toDate') }}</b-col>
            <b-col>
                <b-input />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                {{ $t('status') }}
                <!-- status : not replyed , replyed -->
            </b-col>
            <b-col>
                <b-form-select v-model="form.title" :options="form.titleoptions" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                {{ $t('type') }}
            </b-col>
            <b-col>
                <b-form-select v-model="form.typetitle" :options="form.type" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>whos question</b-col>
            <b-col>
                <b-input />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>whos replied</b-col>
            <b-col>
                <b-input />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>action</b-col>
            <b-col>
                <b-form-select v-model="form.actionTitle" :options="form.actions" />
            </b-col>
        </b-row>
        <b-input />
    </div>
</template>

<script>
export default {
    name: 'qaSearch',
    props: {
    },
    data() {
        return {
            visible: true,
            errors: [],
            form: {
                actionTitle: '',
                typetitle: '',
                type: [
                    { value: 'question', text: 'question' }, { value: 'reply', text: 'reply' }
                ],
                actions: [
                    { value: 'see detail', text: 'see detail' },
                    { value: 'approve qa', text: 'approve qa' },
                    { value: 'approve answer', text: 'approve answer' },
                    { value: 'decline aswer', text: 'decline aswer' },
                    { value: 'dcline qa', text: 'dcline qa' },
                    { value: 'delete', text: 'delete' },
                    { value: 'edit', text: 'edit' },
                    { value: 'change status to', text: 'change status to' },
                    { value: 'freez for', text: 'freez for' },
                    { value: 'disable for', text: 'disable for' },
                    { value: 'enable for', text: 'enable for' }
                ],
                title: '',
                name: '',
                address: '',
                description: '',
                titleoptions: [
                    { value: 'reply', text: 'reply' },
                    { value: 'not reply', text: 'not reply' }
                ]
            }
        }
    },
    methods: {

    }
}
</script>

<style scoped></style>