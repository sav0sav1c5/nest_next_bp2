package rs.ac.uns.ftn.db.jdbc.exam.service;

import java.sql.SQLException;
import java.util.Map;

import rs.ac.uns.ftn.db.jdbc.exam.dao.StanDAO;
import rs.ac.uns.ftn.db.jdbc.exam.dao.impl.StanDAOImpl;

public class StanService {

	private static final StanDAO stanDAO = new StanDAOImpl();
	
    public Map<String, Double> getAveragePriceByCategory() throws SQLException {
        return stanDAO.getAveragePriceByCategory();
    }
}
