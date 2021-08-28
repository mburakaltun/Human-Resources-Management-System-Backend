package mburakaltun.HRMS.dataAccess.abstracts;

import mburakaltun.HRMS.entities.DTOs.JobAdvertisementListDTO;
import mburakaltun.HRMS.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementDAO extends JpaRepository<JobAdvertisement, Integer> {
    @Query("select new mburakaltun.HRMS.entities.DTOs.JobAdvertisementListDTO(" +
            "e.companyName, jt.name, ja.openPositionCount, ja.applicationDeadline, ja.publishingDate" +
            ") " +
            "from Employer e, JobTitle jt , JobAdvertisement ja " +
            "where jt.id = ja.jobTitle.id and e.id = ja.employer.id")
    public List<JobAdvertisementListDTO> getAllList();

    @Query("select new mburakaltun.HRMS.entities.DTOs.JobAdvertisementListDTO(" +
            "e.companyName, jt.name, ja.openPositionCount, ja.applicationDeadline, ja.publishingDate" +
            ") " +
            "from Employer e, JobTitle jt , JobAdvertisement ja " +
            "where jt.id = ja.jobTitle.id and e.id = ja.employer.id " +
            "order by ja.publishingDate desc")
    public List<JobAdvertisementListDTO> getAllListByDesc();
}
