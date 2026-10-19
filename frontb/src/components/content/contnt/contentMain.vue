<template>
    <div>
        content
        <b-card no-body>
            <b-tabs pills card>

                <b-tab :title="this.$t('CONTENT_MAIN_search')">
                    <contentSearch />
                </b-tab>

                <b-tab :title="this.$t('CONTENT_MAIN_base')">
                    <contentCreate />
                </b-tab>
                <b-tab :title="this.$t('CONTENT_MAIN_editor')">
                    <contentEditor />
                </b-tab>
                <b-tab :title="this.$t('CONTENT_MAIN_menus')">
                    <contentMenus />
                </b-tab>

                <b-tab :title="this.$t('CONTENT_MAIN_category')">
                    <contentCategories />
                </b-tab>

                <b-tab :title="this.$t('CONTENT_MAIN_tags')">
                    <contentTags />
                </b-tab>

                <b-tab :title="this.$t('CONTENT_MAIN_seo')">
                </b-tab>
                <b-tab :title="this.$t('users')">
                    <contentUsers />
                </b-tab>
                <b-tab :title="this.$t('status')">
                    <contentStatus />
                </b-tab>

                <!-- 
                        <b-tab title="CMS">
                            <cms/>
                        </b-tab> -->


            </b-tabs>
        </b-card>
    </div>
</template>

<script>

import contentEditor from './contentEditor'
import contentCreate from './contentCreate'
import contentTags from './contentTags'
import contentCategories from './contentCategories'
import contentMenus from './contentMenus'
import contentSearch from './contentSearch'
import contentUsers from './contentUsers'
import contentStatus from './contentStatus'
// import cms from './cms'

export default {
    name: 'contentMain',
    props: {
    },
    data() {
        return {

        }
    },
    methods: {

    },
    components: {
        contentEditor,
        contentCreate,
        contentTags,
        contentCategories,
        contentMenus,
        contentSearch,
        contentUsers,
        contentStatus,
        // cms
    }
}
</script>

<style scoped></style>