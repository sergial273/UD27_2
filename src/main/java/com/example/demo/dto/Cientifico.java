package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="cientificos")
public class Cientifico {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Asignado_a",
        joinColumns = { @JoinColumn(name = "cientifico") },
        inverseJoinColumns = { @JoinColumn(name = "proyecto") }
    )
    
    
    @JsonIgnoreProperties("cientificos")
    private List<Proyecto> estudiantes = new ArrayList<>();
    

    // Constructores
	public Cientifico() {
		
	}

	public Cientifico(Long id, String nombre, List<Proyecto> estudiantes) {
		this.id = id;
		this.nombre = nombre;
		this.estudiantes = estudiantes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Proyecto> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Proyecto> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public String toString() {
		return "Cientifico [id=" + id + ", nombre=" + nombre + ", estudiantes=" + estudiantes + "]";
	}


}