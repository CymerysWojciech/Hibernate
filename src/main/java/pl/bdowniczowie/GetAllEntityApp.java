package pl.bdowniczowie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.bdowniczowie.entity.Employee;

import java.util.List;

public class GetAllEntityApp {
    public static void main(String[] args){
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        List<Employee> result = session.createQuery("from Employee ").getResultList();
        for (Employee employee: result){
            System.out.println(employee);
        }
        session.getTransaction().commit();
        factory.close();
    }
}
