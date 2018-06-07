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
public class TipoDocumentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoDocumentoDTO.class);
    private Long idDoc;
    private String tdocNombre;

    public Long getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Long idDoc) {
        this.idDoc = idDoc;
    }

    public String getTdocNombre() {
        return tdocNombre;
    }

    public void setTdocNombre(String tdocNombre) {
        this.tdocNombre = tdocNombre;
    }
}
