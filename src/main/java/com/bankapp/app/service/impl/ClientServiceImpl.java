package com.bankapp.app.service.impl;


import com.bankapp.app.entity.Client;
import com.bankapp.app.repository.ClientRepository;
import com.bankapp.app.service.util.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);


    }

    @Override
    public Client getClientById(int id) {
        return null;
    }

    @Override
    public void deleteClient(int id) {

    }
}
