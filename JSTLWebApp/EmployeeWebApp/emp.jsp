<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="department" class="classic.web.app.EmployeeBean" scope= "session"/>
<jsp:setProperty name="department" property="*"/>
<html>
	<head>
		<title>ClassicWebApp</title>
	</head>
	<body>
		<h1>
		<b>Employee Details</b>
		</h1>

	<h3>Details Of Employees From Department=${param.deptId}</h3>
		
		<table border="1">
			<tr>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Employee Salary</th>
				<th>Employee Commision</th>
				<th>Employee Age</th>
			</tr>
		<c:forEach var="entry" items="${department.employee}">
				<tr>
					<td>${entry.empId}</td>
					<td>${entry.empName}</td>
					<td>${entry.empSalary}</td>
					<td>${entry.empCommision}</td>
					<td>${entry.empAge}</td>
				</tr>
			</c:forEach>
		</table>
		<p>

			<a href="admin.jsp">Logout</a>	
		</p>
	</body>
</html>

