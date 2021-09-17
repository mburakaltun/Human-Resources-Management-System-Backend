package mburakaltun.HRMS.business.concretes;

import mburakaltun.HRMS.business.abstracts.PersonalService;
import mburakaltun.HRMS.dataAccess.PersonalDAO;
import mburakaltun.HRMS.models.entities.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonalManager implements PersonalService {

    private PersonalDAO personalDao;

    @Autowired
    public PersonalManager(PersonalDAO personalDao) {
        this.personalDao = personalDao;
    }

}
