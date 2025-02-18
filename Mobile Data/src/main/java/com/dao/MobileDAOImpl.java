package com.dao;

import com.entity.Mobile;
import com.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MobileDAOImpl implements MobileDAO {
	public int saveMobile(Mobile mobile) {
		int i = 0;
		Transaction transaction = null;
		try (Session session = HibernateUtility.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(mobile);
			transaction.commit();
			i = 1;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return i;
	}

	public Mobile getMobileById(String id) {
		try (Session session = HibernateUtility.getSessionFactory().openSession()) {
			return session.get(Mobile.class, id);
		}
	}

	public List<Mobile> getAllMobiles() {
		List<Mobile> mList = new ArrayList<Mobile>();

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		try {
			Query<Mobile> query = session.createQuery("from Mobile", Mobile.class);
			mList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (mList.isEmpty()) {
			System.out.println("No DATA found.....");

		}
		return mList;
	}

	public int updateMobile(Mobile mobile) {
		int i = 0;
		Transaction transaction = null;
		try (Session session = HibernateUtility.getSessionFactory().openSession()) {

			Mobile mob = (Mobile) session.get(Mobile.class, mobile.getModelNo());
			if (mob != null) {
				mob.setPrice(mobile.getPrice());
				transaction = session.beginTransaction();

				session.update(mob);
				transaction.commit();
				i = 1;
				session.close();
			}

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();

		}
		return i;
	}

	public int deleteMobile(String id) {
		int i = 0;
		Transaction transaction = null;
		try (Session session = HibernateUtility.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Mobile mobile = session.get(Mobile.class, id);
			if (mobile != null) {
				session.delete(mobile);
				transaction.commit();
				i = 1;
			}
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return i;

	}
}
