# Backend - Gestão Acadêmica

Bem-vindo à seção do backend do projeto Gestão Acadêmica! Este é um projeto desenvolvido com Spring Boot.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- [Java](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) (versão 1.8) - **Obrigatório**
- [Maven](https://maven.apache.org/download.cgi) (versão 3.9.1)
- [MySQL](https://downloads.mysql.com/archives/community/) (versão 8.0.30)

## Instalação

1. **Clone o Repositório**: Comece clonando este repositório para a sua máquina local.

   ```bash
   git clone https://github.com/rhuathiago/gestaoacademica-back.git
   ````

2. **Configuração do Banco de Dados**: Antes de rodar o projeto, certifique-se
   de que você tenha uma conexão MySQL localmente na porta 3306.
   Você também precisa ter um usuário e uma senha "root".


3. **Navegue para o Diretório do Projeto**: Entre no diretório do projeto clonado usando o seguinte comando:

```bash
cd gestaoacademica-api
````

4. **Instale as Dependências**: Instale as dependências do projeto usando o comando maven seguinte:

```bash
mvn clean install
````

## Executando a aplicação
Agora que todas as dependências estão instaladas, você pode rodar a aplicação localmente.

1. **Iniciando o servidor**: Para iniciar o servidor, execute o seguinte comando:

```bash
mvn spring-boot:run
````

2. **Acessando a aplicação**: Abra o seu navegador e acesse http://localhost:4200/ caso esteja rodando o frontend ou acesse http://localhost:8080/ por alguma aplicação para testes de API.
