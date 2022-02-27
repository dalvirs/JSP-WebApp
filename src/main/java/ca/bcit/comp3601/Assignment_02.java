package ca.bcit.comp3601;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Dalvir Chiount, A01258927
 */

public class Assignment_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DATABASE_DRIVER;
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	private DatabaseQuery database;
       
  
    public Assignment_02() {
        super();
    }
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		DATABASE_DRIVER = config.getInitParameter("DATABASE_DRIVER");
		URL = config.getInitParameter("URL");
		USER = config.getInitParameter("USER");
		PASSWORD = config.getInitParameter("PASSWORD");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName(DATABASE_DRIVER);
			
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
			database = new DatabaseQuery(connection);
			
			ArrayList<Customer> customers = database.getCustomers();
			
			request.setAttribute("customers", customers);
			request.setAttribute("database", database);
					
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
		} 
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
