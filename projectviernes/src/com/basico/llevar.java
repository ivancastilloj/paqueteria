package com.basico;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class llevar
 */
@WebServlet("/llevar")
public class llevar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public llevar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String origen = request.getParameter("entrega");
	        String destino = request.getParameter("destino");
	        String paquete = request.getParameter("paquete");
	        
	        String fechaDate = request.getParameter("fecha");
			SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = null;
			try {
				date = formato.parse(fechaDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			java.sql.Date fecha = new java.sql.Date(date.getTime());
			
	        
			
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/viernes","root","");
		
				
				String sql="insert into enviar (origen,destino,paquete,fecha) values('" + origen + "','"  + destino + "','"  + paquete + "','"  + fecha + "')";
	         
				  Statement stat = con.createStatement();// enviar comandos SQL a la base de datos, se usa la clase Statement de java
		          
		          
		           stat.executeUpdate(sql);
		           

		           stat.close();
		           con.close();
		           response.sendRedirect("subida.jsp");  
		           
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  
		   }
}
		
		
		
	
