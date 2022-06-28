package com.space.lotus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.space.lotus.repository.TransporterRepository;
import com.space.lotus.model.Transporter;

@Service
public class TransporterService {

	@Autowired
	private TransporterRepository transporterRepository;
	
	public List<Transporter> getAllTransporters() {
		List<Transporter> transporters = new ArrayList<>();
		transporterRepository.findAll()
		.forEach(transporters::add);
		return transporters;
	}
	
	public Transporter getTransporter(Long id) {
		return transporterRepository.findById(id).orElse(null);
	}
	
	public void addTransporter(Transporter transporter) {
		transporterRepository.save(transporter);
	}
	
	public void updateTransporter(Transporter transporter, Long id) {
		Transporter _transporter  = transporterRepository.findById(id).orElse(null);
		if(_transporter == null) {
			transporterRepository.save(transporter);
		}
		else {
			_transporter.setName(transporter.getName());
			_transporter.setGstin(transporter.getGstin());
			_transporter.setShowOnInvoice(transporter.getShowOnInvoice());
			transporterRepository.save(_transporter);
		}
	}
	
	public void deleteTransporter(Long id) {
		transporterRepository.deleteById(id);
	}
	
}

