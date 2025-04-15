package br.com.fiap.medieval_trade_api.config;

import br.com.fiap.medieval_trade_api.model.*;
import br.com.fiap.medieval_trade_api.repository.ChampionRepository;
import br.com.fiap.medieval_trade_api.repository.ItemRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DatabaseSeeder {

    @Autowired
    private ChampionRepository championRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        seedChampions();
        seedItems();
    }

    private void seedChampions() {
        if (championRepository.count() == 0) {
            List<Champion> champions = List.of(
                Champion.builder().name("Arthas").role(ChampionRole.GUERREIRO).power(90).level(50).build(),
                Champion.builder().name("Morgana").role(ChampionRole.MAGO).power(75).level(45).build(),
                Champion.builder().name("Thorn").role(ChampionRole.ARQUEIRO).power(60).level(35).build(),
                Champion.builder().name("Garen").role(ChampionRole.GUERREIRO).power(85).level(55).build()
            );
            championRepository.saveAll(champions);
        }
    }

    private void seedItems() {
        if (itemRepository.count() == 0) {
            List<Item> items = List.of(
                Item.builder().name("Espada Flamejante").type(ItemType.ARMA).rarity(ItemRarity.EPICA).price(new BigDecimal("250")).build(),
                Item.builder().name("Capa da Invisibilidade").type(ItemType.ARMADURA).rarity(ItemRarity.RARA).price(new BigDecimal("180")).build(),
                Item.builder().name("Poção de Vida").type(ItemType.POCAO).rarity(ItemRarity.COMUM).price(new BigDecimal("30")).build(),
                Item.builder().name("Elmo do Dragão").type(ItemType.ARMADURA).rarity(ItemRarity.LENDARIA).price(new BigDecimal("500")).build()
            );
            itemRepository.saveAll(items);
        }
    }
}