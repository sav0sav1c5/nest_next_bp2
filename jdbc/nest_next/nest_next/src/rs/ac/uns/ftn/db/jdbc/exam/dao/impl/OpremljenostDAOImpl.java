package rs.ac.uns.ftn.db.jdbc.exam.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import rs.ac.uns.ftn.db.jdbc.exam.dao.OpremljenostDAO;
import rs.ac.uns.ftn.db.jdbc.exam.model.Opremljenost;

public class OpremljenostDAOImpl implements OpremljenostDAO {

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Opremljenost entity) throws SQLException {
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
	public Iterable<Opremljenost> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Opremljenost> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Opremljenost findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Opremljenost entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Opremljenost> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean saveTransactional(Connection connection, Opremljenost entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
