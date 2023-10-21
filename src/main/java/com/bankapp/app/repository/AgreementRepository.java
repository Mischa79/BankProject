package com.bankapp.app.repository;

import com.bankapp.app.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, Integer> {

}
