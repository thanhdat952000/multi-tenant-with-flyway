package dev.sultanov.springdata.multitenancy.repository;

import dev.sultanov.springdata.multitenancy.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, Long> {
}
