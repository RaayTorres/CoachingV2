package pdg.dto.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import pdg.modelo.*;
import pdg.modelo.Coach;
import pdg.modelo.dto.CoachDTO;
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
public class CoachMapper implements ICoachMapper {
    private static final Logger log = LoggerFactory.getLogger(CoachMapper.class);

    /**
    * Logic injected by Spring that manages Categoria entities
    *
    */
    @Autowired
    ICategoriaLogic logicCategoria1;

    /**
    * Logic injected by Spring that manages Estado entities
    *
    */
    @Autowired
    IEstadoLogic logicEstado2;

    /**
    * Logic injected by Spring that manages TipoDocumento entities
    *
    */
    @Autowired
    ITipoDocumentoLogic logicTipoDocumento3;

    @Transactional(readOnly = true)
    public CoachDTO coachToCoachDTO(Coach coach) throws Exception {
        try {
            CoachDTO coachDTO = new CoachDTO();

            coachDTO.setIdCoach(coach.getIdCoach());
            coachDTO.setApellido((coach.getApellido() != null)
                ? coach.getApellido() : null);
            coachDTO.setCelular((coach.getCelular() != null)
                ? coach.getCelular() : null);
            coachDTO.setContrasena((coach.getContrasena() != null)
                ? coach.getContrasena() : null);
            coachDTO.setCorreo((coach.getCorreo() != null) ? coach.getCorreo()
                                                           : null);
            coachDTO.setHoraPagada((coach.getHoraPagada() != null)
                ? coach.getHoraPagada() : null);
            coachDTO.setHoraProbono((coach.getHoraProbono() != null)
                ? coach.getHoraProbono() : null);
            coachDTO.setIdentificacion((coach.getIdentificacion() != null)
                ? coach.getIdentificacion() : null);
            coachDTO.setLogin((coach.getLogin() != null) ? coach.getLogin() : null);
            coachDTO.setNombre((coach.getNombre() != null) ? coach.getNombre()
                                                           : null);
            coachDTO.setTelefono((coach.getTelefono() != null)
                ? coach.getTelefono() : null);

            if (coach.getCategoria() != null) {
                coachDTO.setIdCat_Categoria(coach.getCategoria().getIdCat());
            } else {
                coachDTO.setIdCat_Categoria(null);
            }

          
            coachDTO.setIdDoc_TipoDocumento((coach.getTipoDocumento().getIdDoc() != null)
                ? coach.getTipoDocumento().getIdDoc() : null);

            return coachDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Coach coachDTOToCoach(CoachDTO coachDTO) throws Exception {
        try {
            Coach coach = new Coach();

            coach.setIdCoach(coachDTO.getIdCoach());
            coach.setApellido((coachDTO.getApellido() != null)
                ? coachDTO.getApellido() : null);
            coach.setCelular((coachDTO.getCelular() != null)
                ? coachDTO.getCelular() : null);
            coach.setContrasena((coachDTO.getContrasena() != null)
                ? coachDTO.getContrasena() : null);
            coach.setCorreo((coachDTO.getCorreo() != null)
                ? coachDTO.getCorreo() : null);
            coach.setHoraPagada((coachDTO.getHoraPagada() != null)
                ? coachDTO.getHoraPagada() : null);
            coach.setHoraProbono((coachDTO.getHoraProbono() != null)
                ? coachDTO.getHoraProbono() : null);
            coach.setIdentificacion((coachDTO.getIdentificacion() != null)
                ? coachDTO.getIdentificacion() : null);
            coach.setLogin((coachDTO.getLogin() != null) ? coachDTO.getLogin()
                                                         : null);
            coach.setNombre((coachDTO.getNombre() != null)
                ? coachDTO.getNombre() : null);
            coach.setTelefono((coachDTO.getTelefono() != null)
                ? coachDTO.getTelefono() : null);

            Categoria categoria = new Categoria();

            if (coachDTO.getIdCat_Categoria() != null) {
                categoria = logicCategoria1.getCategoria(coachDTO.getIdCat_Categoria());
            }

            if (categoria != null) {
                coach.setCategoria(categoria);
            }

            Estado estado = new Estado();

            if (coachDTO.getIdEstado_Estado() != null) {
                estado = logicEstado2.getEstado(coachDTO.getIdEstado_Estado());
            }


            TipoDocumento tipoDocumento = new TipoDocumento();

            if (coachDTO.getIdDoc_TipoDocumento() != null) {
                tipoDocumento = logicTipoDocumento3.getTipoDocumento(coachDTO.getIdDoc_TipoDocumento());
            }

            if (tipoDocumento != null) {
                coach.setTipoDocumento(tipoDocumento);
            }

            return coach;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CoachDTO> listCoachToListCoachDTO(List<Coach> listCoach)
        throws Exception {
        try {
            List<CoachDTO> coachDTOs = new ArrayList<CoachDTO>();

            for (Coach coach : listCoach) {
                CoachDTO coachDTO = coachToCoachDTO(coach);

                coachDTOs.add(coachDTO);
            }

            return coachDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Coach> listCoachDTOToListCoach(List<CoachDTO> listCoachDTO)
        throws Exception {
        try {
            List<Coach> listCoach = new ArrayList<Coach>();

            for (CoachDTO coachDTO : listCoachDTO) {
                Coach coach = coachDTOToCoach(coachDTO);

                listCoach.add(coach);
            }

            return listCoach;
        } catch (Exception e) {
            throw e;
        }
    }
}
