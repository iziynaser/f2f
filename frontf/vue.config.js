module.exports = {
  publicPath: '/store',
  outputDir: 'dist',
  devServer: {
    port: 8082,
    hot: true,
    watchOptions: {
      poll: true
    },
    proxy: {
      '/api': {
        target: 'http://localhost', // آدرس سرور Spring Boot شما
        changeOrigin: true,
        secure: false,
        pathRewrite: { '^/api': '/api' } // مسیرهای /api بدون تغییر به سرور فرستاده شود
      }
    }
  },

  configureWebpack: {
    devtool: 'source-map'
  },

  pluginOptions: {

  }

  // build: {
  //   assetsPublicPath: '/',
  //   assetsSubdirectory:'public'
  // }
}
