package pdg.dto.mapper;

import pdg.modelo.ProcCoaching;

import pdg.modelo.dto.ProcCoachingDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IProcCoachingMapper {
    public ProcCoachingDTO procCoachingToProcCoachingDTO(
        ProcCoaching procCoaching) throws Exception;

    public ProcCoaching procCoachingDTOToProcCoaching(
        ProcCoachingDTO procCoachingDTO) throws Exception;

    public List<ProcCoachingDTO> listProcCoachingToListProcCoachingDTO(
        List<ProcCoaching> procCoachings) throws Exception;

    public List<ProcCoaching> listProcCoachingDTOToListProcCoaching(
        List<ProcCoachingDTO> procCoachingDTOs) throws Exception;
}
