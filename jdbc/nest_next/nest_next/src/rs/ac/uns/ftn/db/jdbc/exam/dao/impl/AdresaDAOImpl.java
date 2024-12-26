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
	public int saveAll(Iterable<Adresa> adrese) throws SQLException {

		int rowsSaved = 0;
		
		try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {
			connection.setAutoCommit(false);
			
			try {
				for(Adresa adresa : adrese) {
					boolean success = saveTransactional(connection, adresa);
					if (success) rowsSaved++;
				}
				
				connection.commit();
			} catch (SQLException e) {
					connection.rollback();
					throw e;
				}
		}
		
		return rowsSaved;
	}

	@Override
	public boolean saveTransactional(Connection connection, Adresa adresa) throws SQLException {

		int nextId = findMaxId(connection) + 1;
		adresa.setIdAdr(nextId);
		
		String query = "insert into adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) values (?, ?, ?, ?)";
		
	    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        
	    	int i = 1;
	    	preparedStatement.setInt(i++, adresa.getIdAdr());
	        preparedStatement.setString(i++, adresa.getUlAdr()); 
	        preparedStatement.setInt(i++, adresa.getRbrAdr());
	        preparedStatement.setInt(i++, adresa.getGradIdGr());

	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected == 1;
	    }
	}
	
	private int findMaxId(Connection connection) throws SQLException {

		String query = "select max(id_adr) from adresa";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);
			 ResultSet resultSet = preparedStatement.executeQuery()) {
			
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
			else {
				return 0;
			}
		}

	}

/*
    private void commitTransaction(Connection connection) throws SQLException {
        if (connection != null) {
            connection.commit();
        }
    }

    private void rollbackTransaction(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }	
*/	
	
}