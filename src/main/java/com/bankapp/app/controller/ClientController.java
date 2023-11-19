package com.bankapp.app.controller;


import com.bankapp.app.dto.ClientTestDto;
import com.bankapp.app.entity.Client;
import com.bankapp.app.mapper.ClientTestMapper;
import com.bankapp.app.service.util.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientTestMapper clientTestMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") int id) {
        Client client = (Client) clientService.getClientById(id);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ClientTestDto> createClient(@RequestBody ClientTestDto clientDto) {
        try {
            Client client = clientTestMapper.toEntity(clientDto);
            Client createdClient = clientService.createClient(client);
            ClientTestDto createdClientDto = clientTestMapper.toDto(createdClient);
            return ResponseEntity.ok(createdClientDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") int id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}


