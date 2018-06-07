package pdg.dto.mapper;

import pdg.modelo.SesCoaching;

import pdg.modelo.dto.SesCoachingDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ISesCoachingMapper {
    public SesCoachingDTO sesCoachingToSesCoachingDTO(SesCoaching sesCoaching)
        throws Exception;

    public SesCoaching sesCoachingDTOToSesCoaching(
        SesCoachingDTO sesCoachingDTO) throws Exception;

    public List<SesCoachingDTO> listSesCoachingToListSesCoachingDTO(
        List<SesCoaching> sesCoachings) throws Exception;

    public List<SesCoaching> listSesCoachingDTOToListSesCoaching(
        List<SesCoachingDTO> sesCoachingDTOs) throws Exception;
}
