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
        <b-button>
            list
        </b-button>
    </div>
</template>

<script>
export default {
    name: 'FinAccountList',
    props: {
    },
    data() {
        return {
            form: {
                name: '',
                title: '',
            }
        }
    },
    methods: {

    }
}
</script>

<style scoped></style>