<template>

  <div class="tree-node">

    <div
        class="node-row"
        :class="{selected:isSelected}"
        @click.stop="selectNode"
        @dblclick.stop="confirmNode"
    >

      <span class="toggle" @click.stop="toggle">

        <span v-if="hasChildren">
          {{ expanded ? "▼" : "▶" }}
        </span>

        <span v-else>•</span>

      </span>

      <span class="code">
        {{ account.code }}
      </span>

      <span class="name">
        {{ account.name }}
      </span>

    </div>

    <div v-if="expanded && hasChildren" class="children">

      <account-tree-node
          v-for="child in account.children"
          :key="child.id"
          :account="child"
          :selected-id="selectedId"
          @select="$emit('select',$event)"
          @confirm="$emit('confirm',$event)"
      />

    </div>

  </div>

</template>

<script>

export default {

  name:"AccountTreeNode",

  props:{
    account:Object,
    selectedId:[Number,String]
  },

  data(){
    return{
      expanded:false
    }
  },

  computed:{

    hasChildren(){
      return this.account.children && this.account.children.length>0
    },

    isSelected(){
      return String(this.account.id)===String(this.selectedId)
    }

  },

  methods:{

    toggle(){
      if(this.hasChildren)
        this.expanded=!this.expanded
    },

    selectNode(){
      this.$emit("select",this.account)
    },

    confirmNode() {
      if (this.hasChildren) return   // فقط برگ‌ها را تأیید کن
      this.$emit("confirm", this.account)
    }


  }

}

</script>

<style scoped>

.node-row{
  display:flex;
  align-items:center;
  padding:5px;
  cursor:pointer;
  border-radius:4px;
}

.node-row:hover{
  background:#f4f4f4;
}

.selected{
  background:#d9ecff;
}

.children{
  padding-right:20px;
}

.code{
  font-weight:bold;
  margin-left:5px;
}

.toggle{
  width:20px;
  cursor:pointer;
}

</style>
