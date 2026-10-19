<template>
  <div>
    {{ $t('overview _comments _product') }}
    <div>

      <div class="mt-2">{{ $t('comment_1') }}</div>
      <b-progress value="25" striped variant="success"></b-progress>

      <!-- <label></label> -->
      <div class="mt-2">{{ $t('comment_2') }}</div>
      <b-progress value="75" striped variant="info"></b-progress>

      <div class="mt-2">{{ $t('comment_3') }}</div>
      <b-progress value="35" striped variant="warning"></b-progress>

      <div class="mt-2">{{ $t('comment_4') }}</div>
      <b-progress value="90" striped variant="danger"></b-progress>
    </div>
  </div>
</template>

<script>
export default {
  name: 'commentDiagram',
  props: {
  },
  data() {
    return {

    }
  },
  methods: {

  }
}
</script>

<style scoped></style>