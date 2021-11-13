const initState = { uiSchema: "Material-ui" }
export default {
  namespace: 'themes',
  state: initState,
  effects: {
        
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
