<%@ page errorPage="Errorpage2.jsp" %> 
<%!
    String num1;
    String num2;
    int a,b,c;
%> 
<%  
 
num1=request.getParameter("n1");  
num2=request.getParameter("n2");  
  
a=Integer.parseInt(num1);  
b=Integer.parseInt(num2);  
c=a/b;  
out.print("division of numbers is: "+c);
  
%>  