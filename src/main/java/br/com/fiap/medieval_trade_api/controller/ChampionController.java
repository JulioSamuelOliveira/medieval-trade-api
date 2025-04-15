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

import br.com.fiap.medieval_trade_api.repository.ChampionRepository;
import br.com.fiap.medieval_trade_api.model.Champion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/champions")
@Slf4j

public class ChampionController {

    @Autowired
    private ChampionRepository repository;

    @GetMapping
    @Cacheable("champions")
    @Operation(description = "listar todos os personagens", tags = "champions", summary = "Lista de personagens")
    public List<Champion> index() {
        log.info("Buscando todos os personagens");
        return repository.findAll();
    }

    @PostMapping
    @CacheEvict(value = "champions", allEntries = true)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(responses = {
        @ApiResponse(responseCode = "400", description = "Falha na validação")
    })
    public Champion create (@RequestBody @Valid Champion champion){
        log.info("Cadastrando Personagem" + champion.getName());
        return repository.save(champion);
    }

    @GetMapping("{id}")
    public Champion get(@PathVariable Long id) {
        log.info("Buscando personagem" + id);
        return getChampion(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("Apagando Personagem" + id);
        repository.delete(getChampion(id));
    }

    @PutMapping("{id}")
    public Champion update(@PathVariable Long id, @RequestBody @Valid Champion champion){
        log.info("Atualizando personagem" + id + " " + champion);

        getChampion(id);
        champion.setId(id);
        return repository.save(champion);
    }

    private Champion getChampion(Long id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Personagem não encontrado"));
    }
}
