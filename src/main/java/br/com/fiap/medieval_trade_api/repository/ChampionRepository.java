package br.com.fiap.medieval_trade_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.medieval_trade_api.model.Champion;

public interface ChampionRepository extends JpaRepository<Champion, Long>{
    
}
