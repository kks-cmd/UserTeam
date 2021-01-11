export default {
    state: {
        userInfo:{}
    },
    getters: {
        getUserInfo(state){
            return state.userInfo;
        }
    },
    mutations: {
        setUserInfo(state, userInfo){//当前登录用户信息
            state.userInfo = userInfo;
        }
    },
    actions: {
    }
}