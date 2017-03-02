package com.careem.engine.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.careem.engine.core.model.Cab;
import com.careem.engine.core.model.Driver;
import com.careem.engine.core.model.User;
import com.careem.engine.core.service.CabService;
import com.careem.engine.core.service.DriverService;
import com.careem.engine.core.service.UserService;
import com.careem.engine.web.model.DriverModel;

@Component
public class DriverWebService {

	@Autowired
	private DriverService driverService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CabService cabService;
	
	public List<DriverModel> getAllDrivers() {
		List<DriverModel> driverModels = new ArrayList<DriverModel>();
		List<Driver> drivers = driverService.findAll();
		Iterator<Driver> driverIterator = drivers.iterator();
		while(driverIterator.hasNext()) {
			Driver driver = driverIterator.next();
			DriverModel driverModel = new DriverModel();
			driverModel.setDriverId(driver.getId());
			driverModel.setEmail(driver.getUser().getEmail());
			driverModel.setGender(driver.getUser().getGender());
			driverModel.setName(driver.getUser().getName());
			driverModel.setUserId(driver.getUser().getId());
			driverModel.setBookingStatus(driver.getBookingStatus());
			driverModel.setCabid(driver.getCab().getId());
			driverModel.setCabType(driver.getCab().getCabType());
			driverModel.setLastDriveFinishedDate(driver.getLastDriveFinishedDate());
			driverModel.setLatitude(driver.getLatitude());
			driverModel.setLongitude(driver.getLongitude());
			driverModel.setRating(driver.getRating());
			driverModels.add(driverModel);
		}
		return driverModels;
	}

	public DriverModel createDriver(DriverModel driverModel) {
		User user = new User();
		user.setEmail(driverModel.getEmail());
		user.setGender(driverModel.getGender());
		user.setName(driverModel.getName());
		user = userService.save(user);
		Driver driver = new Driver();
		driver.setUser(user);
		driver.setBookingStatus("AVAILABLE");
		Cab cab = new Cab();
		cab.setCabType(driverModel.getCabType());
		cab.setSeatsCount(driverModel.getSeatsCount());
		cab = cabService.save(cab);
		driver.setCab(cab);
		driver.setRating(driverModel.getRating());
		driver.setLatitude(driverModel.getLatitude());
		driver.setLongitude(driverModel.getLongitude());
		driver = driverService.save(driver);
		driverModel.setDriverId(driver.getId());
		driverModel.setUserId(user.getId());
		return driverModel;
	}

	public DriverModel editDriver(DriverModel driverModel) {
		User user = userService.findById(driverModel.getUserId());
		user.setEmail(driverModel.getEmail());
		user.setGender(driverModel.getGender());
		user.setName(driverModel.getName());
		user = userService.save(user);
		Driver driver = driverService.findById(driverModel.getDriverId());
		driver.setUser(user);
		driver.setBookingStatus("AVAILABLE");
		Cab cab = cabService.findById(driverModel.getCabid());
		driver.setCab(cab);
		driver.setLastDriveFinishedDate(new Date());
		driver.setRating(driverModel.getRating());
		driver.setLatitude(driverModel.getLatitude());
		driver.setLongitude(driverModel.getLongitude());
		driver = driverService.save(driver);
		driverModel.setDriverId(driver.getId());
		driverModel.setUserId(user.getId());
		return driverModel;
	}

	public DriverModel deleteDriver(DriverModel driverModel) {
		return null;
	}
}