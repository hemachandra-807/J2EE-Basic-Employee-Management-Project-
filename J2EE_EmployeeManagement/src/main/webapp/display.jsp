<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%String id = request.getParameter("id");%>
<%String name = request.getParameter("name"); %>
<%String age = request.getParameter("age"); %>
<%String salary = request.getParameter("salary"); %>
<%String gender = request.getParameter("gender"); %>

<h1>ID: <%=id %></h1>
<h1>ID: <%=name %></h1>
<h1>ID: <%=age %></h1>
<h1>ID: <%=salary %></h1>
<h1>ID: <%= %></h1>
</body>
</html>