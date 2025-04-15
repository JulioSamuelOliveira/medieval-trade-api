package br.com.fiap.medieval_trade_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "campo obrigatorio")
    private String name;

    @Enumerated(EnumType.STRING)
    private ChampionRole role;

    @Min(value = 1, message = "O level mínimo é 1")
    @Max(value = 99, message = "O level máximo é 99")
    private int level;

    @Min(value = 0, message = "Moedas não podem ser negativas")
    private Integer coin;

}
