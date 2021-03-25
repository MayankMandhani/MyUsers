# MyUsers
An API for User registration, authentication and login using Java, Springboot, JPA, PostgreSQL and Gradle.

# Routes (http://localhost:8080/):
<b>/users/register</b> -  For registration of user. <br>
Request body example (User Object): <br>
{<br>
    "emai<br>l": "tester@test.com",<br>
    "firstNam<br>e": "Tester",<br>
    "lastName": "<br>Test",<br>
    "dob": "2000-12-0<br>9",<br>
    "place": "India",<br>
    "password": "test"<br>
}<br>
<br>
<b>/users/login</b> - To login existing users.<br>
Request body example:<br>
{<br>
    "email": "tester@test.com",<br>
    "password": "test"<br>
}<br>
<br>
<b>/users/logout</b> - To logout a particular user.<br>
Request body example (User Object): <br>
{<br>
    "email": "tester@test.com",<br>
    "firstName": "Tester"<br>
    "lastName": "Test",<br>
    "dob": "2000-12-09",<br>
    "place": "India",<br>
    "password": "test"<br>
}<br>
<br>
<b>/login_history</b> - To view the captures Login History.<br>
No request body required.
