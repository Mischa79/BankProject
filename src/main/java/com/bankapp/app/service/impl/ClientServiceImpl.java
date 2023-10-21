package com.bankapp.app.service.impl;

import ch.qos.logback.core.net.server.Client;
import com.bankapp.app.service.util.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    @Override
    public void post(String data) {

    }

    @Override
    public Client createClient(Client client) {
        return null;
    }
}
