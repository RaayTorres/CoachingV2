package pdg.dto.mapper;

import pdg.modelo.Estado;

import pdg.modelo.dto.EstadoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IEstadoMapper {
    public EstadoDTO estadoToEstadoDTO(Estado estado) throws Exception;

    public Estado estadoDTOToEstado(EstadoDTO estadoDTO)
        throws Exception;

    public List<EstadoDTO> listEstadoToListEstadoDTO(List<Estado> estados)
        throws Exception;

    public List<Estado> listEstadoDTOToListEstado(List<EstadoDTO> estadoDTOs)
        throws Exception;
}
