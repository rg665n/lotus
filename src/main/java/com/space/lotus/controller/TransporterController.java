package com.space.lotus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.space.lotus.model.Transporter;
import com.space.lotus.service.TransporterService;

@RestController
public class TransporterController {
	
	@Autowired
	private TransporterService transporterService;
	
	@RequestMapping(method=RequestMethod.GET, value="/api/v1/transporters")
	public List<Transporter> getAllTransporters(){
		return transporterService.getAllTransporters();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/api/v1/transporters/{id}")
	public Transporter getTransporter(@PathVariable("id") Long id ) {
		return transporterService.getTransporter(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/api/v1/transporters")
	public void addTransporter(@RequestBody Transporter transporter) {
		transporterService.addTransporter(transporter);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/api/v1/transporters/{id}")
	public void updateTransporter(@RequestBody Transporter transporter ,@PathVariable Long id) {
		transporterService.updateTransporter(transporter,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/api/v1/transporters/{id}")
	public void deleteTransporter(@PathVariable Long id) {
		transporterService.deleteTransporter(id);
	}
}
