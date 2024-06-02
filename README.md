
```markdown
# Scrum Coaches Application

This is a Spring Boot application for managing Scrum Coaches. It allows users to add Scrum Coaches with their name and email, and view all Scrum Coaches in the database.

## Prerequisites

- Java 8 or higher
- Maven
- MySQL

## Installation

### MySQL Database Setup

1. **Install MySQL:**

   Download and install MySQL from the official website: [MySQL Downloads](https://dev.mysql.com/downloads/)

2. **Start MySQL Service:**

   Start the MySQL service. This can be done via the terminal or using a tool like MySQL Workbench.

3. **Create Database:**

   Open your MySQL client and run the following command to create a new database:

   ```sql
   CREATE DATABASE scrum_coaches_db;
   ```

4. **Create User (Optional):**

   Create a new MySQL user and grant privileges to the newly created database (optional step):

   ```sql
   CREATE USER 'scrum_user'@'localhost' IDENTIFIED BY 'your_password';
   GRANT ALL PRIVILEGES ON scrum_coaches_db.* TO 'scrum_user'@'localhost';
   FLUSH PRIVILEGES;
   ```

### Application Setup

1. **Clone the Repository:**

   Clone the repository to your local machine using the following command:

   ```bash
   git clone https://github.com/sxwxbxr/m426_repo.git
   cd m426_repo
   ```

2. **Configure Application Properties:**

   Update the `application.properties` file located in `src/main/resources` with your MySQL database details:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/scrum_coaches_db
   spring.datasource.username=scrum_user
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. **Build and Run the Application:**

   Use Maven to build and run the application:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access the Application:**

   Open your web browser and navigate to `http://localhost:8080/index.html`.

## Usage

- **Add a Scrum Coach:**
    - Fill in the name and email fields in the form and click "Submit".
    - This will send a POST request to the backend to save the Scrum Coach in the database.

- **View All Scrum Coaches:**
    - Click the "Refresh" button to retrieve and display all Scrum Coaches from the database, if they are not being displayed already.

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── wiss
│   │           └── m426
│   │               ├── controller
│   │               │   └── ScrumCoachesController.java
│   │               ├── model
│   │               │   └── ScrumCoach.java
│   │               ├── repository
│   │               │   └── ScrumCoachesRepository.java
│   │               ├── service
│   │               │   └── ScrumCoachesService.java
│   │               └── DemoApplication.java
│   ├── resources
│   │   ├── application.properties
│   │   └── static
│   │       └── index.html
│   └── test
│       └── java
```

## Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- MySQL Connector Java
- Spring Boot Starter Test

These dependencies are defined in the `pom.xml` file.

## Troubleshooting

- **Whitelabel Error Page:**
    - Ensure the `index.html` file is placed correctly in `src/main/resources/static`.
    - Verify the database connection settings in `application.properties`.
    - Check the console logs for any error messages and address them accordingly.

- **Database Connection Issues:**
    - Ensure MySQL is running and accessible.
    - Double-check the database URL, username, and password in `application.properties`.
    - Verify that the database and user have been created correctly in MySQL.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
