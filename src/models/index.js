//输出modles目录下 *.js 文件 除index.js
const context = require.context('./',false,/\.js$/);
export default context
    .keys()
    .filter(item=>item != "./index.js")
    .map(key=>context(key))