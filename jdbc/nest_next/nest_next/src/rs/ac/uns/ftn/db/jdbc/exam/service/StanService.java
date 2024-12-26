package rs.ac.uns.ftn.db.jdbc.exam.service;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.dao.StanDAO;
import rs.ac.uns.ftn.db.jdbc.exam.dao.impl.StanDAOImpl;
import rs.ac.uns.ftn.db.jdbc.exam.dto.KategorijaDTO;

public class StanService {

	private static final StanDAO stanDAO = new StanDAOImpl();
	
    public List<KategorijaDTO> getProsecnaCenaPoKategorijama() throws SQLException {
    	return stanDAO.findProsecnaCenaPoKategorijama();
    }
    
}
