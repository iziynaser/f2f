<template>
    <b-container fluid>
        <b-row align-h="start" align-v="stretch" class="my-1">
            <b-col sm="3">
                <b-form-input v-model="lkdata[0]" :placeholder="placeHolderCode" />
            </b-col>
            <b-col sm="7">
                <b-form-input v-model="lkdata[1]" :placeholder="placeHolderValue" />
            </b-col>
            <b-col sm="1">
                <b-button variant="primary" @click="showModalForm">
                    <b-icon icon="text-center"></b-icon>
                </b-button>
            </b-col>
        </b-row>
    </b-container>
</template>

<script>


export default {
    name: 'tPerson',
    components: {
    },
    props: {
        modalFormName: String,
        lkdata: [],
        id: String,
        placeHolderCode: String,
        placeHolderValue: String
    },
    data() {
        return {
        }
    },
    methods: {
        showModalForm() {
            console.log("modal form =" + this.id);
            this.$bvModal.show(this.id);
        },
    },
    created() {
    },
}
</script>

<style scoped></style>