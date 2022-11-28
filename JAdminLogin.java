package CngBooking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JAdminLogin
 */
public class JAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JAdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uname=request.getParameter("email");
		String upass=request.getParameter("password");
		
		try{
			
			Connection con=Dbconnection.connect();
			PreparedStatement pstmt1= con.prepareStatement("select * from admin where email=? and pass=?");
			pstmt1.setString(1,uname);
			pstmt1.setString(2,upass);
			
			ResultSet rs1=pstmt1.executeQuery();
			if (rs1.next()){
				
				//System.out.println("1"+rs1.getInt(1));
				//int id3=rs1.getInt(1);
				//GetterSetter.setId(id3);
				
				
				//System.out.println("log in successfully");
				response.sendRedirect("AdminDash.jsp");
				
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
