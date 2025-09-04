package br.com.MercShoppe.dev.MercShoppe_api.Controller;


import br.com.MercShoppe.dev.MercShoppe_api.DTO.FornecedorCreateDTO;
import br.com.MercShoppe.dev.MercShoppe_api.Service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping("/{id}")
    public FornecedorCreateDTO findById(@PathVariable("id") UUID id) {return service.findById(id);}

    //pegar todas as mercadorias
    @GetMapping
    public List<FornecedorCreateDTO> findAll() {return service.findAll();}

    //salvar mercadoria
    @PostMapping
    public FornecedorCreateDTO save(@RequestBody FornecedorCreateDTO fornecedorCreateDTO) {return service.save(fornecedorCreateDTO);}

    //atualizar mercadoria
    @PutMapping("/{id}") public FornecedorCreateDTO update( @PathVariable("id")UUID id, @RequestBody FornecedorCreateDTO fornecedorCreateDTO) {return service.update(id,fornecedorCreateDTO);}

    //deletar mercadoria
    @DeleteMapping("/{id}") public void deleteById(@PathVariable("id")UUID id){service.deleteById(id);}

}

