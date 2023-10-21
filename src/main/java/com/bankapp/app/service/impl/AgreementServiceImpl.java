package com.bankapp.app.service.impl;

import com.bankapp.app.entity.Agreement;
import com.bankapp.app.repository.AgreementRepository;
import com.bankapp.app.service.util.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;

    @Override
    public Agreement getAgreementById(String id) {
        Integer agreementId = Integer.parseInt(id);
        Optional<Agreement> agreementOptional = agreementRepository.findById(agreementId);
         if (agreementOptional.isPresent()) {
             return agreementOptional.get();
         } else {
             try {
                 throw new AgreementNotFoundException("Agreement not found with ID: " + id);
             } catch (AgreementNotFoundException e) {
                 throw new RuntimeException(e);
             }
         }
    }
}
