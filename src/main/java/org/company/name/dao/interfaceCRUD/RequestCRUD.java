package org.company.name.dao.interfaceCRUD;

import org.company.name.entity.Request;

import java.util.List;

public interface RequestCRUD {
    int addBookRequest(Request request);

    List<Request> getAllRequests();

    boolean update(Request request);
}
