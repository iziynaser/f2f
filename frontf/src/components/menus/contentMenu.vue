<template>
    <div>
        <b-nav-item-dropdown :text="$t('CONTENT_SITE')" right>

            <b-dropdown-item href="#">
                  <b-button size="sm" variant="link" @click="createContentTabs(0,$t('CONTENT_webSite'))">{{ $t('CONTENT_webSite') }}</b-button>
            </b-dropdown-item>

            <b-dropdown-item href="#">
                <b-button size="sm" variant="link" @click="createContentTabs(1,$t('CONTENT_survey'))">{{ $t('CONTENT_survey') }}</b-button>
            </b-dropdown-item>

            <b-dropdown-item href="#">
                <b-button size="sm" variant="link" @click="createContentTabs(2,$t('CONTENT_forum'))">{{ $t('CONTENT_forum') }}</b-button>
            </b-dropdown-item>

            <b-dropdown-item href="#">
                <b-button size="sm" variant="link" @click="createContentTabs(3,$t('C_WEB_QA'))">{{ $t('C_WEB_QA') }}</b-button>
            </b-dropdown-item>

            <b-dropdown-item href="#">
                <b-button size="sm" variant="link" @click="createContentTabs(4,$t('CONTENT_blog'))">{{ $t('CONTENT_blog') }}</b-button>
            </b-dropdown-item>

            <b-dropdown-item href="#">
                <b-button size="sm" variant="link" @click="createContentTabs(5,$t('CONTENT_content'))">{{ $t('CONTENT_content') }}</b-button>
            </b-dropdown-item>

            <b-dropdown-item href="#">
                <b-button size="sm" variant="link" @click="createContentTabs(6,$t('article'))">{{ $t('article') }}</b-button>
            </b-dropdown-item>

            <b-dropdown-item href="#">
                <b-button size="sm" variant="link" @click="createContentTabs(7,$t('CONTENT_contentSetup'))">{{ $t('CONTENT_contentSetup') }}</b-button>
            </b-dropdown-item>

            <!-- <b-nav-item-dropdown text="CONTENT" right> -->
            <!-- <b-dropdown-item href="#" >
              <router-link to="/contentC">Content</router-link>
          </b-dropdown-item> -->
            <!-- </b-nav-item-dropdown> -->

            <!-- <b-dropdown-item href="#" >
              <router-link to="/humanres">{{$t('CONTENT_datasourceSetup')}} </router-link>
          </b-dropdown-item> -->

        </b-nav-item-dropdown>
    </div>
</template>

<script>
import createContent from '../content/createContent.vue'
import surveyMain from '../content/survey/surveyMain'
import forumMain from '../content/forum/forumMain'
import qaMain from '../content/qa/qaMain'
import blogMain from '../content/blog/blogMain'
import contentMain from '../content/contnt/contentMain'

export default {
    name: 'contentMenu',
    props: {
    },
  data() {
    return {
      cp: [
            createContent,
            surveyMain,
            forumMain,
            qaMain,
            blogMain,
            contentMain,
      ]
    }
  },
  methods: {
    createContentTabs(idParam, nameParam) {
      let atab = {
        id: idParam ,
        name: nameParam,
        contnt : this.cp[idParam]
      }
      atab.id = (atab.id + 30);
      //console.log(atab);
      this.$emit('createAppTab',atab);
    }
  }
}
</script>

<style scoped></style>