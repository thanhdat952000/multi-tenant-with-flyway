package dev.sultanov.springdata.multitenancy.repository;

import dev.sultanov.springdata.multitenancy.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}