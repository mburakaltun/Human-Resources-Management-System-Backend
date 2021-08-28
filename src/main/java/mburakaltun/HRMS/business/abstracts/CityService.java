package mburakaltun.HRMS.business.abstracts;

import mburakaltun.HRMS.core.Result;
import mburakaltun.HRMS.entities.concretes.City;

public interface CityService {
    Result add(String cityName);
}
