
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

@WebServlet("/Addproduct_servlet")
public class Addproduct_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name,brand,pmfd;
		int price,stock;
		PrintWriter pw=response.getWriter();
		try {
			name=request.getParameter("name");
			brand=request.getParameter("brand");
			price=Integer.parseInt(request.getParameter("price"));
			pmfd=request.getParameter("mfd");
			stock=Integer.parseInt(request.getParameter("stock"));
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management","root","");
			PreparedStatement ps=con.prepareStatement("insert into product_info values(?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,brand);
			ps.setInt(3,price);
			ps.setString(4,pmfd);
			ps.setInt(5,stock);
			ps.executeUpdate();
			con.close();
			pw.println(" One Product Saved Successfully !");
			RequestDispatcher rd=request.getRequestDispatcher("Add_product.jsp");
			rd.include(request, response);
		}catch(Exception e) {
			pw.println(" Product Not Saved ");
			pw.print(e);
			RequestDispatcher rd=request.getRequestDispatcher("Add_product.jsp");
			rd.include(request, response);
		}
	}

}
