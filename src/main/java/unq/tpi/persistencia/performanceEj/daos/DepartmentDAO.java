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
		Session session = SessionManager.getSession();
		return (Department) session.get(Department.class, num);
	}

	@SuppressWarnings("unchecked")
	public List<Department> getAll() {
		Session session = SessionManager.getSession();
		return session.createCriteria(Department.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<DetalleEmpleado> detallesEmpEnDepto(Department dpt) {

		Session session = SessionManager.getSession();
		return (List<DetalleEmpleado>) session
				.createQuery(
						"SELECT new unq.tpi.persistencia.performanceEj.daos.DetalleEmpleado(s.amount, e.firstName, e.lastName, t)  FROM Department d join d.employees e join e.salaries s join e.titles t where d = ? and s.to = '9999-01-01'")
				.setEntity(0, dpt).list();

	}
	
	public Double sumarSalarios(Department depto) {
		Session session = SessionManager.getSession();
		return (Double) session
				.createQuery(
						"SELECT sum(s.amount) FROM Department d join d.employees e join e.salaries s where d = ? and s.to = '9999-01-01'")
				.setEntity(0, depto).uniqueResult();

	}

}
