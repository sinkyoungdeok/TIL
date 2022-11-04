const UserEditForm = {
    template: `
  <q-dialog>

      <q-card style="width: 700px; max-width: 80vw;">
<!--        <q-form @sumit="onSubmit" v-bind:action="url" method="post" enctype="multipart/form-data">-->
        <q-form @submit.prevent="onSubmit">
            <q-card-section>
                <div>
                    <span class="text-h6">이름</span>
                    <div>
                      <q-input name="username" v-model="user.username" filled type="text" />
                    </div>
                </div>
            </q-card-section>
            
             <q-card-section>
                <div>
                    <span class="text-h6">프로필 이미지</span>
                    
                      <q-file
                        name="profileUrl"
                        v-model="file"
                        label="Pick files"
                        filled
                        style="max-width: 300px"
                        accept="image/*"
                        >
                            <template v-slot:prepend>
                             <q-avatar >
                                <img :src="user.profileUrl">
                                </q-avatar>
                            </template>
                        </q-file>
                </div>
            </q-card-section>
           
            <q-card-actions align="right" class="bg-white text-teal">
              <q-btn flat label="저장" type="submit"  />
              <q-btn flat label="취소" v-close-popup/>
            </q-card-actions>
            
                  
          </q-form>
      </q-card>

    </q-dialog>
`,
    props: [
        'user',
        'typeLabel'
    ],
    data() {
        return {}
    },

    mounted() {
        this.getProfileUrl()
    },

    methods: {
        getProfileUrl() {

        },
        onSubmit(event) {
            let accessToken = localStorage.getItem('token')
            let url = localStorage.getItem('userServiceUrl')

            let formData = new FormData(event.target);

            window.axios.post(`${url}/api/v1/users/${this.$props.user.id}`, formData,
                {
                    headers: {
                        'Content-Type': 'multipart/form-data',
                        Authorization: `Bearer ${accessToken}`
                    }
                }
            )
                .then(response => {
                    location.reload()
                })
                .catch(err => err.data);
        }
    }
}
