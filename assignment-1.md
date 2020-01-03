## Assignment 1 : Rest with CRUD for 'employee' object

1.  Define a model object for `Employee` class with following properties:

    - firstName
    - lastName
    - designation
    - empId

2.  Define a EmployeRepository with LIST of employees. 
    And following operations:

    - save(Employee emp)
    - update(Employee emp)
    - find(int id)
    - delete(int id)

3.  Define a REST controller to handle following request URLS

    Find By id:    GET http://localhost:8081/employees/{id}
    Save:          POST  http://localhost:8081/employees/
    Update:        PUT http://localhost:8081/employees/
    Delete:       DELETE http://localhost:8081/employees/{id}  