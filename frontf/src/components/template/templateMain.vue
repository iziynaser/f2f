<template>
    <div>
        <b-card no-body>
            <b-tabs pills card>
                <b-tab :title="this.$t('result')">
                </b-tab>

                <b-tab :title="this.$t('main')">
                </b-tab>

                <b-tab :title="this.$t('admin')">
                </b-tab>

                <b-tab :title="this.$t('search')">
                </b-tab>

            </b-tabs>
        </b-card>
    </div>
</template>

<script>

export default {
    name: 'templateMain',
    props: {
    },
    data() {
        return {

        }
    },
    methods: {

    },
    components: {

    }
}
</script>

<style scoped></style>