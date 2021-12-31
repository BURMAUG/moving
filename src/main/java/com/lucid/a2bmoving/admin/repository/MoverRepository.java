package com.lucid.a2bmoving.admin.repository;

import com.lucid.a2bmoving.admin.Movers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MoverRepository extends CrudRepository<Movers, UUID> {
}
