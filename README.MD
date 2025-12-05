# 🚀 Portfolio API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Java](https://img.shields.io/badge/postman-%23ED8B00.svg?style=for-the-badge&logo=postman&logoColor=white)
![Azure](https://img.shields.io/badge/azure-%230072C6.svg?style=for-the-badge&logo=azure&logoColor=white)
> API RESTful robusta desenvolvida inicialmente para gerenciar dados dos meus projetos, servindo como back-end centralizado para meu portifólio, mas tambem pode ser adaptado para seu ambiente!

**🔗 [Acesse a API em Produção (Azure)](https://api-portifolio-lucasgabriel-gndaegdjdea2hfb2.brazilsouth-01.azurewebsites.net/projetos)**

>   ☝️Pode demorar para inicializar pois usei estratégias de gerenciamento para redução de custos, mas depois de inicializado, funciona normalmente.
---

## 🎯 Sobre o Projeto
Este projeto demonstra a aplicação prática de Engenharia de Software Moderna, focando em arquitetura limpa, segurança e infraestrutura em nuvem.

O objetivo foi criar uma solução escalável onde:
1.  **Leitura Pública:** Recrutadores e interfaces Front-end podem consumir os dados livremente (`GET`).
2.  **Escrita Protegida:** Apenas administradores autenticados podem gerenciar o portfólio (`POST/PUT/DELETE`).
3.  **Performance:** Otimização de dados no PostgreSQL.

## 🛠 Tech Stack
* **Core:** Java 21 & Spring Boot 4
* **Database:** PostgreSQL 17 (Gerenciado no Azure)
* **ORM:** Hibernate 7 
* **Security:** Spring Security 6
* **DevOps:** Docker, Docker Compose & GitHub Actions (CI/CD)
* **Cloud:** Microsoft Azure App Service (Linux)

## 🔐 Segurança & Arquitetura 
O sistema segue rigorosos padrões de mercado:
* **Credenciais Seguras:** Nenhuma senha está no código (hardcoded). Tudo é injetado via Variáveis de Ambiente no Azure.
* **Stateless:** A API não mantém estado de sessão, permitindo escalabilidade horizontal.
* **Autenticação:** Proteção de rotas críticas contra acesso não autorizado.

## 🚀 Como Rodar Localmente

### Pré-requisitos
* Java 21+
* Docker & Docker Compose

### Passo a Passo
```
# 1. Clone o repositório
git clone https://github.com/lucasgls/portifolio-api.git

# 2. Suba o banco de dados via Docker
docker-compose up -d

# 3. Configure as variáveis de ambiente no application.properties.example

# 4. Tranforme o application.properties.example > application.properties

# 5. Execute a aplicação
./mvnw spring-boot:run
```

## 📡 Documentação da API

| Método  | Endpoint         | Descrição            | Auth      |
|---------|-----------------|----------------------|-----------|
| `POST`  | `/projetos`      | Cria novo projeto    | 🔒 Privada |
| `PUT`   | `/projetos/{id}` | Edita projeto        | 🔒 Privada |
| `DELETE` | `/projetos/{id}` | Deleta projeto       | 🔒 Privada |
| `GET`   | `/projetos`      | Lista dos projetos   | 🔓 Pública |
| `GET`   | `/projetos{id}`      | Exibe o único projeto | 🔓 Pública |

---

### 📦 Exemplos de Uso (Payloads)

<details>
  <summary><b> JSON de Criação (POST)</b></summary>

Rota: `.../projetos`

Body de criação:

  ```json
  {
    "nome": "IAnalisador",
    "descricao": "Usa openai API para processar curriculos e requisitos de vagas e escolher melhores candidato.s",
    "tecnologias": "Python, Vite, Azure, OpenApi",
    "urlsImagem": [
      "https://foto0.png",
      "https://foto1.png)"
    ]
  }
  ```
</details>

<details>
  <summary><b> JSON de Edição (PUT)</b></summary>

Rota: `.../projetos/{id}`

Body de edição:

  ```json
  {
    "nome": "IAnalisador",
    "descricao": "Usa openai API para processar curriculos e requisitos de vagas e escolher melhores candidato.s",
    "tecnologias": "Python, Vite, Azure, OpenApi",
    "urlsImagem": [
      "https://foto1.png",
      "https://foto0.png)"
    ]
  }
  ```
</details>
