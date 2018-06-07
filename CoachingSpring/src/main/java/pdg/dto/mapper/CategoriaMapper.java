package pdg.dto.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import pdg.modelo.*;
import pdg.modelo.Categoria;
import pdg.modelo.dto.CategoriaDTO;
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
public class CategoriaMapper implements ICategoriaMapper {
    private static final Logger log = LoggerFactory.getLogger(CategoriaMapper.class);

    @Transactional(readOnly = true)
    public CategoriaDTO categoriaToCategoriaDTO(Categoria categoria)
        throws Exception {
        try {
            CategoriaDTO categoriaDTO = new CategoriaDTO();

            categoriaDTO.setIdCat(categoria.getIdCat());
            categoriaDTO.setCatNombre((categoria.getCatNombre() != null)
                ? categoria.getCatNombre() : null);
            categoriaDTO.setHoraPagada((categoria.getHoraPagada() != null)
                ? categoria.getHoraPagada() : null);
            categoriaDTO.setHoraProbono((categoria.getHoraProbono() != null)
                ? categoria.getHoraProbono() : null);
            categoriaDTO.setNombreCorto((categoria.getNombreCorto() != null)
                ? categoria.getNombreCorto() : null);

            return categoriaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO)
        throws Exception {
        try {
            Categoria categoria = new Categoria();

            categoria.setIdCat(categoriaDTO.getIdCat());
            categoria.setCatNombre((categoriaDTO.getCatNombre() != null)
                ? categoriaDTO.getCatNombre() : null);
            categoria.setHoraPagada((categoriaDTO.getHoraPagada() != null)
                ? categoriaDTO.getHoraPagada() : null);
            categoria.setHoraProbono((categoriaDTO.getHoraProbono() != null)
                ? categoriaDTO.getHoraProbono() : null);
            categoria.setNombreCorto((categoriaDTO.getNombreCorto() != null)
                ? categoriaDTO.getNombreCorto() : null);

            return categoria;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CategoriaDTO> listCategoriaToListCategoriaDTO(
        List<Categoria> listCategoria) throws Exception {
        try {
            List<CategoriaDTO> categoriaDTOs = new ArrayList<CategoriaDTO>();

            for (Categoria categoria : listCategoria) {
                CategoriaDTO categoriaDTO = categoriaToCategoriaDTO(categoria);

                categoriaDTOs.add(categoriaDTO);
            }

            return categoriaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Categoria> listCategoriaDTOToListCategoria(
        List<CategoriaDTO> listCategoriaDTO) throws Exception {
        try {
            List<Categoria> listCategoria = new ArrayList<Categoria>();

            for (CategoriaDTO categoriaDTO : listCategoriaDTO) {
                Categoria categoria = categoriaDTOToCategoria(categoriaDTO);

                listCategoria.add(categoria);
            }

            return listCategoria;
        } catch (Exception e) {
            throw e;
        }
    }
}
