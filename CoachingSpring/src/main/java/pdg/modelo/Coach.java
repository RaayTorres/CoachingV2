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
*
*/
@Entity
@Table(name = "coach", schema = "public")
public class Coach implements java.io.Serializable {
	@NotNull
	private Long idCoach;
	//@NotNull
	private Categoria categoria;	
	@NotNull
	private TipoDocumento tipoDocumento;	
	@NotNull
	@NotEmpty
	@Size(max=60)
	private String apellido;	
	private String celular;	
	@NotNull
	@NotEmpty
	@Size(max=80)
	private String correo;	
	@NotNull
	private Double horaPagada;	
	@NotNull
	private Double horaProbono;	
	@NotNull
	@NotEmpty
	@Size(max=60)
	private String identificacion;	
	@NotNull
	@NotEmpty
	@Size(max=60)
	private String contrasena;	
	@NotNull
	@NotEmpty
	@Size(max=60)
	private String login;	
	@NotNull
	@NotEmpty
	@Size(max=60)
	private String nombre;	
	private String telefono;	
	
	  private byte[] foto;
	
	private Set<ProcCoaching> procCoachings = new HashSet<ProcCoaching>(0);	
    public Coach() {
    }

    public Coach(Long idCoach, String apellido, Categoria categoria,
    		String celular, String contrasena, String correo, 
        Double horaPagada, Double horaProbono, String identificacion,
        String login, String nombre, Set<ProcCoaching> procCoachings,
        String telefono, TipoDocumento tipoDocumento, byte[] foto) {
        this.idCoach = idCoach;
        this.categoria = categoria;
      
        this.tipoDocumento = tipoDocumento;
        this.apellido = apellido;
        this.celular = celular;
        this.contrasena = contrasena;
        this.correo = correo;
        this.horaPagada = horaPagada;
        this.horaProbono = horaProbono;
        this.identificacion = identificacion;
        this.login = login;
        this.nombre = nombre;
        this.telefono = telefono;
        this.procCoachings = procCoachings;
        this.foto = foto;
    }

    @Id
    @Column(name = "id_coach", unique = true, nullable = false)
    public Long getIdCoach() {
        return this.idCoach;
    }

    public void setIdCoach(Long idCoach) {
        this.idCoach = idCoach;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id_cat")
    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_documento_id_doc")
    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Column(name = "apellido", nullable = false)
    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Column(name = "celular")
    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Column(name = "contrasena", nullable = false)
    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Column(name = "correo", nullable = false)
    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    
    //TODO descomentar despues 
    @Column(name = "foto")
    public byte[] getFoto() {
        return this.foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    @Column(name = "identificacion", nullable = false)
    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Column(name = "login", nullable = false)
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "telefono")
    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "coach")
    public Set<ProcCoaching> getProcCoachings() {
        return this.procCoachings;
    }

    public void setProcCoachings(Set<ProcCoaching> procCoachings) {
        this.procCoachings = procCoachings;
    }
}
