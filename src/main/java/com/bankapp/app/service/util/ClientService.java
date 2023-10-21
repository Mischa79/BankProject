package com.bankapp.app.service.util;

import ch.qos.logback.core.net.server.Client;

public interface ClientService {
    void post(String data);

    Client createClient(Client client);
}
