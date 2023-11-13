package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICientificoDAO;
import com.example.demo.dto.Cientifico;

@Service
public class CientificoServiceImpl implements ICientificoService{
	
	//Utilizamos los metodos de la interface IClienteDAO, es como si instaciaramos.
	@Autowired
	ICientificoDAO iCientificoDAO;
	
	@Override
	public List<Cientifico> listarCientificos() {
		
		return iCientificoDAO.findAll();
	}

	@Override
	public Cientifico guardarCientifico(Cientifico Cientifico) {
		
		return iCientificoDAO.save(Cientifico);
	}

	@Override
	public Cientifico CientificoXID(Long id) {
		
		return iCientificoDAO.findById(id).get();
	}

	@Override
	public Cientifico actualizarCientifico(Cientifico Cientifico) {
		
		return iCientificoDAO.save(Cientifico);
	}

	@Override
	public void eliminarCientifico(Long id) {
		
		iCientificoDAO.deleteById(id);
		
	}

}
