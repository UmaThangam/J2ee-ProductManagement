

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Searchproduct_servlet")
public class Searchproduct_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name,brand;
		PrintWriter pw=response.getWriter();
	//	pw.println("<table border='1'><th>Name</th><th>Brand</th><th>Price</th><th>MFD</th><th>Stock</th></tr>");
		try {
			name=request.getParameter("name");
			brand=request.getParameter("brand");
			int count=0;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management","root","");
			Statement st=con.createStatement();
			ResultSet r=st.executeQuery("select * from product_info");
			pw.println(" <h2>Product Information </h2>");
			while(r.next()) {
				if(name.equals(r.getString(1)) && (brand.equals(r.getString(2)))){
//					pw.print("<tr>");
//		 			   pw.print("<td>");
//					   pw.print(r.getString(1));
//					   pw.print("</td>");
//		 			   pw.print("<td>");
//		 			   pw.print(r.getString(2));
//		 			   pw.print("</td>");
//		 			   pw.print("<td>");
//		 			   pw.print(r.getString(3));
//		 			   pw.print("</td>");
//		 			  pw.print("<td>");
//		 			   pw.print(r.getString(4));
//		 			   pw.print("</td>");
//		 			  pw.print("<td>");
//		 			   pw.print(r.getString(5));
//		 			   pw.print("</td>");
//		 			   pw.print("<tr>");  
		 			   
					pw.println("<br>Name :"+ r.getString(1));
					pw.println("<br>Brand :"+ r.getString(2));
					pw.println("<br>Price :"+ r.getString(3));
					pw.println("<br>MFD :"+ r.getString(4));
					pw.println("<br>Stock :"+ r.getString(5));
					count=1;
				}
			}
			if(count==0) {
				
			pw.println(" Invalid Product Name / Brand  !");
			RequestDispatcher rd=request.getRequestDispatcher("search_product.jsp");
			rd.include(request, response);
		}
			
	}catch(Exception e) {
			pw.print(e);
			RequestDispatcher rd=request.getRequestDispatcher("search_product.jsp");
			rd.include(request, response);		
		}
		// pw.print("</table>");
	}

}
