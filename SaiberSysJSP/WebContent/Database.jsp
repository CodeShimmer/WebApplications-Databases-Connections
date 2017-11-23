<html>
<body>

<%@page import="java.sql.DriverManager,java.sql.Connection,java.sql.Statement,java.sql.ResultSet"%>

<%!
     Connection con;
     Statement st;
     ResultSet r;
     String username,password;
     String databasepassword;
%>

<%
    username=request.getParameter("username");
	password=request.getParameter("password");
	
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/us","root","");
    st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    r=st.executeQuery("select password from users where username='"+username+"'");
    if(r.next()==false)
    {
    	out.println("Invalid Data given");
    }  
    else
    {
      r.beforeFirst();	
      r.next();
      databasepassword=r.getString(1);
   // out.print(databasepassword);
    
    if(password.equals(databasepassword))
      out.println("Login Success");
    else
    	out.println("Login Fail");
    }
%>

</body>
</html>