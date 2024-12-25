package rs.ac.uns.ftn.db.jdbc.exam.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import rs.ac.uns.ftn.db.jdbc.exam.dao.KategorijaDAO;
import rs.ac.uns.ftn.db.jdbc.exam.model.Kategorija;

public class KategorijaDAOImpl implements KategorijaDAO {

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Kategorija entity) throws SQLException {
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
	public Iterable<Kategorija> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Kategorija> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kategorija findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Kategorija entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Kategorija> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean saveTransactional(Connection connection, Kategorija entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
