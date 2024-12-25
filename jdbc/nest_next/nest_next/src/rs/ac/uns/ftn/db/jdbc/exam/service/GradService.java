package rs.ac.uns.ftn.db.jdbc.exam.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.dao.GradDAO;
import rs.ac.uns.ftn.db.jdbc.exam.dao.impl.GradDAOImpl;
import rs.ac.uns.ftn.db.jdbc.exam.dto.GradoviIBrojStanovaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.NajcesceKategorijeStanovaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.model.Grad;

public class GradService {

	private static final GradDAO gradDAO = new GradDAOImpl();

	// Postojeća metoda za dobijanje svih gradova
	public ArrayList<Grad> getAll() throws SQLException {
		return (ArrayList<Grad>) gradDAO.findAll();
	}

	// Nova metoda za dobijanje gradova sa najčešćim kategorijama stanova
    public List<NajcesceKategorijeStanovaDTO> getNajcesceKategorijeStanova() throws SQLException {
        return gradDAO.findGradSaNajcescimKategorijamaStanova();
    }
	
    // Nova metoda za dobijanje gradova i broja stanova u svakom od njih
    public List<GradoviIBrojStanovaDTO> getGradoviIBrojStanova() throws SQLException {
    	return gradDAO.getGradoviIBrojStanova();
    }
    
}
