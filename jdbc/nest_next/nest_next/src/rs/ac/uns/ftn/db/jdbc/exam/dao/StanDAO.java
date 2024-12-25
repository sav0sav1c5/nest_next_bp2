package rs.ac.uns.ftn.db.jdbc.exam.dao;

import java.sql.SQLException;
import java.util.Map;

import rs.ac.uns.ftn.db.jdbc.exam.model.Stan;

public interface StanDAO extends CRUDDao<Stan, Integer> {
	
	Map<String, Double> getAveragePriceByCategory() throws SQLException;

}
