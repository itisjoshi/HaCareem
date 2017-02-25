package com.careem.engine.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.careem.engine.core.model.Booking;
import com.careem.engine.core.repository.BookingRepository;

@Service("BookingService")
@Repository
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public void delete(Booking booking) {
		bookingRepository.save(booking);
	}

	@Override
	public List<Booking> findAll() {
		return (List<Booking>) bookingRepository.findAll();
	}

	@Override
	public Booking findById(Long id) {
		return bookingRepository.findById(id);
	}

	@Override
	public double getDriverCurrentDayWage(Date date, Long driverId) {
		return bookingRepository.getDriverCurrentDayWage(date, driverId);
	}
}