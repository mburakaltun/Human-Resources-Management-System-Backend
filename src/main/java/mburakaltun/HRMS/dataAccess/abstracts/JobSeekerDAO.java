package mburakaltun.HRMS.dataAccess.abstracts;

import mburakaltun.HRMS.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerDAO extends JpaRepository<JobSeeker, Integer> {
    public JobSeeker findByIdNo(String idNo);
    public JobSeeker findByEmail(String email);
}
