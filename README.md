# 💰 pf-finance-service

**pf-finance-service** é um microserviço do sistema **Pink Finance**, responsável pelo gerenciamento de **transações financeiras**, como **receitas** e **despesas**. O projeto é desenvolvido com **Spring Boot** e segue a arquitetura de microsserviços, com foco em escalabilidade e manutenibilidade.

Este projeto é desenvolvido pela equipe **Budget Boys**, uma empresa fictícia criada para fins acadêmicos em um projeto de faculdade.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.5
- Spring Data JPA
- Spring Data REST
- Spring Actuator
- Hibernate Validator
- Lombok
- MapStruct
- MySQL
- Docker

---

## 🗂️ Estrutura do Projeto

- `src/main/java`: Código-fonte principal da aplicação.
- `src/test/java`: Testes automatizados.
- `resources/application.properties`: Configurações padrão da aplicação.
- `pom.xml`: Arquivo de configuração do Maven.

---

## ⚙️ Configuração

Antes de rodar a aplicação, crie um arquivo `.env` na raiz do projeto com as seguintes variáveis de ambiente:

```env
DB_USER=
DB_PASSWORD=
DB_NAME=
DB_HOST=
SPRING_PORT=
```

--- 

## 📦 Docker

Os arquivos do Docker já estão no repositório do projeto. É apenas necessário compilar o projeto Maven antes de subir para o container.

Compilar Maven
```
mvn clean package 
```

Subir para container
```
docker-compose up --build
```
