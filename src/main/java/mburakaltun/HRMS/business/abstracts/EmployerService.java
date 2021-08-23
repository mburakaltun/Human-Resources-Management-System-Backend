package mburakaltun.HRMS.business.abstracts;

import mburakaltun.HRMS.core.DataResult;
import mburakaltun.HRMS.core.Result;
import mburakaltun.HRMS.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    public DataResult<List<Employer>> getAll();
    public Result add(Employer employer);
    public DataResult<Employer> getByCompanyEmail(String companyEmail);
}
