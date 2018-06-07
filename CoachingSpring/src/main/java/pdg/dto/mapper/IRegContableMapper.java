package pdg.dto.mapper;

import pdg.modelo.RegContable;

import pdg.modelo.dto.RegContableDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IRegContableMapper {
    public RegContableDTO regContableToRegContableDTO(RegContable regContable)
        throws Exception;

    public RegContable regContableDTOToRegContable(
        RegContableDTO regContableDTO) throws Exception;

    public List<RegContableDTO> listRegContableToListRegContableDTO(
        List<RegContable> regContables) throws Exception;

    public List<RegContable> listRegContableDTOToListRegContable(
        List<RegContableDTO> regContableDTOs) throws Exception;
}
