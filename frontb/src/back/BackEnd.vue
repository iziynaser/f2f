<template>
<div >
          <div>
            <NavBars @createAppTab="createAppTab" @createHelpDeskTab="createHelpDeskTab"/>
        </div>
        <div>
          <b-card class="mb-2"  img-right img-src="http://localhost:8080/images/logo/face.png">
            <b-card-text> 
              <div>
                <b-container fluid>
                  <b-row  class="my-1">
                    <b-col sm="3">
                        <label>clock</label> 
                    </b-col>
                    <b-col sm="6">
                       <toast :show="toast.show" :text="toast.text" @hide-toast="hideToast"></toast>
                    </b-col>
                  </b-row> 
                  </b-container>
              </div>
            </b-card-text>  
           
          </b-card>           
        </div>

   <b-card no-body>
    <b-tabs small pills card ref="appTabs" v-model="appTabIndex">
      <b-tab :title="$t('help_desc')">
          <b-card no-body>
              <b-tabs  pills small card vertical ref="appTabs" v-model="tabIndex">

                        <b-tab v-for="a in helpDeskTabs" ref="helpDeskTabs" :key="a.id" >
        <template #title>
          <b-icon icon="x" size="sm" @click="closeTab(a.id)"></b-icon>
            {{getTranslationFromBundle(a.name)}}
        </template>
        <p>
          <component :is="a.contnt"></component>
        </p>
      </b-tab>

              </b-tabs>
          </b-card>
      </b-tab>
                  <b-tab v-for="t in appTabs" :key="t.id">
                      <template #title>
                          <b-icon icon="x" size="sm" @click="closeTab(t.id)"></b-icon>
                          {{ t.name }}
                      </template>
                      <p>
                          <component :is="t.contnt"></component>
                      </p>
                  </b-tab>
    </b-tabs>
   </b-card>     
</div>

</template>
  
<script>
import NavBars from '../components/navBars.vue';

import charts from '../components/portal/charts.vue';
import links from '../components/portal/links.vue';
import calendar from '../components/portal/calendar.vue';
import notes from '../components/portal/notes.vue';
import phone from '../components/portal/phone.vue';
import softwares from '../components/portal/softwares.vue';
import toast from '../components/Toast'
import fAsset from '../components/portal/fAsset.vue'

export default {
  name: "BackEnd",
  components: {
    NavBars,
    toast,
  },
    data() {
      return {
        tabIndex: 0 ,
        isBusy: false,
        helpDeskTabIndex: 0 ,
        appTabIndex: 0 ,
          appTabs:[],
          helpDeskTabs: [
            {
              name: "charts" ,
                   id: 1,
                   contnt: charts
            },
                        {
              name: "links" ,
                   id: 2,
                   contnt: links
            },
                        {
              name: "calendar" ,
                   id: 3,
                   contnt: calendar
            },
                        {
              name: "notes" ,
                   id: 4,
                   contnt: notes
            },
                        {
              name: "phone" ,
                   id: 5,
                   contnt: phone
            },
                        {
              name: "softwares" ,
                   id: 6,
                   contnt: softwares
            },
                        {
              name: "assets" ,
                   id: 7,
                   contnt: fAsset
            }
          ],
        }
  },
      computed:{
        toast(){
          return this.$store.getters.toast;
        }
  },
  methods: {
          hideToast(){
        this.$store.commit("hideToast");
      },

    // createTab() {
    //   let newTab = {
    //     id: 0 ,
    //     name: "t",
    //     contnt : "cccc"
    //   }
    //   this.helpDeskTabs.push(newTab);
    //     console.log('createTab')
    // },
    createAppTab(at) { 
      //console.log('backEnd:'+at)
      let index = 0;
      let isfound = false;
      let j = 0;
      for (j = 0; j < this.appTabs.length; j++) {
        if (this.appTabs[j].id === at.id) {
          isfound = true;
          index = j;
          console.log('found :'+index);
          break;
        }
      }
        if (isfound == false) {
          this.appTabs.push(at);
        }
    },
    createHelpDeskTab(at) { 
      //console.log('backEnd:'+at)
      let index = 0;
      let isfound = false;
      let j = 0;
      for (j = 0; j < this.helpDeskTabs.length; j++) {
        if (this.helpDeskTabs[j].id === at.id) {
          isfound = true;
          index = j;
          console.log('found :'+index);
          break;
        }
      }
        if (isfound == false) {
          this.helpDeskTabs.push(at);
        }
    },
    closeTab(x) {
      for (let i = 0; i < this.appTabs.length; i++) {
        if (this.appTabs[i].id == x) {
            this.appTabs.splice(i, 1)
          }
      }

      for (let i = 0; i < this.helpDeskTabs.length; i++) {
        if (this.helpDeskTabs[i].id === x) {
            this.helpDeskTabs.splice(i, 1)
          }
      }
        
    },
    getTranslationFromBundle(str) {
      //console.log("a:"+str);
      let tStr = this.$t(str);
      //console.log(",b:"+tStr);
      return tStr;
     }
    }
}
</script>
  
<style></style>
  