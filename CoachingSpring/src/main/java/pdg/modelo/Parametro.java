package pdg.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "parametro", schema = "public")
public class Parametro implements java.io.Serializable {
    @NotNull
    private Long idParam;
    private Double numero;
    private String texto;
    private byte[] textoBlob;
    private String textoClob;
    public Parametro() {
    }

    public Parametro(Long idParam, Double numero, String texto,
        byte[] textoBlob, String textoClob) {
        this.idParam = idParam;
        this.numero = numero;
        this.texto = texto;
        this.textoBlob = textoBlob;
        this.textoClob = textoClob;
    }

    @Id
    @Column(name = "id_param", unique = true, nullable = false)
    public Long getIdParam() {
        return this.idParam;
    }

    public void setIdParam(Long idParam) {
        this.idParam = idParam;
    }

    @Column(name = "numero")
    public Double getNumero() {
        return this.numero;
    }

    public void setNumero(Double numero) {
        this.numero = numero;
    }

    @Column(name = "texto")
    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Column(name = "texto_blob")
    public byte[] getTextoBlob() {
        return this.textoBlob;
    }

    public void setTextoBlob(byte[] textoBlob) {
        this.textoBlob = textoBlob;
    }

    @Column(name = "texto_clob")
    public String getTextoClob() {
        return this.textoClob;
    }

    public void setTextoClob(String textoClob) {
        this.textoClob = textoClob;
    }
}
