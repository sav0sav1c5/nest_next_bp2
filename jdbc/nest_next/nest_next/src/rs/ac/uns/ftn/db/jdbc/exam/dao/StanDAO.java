package rs.ac.uns.ftn.db.jdbc.exam.dao;

import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.dto.KategorijaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.model.Stan;

public interface StanDAO extends CRUDDao<Stan, Integer> {
	
	List<KategorijaDTO> getAveragePriceByCategory();

}
