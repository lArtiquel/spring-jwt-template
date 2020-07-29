# Spring jwt template

Simple Spring JWT Authentication template with some routes to test.

I deployed demo to Heroku and left api opened to everyone, so feel free to test.

Check [api documentation](https://spring-jwt-template.herokuapp.com/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config).

Link to api --> https://spring-jwt-template.herokuapp.com/

## Tech stack:
* Java 11.
* Spring (Boot, Security, Data).
* Mongodb.
* Java JWT.
* Lombok.
* Swagger.

### Requests

#### Registration

##### Registration success
<p align="center">
  <img src="img/register_success.png">
</p>

##### Registration failure
<p align="center">
  <img src="img/register_failure.png">
</p>

#### Login

##### Login success
<p align="center">
  <img src="img/login_success.png">
</p>

##### Login failure
<p align="center">
  <img src="img/login_failure.png">
</p>

#### Refresh

##### Refresh success
<p align="center">
  <img src="img/refresh_success.png">
</p>

##### Refresh failure
<p align="center">
  <img src="img/refresh_failure.png">
</p>

#### Accessing content

##### Public content accessing
<p align="center">
  <img src="img/public_content.png">
</p>

##### Protected route accessing with valid token and authorities
<p align="center">
  <img src="img/protectedRoute_success.png">
</p>

##### Protected route accessing with wrong token
<p align="center">
  <img src="img/protectedRoute_failure.png">
</p>

##### Protected route accessing without required authority
<p align="center">
  <img src="img/unauthorized.png">
</p>

That's it. If you found some bug, please, open issue or better create pull request. Thanks!
	
***Best Regards, Arti Tsv!***