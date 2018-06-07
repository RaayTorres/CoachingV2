package pdg.dto.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import pdg.modelo.*;
import pdg.modelo.Parametro;
import pdg.modelo.dto.ParametroDTO;
import pdg.modelo.logic.*;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class ParametroMapper implements IParametroMapper {
    private static final Logger log = LoggerFactory.getLogger(ParametroMapper.class);

    @Transactional(readOnly = true)
    public ParametroDTO parametroToParametroDTO(Parametro parametro)
        throws Exception {
        try {
            ParametroDTO parametroDTO = new ParametroDTO();

            parametroDTO.setIdParam(parametro.getIdParam());
            parametroDTO.setNumero((parametro.getNumero() != null)
                ? parametro.getNumero() : null);
            parametroDTO.setTexto((parametro.getTexto() != null)
                ? parametro.getTexto() : null);
            parametroDTO.setTextoBlob((parametro.getTextoBlob() != null)
                ? parametro.getTextoBlob() : null);
            parametroDTO.setTextoClob((parametro.getTextoClob() != null)
                ? parametro.getTextoClob() : null);

            return parametroDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Parametro parametroDTOToParametro(ParametroDTO parametroDTO)
        throws Exception {
        try {
            Parametro parametro = new Parametro();

            parametro.setIdParam(parametroDTO.getIdParam());
            parametro.setNumero((parametroDTO.getNumero() != null)
                ? parametroDTO.getNumero() : null);
            parametro.setTexto((parametroDTO.getTexto() != null)
                ? parametroDTO.getTexto() : null);
            parametro.setTextoBlob((parametroDTO.getTextoBlob() != null)
                ? parametroDTO.getTextoBlob() : null);
            parametro.setTextoClob((parametroDTO.getTextoClob() != null)
                ? parametroDTO.getTextoClob() : null);

            return parametro;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ParametroDTO> listParametroToListParametroDTO(
        List<Parametro> listParametro) throws Exception {
        try {
            List<ParametroDTO> parametroDTOs = new ArrayList<ParametroDTO>();

            for (Parametro parametro : listParametro) {
                ParametroDTO parametroDTO = parametroToParametroDTO(parametro);

                parametroDTOs.add(parametroDTO);
            }

            return parametroDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Parametro> listParametroDTOToListParametro(
        List<ParametroDTO> listParametroDTO) throws Exception {
        try {
            List<Parametro> listParametro = new ArrayList<Parametro>();

            for (ParametroDTO parametroDTO : listParametroDTO) {
                Parametro parametro = parametroDTOToParametro(parametroDTO);

                listParametro.add(parametro);
            }

            return listParametro;
        } catch (Exception e) {
            throw e;
        }
    }
}
