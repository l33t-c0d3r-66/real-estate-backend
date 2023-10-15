# Real Estate Backend
<li> Backend for Real Estate Portfolio Website </li>
<li> This Project is the Back End for a Real Estate Portfolio Application designed in ReactJS </li>
<li> This Project is created using Spring Boot, Spring Web, and Spring Security
<li> This Project is divided into two types of API</li> 
<li> 1. Public API (Publicly accessible) </li>
<li> 2. Private API (Need Token for Request) </li>
<br>


<li> Public API End Points</li>
<br>

`POST: /api/public/login` => Allows you to log in to the Application and get token \
`GET: /api/public/properties/{type}` => Retrieve List of Available Properties based on type. Either buy or rent \
`GET: /api/public/property/{id}` => Retrieve single property with Id \

<li> Private API End Points </li>
<br>

`POST: /api/v1/register` => To Register the User on portal \
`POST: /api/v1/validate/{token}` => Validate JWT Token \
`POST: /api/v1/property` => Save Property Information to rent or sell with the Required Data \
`PUT: /api/v1/property/{id}` => Update the property information with Given Id (Long Type). \
`DELETE: /api/v1/property/{id}` => Delete the Property information with the given id. \


## Purpose of Project
<li> This Backend REST API is designed so that it can be used with React JS front end of Property Portfolio. </li>
<li> There are two types of Users i.e. Authenticated and unauthenticated users </li>
<li> Unauthenticated users will be able to see the list of available properties for sale or rent </li>
<li> To Purchase or Make a Deal they will have to contact the Dealer with Contact Form </li>
<li> Authenticated Users are the dealers who will post different images after verifying the price </li>
<li> Only Authenticated users can Add, Delete, or Update the Property Information </li>
<li> Unauthenticated users will have to contact in order to post an advertisement for selling out or renting </li>

## What is Spring Boot?
<li> Spring Boot is an open-source Java-based framework used to create a Micro Service.
<li> Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run"
<li> You can learn more about Spring Boot on the following link:
<li> https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/

   
