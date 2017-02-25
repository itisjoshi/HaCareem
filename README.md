# HaCareem
Code for Careem Hackathon Event Bangalore India 2017

# Task:

## Book A Ride
One of the goals we strive towards at Careem is creating a perfect booking experience for our Customers- extremely reliable ETAS, accurate locations, best Captains and so on. Build a ride dispatching platform that collects location updates from ‘drivers on the move’ to later be used as data to dispatch the best driver to a customer that wants to book a ride. It is up to you to creatively decide the features, capability and complexity of the platform (Eg: Moving cars on the map, multiple bookings per driver etc.)

## Things to Think About
What REST frameworks you will use
In-memory vs. persistent storage
Testing (unit testing/integration testing/mocking etc.)
Optimized dispatching algorithms
Service Oriented Architecture
Asynchronous processing of location updates like message queues
Horizontal scaling
Design patterns, dependency injection etc.
We will be judging you on the following criteria:

## Judging Criteria
1. Innovativeness
2. Architecture
3. Manageability and Scalability
4. Application Performance
5. Code Toxicity
6. Robustness
7. Completeness (Demoable)




# Our Approach
Project is all about booking a ride. Here We are priortized things for booking a cab based on the following criteria such as
Minimum wage of the driver on that current day, 
Longest waiting time of the driver and shortest distance driver.
We covered the distance of 1 Km from the current customer location based on the latitude and longitude
We will search the cab and allocate based on the above criteria. 
The user setting preferences can be done apart from the 
default settings like switching driver gender and Minimum driver rating as well. 

In order to prevent Race Condition upon booking a Queueing system is used for a specific driver.
The location of the driver is get trakced for every 5 seconds and we are using a Amazon SQS queue to process the location queue. We are using Redis to keep track of the moving car with the customer latitude and longitude until the destination is reached. We can lively locate a vehicle. After the destination is reached location data is moved to mysql from redis.

## Technology & Architecture used:

1. SPRING MVC
2. Hibernate
3. MySql(All Meta informations)
4. Redis(frequest changes to the current location of the cab is stored here.)
5. SQS(Location Changes Information will be stored by lining up in Amazon SQS)
6. Queuing System(To Prevent Race Condition, an internal queuing system is used)

## Installation 

1. mvn clean
2. mvn install
3. mvn deploy

## API Calls:

|Return Type|Request Method|URL Mapping  |
|-----------|--------------|------------ |
|List<UserModel>  |GET           |/user/list   |
|UserModel  |POST          |/user/create |
|UserModel  |PUT           |/user/edit   |
|UserModel  |DELETE        |/user/delete |

```javascript
UserModel:
{
	Long userId;
	String name;
	String email;
}
```


|Return Type|Request Method|URL Mapping    |
|-----------|--------------|------------   |
|List<DriverModel>|GET           |/driver/list   |
|DriverModel|POST          |/driver/create |
|DriverModel|PUT           |/driver/edit   |
|DriverModel|DELETE        |/driver/delete |

```javascript
DriverModel:
{
	Long driverId;
	String bookingStatus;
	Date lastDriveFinishedDate;
	Long userId;
	String name;
	String email;
	Long cabid;
	CabType cabType;
	String gender;
	String rating;
	Double latitude;	
	Double longitude;
}
```

Returns CustomerModel GET /customer/list 
Returns CustomerModel POST /customer/create 
Returns CustomerModel PUT /customer/edit 
Returns CustomerModel DELETE /customer/delete 

|Return Type|Request Method|URL Mapping  |
|-----------|--------------|------------ |
|List<CustomerModel>|GET           |/customer/list   |
|CustomerModel|POST          |/customer/create |
|CustomerModel|PUT           |/customer/edit   |
|CustomerModel|DELETE        |/customer/delete |

```javascript
CustomerModel: 
{
	String preference;
	Long customerId;
	String name;
	String email;
	String gender;
	Long userId;
}
```


|Return Type|Request Method|URL Mapping  |
|-----------|--------------|------------ |
|List<CabModel>|GET           |/cab/list   |
|CabModel|POST          |/cab/create |
|CabModel|PUT           |/cab/edit   |
|CabModel|DELETE        |/cab/delete |
```javascript
CabModel
{
  Long cabId;
  CabType cabType;
  Long seatsCount;
}
```

```javascript
CabType {
	SHARE,
	PRIME
}
```



|Return Type|Request Method|URL Mapping  |
|-----------|--------------|------------ |
|BookingModel|GET           |/booking/book/{customerid}/{latitude}/{longitude}   |
|BookingModel|GET          |booking/book/generatecost/{id} |
|BookingModel|GET        |/booking/book/updatedrop/{id}/{latitude}/{longitude} |
|BookingModel|GET        |/booking/book/updaterating/{id}/{rating} |
|BookingModel|GET        |/booking/book/updatecablocation/{id}/{latitude}/{longitude} |
|HashMap<String, Double>| GET | /book/getcablocation/{id}|

# Contributors

1. [Prathap Manohar Joshi](https://www.linkedin.com/in/pmjoshi) : https://github.com/itisjoshi

2. [Karthekeyan Devanand](https://www.linkedin.com/in/karthekeyandevanand) : https://github.com/Karthekeyan-Engine
