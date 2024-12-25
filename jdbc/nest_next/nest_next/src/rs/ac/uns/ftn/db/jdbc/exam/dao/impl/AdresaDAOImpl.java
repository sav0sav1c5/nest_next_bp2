package rs.ac.uns.ftn.db.jdbc.exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rs.ac.uns.ftn.db.jdbc.exam.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.exam.dao.AdresaDAO;
import rs.ac.uns.ftn.db.jdbc.exam.model.Adresa;

public class AdresaDAOImpl implements AdresaDAO {

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Adresa entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Adresa> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Adresa> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresa findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Adresa adresa) throws SQLException {
		try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {
			return saveTransactional(connection, adresa);
		}
	}

	@Override
	public int saveAll(Iterable<Adresa> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean saveTransactional(Connection connection, Adresa entity) throws SQLException {

		int nextId = findMaxId(connection);
		entity.setIdAdr(nextId);
		
		System.out.println("Next ID: " + entity.getIdAdr());
		
		String query = "insert into adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) values (?, ?, ?, ?)";
		
		// Prepare statement for execution
	    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        // Set the parameters for the prepared statement
	        preparedStatement.setInt(1, entity.getIdAdr());  // id_adr
	        preparedStatement.setString(2, entity.getUlAdr());  // ul_adr
	        preparedStatement.setInt(3, entity.getRbrAdr());  // rbr_adr
	        preparedStatement.setInt(4, entity.getGradIdGr());  // grad_id_gr

	        // Execute the update and check the result
	        int rowsAffected = preparedStatement.executeUpdate();

	        System.out.println("\n\nRowsAffected: " + rowsAffected);
	        
	        // Commit the transaction if the update was successful
	        if (rowsAffected > 0) {
	            connection.commit();
	            return true;
	        } else {
	            connection.rollback();
	            return false;
	        }

	    } catch (SQLException e) {
	        // Roll back the transaction in case of an exception
	        if (connection != null) {
	            try {
	                connection.rollback();
	            } catch (SQLException rollbackEx) {
	                rollbackEx.printStackTrace();
	            }
	        }
	        throw e; // Re-throw the exception to be handled by the caller
	    }

	}

	private int findMaxId(Connection connection) throws SQLException {

		String query = "select max(id_adr) from adresa";
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
			else {
				return 0;
			}
		}

	}

}