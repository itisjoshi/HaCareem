package com.careem.engine.web.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.careem.engine.core.model.Booking;
import com.careem.engine.core.model.Customer;
import com.careem.engine.core.model.Driver;
import com.careem.engine.core.service.BookingService;
import com.careem.engine.core.service.CustomerService;
import com.careem.engine.core.service.DriverService;
import com.careem.engine.web.model.BookingModel;

@Component
public class BookingWebService {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private CustomerService customerService;
	
	public static final int PER_KILOMETER_RATE_MINI = 7; // Rate Per Kilometer - Mini
	public static final int PER_KILOMETER_RATE_PRIME = 15; // Rate Per Kilometer - Prime
	
	public static final double INVITE_RADIUS = 1.00; // Radius Limits in Kilometers (KM) to invite friends
	public static final double EARTH_RADIUS = 6378.137; // Radius of earth in Kilometers (KM)
	
	public Driver findMinimumWageDriver(List<Driver> drivers) {

		Collections.sort(drivers, new Comparator<Driver>() {
		    @Override
		    public int compare(Driver driver1, Driver driver2) {
		    	double driver1Wage = bookingService.getDriverCurrentDayWage(new Date(), driver1.getId());
		    	double driver2Wage = bookingService.getDriverCurrentDayWage(new Date(), driver2.getId());
		        return (int) driver1Wage - (int) driver2Wage;
		    }});
		return drivers.size() > 0 && drivers.get(0).equals(drivers.get(1)) ? null : drivers.get(0);
	}
	
	public Driver findMaximumWaitedTimeDriver(List<Driver> drivers) {
		
		Map<Long, Long> millisMap = new HashMap<>();
		
		long fiveMinutesToMills = 300000L;
		int numberOfDrivers = 0;
		
		for(int i = 0; i < drivers.size(); i++) {
			
			Date lastDroppedDate = drivers.get(i).getLastDriveFinishedDate();
			long millisecond = new Date().getTime() - lastDroppedDate.getTime();
			millisMap.put(drivers.get(i).getId(), millisecond);
		}
		
		Map<Long, Long> sortedMap = sortByValue(millisMap);
		
		for(Map.Entry<Long, Long> entry: sortedMap.entrySet()) {
			
			if(entry.getValue() <= fiveMinutesToMills) {
				numberOfDrivers++;
			} else {
				break;
			}
		}
		return numberOfDrivers > 1 ? null : drivers.get(Integer.parseInt((sortedMap.keySet().iterator().next()).toString()));
	}
	
