package com.wechat.selfmenu.menu.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wx_sub_menu")
public class Menu {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	@Column(length = 36)
	private String id;
	@JsonProperty("button")
	@OneToMany
	@JoinColumn(name = "parent_id")
	private List<SubMenu> subMenus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<SubMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}
}
