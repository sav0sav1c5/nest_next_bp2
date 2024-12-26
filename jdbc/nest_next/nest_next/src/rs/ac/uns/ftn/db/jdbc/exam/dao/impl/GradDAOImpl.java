package rs.ac.uns.ftn.db.jdbc.exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.exam.dao.GradDAO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.GradoviIBrojStanovaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.NajcesceKategorijeStanovaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.model.Grad;

public class GradDAOImpl implements GradDAO {

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Grad entity) throws SQLException {
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
	public Iterable<Grad> findAll() throws SQLException {
		
		String query = "select id_gr, naz_gr from grad";
		List<Grad> gradList = new ArrayList<Grad>();
		
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(query);
			 ResultSet resultSet = preparedStatement.executeQuery()) {
			
			while (resultSet.next()) {
				int idGr = resultSet.getInt(1);
				String nazivGr = resultSet.getString(2);
				gradList.add(new Grad(idGr, nazivGr));
			}
		
		}
		
		return gradList;
	}

	@Override
	public Iterable<Grad> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Grad findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Grad entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Grad> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean saveTransactional(Connection connection, Grad entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<NajcesceKategorijeStanovaDTO> findGradSaNajcescimKategorijamaStanova() {
		
		List<NajcesceKategorijeStanovaDTO> result = new ArrayList<>();
        
		String query = "SELECT g.naz_gr, k.naz_kat, COUNT(s.id_st) AS brojStanova " +
		        	   "FROM grad g " +
		        	   "JOIN adresa a ON g.id_gr = a.grad_id_gr " +
		        	   "JOIN stan s ON a.id_adr = s.adresa_id_adr " +
		        	   "JOIN kategorija k ON s.kategorija_id_kat = k.id_kat " +
		        	   "GROUP BY g.naz_gr, k.naz_kat " +
		        	   "ORDER BY SUM(COUNT(s.id_st)) OVER (PARTITION BY g.naz_gr) DESC, brojStanova DESC";

        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
        	 PreparedStatement preparedStatement = connection.prepareStatement(query);
        	 ResultSet resultSet = preparedStatement.executeQuery()) {
        	
            while (resultSet.next()) {
                String nazivGr = resultSet.getString("naz_gr");
                String nazivKat = resultSet.getString("naz_kat");
                int brojStanova = resultSet.getInt("brojStanova");
                result.add(new NajcesceKategorijeStanovaDTO(nazivGr, nazivKat, brojStanova));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
	}

	@Override
	public List<GradoviIBrojStanovaDTO> getGradoviIBrojStanova() {

		List<GradoviIBrojStanovaDTO> result = new ArrayList<>();
		
		String query = "SELECT g.naz_gr, COUNT(s.id_st) AS broj_stanova "
			     	 + "FROM grad g "
			     	 + "JOIN adresa a ON g.id_gr = a.grad_id_gr "
			     	 + "JOIN stan s ON a.id_adr = s.adresa_id_adr "
			      	 + "GROUP BY g.naz_gr ";
		
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(query);
			 ResultSet resultSet = preparedStatement.executeQuery()) {
			
			while (resultSet.next()) {
				String nazivGr = resultSet.getString("naz_gr");
				int brojSt = resultSet.getInt("broj_stanova");
				result.add(new GradoviIBrojStanovaDTO(nazivGr, brojSt));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
