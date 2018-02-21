package com.basico;
import com.basico.model.pedido;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

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
       String no="No existe";
        HttpSession session = request.getSession(false);
        session.setAttribute("origen", origen);
        session.setAttribute("destino", destino);
        
        //Get Connection
        
        List<pedido> listaEnvios = new ArrayList<pedido>();
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/viernes","root","");
	
       
         
          PreparedStatement Statement = con.prepareStatement("select * from enviar Where origen='" + origen +"' and destino='" +destino+"'");;
          
          ResultSet rs = Statement.executeQuery();
         
      	while(rs.next()) {
      		
      		pedido pedido = new pedido();
		
			pedido.setOrigen(rs.getString("origen"));
			pedido.setDestino(rs.getString("destino"));
			pedido.setTamano(rs.getString("paquete"));
			
			 String fechaDate = rs.getString("fecha");
				SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = null;
				try { 
					date = formato.parse(fechaDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				java.sql.Date fecha = new java.sql.Date(date.getTime());
			
			pedido.setFecha(fecha);
			
if (pedido.getOrigen().equals(null)) {
	session.setAttribute("no", no);
				
			}
			listaEnvios.add(pedido);
			
			
   		
   		}           
      	rs.close();
      	Statement.close();
		con.close();
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  request.setAttribute("listaEnvios", listaEnvios);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/table.jsp");
			rd.forward(request, response);
	}
}
	






	
	
	

