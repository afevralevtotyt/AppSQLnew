import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Application {
//Вроде все работает
    public static void main(String[] args) {

       EmployeeDAO employeeDAO = new EmployeeDAOImpl();

       Employee fedor = new Employee("Fedor", "Vasnecov", "male", 24, 1);

       employeeDAO.createEmployee(fedor);

       System.out.println(employeeDAO.readById(1));

       Employee elena = new Employee(2, "Elena", "Holodcova", "female", 23,  1);

       employeeDAO.updateEmployee(elena);


       List<Employee> employeeList = employeeDAO.readAll();

       employeeList.stream().forEach(System.out::println);
       employeeDAO.delete(fedor);

       List<Employee> employeeListAfterDelete = employeeDAO.readAll();

       employeeListAfterDelete.stream().forEach(System.out::println);

    }

}
