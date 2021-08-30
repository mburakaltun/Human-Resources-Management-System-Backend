package mburakaltun.HRMS.dataAccess;

import mburakaltun.HRMS.models.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDAO extends JpaRepository<Employer, Integer> {
    public Employer findByUsername(String username);
    public Employer findByCompanyEmail(String companyEmail);
}
