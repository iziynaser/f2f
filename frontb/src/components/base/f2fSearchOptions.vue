<template>
    <div>
        <b-row align-h="start" align-content="center" v-align="start" class="my-1">
            <b-col offset="0" align-self="center" sm="1">{{ this.optionText }}</b-col>
            <b-col offset="0" align-self="center" sm="2">
                <b-form-select v-model="selected" style="margin-left:0" class="m-2">
                    <b-form-select-option value=" 1">{{ this.$t('contains') }}</b-form-select-option>
                    <b-form-select-option value="2">{{ this.$t('equals') }}</b-form-select-option>
                    <b-form-select-option value="3">{{ this.$t('begins_with') }}</b-form-select-option>
                    <b-form-select-option value="4">{{ this.$t('is_empty') }}</b-form-select-option>
                    <b-form-select-option value="5">{{ this.$t('not_equal') }}</b-form-select-option>
                </b-form-select>
            </b-col>
            <b-col offset="0" align-self="center" sm="3">
                <input type="text" id="invoiceId" class="m-3" name="invoiceId" />
            </b-col>
        </b-row>
    </div>
</template>

<script>
export default {
    name: 'f2fSearchOptions',
    props: {
        optionText: String
    },
    data() {
        return {
            selected: null
        }
    },
    methods: {

    }
}
</script>

<style scoped></style>