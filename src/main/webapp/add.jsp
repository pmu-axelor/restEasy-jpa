<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Welcome</title>
</head>
<body>
     <h1 >Enter Student details </h1>
     <form action="/RestEasyJpa/hello/addExpenses" method="post">
      Amount<input type="text" name="amt">
      Date<input type="date" name="edate">
      <button type="submit">OK</button>
    </form>  
   
</body>
</html>  