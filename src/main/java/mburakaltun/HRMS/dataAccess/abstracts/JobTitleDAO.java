package mburakaltun.HRMS.dataAccess.abstracts;

import mburakaltun.HRMS.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleDAO extends JpaRepository<JobTitle, Integer> {

}
