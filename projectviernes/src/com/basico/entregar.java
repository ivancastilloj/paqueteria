package com.basico;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;
/**
 * Servlet implementation class entregar
 */
@WebServlet("/entregar")
public class entregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public entregar() {
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
		   //Get parameters
        String origen = request.getParameter("entrega");
        String destino = request.getParameter("destino");
        System.out.println(origen);
        System.out.println(destino);

        //Get Connection
        
		
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/viernes","root","");
	
       
         
          PreparedStatement Statement = con.prepareStatement("select * from enviar Where origen='" + origen +"' and destino='" +destino+"'");;
          
          ResultSet rs = Statement.executeQuery();
         
      	while(rs.next()) {
   		System.out.println("origen: "+rs.getString("origen"));
   		System.out.println("destino: "+rs.getString("destino"));
   		System.out.println("paquete:"+rs.getString("paquete"));
   		System.out.println("fecha: "+rs.getDate("fecha"));
   		request.getSession().setAttribute("origen", rs.getString("origen"));
   		request.getSession().setAttribute("destino", rs.getString("destino"));
   		request.getSession().setAttribute("paquete", rs.getString("paquete"));
   		request.getSession().setAttribute("fecha", rs.getDate("fecha"));
   	
   		}           
          con.close();
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  response.sendRedirect("table.jsp");  
	}
}
	






	
	
	

