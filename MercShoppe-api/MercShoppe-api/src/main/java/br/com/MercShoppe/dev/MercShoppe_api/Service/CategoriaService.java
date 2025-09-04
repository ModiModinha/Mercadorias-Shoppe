package br.com.MercShoppe.dev.MercShoppe_api.Service;

import br.com.MercShoppe.dev.MercShoppe_api.DTO.CategoriaCreateDTO;
import br.com.MercShoppe.dev.MercShoppe_api.Entity.Categoria;
import br.com.MercShoppe.dev.MercShoppe_api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaCreateDTO findById(UUID id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        CategoriaCreateDTO categoriaCreateDTO = convertToDto(categoria);
        return categoriaCreateDTO;
    }

    public CategoriaCreateDTO save(CategoriaCreateDTO categoriaDTO){
        Categoria categoria = convertToEntity(categoriaDTO);
        categoria = categoriaRepository.save(categoria);
        return convertToDto(categoria);
    }

    public CategoriaCreateDTO update(UUID id, CategoriaCreateDTO categoriaDTO){
        Categoria categoria = convertToEntity(categoriaDTO);
        categoria.setId(id);
        categoria = categoriaRepository.save(categoria);
        return convertToDto(categoria);
    }

    public void deleteById(UUID id){
        categoriaRepository.deleteById(id);
    }

    public List<CategoriaCreateDTO> findAll(){
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaCreateDTO> categoriasDTO = new ArrayList<>();
        for(Categoria categoria : categorias){
            categoriasDTO.add(convertToDto(categoria));
        }
        return categoriasDTO;
    }

    public CategoriaCreateDTO convertToDto (Categoria categoria){
        CategoriaCreateDTO categoriaCreateDTO = new CategoriaCreateDTO();
        categoriaCreateDTO.setNome(categoria.getNome());
        categoriaCreateDTO.setDescricao(categoria.getDescricao());
        categoriaCreateDTO.setMercadorias(categoria.getMercadorias());
        return categoriaCreateDTO;
    }

    public Categoria convertToEntity(CategoriaCreateDTO categoriaCreateDTO){
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaCreateDTO.getNome());
        categoria.setDescricao(categoriaCreateDTO.getDescricao());
        categoria.setMercadorias(categoriaCreateDTO.getMercadorias());
        return categoria;
    }

}
