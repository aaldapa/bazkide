const path = require('path');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const CopyPlugin = require('copy-webpack-plugin');

module.exports = {
  entry: { 
    'main': './src/js/index.js', // Tu entrada principal JS
    'admin/access/index': './src/js/admin/access/index.js'
  },
  output: {
    path: path.resolve(__dirname, '../src/main/resources/static/'),
    //filename: 'js/[name].js', // JS generado
    filename: (pathData) => {
      return `js/${pathData.chunk.name}.js`; // genera rutas como js/admin/index.js
    },
    clean: true, // Limpiar la carpeta de salida antes de cada build (opcional, pero útil)
  },
  module: {
    rules: [
      {
        test: /\.css$/i,
        use: [MiniCssExtractPlugin.loader, 'css-loader'],
      },
      {
        //test: /\.(woff(2)?|eot|ttf|otf|svg)$/,
        test: /\.(woff(2)?|eot|ttf|otf)$/,
        type: 'asset/resource',
        generator: {
          filename: 'webfonts/[name][ext]',
        },
      },
      {
        test: /\.(png|jpg|jpeg|gif|ico)$/i,
        type: 'asset/resource',
        generator: {
          filename: 'images/[name][ext]',
        },
      },
      {
        test: /\.(svg)$/,
        type: 'asset/resource',
        generator: {
          filename: 'images/svg/[name]-[hash][ext]',
        },
      },
    ],
  },
  plugins: [
    new MiniCssExtractPlugin({
      filename: 'css/styles.css', // Nombre del CSS generado
    }),
    ,
    new CopyPlugin({
      patterns: [
        { from: 'src/assets/images', to: 'images' },
        //{ from: 'src/assets/webfonts', to: 'webfonts' },
      ],
    }),
  ],
  mode: 'development', // 'production' o 'development' si estás desarrollando
};