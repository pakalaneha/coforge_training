package com.coforge.ems.dto;

// no need to speicfy entity table and all -> because this is justa trabsfer object
public class DepartmentDTO {
	
	private int dno;
	
	private String dname;
	
	public DepartmentDTO() {
		super();
		
	}

	public DepartmentDTO(int dno,String dname) {
		super();
		this.dno = dno;
		this.dname = dname;
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Department [dno=" + dno + ", dname=" + dname + "]";
	}
	
	
	
	
}
