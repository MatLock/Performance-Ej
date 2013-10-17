package unq.tpi.persistencia.performanceEj.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import unq.tpi.persistencia.performanceEj.model.Employee;
import unq.tpi.persistencia.util.SessionManager;

public class EmployeeDAO {

	public Employee getByName(final String name, final String lastName) {
		Session session = SessionManager.getSession();
		return (Employee) session
				.createQuery(
						"from Employee where firstName = :name and lastName = :lastName")
				.setParameter("name", name).setParameter("lastName", lastName)
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		Session session = SessionManager.getSession();
		return (List<Employee>) session
			.createQuery("SELECT e FROM Employee AS e INNER JOIN e.salaries AS s WHERE to_date = '9999-01-01' ORDER BY s.amount DESC")
			.setMaxResults(10).list();
		//return session.createCriteria(Employee.class).list();
	}

	public Employee getByCode(int id) {
		Session session = SessionManager.getSession();
		return (Employee) session
				.createQuery("FROM Employee WHERE emp_no = :id")
				.setParameter("id",id)
				.uniqueResult();
	//	return (Employee) session.get(Employee.class, id);
	//	return (Employee) session.load(Employee.class, id);
	}

}
