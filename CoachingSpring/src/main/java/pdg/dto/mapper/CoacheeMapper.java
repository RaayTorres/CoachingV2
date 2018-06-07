package pdg.dto.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import pdg.modelo.*;
import pdg.modelo.Coachee;
import pdg.modelo.dto.CoacheeDTO;
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
public class CoacheeMapper implements ICoacheeMapper {
    private static final Logger log = LoggerFactory.getLogger(CoacheeMapper.class);

    /**
    * Logic injected by Spring that manages Estado entities
    *
    */
    @Autowired
    IEstadoLogic logicEstado1;

    /**
    * Logic injected by Spring that manages TipoDocumento entities
    *
    */
    @Autowired
    ITipoDocumentoLogic logicTipoDocumento2;

    @Transactional(readOnly = true)
    public CoacheeDTO coacheeToCoacheeDTO(Coachee coachee)
        throws Exception {
        try {
            CoacheeDTO coacheeDTO = new CoacheeDTO();

            coacheeDTO.setIdCoachee(coachee.getIdCoachee());
            coacheeDTO.setApellido((coachee.getApellido() != null)
                ? coachee.getApellido() : null);
            coacheeDTO.setCelular((coachee.getCelular() != null)
                ? coachee.getCelular() : null);
            coacheeDTO.setCorreo((coachee.getCorreo() != null)
                ? coachee.getCorreo() : null);
            coacheeDTO.setDireccion((coachee.getDireccion() != null)
                ? coachee.getDireccion() : null);
            coacheeDTO.setFoto((coachee.getFoto() != null) ? coachee.getFoto()
                                                           : null);
            coacheeDTO.setHobbies((coachee.getHobbies() != null)
                ? coachee.getHobbies() : null);
            coacheeDTO.setIdentificacion((coachee.getIdentificacion() != null)
                ? coachee.getIdentificacion() : null);
            coacheeDTO.setNombre((coachee.getNombre() != null)
                ? coachee.getNombre() : null);
            coacheeDTO.setTelefono((coachee.getTelefono() != null)
                ? coachee.getTelefono() : null);
            coacheeDTO.setIdEstado_Estado((coachee.getEstado().getIdEstado() != null)
                ? coachee.getEstado().getIdEstado() : null);
            coacheeDTO.setIdDoc_TipoDocumento((coachee.getTipoDocumento()
                                                      .getIdDoc() != null)
                ? coachee.getTipoDocumento().getIdDoc() : null);

            return coacheeDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Coachee coacheeDTOToCoachee(CoacheeDTO coacheeDTO)
        throws Exception {
        try {
            Coachee coachee = new Coachee();

            coachee.setIdCoachee(coacheeDTO.getIdCoachee());
            coachee.setApellido((coacheeDTO.getApellido() != null)
                ? coacheeDTO.getApellido() : null);
            coachee.setCelular((coacheeDTO.getCelular() != null)
                ? coacheeDTO.getCelular() : null);
            coachee.setCorreo((coacheeDTO.getCorreo() != null)
                ? coacheeDTO.getCorreo() : null);
            coachee.setDireccion((coacheeDTO.getDireccion() != null)
                ? coacheeDTO.getDireccion() : null);
            coachee.setFoto((coacheeDTO.getFoto() != null)
                ? coacheeDTO.getFoto() : null);
            coachee.setHobbies((coacheeDTO.getHobbies() != null)
                ? coacheeDTO.getHobbies() : null);
            coachee.setIdentificacion((coacheeDTO.getIdentificacion() != null)
                ? coacheeDTO.getIdentificacion() : null);
            coachee.setNombre((coacheeDTO.getNombre() != null)
                ? coacheeDTO.getNombre() : null);
            coachee.setTelefono((coacheeDTO.getTelefono() != null)
                ? coacheeDTO.getTelefono() : null);

            Estado estado = new Estado();

            if (coacheeDTO.getIdEstado_Estado() != null) {
                estado = logicEstado1.getEstado(coacheeDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                coachee.setEstado(estado);
            }

            TipoDocumento tipoDocumento = new TipoDocumento();

            if (coacheeDTO.getIdDoc_TipoDocumento() != null) {
                tipoDocumento = logicTipoDocumento2.getTipoDocumento(coacheeDTO.getIdDoc_TipoDocumento());
            }

            if (tipoDocumento != null) {
                coachee.setTipoDocumento(tipoDocumento);
            }

            return coachee;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CoacheeDTO> listCoacheeToListCoacheeDTO(
        List<Coachee> listCoachee) throws Exception {
        try {
            List<CoacheeDTO> coacheeDTOs = new ArrayList<CoacheeDTO>();

            for (Coachee coachee : listCoachee) {
                CoacheeDTO coacheeDTO = coacheeToCoacheeDTO(coachee);

                coacheeDTOs.add(coacheeDTO);
            }

            return coacheeDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Coachee> listCoacheeDTOToListCoachee(
        List<CoacheeDTO> listCoacheeDTO) throws Exception {
        try {
            List<Coachee> listCoachee = new ArrayList<Coachee>();

            for (CoacheeDTO coacheeDTO : listCoacheeDTO) {
                Coachee coachee = coacheeDTOToCoachee(coacheeDTO);

                listCoachee.add(coachee);
            }

            return listCoachee;
        } catch (Exception e) {
            throw e;
        }
    }
}
