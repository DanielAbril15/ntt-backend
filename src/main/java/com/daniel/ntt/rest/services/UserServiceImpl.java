package com.daniel.ntt.rest.services;

import com.daniel.ntt.rest.models.Document;
import com.daniel.ntt.rest.models.User;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {

    @Override
    public User getDetailsUser(Document document) {
        User userDetail= new User();

        userDetail.setFirstName("Daniel");
        userDetail.setSecondName("Eduardo");
        userDetail.setFirstLastName("Abril");
        userDetail.setSecondLastName("Garcia");
        userDetail.setAddress("cll 87 #103 f50");
        userDetail.setCity("Bogota");
        userDetail.setPhone("3166856325");


        return userDetail;
    }
}
