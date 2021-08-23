package mburakaltun.HRMS.dataAccess.abstracts;

import mburakaltun.HRMS.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDAO extends JpaRepository<Employer, Integer> {
}
