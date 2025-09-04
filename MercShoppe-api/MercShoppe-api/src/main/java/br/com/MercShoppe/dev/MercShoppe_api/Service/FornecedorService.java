package br.com.MercShoppe.dev.MercShoppe_api.Service;

import br.com.MercShoppe.dev.MercShoppe_api.DTO.FornecedorCreateDTO;
import br.com.MercShoppe.dev.MercShoppe_api.Entity.Fornecedor;
import br.com.MercShoppe.dev.MercShoppe_api.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorCreateDTO findById(UUID id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow();
        FornecedorCreateDTO fornecedorCreateDTO = convertToDto(fornecedor);
        return fornecedorCreateDTO;
    }

    public FornecedorCreateDTO save(FornecedorCreateDTO fornecedorDTO){
        Fornecedor fornecedor = convertToEntity(fornecedorDTO);
        fornecedor = fornecedorRepository.save(fornecedor);
        return convertToDto(fornecedor);
    }

    public FornecedorCreateDTO update(UUID id, FornecedorCreateDTO fornecedorDTO){
        Fornecedor fornecedor = convertToEntity(fornecedorDTO);
        fornecedor.setId(id);
        fornecedor = fornecedorRepository.save(fornecedor);
        return convertToDto(fornecedor);
    }

    public void deleteById(UUID id){
        fornecedorRepository.deleteById(id);
    }

    public List<FornecedorCreateDTO> findAll(){
        List<Fornecedor> fornecedores = fornecedorRepository.findAll();
        List<FornecedorCreateDTO> fornecedoresDTO = new ArrayList<>();
        for(Fornecedor fornecedor : fornecedores){
            fornecedoresDTO.add(convertToDto(fornecedor));
        }
        return fornecedoresDTO;
    }

    public FornecedorCreateDTO convertToDto (Fornecedor fornecedor){
        FornecedorCreateDTO fornecedorCreateDTO = new FornecedorCreateDTO();
        fornecedorCreateDTO.setNome(fornecedor.getNome());
        fornecedorCreateDTO.setContato(fornecedor.getContato());
        fornecedorCreateDTO.setEndereco(fornecedor.getEndereco());
        fornecedorCreateDTO.setMercadorias(fornecedor.getMercadorias());
        return fornecedorCreateDTO;
    }

    public Fornecedor convertToEntity(FornecedorCreateDTO fornecedorCreateDTO){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(fornecedorCreateDTO.getNome());
        fornecedor.setContato(fornecedorCreateDTO.getContato());
        fornecedor.setEndereco(fornecedorCreateDTO.getEndereco());
        fornecedor.setMercadorias(fornecedorCreateDTO.getMercadorias());
        return fornecedor;
    }

}
