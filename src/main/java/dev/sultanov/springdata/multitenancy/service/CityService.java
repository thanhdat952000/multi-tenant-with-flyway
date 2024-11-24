package dev.sultanov.springdata.multitenancy.service;

import dev.sultanov.springdata.multitenancy.entity.City;

import java.util.Map;

public interface CityService {
    Map<String, Object> getAll();

    Map<String, Object> create(City city);

    Map<String, Object> update(City city);

    Map<String, Object> getById(Long id);

    Map<String, Object> delete(Long[] listId);
}