'use strict';

const path = require('path');
const webpack = require('webpack');

module.exports = {
    plugins: [
        new webpack.optimize.CommonsChunkPlugin({
            name: 'vendor',
            minChunks: function (module) {
                return module.context && module.context.indexOf('node_modules') !== -1;
            }
        }),
        new webpack.optimize.CommonsChunkPlugin({
            name: 'manifest'
        })
    ],
    entry: {
        bundle: [
            './js/angular/app.mdl.js',
            './js/angular/user_registration/user_registration.ctrl.js',
            './js/angular/services/users.srv.js'
        ]
    },
    output: {
        //Production version
        // filename: '[name].[chunkhash].js',
        //Develop version
        filename: '[name].js',
        path: path.resolve(__dirname, 'dist')
    }
};