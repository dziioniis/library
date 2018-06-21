package org.company.name.dao.interfaceCRUD;


import org.company.name.entity.User;

public interface UserCRUD {

    User findUser(String name);

    int insertUser(User user);
}

