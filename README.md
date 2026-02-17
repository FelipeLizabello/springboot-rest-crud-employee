# 🏢 Employee Management API

API REST para gerenciamento de funcionários desenvolvida com Spring Boot, demonstrando uma arquitetura em camadas completa com operações CRUD.

## 💡 Visão Geral

Este projeto implementa uma API RESTful robusta para gerenciar informações de funcionários em uma organização. A aplicação segue as melhores práticas do Spring Boot, utilizando uma arquitetura em camadas bem definida e integrando-se com banco de dados MySQL através do Spring Data JPA.

## ✨ Funcionalidades

### Gestão Completa de Funcionários

A API permite realizar todas as operações essenciais para gerenciar o cadastro de funcionários:

- **Cadastro de Funcionários**: Registrar novos funcionários no sistema com informações completas
- **Consulta Individual**: Buscar dados específicos de um funcionário por ID
- **Listagem Completa**: Obter lista de todos os funcionários cadastrados
- **Atualização de Dados**: Modificar informações de funcionários existentes
- **Remoção de Registros**: Excluir funcionários do sistema

### Características Técnicas

- **API RESTful**: Endpoints seguindo os princípios REST com métodos HTTP apropriados
- **Persistência de Dados**: Integração com MySQL usando JPA/Hibernate
- **Validação de Dados**: Garantia de integridade dos dados inseridos
- **Respostas Padronizadas**: Retorno em formato JSON
- **Hot Reload**: Desenvolvimento ágil com Spring Boot DevTools

## 🏗️ Arquitetura

O projeto segue uma **arquitetura em camadas** (Layered Architecture) que separa responsabilidades e facilita a manutenção:

```
┌─────────────────────────────────────┐
│     Controller Layer                │  ← Endpoints REST
│  (Recebe requisições HTTP)          │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│     Service Layer                   │  ← Lógica de negócio
│  (Regras e validações)              │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│     Repository Layer                │  ← Acesso a dados
│  (Comunicação com BD)               │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│     MySQL Database                  │  ← Persistência
└─────────────────────────────────────┘
```

### Camadas da Aplicação

**1. Controller (Camada de Apresentação)**
- Expõe os endpoints REST
- Recebe e valida requisições HTTP
- Retorna respostas formatadas em JSON
- Gerencia códigos de status HTTP apropriados

**2. Service (Camada de Negócio)**
- Contém a lógica de negócio da aplicação
- Realiza validações complexas
- Orquestra operações entre diferentes repositories
- Independente do protocolo de comunicação

**3. Repository (Camada de Dados)**
- Abstrai o acesso ao banco de dados
- Utiliza Spring Data JPA para operações CRUD
- Queries customizadas quando necessário
- Gerencia transações com o banco

**4. Entity (Camada de Modelo)**
- Define a estrutura dos dados (Employee)
- Mapeia entidades para tabelas do banco
- Relacionamentos entre entidades

## 🔌 API Endpoints

A API oferece os seguintes recursos:

| Método | Endpoint | Descrição | Resposta |
|--------|----------|-----------|----------|
| `GET` | `/api/employees` | Lista todos os funcionários | Array de funcionários |
| `GET` | `/api/employees/{id}` | Busca funcionário específico | Objeto funcionário |
| `POST` | `/api/employees` | Cria novo funcionário | Funcionário criado |
| `PUT` | `/api/employees/{id}` | Atualiza funcionário | Funcionário atualizado |
| `DELETE` | `/api/employees/{id}` | Remove funcionário | Status 204 No Content |

### Modelo de Dados

```json
{
  "id": 1,
  "firstName": "João",
  "lastName": "Silva",
  "email": "joao.silva@empresa.com"
}
```

## 🛠️ Stack Tecnológica

**Backend Framework**
- Spring Boot 4.0.2
- Spring Web MVC - Criação de APIs REST
- Spring Data JPA - Persistência e ORM

**Banco de Dados**
- MySQL - Banco relacional
- Hibernate - ORM

**Build & Runtime**
- Java 25
- Maven - Gerenciamento de dependências

**Desenvolvimento**
- Spring Boot DevTools - Hot reload e produtividade

## 🎯 Casos de Uso

### 1. Sistema de RH
Gerenciar cadastro de funcionários, mantendo informações atualizadas e acessíveis

### 2. Diretório Corporativo
Servir como backend para um diretório de funcionários da empresa

### 3. Sistema de Onboarding
Integrar com processos de admissão de novos colaboradores

### 4. Aprendizado
Demonstrar implementação de API REST com Spring Boot seguindo boas práticas

## 📊 Padrões e Práticas

- **REST API Design**: Utilização correta de verbos HTTP e status codes
- **Separation of Concerns**: Responsabilidades bem divididas entre camadas
- **Dependency Injection**: Acoplamento fraco através de injeção de dependências do Spring
- **Convention over Configuration**: Convenções do Spring Boot para configuração mínima
- **Repository Pattern**: Abstração do acesso a dados

## 🔄 Fluxo de uma Requisição

```
1. Cliente faz requisição HTTP → Controller
2. Controller valida dados → Service
3. Service aplica regras de negócio → Repository
4. Repository executa query → Database
5. Database retorna dados → Repository
6. Repository retorna entidade → Service
7. Service processa resultado → Controller
8. Controller serializa para JSON → Cliente
```

## 💻 Tecnologias Base

- **Spring Boot**: Framework que simplifica desenvolvimento Java
- **Spring Data JPA**: Abstração para persistência de dados
- **Hibernate**: Implementação JPA para mapeamento objeto-relacional
- **MySQL Connector**: Driver JDBC para conexão com MySQL
- **Maven**: Automação de build e gerenciamento de dependências

---

**Desenvolvido por:** [Felipe Lizabello](https://github.com/FelipeLizabello)

**Stack:** Java • Spring Boot • MySQL • REST API