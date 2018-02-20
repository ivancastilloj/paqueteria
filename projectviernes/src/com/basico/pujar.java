package com.basico;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Scope;

/**
 * Servlet implementation class pujar
 */
@WebServlet("/pujar")
public class pujar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pujar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String nombre = request.getParameter("nombre");
	        String password = request.getParameter("password");
	        HttpSession sesion = request.getSession();
	        int puja= (Integer) sesion.getAttribute("puja");
	       
	        System.out.println(puja);
	       
			
	        
			
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/viernes","root","");
		
				
				String sql="insert into transportistas (nombre,password,puja) values('" + nombre + "','"  + password + "','"  +puja + "')";
	         
				  Statement stat = con.createStatement();// enviar comandos SQL a la base de datos, se usa la clase Statement de java
		          
		          
		           stat.executeUpdate(sql);
		           

		           stat.close();
		           con.close();
		           sesion.setAttribute("usuario", nombre);
		           response.sendRedirect("subida.jsp");  
		           
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  
		   }

}
