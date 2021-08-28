package mburakaltun.HRMS.dataAccess.abstracts;

import mburakaltun.HRMS.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDAO extends JpaRepository<City, Integer> {
    City getByName(String cityName);
}
