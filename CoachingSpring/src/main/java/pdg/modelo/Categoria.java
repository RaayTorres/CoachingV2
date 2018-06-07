package pdg.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
* ALTER TABLE categoria ALTER COLUMN id_cat SET DEFAULT nextval('seq_prueba')
*
*/
@Entity
@Table(name = "categoria", schema = "public")
public class Categoria implements java.io.Serializable {
  
	  @NotNull
	    private Long idCat;
	    @NotNull
	    @NotEmpty
	    @Size(max = 60)
	    private String catNombre;
	    @NotNull
	    private Double horaPagada;
	    @NotNull
	    private Double horaProbono;
	    @NotNull
	    @NotEmpty
	    @Size(max = 10)
	    private String nombreCorto;
	    private Set<Coach> coaches = new HashSet<Coach>(0);


    public Categoria() {
    }

    public Categoria(Long idCat, String catNombre, Set<Coach> coaches,
        Double horaPagada, Double horaProbono, String nombreCorto) {
        this.idCat = idCat;
        this.catNombre = catNombre;
        this.horaPagada = horaPagada;
        this.horaProbono = horaProbono;
        this.nombreCorto = nombreCorto;
        this.coaches = coaches;
    }

    @Id
    @Column(name = "id_cat", unique = true, nullable = false)
    public Long getIdCat() {
        return this.idCat;
    }

    public void setIdCat(Long idCat) {
        this.idCat = idCat;
    }

    @Column(name = "cat_nombre", nullable = false)
    public String getCatNombre() {
        return this.catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    @Column(name = "hora_pagada", nullable = false)
    public Double getHoraPagada() {
        return this.horaPagada;
    }

    public void setHoraPagada(Double horaPagada) {
        this.horaPagada = horaPagada;
    }

    @Column(name = "hora_probono", nullable = false)
    public Double getHoraProbono() {
        return this.horaProbono;
    }

    public void setHoraProbono(Double horaProbono) {
        this.horaProbono = horaProbono;
    }

    @Column(name = "nombre_corto", nullable = false)
    public String getNombreCorto() {
        return this.nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
    public Set<Coach> getCoaches() {
        return this.coaches;
    }

    public void setCoaches(Set<Coach> coaches) {
        this.coaches = coaches;
    }
}
