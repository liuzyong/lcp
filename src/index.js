import { StrictMode } from "react";
import dva from 'dva';
import ReactDOM from "react-dom";
// import Form from "@rjsf/core";
import App from "./App";

const createHistory = require("history").createHashHistory // 这里使用的hash路由模式
// 创建应用
const app = dva({ history: createHistory() })

// 注册model, 会这样会自动导入global的mode
// app.model(require('./models/global').default)
require('./models').default.forEach(key => app.model(key.default))

// 注册路由
app.router(App)
// 启动应用
app.start('#root')



