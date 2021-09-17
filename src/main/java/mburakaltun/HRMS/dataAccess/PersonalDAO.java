package mburakaltun.HRMS.dataAccess;

import mburakaltun.HRMS.models.entities.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDAO extends JpaRepository<Personal, Integer> {
    public Personal findByUsername(String username);
}
