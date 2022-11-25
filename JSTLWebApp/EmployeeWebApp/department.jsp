<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="admin" class="classic.web.app.EmployeeBean" scope="session"/>
<jsp:useBean id="department" class="classic.web.app.EmployeeBean" scope="session"/>
<jsp:setProperty name="admin" property="*"/>
<c:if test="${empty admin.id}">
	<c:redirect url="admin.jsp"/>
</c:if>
<html>
	<head>
		<title>ClassicWebApp</title>
	</head>
	<body>
		<h1>Welcome to Department ${admin.id}</h1>
		<h3>Here are all Departments</h3>
		<table border="1">
			<tr>
				<th>Department ID</th>
				<th>Department Name</th>
				<th>Location</th>
			</tr>
			<c:forEach var="entry" items="${admin.department}">
				<tr>
					<td>${entry.deptId}</td>
					<td>${entry.deptName}</td>
					<td>${entry.location}</td>
				</tr>
			</c:forEach>
		</table>

		<form method = "POST" action="emp.jsp">
		<p>
			<b>Department</b>
			<input type="text" name="deptId"/>
		</p>
		<p>
			<input type="submit" name="submit" value="Details"/>
		</p>
		</form>

		<p>
			<a href="admin.jsp?signout=true">Logout</a>
		</p>
	</body>
</html>

