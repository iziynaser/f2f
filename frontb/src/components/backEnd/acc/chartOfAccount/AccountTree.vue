<template>

  <ul className="tree">

    <account-node
        v-for="n in nodes"
        :key="n.id"
        :node="n"
        :selected-id="selectedId"
        @select="select"
    />

  </ul>

</template>

<script>

import AccountNode from "./AccountNode.vue"

export default {

  name: "AccountTree",

  components: {
    AccountNode
  },

  props: {
    nodes: Array,
    selectedId: Number
  },

  methods: {

    select(node) {
      this.$emit("select", node)
    }

  }

}

</script>

<style scoped>

.tree {
  list-style: none;
  padding: 0;
}

</style>
