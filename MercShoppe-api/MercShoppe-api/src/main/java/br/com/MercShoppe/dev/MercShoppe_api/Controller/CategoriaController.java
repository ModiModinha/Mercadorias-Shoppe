package br.com.MercShoppe.dev.MercShoppe_api.Controller;


import br.com.MercShoppe.dev.MercShoppe_api.DTO.CategoriaCreateDTO;
import br.com.MercShoppe.dev.MercShoppe_api.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping("/{id}")
    public CategoriaCreateDTO findById(@PathVariable("id") UUID id) {return service.findById(id);}

    //pegar todas as mercadorias
    @GetMapping
    public List<CategoriaCreateDTO> findAll() {return service.findAll();}

    //salvar mercadoria
    @PostMapping
    public CategoriaCreateDTO save(@RequestBody CategoriaCreateDTO categoriaCreateDTO) {return service.save(categoriaCreateDTO);}

    //atualizar mercadoria
    @PutMapping("/{id}") public CategoriaCreateDTO update( @PathVariable("id")UUID id, @RequestBody CategoriaCreateDTO categoriaCreateDTO) {return service.update(id,categoriaCreateDTO);}

    //deletar mercadoria
    @DeleteMapping("/{id}") public void deleteById(@PathVariable("id")UUID id){service.deleteById(id);}

}

