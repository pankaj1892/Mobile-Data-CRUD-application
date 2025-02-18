package com.service;

import java.util.List;

import com.entity.Mobile;

public interface MobileService {
	public int addMobile(Mobile mobile);

	public Mobile readMobileById(String id);

	public List<Mobile> readAllMobiles();

	public int modifyMobile(Mobile mobile);

	public int removeMobile(String id);

}
