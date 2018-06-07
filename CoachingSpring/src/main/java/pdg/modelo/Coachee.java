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
@Table(name = "coachee", schema = "public")
public class Coachee implements java.io.Serializable {
	 @NotNull
	    private Long idCoachee;
	   
	    private Estado estado;
	    @NotNull
	    private TipoDocumento tipoDocumento;
	    @NotNull
	    @NotEmpty
	    @Size(max = 60)
	    private String apellido;
	    private String celular;
	    @NotNull
	    @NotEmpty
	    @Size(max = 80)
	    private String correo;
	    @NotNull
	    @NotEmpty
	    @Size(max = 80)
	    private String direccion;
	    private byte[] foto;
	    private String hobbies;
	    @NotNull
	    @NotEmpty
	    @Size(max = 60)
	    private String identificacion;
	    @NotNull
	    @NotEmpty
	    @Size(max = 60)
	    private String nombre;
	    private String telefono;
	    
	    //TODO Descomentar despues
//		@NotNull
//		@NotEmpty
		@Size(max=60)
		private String contrasena;	
		@NotNull
		@NotEmpty
	@Size(max=60)
		private String login;
	    
	    
	    private Set<ProcCoaching> procCoachings = new HashSet<ProcCoaching>(0);
	    private Set<RegContable> regContables = new HashSet<RegContable>(0);

    public Coachee() {
    }

    public Coachee(Long idCoachee, String apellido, String celular,
        String correo, String direccion, Estado estado, byte[] foto,
        String hobbies, String identificacion, String nombre,
        Set<ProcCoaching> procCoachings, Set<RegContable> regContables,
        String telefono, TipoDocumento tipoDocumento,String login, String contrasena) {
        this.idCoachee = idCoachee;
        this.estado = estado;
        this.tipoDocumento = tipoDocumento;
        this.apellido = apellido;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
        this.foto = foto;
        this.hobbies = hobbies;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.procCoachings = procCoachings;
        this.regContables = regContables;
        this.login = login;
        this.contrasena = contrasena;
    }

    @Id
    @Column(name = "id_coachee", unique = true, nullable = false)
    public Long getIdCoachee() {
        return this.idCoachee;
    }

    public void setIdCoachee(Long idCoachee) {
        this.idCoachee = idCoachee;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_id_estado")
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @ManyToOne(fetch = FetchType.EAGER)
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

   //TODO descometnar despues 
    @Column(name = "contrasena", nullable = false)
    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    //TODO descomentar despues
    @Column(name = "login", nullable = false)
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    @Column(name = "celular")
    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Column(name = "correo", nullable = false)
    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Column(name = "direccion", nullable = false)
    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "foto")
    public byte[] getFoto() {
        return this.foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Column(name = "hobbies")
    public String getHobbies() {
        return this.hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    @Column(name = "identificacion", nullable = false)
    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "coachee")
    public Set<ProcCoaching> getProcCoachings() {
        return this.procCoachings;
    }

    public void setProcCoachings(Set<ProcCoaching> procCoachings) {
        this.procCoachings = procCoachings;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "coachee")
    public Set<RegContable> getRegContables() {
        return this.regContables;
    }

    public void setRegContables(Set<RegContable> regContables) {
        this.regContables = regContables;
    }
}
