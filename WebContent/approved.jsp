<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>

<%
int id = Integer.parseInt(request.getParameter("id"));
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
	String sql ="update pumps set status=? where pumpid=?";
	//String status=

connection = DriverManager.getConnection(connectionUrl+database, userid, password);
PreparedStatement pstmt=connection.prepareStatement(sql);
pstmt.setString(1,"Approved");
pstmt.setInt(2,id);

int i=pstmt.executeUpdate();
if (i>0){
	System.out.println("hiii");
	response.sendRedirect("ActiveStations.jsp");
}	
}catch(Exception e){
	e.printStackTrace();
}
%>