//vue config js
module.exports = {
  publicPath: '/admin',
  //options
  devServer: {
    port: 8083,
    hot: true,
    watchOptions: {
      poll: true
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
