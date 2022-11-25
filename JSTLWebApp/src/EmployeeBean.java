package classic.web.app;

import java.sql.*;
import java.util.*;

public class EmployeeBean implements java.io.Serializable {

	private int id;
	private String password;
	private int dept_id;

	public final int getId() { return id; }
	public final void setId(int value) { id = value; }

	public final int getDeptId() {return dept_id;}
	public final void setDeptId(int value) {dept_id=value;}

	public final String getPassword() { return password; }
	public final void setPassword(String value) { password = value; }

	public boolean authenticate() throws SQLException {
		try(var con = DB.connect()){
			var pstmt = con.prepareStatement("select count(id) from admin where id=? and pass=?");
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			var rs = pstmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			rs.close();
			pstmt.close();
			if(count == 1)
				return true;
			password = null;
			return false;
		}
	}

	public List<DepartmentEntry> getDepartment() throws SQLException {
		var department = new ArrayList<DepartmentEntry>();
		try(var con = DB.connect()){
			var pstmt = con.prepareStatement("select dept_id, dept_name, location from department ");
			//pstmt.setInt(1, id);
			var rs = pstmt.executeQuery();
			while(rs.next())
				department.add(new DepartmentEntry(rs));
			rs.close();
			pstmt.close();
		}
		return department;
	}


	public static class DepartmentEntry {
		
		private int dept_id;
		private String dept_name;
		private String location;

		DepartmentEntry(ResultSet rs) throws SQLException {
			dept_id = rs.getInt("dept_id");
			dept_name = rs.getString("dept_name");
			location = rs.getString("location");
		}

		public final int getDeptId() { return dept_id; }

		public final String getDeptName() { return dept_name; }

		public final String getLocation() { return location; }
	}
	public List<EmpEntry> getEmployee() throws SQLException {
		var emp = new ArrayList<EmpEntry>();
		try(var con = DB.connect()){
			var pstmt = con.prepareStatement("select eid, empname, salary, commision, empage from emp where deptno=?");
			pstmt.setInt(1, dept_id);
			var rs = pstmt.executeQuery();
			while(rs.next())
				emp.add(new EmpEntry(rs));
			rs.close();
			pstmt.close();
		}
		return emp;
	}


	public static class EmpEntry {
		
		private String eid;
		private String name;
		private int salary;
		private int commision;
		private int age;

		EmpEntry(ResultSet rs) throws SQLException {
			eid = rs.getString("eid");
			name = rs.getString("empname");
			salary = rs.getInt("salary");
			commision = rs.getInt("commision");
			age = rs.getInt("empage");
		}

		public final String getEmpId() { return eid; }
		
		public final String getEmpName() { return name; }
		
		public final int getEmpSalary() { return salary; }

		public final int getEmpCommision() { return commision; }

		public final int getEmpAge() { return age; }
	}
}


