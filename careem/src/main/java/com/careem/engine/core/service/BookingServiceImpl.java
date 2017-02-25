package com.careem.engine.core.service;

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
		// TODO Auto-generated method stub
		return bookingRepository.save(booking);
	}

	@Override
	public void delete(Booking booking) {
		// TODO Auto-generated method stub
		bookingRepository.save(booking);
	}

	@Override
	public List<Booking> findAll() {
		// TODO Auto-generated method stub
		return (List<Booking>) bookingRepository.findAll();
	}

	@Override
	public Booking findById(Long id) {
		// TODO Auto-generated method stub
		return bookingRepository.findById(id);
	}

}
