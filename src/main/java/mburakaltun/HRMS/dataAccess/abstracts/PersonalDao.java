package mburakaltun.HRMS.dataAccess.abstracts;

import mburakaltun.HRMS.entities.concretes.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDao extends JpaRepository<Personal, Integer> {
}
