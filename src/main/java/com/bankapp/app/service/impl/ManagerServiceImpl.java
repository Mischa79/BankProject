package com.bankapp.app.service.impl;

import com.bankapp.app.entity.Manager;
import com.bankapp.app.repository.ManagerRepository;
import com.bankapp.app.service.util.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    @Override
    public Manager getManagerById(String id) {
        return managerRepository.findById(Integer.parseInt(id)).orElse(null);
    }
}
