package pdg.dto.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import pdg.modelo.*;
import pdg.modelo.TipoEstado;
import pdg.modelo.dto.TipoEstadoDTO;
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
public class TipoEstadoMapper implements ITipoEstadoMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoEstadoMapper.class);

    @Transactional(readOnly = true)
    public TipoEstadoDTO tipoEstadoToTipoEstadoDTO(TipoEstado tipoEstado)
        throws Exception {
        try {
            TipoEstadoDTO tipoEstadoDTO = new TipoEstadoDTO();

            tipoEstadoDTO.setIdTestado(tipoEstado.getIdTestado());
            tipoEstadoDTO.setNombreTipoEstado((tipoEstado.getNombreTipoEstado() != null)
                ? tipoEstado.getNombreTipoEstado() : null);

            return tipoEstadoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoEstado tipoEstadoDTOToTipoEstado(TipoEstadoDTO tipoEstadoDTO)
        throws Exception {
        try {
            TipoEstado tipoEstado = new TipoEstado();

            tipoEstado.setIdTestado(tipoEstadoDTO.getIdTestado());
            tipoEstado.setNombreTipoEstado((tipoEstadoDTO.getNombreTipoEstado() != null)
                ? tipoEstadoDTO.getNombreTipoEstado() : null);

            return tipoEstado;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoEstadoDTO> listTipoEstadoToListTipoEstadoDTO(
        List<TipoEstado> listTipoEstado) throws Exception {
        try {
            List<TipoEstadoDTO> tipoEstadoDTOs = new ArrayList<TipoEstadoDTO>();

            for (TipoEstado tipoEstado : listTipoEstado) {
                TipoEstadoDTO tipoEstadoDTO = tipoEstadoToTipoEstadoDTO(tipoEstado);

                tipoEstadoDTOs.add(tipoEstadoDTO);
            }

            return tipoEstadoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoEstado> listTipoEstadoDTOToListTipoEstado(
        List<TipoEstadoDTO> listTipoEstadoDTO) throws Exception {
        try {
            List<TipoEstado> listTipoEstado = new ArrayList<TipoEstado>();

            for (TipoEstadoDTO tipoEstadoDTO : listTipoEstadoDTO) {
                TipoEstado tipoEstado = tipoEstadoDTOToTipoEstado(tipoEstadoDTO);

                listTipoEstado.add(tipoEstado);
            }

            return listTipoEstado;
        } catch (Exception e) {
            throw e;
        }
    }
}
