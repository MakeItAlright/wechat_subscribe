package com.subscribe.selfmenu.menu.service;

import com.subscribe.selfmenu.menu.domain.SelfMenu;

public interface SelfMenuService {

	SelfMenu findMenus();

	void save(SelfMenu menu);

}
