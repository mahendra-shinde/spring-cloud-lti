## Built in JSON Parsing

1.  Create a new model java class `product` in package `com.mahendra.demo.models`

    ```java
    public class Product{
    private String name;
	private Integer id;
	private String description;
	private Double price;
    }
    ```

2.  Using `source` menu in eclipse generate getters/setters and constructors (empty constructor and parameterized constructor)

3.  Create a new repository `ProductRepository` in `com.mahendra.demo.daos`

    ```java
    @Repository
    public class ProductRepository {
        
        List<Product> products = new LinkedList<>();
        
        @PostConstruct
        public void init() {
            System.out.println("Generate sample data");
            products.add(new Product("Product A",101,"Sample product A",120D));
            products.add(new Product("Product B",102,"Sample product B",110.3D));
            products.add(new Product("Product C",103,"Sample product C",320.67D));
        }
        
        public Product findById(int id) {
            return products.stream().filter(p->p.getId()==id).findFirst().get();
        }
    }
    ```

4.  Create a new controller `ProductController` in package `com.mahendra.controllers`

    ```java
    @RestController
    @RequestMapping("/products")
    public class ProductController {

        @Autowired private ProductRepository productRepo;
        
        @GetMapping("/find/{id}")
        public Product find(@PathVariable("id") Integer id) {
            return productRepo.findById(id);
        }
    }
    ```

5.  Run the project (if not already running)

6.  URL to be tested :  http://localhost:8081/products/find/101