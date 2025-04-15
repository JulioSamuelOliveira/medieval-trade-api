package br.com.fiap.medieval_trade_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do campeão é obrigatório")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "A classe do campeão é obrigatório")
    private ChampionRole role;

    @Min(value = 1, message = "O poder mínimo é 1")
    @Max(value = 100, message = "O poder máximo é 100")
    private int power;

    @NotNull(message = "O level é obrigatório")
    @Min(value = 1, message = "O level mínimo é 1")
    @Max(value = 99, message = "O level máximo é 99")
    private Integer level;
}
