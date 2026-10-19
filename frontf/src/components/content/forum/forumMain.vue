<template>
    <div>
        forum
        <b-card no-body>
            <b-tabs pills card>
                <b-tab :title="this.$t('search')">
                    list of posts ,
                    categories
                </b-tab>
                <b-tab title="main">
                    isAnonymous
                    trees,
                    can edit or delete his post ,
                    can other download posts or files
                    move/devide a topic or post
                    forum icon
                    forum name
                    report a post is not suitable
                </b-tab>
                <b-tab title="topics">
                    title,content,categorylist,
                    forumlist
                </b-tab>
                <b-tab title="threads">
                </b-tab>
                <b-tab title="add/remove people to forum">
                </b-tab>
                <b-tab :title="this.$t('content')">
                    content
                </b-tab>
                <b-tab title="results">
                    list of updated topics,
                    new topics,
                    most viewed topics

                    //liks , browse
                    name of forum
                    number of topics (number)
                    latest topic (date)

                </b-tab>
            </b-tabs>
        </b-card>
    </div>
</template>

<script>

export default {
    name: 'forumMain',
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