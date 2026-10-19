<template>
    <div>
        <div class="p-2 my-2 border">
            {{ $t('categories') }}
            <hr />
            <b-row class="my-1">
                <b-col>
                    <b-card>
                        <b-form-checkbox-group stacked name="checkButton">
                            <b-form-checkbox :value="option.id" v-for="option in cols1" :key="option.id"
                                @change="loadCategories(option.id, option.name)">
                                {{ option.name }}
                            </b-form-checkbox>
                        </b-form-checkbox-group>
                    </b-card>
                </b-col>
            </b-row>
        </div>

    </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';

export default {
    name: 'f2fCategory',
    props: {
    },
    data() {
        return {
            value: [],
            cols1: [],
            breadcrumbItems: [],
            brands: [],
            cCode: "",
            cName: "",
            form: {
                name: "",
                value: "",
                categoryId: ""
            }
        }
    },
    methods: {
        variantColors(idx) {
            return idx % 2 == 0 ? "light" : "info";
        },
        loadCategories(idv, idt) {
            console.log('idv:' + idv + ',idt:' + idt);
            var self = this;

            if (idv == 1 && self.breadcrumbItems.length > 1) {
                self.breadcrumbItems = self.breadcrumbItems.splice(0);
            }

            self.form.categoryId = idv;
            self.cName = idt;

            const url = `/Category/listById`;
          axiosInstance.get(url, {
                params: { id: idv }
            })
                .then(function (res) {
                    if (res) {
                        self.cols1 = res.data;
                        if (idv !== 1) {
                            let exist = false;
                            let idx = -1;
                            for (const [i, b] of self.breadcrumbItems.entries()) {
                                if (b.id == idv) {
                                    exist = true;
                                    idx = i;
                                }
                            }
                            if (exist == false)
                                self.breadcrumbItems.push({ text: idt, id: idv, href: '#' });
                            else {
                                let L = self.breadcrumbItems.length - 1;
                                if (L !== idx)
                                    var k = 0;
                                while (k < L - idx) {
                                    self.breadcrumbItems.pop();
                                    k++;
                                }
                            }

                        } else {
                            self.breadcrumbItems = [];
                        }

                        //load brands
                        self.loadBrands(idv);
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        loadBrands(cId) {
            var self = this;
            const url = `/brand/byCategoryId`;
          axiosInstance.get(url, {
                params: {
                    categoryId: cId
                }
            })
                .then(function (res) {
                    self.brands = res.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
    , created() {
        this.loadCategories(1, 'همه دسته ها');
    }
}
</script>

<style scoped></style>