<template>
    <div>
        <div>content:{{ content.id }},{{ content.name }}</div>
        <div>
            <b-row class="my-1">
                <b-col>
                    <h6>
                        <p class="font-weight-italic ">editor for content:</p>
                    </h6>
                </b-col>
                <!-- <b-col>
                        <b-button size="sm" variant="success"
                                  ref="saveBtn"  
                                  @clik="saveForm()">save</b-button>
                    </b-col>                     -->
            </b-row>
        </div>
        <div>
            <b-row class="my-1">
                <b-button class="m-1">{{ this.$t('preview') }}</b-button>
                <b-button class="m-1" @click="saveForm">save2</b-button>
            </b-row>
            <vue-editor v-model="form.body" :config="config" ref="content" @text-change="contentChanged()">
            </vue-editor>
        </div>
    </div>
</template>

<script>

import { VueEditor } from 'vue2-editor'
import axiosInstance from '@/api/axiosInstance';
import {CONSTANTS} from "../../../api/constants";

export default {
    name: 'contentEditor',
    props: {
        content: { type: Object },
        desciption: {
            type: String,
            default: "dfsdfsf"
        },
        editorContent: { type: String }
    },
    data() {
        return {
            form: {
                body: '',//this.contentLoaded() ,
                language: 'fa',
                code: '123',
                date: '1398/05/25',
                status: 'PUBLISHED'
            },
            hasPreview: true,
            config: {
                image: {
                    byFile:  CONSTANTS.IMG_URL +'image',
                    byUrl: CONSTANTS.IMG_URL +'image-by-url'
                },
                field: 'image',
                types: 'image/*'
            },
        }
    },
    components: {
        VueEditor
    }, computed: {
        contentLoaded() {
            return this.content.body;
        }
    },
    mounted() {
        //this.title = this.$t('REDITOR_TITLE');
        //this.desciption = this.$t('REDITOR_DESCRIPTION');
    },
    methods: {
        saveForm() {
            //console.log('saveForm is called');
            var self = this;
            const url = "/content/save";
          axiosInstance.post(url, self.form)
                .then((res) => {
                    console.log(res);
                })
                .catch((err) => {
                    console.log(err);
                })
        },
        contentChanged() {
            console.log('content changed');
        }
    }
}
</script>

<style scoped></style>