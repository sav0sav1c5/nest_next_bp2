package rs.ac.uns.ftn.db.jdbc.exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.exam.dao.StanDAO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.KategorijaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.model.Stan;

public class StanDAOImpl implements StanDAO {

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Stan entity) throws SQLException {
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
	public Iterable<Stan> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Stan> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stan findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Stan stan) throws SQLException {
		try (Connection conncetion = ConnectionUtil_HikariCP.getConnection()) {
			return saveTransactional(conncetion, stan);
		}
	}

	@Override
	public int saveAll(Iterable<Stan> stanovi) throws SQLException {

		int rowsSaved = 0;
		
		try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {
			connection.setAutoCommit(false);
			
			try {
				for (Stan stan : stanovi) {
					boolean success = saveTransactional(connection, stan);
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
    public List<KategorijaDTO> findProsecnaCenaPoKategorijama(){
        
    	List<KategorijaDTO> result = new ArrayList<>();
    	
    	String query = "SELECT k.naz_kat, AVG(s.cena_st) AS prosecna_cena "
                     + "FROM stan s "
                     + "JOIN kategorija k ON s.kategorija_id_kat = k.id_kat "
                     + "GROUP BY k.naz_kat";
        
        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String kategorija = resultSet.getString(1);
                Double prosCenaStanaUKat = resultSet.getDouble(2);
                result.add(new KategorijaDTO(kategorija, prosCenaStanaUKat));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    @Override
    public boolean saveTransactional(Connection connection, Stan stan) throws SQLException {
        
        int nextId = findMaxId(connection) + 1;
        stan.setIdSt(nextId);
        
    	String query = "insert into stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
        	int i = 1;
            preparedStatement.setInt(i++, stan.getIdSt()); 
            preparedStatement.setInt(i++, stan.getPovrSt());
            preparedStatement.setInt(i++, stan.getCenaSt()); 
            preparedStatement.setDouble(i++, stan.getOcenaSt());
            preparedStatement.setString(i++, stan.getDostupSt());
            preparedStatement.setInt(i++, stan.getAdresaIdAdr());
            preparedStatement.setInt(i++, stan.getKategorijaIdKat()); 
            preparedStatement.setInt(i++, stan.getOpremljenostIdOpr()); 
            preparedStatement.setInt(i++, stan.getStanodavacIdKor());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected == 1;
        }
    }


	private int findMaxId(Connection connection) throws SQLException {

		String query = "select max(id_st) from stan";
		
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
