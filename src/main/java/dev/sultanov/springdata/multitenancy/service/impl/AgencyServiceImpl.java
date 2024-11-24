package dev.sultanov.springdata.multitenancy.service.impl;

import dev.sultanov.springdata.multitenancy.entity.Agency;
import dev.sultanov.springdata.multitenancy.exception.HandleException;
import dev.sultanov.springdata.multitenancy.repository.AgencyRepository;
import dev.sultanov.springdata.multitenancy.service.AgencyService;
import dev.sultanov.springdata.multitenancy.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private TenantService tenantService;

    @Override
    public Map<String, Object> getAll() {
        Map<String, Object> result = new HashMap<>();
        List<Agency> agencies = agencyRepository.findAll();
        result.put("result", agencies);
        result.put("status", true);
        result.put("msg", "Truy xuất dữ liệu thành công");
        return result;
    }

    @Override
    public Map<String, Object> create(Agency agency) {
        Map<String, Object> result = new HashMap<>();
        Agency newAgency = agencyRepository.save(agency);
        result.put("result", newAgency);
        result.put("status", true);
        result.put("msg", "Thêm mới dữ liệu thành công");
        tenantService.initDatabase(agency.getTenantId());
        return result;
    }

    @Override
    public Map<String, Object> update(Agency agency) {
        Map<String, Object> result = new HashMap<>();
        Optional<Agency> opAgency = agencyRepository.findById(agency.getId());
        if (opAgency.isEmpty()) {
            throw new HandleException("Truy xuất dữ liệu thất bại!");
        }
        Agency updateAgency = opAgency.get();
        updateAgency.setName(agency.getName());
        result.put("result", agencyRepository.save(updateAgency));
        result.put("status", true);
        result.put("msg", "Cập nhật dữ liệu thành công");
        return result;
    }

    @Override
    public Map<String, Object> getById(Long id) {
        Map<String, Object> result = new HashMap<>();
        Optional<Agency> agency = agencyRepository.findById(id);
        if (agency.isEmpty()) {
            throw new HandleException("Không tìm thấy đối tượng với id = " + id);
        }
        result.put("result", agency.get());
        result.put("status", true);
        result.put("msg", "Truy xuất dữ liệu thành công");
        return result;
    }

    @Override
    public Map<String, Object> delete(Long[] listId) {
        Map<String, Object> result = new HashMap<>();
        for (Long id : listId) {
            Optional<Agency> opAgency = agencyRepository.findById(id);
            if (opAgency.isEmpty()) {
                throw new HandleException("Không tìm thấy đối tượng để xóa!");
            }
            agencyRepository.delete(opAgency.get());
        }
        result.put("status", true);
        result.put("msg", "Xóa dữ liệu thành công!");
        return result;
    }
}
