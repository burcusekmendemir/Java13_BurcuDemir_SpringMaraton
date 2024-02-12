package com.burcu.service;

import com.burcu.repository.HastaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HastaService {
    private final HastaRepository hastaRepository;
}
