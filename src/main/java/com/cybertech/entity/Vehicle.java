package com.cybertech.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/11/11. 下午6:41
 */
public class Vehicle {

	private String hphm;
	private String hpzl;
	private List<Relation> list = new ArrayList<>();


	public String getHphm() {
		return hphm;
	}

	public void setHphm(String hphm) {
		this.hphm = hphm;
	}

	public String getHpzl() {
		return hpzl;
	}

	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}

	public List<Relation> getList() {
		return list;
	}

	public void setList(List<Relation> list) {
		this.list = list;
	}
}
