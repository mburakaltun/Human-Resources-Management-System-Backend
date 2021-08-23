package mburakaltun.HRMS.business.concretes;

import mburakaltun.HRMS.business.abstracts.EmployerService;
import mburakaltun.HRMS.dataAccess.abstracts.EmployerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDAO employerDAO;

    @Autowired
    public EmployerManager(EmployerDAO employerDAO) {
        this.employerDAO = employerDAO;
    }
}
