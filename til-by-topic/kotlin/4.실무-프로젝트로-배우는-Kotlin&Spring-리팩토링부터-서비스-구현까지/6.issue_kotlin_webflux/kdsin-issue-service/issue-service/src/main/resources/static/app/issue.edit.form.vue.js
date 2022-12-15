const IssueEditForm = {
    template: `
  <q-dialog>
      <q-card style="width: 700px; max-width: 80vw;">
        <q-card-section>
          <div class="text-h5">{{issue.summary}}</div>
        </q-card-section>

        <q-card-section>
            <div>
                <span class="text-h6">리포터</span>
                <div>
                    {{$props.reporter}}
                </div>
            </div>
        </q-card-section>
        
         <q-card-section>
            <div>
                <span class="text-h6">우선순위</span>
                <div>
                  <q-select v-model="issue.priority"
                   :options="typeLabel.priorityOptions" />
                </div>
            </div>
        </q-card-section>
        
         <q-card-section>
            <div>
                <span class="text-h6">진행상태</span>
                <div>
                  <q-select v-model="issue.status"
                   :options="typeLabel.statusOptions" />
                </div>
            </div>
        </q-card-section>
        
         <q-card-section>
            <div>
                <span class="text-h6">접수일시</span>
                <div>{{issue.createdAt}}</div>
            </div>
        </q-card-section>
        
         <q-card-section>
            <div v-if="issue.createdAt !== issue.updatedAt">
                <span class="text-h6">수정일시</span>
                <div>{{issue.updatedAt}}</div>
            </div>
        </q-card-section>

        <q-card-section>
          <div >
              <span class="text-h6">내용</span>
                <q-input 
                    v-model="issue.description"
                    filled
                    autogrow
                />
           </div>
        </q-card-section>

        <q-card-section>
          <div >
              <span class="text-h6">댓글</span>
                <q-input filled 
                    @keyup.enter="createComment($event)" 
                    v-model="newComment"    
                    label="댓글을 입력하세요" 
                :dense="dense" />
           </div>
           
    
        </q-card-section>

        <q-card-section>
            <q-list bordered separator>
                <q-item
                    v-for="comment in issue.comments" 
                    >
                    <q-item-section avatar style="width:100%">
                        <q-chip>
                            {{comment.username}}
                        </q-chip>
                        
                        <q-input 
                            style="width:100%"
                            filled v-model="comment.body" :dense="dense" 
                            :readonly="editCommentId !== comment.id"
                            @keyup.enter="editComment(comment)"
                        />
                        
                        <div>
                            <span @click="showEditComment(comment)">수정</span> | 
                            <span @click="deleteComment(comment)">삭제</span>
                        </div>
                                    
                    </q-item-section>
          
                </q-item>
          </q-list>
        </q-card-section>

        <q-card-actions align="right" class="bg-white text-teal">
          <q-btn flat @click="save()" label="저장" v-close-popup />
          <q-btn flat label="취소" v-close-popup />
          <q-btn flat @click="remove()" label="삭제" v-close-popup />
        </q-card-actions>
      </q-card>
    </q-dialog>
`,
    props: [
        'user',
        'issue',
        'reporter',
        'typeLabel'
    ],
    data() {
        return {
            editCommentId: 0,
            newComment: '',
        }
    },

    mounted() {
    },

    methods: {
        save() {
            if (!confirm('변경 사항을 저장하시겠습니까?')) {
                return
            }
            let accessToken = localStorage.getItem('token')
            window.axios.put(`/api/v1/issues/${this.issue.id}`,
                this.issue,
                {
                    headers: {
                        Authorization: `Bearer ${accessToken}`
                    }
                }
            ).then(response => {
                if (!response.data) {
                    alert('오류가 발생했습니다')
                    return
                }
                if (response.data && response.data.code) {
                    alert(response.data.message)
                    return
                }
                this.issue = response.data
                location.href = `/issueapp`
            })
        },
        remove() {
            if (!confirm('이슈를 삭제하시겠습니까?')) {
                return
            }

            let accessToken = localStorage.getItem('token')
            window.axios.delete(`/api/v1/issues/${this.issue.id}`,
                {
                    headers: {
                        Authorization: `Bearer ${accessToken}`
                    }
                }
            ).then(response => {
                location.href = `/issueapp`
            })
        },
        showEditComment(comment) {
            this.editCommentId = comment.id
        },
        editComment(comment) {
            if (!comment || !comment.body) {
                return
            }
            let accessToken = localStorage.getItem('token')
            window.axios.put(`/api/v1/issues/${this.issue.id}/comments/${comment.id}`,
                {body: comment.body},
                {
                    headers: {
                        Authorization: `Bearer ${accessToken}`
                    }
                }
            ).then(response => {
                this.editCommentId = 0
            })
        },
        deleteComment(comment) {
            if (!confirm('삭제하시겠습니까?')) {
                return
            }
            let accessToken = localStorage.getItem('token')
            window.axios.delete(`/api/v1/issues/${this.issue.id}/comments/${comment.id}`,
                {
                    headers: {
                        Authorization: `Bearer ${accessToken}`
                    }
                }
            ).then(response => {
                this.issue.comments = this.issue.comments.filter(_comment => {
                    return _comment.id !== comment.id
                })
            })
        },
        createComment(event) {
            event.preventDefault() && event.stopPropagation()
            if (!this.newComment) {
                return
            }
            let accessToken = localStorage.getItem('token')
            window.axios.post(`/api/v1/issues/${this.issue.id}/comments`,
                {body: this.newComment},
                {
                    headers: {
                        Authorization: `Bearer ${accessToken}`
                    }
                }
            ).then(response => {
                this.newComment = ''
                this.issue.comments.push(response.data)
            })
        }
    }
}
