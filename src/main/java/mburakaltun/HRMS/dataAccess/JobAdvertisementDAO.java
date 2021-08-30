package mburakaltun.HRMS.dataAccess;

import mburakaltun.HRMS.models.DTOs.JobAdvertisementListDTO;
import mburakaltun.HRMS.models.entities.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementDAO extends JpaRepository<JobAdvertisement, Integer> {
    @Query("select new mburakaltun.HRMS.models.DTOs.JobAdvertisementListDTO(" +
            "e.companyName, jt.name, ja.openPositionCount, ja.applicationDeadline, ja.publishingDate" +
            ") " +
            "from Employer e, JobTitle jt , JobAdvertisement ja " +
            "where jt.id = ja.jobTitle.id and e.id = ja.employer.id")
    public List<JobAdvertisementListDTO> getAllList();

    @Query("select new mburakaltun.HRMS.models.DTOs.JobAdvertisementListDTO(" +
            "e.companyName, jt.name, ja.openPositionCount, ja.applicationDeadline, ja.publishingDate" +
            ") " +
            "from Employer e, JobTitle jt , JobAdvertisement ja " +
            "where jt.id = ja.jobTitle.id and e.id = ja.employer.id " +
            "order by ja.publishingDate desc")
    public List<JobAdvertisementListDTO> getAllListByDesc();

    @Query("select new mburakaltun.HRMS.models.DTOs.JobAdvertisementListDTO(" +
            "e.companyName, jt.name, ja.openPositionCount, ja.applicationDeadline, ja.publishingDate" +
            ") " +
            "from Employer e, JobTitle jt , JobAdvertisement ja " +
            "where jt.id = ja.jobTitle.id and e.id = ja.employer.id and e.id = :employerId")
    public List<JobAdvertisementListDTO> getByEmployerId(int employerId);

    public void deleteById(int id);

    public JobAdvertisement findById(int id);
}
