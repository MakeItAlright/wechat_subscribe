package com.subscribe.selfmenu.menu.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "wx_self_menu")
public class SelfMenu {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	@Column(length = 36)
	private String id;

	// 一个自定义菜单，最多包含3个一级菜单
	@OneToMany(cascade = CascadeType.ALL) // 一对多
	@JoinColumn(name = "menu_id")
	private List<Menu> subMenus = new LinkedList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Menu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
	}

}
