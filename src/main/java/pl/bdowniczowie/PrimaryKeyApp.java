package pl.bdowniczowie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.bdowniczowie.entity.Employee;

public class PrimaryKeyApp {
    public static void main(String[] args){
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        Employee employee = new Employee();
        employee.setFirstName("Jurek");
        employee.setLastName("Owsiak");
        employee.setSalary(10000);

        Employee employee1 = new Employee();
        employee1.setFirstName("Kazik");
        employee1.setLastName("Mieszała");
        employee1.setSalary(15000);

        Employee employee2 = new Employee();
        employee2.setFirstName("Roman");
        employee2.setLastName("Borodzik");
        employee2.setSalary(9000);

        session.beginTransaction();
        session.persist(employee);
        session.persist(employee1);
        session.persist(employee2);
        session.getTransaction().commit();
        factory.close();
    }
}
