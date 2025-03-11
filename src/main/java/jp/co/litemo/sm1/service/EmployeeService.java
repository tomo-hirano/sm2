package jp.co.litemo.sm1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.litemo.sm1.model.Employee;
import jp.co.litemo.sm1.repository.EmployeeRepository;

/**
 * 従業員情報のビジネスロジックを提供するサービス
 * 変換元: /Infrastructure/RepositoryImpl/EmployeeRepositoryImpl.vb
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    public Employee getEmployeeByEmployeeNo(String employeeNo) {
        return employeeRepository.findByEmployeeNo(employeeNo);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> searchEmployees(String name, String nameKana) {
        if (name != null && !name.isEmpty()) {
            return employeeRepository.findByNameContaining(name);
        } else if (nameKana != null && !nameKana.isEmpty()) {
            return employeeRepository.findByNameKanaContaining(nameKana);
        }
        return getAllEmployees();
    }
}
