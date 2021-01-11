/* 
 * http请求接口api
 */
import * as login from './moudules/login'
import * as permission from './moudules/permission'
import * as user from './moudules/user'
import * as menu from './moudules/menu'
import * as dict from './moudules/dict'

// 默认全部导出
export default {
    login,
    permission,
	user,
    menu,
    dict
}
