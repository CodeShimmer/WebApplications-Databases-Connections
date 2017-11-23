<%@page import="java.sql.DriverManager,java.sql.Connection,java.sql.Statement,java.sql.ResultSet"%>

<%!
	Connection con;
	Statement st;
	ResultSet r;
	String username,password,databasepassword;
%>

<%
    username=request.getParameter("username");
	password=request.getParameter("password");
	
	/*
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
    st=con.createStatement();
    r=st.executeQuery("select password from users where username='"+username+"'");
    r.next();
    databasepassword=r.getString(1);
    */
    //if(databasepassword.equals(password))
    	
    if((username.compareTo("admin")==0)&&(password.compareTo("admin")==0))
    {
    %>
    	
      <jsp:forward page="success.jsp"/>
      <%
    }
    else
    {	
    
%>
<jsp:include page="ForwardClient.html"/>
<%
}
%>