const webpack = require('webpack');

module.exports = {
    resolve: {
        fallback: {
            zlib: require.resolve("browserify-zlib"),
            path: require.resolve("path-browserify"),
            crypto: require.resolve("crypto-browserify"),
            stream: require.resolve("stream-browserify"),
            querystring: require.resolve("querystring-es3"),
            http: require.resolve("stream-http"),
            net: false, // Optional, depends on whether 'net' is truly required
            fs: false,  // fs is not supported in the browser
        },
    },
    plugins: [
        new webpack.ProvidePlugin({
            process: 'process/browser',
            Buffer: ['buffer', 'Buffer'],
        }),
    ],
};
