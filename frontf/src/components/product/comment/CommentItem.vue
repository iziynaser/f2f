<template>
    <b-list-group-item>
        <b-row>
            <div>
                <b-row>

                </b-row>
            </div>
            <!-- سمت چپ: مشخصات کاربر -->
            <b-col cols="12" md="3" class="text-center text-md-left mb-2 mb-md-0">
                <b-avatar size="4rem" variant="secondary" class="mb-2" :src="comment.avatar || defaultAvatar" />
                <div><b>{{ comment.nickName || 'مهمان' }}</b></div>
                <div class="text-muted" style="font-size: 0.85rem;">
                    {{ fromNow(comment.dateCreated) }}
                </div>
            </b-col>

            <!-- سمت راست: متن و مزایا/معایب -->
            <b-col cols="12" md="9">
                <div class="font-weight-bold mb-2">{{ comment.subject }}</div>

                <!-- مزایا -->
                <div v-if="comment.benefits && comment.benefits.length">
                    <div class="text-success font-weight-bold mb-1">
                        <b-icon icon="hand-thumbs-up-fill" class="mr-1" /> مزایا
                    </div>
                    <b-list-group horizontal flush class="mb-2">
                        <b-list-group-item v-for="ben in comment.benefits" :key="ben" class="p-1 px-2">
                            {{ ben }}
                        </b-list-group-item>
                    </b-list-group>
                </div>

                <!-- معایب -->
                <div v-if="comment.upsets && comment.upsets.length">
                    <div class="text-danger font-weight-bold mb-1">
                        <b-icon icon="hand-thumbs-down-fill" class="mr-1" /> معایب
                    </div>
                    <b-list-group horizontal flush class="mb-2">
                        <b-list-group-item v-for="up in comment.upsets" :key="up" class="p-1 px-2">
                            {{ up }}
                        </b-list-group-item>
                    </b-list-group>
                </div>

                <!-- متن -->
                <div v-html="comment.content" class="my-2"></div>

                <!-- آیا این نظر مفید بود؟ -->
                <div class="mt-3">
                    <span>{{ $t('this_post_is_useful') }}</span>
                    <b-button @click="vote('DISLIKE')" size="sm" variant="outline-danger" class="ml-2">
                        {{ $t('no') }}
                        <b-badge variant="danger" pill class="ml-1">{{ getReactionCount('DISLIKE') }}</b-badge>
                    </b-button>
                    <b-button @click="vote('LIKE')" size="sm" variant="outline-success">
                        {{ $t('yes') }}
                        <b-badge variant="success" pill class="ml-1">{{ getReactionCount('LIKE') }}</b-badge>
                    </b-button>
                </div>
            </b-col>
        </b-row>
    </b-list-group-item>
</template>

<script>
//import dayjs from 'dayjs'
//import relativeTime from 'dayjs/plugin/relativeTime'
//import 'dayjs/locale/fa'

//dayjs.extend(relativeTime)
//dayjs.locale('fa')

export default {
    name: 'CommentItem',
    components: {
    },
    props: {
        comment: Object
    },
    data() {
        return {
            defaultAvatar: ''
        }
    },
    methods: {
        getReactionCount(type) {
            if (this.comment && Array.isArray(this.comment.reactionSummary)) {
                const entry = this.comment.reactionSummary.find(r => r.type === type)
                return entry && typeof entry.count === 'number' ? entry.count : 0
            }
            return 0
        },
        vote(type) {
            this.$emit('vote', { commentId: this.comment.id, type })
        },
        fromNow(date) {
            //return dayjs(date).fromNow()
            return date
        }
    }
}
</script>

<style scoped>
.text {
    font-size: 0.9rem;
}
</style>
