
// Loading required libraries
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class DatabaseAccess
 */
@WebServlet("/DatabaseAccess")
public class DatabaseAccess extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		static final String DB_URL = "jdbc:mysql://localhost:3306/Employees";

		   //  Database credentials
		   static final String USER = "Kyte";
		   static final String PASS = "Junkfired2015";
		   Statement stmt;
		   String sql;
		   ResultSet rs;
		   Connection conn;
		   PreparedStatement pstmt;
	
	
	public void service(ServletRequest request, ServletResponse response)
		      throws ServletException, IOException {
		
		      // Set response content type
		      response.setContentType("text/html");
		      PrintWriter out = response.getWriter();
		      String title = "Database Result";
		      
		      String docType =
		         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		      
		      out.println(docType +
		         "<html>\n" +
		         "<head><title>" + title + "</title></head>\n" +
		         "<body bgcolor = \"#f0f0f0\">\n" +
		         "<h1 align = \"center\">" + title + "</h1>\n");
		      try {
		         // Register JDBC driver
		         Class.forName("com.mysql.jdbc.Driver");
		         

		         // Open a connection
		         conn = DriverManager.getConnection(DB_URL, USER, PASS);
				 
//				 //Open a connection
//				 out.println("Connecting to database...");
//                 //Execute a query
//				 out.println("Creating database...");
//				 stmt = conn.createStatement();
//				 sql = "CREATE DATABASE Employees";
//				 stmt.executeUpdate(sql);
//				 System.out.println("Database created successfully...");
				 int typ;
				 Scanner sc=new Scanner(System.in);
					   out.println("Enter your choice");
					   out.println("1-Show entire bank Employees Details");
					   out.println("2-Enter new bank Employee Details");
					   out.println("3-Delete a bank Employee Details(Id Required)");
					   out.println("4-update a bank Employee Details(Id Required)");
					   out.println("choice:<input type=\"number\" name=\"key\"/><br/>");
					   typ=sc.nextInt();
		switch(typ) {
			case '1':
		         // Execute SQL query
		        stmt = conn.createStatement();
		        sql = "SELECT id, first, last, age FROM Employees";
		        rs = stmt.executeQuery(sql);

		         // Extract data from result set
		         while(rs.next()){
		            //Retrieve by column name
		        	 int id  = rs.getInt("id");
		            int age = rs.getInt("age");
		            String first = rs.getString("first");
		            String last = rs.getString("last");

		            //Display values
		            out.println("ID: " + id + "<br>");
		            out.println(", Age: " + age + "<br>");
		            out.println(", First: " + first + "<br>");
		            out.println(", Last: " + last + "<br>");
		         }
		        break;
			case '2':
				sql = "insert into Employees(id, first, last, age) values(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
		         
		         //rs = stmt.executeQuery(sql);
			   
					   //Scanner sc=new Scanner(System.in);
					   out.println("Enter ID");
					   int id=sc.nextInt();
					   out.println("Enter First-Name");
					   String first=sc.next();
					   out.println("Enter last-Name");
					  String last=sc.next();
					   out.println("Enter AGE");
					   int age=sc.nextInt();
					     
					   
					   pstmt.setInt(1,id);
					   pstmt.setString(2,first);
					   pstmt.setString(3,last);
					   pstmt.setInt(4,age);
					   pstmt.executeUpdate();
					   sql = "SELECT id, first, last, age FROM Employees";
				        rs = stmt.executeQuery(sql);

		// Extract data from result set
		         while(rs.next()){
		            //Retrieve by column name
		            id  = rs.getInt("id");
		            age = rs.getInt("age");
		            first = rs.getString("first");
		            last = rs.getString("last");

		            //Display values
		            out.println("ID: " + id + "<br>");
		            out.println(", Age: " + age + "<br>");
		            out.println(", First: " + first + "<br>");
		            out.println(", Last: " + last + "<br>");
		         }
		               break;
		case '3':

		      // Execute a query
			//Scanner sc=new Scanner(System.in);
			out.println("Enter ID");
				   id=sc.nextInt();
		         stmt = conn.createStatement();
		      sql = "DELETE FROM Employees" +
		                   "WHERE id = id";
		      stmt.executeUpdate(sql);
		      rs = stmt.executeQuery(sql);
		      while(rs.next()){
		         //Retrieve by column name
		        id  = rs.getInt("id");
		        age = rs.getInt("age");
		        first = rs.getString("first");
		        last = rs.getString("last");

		         //Display values
		         out.print("ID: " + id);
		         out.print(", Age: " + age);
		         out.print(", First: " + first);
		         out.println(", Last: " + last);
		      }
		 break;
		case '4':
		// Execute a query
		      //Scanner sc=new Scanner(System.in);
		out.println("Enter ID");
			sc.nextInt();
					   out.println("Enter First-Name");
			sc.next();
					   out.println("Enter last-Name");
			sc.next();
					   out.println("Enter AGE");
			sc.nextInt();
		      stmt = conn.createStatement();
		      sql = "UPDATE Employees" +
		                   "SET first=first1, last=last1, age = age1  WHERE id in (id1)";
		      stmt.executeUpdate(sql);

		      // Now you can extract all the records
		      // to see the updated records
		      sql = "SELECT id, first, last, age FROM Employees";
		      rs = stmt.executeQuery(sql);

		      while(rs.next()){
		         //Retrieve by column name
		         id  = rs.getInt("id");
		         age = rs.getInt("age");
		         first = rs.getString("first");
		         last = rs.getString("last");

		         //Display values
		         out.print("ID: " + id);
		         out.print(", Age: " + age);
		         out.print(", First: " + first);
		         out.println(", Last: " + last);

			}
			break;
			case '5':
			stmt = conn.createStatement();
			sql = "ALTER TABLE student ADD COLUMN DateOfBirth year";
			stmt.executeUpdate(sql);
			System.out.println("Table is altered successfully");
			out.println("Enter ID");
			sc.nextInt();
					   out.println("Enter Date of birth (year)");
			sc.nextInt();
					   
		      sql = "UPDATE Employees" + "SET year = year1  WHERE id in (id1)";
		      stmt.executeUpdate(sql);

		      // Now you can extract all the records
		      // to see the updated records
		      sql = "SELECT id, first, last, age FROM Employees";
		      rs = stmt.executeQuery(sql);

		      while(rs.next()){
		         //Retrieve by column name
		         id  = rs.getInt("id");
		         age = rs.getInt("age");
		         first = rs.getString("first");
		         last = rs.getString("last");

		         //Display values
		         out.print("ID: " + id);
		         out.print(", Age: " + age);
		         out.print(", First: " + first);
		         out.println(", Last: " + last);
			}
			break;
		
		}
		out.println("</body></html>");
		// Clean-up environment
		rs.close();
		stmt.close();
		conn.close();
		      }
		      
		catch(SQLException se) {
		         //Handle errors for JDBC
		         se.printStackTrace();
		      } catch(Exception e) {
		         //Handle errors for Class.forName
		         e.printStackTrace();
		      } finally {
		         //finally block used to close resources
		         try {
		            if(stmt != null)
		               stmt.close();
		         } catch(SQLException se2) {
		         } // nothing we can do
		         try {
		            if(conn != null)
		            conn.close();
		         } catch(SQLException se) {
		            se.printStackTrace();
		         } //end finally try
		      } //end try
		   }

		}


