# API Internet-Banking

## Internet-Banking
Projeto responsável de operações com internet-banking (saque/deposito).

## Descrição
Aplicação responsável por criar uma simulação de um internet-banking.

## Funcionalidades
O Internet-Banking recebe valores a serem sacados e ou depositados e com base nisso aplica-se uma taxa de 1% ou 0.4% a
depender de quanto o correntista deseja sacar.

## Tecnologias
- Java v17
- Springboot v3.0.7
- Maven v3.9
- H2

## Requisitos
- JDK v17

## Inicialização
### Docker
1 - Construa a imagem no seu docker:
```bash
docker build . -t internet-banking
```
2 - Inicializar a imagem na porta 8080:
```bash
docker run --name internet-banking -p 8080:8080 -d internet-banking
```
3 - Acesse a api em <a href="http://localhost:8080/swagger-ui/index.html#/" target="_blank">http://localhost:8080/swagger-ui/index.html
### Local
1 - Construa seu projeto no maven:
```bash
mvn clean install -U
```
2 - Importe o seu projeto no eclipse ou intelliJ
3 - Inicializar o arquivo CalculatorPyhtagorasApplication
4 - Acesse a api em <a href="http://localhost:8080/swagger-ui/index.html#/" target="_blank">http://localhost:8080/swagger-ui/index.html

## Colaboradores
Vinicius Torres Pascucci <a href="https://github.com/viniciuspascucci1993" target="_blank">LinkedIn</a>

## Status do Projeto
Concluído.
