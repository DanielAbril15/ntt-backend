package com.daniel.ntt.rest.services;

import com.daniel.ntt.rest.models.Document;
import com.daniel.ntt.rest.models.User;

public interface IUserService {
    User getDetailsUser(Document document);
}