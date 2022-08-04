package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Pc;
import com.example.demo.Services.PcService;

@RestController
public class PcController {
	
@Autowired	
private PcService pcService;
	
@PostMapping("/addPc")
public Pc addPc(@RequestBody Pc pc) {
	return pcService.createPc(pc);
}

@PostMapping("/addPcs")
public List<Pc> addPcs(@RequestBody List<Pc> pcs){
	return pcService.createPcs(pcs);
}

@GetMapping("/pc/{id}")
public Pc getUserById(@PathVariable int id) {
	return pcService.getPcById(id);
}

@GetMapping("/pcs")
public List<Pc> getAllPcs(){
	return pcService.getAllPcs();
}

@PutMapping("/updatepc")
public Pc updatePc(@RequestBody Pc pc) {
	return pcService.updatePc(pc);
}

@DeleteMapping("/pc/{id}")
public String deletePc(@PathVariable int id) {
	return pcService.deletePcById(id);
}




}
