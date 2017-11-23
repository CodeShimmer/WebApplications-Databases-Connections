import java.io.*;
import java.util.Enumeration;

import javax.servlet.*;  
import javax.servlet.http.*;  
  
  
public class DemoServlet extends HttpServlet{  
public void doGet(HttpServletRequest req,HttpServletResponse res)  
throws ServletException,IOException  
{  
res.setContentType("text/html");  
PrintWriter out=res.getWriter();  
  
ServletContext context=getServletContext();  
Enumeration<String> e=context.getInitParameterNames();  
      
String str="";  
while(e.hasMoreElements()){  
    str=e.nextElement();  
    out.print("<br> "+context.getInitParameter(str));  
}  
}}  