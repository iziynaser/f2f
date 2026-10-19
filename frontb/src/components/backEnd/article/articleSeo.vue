<template>
    <div>
        <b-container fluid>
            <b-row class="my-1">
                <label for="title">{{ this.$t('title') }}</label>
                <b-col sm="6"><b-input id="title" /></b-col>
            </b-row>
            <b-row>
                <label for="description">description</label>
                <b-textarea id="description"></b-textarea>
            </b-row>
            <b-row>
                <label for="keywords">keywords</label>
                <b-textarea id="keywords"></b-textarea>
            </b-row>
        </b-container>
    </div>
</template>

<script>
export default {
    name: 'articleSeo',
    props: {
    },
    data() {
        return {

        }
    },
    methods: {

    }
}
</script>

<style scoped></style>