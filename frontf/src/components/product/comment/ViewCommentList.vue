<template>
  <b-list-group v-if="comments && comments.length">
    <comment-item v-for="comment in comments" :key="comment.id" :comment="comment" @vote="$emit('vote', $event)" />
  </b-list-group>
</template>

<script>
import CommentItem from './CommentItem.vue';

export default {
  name: 'ViewCommentList',
  components: { CommentItem },
  props: {
    comments: Array
  }
};
</script>
