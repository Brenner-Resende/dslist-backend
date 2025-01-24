# Game Catalog API

Este projeto é uma API web desenvolvida para gerenciar catálogos de jogos. Foi construído com Java e Spring Boot, utilizando boas práticas como o padrão REST, estruturação em camadas, uso de DTOs, e suporte a ambientes de desenvolvimento e produção com Docker e CI/CD.

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java 21
- **Framework**: Spring Boot
- **Banco de Dados**: PostgreSQL
- **Gerenciamento de Dependências**: Maven
- **Containerização**: Docker e Docker Compose
- **Controle de Versões**: Git
- **Integração e Deploy Contínuos**: CI/CD

---

## ✨ Funcionalidades

- **CRUD de jogos**: Permite criar, listar, atualizar e excluir jogos no catálogo.
- **Organização de listas de jogos**: Relacionamentos N-N com classe de associação e `@EmbeddedId`.
- **Database Seeding**: População inicial automatizada de dados.
- **Projeções**: Consultas SQL otimizadas no Spring Data JPA para operações específicas.
- **Configuração de CORS**: Suporte para acesso seguro entre origens diferentes.

---

## 🔍 Estrutura do Projeto

A estrutura foi baseada no **padrão em camadas**, organizada da seguinte forma:

- **Controller**: Responsável por lidar com as requisições HTTP.
- **Service**: Contém a lógica de negócios.
- **Repository**: Comunicação com o banco de dados usando Spring Data JPA.
- **DTO (Data Transfer Object)**: Utilizado para transferir dados entre as camadas da aplicação.

---

## 📂 Estrutura de Classes e Relacionamentos

### Entidades Principais

#### Game

	@Entity
	@Table(name = "tb_game")
	public class Game { ... }

#### GameList
	@Entity
	@Table(name = "tb_game_list")
	public class GameList { ... }
#### Belonging
	@Entity
	@Table(name = "tb_belonging")
	public class Belonging { ... }
- Relacionamento N-N entre Game e GameList, utilizando uma classe de associação Belonging com @EmbeddedId para representar a chave composta.

## 🗂️ Consultas SQL e Projections
A aplicação utiliza o Spring Data JPA para realizar consultas otimizadas, como buscar jogos associados a uma lista específica:

	@Query("SELECT new com.example.dto.GameMinProjection(g.id, g.title) FROM Game g WHERE g.list.id = :listId")
	List<GameMinProjection> searchByList(Long listId);
	
As projections foram utilizadas para retornar apenas os dados necessários, reduzindo o overhead de dados trafegados.

## ⚙️ Configuração e Execução
### Requisitos
- Docker e Docker Compose instalados
- Java 17 instalado
- Maven instalado

### Passos
- Clone o repositório:

	git clone https://github.com/seu-usuario/game-catalog-api.git
	
- Configure os perfis de ambiente (application-local.properties e application-prod.properties).

- Suba os serviços com Docker Compose:

	docker-compose up -d
	
- Acesse a API em http://localhost:8080.

## 🚀 Deploy com CI/CD
Foi implementado um pipeline de CI/CD utilizando o Railway, que realiza:

- Testes automatizados
- Build e geração de imagens Docker
- Deploy automático no ambiente configurado

## 📖 Aprendizados e Boas Práticas
- **Estruturação REST:** Construção de endpoints seguindo os padrões de nomenclatura RESTful.
- **Padrão DTO:** Abstração das entidades para evitar vazamento de informações sensíveis.
- ** Relacionamentos complexos:** Implementação de relacionamentos N-N com classe de associação e chave composta.
- **Ambientes Dockerizados:** Facilitação de homologação local e deploy em produção.
- **Configuração de CORS:** Permissão de acessos externos de forma segura.

## 📞 Contato
Para dúvidas ou sugestões, entre em contato:

- Autor: Brenner Resende Borges
- E-mail: brenner.resende20@gmail.com
- LinkedIn: <https://www.linkedin.com/in/brenner-resende-borges-68733b243/>
