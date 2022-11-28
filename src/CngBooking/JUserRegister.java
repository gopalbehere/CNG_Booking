package CngBooking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JUserRegister
 */
public class JUserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JUserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int cng=Integer.parseInt(request.getParameter("cng"));
		
		int id=0;
try{
			
			Connection con=Dbconnection.connect();
			PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2,request.getParameter("name"));
			ps.setString(3, request.getParameter("email") );
			ps.setString(4, request.getParameter("mobile"));
			ps.setString(5, request.getParameter("password"));
			ps.setString(6, request.getParameter("city"));
			ps.setInt(7, cng);
			
			

			int i=ps.executeUpdate();
			
			if(i>0){
				
				response.sendRedirect("userlogin.html");
				
			}else{
				response.sendRedirect("404.html");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
			
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
