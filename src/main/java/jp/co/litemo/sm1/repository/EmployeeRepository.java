package jp.co.litemo.sm1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.litemo.sm1.model.Employee;

/**
 * 従業員永続化のためのリポジトリ
 * 変換元: /Domain/Repository/IEmployeeRepository.vb
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmployeeNo(String employeeNo);
    List<Employee> findByNameContaining(String name);
    List<Employee> findByNameKanaContaining(String nameKana);
}
