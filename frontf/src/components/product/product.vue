<template>
  <div>
    <!-- عنوان و ویژگی‌های کلی -->
    <div class="title-box-with-major-attrib mb-3 p-3 bg-light rounded shadow-sm">
      <div>
        <product-title :title="title" :productId="id" />
      </div>
    </div>

    <!-- محتوای اصلی -->
    <div class="container">
      <div class="row">

        <!-- آیکن‌های جانبی -->
        <div class="col-auto d-flex flex-column align-items-center p-2">
          <b-icon-heart class="mb-3 h4 text-primary" title="افزودن به علاقه مندی ها"/>
          <b-icon-share class="mb-3 h4 text-primary"  title="به اشتراک گذاری کالا"/>
          <b-icon-alarm class="mb-3 h4 text-primary"  title="اطلاع رسانی شگفت انگیز"/>
          <b-icon-square-half class="mb-3 h4 text-primary"  title="مقایسه کالا"/>
          <b-icon-graph-up class="mb-3 h4 text-primary" title="نمودار قیمت"/>
          <b-icon-files
              class="mb-3 h4 text-primary"
              role="button"
              style="cursor: pointer;"
              title="افزودن به مقایسه"
              @click="addToCompare(id)"
          />

          <b-icon-binoculars
              title = "مشاهده مقایسه کالاها"
              class="mb-3 h4 text-primary"
              :disabled="compareList.length === 0"
              @click="$router.push({ name: 'Compare' })"
          />
        </div>

        <!-- تصاویر -->
        <div class="col">
          <sImages :thumbnailImages="thumbnailArrayImages" :productImages="productArrayImages" />
        </div>

        <!-- توضیحات محصول -->
        <div class="col-sm">
          <p class="text-muted mb-2">{{ $t('PRODUCT_INTRO') }}</p>

          <b-list-group horizontal class="mb-2">
            <b-list-group-item>
              <f2fBadge :name="$t('comments')" :address="`/comments/product/${id}/count`" />
            </b-list-group-item>
            <b-list-group-item>
              <f2fBadge :name="$t('sales')" :address="`/comments/product/${id}/rating`" />
            </b-list-group-item>
          </b-list-group>

          <colorMoreLess v-if="validProductId" :productId="id" class="mb-3" />

          <b-row class="mb-2">
            <b-col>
              <strong>{{ $t('brand') }}: </strong>
              {{ brandName || $t('no_brand') }}
            </b-col>
            <b-col>
              <strong>{{ $t('category') }}:</strong>
              cleaning tools
            </b-col>
          </b-row>

          <moreLess />
        </div>

        <!-- قیمت و خرید -->
        <div class="col-sm">
          <div>
            <productAttribute />
          </div>
          <ProductPriceAddToCart :basePrice="product.basePrice" :finalPrice="product.finalPrice"
            @add-to-cart="addToCart" />
        </div>

      </div>
    </div>

    <!-- مشابه و تب‌ها -->
    <div class="mt-4">
      <similarProduct :productId="id" />
      <ProductSectionTabs :id="id" targetType="PRODUCT" />
    </div>
  </div>
</template>

<script>
import {mapActions, mapGetters} from 'vuex';
import ProductSectionTabs from './ProductSectionTabs.vue';
import productTitle from './productTitle.vue';
import sImages from './sImages.vue';
import similarProduct from './similarProduct.vue';
import productAttribute from './productAttribute.vue';
import moreLess from './moreLess.vue';
import colorMoreLess from './colorMoreLess.vue';
import ProductPriceAddToCart from './ProductPriceAddToCart.vue';
import f2fBadge from '../base/f2fBadge.vue';
import { loadListOfImages } from './file-upload.service';
import axiosInstance from '@/api/axiosInstance';

export default {
  name: 'Product',
  props: {
    id: [Number, String],
    title: String
  },
  components: {
    ProductSectionTabs,
    productTitle,
    sImages,
    similarProduct,
    productAttribute,
    moreLess,
    colorMoreLess,
    ProductPriceAddToCart,
    f2fBadge
  },
  data() {
    return {
      brandName: '',
      product: {
        basePrice: 0,
        finalPrice: 0,
        discountName: ''
      },
      thumbnailArrayImages: [],
      productArrayImages: []
    };
  },
  computed: {
    ...mapGetters('compare', ['getCompareList']),
    compareList() {
      return this.getCompareList;
    },
    validProductId() {
      return this.id && Number(this.id) > 0;
    }
  },
  methods: {
    ...mapActions('cart', ['addToCart']),
    ...mapActions('compare', ['addProductToCompare']),
    addToCompare(productId) {
      this.addProductToCompare(productId)
          .then(() => {
            this.$bvToast.toast('محصول به لیست مقایسه اضافه شد.', {
              title: 'موفق',
              variant: 'success',
              solid: true,
              autoHideDelay: 3000
            });
          })
          .catch(() => {
            this.$bvToast.toast('خطا در افزودن محصول به مقایسه.', {
              title: 'خطا',
              variant: 'danger',
              solid: true,
              autoHideDelay: 3000
            });
          });
    },
    fetchBrand() {
      axiosInstance.get('/brand/byProductItemId', { params: { id: this.id } })
        .then(res => {
          this.brandName = res.data || '';
        })
        .catch(err => {
          console.error('خطا در دریافت برند:', err);
        });
    },
    showThumbnailImages() {
      loadListOfImages(this.id, 'small')
        .then(images => {
          this.thumbnailArrayImages = images;
        })
        .catch(console.error);
    },
    showMediumImages() {
      loadListOfImages(this.id, 'medium')
        .then(images => {
          this.productArrayImages = images;
        })
        .catch(console.error);
    }
  },
  created() {
    if (this.validProductId) {
      this.fetchBrand();
    }
  },
  mounted() {
    this.showThumbnailImages();
    this.showMediumImages();
  }
};
</script>

<style scoped>
.title-box-with-major-attrib {
  border-left: 5px solid #007bff;
  background-color: #f8f9fa;
}
</style>
