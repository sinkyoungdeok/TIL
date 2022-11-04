const IssueWriteForm = {
    template: `
  <q-dialog>
      <q-card style="width: 700px; max-width: 80vw;">
        <q-card-section>
          <div class="text-h5">
                    <q-input filled 
                    v-model="issue.summary"    
                    label="제목" />
            </div>
        </q-card-section>

            <q-card-section>
                       <div>
                            <span class="text-h6">이슈타입</span>
                            <div>
                              <q-select v-model="issue.type"
                               :options="typeLabel.type" />
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
          <div >
              <span class="text-h6">내용</span>
                <q-input 
                    v-model="issue.description"
                    filled
                    autogrow
                />
           </div>
        </q-card-section>


        <q-card-actions align="right" class="bg-white text-teal">
          <q-btn flat label="저장" @click="save()" v-close-popup />
          <q-btn flat label="취소" v-close-popup />
        </q-card-actions>
      </q-card>
    </q-dialog>
`,
    props: [
        'user',
        'typeLabel'
    ],
    data() {
        return {
            issue: {
                summary: '',
                description: '',
                type: 'TASK',
                priority: 'MEDIUM',
                status: 'TODO',
            },
        }
    },

    methods: {
        save() {
            let accessToken = localStorage.getItem('token')
            window.axios.post(`/api/v1/issues`,
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
    }
}
