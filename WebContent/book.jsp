<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="CngBooking.GetterSetter"%>

<%
int pid = Integer.parseInt(request.getParameter("id"));
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "cngbooking";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;

try{
	int cng=GetterSetter.getId();
	int uid=GetterSetter.getId2();
	String name=GetterSetter.getId3();
	String mobile=GetterSetter.getId4();
	
	
	connection = DriverManager.getConnection(connectionUrl+database, userid, password);
	PreparedStatement ps11=connection.prepareStatement("select * from pumps where pumpid=?");
	ps11.setInt(1, pid);
	
	ResultSet rs11 = ps11.executeQuery();
	if(rs11.next())
	{
		int pcng =rs11.getInt("cngkg");
		int ncng = pcng-cng;
		if(pcng>=ncng)
		{
			
	PreparedStatement ps22 = connection.prepareStatement("update pumps set cngkg=? where pumpid=?");
	ps22.setInt(1, ncng);
	ps22.setInt(2, pid);
	ps22.executeUpdate();
	
	PreparedStatement ps2 = connection.prepareStatement("insert into book values(?,?,?,?,?)");
	ps2.setInt(1, uid);
	ps2.setInt(2, pid);
	ps2.setString(3, name);
	ps2.setString(4, mobile);
	ps2.setInt(5,cng);
	
	
	int i = ps2.executeUpdate();
	if(i>0)
	{
		System.out.println("Booking Successful..");
		response.sendRedirect("UserDash.jsp");
	}
	else
	{
		System.out.println("Booking Failed..");
		response.sendRedirect("404.html");
	}
	}
		
	}
		  
}
catch(Exception e)
{
   e.printStackTrace();
}



%>