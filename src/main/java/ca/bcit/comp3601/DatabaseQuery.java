package ca.bcit.comp3601;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Dalvir Chiount, A01258927
 */

public class DatabaseQuery extends Dao{
	
	public DatabaseQuery(Connection connection) {
		super(connection);
	}
	
	public enum Column {
		MEMBERID,
		FIRSTNAME, 
		LASTNAME, 
		ADDRESS, 
		CITY, 
		CODE,
		COUNTRY,
		PHONENUMBER, 
		EMAIL;

	}
	
	public void add(Customer customer) throws SQLException {
		int i = 0;
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM A01258927_Cust");
		while(resultSet.next())
		{
			i = resultSet.getInt(1);
		}
		i = i + 1;
		
		String sqlString = String.format("INSERT INTO %s values(?, ?, ?, ?, ?, ?, ?, ?, ?)", TABLE_NAME);
		execute(sqlString, //
				i,
				customer.getFirstName(), //
				customer.getLastName(), //
				customer.getAddress(), //
				customer.getCity(), //
				customer.getCode(), //
				customer.getCountry(), //
				customer.getPhoneNumber(), //
				customer.getEmail());
		
	}
	
	public void delete(int id) throws SQLException {
		Statement statement = connection.createStatement();

		String sqlString = String.format("DELETE FROM %s WHERE MEMBERID='%s'", TABLE_NAME, id);
		statement.executeUpdate(sqlString);
	}
	
	public void update(Customer customer) throws SQLException {
		String sqlString = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?", TABLE_NAME, //
				Column.FIRSTNAME,
				Column.LASTNAME,
				Column.ADDRESS,
				Column.CITY,
				Column.CODE,
				Column.COUNTRY,
				Column.PHONENUMBER,
				Column.EMAIL,
				Column.MEMBERID);
		
		execute(sqlString, customer.getFirstName(), customer.getLastName(), customer.getAddress(), customer.getCity(),
				customer.getCode(), customer.getCountry(), customer.getPhoneNumber(), customer.getEmail(), customer.getMemberId());
	}
	
	public ArrayList<Customer> getCustomers() {
		
		ArrayList<Customer> customers = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			String sqlString = String.format("Select * from %s", TABLE_NAME);
			ResultSet rst = statement.executeQuery(sqlString);
					
			while (rst.next()) {
				Customer customer = new Customer(rst.getInt(String.valueOf(Column.MEMBERID)), rst.getString(String.valueOf(Column.FIRSTNAME)), rst.getString(String.valueOf(Column.LASTNAME)),
						                     rst.getString(String.valueOf(Column.ADDRESS)), rst.getString(String.valueOf(Column.ADDRESS)), rst.getString(String.valueOf(Column.CODE)),
						                     rst.getString(String.valueOf(Column.COUNTRY)), rst.getString(String.valueOf(Column.PHONENUMBER)), rst.getString(String.valueOf(Column.EMAIL)));
				customers.add(customer);
			}
			
		} catch (SQLException e) {
			System.err.println(e);
		}
		
		return customers;
	}

}
	
	
