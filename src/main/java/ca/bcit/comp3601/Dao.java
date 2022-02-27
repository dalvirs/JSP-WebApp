package ca.bcit.comp3601;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author Dalvir Chiount, A01258927
 */

public abstract class Dao {

	public Connection connection;
	public static final String TABLE_NAME = "A01258927_cust";

	protected Dao(Connection connection) {
		this.connection = connection;
	}

	protected void execute(String preparedStatementString, Object... args) throws SQLException {
		PreparedStatement statement = null;
		statement = connection.prepareStatement(preparedStatementString);
		int i = 1;
		for (Object object : args) {
			if (object instanceof String) {
				statement.setString(i, object.toString());
			} else if (object instanceof Boolean) {
				statement.setBoolean(i, (Boolean) object);
			} else if (object instanceof Integer) {
				statement.setInt(i, (Integer) object);
			} else if (object instanceof Long) {
				statement.setLong(i, (Long) object);
			} else if (object instanceof Float) {
				statement.setFloat(i, (Float) object);
			} else if (object instanceof Double) {
				statement.setDouble(i, (Double) object);
			} else if (object instanceof Byte) {
				statement.setByte(i, (Byte) object);
			} else if (object instanceof Timestamp) {
				statement.setTimestamp(i, (Timestamp) object);
			} else if (object instanceof LocalDateTime) {
				statement.setTimestamp(i, Timestamp.valueOf((LocalDateTime) object));
			} else {
				statement.setString(i, object.toString());
			}

			i++;
		}

		statement.executeUpdate();
	}

	public void delete(Customer member) throws SQLException {
		Statement statement = connection.createStatement();

		String sqlString = String.format("DELETE FROM %s WHERE MEMBERID='%s'", TABLE_NAME, member.getMemberId());
		statement.executeUpdate(sqlString);
	}
}
