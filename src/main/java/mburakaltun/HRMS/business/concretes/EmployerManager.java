package mburakaltun.HRMS.business.concretes;

import mburakaltun.HRMS.business.abstracts.EmployerService;
import mburakaltun.HRMS.core.DataResult;
import mburakaltun.HRMS.core.Result;
import mburakaltun.HRMS.core.SuccessDataResult;
import mburakaltun.HRMS.core.SuccessResult;
import mburakaltun.HRMS.dataAccess.abstracts.EmployerDAO;
import mburakaltun.HRMS.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDAO employerDAO;

    @Autowired
    public EmployerManager(EmployerDAO employerDAO) {
        this.employerDAO = employerDAO;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(employerDAO.findAll(), "Employers listed successfully");
    }

    @Override
    public Result add(Employer employer) {
        employerDAO.saveAndFlush(employer);
        return new SuccessResult("Employer added to database successfully");
    }

    @Override
    public DataResult<Employer> getByCompanyEmail(String companyEmail) {
        return new SuccessDataResult<>(employerDAO.findByCompanyEmail(companyEmail));
    }
}
