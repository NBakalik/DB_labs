package controller.implementation;

import controller.GeneralController;
import model.Region;
import service.GeneralService;
import service.implementation.RegionService;

import java.sql.SQLException;
import java.util.List;

public class RegionController implements GeneralController<Region> {

    private final GeneralService generalService = new RegionService();

    @Override
    public List<Region> findAll() throws SQLException {
        return generalService.findAll();
    }

    @Override
    public Region findById(Integer id) throws SQLException {
        return (Region) generalService.findById(id);
    }

    @Override
    public void create(Region region) throws SQLException {
        generalService.create(region);
    }

    @Override
    public void update(Region region) throws SQLException {
        generalService.update(region);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalService.delete(id);
    }
}
