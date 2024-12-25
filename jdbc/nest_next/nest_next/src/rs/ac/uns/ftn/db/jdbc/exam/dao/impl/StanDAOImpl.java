package rs.ac.uns.ftn.db.jdbc.exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import rs.ac.uns.ftn.db.jdbc.exam.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.exam.dao.StanDAO;
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
	public boolean save(Stan entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Stan> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

    @Override
    public Map<String, Double> getAveragePriceByCategory() throws SQLException {
        String query = "SELECT k.naz_kat, AVG(s.cena_st) AS prosecna_cena "
                     + "FROM stan s "
                     + "JOIN kategorija k ON s.kategorija_id_kat = k.id_kat "
                     + "GROUP BY k.naz_kat";

        Map<String, Double> result = new HashMap<>();
        
        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String category = resultSet.getString(1);
                Double avgPrice = resultSet.getDouble(2);
                result.put(category, avgPrice);
            }
        }
        return result;
    }
    
    @Override
    public boolean saveTransactional(Connection connection, Stan entity) throws SQLException {
        
        // Pozivanje metode findMaxId za dobijanje sledećeg slobodnog ID-a
        int nextId = findMaxId(connection) + 1;
        entity.setIdSt(nextId); // Postavljanje ID-a u entitet
    	
        System.out.println("Next ID: " + entity.getIdSt());
        
    	String query = "insert into stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        // Priprema statement-a za izvršenje
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Postavljanje parametara za prepared statement
            preparedStatement.setInt(1, entity.getIdSt());         // id_st
            preparedStatement.setInt(2, entity.getPovrSt());       // povr_st
            preparedStatement.setInt(3, entity.getCenaSt());       // cena_st
            preparedStatement.setDouble(4, entity.getOcenaSt());   // ocena_st
            preparedStatement.setString(5, entity.getDostupSt());  // dostup_st
            preparedStatement.setInt(6, entity.getAdresaIdAdr());  // adresa_id_adr
            preparedStatement.setInt(7, entity.getKategorijaIdKat());  // kategorija_id_kat
            preparedStatement.setInt(8, entity.getOpremljenostIdOpr());  // opremljenost_id_opr
            preparedStatement.setInt(9, entity.getStanodavacIdKor());    // stanodavac_id_kor

            // Izvršenje upita i provera rezultata
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("\n\nRowsAffected: " + rowsAffected);

            // Potvrda transakcije ako je uspešno izvršeno
            if (rowsAffected > 0) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }

        } catch (SQLException e) {
            // Rollback u slučaju greške
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            throw e; // Ponovno bacanje izuzetka za obradu od strane pozivaoca
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
