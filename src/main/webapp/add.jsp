<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page language="java" import="java.util.*" %>
    <%@page import="com.resteasyjpa.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Welcome</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

     <h1 >Enter details </h1>
     <form action="/RestEasyJpa/hello/addExpenses" method="post">
      Amount<input type="text" name="amt">
      Date<input type="date" name="edate">
       <label for="catgs">Category</label>
      <select name="catg" id="catg">
      <option>Select Category</option>
      </select>
      <br><br>
      <button type="submit">OK</button>  
    </form>
    
       <script>
        $(document).ready(function () {
            $.ajax({
                url: "hello/dropDown",
                datatype: "JSON",
                type: "GET",
              success:function (data) {
                	console.log(data);
                	  $.each(data, function (key, value)  {
                     	 $('#catg').append('<option value="' + value.id + '">' + value.name + '</option>')
                         } ); 
                } 
            });  
        });
    </script>
</body> 
</html>  