<template>
    <div>
        <b-card-group deck>
            <b-card no-body class="overflow-hidden" style="max-width: 540px;">
                <b-row no-gutters>
                    <b-col md="6">
                        <!-- <b-card-img src="http://localhost:8080/images/logo/logo.png" alt="" class="rounded-0"></b-card-img> -->
                    </b-col>
                    <b-col md="6">
                        <b-list-group flush>
                            <b-card-body :title="this.$t('new_features')">
                            </b-card-body>
                            <b-list-group-item>content</b-list-group-item>
                            <b-list-group-item>hr</b-list-group-item>
                            <b-list-group-item>accounting</b-list-group-item>
                            <b-list-group-item>site</b-list-group-item>
                        </b-list-group>
                        <b-list-group flush>
                            <b-list-group-item>
                                <b-card-body title="bug fixes">
                                    <b-card-text>
                                        gfhfghdfgh
                                        fgjhghjfghj
                                        fghfghfgfgh
                                    </b-card-text>
                                </b-card-body>
                            </b-list-group-item>
                        </b-list-group>
                    </b-col>
                </b-row>
            </b-card>

            <b-card title="f2f version" img-src="http://localhost:8080/images/logo/logo.png" img-alt="image" img-top
                tag="article" style="max-width:20 rem;" class="mb-2">
                <b-card-text>
                    1.0
                </b-card-text>
            </b-card>
        </b-card-group>
    </div>
</template>

<script>


export default {
    name: 'appInfo',
    data() {
        return {
            form: {

            },
        }
    },
    methods: {

    },
    created() {

    }
}


</script>

<style scoped></style>
