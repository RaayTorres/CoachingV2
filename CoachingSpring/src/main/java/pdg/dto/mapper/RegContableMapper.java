package pdg.dto.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import pdg.modelo.*;
import pdg.modelo.RegContable;
import pdg.modelo.dto.RegContableDTO;
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
public class RegContableMapper implements IRegContableMapper {
    private static final Logger log = LoggerFactory.getLogger(RegContableMapper.class);

    /**
    * Logic injected by Spring that manages Coachee entities
    *
    */
    @Autowired
    ICoacheeLogic logicCoachee1;

    @Transactional(readOnly = true)
    public RegContableDTO regContableToRegContableDTO(RegContable regContable)
        throws Exception {
        try {
            RegContableDTO regContableDTO = new RegContableDTO();

            regContableDTO.setIdHis(regContable.getIdHis());
            regContableDTO.setFechaPago(regContable.getFechaPago());
            regContableDTO.setTipo((regContable.getTipo() != null)
                ? regContable.getTipo() : null);
//            regContableDTO.setValor((regContable.getValor() != null)
//                ? regContable.getValor() : null);
           regContableDTO.setIdCoachee_Coachee((regContable.getCoachee()
                                                            .getIdCoachee() != null)
                ? regContable.getCoachee().getIdCoachee() : null);

            return regContableDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public RegContable regContableDTOToRegContable(
        RegContableDTO regContableDTO) throws Exception {
        try {
            RegContable regContable = new RegContable();

            regContable.setIdHis(regContableDTO.getIdHis());
            regContable.setFechaPago(regContableDTO.getFechaPago());
            regContable.setTipo((regContableDTO.getTipo() != null)
                ? regContableDTO.getTipo() : null);
    //        regContable.setValor((regContableDTO.getValor() != null)
       //         ? regContableDTO.getValor() : null);

            Coachee coachee = new Coachee();

            if (regContableDTO.getIdCoachee_Coachee() != null) {
                coachee = logicCoachee1.getCoachee(regContableDTO.getIdCoachee_Coachee());
            }

            if (coachee != null) {
                regContable.setCoachee(coachee);
            }

            return regContable;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RegContableDTO> listRegContableToListRegContableDTO(
        List<RegContable> listRegContable) throws Exception {
        try {
            List<RegContableDTO> regContableDTOs = new ArrayList<RegContableDTO>();

            for (RegContable regContable : listRegContable) {
                RegContableDTO regContableDTO = regContableToRegContableDTO(regContable);

                regContableDTOs.add(regContableDTO);
            }

            return regContableDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RegContable> listRegContableDTOToListRegContable(
        List<RegContableDTO> listRegContableDTO) throws Exception {
        try {
            List<RegContable> listRegContable = new ArrayList<RegContable>();

            for (RegContableDTO regContableDTO : listRegContableDTO) {
                RegContable regContable = regContableDTOToRegContable(regContableDTO);

                listRegContable.add(regContable);
            }

            return listRegContable;
        } catch (Exception e) {
            throw e;
        }
    }
}
