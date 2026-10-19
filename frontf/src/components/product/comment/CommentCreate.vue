<template>
  <div>
    <b-row>
      <b-col sm="3"> {{ $t('title') }} </b-col>
      <b-col sm="6">
        <b-form-input v-model="form.title" />
      </b-col>
    </b-row>

    <dyna-list ref="benefComponent" :label="$t('PRODUCT_COMMENT_LIST_OF_BEN')" @updatelist="updateListOfBenefits" />
    <dyna-list ref="upsetComponent" :label="$t('PRODUCT_COMMENT_LIST_OF_UPS')" @updatelist="updateListOfUpsets" />
    <r-editor ref="editorComponent" @editorContentChanged="editorContentChanged" />

    <b-row class="my-1">
      <b-button @click="saveComment" :disabled="saving">{{ saving ? $t('saving') : $t('save') }}</b-button>
      <b-button variant="secondary" class="ml-2" @click="$emit('cancel')">{{ $t('cancel') }}</b-button>
    </b-row>
  </div>
</template>

<script>
import dynaList from '../dynaList.vue';
import rEditor from '../rEditor.vue';
import commentService from '../../../store/modules/comment/commentService';

export default {
  name: 'CommentCreate',
  components: { dynaList, rEditor },
  props: {
    productId: {
      type: [Number, String],
      required: true
    }
  },
  data() {
    return {
      form: {
        title: '',
        benefits: [],
        upsets: [],
        content: '',
        productId: this.productId
      },
      saving: false
    };
  },
  methods: {
    updateListOfBenefits(arr) { this.form.benefits = arr; },
    updateListOfUpsets(arr) { this.form.upsets = arr; },
    editorContentChanged(content) { this.form.content = content; },
    clearForm() {
      this.form.title = '';
      this.form.benefits = [];
      this.form.upsets = [];
      this.form.content = '';
      this.$refs.benefComponent.clear();
      this.$refs.upsetComponent.clear();
      this.$refs.editorComponent.clear();
    },
    saveComment() {
      this.saving = true;
      commentService.saveComment(this.form)
          .then(() => {
            this.clearForm();
            this.$emit('saved');
          })
          .catch(err => {
            console.error(err);
          })
          .finally(() => { this.saving = false; });
    }
  }
};
</script>
