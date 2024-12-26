package rs.ac.uns.ftn.db.jdbc.exam.dao;

import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.dto.GradoviIBrojStanovaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.NajcesceKategorijeStanovaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.model.Grad;

public interface GradDAO extends CRUDDao<Grad, Integer> {
	
	List<NajcesceKategorijeStanovaDTO> findNajcesceKategorijeStanovaPoGradovima();
	
	List<GradoviIBrojStanovaDTO>  findGradoviIBrojStanova();

}
