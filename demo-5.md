### CRUD Operation on in-memory collection

1.  Copy `demo-3` as new project `demo-5`

2.  In newly created `demo-5` open `pom.xml` file and then find-and-replace all occurances of `demo-3` with `demo-5`

3.  To avoid confusion, in eclipse, right click on `demo-5` project and use option `Close unrelated projects`.

4.  Open `ProductRepository` class and make following changes.

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
            Optional<Product> px = products.stream().filter(p->p.getId()==id).findFirst();
            if(px.isPresent())
                return px.get();
            else
                return null;
        }
        
        public void save(Product product) {
            //check if product already exists!
            Product temp = findById(product.getId());
            if(temp!=null) {
                throw new RuntimeException("Product already exists!");
            }
            products.add(product);
        }
        
        public void update(Product product) {
            //check if product already exists!
            Product temp = findById(product.getId());
            if(temp==null) {
                throw new RuntimeException("Product does not exists!");
            }
            temp = product; 
        }	
        
        public void delete(int id) {
            //check if product already exists!
            Product temp = findById(id);
            if(temp==null) {
                throw new RuntimeException("Product does not exists!");
            }
            products.remove(temp);
        }
        
    }
    ```

5.  Modify the `ProductController` class

    ```java
    @RestController
    @RequestMapping("/products")
    public class ProductController {

        @Autowired private ProductRepository productRepo;
        
        @GetMapping(value="/find/{id}",produces= {"application/json","application/xml"})
        public Product find(@PathVariable("id") Integer id) {
            return productRepo.findById(id);
        }
        
        // POST http://localhost:8081/products/save
        @PostMapping(value="/save",consumes="application/json")
        public ResponseEntity<String> save(@RequestBody Product product){
            try {
            productRepo.save(product);
            return new ResponseEntity<>("Saved !",HttpStatus.CREATED);
            }catch(RuntimeException ex) {
                System.out.println(ex.getMessage());
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
        // PUT http://localhost:8081/products/update
        @PutMapping(value="/update",consumes="application/json")
        public ResponseEntity<String> update(@RequestBody Product product){
            try {
                productRepo.update(product);
                return new ResponseEntity<>("Saved !",HttpStatus.CREATED);
                }catch(RuntimeException ex) {
                    System.out.println(ex.getMessage());
                    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
                }
        }
        
        // DELETE http://localhost:8081/products/{id}
        @DeleteMapping(value="/{id}")
        public ResponseEntity<String> deleteById(@PathVariable int id){
            try {
                productRepo.delete(id);
                return new ResponseEntity<String>("Record Deleted",HttpStatus.OK);
            }catch(Exception ex) {
                ex.printStackTrace();
                return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
            }
        }
        
    }
    ```

6.  Run application as Spring Boot App and Test using Postman.

    URL:        http://localhost:8081/products/save

    Body:       Select 'ROW' and then 'Application/JSON'
    
    Body text:       

    ```json
    {
        "name": "Product D",
        "id": 104,
        "description": "Sample product D",
        "price": 110.34
    }
    ```

    click 'Send' button TWICE!

7.  Test the PUT operation (Update)

    Create a new request in Postman 
    
    ```
    Request Type: PUT
    URL:        http://localhost:8081/products/update
    Body:       Select 'ROW' and then 'Application/JSON'
    ```
    
    Body text:       

    ```json
    {
        "name": "Parle G",
        "id": 104,
        "description": "Gluco Buicuites",
        "price": 5
    }
    ```

8.  Test the GET operation (Retreive)

    Create a new request in Postman 
    
    ```
    Request Type: GET
    URL:        http://localhost:8081/products/find/104
    Accept:     application/json
    ```

9.  Test the DELETE operation 

    Create a new request in Postman 
    
    ```
    Request Type: DELETE
    URL:        http://localhost:8081/products/104
    Accept:     application/json
    ```
