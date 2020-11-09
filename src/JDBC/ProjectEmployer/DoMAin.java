package JDBC.ProjectEmployer;

import ProjectemployeerSecond.ProjectEmployer.Entity.Address;
import ProjectemployeerSecond.ProjectEmployer.Entity.Employee;
import ProjectemployeerSecond.ProjectEmployer.Entity.EmployeeProject;
import ProjectemployeerSecond.ProjectEmployer.Entity.Project;
import ProjectemployeerSecond.ProjectEmployer.Service.AddressService;
import ProjectemployeerSecond.ProjectEmployer.Service.EmployeeProjectService;
import ProjectemployeerSecond.ProjectEmployer.Service.EmployeeService;
import ProjectemployeerSecond.ProjectEmployer.Service.ProjectService;

import java.sql.SQLException;
import java.util.Calendar;

public class DoMAin {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();
        EmployeeProjectService employeeProjectService = new EmployeeProjectService();

        Address address = new Address();
        address.setId(1L);
        address.setCountry("DC");
        address.setCity("Gotham City");
        address.setStreet("Arkham street 1");
        address.setPostCode("12345");

        Employee employee = new Employee();
        employee.setId((int) 1L);
        employee.setFirstName("James");
        employee.setLastName("Gordon");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthDay(new java.sql.Date(calendar.getTime().getTime()));
        employee.setAddressId((int) address.getId());

        Project project = new Project();
        project.setId(1L);
        project.setTitle("Gotham City Police Department Commissioner");

        EmployeeProject employeeProject = new EmployeeProject();
        employeeProject.setEmployeeId(employee.getId());
        employeeProject.setProjectId(project.getId());

        try {
            addressService.add(address);
            employeeService.add(employee);
            projectService.add(project);
            employeeProjectService.add(employeeProject);

//            List<Adress> addressList = adressService.getAll();
//            List<Employee> employeeList = employeeService.getAll();
//            for (Employee e : employeeList) {
//                System.out.println(e);
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
