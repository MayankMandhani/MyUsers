# MyUsers
An API for User registration, authentication and login using Java, Springboot, JPA, PostgreSQL and Gradle.
<br><br>
<b>Routes (http://localhost:8080/):</b><br>
<b>/users/register</b> -  For registration of user. <br>
Request body example (User Object): <br>
{<br>
&emsp;    "email": "tester@test.com",<br>
&emsp;    "firstName": "Tester",<br>
    &emsp;"lastName": "Test",<br>
    &emsp;"dob": "2000-12-09",<br>
  &emsp;  "place": "India",<br>
    &emsp;"password": "test"<br>
}<br>
<br>
<b>/users/login</b> - To login existing users.<br>
Request body example:<br>
{<br>
  &emsp;  "email": "tester@test.com",<br>
&emsp;    "password": "test"<br>
}<br>
<br>
<b>/users/logout</b> - To logout a particular user.<br>
Request body example (User Object): <br>
{<br>
&emsp;    "email": "tester@test.com",<br>
&emsp;    "firstName": "Tester"<br>
&emsp;    "lastName": "Test",<br>
 &emsp;   "dob": "2000-12-09",<br>
   &emsp; "place": "India",<br>
    &emsp;"password": "test"<br>
}<br>
<br>
<b>/login_history</b> - To view the captured Login History.<br>
No request body required.
