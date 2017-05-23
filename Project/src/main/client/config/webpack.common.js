var webpack = require('webpack');
var CopyWebpackPlugin = (CopyWebpackPlugin = require('copy-webpack-plugin'), CopyWebpackPlugin.default || CopyWebpackPlugin);
var HtmlWebpackPlugin = require('html-webpack-plugin');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var helpers = require('./helpers');
var autoprefixer = require('autoprefixer');
var ProvidePlugin = require('webpack/lib/ProvidePlugin'); 
var failPlugin = require('webpack-fail-plugin');

module.exports = {
  postcss: [autoprefixer],
  entry: {
    'polyfills': './src/polyfills.ts',
    'vendors': './src/vendors.ts',
    'app': './src/boot.ts'
  },
  resolve: {
    extensions: ['', '.js', '.ts']
  },
  module: {
    preloaders: [
      {
      test: /\.js$/,
      loader: 'source-map-loader',
      exclude: [
        // these packages have problems with their sourcemaps
        helpers.root('node_modules/@ngrx/core'),
        helpers.root('node_modules/@ngrx/router'),
        helpers.root('node_modules/@angular'),
        helpers.root('node_modules/rxjs')
      ]
    }
    ],
    loaders: [
      {
        test: /\.ts$/,
        exclude: '/node_modules/',
        loader: 'awesome-typescript-loader'
      },
      {
        test: /\.html$/,
        exclude: '/node_modules/',
        loader: 'html'
      },
      {
        test: /\.(png|jpe?g|gif|svg|woff|woff2|ttf|eot|ico)$/,
        exclude: '/node_modules/',
        include: helpers.root('assets', 'img'),
        loader: 'file?name=assets/img/[name].[ext]'
      },
      {
        test: /\.css$/,
        exclude: helpers.root('src','app'),
        loader: ExtractTextPlugin.extract('style', 'css?sourceMap')
      },
      {
        test: /\.css$/,
        include: helpers.root('src','app'),
        loader: 'raw'
      },
      {
        test: /\.woff(\?v=\d+\.\d+\.\d+)?$/,
        loader: "url?limit=10000&minetype=application/font-woff"
      }, {
        test: /\.woff2(\?v=\d+\.\d+\.\d+)?$/,
        loader: "url?limit=10000&minetype=application/font-woff"
      }, {
        test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/,
        loader: "url?limit=10000&minetype=application/octet-stream"
      }, {
        test: /\.eot(\?v=\d+\.\d+\.\d+)?$/,
        loader: "file"
      }, {
        test: /\.svg(\?v=\d+\.\d+\.\d+)?$/,
        loader: "url?limit=10000&minetype=image/svg+xml"
      }
    ]
  },

  plugins: [
    failPlugin,
    new CopyWebpackPlugin([{
      from: 'assets/',
      to: 'assets/'
    }]),
    new CopyWebpackPlugin([{
      from: 'node_modules/jquery/dist/',
      to: 'assets/vendors/jquery/'
    }]),
    new CopyWebpackPlugin([{
      from: 'node_modules/bootstrap/dist/',
      to: 'assets/vendors/bootstrap/'
    }]),
    new CopyWebpackPlugin([{
      from: 'node_modules/font-awesome/css',
      to: 'assets/vendors/font-awesome/css'
    }]),
    new CopyWebpackPlugin([{
      from: 'node_modules/font-awesome/fonts',
      to: 'assets/vendors/font-awesome/fonts'
    }]),
    new webpack.optimize.CommonsChunkPlugin({
      name: ['app', 'vendors', 'polyfills']
    }),
    new ProvidePlugin({
            jQuery: 'jquery',
            $: 'jquery',
            jquery: 'jquery',
            "Tether": 'tether',
            "window.Tether": "tether"
        }),
    new HtmlWebpackPlugin({
      template: 'src/index.html',
      chunksSortMode: 'dependency'
    })
  ],
  node: { global: 'window', progress: false, crypto: 'empty', module: false, clearImmediate: false, setImmediate: false }
};