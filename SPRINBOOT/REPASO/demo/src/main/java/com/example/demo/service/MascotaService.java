package com.example.demo.service;

import com.example.demo.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService {

    @Autowired
    MascotaRepository mascRepo;
}
