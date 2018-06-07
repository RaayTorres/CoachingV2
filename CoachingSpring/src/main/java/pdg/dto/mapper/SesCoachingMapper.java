package pdg.dto.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import pdg.modelo.*;
import pdg.modelo.SesCoaching;
import pdg.modelo.dto.SesCoachingDTO;
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
public class SesCoachingMapper implements ISesCoachingMapper {
    private static final Logger log = LoggerFactory.getLogger(SesCoachingMapper.class);

    /**
    * Logic injected by Spring that manages Estado entities
    *
    */
    @Autowired
    IEstadoLogic logicEstado1;

    /**
    * Logic injected by Spring that manages ProcCoaching entities
    *
    */
    @Autowired
    IProcCoachingLogic logicProcCoaching2;

    @Transactional(readOnly = true)
    public SesCoachingDTO sesCoachingToSesCoachingDTO(SesCoaching sesCoaching)
        throws Exception {
        try {
            SesCoachingDTO sesCoachingDTO = new SesCoachingDTO();

            sesCoachingDTO.setIdSesi(sesCoaching.getIdSesi());
            sesCoachingDTO.setAccion((sesCoaching.getAccion() != null)
                ? sesCoaching.getAccion() : null);
            sesCoachingDTO.setCompromiso((sesCoaching.getCompromiso() != null)
                ? sesCoaching.getCompromiso() : null);
            sesCoachingDTO.setFecha(sesCoaching.getFecha());
            sesCoachingDTO.setFocoSesion((sesCoaching.getFocoSesion() != null)
                ? sesCoaching.getFocoSesion() : null);
            sesCoachingDTO.setHora((sesCoaching.getHora() != null)
                ? sesCoaching.getHora() : null);
            sesCoachingDTO.setIdHis((sesCoaching.getIdHis() != null)
                ? sesCoaching.getIdHis() : null);
            sesCoachingDTO.setIndicador((sesCoaching.getIndicador() != null)
                ? sesCoaching.getIndicador() : null);
            sesCoachingDTO.setProfundidad((sesCoaching.getProfundidad() != null)
                ? sesCoaching.getProfundidad() : null);
            sesCoachingDTO.setIdEstado_Estado((sesCoaching.getEstado()
                                                          .getIdEstado() != null)
                ? sesCoaching.getEstado().getIdEstado() : null);
            sesCoachingDTO.setIdProc_ProcCoaching((sesCoaching.getProcCoaching()
                                                              .getIdProc() != null)
                ? sesCoaching.getProcCoaching().getIdProc() : null);

            return sesCoachingDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public SesCoaching sesCoachingDTOToSesCoaching(
        SesCoachingDTO sesCoachingDTO) throws Exception {
        try {
            SesCoaching sesCoaching = new SesCoaching();

            sesCoaching.setIdSesi(sesCoachingDTO.getIdSesi());
            sesCoaching.setAccion((sesCoachingDTO.getAccion() != null)
                ? sesCoachingDTO.getAccion() : null);
            sesCoaching.setCompromiso((sesCoachingDTO.getCompromiso() != null)
                ? sesCoachingDTO.getCompromiso() : null);
            sesCoaching.setFecha(sesCoachingDTO.getFecha());
            sesCoaching.setFocoSesion((sesCoachingDTO.getFocoSesion() != null)
                ? sesCoachingDTO.getFocoSesion() : null);
            sesCoaching.setHora((sesCoachingDTO.getHora() != null)
                ? sesCoachingDTO.getHora() : null);
            sesCoaching.setIdHis((sesCoachingDTO.getIdHis() != null)
                ? sesCoachingDTO.getIdHis() : null);
            sesCoaching.setIndicador((sesCoachingDTO.getIndicador() != null)
                ? sesCoachingDTO.getIndicador() : null);
            sesCoaching.setProfundidad((sesCoachingDTO.getProfundidad() != null)
                ? sesCoachingDTO.getProfundidad() : null);

            Estado estado = new Estado();

            if (sesCoachingDTO.getIdEstado_Estado() != null) {
                estado = logicEstado1.getEstado(sesCoachingDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                sesCoaching.setEstado(estado);
            }

            ProcCoaching procCoaching = new ProcCoaching();

            if (sesCoachingDTO.getIdProc_ProcCoaching() != null) {
                procCoaching = logicProcCoaching2.getProcCoaching(sesCoachingDTO.getIdProc_ProcCoaching());
            }

            if (procCoaching != null) {
                sesCoaching.setProcCoaching(procCoaching);
            }

            return sesCoaching;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SesCoachingDTO> listSesCoachingToListSesCoachingDTO(
        List<SesCoaching> listSesCoaching) throws Exception {
        try {
            List<SesCoachingDTO> sesCoachingDTOs = new ArrayList<SesCoachingDTO>();

            for (SesCoaching sesCoaching : listSesCoaching) {
                SesCoachingDTO sesCoachingDTO = sesCoachingToSesCoachingDTO(sesCoaching);

                sesCoachingDTOs.add(sesCoachingDTO);
            }

            return sesCoachingDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SesCoaching> listSesCoachingDTOToListSesCoaching(
        List<SesCoachingDTO> listSesCoachingDTO) throws Exception {
        try {
            List<SesCoaching> listSesCoaching = new ArrayList<SesCoaching>();

            for (SesCoachingDTO sesCoachingDTO : listSesCoachingDTO) {
                SesCoaching sesCoaching = sesCoachingDTOToSesCoaching(sesCoachingDTO);

                listSesCoaching.add(sesCoaching);
            }

            return listSesCoaching;
        } catch (Exception e) {
            throw e;
        }
    }
}
