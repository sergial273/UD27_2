package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProyectoDAO;
import com.example.demo.dto.Proyecto;

@Service
public class ProyectoServiceImpl implements IProyectoService{
	
	//Utilizamos los metodos de la interface IClienteDAO, es como si instaciaramos.
	@Autowired
	IProyectoDAO iProyectoDAO;
	
	@Override
	public List<Proyecto> listarProyectos() {
		
		return iProyectoDAO.findAll();
	}

	@Override
	public Proyecto guardarProyecto(Proyecto Proyecto) {
		
		return iProyectoDAO.save(Proyecto);
	}

	@Override
	public Proyecto ProyectoXID(Long id) {
		
		return iProyectoDAO.findById(id).get();
	}

	@Override
	public Proyecto actualizarProyecto(Proyecto Proyecto) {
		
		return iProyectoDAO.save(Proyecto);
	}

	@Override
	public void eliminarProyecto(Long id) {
		
		iProyectoDAO.deleteById(id);
		
	}

}