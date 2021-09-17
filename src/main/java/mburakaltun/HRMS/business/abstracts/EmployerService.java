package mburakaltun.HRMS.business.abstracts;

import mburakaltun.HRMS.core.results.DataResult;
import mburakaltun.HRMS.core.results.Result;
import mburakaltun.HRMS.models.entities.Employer;

import java.util.List;

public interface EmployerService {
    public DataResult<List<Employer>> getAll();
    public Result add(Employer employer);
    public DataResult<Employer> getByCompanyEmail(String companyEmail);
}
