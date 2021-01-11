module.exports = {

    publicPath: '/',　　
  
    // 将构建好的文件输出到哪里（或者说将编译的文件）
    outputDir: 'dist',
  
    // 放置静态资源的地方 (js/css/img/font/...)
    assetsDir: 'static',
  
    pages: {
      index: {
        // 入口文件
        entry: 'src/main.js',　　/*这个是根入口文件*/
        // 模板文件
        template: 'public/index.html',
        // 输出文件
        filename: 'index.html',
      },

      subpage: 'src/main.js'　
    },

    lintOnSave: true,
 
    runtimeCompiler: false,
  
    transpileDependencies: [/* string or regex */],
 
    productionSourceMap: true,

    chainWebpack: () => {},
    configureWebpack: () => {},
  
    // CSS 相关选项
    css: {
      extract: true,
      sourceMap: false,
      loaderOptions: {},
      modules: false
    },
    parallel: require('os').cpus().length > 1,
    // 配置 webpack-dev-server 行为。
    devServer: {
      open: false,
      host: '0.0.0.0',
      port: 8080,
      https: false,
      hotOnly: false,
     before: app => {}
    },
    // 三方插件的选项
    pluginOptions: {
      // ...
    }
  }