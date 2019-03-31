package com.gaurav.datastructures.others;

public class Employee implements Cloneable {

	private int empoyeeId;
	private String employeeName;
	private Department department;

	public Employee(int id, String name, Department dept) {
		this.empoyeeId = id;
		this.employeeName = name;
		this.department = dept;
	}

	public int getEmpoyeeId() {
		return empoyeeId;
	}

	public void setEmpoyeeId(int empoyeeId) {
		this.empoyeeId = empoyeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	// For Shallow Copy
	/*@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}*/
	
	//Modified clone() method in Employee class for Deep Copy
	@Override
	protected Object clone() throws CloneNotSupportedException {
	    Employee cloned = (Employee)super.clone();
	    cloned.setDepartment((Department)cloned.getDepartment().clone());  
	    return cloned;
	}

}
