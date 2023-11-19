package com.bankapp.app.service.util;


import com.bankapp.app.entity.Client;

public interface ClientService {


    Client createClient(Client client);

    Client getClientById(int id);

    void deleteClient(int id);
}
