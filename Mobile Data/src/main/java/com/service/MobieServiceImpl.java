package com.service;

import java.util.List;

import com.dao.MobileDAO;
import com.dao.MobileDAOImpl;
import com.entity.Mobile;

public class MobieServiceImpl implements MobileService {

	MobileDAO dao = new MobileDAOImpl();

	@Override
	public int addMobile(Mobile mobile) {

		return dao.saveMobile(mobile);
	}

	@Override
	public Mobile readMobileById(String id) {
		return dao.getMobileById(id);
	}

	@Override
	public List<Mobile> readAllMobiles() {
		return dao.getAllMobiles();
	}

	@Override
	public int modifyMobile(Mobile mobile) {
		return dao.updateMobile(mobile);
	}

	@Override
	public int removeMobile(String id) {
		return dao.deleteMobile(id);
	}

}
