package controller.implementation;

import controller.GeneralController;
import model.OrderStatus;
import service.GeneralService;
import service.implementation.OrderStatusService;

import java.sql.SQLException;
import java.util.List;

public class OrderStatusController implements GeneralController<OrderStatus> {

    private final GeneralService generalService = new OrderStatusService();

    @Override
    public List<OrderStatus> findAll() throws SQLException {
        return generalService.findAll();
    }

    @Override
    public OrderStatus findById(Integer id) throws SQLException {
        return (OrderStatus) generalService.findById(id);
    }

    @Override
    public void create(OrderStatus orderStatus) throws SQLException {
        generalService.create(orderStatus);
    }

    @Override
    public void update(OrderStatus orderStatus) throws SQLException {
        generalService.update(orderStatus);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalService.delete(id);
    }
}
