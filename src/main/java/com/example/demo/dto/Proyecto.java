package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="proyectos")
public class Proyecto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int horas;

    @ManyToMany(mappedBy = "estudiantes")
    @JsonIgnoreProperties("estudiantes")
    private List<Cientifico> cientificos;

    // Constructores
	public Proyecto() {
		
	}

	public Proyecto(Long id, String nombre, int horas, List<Cientifico> cientificos) {
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.cientificos = cientificos;
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

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public List<Cientifico> getCientificos() {
		return cientificos;
	}

	public void setCientificos(List<Cientifico> cientificos) {
		this.cientificos = cientificos;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", horas=" + horas + ", cientificos=" + cientificos + "]";
	}



}

