# HaCareem
Code for Careem Hackathon Event Bangalore India 2017

Task:

Book A Ride
One of the goals we strive towards at Careem is creating a perfect booking experience for our Customers- extremely reliable ETAS, accurate locations, best Captains and so on. Build a ride dispatching platform that collects location updates from ‘drivers on the move’ to later be used as data to dispatch the best driver to a customer that wants to book a ride. It is up to you to creatively decide the features, capability and complexity of the platform (Eg: Moving cars on the map, multiple bookings per driver etc.)

Things to Think About
What REST frameworks you will use
In-memory vs. persistent storage
Testing (unit testing/integration testing/mocking etc.)
Optimized dispatching algorithms
Service Oriented Architecture
Asynchronous processing of location updates like message queues
Horizontal scaling
Design patterns, dependency injection etc.
We will be judging you on the following criteria:

Judging Criteria
Innovativeness
Architecture
Manageability and Scalability
Application Performance
Code Toxicity
Robustness
Completeness (Demoable)




 
Project is all about booking a ride. Here We are priortized things for booking a cab based on the following criteria such as
Minimum wage of the driver on that current day, 
Longest waiting time of the driver and shortest distance driver.
We covered the distance of 1 Km from the current customer location based on the latitude and longitude
We will search the cab and allocate based on the above criteria. 
The user setting preferences can be done apart from the 
default settings like switching driver gender and Minimum driver rating as well. 

In order to prevent Race Condition upon booking a Queueing system is used for a specific driver.
The location of the driver is get trakced for every 30 seconds and we are using a Amazon SQS queue to process the location queue. We are using Redis to keep track of the moving car with the customer latitude and longitude until the destination is reached. We can lively locate a vehicle. After the destination is reached location data is moved to mysql from redis.

Technology & Architecture used:

SPRING MVC
Hibernate
MySql(All Meta informations)
Redis(frequest changes to the current location of the cab is stored here.)
SQS(Location Changes Information will be stored by lining up in Amazon SQS)
Queuing System(To Prevent Race Condition, an internal queuing system is used)

API Calls:

Returns UserModel GET /user/list 
Returns UserModel POST /user/create 
Returns UserModel PUT /user/edit 
Returns UserModel DELETE /user/delete 

UserModel:
{
	Long userId;
	String name;
	String email;
}

Returns DriverModel GET /driver/list 
Returns DriverModel POST /driver/create 
Returns DriverModel PUT /driver/edit 
Returns DriverModel DELETE /driver/delete 

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

Returns CustomerModel GET /customer/list 
Returns CustomerModel POST /customer/create 
Returns CustomerModel PUT /customer/edit 
Returns CustomerModel DELETE /customer/delete 

CustomerModel: 
{
  String preference;
  customerId;
	String name;
	String email;
	String gender;
	Long userId;
}


Returns CustomerModel GET /cab/list 
Returns CustomerModel POST /cab/create 
Returns CustomerModel PUT /cab/edit 
Returns CustomerModel DELETE /cab/delete 

CustomerModel
{
  Long cabId;
  CabType cabType;
  Long seatsCount;
}

CabType {
	SHARE,
	PRIME
}



Returns BookingModel GET /booking/book/{customerid}/{latitude}/{longitude} 
Returns BookingModel GET /booking/book/generatecost/{id} 
Returns BookingModel GET /booking/book/updatedrop/{id}/{latitude}/{longitude}
Returns BookingModel GET /booking/book/updaterating/{id}/{rating} 
Returns BookingModel GET /booking/book/updatecablocation/{id}/{latitude}/{longitude} 
Returns HashMap<String, Double> GET /book/getcablocation/{id}


