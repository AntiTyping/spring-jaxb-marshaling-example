package foo.bar;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: apliszka
 * Date: 8/18/13
 * Time: 12:32 AM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "department")
public class Department {

    private String id;
    private String name;

    @XmlAttribute(name = "deptId")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "deptName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
