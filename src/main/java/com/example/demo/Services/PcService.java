package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Pc;
import com.example.demo.Repos.PcRepository;

@Service
public class PcService {

@Autowired
private PcRepository pcrepository;


public Pc createPc(Pc pc) {
	return pcrepository.save(pc);
}

public List<Pc> createPcs(List<Pc> pc){
	return pcrepository.saveAll(pc);
}

public Pc getPcById(int id) {
	return pcrepository.findById(id).orElse(null);	
}

public List<Pc> getAllPcs() {
	return pcrepository.findAll();
}

public Pc updatePc(Pc pc) {
	Pc oldPc;
	Optional<Pc> changePc=pcrepository.findById(pc.getId());
	if(changePc.isPresent()) {
		oldPc=changePc.get();
		oldPc.setMarca(pc.getMarca());
		oldPc.setOwners(pc.getOwners());
		return oldPc;
	}
	else {
		return new Pc(pc.getId(),pc.getMarca(),pc.getOwners());

	}
}

public String deletePcById(int id) {
		 pcrepository.deleteById(id);
		 return "Deleted User with id="+id;
	}

	
}










