### Description



GET  http://localhost:8080/simplewebapp/employees/ - all employees

GET  http://localhost:8080/simplewebapp/employees/2   - get employee by id

POST http://localhost:8080/simplewebapp/employees/ - add employee
        Body 
        {"firstName":"Ivan","lastName":"Pupkin","jobTitle":"Driver","gender":"MALE","dateOfBirth":"2000-06-08"}

PUT  http://localhost:8080/simplewebapp/employees/  - update employee  
        Body
        {"employeeId":4, "firstName":"Lara","lastName":"Pupkin","departamentId":2,"jobTitle":"Manager","gender":"FEMALE","dateOfBirth":"2000-06-08"}
        
DELETE http://localhost:8080/simplewebapp/employees/1 - delete employee by id
        
        
        
  

