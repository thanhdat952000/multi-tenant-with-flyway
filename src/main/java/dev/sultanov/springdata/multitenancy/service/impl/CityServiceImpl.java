package dev.sultanov.springdata.multitenancy.service.impl;

import dev.sultanov.springdata.multitenancy.entity.City;
import dev.sultanov.springdata.multitenancy.exception.HandleException;
import dev.sultanov.springdata.multitenancy.repository.CityRepository;
import dev.sultanov.springdata.multitenancy.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public Map<String, Object> getAll() {
        Map<String, Object> result = new HashMap<>();
        List<City> cities = cityRepository.findAll();
        result.put("result", cities);
        result.put("status", true);
        result.put("msg", "Truy xuất dữ liệu thành công");
        return result;
    }

    @Override
    public Map<String, Object> create(City city) {
        Map<String, Object> result = new HashMap<>();
        City newCity = cityRepository.save(city);
        result.put("result", newCity);
        result.put("status", true);
        result.put("msg", "Thêm mới dữ liệu thành công");
        return result;
    }

    @Override
    public Map<String, Object> update(City city) {
        Map<String, Object> result = new HashMap<>();
        Optional<City> opCity = cityRepository.findById(city.getId());
        if (opCity.isEmpty()) {
            throw new HandleException("Truy xuất dữ liệu thất bại!");
        }
        City updateCity = opCity.get();
        updateCity.setName(city.getName());
        result.put("result", cityRepository.save(updateCity));
        result.put("status", true);
        result.put("msg", "Cập nhật dữ liệu thành công");
        return result;
    }

    @Override
    public Map<String, Object> getById(Long id) {
        Map<String, Object> result = new HashMap<>();
        Optional<City> city = cityRepository.findById(id);
        if (city.isEmpty()) {
            throw new HandleException("Không tìm thấy đối tượng với id = " + id);
        }
        result.put("result", city.get());
        result.put("status", true);
        result.put("msg", "Truy xuất dữ liệu thành công");
        return result;
    }

    @Override
    public Map<String, Object> delete(Long[] listId) {
        Map<String, Object> result = new HashMap<>();
        for (Long id : listId) {
            Optional<City> opCity = cityRepository.findById(id);
            if (opCity.isEmpty()) {
                throw new HandleException("Không tìm thấy đối tượng để xóa!");
            }
            cityRepository.delete(opCity.get());
        }
        result.put("status", true);
        result.put("msg", "Xóa dữ liệu thành công!");
        return result;
    }
}