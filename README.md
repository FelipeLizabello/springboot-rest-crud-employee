# 🏢 Employee Management API

API REST para gerenciamento de funcionários desenvolvida com Spring Boot, demonstrando uma arquitetura em camadas completa com operações CRUD.

## 💡 Visão Geral

Este projeto implementa uma API RESTful robusta para gerenciar informações de funcionários em uma organização. A aplicação segue as melhores práticas do Spring Boot, utilizando uma arquitetura em camadas bem definida e integrando-se com banco de dados MySQL através do Spring Data JPA.

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

## 🔌 API Endpoints

A API oferece os seguintes recursos:

| Método | Endpoint | Descrição | Resposta |
|--------|----------|-----------|----------|
| `GET` | `/api/employees` | Lista todos os funcionários | Array de funcionários |
| `GET` | `/api/employees/{id}` | Busca funcionário específico | Objeto funcionário |
| `POST` | `/api/employees` | Cria novo funcionário | Funcionário criado |
| `PUT` | `/api/employees/{id}` | Atualiza funcionário | Funcionário atualizado |
| `DELETE` | `/api/employees/{id}` | Remove funcionário | Status 204 No Content |
``

## 💻 Tecnologias Base

- **Spring Boot**: Framework que simplifica desenvolvimento Java
- **Spring Data JPA**: Abstração para persistência de dados
- **Hibernate**: Implementação JPA para mapeamento objeto-relacional
- **MySQL Connector**: Driver JDBC para conexão com MySQL
- **Maven**: Automação de build e gerenciamento de dependências

---

**Stack:** Java • Spring Boot • MySQL • REST API
