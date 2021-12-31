package com.lucid.a2bmoving.admin.service;

import com.lucid.a2bmoving.admin.Movers;
import com.lucid.a2bmoving.admin.repository.MoverRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MoverService {
    @Autowired
    private MoverRepository moverRepository;

    public Iterable<Movers> getAllMovers()
    {
        if (moverRepository.findAll() != null)
            return moverRepository.findAll();
        else
            throw new NullPointerException("THERE ARE NO MOVERS YET");
    }
}
