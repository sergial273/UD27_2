package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cientifico;


public interface ICientificoService {
	
	//Metodos del CRUD
		public List<Cientifico> listarCientificos(); //Listar All 
		
		public Cientifico guardarCientifico(Cientifico Cientifico);	//Guarda un cliente CREATE
		
		public Cientifico CientificoXID(Long id); //Leer datos de un cliente READ
		
		public Cientifico actualizarCientifico(Cientifico Cientifico); //Actualiza datos del cliente UPDATE
		
		public void eliminarCientifico(Long id);// Elimina el cliente DELETE

}

