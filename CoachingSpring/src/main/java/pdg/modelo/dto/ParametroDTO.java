package pdg.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class ParametroDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ParametroDTO.class);
    private Long idParam;
    private Double numero;
    private String texto;
    private byte[] textoBlob;
    private String textoClob;

    public Long getIdParam() {
        return idParam;
    }

    public void setIdParam(Long idParam) {
        this.idParam = idParam;
    }

    public Double getNumero() {
        return numero;
    }

    public void setNumero(Double numero) {
        this.numero = numero;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public byte[] getTextoBlob() {
        return textoBlob;
    }

    public void setTextoBlob(byte[] textoBlob) {
        this.textoBlob = textoBlob;
    }

    public String getTextoClob() {
        return textoClob;
    }

    public void setTextoClob(String textoClob) {
        this.textoClob = textoClob;
    }
}
