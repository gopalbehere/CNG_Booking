package CngBooking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JCngReg
 */
public class JCngReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JCngReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a=request.getParameter("cngkg");
		int cngkg=Integer.parseInt(a);
		int pumpid=0;
		String status="Pending";
		try{
					
					Connection con=Dbconnection.connect();
					PreparedStatement ps=con.prepareStatement("insert into pumps values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					ps.setInt(1, pumpid);
					ps.setString(2,request.getParameter("cname"));
					ps.setString(3, request.getParameter("caddress") );
					ps.setString(4, request.getParameter("ccity"));
					ps.setString(5, request.getParameter("ctaluka"));
					ps.setString(6, request.getParameter("cdistrict"));
					ps.setString(7,request.getParameter("coptime"));
					ps.setString(8, request.getParameter("ccltime") );
					ps.setString(9, request.getParameter("cmobile"));
					ps.setString(10, request.getParameter("clat"));
					ps.setString(11, request.getParameter("clong") );
					ps.setString(12, request.getParameter("cpass"));
					ps.setInt(13, cngkg);
					ps.setString(14, status);

					
					

					int i=ps.executeUpdate();
					
					if(i>0){
						response.sendRedirect("cnglogin.html");
						
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
