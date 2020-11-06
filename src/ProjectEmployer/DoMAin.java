package ProjectEmployer;

import ProjectEmployer.Entity.Adress;
import ProjectEmployer.Entity.EmplProj;
import ProjectEmployer.Entity.Employee;
import ProjectEmployer.Entity.Project;
import ProjectEmployer.Service.AdressService;
import ProjectEmployer.Service.EmplProjService;
import ProjectEmployer.Service.EmployeeService;
import ProjectEmployer.Service.ProjectService;

import java.sql.SQLException;
import java.util.Calendar;

public class DoMAin {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        AdressService adressService = new AdressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();
        EmplProjService emplProjService = new EmplProjService();

        Adress address = new Adress();
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

        EmplProj emplProj = new EmplProj();
        emplProj.setEmployeeId(employee.getId());
        emplProj.setProjectId(project.getId());

        try {
            adressService.add(address);
            employeeService.add(employee);
            projectService.add(project);
            emplProjService.add(emplProj);

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
