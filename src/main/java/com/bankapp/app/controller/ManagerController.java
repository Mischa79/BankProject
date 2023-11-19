package com.bankapp.app.controller;


import com.bankapp.app.dto.ManagerTestDto;
import com.bankapp.app.entity.Manager;
import com.bankapp.app.mapper.ManagerTestMapper;
import com.bankapp.app.service.util.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/{id}")
    public ManagerTestDto getManagerById(@PathVariable("id")String id){
        Manager manager = managerService.getManagerById(id);
        return ManagerTestMapper.INSTANCE.toDto(manager);
    }
}
