package mburakaltun.HRMS.dataAccess;

import mburakaltun.HRMS.models.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerDAO extends JpaRepository<JobSeeker, Integer> {
    JobSeeker findByIdNo(String idNo);
    JobSeeker findByEmail(String email);
    JobSeeker getById(int id);
}
