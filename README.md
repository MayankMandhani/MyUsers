# MyUsers
An API for User registration, authentication and login using Java, Springboot, JPA, PostgreSQL and Gradle.

# Routes (http://localhost:8080/):
/users/register -  For registration of user.
Request body example (User Object): 
{
    "email": "tester@test.com",
    "firstName": "Tester",
    "lastName": "Test",
    "dob": "2000-12-09",
    "place": "India",
    "password": "test"
}

/users/login - To login existing users.
Request body example:
{
    "email": "tester@test.com",
    "password": "test"
}

/users/logout - To logout a particular user.
Request body example (User Object): 
{
    "email": "tester@test.com",
    "firstName": "Tester"
    "lastName": "Test",
    "dob": "2000-12-09",
    "place": "India",
    "password": "test"
}

/login_history - To view the captures Login History
No request body required.
