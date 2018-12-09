# Descrição

Projeto de exemplo de uma API REST criada em Spring com Spring Boot e JPA.

O projeto é um pequeno blog onde podem ser inseridos artigos.

Estes artigos têm Status, Categorias e Tags. 

## DB
O Banco utilizado é o PostgreSQL e existe um arquivo docker-compose.yml no diretório db_teste
para poder rodar um banco localmente.

A criação das tabelas é feita de forma automática pelo Hibernate.

## Rodando
Para rodar bastar executar o comando maven

`mvn clean install`

e depois 

`java -jar %NOME_JAR_GERADO%`.
