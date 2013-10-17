package unq.tpi.persistencia.performanceEj.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import unq.tpi.persistencia.performanceEj.model.Department;
import unq.tpi.persistencia.util.SessionManager;

public class DepartmentDAO {

	public Department getByName(final String name) {
		Session session = SessionManager.getSession();
		return (Department) session
				.createQuery("from Department where name = :name")
				.setParameter("name", name).uniqueResult();
	}

	public Department getByCode(String num) {
//		Criteria criteria = SessionManager.getSession().createCriteria(Department.class);
//		criteria.add(Restrictions.eq("number",num));
//		return (Department) criteria.uniqueResult();
	//	return (Department) session.get(Department.class, num);
		Session session = SessionManager.getSession();
		return (Department) session
				.createQuery("SELECT name,dept_no FROM Department WHERE dept_no= :num")
		        .setParameter("num",num);
	}

	@SuppressWarnings("unchecked")
	public List<Department> getAll() {
		Session session = SessionManager.getSession();
		return session.createCriteria(Department.class).list();
	}

}
