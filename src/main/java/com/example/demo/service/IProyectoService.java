package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proyecto;


public interface IProyectoService {
	
	//Metodos del CRUD
		public List<Proyecto> listarProyectos(); //Listar All 
		
		public Proyecto guardarProyecto(Proyecto Proyecto);	//Guarda un cliente CREATE
		
		public Proyecto ProyectoXID(Long id); //Leer datos de un cliente READ
		
		public Proyecto actualizarProyecto(Proyecto Proyecto); //Actualiza datos del cliente UPDATE
		
		public void eliminarProyecto(Long id);// Elimina el cliente DELETE

}

