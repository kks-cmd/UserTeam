import Vue from 'vue'
import vuex from 'vuex'

Vue.use(vuex);

import user from './modules/user'

const store = new vuex.Store({
    modules: {
        user:user
    }
})
export const $store=function(){
    return store;
}
export default store