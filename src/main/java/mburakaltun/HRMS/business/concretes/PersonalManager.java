package mburakaltun.HRMS.business.concretes;

import mburakaltun.HRMS.business.abstracts.PersonalService;
import mburakaltun.HRMS.dataAccess.abstracts.PersonalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalManager implements PersonalService {

    private PersonalDao personalDao;

    @Autowired
    public PersonalManager(PersonalDao personalDao) {
        this.personalDao = personalDao;
    }
}
