package service.implementation;

import DAO.GeneralDAO;
import DAO.implementation.OrderStatusDaoImpl;
import model.OrderStatus;
import service.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class OrderStatusService implements GeneralService<OrderStatus> {

    private final GeneralDAO generalDAO = new OrderStatusDaoImpl();

    @Override
    public List<OrderStatus> findAll() throws SQLException {
        return generalDAO.findAll();
    }

    @Override
    public OrderStatus findById(Integer id) throws SQLException {
        return (OrderStatus) generalDAO.findById(id);
    }

    @Override
    public void create(OrderStatus orderStatus) throws SQLException {
        generalDAO.create(orderStatus);
    }

    @Override
    public void update(OrderStatus orderStatus) throws SQLException {
        generalDAO.update(orderStatus);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalDAO.delete(id);
    }
}
