package mburakaltun.HRMS.dataAccess;

import mburakaltun.HRMS.models.entities.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTitleDAO extends JpaRepository<JobTitle, Integer> {
    JobTitle findByName(String name);
}
