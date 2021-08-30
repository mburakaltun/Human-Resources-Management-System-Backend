package mburakaltun.HRMS.business.abstracts;

import mburakaltun.HRMS.core.results.DataResult;
import mburakaltun.HRMS.core.results.Result;
import mburakaltun.HRMS.models.entities.JobTitle;

import java.util.List;

public interface JobTitleService {
    DataResult<List<JobTitle>> getAll();
    Result add(String jobTitleName);

}
