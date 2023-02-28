import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {
      final String user = "postgres";
      final String password = "123";
      final String url = "jdbc:postgresql://localhost:5432/skypro";

      try (final Connection connection = DriverManager.getConnection(url, user, password);
           PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id =(?)")){

          statement.setInt(1, 1);

          final ResultSet resultSet = statement.executeQuery();


          while (resultSet.next()){
              String firstName = "Name: " + resultSet.getString("first_name");
              String lastName = "Last name: " + resultSet.getString("last_name");
              String gender = "Gender: " + resultSet.getString("gender");
              int age = resultSet.getInt("age");
              int cityId = resultSet.getInt("city_id");

              System.out.println(firstName);
              System.out.println(lastName);
              System.out.println(gender);
              System.out.println(age);
              System.out.println(cityId);

          }
          EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

          employeeDAO.createEmployee(new Employee("Alexandra", "Fedotova", "female", 19, new City( 1,"Moscow")));

          Employee firstEmplyoyee = employeeDAO.readById(1);

          System.out.println("Первый сотрудник " +firstEmplyoyee);

          List <Employee> employeeList = new ArrayList<>();

          employeeList = employeeDAO.readAll();


          System.out.println("Список при добавленном сотруднике");
          employeeList.stream().forEach(System.out::println);

          employeeDAO.updateEmployeeById(2, "Lida", "Petrova", "female", 18, 1);

          System.out.println("Второй сотрудник: " + employeeDAO.readById(2));

          employeeDAO.deleteById(11);

          List<Employee> employeeListLast = employeeDAO.readAll();

          System.out.println("Список после удаления сотрудника");
          employeeListLast.stream().forEach(System.out::println);



      }

    }

}
