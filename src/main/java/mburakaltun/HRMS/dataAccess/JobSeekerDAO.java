package mburakaltun.HRMS.dataAccess;

import mburakaltun.HRMS.models.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerDAO extends JpaRepository<JobSeeker, Integer> {
    public JobSeeker findByUsername(String username);
    public JobSeeker findByIdNo(String idNo);
    public JobSeeker findByEmail(String email);
}
