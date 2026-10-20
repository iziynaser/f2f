```
<template>
    <div>
        <b-card-group deck>
            <b-card no-body class="overflow-hidden" style="max-width: 540px;">
                <b-row no-gutters>
                    <b-col md="2">
                    </b-col>

                    <b-col md="10">
                        <b-list-group flush>
                            <b-card-body>
                                <h5>
                                    <b-icon icon="calendar" class="mr-2 text-success"></b-icon>
                                    تاریخ انتشار: {{ changelog.date }}
                                </h5>
                                <ul>
                                    <li>ww</li>
                                </ul>
                            </b-card-body>
                        </b-list-group>
                        <!-- ویژگی‌ها -->
                        <b-list-group flush>
                            <b-card-body>
                                <h5>
                                    <b-icon icon="plus-circle" class="mr-2 text-success"></b-icon>
                                    {{ $t('new_features') }}
                                </h5>
                                <ul v-if="changelog.features.length">
                                    <li v-for="(feature, index) in changelog.features" :key="'f' + index">
                                        <b-icon icon="chevron-right" class="mr-1 text-primary"></b-icon>
                                        {{ feature }}
                                    </li>
                                </ul>
                                <p v-else class="text-muted">هیچ ویژگی جدیدی ثبت نشده است.</p>
                            </b-card-body>
                        </b-list-group>

                        <!-- باگ‌ها -->
                        <b-list-group flush>
                            <b-card-body>
                                <h5>
                                    <b-icon icon="bug-fill" class="mr-2 text-danger"></b-icon>
                                    Bug Fixes
                                </h5>
                                <ul v-if="changelog.fixes.length">
                                    <li v-for="(fix, index) in changelog.fixes" :key="'fx' + index">
                                        <b-icon icon="chevron-right" class="mr-1 text-primary"></b-icon>
                                        {{ fix }}
                                    </li>
                                </ul>
                                <p v-else class="text-muted">هیچ باگی گزارش نشده است.</p>
                            </b-card-body>
                        </b-list-group>
                    </b-col>
                </b-row>
            </b-card>
        </b-card-group>
    </div>
</template>

<script>
    import axios from 'axios';
    import { BIcon} from 'bootstrap-vue';

    export default {
        name: 'AppInfoCard',
        components: {
            BIcon,
        },
        data() {
            return {
                changelog: {
                    version: '',
                    date: '',
                    features: [],
                    fixes: []
                }
            };
        },
        created() {
            axios.get('/f2f/api/client/appinfo/changelog')
                .then(response => {
                    this.changelog = response.data;
                })
                .catch(err => {
                    console.error('خطا در بارگذاری changelog', err);
                });
        }
    };
</script>
```