package mburakaltun.HRMS.dataAccess.abstracts;

import mburakaltun.HRMS.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDAO extends JpaRepository<Employer, Integer> {
    public Employer findByCompanyEmail(String companyEmail);
}
