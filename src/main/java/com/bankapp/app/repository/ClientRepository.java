package com.bankapp.app.repository;

import com.bankapp.app.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer > {
}