	public Map<Long, Long> sortByValue(Map<Long, Long> unsortMap) {

        List<Map.Entry<Long, Long>> list = new LinkedList<Map.Entry<Long, Long>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Long, Long>>() {
            public int compare(Map.Entry<Long, Long> o1, Map.Entry<Long, Long> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<Long, Long> sortedMap = new LinkedHashMap<Long, Long>();
        for (Map.Entry<Long, Long> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
	
	public double minimumDistanceFinder(double clientLatitude, double clientLongitude,
			double driverLatitude, double driverLongitude) {

		double distanceLatitude = (driverLatitude - clientLatitude) * Math.PI / 180;
		double distanceLongitude = (driverLongitude - clientLongitude) * Math.PI / 180;

		double a = Math.pow(Math.sin(distanceLatitude / 2), 2) +
				Math.cos(clientLatitude * Math.PI / 180) * Math.cos(driverLatitude * Math.PI / 180) *
				Math.pow(Math.sin(distanceLongitude / 2), 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return EARTH_RADIUS * c * 1000; //  Return distance in meters
	}

	public Driver findShortestDistanceDriver(List<Driver> drivers, double customerLatitude, double customerLongitude) {
		
		int minimumDistance = Integer.MIN_VALUE;
		Map<Long, Integer> treeMap = new TreeMap<>();
		
		for(int i = 0; i < drivers.size(); i++) {
			
			int currentMinimumDistance = (int) minimumDistanceFinder(customerLatitude,customerLongitude , 
															      drivers.get(i).latitude, drivers.get(i).longitude);
			
			if(minimumDistance < currentMinimumDistance) {
				minimumDistance = currentMinimumDistance ;
			}
			treeMap.put(drivers.get(i).getId(), minimumDistance);
		}
		return treeMap.size() > 0 ? drivers.get(0) : null;
	}
	
	public boolean minimumDistanceDriverFinder(double clientLatitude, double clientLongitude,
			double driverLatitude, double driverLongitude) {

		double distanceLatitude = (driverLatitude - clientLatitude) * Math.PI / 180;
		double distanceLongitude = (driverLongitude - clientLongitude) * Math.PI / 180;

		double a = Math.pow(Math.sin(distanceLatitude / 2), 2) +
				Math.cos(clientLatitude * Math.PI / 180) * Math.cos(driverLatitude * Math.PI / 180) *
				Math.pow(Math.sin(distanceLongitude / 2), 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return EARTH_RADIUS * c <= INVITE_RADIUS;
	}
	
	public List<Driver> getDriverListWithinDistance(double customerLatitude, double customerLongitude) {
		
		List<Driver> drivers = driverService.findAll();
		List<Driver> availableDriversList = new ArrayList<>();
		
		for(int i = 0; i < drivers.size(); i++) {
			
			double driverLatitude = drivers.get(i).latitude, driverLongitude = drivers.get(i).longitude;
			
			boolean driverFound = minimumDistanceDriverFinder(customerLatitude, customerLongitude, driverLatitude, driverLongitude);
			
			if(driverFound) {
				availableDriversList.add(drivers.get(i));
			} 
		}
		return availableDriversList;
	}
	
	public BookingModel getDriver(Long customerid, double latitude, double longitude) {
		
		BookingModel bookingModel = new BookingModel();
		List<Driver> driversWithinDistance = getDriverListWithinDistance(latitude, longitude);
		
		if(!driversWithinDistance.isEmpty()) {
			
			Driver minimumWageDriver = findMinimumWageDriver(driversWithinDistance);
			
			if(minimumWageDriver == null) {
				
				Driver maximumWaitedTimeDriver = findMaximumWaitedTimeDriver(driversWithinDistance);
				
				if(maximumWaitedTimeDriver == null) {
					
					Driver shortestDistanceDriver = findShortestDistanceDriver(driversWithinDistance, latitude, longitude);
					
					if(shortestDistanceDriver == null) {
						return null;
					} else {
						// return shortestDistanceDriver;
						bookingModel = createbooking(shortestDistanceDriver, customerid, latitude, longitude);
					}
					
				} else {
					// return maximumWaitedTimeDriver;
					bookingModel = createbooking(maximumWaitedTimeDriver, customerid, latitude, longitude);
				}
				
			} else {
				// return minimumWageDriver;
				bookingModel = createbooking(minimumWageDriver, customerid, latitude, longitude);				
			}
		}
		return bookingModel;
	}

	private BookingModel createbooking(Driver driver, Long customerid, double latitude, double longitude) {
		// TODO Auto-generated method stub
		BookingModel bookingModel = new BookingModel();
		Booking booking = new Booking();
		Customer customer = customerService.findById(customerid);
		booking.setCustomer(customer);
		booking.setCustomerFromLatitude(latitude);
		booking.setCustomerFromlongitude(longitude);
		booking.setDriver(driver);
		booking = bookingService.save(booking);
		driver = driverService.findById(booking.getDriver().getId());
		driver.setLastDriveFinishedDate(new Date());
		driver.setLatitude(latitude);
		driver.setLongitude(longitude);
		driver.setBookingStatus("NOTAVAILABLE");
		driverService.save(driver);
		return bookingModel;
	}

	public BookingModel generateCost(Long id) {
		BookingModel bookingModel = new BookingModel();
		Booking booking = bookingService.findById(id);
		double totalCost = 0.0;
		if(booking.getCost() != null || booking.getCost() != 0) {
			return bookingModel;
		}
		Long distance = Long.parseLong(booking.getDistanceTravelled());
		String cabType = booking.getDriver().getCab().getCabType().toString();
		
		switch(cabType) {
			case "MINI" : totalCost = distance * PER_KILOMETER_RATE_MINI; break;
			case "PRIME" : totalCost = distance * PER_KILOMETER_RATE_PRIME; break;
		}
		booking.setCost(totalCost);	
		booking.setDistanceTravelled(distance.toString());
		booking = bookingService.save(booking);
		return convertBookingToBookingModel(booking);
	}

	public BookingModel updateDropTime(Long id, double latitude, double longitude) {
		// TODO Auto-generated method stub
		Booking booking = bookingService.findById(id);
		booking.setDriverEndLatitude(latitude);
		booking.setDriverEndLongitude(longitude);
		booking = bookingService.save(booking);
		Driver driver = driverService.findById(booking.getDriver().getId());
		driver.setLastDriveFinishedDate(new Date());
		driver.setLatitude(latitude);
		driver.setLongitude(longitude);
		driver.setBookingStatus("AVAILABLE");
		driverService.save(driver);
		booking.setDriver(driver);
		return convertBookingToBookingModel(booking);
	}

	public BookingModel updateRating(Long id, String rating) {
		// TODO Auto-generated method stub
		Booking booking = bookingService.findById(id);
		booking.setRating(rating);
		booking = bookingService.save(booking);
		Driver driver = driverService.findById(booking.getDriver().getId());
		Long oldRating = Long.parseLong(driver.getRating());
		Long totalDrives = bookingService.findByDriver(driver).size() + 0L;
		Long newRating = ((oldRating * totalDrives) + Long.parseLong(rating))/(totalDrives+1);
		driver.setRating(newRating.toString());
		driver = driverService.save(driver);
		return convertBookingToBookingModel(booking);
	}

	public BookingModel updatecabCurrentLocation(Long id, double latitude, double longitude) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, Double> getcabCurrentLocation(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	private BookingModel convertBookingToBookingModel(Booking booking) {
		// TODO Auto-generated method stub
		BookingModel bookingModel = new BookingModel();
		bookingModel.setBookingStatus(booking.getDriver().getBookingStatus());
		bookingModel.setCabType(booking.getDriver().getCab().getCabType());
		bookingModel.setCost(booking.getCost());
		bookingModel.setCostDenomination(booking.getCostDenomination());
		bookingModel.setCustomerFromLatitude(booking.getCustomerFromLatitude());
		bookingModel.setCustomerFromlongitude(booking.getCustomerFromlongitude());
		bookingModel.setCustomerId(booking.getCustomer().getId());
		bookingModel.setDistanceTravelled(booking.getDistanceTravelled());
		bookingModel.setDriverEndLatitude(booking.getDriverEndLatitude());
		bookingModel.setDriverEndLongitude(booking.getDriverEndLongitude());
		bookingModel.setSeatsCount(booking.getDriver().getCab().getSeatsCount());
		bookingModel.setRating(booking.getRating());
		bookingModel.setDriverId(booking.getDriver().getId());
		return bookingModel;
	}

}