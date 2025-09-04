package br.com.MercShoppe.dev.MercShoppe_api.Service;

import br.com.MercShoppe.dev.MercShoppe_api.DTO.MercadoriaCreateDTO;
import br.com.MercShoppe.dev.MercShoppe_api.Entity.Mercadoria;
import br.com.MercShoppe.dev.MercShoppe_api.repository.MercadoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MercadoriaService {
    @Autowired
    private MercadoriaRepository mercadoriaRepository;

    public MercadoriaCreateDTO findById(UUID id) {
        Mercadoria mercadoria = mercadoriaRepository.findById(id).orElseThrow();
        MercadoriaCreateDTO mercadoriaCreateDTO = convertToDto(mercadoria);
        return mercadoriaCreateDTO;
    }

    public MercadoriaCreateDTO save(MercadoriaCreateDTO mercadoriaDTO){
        Mercadoria mercadoria = convertToEntity(mercadoriaDTO);
        mercadoria = mercadoriaRepository.save(mercadoria);
        return convertToDto(mercadoria);
    }

    public MercadoriaCreateDTO update(UUID id, MercadoriaCreateDTO mercadoriaDTO){
        Mercadoria mercadoria = convertToEntity(mercadoriaDTO);
        mercadoria.setId(id);
        mercadoria = mercadoriaRepository.save(mercadoria);
        return convertToDto(mercadoria);
    }

    public void deleteById(UUID id){
        mercadoriaRepository.deleteById(id);
    }
    public List<MercadoriaCreateDTO> findAll(){
        List<Mercadoria> mercadorias = mercadoriaRepository.findAll();
        List<MercadoriaCreateDTO> mercadoriasDTO = new ArrayList<>();
        for(Mercadoria mercadoria : mercadorias){
            mercadoriasDTO.add(convertToDto(mercadoria));
        }
        return mercadoriasDTO;
    }

    public MercadoriaCreateDTO convertToDto (Mercadoria mercadoria){
        MercadoriaCreateDTO mercadoriaCreateDTO = new MercadoriaCreateDTO();
        mercadoriaCreateDTO.setNome(mercadoria.getNome());
        mercadoriaCreateDTO.setPreco(mercadoria.getPreco());
        mercadoriaCreateDTO.setQuantidade(mercadoria.getQuantidade());
        mercadoriaCreateDTO.setCategoria(mercadoria.getCategoria());
        mercadoriaCreateDTO.setFornecedor(mercadoria.getFornecedor());
        return mercadoriaCreateDTO;
    }

    public Mercadoria convertToEntity(MercadoriaCreateDTO mercadoriaCreateDTO){
        Mercadoria mercadoria = new Mercadoria();
        mercadoria.setNome(mercadoriaCreateDTO.getNome());
        mercadoria.setPreco(mercadoriaCreateDTO.getPreco());
        mercadoria.setQuantidade(mercadoriaCreateDTO.getQuantidade());
        mercadoria.setCategoria(mercadoriaCreateDTO.getCategoria());
        mercadoria.setFornecedor(mercadoriaCreateDTO.getFornecedor());
        return mercadoria;
    }

}
