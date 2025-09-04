package br.com.MercShoppe.dev.MercShoppe_api.Controller;


import br.com.MercShoppe.dev.MercShoppe_api.DTO.MercadoriaCreateDTO;
import br.com.MercShoppe.dev.MercShoppe_api.Service.MercadoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/mercadoria")
public class MercadoriaController {

    @Autowired
    private MercadoriaService service;

    //encontrar mercadoria com seu id
    @GetMapping("/{id}")
    public MercadoriaCreateDTO findById(@PathVariable("id") UUID id) {return service.findById(id);}

    //pegar todas as mercadorias
    @GetMapping
    public List<MercadoriaCreateDTO> findAll() {return service.findAll();}

    //salvar mercadoria
    @PostMapping
    public MercadoriaCreateDTO save(@RequestBody MercadoriaCreateDTO mercadoriaCreateDTO) {return service.save(mercadoriaCreateDTO);}

    //atualizar mercadoria
    @PutMapping("/{id}") public MercadoriaCreateDTO update( @PathVariable("id")UUID id, @RequestBody MercadoriaCreateDTO mercadoriaCreateDTO) {return service.update(id,mercadoriaCreateDTO);}

    //deletar mercadoria
    @DeleteMapping("/{id}") public void deleteById(@PathVariable("id")UUID id){service.deleteById(id);}

}
