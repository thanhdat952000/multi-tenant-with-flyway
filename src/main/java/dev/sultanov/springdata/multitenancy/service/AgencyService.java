package dev.sultanov.springdata.multitenancy.service;


import dev.sultanov.springdata.multitenancy.entity.Agency;

import java.util.Map;

public interface AgencyService {
    Map<String, Object> getAll();

    Map<String, Object> create(Agency agency);

    Map<String, Object> update(Agency agency);

    Map<String, Object> getById(Long id);

    Map<String, Object> delete(Long[] listId);
}
