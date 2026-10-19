<template>
    <div>
              <div>
                <b-card>
                  <b-card-title>{{$t('PRODUCT_COMMENT_SORT_BY')}}</b-card-title>
                  <b-tabs pills card>
                    <b-tab :title="this.$t('PRODUCT_COMMENT_MOST_USEFUL')">
                        <viewComment :comments="mostUsefulComments"/>
                    </b-tab>
                    <b-tab :title="this.$t('PRODUCT_COMMENT_UP_TO_DATE')">
                        <viewComment :comments="comments"/>
                    </b-tab>
                    <b-tab :title="this.$t('PRODUCT_COMMENT_SUBJECT')">
                        <viewComment :comments="subjectComments"/>
                    </b-tab>
                  </b-tabs>
                </b-card>
              </div>        
    </div>
</template>

<script>

import axios from 'axios'
import viewComment from './viewComment'

export default {
    name:'commentL',
    props:{
      comments:Array,
      id:Number
          } ,
    data(){
      return {
        mostUsefulComments:[],
        uptoDateComments:[],
        subjectComments:[]
      }
    } ,
    methods:{
        onMostUsefulComments(){
          const arr = this.comments.slice(0);
          arr.sort(function compare(A,B){
            let c = 0;
            const a = A.numberOfLikes ;
            const b = B.numberOfLikes ;
            if( a > b)
              c = 1 
            else if (a<b)
              c = -1

            return c;  
          });
          this.mostUsefulComments = arr;
          console.log(this.mostUsefulComments);
        },
        onSubjectComments(){
            const arr = this.comments.slice(0);
            arr.sort(function compare(A,B){
            let c = 0;
            const a = A.subject;
            const b = B.subject;
            if( a > b )
              c = 1 ;
            else if(a<b)
              c = -1 ; 
            return c;  
          });
          this.subjectComments = arr;
          console.log(this.subjectComments);
        },
        onCommentResult(){
            var self = this;
            axios({
                method:"GET",
                url: "/comments/list",
                params:{
                    'productId':self.id 
                }
            }).then(function(res){
                self.comments = res.data;
                console.log(res.data);
                //fill other arrays
               self.onMostUsefulComments();
               self.onSubjectComments();

            }).catch(function(error){
                console.log(error);
            })

        }
    },
    mounted(){
        this.onCommentResult();
    },
    components:{
      viewComment
    }

}
</script>

<style scoped>

</style>