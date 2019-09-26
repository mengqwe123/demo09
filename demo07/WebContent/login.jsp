<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户登录</title>
</head>
<script type="text/javascript">
function validate(f){
	
	if(!(/^\w{5,15}$/.test(f.userid.value))){
		alert("用户ID必须是5-15位！！");
		f.userid.focus();
		return false;
	}
	if(!(/^\w{5,15}$/.test(f.userpass.value))){
		alert("密码必须是5-15位！！");
		f.userpass.focus();
		return false;
	}
	return true;
}
</script>
<body>
<h2>用户登录程序</h2>
<%
request.setCharacterEncoding("GBK");
%>
<%
List<String>info=(List<String>)request.getAttribute("info");
if(info!=null){
	Iterator<String>iter=info.iterator();
while(iter.hasNext()){
	%>
<h4><%=iter.next() %></h4>
<%	
}
}
%>
<form action="LoginServlet" method="post" onSubmit="return validate(this)">

用户ID:<input type="text" name="userid"><br>
密&nbsp;&nbsp;码:<input type="text" name="userpass"><br>
<input type="reset" value="重置"  >
<input type="submit" value="登录" >
</form>
</body>
</html>