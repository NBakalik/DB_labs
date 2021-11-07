package controller.implementation;

import controller.GeneralController;
import model.CardBonus;
import service.GeneralService;
import service.implementation.CardBonusService;

import java.sql.SQLException;
import java.util.List;

public class CardBonusController implements GeneralController<CardBonus> {

    private final GeneralService generalService = new CardBonusService();

    @Override
    public List<CardBonus> findAll() throws SQLException {
        return generalService.findAll();
    }

    @Override
    public CardBonus findById(Integer id) throws SQLException {
        return (CardBonus) generalService.findById(id);
    }

    @Override
    public void create(CardBonus cardBonus) throws SQLException {
        generalService.create(cardBonus);
    }

    @Override
    public void update(CardBonus cardBonus) throws SQLException {
        generalService.update(cardBonus);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalService.delete(id);
    }
}
