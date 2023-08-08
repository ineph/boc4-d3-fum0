package com.example.bocadefumoapi.repositories;

import com.example.bocadefumoapi.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {
}
