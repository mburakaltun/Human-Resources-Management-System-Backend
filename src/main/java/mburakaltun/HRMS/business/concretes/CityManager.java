package mburakaltun.HRMS.business.concretes;

import mburakaltun.HRMS.business.abstracts.CityService;
import mburakaltun.HRMS.core.results.ErrorResult;
import mburakaltun.HRMS.core.results.Result;
import mburakaltun.HRMS.core.results.SuccessResult;
import mburakaltun.HRMS.dataAccess.CityDAO;
import mburakaltun.HRMS.models.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityManager implements CityService {

    private CityDAO cityDAO;

    @Autowired
    public CityManager(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    public Result add(String cityName) {
        if(cityDAO.getByName(cityName) == null) {
            cityDAO.saveAndFlush(new City(cityName));
            return new SuccessResult("City added");
        }
        return new ErrorResult("City name is already in database");
    }
}
