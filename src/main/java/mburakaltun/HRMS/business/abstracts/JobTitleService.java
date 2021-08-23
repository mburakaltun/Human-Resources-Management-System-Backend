package mburakaltun.HRMS.business.abstracts;

import mburakaltun.HRMS.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleService {
    List<JobTitle> getAll();
}
