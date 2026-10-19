<template>
    <div>
        blog is a history book
        //search on blogs base on keyword,subject,person
        <b-card no-body>
            <b-tabs pills card>
                <b-tab :title="this.$t('blog_mtab_search')">
                    list sorted by date
                    list sorted by topic

                </b-tab>
                <b-tab :title="this.$t('blog_mtab_main')">
                    //introduction about writer

                    title
                    header
                    footer
                    content
                    comments(like,dislike,answer)
                </b-tab>
                <b-tab :title="this.$t('blog_mtab_admin')">
                    disable
                    enable a person/blog/post
                    delete
                    mail box
                    fixed post

                    // create weblog group
                    every group can have a specific weblog
                    manage writers



                </b-tab>
                <b-tab :title="this.$t('blog_mtab_result')">

                </b-tab>

            </b-tabs>
        </b-card>
    </div>
</template>

<script>

export default {
    name: 'blogMain',
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