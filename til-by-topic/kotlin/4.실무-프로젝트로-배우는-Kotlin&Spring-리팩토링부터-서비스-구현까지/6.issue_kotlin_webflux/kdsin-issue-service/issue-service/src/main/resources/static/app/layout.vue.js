const MyLayout = {
    template: `
        <q-header reveal elevated class="bg-primary text-white">
          <q-toolbar>
            <q-toolbar-title>
              JARA
            </q-toolbar-title>
          <q-btn-dropdown stretch flat 
          :icon="profileUrl"
          :label="user.username + layoutLabel.userNameSuffix">
                <q-list>
                  <q-item-label header>{{$props.layoutLabel.myInfo}}</q-item-label>
                  <q-item clickable v-close-popup  @click="showUserEditForm()">
                    <q-item-section avatar>
                      <q-avatar icon="edit" color="primary" text-color="white" />
                    </q-item-section>
                    <q-item-section>
                      <q-item-label>{{$props.layoutLabel.userEdit}}</q-item-label> 
                    </q-item-section>
                  </q-item>
                  <q-item clickable v-close-popup  @click="logout()">
                    <q-item-section avatar>
                      <q-avatar icon="logout" color="primary" text-color="white" />
                    </q-item-section>
                    <q-item-section>
                      <q-item-label>{{$props.layoutLabel.logout}}</q-item-label> 
                    </q-item-section>
                  </q-item>
                </q-list>
             </q-btn-dropdown>
              
          </q-toolbar>
          
            <q-tabs align="center" class="bg-white text-primary">
                <q-tab :label="layoutLabel.todo" @click="fetchIssues('TODO')" icon="task"/>
                <q-tab :label="layoutLabel.inProgress" @click="fetchIssues('IN_PROGRESS')"  icon="schedule"/>
                <q-tab :label="layoutLabel.resolved" @click="fetchIssues('RESOLVED')" icon="check_circle"/>
            </q-tabs>
        </q-header>
        <-- end top header toolbar -->
        
        <-- begin left navigation -->
         <q-drawer show-if-above v-model="leftDrawerOpen" side="left" bordered>
          <q-scroll-area class="fit">
          <q-list padding class="menu-list">
            <q-item clickable v-ripple @click="showWriteForm()">
              <q-item-section avatar>
                <q-icon name="add_task" />
              </q-item-section>

              <q-item-section >
                <a  >{{$props.layoutLabel.publishIssue}}</a>
              </q-item-section>
            </q-item>
         
          </q-list>
        </q-scroll-area>
        </q-drawer>
        <-- end left navigation -->
               
        <!-- begin issue-list -->               
        <issue-list
            :issues="issues"
            :type-label="typeLabel"
            @issueCardClicked="clickIssue"
        /> 
        <!-- end issue-list -->
        
        <!-- begin issue-write-form -->
        <issue-write-form 
            v-model="issueWriteFormShowed"
            :user="user"
            :type-label="typeLabel"
        />
        <!-- end issue-write-form -->
        
        <!-- begin issue-edit-form -->
        <issue-edit-form 
            v-model="issueFormShowed"
            :user="user"
            :issue="clickedIssue"
            :reporter="reporter"
           :type-label="typeLabel"
            />
        <!-- end issue-edit-form -->
        
        <!-- begin issue-edit-form -->
        <user-edit-form 
            v-model="userEditFormShowed"
            :user="user"
           :type-label="typeLabel"
            />
        <!-- end issue-edit-form -->
`,
    props: [
        'layoutLabel',
        'user',
        'issues',
        'typeLabel'
    ],
    data() {
        return {
            issueWriteFormShowed: false,
            issueFormShowed: false,
            userEditFormShowed: false,
            clickedIssue: 0,
            issues: [],
            user: null,
            reporter: '',
            profileUrl: 'account_circle',
        }
    },
    mounted() {
        this.fetchUser()
        this.fetchIssues()
    },
    methods: {
        fetchIssues(_status) {
            let status = _status || 'TODO'
            let accessToken = localStorage.getItem('token')
            if (!accessToken) {
                return
            }
            window.axios.get(`/api/v1/issues?status=${status}`, {
                headers: {
                    Authorization: `Bearer ${accessToken}`
                }
            }).then(response => {
                this.issues = response.data
            })
        },
        fetchUser() {
            let accessToken = localStorage.getItem('token')
            if (!accessToken) {
                return
            }
            let url = localStorage.getItem('userServiceUrl')
            window.axios.get(`${url}/api/v1/users/me`, {
                headers: {
                    Authorization: `Bearer ${accessToken}`
                }
            }).then(response => {
                if (!response.data) {
                    location.href = '/'
                }
                if (response.data && response.data.code) {
                    alert(response.data.message)
                    location.href = '/'
                }
                this.user = response.data
                if (this.user.profileUrl && this.user.profileUrl.indexOf("null") === -1) {
                    this.profileUrl = `img:${this.user.profileUrl}`
                }
            }).catch(err => {
                location.href = '/'
            })
        },
        showWriteForm() {
            this.issueWriteFormShowed = true
        },
        showUserEditForm() {
            this.userEditFormShowed = true
        },
        clickIssue(id) {
            this.issueFormShowed = true
            this.clickedIssue = this.issues.find(issue => {
                return issue.id === id
            })

            this.fetchReporter(this.clickedIssue)
        },
        fetchReporter(issue) {
            let accessToken = localStorage.getItem('token')
            let url = localStorage.getItem('userServiceUrl')
            window.axios.get(`${url}/api/v1/users/${issue.userId}/username`,
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
                this.reporter = response.data.reporter
            })
        },
        logout() {
            let accessToken = localStorage.getItem('token')
            let url = localStorage.getItem('userServiceUrl')
            window.axios.delete(`${url}/api/v1/users/logout`,
                {
                    headers: {
                        Authorization: `Bearer ${accessToken}`
                    }
                }
            ).then(response => {
                if (response.data && response.data.code) {
                    alert(response.data.message)
                    return
                }
                location.href = '/'
            })
        }

    }
}
