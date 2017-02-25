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
		// TODO Auto-generated method stub
		List<Cab> cabs = cabService.findAll();
		List<CabModel> cabModels = new ArrayList<CabModel>();
		Iterator<Cab> cabIterator = cabs.iterator();
		while(cabIterator.hasNext()) {
			Cab cab = cabIterator.next();
			CabModel cabModel = new CabModel();
			cabModel.setCabType(cab.getCabType());
			cabModel.setSeatsCount(cab.getSeatsCount());
			cabModels.add(cabModel);
		}
		return cabModels;
	}

	public CabModel createCab(CabModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}

	public CabModel editCab(CabModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}

	public CabModel deleteCab(CabModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
