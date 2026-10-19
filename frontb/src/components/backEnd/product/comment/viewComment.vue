<template>
  <div>
    <div v-if="commentsArrayLength > 0">
      <b-list-group>
        <b-list-group-item v-for="comment in comments" :key="comment.id">
          <b-row>
            <b-col>
              <div>
                <b v-if="comment.nickName !== null">{{ comment.nickName }}</b>
                <b v-else>guest user</b>
              </div>
              <div>
                date :{{ comment.dateCreated }}
              </div>
            </b-col>
            <b-col>
              <div>
                <div>
                  <span class="border-0">
                    <b> {{ comment.subject }} </b>
                  </span>
                </div>

                <div>
                  <span class="border-1 border-bottom border-dark"></span>
                </div>

                <div v-if="comment.benefits">
                  <div class="text">{{ $t('benefits') }}</div>
                  <b-list-group horizontal flush>
                    <b-list-group-item v-for="ben in comment.benefits.split(',')" :key="ben">
                      {{ ben }}
                    </b-list-group-item>
                  </b-list-group>
                </div>

                <div v-if="comment.disadvatages">
                  <div class="text font-weight-bold">{{ $t('disadvatages') }}</div>
                  <b-list-group horizontal flush>
                    <b-list-group-item v-for="upse in comment.disadvatages.split(',')" :key="upse">
                      {{ upse }}
                    </b-list-group-item>
                  </b-list-group>
                </div>

                <div v-html="comment.content"></div>
                <div>
                  {{ $t('this_post_is_useful') }}
                  <b-button class="m-2" size="sm" :pressed.sync="noButtonPressesd" variant="outline-dark">
                    {{ $t('no') }}
                    <b-badge v-if="comment.numberOfDisLikes === null" variant="danger" pill>0</b-badge>
                    <b-badge v-else variant="danger" pill>{{ comment.numberOfDisLikes }}</b-badge>
                  </b-button>

                  <b-button size="sm" :pressed.sync="yesButtonPressed" variant="outline-success">
                    {{ $t('yes') }}
                    <b-badge v-if="comment.numberOfLikes === null" variant="success" pill>0</b-badge>
                    <b-badge v-else variant="success" pill>{{ comment.numberOfLikes }}</b-badge>
                  </b-button>
                </div>
              </div>
            </b-col>
          </b-row>
        </b-list-group-item>
      </b-list-group>
    </div>
  </div>
</template>

<script>
export default {
  name: 'viewComment',
  props: {
    comments: Array
  },
  data() {
    return {
      yesButtonPressed: false,
      noButtonPressesd: false,
    }
  },
  // computed :{
  //     commentsArrayLenght(){
  //       console.log("length comments:"+comments?.length);
  //       return comments?.length || 0 ;
  //     }
  //   },
  methods: {

  },
  computed: {
    commentsArrayLength() {
      console.log("lenght comments:...");
      return 1;

    }
  }
}
</script>

<style scoped></style>