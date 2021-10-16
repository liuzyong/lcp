const initState = { uiSchema: "Material-ui" }
export default {
  namespace: 'themes',
  state: initState,
  effects: {
    *getauditlist({ payload },{call,put }){
      const response = yield call(getauditlist);
      if (!response || response.code != codeConstants.SUCCESS.code) {
        return false;
      }
      return response;
    },
    
  },
  reducers: {
    saveThemes(state, {payload}) {
        return {
          ...state,
          uiSchema: payload
        }
      },
  }
}
