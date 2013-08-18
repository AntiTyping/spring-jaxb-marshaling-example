package foo.bar;

import foo.bar.book.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class BookXMLApp {
    public static void main(String[] args) throws FileNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloService helloService = context.getBean(HelloService.class);
        System.out.println(helloService.sayHello());


        Jaxb2Marshaller jaxbMarshaller = (Jaxb2Marshaller)context.getBean("jaxbMarshaller");

        Map marshallerProperties = new HashMap();
        marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setMarshallerProperties(marshallerProperties);

        {
            Book book = new Book();
            book.setTitle("Test-Driven Development by Example");

            StreamResult result = new StreamResult(System.out);

            jaxbMarshaller.marshal(book, result);
        }

        {
            Department department = new Department();
            department.setId("IT");
            department.setName("IT Department");

            Employee employee = new Employee("12345", "Test Employee");
            employee.setDepartment(department);

            FileOutputStream outputStream = new FileOutputStream(new File("employee.xml"));
//            StreamResult result = new StreamResult(System.out);
            StreamResult result = new StreamResult(outputStream);

            jaxbMarshaller.marshal(employee, result);
        }

        {
            FileInputStream inputStream = new FileInputStream(new File("employee.xml"));
            StreamSource source = new StreamSource(inputStream);

            Employee employee = (Employee)jaxbMarshaller.unmarshal(source);
            System.out.println("Emp Id is " + employee.getId());
            System.out.println("Emp Name is " + employee.getName());

            Department department = employee.getDepartment();
            System.out.println("Dept Id is " + department.getId());
            System.out.println("Dept Name is " + department.getName());
        }
    }
}
