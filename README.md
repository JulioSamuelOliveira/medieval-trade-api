# 🏰 API - Mercado Medieval

Este projeto é uma API RESTful desenvolvida em **Java**, que simula um **mercado medieval**, onde personagens podem cadastrar, comprar, vender e trocar **itens mágicos** como espadas encantadas, elixires, grimórios, mantos de invisibilidade, entre outros.

## 📦 Funcionalidades

- Cadastro de personagens (Champion)
- Cadastro de itens mágicos (Item)
- Compra, venda e troca de itens
- Filtros de busca por tipo, raridade e nível dos itens
- Validações de entrada com Jakarta Bean Validation
- CRUD completo para personagens e itens

## 🧙‍♂️ Classes Principais

### 🧑 Champion
Representa um personagem do universo medieval.

Campos:
- `id` (Long)
- `nome` (String)
- `classe` (String) → apenas valores específicos (ex: GUERREIRO, MAGO, ARQUEIRO)
- `level` (int) → entre 1 e 99
- `moedas` (Integer) → não pode ser negativo

### 🪄 Item
Representa um item mágico negociável.

Campos:
- `id` (Long)
- `nome` (String)
- `tipo` (String) → apenas valores específicos (ex: ARMA, ARMADURA, POÇÃO, ACESSÓRIO)
- `raridade` (String) → comum, raro, épico, lendário
- `preco` (BigDecimal) → não pode ser negativo
- `dono` (Champion)

### 🔍 Filtros de Busca
- Buscar itens por tipo
- Buscar por raridade
- Buscar por nível mínimo/máximo do personagem

## 🚀 Tecnologias Utilizadas

- Java 17+
- Jakarta EE / Jakarta Persistence (JPA)
- Jakarta Validation (Bean Validation)
- JAX-RS (para os endpoints REST)
- Banco de dados relacional (ex: H2, PostgreSQL)
- Maven ou Gradle (build)

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/JulioSamuelOliveira/medieval-trade-api.git
   cd medieval-trade-api
