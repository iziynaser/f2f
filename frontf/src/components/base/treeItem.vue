<template>
    <div>
      <li>
        <div
          :class="{bold: isFolder}"
          @click="toggle"
          @dblclick="makeFolder">
          {{ item.name }}
          <span v-if="isFolder">[{{ isOpen ? '-' : '+' }}]</span>
          <!-- <b-icon-trash small></b-icon-trash> -->
        </div>
        <ul v-show="isOpen" v-if="isFolder">
          <tree-item
            class="item"
            v-for="(child, index) in item.children"
            :key="index"
            :item="child"
            @make-folder="$emit('make-folder', $event)"
            @add-item="$emit('add-item', $event)"
            @select-item="$emit('select-item',$event)"
            :depth="depth + 1"
          ></tree-item>
          <li class="add" @click="$emit('add-item', item)">+</li>
        </ul>
      </li>
    </div>
</template>

<script>

// eslint-disable-next-line no-unused-vars
import Vue from 'vue'

export default {
    name:'tree-item',
    props:{
        item: Object,
        depth: {
                type:Number,
                required:false,
                default:0
              }
    } ,
    data(){
      return {
        isOpen: false
      }
    } ,
        methods: {
          toggle: function() {
            if (this.isFolder) {
              this.isOpen = !this.isOpen;
            }
            this.selectItem();
          },
          makeFolder: function() {
            if(this.depth==2)
                return;
            if (!this.isFolder) {
              this.$emit("make-folder", this.item);
              this.isOpen = true;
            }
          },
          selectItem:function(){
            this.$emit('select-item',this.item);
          },inputItem:function(){
            this.$emit('input-item',this.item);
          }
    },
    computed: {
        isFolder: function() {
            return this.item.children && this.item.children.length;
        }
    }      
}
</script>

<style scoped>

</style>