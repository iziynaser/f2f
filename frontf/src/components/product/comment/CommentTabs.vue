<template>
  <b-tabs pills card>
    <b-tab :title="$t('PRODUCT_COMMENT_MOST_USEFUL')">
      <comment-list :comments="sortedByLikes" @vote="handleVote" />
    </b-tab>
    <b-tab :title="$t('PRODUCT_COMMENT_UP_TO_DATE')">
      <comment-list :comments="comments" @vote="handleVote" />
    </b-tab>
    <b-tab :title="$t('PRODUCT_COMMENT_SUBJECT')">
      <comment-list :comments="sortedBySubject" @vote="handleVote" />
    </b-tab>
  </b-tabs>
</template>

<script>
import commentService from '../../../store/modules/comment/commentService';
import CommentList from './ViewCommentList.vue';

export default {
  name: 'CommentTabs',
  components: { CommentList },
  props: {
    productId: {
      type: [Number, String],
      required: true
    }
  },
  data() {
    return { comments: [] };
  },
  computed: {
    sortedByLikes() {
      return [...this.comments].sort((a, b) => (b.numberOfLikes || 0) - (a.numberOfLikes || 0));
    },
    sortedBySubject() {
      return [...this.comments].sort((a, b) => (a.subject || '').localeCompare(b.subject || ''));
    }
  },
  methods: {
    fetchComments() {
      commentService.fetchComments(this.productId)
          .then(res => {
            this.comments = res.data;
          })
          .catch(console.error);
    },
    handleVote({ commentId, type }) {
      commentService.voteComment(commentId, type)
          .then(() => this.fetchComments())
          .catch(console.error);
    }
  },
  mounted() {
    this.fetchComments();
  }
};
</script>
