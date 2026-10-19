<template>
  <div>
    <div>
      {{ $t('number_comments_product') }}:1010
      <b-row class="my-1">
        <b-col sm="9">
          <span v-if="registerBtnClicked">
            <commentCreate :id="Number(id)" />
          </span>
          <span v-else>
            <commentDiagram />
          </span>
        </b-col>
        <b-col sm="3">
          <div>
            {{ $t('PRODUCT_COMMENT_REG_DESCR') }}
          </div>
          <div>
            <b-button pill variant="danger" @click="registerBtnClick">
              {{ $t('PRODUCT_COMMENT_REG_A_NEW_ONE') }}
            </b-button>
          </div>
        </b-col>
      </b-row>
    </div>
    <commentL :id="Number(id)" />
  </div>
</template>

<script>

import commentCreate from './commentCreate'
import commentDiagram from './commentDigram'
import commentL from './commentL'

export default {
  name: 'comment',
  props: {
    id: Number
  },
  data() {
    return {
      registerBtnClicked: false,
      //noButtonPressesd:false,
      //yesButtonPressed:false,
      //comments:[]
    }
  },
  methods: {
    registerBtnClick() {
      this.registerBtnClicked = true;
    },
    saveCommentClick() {
      //this.comments.push({title:this.title,benefits:this.benefits,upsets:this.upsets,content:this.content});
      this.clear();
    }
  },
  components: {
    commentL,
    commentCreate,
    commentDiagram
  }
}
</script>

<style scoped></style>