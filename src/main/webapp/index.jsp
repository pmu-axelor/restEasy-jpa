<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page language="java" import="java.util.*" %>
    <%@page language="java" import="java.text.*" %>
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
         <td><b>ID</b></td>
         <td><b>Category</b></td>
         <td><b>Amount</b></td>
         <td><b>Date</b></td>
         <td><b>Action</b></td>
      </tr>   
   <%--       <%
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");

           List lst = (List)request.getAttribute("data");
           Iterator itr = lst.iterator();
            while(itr.hasNext()){
        	 Expenses details = (Expenses)itr.next();
        	// Category category = (Category)itr.next();
        %>
        <tr>
           <td><%=details.getId() %></td>
           <td><%=category.getName() %></td>
           <td><%=details.getAmount() %></td>
           <td><%=DATE_FORMAT.format(details.getDate())%></td>
           <td><a href="/RestEasyJpa/hello/delete?id=<%=details.getId() %>"><button type="button" >Delete</button></a></td>
           
        </tr>  
        <%} %>   --%>
        <%
       SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
       List<Object[]> lst = (List<Object[]>)request.getAttribute("data");
         for(Object[] result : lst){
       %> 
         <tr>
           <td><%=result[0]%></td>
           <td><%=result[1]%></td>
           <td><%=result[2] %></td>
           <td><%=DATE_FORMAT.format(result[3])%></td>
           <td><a href="/RestEasyJpa/hello/delete?id=<%=result[0] %>"><button type="button" >Delete</button></a></td>
           
        </tr>  
        <%} %> 
    </table> 
    <br>
      <a href="add.jsp"><button type="button">ADD</button></a> 
       <a href="addCategory.jsp"><button type="button">ADD CATEGORY</button></a>
</body>
</html>
