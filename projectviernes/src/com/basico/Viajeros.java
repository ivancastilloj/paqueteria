package com.basico;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basico.model.usuario;

/**
 * Servlet implementation class Viajeros
 */
@WebServlet("/Viajeros")
public class Viajeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viajeros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: as").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
	
		System.out.println("Entra en viajes");
		String nombre = (String) session.getAttribute("usuario");
		
	        
	        List<usuario> listaViajar = new ArrayList<usuario>();
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/viernes","root","");
		
	       
	         System.out.println(nombre);
	          PreparedStatement Statement = con.prepareStatement("select * from viajes Where nombre='" +nombre+"'");
	          System.out.println("hace select");
	          ResultSet rs = Statement.executeQuery();
	         
	      	while(rs.next()) {
	      		
	      		usuario usu = new usuario();
			
				usu.setOrigen(rs.getString("origen"));
				usu.setDestino(rs.getString("destino"));
				usu.setNombre(rs.getString("nombre"));
			
				usu.setPuja(rs.getString("puja"));
				System.out.println(rs.getString("origen"));
				System.out.println(rs.getString("destino"));
				System.out.println(rs.getString("nombre"));
				System.out.println(rs.getString("puja"));
				listaViajar.add(usu);
	   		
	   		}           
	      	rs.close();
	      	Statement.close();
			con.close();
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			  request.setAttribute("listaViajar", listaViajar);
				request.getSession().setAttribute("nombre", nombre);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/viajes.jsp");
				rd.forward(request, response);
		}
	}