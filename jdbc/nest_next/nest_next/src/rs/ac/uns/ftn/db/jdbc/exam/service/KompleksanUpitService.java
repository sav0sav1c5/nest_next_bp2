package rs.ac.uns.ftn.db.jdbc.exam.service;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.dao.GradDAO;
import rs.ac.uns.ftn.db.jdbc.exam.dao.impl.GradDAOImpl;
import rs.ac.uns.ftn.db.jdbc.exam.dto.NajcesceKategorijeStanovaDTO;

public class KompleksanUpitService {

	private static final GradDAO gradDAO = new GradDAOImpl();
	
    public List<NajcesceKategorijeStanovaDTO> getNajcesceKategorijeStanova() throws SQLException {
        return gradDAO.findGradSaNajcescimKategorijamaStanova();
    }
	
}
