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
@Table(name = "reg_contable", schema = "public")
public class RegContable implements java.io.Serializable {
	 @NotNull
	    private Long idHis;
	    @NotNull
	    private Coachee coachee;
	  //  @NotNull
	    private Date fechaPago;
//	    @NotNull
//	    @NotEmpty
//	    @Size(max = 200)
	    private String tipo;
	//    @NotNull
	   // private Double valor;
	    
	    private Double credito;
	    private Double debito;
	    private Double saldo;
	    
	    private Set<ProcCoaching> procCoachings = new HashSet<ProcCoaching>(0);

    public RegContable() {
    }

    public RegContable(Long idHis, Coachee coachee, Date fechaPago,
        Set<ProcCoaching> procCoachings, String tipo,   Double credito,
     Double debito,
     Double saldo) {
        this.idHis = idHis;
        this.coachee = coachee;
        this.fechaPago = fechaPago;
        this.tipo = tipo;
     //   this.valor = valor;
        this.procCoachings = procCoachings;
        this.credito = credito;
        this.debito = debito;
        this.saldo = saldo;
    }

    @Id
    @Column(name = "id_his", unique = true, nullable = false)
    public Long getIdHis() {
        return this.idHis;
    }

    public void setIdHis(Long idHis) {
        this.idHis = idHis;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coachee_id_coachee")
    public Coachee getCoachee() {
        return this.coachee;
    }

    public void setCoachee(Coachee coachee) {
        this.coachee = coachee;
    }

    @Column(name = "fecha_pago", nullable = false)
    public Date getFechaPago() {
        return this.fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Column(name = "tipo", nullable = false)
    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

//    @Column(name = "valor", nullable = false)
//    public Double getValor() {
//        return this.valor;
//    }
//
//    public void setValor(Double valor) {
//        this.valor = valor;
//    }
//    
    //TODO descomentar despues
    @Column(name = "debito", nullable = false)
    public Double getDebito() {
        return this.debito;
    }

    public void setdebito(Double debito) {
        this.debito = debito;
    }
    
  //TODO descomentar despues
   @Column(name = "credito", nullable = false)
    public Double getCredito() {
        return this.credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }
    
  //TODO descomentar despues 
    @Column(name = "saldo", nullable = false)
    public Double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    
    

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "regContable")
    public Set<ProcCoaching> getProcCoachings() {
        return this.procCoachings;
    }

    public void setProcCoachings(Set<ProcCoaching> procCoachings) {
        this.procCoachings = procCoachings;
    }
    
    
    
    
    
    
    
}
