package com.example.bocadefumoapi.repositories;

import com.example.bocadefumoapi.models.DominioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DominioRepository extends JpaRepository<DominioModel, UUID> {
}
