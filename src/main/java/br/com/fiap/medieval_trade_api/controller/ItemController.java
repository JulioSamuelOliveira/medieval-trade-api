package br.com.fiap.medieval_trade_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.medieval_trade_api.model.Item;
import br.com.fiap.medieval_trade_api.repository.ItemRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/itens")
@Slf4j

public class ItemController {

    @Autowired
    private ItemRepository repository;

    @GetMapping
    @Cacheable("itens")
    @Operation(description = "listar todos os itens", tags = "itens", summary = "Lista de itens")
    public List<Item> index() {
        log.info("Buscando todos os itens");
        return repository.findAll();
    }

    @PostMapping
    @CacheEvict(value = "itens", allEntries = true)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(responses = {
            @ApiResponse(responseCode = "400", description = "Falha na validação")
    })
    public Item create(@RequestBody @Valid Item item) {
        log.info("Cadastrando item" + item.getName());
        return repository.save(item);
    }

    @GetMapping("{id}")
    public Item get(@PathVariable Long id) {
        log.info("Buscando item" + id);
        return getItem(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("Apagando Item" + id);
        repository.delete(getItem(id));
    }

    @PutMapping("{id}")
    public Item update(@PathVariable Long id, @RequestBody @Valid Item item){
        log.info("Atualizando personagem" + id + " " + item);

        getItem(id);
        item.setId(id);
        return repository.save(item);
    }

    private Item getItem(Long id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Item não encontrado"));
    }
}
