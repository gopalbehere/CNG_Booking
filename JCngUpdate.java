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
 * Servlet implementation class JCngUpdate
 */
public class JCngUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JCngUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int pid=Integer.parseInt(request.getParameter("pid"));
		int cng=Integer.parseInt(request.getParameter("cng"));
		
		try{
			
			Connection con=Dbconnection.connect();
			PreparedStatement pstmt1= con.prepareStatement("update pumps set cngkg=? where pumpid=?");
			pstmt1.setInt(1,cng);
			pstmt1.setInt(2,pid);
			
			int i=pstmt1.executeUpdate();
			if (i>0){
				response.sendRedirect("CngDash.jsp");
				
			}
			}catch(Exception e){
				
				
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
