package foo.bar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: apliszka
 * Date: 8/18/13
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "employee")
public class Employee {

    private String id;
    private String name;
    private Department department;

    public Employee() {}

    public Employee(String id, String name){
        this.id = id;
        this.name = name;
    }

    @XmlElement(name = "empId")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "empName")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "department")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}