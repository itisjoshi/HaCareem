package com.careem.engine.web.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.careem.engine.core.model.Cab;
import com.careem.engine.core.service.CabService;
import com.careem.engine.web.model.CabModel;

@Component
public class CabWebService {

	@Autowired
	private CabService cabService;
	
	public List<CabModel> getAllCabs() {
		List<Cab> cabs = cabService.findAll();
		List<CabModel> cabModels = new ArrayList<CabModel>();
		Iterator<Cab> cabIterator = cabs.iterator();
		while(cabIterator.hasNext()) {
			Cab cab = cabIterator.next();
			CabModel cabModel = new CabModel();
			cabModel.setCabType(cab.getCabType());
			cabModel.setSeatsCount(cab.getSeatsCount());
			cabModel.setCabId(cab.getId());
			cabModels.add(cabModel);
		}
		return cabModels;
	}

	public CabModel createCab(CabModel cabModel) {
		Cab cab = new Cab();
		cab.setSeatsCount(cabModel.getSeatsCount());
		cab.setCabType(cabModel.getCabType());
		cab = cabService.save(cab);		
		cabModel = new CabModel();
		cabModel.setCabId(cab.getId());
		cabModel.setCabType(cab.getCabType());
		cabModel.setSeatsCount(cab.getSeatsCount());
		return cabModel;
	}

	public CabModel editCab(CabModel cabModel) {
		Cab cab = cabService.findById(cabModel.getCabId());
		cab.setSeatsCount(cab.getSeatsCount());
		cab.setCabType(cab.getCabType());
		cab = cabService.save(cab);		
		cabModel = new CabModel();
		cabModel.setCabId(cab.getId());
		cabModel.setCabType(cab.getCabType());
		cabModel.setSeatsCount(cab.getSeatsCount());
		return cabModel;
	}

	public CabModel deleteCab(CabModel cabModel) {
		Cab cab = cabService.findById(cabModel.getCabId());
		cabService.delete(cab);		
		return null;
	}
}