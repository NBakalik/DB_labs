package service.implementation;

import DAO.GeneralDAO;
import DAO.implementation.CardBonusDaoImpl;
import model.CardBonus;
import service.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class CardBonusService implements GeneralService<CardBonus> {

    private final GeneralDAO generalDAO = new CardBonusDaoImpl();

    @Override
    public List<CardBonus> findAll() throws SQLException {
        return generalDAO.findAll();
    }

    @Override
    public CardBonus findById(Integer id) throws SQLException {
        return (CardBonus) generalDAO.findById(id);
    }

    @Override
    public void create(CardBonus cardBonus) throws SQLException {
        generalDAO.create(cardBonus);
    }

    @Override
    public void update(CardBonus cardBonus) throws SQLException {
        generalDAO.update(cardBonus);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalDAO.delete(id);
    }
}
