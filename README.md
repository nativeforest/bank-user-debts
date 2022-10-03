# Bank user debts Project

Project using Java SpringBoot, H2 y JPA


#Tools and version used

Java version: 11
<br /> 
Database: h2database 
<br />
sprijng boot starter parent : 2.7.4 
<br />
IDLE: Visual Code 

# DB
At the start of the project,H2 memory database runs inside CommandLineRunner, so check the database state via http://localhost:8080/h2-console/ , with the next credentials

Saved Settings: Generic H2 (Embedded) 
Setting Name: Generic H2 (Embedded) 
Driver Class: org.h2.Driver 
JDBC URL: jdbc:h2:mem:testdb 
User Name: sa 
password: password 

# ENDPOINTS
running on the URL http://localhost with port 8080 ( http://localhost:8080/api/v1 ) 

-List of banks by user Id
/api/v1/user/<userId>/banks

-List debts by Bank Id
/api/v1/bank/<BankId>/debts


-Permitir al cliente pagar la deuda.

/api/v1/bank/<BankId>/debts  (falta)

-List Banks by User Id.
/api/v1/user/<userId>/banks

