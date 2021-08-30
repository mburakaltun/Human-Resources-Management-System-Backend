package mburakaltun.HRMS.dataAccess;

import mburakaltun.HRMS.models.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDAO extends JpaRepository<City, Integer> {
    City getByName(String cityName);
}
