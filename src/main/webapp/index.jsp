<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page language="java" import="java.util.*" %>
    <%@page import="com.resteasyjpa.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body>
    <table border="1">
      <tr>
         <td>ID</td>
         <td>Amount</td>
         <td>Date</td>
         <td><b>Action</b></td>
      </tr>
        <%
           List lst = (List)request.getAttribute("data");
        Iterator itr = lst.iterator();
         while(itr.hasNext()){
        	 Expenses details = (Expenses)itr.next();
        %>
        <tr>
           <td><%=details.getId() %></td>
           <td><%=details.getAmount() %></td>
           <td><%=details.getDate() %></td>
           <td><a href="/RestEasyJpa/hello?id=<%=details.getId() %>"><button type="button" >Delete</button></a></td>
        </tr>
        <%} %>
    </table> 
    <br>
      <a a href="add.jsp"><button type="button">ADD</button></a> 
</body>
</html>
