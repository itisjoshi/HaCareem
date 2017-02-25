package com.careem.engine.web.controller;

import java.util.List;

import javax.validation.Valid;

import com.careem.engine.web.model.*;
import com.careem.engine.web.service.CabWebService;
import com.careem.engine.web.service.CabWebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class CabController {

	@Autowired
	private CabWebService cabService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<CabModel> listCab() {
		return cabService.getAllCabs();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody CabModel createCab(@RequestBody CabModel userModel) {
		return cabService.createCab(userModel);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody CabModel editCab(@RequestBody CabModel userModel) {
		return cabService.editCab(userModel);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody CabModel deleteCab(@RequestBody CabModel userModel) {
		return cabService.deleteCab(userModel);
	}

}