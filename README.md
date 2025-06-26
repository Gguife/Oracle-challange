# 📚 Fórum API - Challenge

## 💻 Sobre o Projeto

Este *challenge* consiste na criação de um fórum. O aplicativo deve possuir funcionalidades que permitam o cadastro de posts, incluindo:

- Título  
- Mensagem  
- Data de criação  
- Estado do tópico  
- Autor  
- Curso  

Enquanto um time de desenvolvimento será responsável pelo aplicativo mobile, o nosso será encarregado do desenvolvimento da **API REST** deste projeto.

---

## ⚙️ Funcionalidades da API

A API REST implementa as seguintes funcionalidades:

- **CRUD de posts do fórum**:
  - Criar novos posts
  - Listar todos os posts
  - Atualizar os dados de um post
  - Remover posts criados, seguindo padrões de segurança
- **Validação de dados** durante o cadastro e atualização
- **Tratamento de exceções** com mensagens claras
- **Documentação da API** com Swagger/OpenAPI *(opcional)*
- **Versionamento da API** *(opcional)*

---

## 🛠 Tecnologias Utilizadas

As seguintes tecnologias foram utilizadas no desenvolvimento da API REST do projeto:

- Java 21  
- Spring Boot 3  
- Maven  
- Docker  
- PostgreSQL  
- Hibernate  
- Flyway  
- Lombok

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

- Docker e Docker Compose instalados
- Java 21
- Maven

### Passos

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

---

## 🚀 Como Executar o Projeto
### Execute o Docker Compose para subir o banco de dados:
```bash
docker-compose up -d
```
### Execute o projeto com o Maven:
```bash
./mvnw spring-boot:run
```

### Acesse a API localmente:
```bash
http://localhost:8080
```
