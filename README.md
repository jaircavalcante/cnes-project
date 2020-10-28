# Projeto

Utilizando boas práticas de desenvolvimento no software, crie uma aplicação para ler e apresentar dados do Cadastro Nacional de Estabelecimentos de Saúde (CNES) no Brasil.
Fonte dos dados: http://dados.gov.br/dataset/cnes_ativo

O Sistema deve conter três visões:
>    1. Lista de CNES;
>    2. CNES por tipos;
>    3. CNES por Estado;

### CNES-API:
API criada utilizando Spring, Banco de dados H2 e Swagger.

1. Importar Projeto Maven em sua IDE de preferência
2. Realizar update nas dependências do maven
3. Executar a App.java

- Acesso ao banco de dados: http://localhost:8080/api/h2
- Acesso ao Swagger da api: http://localhost:8080/api/swagger-ui.html#/

O Arquivo disponivel no link descrito acima poderá ser importado na base e consultado os seus respectivos
registros via CNES-WEB.

### CNES-WEB.
Plataforma web criada utilizando Angular.

1 - Instalação do Node.js, caso não tenha instalado em sua máquina.
Download do instalador do Node.js. Prefira sempre a versão LTS

2 - Instalação do Angular, caso não tenha instalado em sua máquina.
Após baixar o nome(item 1), abrir o prompt do Node e executar o comando: 
>npm install -g @angular/cli@latest

3. Na pasta raiz do projeto executar o comando abaixo para atualizar as dependências:
> npm update

4. Para rodar o projeto usar o comando:
> ng serve



