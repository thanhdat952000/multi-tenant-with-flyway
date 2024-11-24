package dev.sultanov.springdata.multitenancy.controller;

import dev.sultanov.springdata.multitenancy.entity.City;
import dev.sultanov.springdata.multitenancy.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping
    public Map<String, Object> addCity(@RequestBody City city) {
        return cityService.create(city);
    }

    @GetMapping
    public Map<String, Object> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getById(@PathVariable(value = "id") Long id) {
        return cityService.getById(id);
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody City city) {
        return cityService.update(city);
    }

    @DeleteMapping
    public Map<String, Object> delete(@RequestBody Long[] listId) {
        return cityService.delete(listId);
    }
}