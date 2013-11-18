package unq.tpi.persistencia.performanceEj.daos;

public class DetalleEmpleado {
	public final double salario;
	public final String firstName;
	public final String lastName;
	public final String title;
	public final String fullName;
	
	public DetalleEmpleado(double salario, String firstName,
			String lastName, String title) {
		super();
		this.salario = salario;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.fullName = this.lastName+", " + this.firstName; 
		
	}

}