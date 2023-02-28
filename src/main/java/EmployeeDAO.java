import java.util.List;

public interface EmployeeDAO {

    void createEmployee (Employee employee);

    Employee readById (int id);

    List<Employee> readAll();

    void updateEmployeeById(int id, String firstName, String lastName, String gender, int age, int cityId);

    void deleteById(int id);

}
