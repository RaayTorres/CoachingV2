package pdg.dto.mapper;

import pdg.modelo.Coachee;

import pdg.modelo.dto.CoacheeDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ICoacheeMapper {
    public CoacheeDTO coacheeToCoacheeDTO(Coachee coachee)
        throws Exception;

    public Coachee coacheeDTOToCoachee(CoacheeDTO coacheeDTO)
        throws Exception;

    public List<CoacheeDTO> listCoacheeToListCoacheeDTO(List<Coachee> coachees)
        throws Exception;

    public List<Coachee> listCoacheeDTOToListCoachee(
        List<CoacheeDTO> coacheeDTOs) throws Exception;
}
