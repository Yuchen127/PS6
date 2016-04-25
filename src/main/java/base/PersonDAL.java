package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.PersonDomainModel;
import util.HibernateUtil;

public class PersonDAL {

	public static PersonDomainModel addPerson(PersonDomainModel per) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction px = null;
		int personID = 0;
		try {
			px = session.beginTransaction();
			session.save(per);
			px.commit();
		} catch (HibernateException e) {
			if (px != null)
				px.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return per;
	}

	public static ArrayList<PersonDomainModel> getPersons() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction px = null;
		PersonDomainModel perGet = null;		
		ArrayList<PersonDomainModel> pers = new ArrayList<PersonDomainModel>();
		
		try {
			px = session.beginTransaction();	
			
			List people = session.createQuery("FROM PersonDomainModel").list();
			for (Iterator iterator = people.iterator(); iterator.hasNext();) {
				PersonDomainModel stu = (PersonDomainModel) iterator.next();
				pers.add(stu);

			}
			
			px.commit();
		} catch (HibernateException e) {
			if (px != null)
				px.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pers;
	}		

	public static PersonDomainModel getPerson(UUID perID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction px = null;
		PersonDomainModel perGet = null;		
		
		try {
			px = session.beginTransaction();	
									
			Query query = session.createQuery("from PersonDomainModel where personId = :id ");
			query.setParameter("id", perID.toString());
			
			List<?> list = query.list();
			perGet = (PersonDomainModel)list.get(0);
			
			px.commit();
		} catch (HibernateException e) {
			if (px != null)
				px.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return perGet;
	}		

	public static void deletePerson(UUID perID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction px = null;
		PersonDomainModel perGet = null;		
		
		try {
			px = session.beginTransaction();	
									
			PersonDomainModel per = (PersonDomainModel) session.get(PersonDomainModel.class, perID);
			session.delete(per);
		
			
			px.commit();
		} catch (HibernateException e) {
			if (px != null)
				px.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}	

	public static PersonDomainModel updatePerson(PersonDomainModel per) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction px = null;
		PersonDomainModel perGet = null;		
		
		try {
			px = session.beginTransaction();	
									
			session.update(per);
	
			
			px.commit();
		} catch (HibernateException e) {
			if (px != null)
				px.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return per;
	}		
}