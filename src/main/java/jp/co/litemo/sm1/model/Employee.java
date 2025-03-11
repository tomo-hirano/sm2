package jp.co.litemo.sm1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * 従業員1名を表す
 * 変換元: /Domain/DomainObject/Employee.vb
 */
@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "従業員Noは必ず入力してください")
    @Size(max = 5, message = "従業員Noは5文字以内で指定してください")
    @Column(name = "employee_number", unique = true, nullable = false)
    private String employeeNo;

    @NotBlank(message = "従業員名は必ず入力してください")
    @Size(max = 20, message = "従業員名は20文字以内で指定してください")
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 20, message = "従業員名(かな)は20文字以内で指定してください")
    @Column(name = "name_kana")
    private String nameKana;

    @Email(message = "E-mailの形式が正しくありません")
    @Size(max = 30, message = "E-mailは30文字以内で指定してください")
    @Column(name = "email")
    private String email;

    // Getters and Setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}