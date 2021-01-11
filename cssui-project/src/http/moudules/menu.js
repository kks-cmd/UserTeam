
/* 
 * 菜单
 */
// cssvue:查找导航菜单树
export const loadNavTree = (params) => {
    return {
        url: '/rest/menu/listMenus',
        method: 'get',
        params,
        openMock:true,
        mock:function(){
            return  [
                { "id": "Home", "name": "首页","active": "active", "path": "Home", "icon": "fa fa-fw fa-home", "iconColor": "blue", "openIcon": "fa fa-fw fa-navicon", "funcode": "CssWidgets", "visible": true, "isLast": true, "parentId": "firstPage", "level": 2, "menus": []},
            ]
          }
        }
    }
    export const getFastMenus = (params) => {
        return {
            url: '/rest/menu/getFastMenu',
            method: 'get',
            params,
            openMock:true,
            mock:function(){
                return  [] 
              }
            }
        }

    