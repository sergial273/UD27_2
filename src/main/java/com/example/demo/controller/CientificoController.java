package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Proyecto;
import com.example.demo.dto.Cientifico;
import com.example.demo.service.ProyectoServiceImpl;
import com.example.demo.service.CientificoServiceImpl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@RestController
@RequestMapping("/api")
public class CientificoController {
	
	@Autowired
	CientificoServiceImpl CientificoServideImpl;
	
	@Autowired
	ProyectoServiceImpl ProyectoServiceImpl;
	
	@Autowired
    private EntityManager entityManager;
	
	@GetMapping("/Cientificos")
	public List<Cientifico> listarCientificos(){
		return CientificoServideImpl.listarCientificos();
	}
	
	@PostMapping("/Cientificos")
	public Cientifico salvarCientifico(@RequestBody Cientifico Cientifico) {
		
		return CientificoServideImpl.guardarCientifico(Cientifico);
	}
	
	@GetMapping("/Cientificos/{id}")
	public Cientifico CientificoXID(@PathVariable(name="id") Long id) {
		
		Cientifico Cientifico_xid= new Cientifico();
		
		Cientifico_xid=CientificoServideImpl.CientificoXID(id);
		
		System.out.println("Cliente XID: " + Cientifico_xid);
		
		return Cientifico_xid;
	}
	
	@PutMapping("/Cientificos/{id}")
	public Cientifico actualizarCientifico(@PathVariable(name="id")Long id,@RequestBody Cientifico Cientifico) {
		
		Cientifico Cientifico_seleccionado= new Cientifico();
		Cientifico Cientifico_actualizado= new Cientifico();
		
		Cientifico_seleccionado= CientificoServideImpl.CientificoXID(id);
		
		Cientifico_seleccionado.setNombre(Cientifico.getNombre());
		
		Cientifico_actualizado = CientificoServideImpl.actualizarCientifico(Cientifico_seleccionado);
		
		System.out.println("El Cientifico actualizado es: "+ Cientifico_actualizado);
		
		return Cientifico_actualizado;
	}
	
	@DeleteMapping("/Cientificos/{id}")
	public void eleiminarCientifico(@PathVariable(name="id")Long id) {
		CientificoServideImpl.eliminarCientifico(id);
	}
	
	@PostMapping("/Cientifico-Proyecto/{id}")
	@Transactional
	public ResponseEntity<String> salvarCientificoProyecto(@RequestBody Cientifico Cientifico, @PathVariable(name="id")Long id) {
	    // Guarda el Cientifico
	    Cientifico CientificoGuardado = CientificoServideImpl.guardarCientifico(Cientifico);

	    // Obtiene el Proyecto por su ID
	    Proyecto Proyecto = ProyectoServiceImpl.ProyectoXID(id);

	    // Asocia el Cientifico con el Proyecto
	    if (Proyecto != null) {
	        CientificoGuardado.getEstudiantes().add(Proyecto);
	        Proyecto.getCientificos().add(CientificoGuardado);
	        entityManager.persist(CientificoGuardado);
	        entityManager.persist(Proyecto);
	    }

	    return ResponseEntity.ok("Cientifico asociado con éxito al Proyecto");
	    
	}
	
}
