package pdg.dto.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import pdg.modelo.*;
import pdg.modelo.ProcCoaching;
import pdg.modelo.dto.ProcCoachingDTO;
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
public class ProcCoachingMapper implements IProcCoachingMapper {
    private static final Logger log = LoggerFactory.getLogger(ProcCoachingMapper.class);

    /**
    * Logic injected by Spring that manages Coach entities
    *
    */
    @Autowired
    ICoachLogic logicCoach1;

    /**
    * Logic injected by Spring that manages Coachee entities
    *
    */
    @Autowired
    ICoacheeLogic logicCoachee2;

    /**
    * Logic injected by Spring that manages RegContable entities
    *
    */
    @Autowired
    IRegContableLogic logicRegContable3;

    @Transactional(readOnly = true)
    public ProcCoachingDTO procCoachingToProcCoachingDTO(
        ProcCoaching procCoaching) throws Exception {
        try {
            ProcCoachingDTO procCoachingDTO = new ProcCoachingDTO();

            procCoachingDTO.setIdProc(procCoaching.getIdProc());
          //  procCoachingDTO.setIdTpago((procCoaching.getIdTpago() != null)
           //     ? procCoaching.getIdTpago() : null);
            procCoachingDTO.setIdCoach_Coach((procCoaching.getCoach()
                                                          .getIdCoach() != null)
                ? procCoaching.getCoach().getIdCoach() : null);
            procCoachingDTO.setIdCoachee_Coachee((procCoaching.getCoachee()
                                                              .getIdCoachee() != null)
                ? procCoaching.getCoachee().getIdCoachee() : null);
            procCoachingDTO.setIdHis_RegContable((procCoaching.getRegContable()
                                                              .getIdHis() != null)
                ? procCoaching.getRegContable().getIdHis() : null);

            return procCoachingDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public ProcCoaching procCoachingDTOToProcCoaching(
        ProcCoachingDTO procCoachingDTO) throws Exception {
        try {
            ProcCoaching procCoaching = new ProcCoaching();

            procCoaching.setIdProc(procCoachingDTO.getIdProc());
        //    procCoaching.setIdTpago((procCoachingDTO.getIdTpago() != null)
 //               ? procCoachingDTO.getIdTpago() : null);

            Coach coach = new Coach();

            if (procCoachingDTO.getIdCoach_Coach() != null) {
                coach = logicCoach1.getCoach(procCoachingDTO.getIdCoach_Coach());
            }

            if (coach != null) {
                procCoaching.setCoach(coach);
            }

            Coachee coachee = new Coachee();

            if (procCoachingDTO.getIdCoachee_Coachee() != null) {
                coachee = logicCoachee2.getCoachee(procCoachingDTO.getIdCoachee_Coachee());
            }

            if (coachee != null) {
                procCoaching.setCoachee(coachee);
            }

            RegContable regContable = new RegContable();

            if (procCoachingDTO.getIdHis_RegContable() != null) {
                regContable = logicRegContable3.getRegContable(procCoachingDTO.getIdHis_RegContable());
            }

            if (regContable != null) {
                procCoaching.setRegContable(regContable);
            }

            return procCoaching;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProcCoachingDTO> listProcCoachingToListProcCoachingDTO(
        List<ProcCoaching> listProcCoaching) throws Exception {
        try {
            List<ProcCoachingDTO> procCoachingDTOs = new ArrayList<ProcCoachingDTO>();

            for (ProcCoaching procCoaching : listProcCoaching) {
                ProcCoachingDTO procCoachingDTO = procCoachingToProcCoachingDTO(procCoaching);

                procCoachingDTOs.add(procCoachingDTO);
            }

            return procCoachingDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProcCoaching> listProcCoachingDTOToListProcCoaching(
        List<ProcCoachingDTO> listProcCoachingDTO) throws Exception {
        try {
            List<ProcCoaching> listProcCoaching = new ArrayList<ProcCoaching>();

            for (ProcCoachingDTO procCoachingDTO : listProcCoachingDTO) {
                ProcCoaching procCoaching = procCoachingDTOToProcCoaching(procCoachingDTO);

                listProcCoaching.add(procCoaching);
            }

            return listProcCoaching;
        } catch (Exception e) {
            throw e;
        }
    }
}
