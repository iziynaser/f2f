<template>
  <div>
    <b-row>
      <b-col sm="9">
        <div>{{ $t('number_comments_product') }}: {{ totalComments }}</div>

        <b-button v-if="!registerBtnClicked" pill variant="danger" @click="registerBtnClicked = true">
          {{ $t('PRODUCT_COMMENT_REG_A_NEW_ONE') }}
        </b-button>

        <comment-create v-if="registerBtnClicked" :product-id="id" @saved="onCommentSaved" @cancel="registerBtnClicked = false" />

        <comment-tabs v-else :product-id="id" />
      </b-col>
    </b-row>
  </div>
</template>

<script>
import commentService from '../../../store/modules/comment/commentService';
import CommentCreate from './CommentCreate.vue';
import CommentTabs from './CommentTabs.vue';

export default {
  name: 'CommentMain',
  components: { CommentCreate, CommentTabs },
  props: {
    id: {
      type: [Number, String],
      required: true
    }
  },
  data() {
    return {
      registerBtnClicked: false,
      totalComments: 0,
    };
  },
  methods: {
    onCommentSaved() {
      this.registerBtnClicked = false;
      this.loadTotalComments();
    },
    loadTotalComments() {
      commentService.fetchComments(this.id)
          .then(res => {
            this.totalComments = res.data.length;
          })
          .catch(err => {
            console.error(err);
          });
    }
  },
  mounted() {
    this.loadTotalComments();
  }
};
</script>
