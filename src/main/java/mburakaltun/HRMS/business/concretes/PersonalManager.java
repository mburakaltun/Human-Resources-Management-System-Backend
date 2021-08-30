package mburakaltun.HRMS.business.concretes;

import mburakaltun.HRMS.business.abstracts.PersonalService;
import mburakaltun.HRMS.dataAccess.PersonalDAO;
import mburakaltun.HRMS.models.entities.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonalManager implements PersonalService, UserDetailsService {

    private PersonalDAO personalDao;

    @Autowired
    public PersonalManager(PersonalDAO personalDao) {
        this.personalDao = personalDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personal personal = personalDao.findByUsername(username);
        return new User(personal.getUsername(), personal.getPassword(), new ArrayList<>());
    }



}
