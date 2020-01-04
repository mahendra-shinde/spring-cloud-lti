### Demo 6 : Spring DATA-JPA

1.  Create new Spring starter project with following details:

    ```yaml
    Name:   demo-6
    Type:   Maven
    Packaging:  Jar
    Java Version: 8
    Language:   Java

    Group:  com.mahendra
    Artifact:   demo-6
    Version:    1.0
    Package:    com.mahendra.demo
    ```

2.  Add following starter's

    2.1  Spring-web
    2.2  Spring Data-JPA
    2.3  DevTools

3.  Open POM.XML file and add dependency for OJDBC driver.

    ```XML
    <dependency>
        <groupId>com.oracle</groupId>
        <artifactId>ojdbc8</artifactId>
        <version>19.3</version>
    </dependency>
    ```

4.  Open the `application.properties` file and add following properties:

    ```ini
    server.port=8081
    ### Data source properties
    spring.datasource.url=jdbc:oracle:thin:@localhost:1521/xe
    spring.datasource.username=hr
    spring.datasource.password=hr
    ### JPA Properties
    spring.jpa.show-sql=true
    spring.jpa.database-platform=org.hibernate.dialect.Oracle10gDialect
    ```

5.  Create a new ENTITY class `com.mahendra.demo.models.Department`

    ```java
    @Entity
    @Table(name="departments")
    public class Department {
        
    @Id
    @SequenceGenerator(name="seq1",allocationSize=1,sequenceName="department_seq")
    @GeneratedValue(generator="seq1")
    @Column(name="department_id")
    private Integer deptId;
    
    @Column(name="department_name",length=30)
    private String name;
    
    @Column(name="manager_id")
    private Integer managerId;
    
    @Column(name="location_id")
    private Integer locationId;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Department() {
        super();
        // TODO Auto-generated constructor stub
    }
        
    }
    ```

6.  Create a new DAO interface (AKA Repository interface) `com.mahendra.demo.daos.DepartmentDAO`

    ```java
    @Repository
    public interface DepartmentDAO extends CrudRepository<Department, Integer>{
            
        @Query("select d from Department d")
        public List<Department> findAll();
    }
    ```

7.  Create a controller class `com.mahendra.demo.controllers.DepartmentController`

    ```java
    @RestController
    @RequestMapping("/depts")
    public class DepartmentController {

    @Autowired private DepartmentDAO dao;
    
    @GetMapping
    public List<Department> getAll(){
        System.out.println("get all departments");
        return dao.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Department> find(@PathVariable int id)
    {
        Optional<Department> dept = dao.findById(id);
        if(dept.isPresent()) {
            return new ResponseEntity<>(dept.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    }
    ```

8.  Run the project as `Spring Boot App` and then TEST following URLs

    http://localhost:8081/depts/

    http://localhost:8081/depts/10

    http://localhost:8080/depts/50
    
    