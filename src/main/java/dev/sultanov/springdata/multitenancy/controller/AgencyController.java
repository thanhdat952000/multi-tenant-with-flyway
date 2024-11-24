package dev.sultanov.springdata.multitenancy.controller;

import dev.sultanov.springdata.multitenancy.entity.Agency;
import dev.sultanov.springdata.multitenancy.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/agency")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @PostMapping
    public Map<String, Object> create(@RequestBody Agency agency) {
        return agencyService.create(agency);
    }

    @GetMapping
    public Map<String, Object> getAll() {
        return agencyService.getAll();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getById(@PathVariable(value = "id") Long id) {
        return agencyService.getById(id);
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody Agency agency) {
        return agencyService.update(agency);
    }

    @DeleteMapping
    public Map<String, Object> delete(@RequestBody Long[] listId) {
        return agencyService.delete(listId);
    }
}
