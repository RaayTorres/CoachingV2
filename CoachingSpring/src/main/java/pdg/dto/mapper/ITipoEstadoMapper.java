package pdg.dto.mapper;

import pdg.modelo.TipoEstado;

import pdg.modelo.dto.TipoEstadoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ITipoEstadoMapper {
    public TipoEstadoDTO tipoEstadoToTipoEstadoDTO(TipoEstado tipoEstado)
        throws Exception;

    public TipoEstado tipoEstadoDTOToTipoEstado(TipoEstadoDTO tipoEstadoDTO)
        throws Exception;

    public List<TipoEstadoDTO> listTipoEstadoToListTipoEstadoDTO(
        List<TipoEstado> tipoEstados) throws Exception;

    public List<TipoEstado> listTipoEstadoDTOToListTipoEstado(
        List<TipoEstadoDTO> tipoEstadoDTOs) throws Exception;
}
