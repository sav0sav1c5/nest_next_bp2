package rs.ac.uns.ftn.db.jdbc.exam.service;

import java.sql.Connection;
import java.sql.SQLException;

import rs.ac.uns.ftn.db.jdbc.exam.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.exam.dao.impl.AdresaDAOImpl;
import rs.ac.uns.ftn.db.jdbc.exam.dao.impl.StanDAOImpl;
import rs.ac.uns.ftn.db.jdbc.exam.dto.OglasavanjeDTO;
import rs.ac.uns.ftn.db.jdbc.exam.model.Adresa;
import rs.ac.uns.ftn.db.jdbc.exam.model.Stan;

public class OglasavanjeService {

    private AdresaDAOImpl adresaDAO = new AdresaDAOImpl();
    private StanDAOImpl stanDAO = new StanDAOImpl();

    public boolean insertOglasavanje(OglasavanjeDTO oglasavanjeDTO) {
        try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {
            connection.setAutoCommit(false);

            Adresa adresa = oglasavanjeDTO.getAdresa();
            if (!adresaDAO.saveTransactional(connection, adresa)) {
                connection.rollback();
                return false;
            }

            Stan stan = oglasavanjeDTO.getStan();
            stan.setAdresaIdAdr(adresa.getIdAdr()); // Postavljanje ID adrese
            if (!stanDAO.saveTransactional(connection, stan)) {
                connection.rollback();
                return false;
            }

            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
