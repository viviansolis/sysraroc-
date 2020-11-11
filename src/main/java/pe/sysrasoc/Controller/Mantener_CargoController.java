package pe.sysrasoc.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.sysrasoc.Entity.Mantener_Cargo;
import pe.sysrasoc.Service.Mantener_CargoService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/cargo")
public class Mantener_CargoController {
@Autowired
private Mantener_CargoService cargoService;
@GetMapping("/all")
public Map<String, Object> readAll(){
	return cargoService.readAll();
}
@GetMapping("/{id}")
public Map<String, Object> read(@PathVariable int id ) {
	try {
		 return cargoService.read(id);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("error");
		return null;
	}
}
@DeleteMapping("/delete/{id}")
public int delete(@PathVariable int id ) {
	return cargoService.delete(id);
}
//PostMapping permite registrar un nuevo rol
@PostMapping("/add")
public int create(@RequestBody Mantener_Cargo c) {
	System.out.println("Crear: "+ c.getNombre_cargo());
	return cargoService.create(c);
}
//PutMappin permite modificar rol
@PutMapping("/update/{id}")
public int edit(@RequestBody Mantener_Cargo c, @PathVariable int id) {
	//Map<String, Object> map = rolService.read(id);
	System.out.println(c.getNombre_cargo());
	c.setId_cargo(id);
	return cargoService.update(c);
}
}
