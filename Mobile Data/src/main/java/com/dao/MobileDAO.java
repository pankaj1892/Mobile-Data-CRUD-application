package com.dao;

import com.entity.Mobile;
import java.util.List;

public interface MobileDAO {
	public int saveMobile(Mobile mobile);

	public Mobile getMobileById(String id);

	public List<Mobile> getAllMobiles();

	public int updateMobile(Mobile mobile);

	public int deleteMobile(String id);
}
