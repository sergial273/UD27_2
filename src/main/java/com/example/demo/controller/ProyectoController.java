package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Proyecto;
import com.example.demo.service.ProyectoServiceImpl;


@RestController
@RequestMapping("/api")
public class ProyectoController {
	
	@Autowired
	ProyectoServiceImpl ProyectoServideImpl;
	
	@GetMapping("/Proyectos")
	public List<Proyecto> listarProyectos(){
		return ProyectoServideImpl.listarProyectos();
	}
	
	@PostMapping("/Proyectos")
	public Proyecto salvarProyecto(@RequestBody Proyecto Proyecto) {
		
		return ProyectoServideImpl.guardarProyecto(Proyecto);
	}
	
	@GetMapping("/Proyectos/{id}")
	public Proyecto ProyectoXID(@PathVariable(name="id") Long id) {
		
		Proyecto Proyecto_xid= new Proyecto();
		
		Proyecto_xid=ProyectoServideImpl.ProyectoXID(id);
		
		System.out.println("Cliente XID: " + Proyecto_xid);
		
		return Proyecto_xid;
	}
	
	@PutMapping("/Proyectos/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name="id")Long id,@RequestBody Proyecto Proyecto) {
		
		Proyecto Proyecto_seleccionado= new Proyecto();
		Proyecto Proyecto_actualizado= new Proyecto();
		
		Proyecto_seleccionado= ProyectoServideImpl.ProyectoXID(id);
		
		Proyecto_seleccionado.setNombre(Proyecto.getNombre());
		Proyecto_seleccionado.setHoras(Proyecto.getHoras());
		
		Proyecto_actualizado = ProyectoServideImpl.actualizarProyecto(Proyecto_seleccionado);
		
		System.out.println("El Proyecto actualizado es: "+ Proyecto_actualizado);
		
		return Proyecto_actualizado;
	}
	
	@DeleteMapping("/Proyectos/{id}")
	public void eleiminarProyecto(@PathVariable(name="id")Long id) {
		ProyectoServideImpl.eliminarProyecto(id);
	}
	
	
}