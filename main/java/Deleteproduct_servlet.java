import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deleteproduct_servlet
 */
@WebServlet("/Deleteproduct_servlet")
public class Deleteproduct_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name,brand;
		PrintWriter pw=response.getWriter();
		try {
			name=request.getParameter("name");
			brand=request.getParameter("brand");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management","root","");
			PreparedStatement ps=con.prepareStatement("delete from product_info where name=? and brand=? ");
			ps.setString(1,name);
			ps.setString(2,brand);
			int n=ps.executeUpdate();
			con.close();
			if(n!=0) {
			pw.println(" Given Product Delete Successfully !");
			RequestDispatcher rd=request.getRequestDispatcher("delete_product.jsp");
			rd.include(request, response);
		}
			else {
				pw.println("Invalid product  !");
				RequestDispatcher rd=request.getRequestDispatcher("delete_product.jsp");
				rd.include(request, response);
		}
	}catch(Exception e) {
			//pw.println(" Product Not Saved ");
			pw.print(e);
			RequestDispatcher rd=request.getRequestDispatcher("delete_product.jsp");
			rd.include(request, response);

			
		}
	}

}
