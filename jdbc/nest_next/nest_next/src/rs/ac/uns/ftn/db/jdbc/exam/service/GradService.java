package rs.ac.uns.ftn.db.jdbc.exam.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.dao.GradDAO;
import rs.ac.uns.ftn.db.jdbc.exam.dao.impl.GradDAOImpl;
import rs.ac.uns.ftn.db.jdbc.exam.dto.GradDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.GradoviIBrojStanovaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.model.Grad;

public class GradService {

	private static final GradDAO gradDAO = new GradDAOImpl();

	public ArrayList<Grad> findAll() throws SQLException {
		return (ArrayList<Grad>) gradDAO.findAll();
	}

	public List<GradDTO> getAll() throws SQLException {
		
		List<GradDTO> gradDTOs = new ArrayList<>();
		
		for(Grad grad : gradDAO.findAll()) {
			GradDTO gradDTO = new GradDTO();
			gradDTO.setNazivGr(grad.getNazivGr());
			gradDTOs.add(gradDTO);
		}
		
		return gradDTOs;
	}
	
    public List<GradoviIBrojStanovaDTO> getGradoviIBrojStanova() throws SQLException {
    	return gradDAO.findGradoviIBrojStanova();
    }
    
}
