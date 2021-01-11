function checkFlag(beforeEl,item) { 
    if (beforeEl && item.id == beforeEl.id) {
      return false;
    } else {
      return true;
    }
}

function unbindEvent() { //去除floatMenu上绑定的事件
    $("#sidebarFloatMenu").unbind();
}