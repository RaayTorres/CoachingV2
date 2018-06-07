package pdg.dto.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import pdg.modelo.*;
import pdg.modelo.Estado;
import pdg.modelo.dto.EstadoDTO;
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
public class EstadoMapper implements IEstadoMapper {
    private static final Logger log = LoggerFactory.getLogger(EstadoMapper.class);

    /**
    * Logic injected by Spring that manages TipoEstado entities
    *
    */
    @Autowired
    ITipoEstadoLogic logicTipoEstado1;

    @Transactional(readOnly = true)
    public EstadoDTO estadoToEstadoDTO(Estado estado) throws Exception {
        try {
            EstadoDTO estadoDTO = new EstadoDTO();

            estadoDTO.setIdEstado(estado.getIdEstado());
            estadoDTO.setNombreEstado((estado.getNombreEstado() != null)
                ? estado.getNombreEstado() : null);
            estadoDTO.setIdTestado_TipoEstado((estado.getTipoEstado()
                                                     .getIdTestado() != null)
                ? estado.getTipoEstado().getIdTestado() : null);

            return estadoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Estado estadoDTOToEstado(EstadoDTO estadoDTO)
        throws Exception {
        try {
            Estado estado = new Estado();

            estado.setIdEstado(estadoDTO.getIdEstado());
            estado.setNombreEstado((estadoDTO.getNombreEstado() != null)
                ? estadoDTO.getNombreEstado() : null);

            TipoEstado tipoEstado = new TipoEstado();

            if (estadoDTO.getIdTestado_TipoEstado() != null) {
                tipoEstado = logicTipoEstado1.getTipoEstado(estadoDTO.getIdTestado_TipoEstado());
            }

            if (tipoEstado != null) {
                estado.setTipoEstado(tipoEstado);
            }

            return estado;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EstadoDTO> listEstadoToListEstadoDTO(List<Estado> listEstado)
        throws Exception {
        try {
            List<EstadoDTO> estadoDTOs = new ArrayList<EstadoDTO>();

            for (Estado estado : listEstado) {
                EstadoDTO estadoDTO = estadoToEstadoDTO(estado);

                estadoDTOs.add(estadoDTO);
            }

            return estadoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Estado> listEstadoDTOToListEstado(List<EstadoDTO> listEstadoDTO)
        throws Exception {
        try {
            List<Estado> listEstado = new ArrayList<Estado>();

            for (EstadoDTO estadoDTO : listEstadoDTO) {
                Estado estado = estadoDTOToEstado(estadoDTO);

                listEstado.add(estado);
            }

            return listEstado;
        } catch (Exception e) {
            throw e;
        }
    }
}
