<template>

  <li>

    <div
        class="node-row"
        :class="{selected:selectedId===node.id}"
        @click="select"
    >

      <span
          v-if="hasChildren"
          class="toggle"
          @click.stop="toggle"
      >
        {{expanded ? "▼" : "▶"}}
      </span>

      <span class="title">
        {{node.code}} - {{node.name}}
      </span>

    </div>

    <ul
        v-if="expanded && hasChildren"
        class="children"
    >

      <account-node
          v-for="c in node.children"
          :key="c.id"
          :node="c"
          :selected-id="selectedId"
          @select="childSelect"
      />

    </ul>

  </li>

</template>

<script>

export default {

  name: "AccountNode",

  props: {
    node: Object,
    selectedId: Number
  },

  data() {
    return {
      expanded: false
    }
  },

  computed: {

    hasChildren() {

      if (!this.node.children) {
        return false
      }

      return this.node.children.length > 0

    }

  },

  methods: {

    toggle() {
      this.expanded = !this.expanded
    },

    select() {
      this.$emit("select", this.node)
    },

    childSelect(node) {
      this.$emit("select", node)
    }

  }

}

</script>

<style scoped>

.node-row{
  cursor:pointer;
  padding:6px;
  border-radius:4px;
}

.node-row:hover{
  background:#f5f5f5;
}

.selected{
  background:#e7f1ff;
}

.children{
  list-style:none;
  padding-right:18px;
}

.toggle{
  margin-left:6px;
}

</style>
