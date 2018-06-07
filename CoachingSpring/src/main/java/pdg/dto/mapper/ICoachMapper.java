package pdg.dto.mapper;

import pdg.modelo.Coach;

import pdg.modelo.dto.CoachDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ICoachMapper {
    public CoachDTO coachToCoachDTO(Coach coach) throws Exception;

    public Coach coachDTOToCoach(CoachDTO coachDTO) throws Exception;

    public List<CoachDTO> listCoachToListCoachDTO(List<Coach> coachs)
        throws Exception;

    public List<Coach> listCoachDTOToListCoach(List<CoachDTO> coachDTOs)
        throws Exception;
}
