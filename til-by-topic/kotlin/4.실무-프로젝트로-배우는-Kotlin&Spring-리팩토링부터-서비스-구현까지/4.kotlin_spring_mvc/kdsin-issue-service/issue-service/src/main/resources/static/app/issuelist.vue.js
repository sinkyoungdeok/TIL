const IssueList = {
    template: `
    <q-page-container>
             <q-page padding>
                <div class="q-pa-lg q-gutter-md row ">
                    <div class="q-gutter-md row">
                        <q-card @click="clickIssue(issue.id)" class="my-card cursor-pointer " v-for="issue in $props.issues"  v-ripple>
                            <q-card-section  v-if="issue.priority === 'HIGH'" class="bg-red-8 text-white">                          
                                <div class="text-h6">{{issue.summary}}</div>
                            </q-card-section>
                            
                            <q-card-section v-if="issue.priority === 'MEDIUM'" class="bg-orange-4 text-white">
                                <div class="text-h6">{{issue.summary}}</div>
                            </q-card-section>
                            
                            <q-card-section  v-if="issue.priority === 'LOW'" class="bg-green-4 text-white">
                                <div class="text-h6">{{issue.summary}}</div>
                            </q-card-section>
                            
                    
                            <q-card-section>
                                <span>{{typeLabel[issue.type]}}</span>
                            </q-card-section>
                        </q-card>
                    </div>
                </div>
            </q-page>
        </q-page-container>
`,
    props: [
        'issues',
        'typeLabel'
    ],
    data() {
        return {}
    },
    methods: {
        clickIssue(id) {
            this.$emit('issueCardClicked', id)
        }
    }
}