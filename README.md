# FLISOL UFPA CAMETÁ 2022
Projeto desenvolvido para por em prática a construção e gerenciamento de projetos utilizando softwares livres e serviços gratuitos

## Softwares livres usados
- NodeJs 16.14.2 no Windows 10 ou NodeJs 12.21.0 no Windows 7 https://nodejs.org/en/
- Heroku CLI https://devcenter.heroku.com/articles/heroku-cli
- Git 2.35.3 32-bit ou 64-bit https://git-scm.com/
- PostgreSQL 12.10 https://www.enterprisedb.com/downloads/postgres-postgresql-downloads
- Postman 9.15.2 https://www.postman.com/downloads/
- Java 17 OpenJdk (Preferivel a distribuição Zulu) https://cdn.azul.com/zulu/bin/zulu17.34.19-ca-jdk17.0.3-win_x64.zip A nova licença é a Licença “Oracle No-Fee Terms and Conditions” (NFTC).  Esta licença para o Oracle JDK permite o uso gratuito para todos os usuários, mesmo de uso comercial e de produção a partir do Java 17.
- Microsoft .NET Framework 4.7.2 (para Windows 7) https://go.microsoft.com/fwlink/?LinkId=863261&clcid=0x409

## Serviços gratuitos usados
- Netlify para implantação do frontend na nuvem https://www.netlify.com/
- Heroku para provisionamento do banco de dados e backend na nuvem https://www.heroku.com/
- Heroku CLI + Git local/remoto para gerenciamento do projeto

## Construção do Projeto
- Frontend -> Html, CSS, Javascript e React
- Backend -> Java com SpringBoot, SpringDataJP e Hibernate
- Banco de Dados -> PostgreSQL

## Requisitos e ferramentas para rodar o projeto
- Java 17
- Git e GitHub para gerenciamento de repositório
- NodeJs (para win7 v12.21.0)
- Npm
- Yarn - frontend (primeiro yarn install(ou add) react-scripts e depois yarn start)
- IDE Java - backend (Recomendável Spring Tool Suite 4 (STS) ver tutorial de importação de projeto maven (Existing Maven Project))
- VS Code
## Roteiro
  ####
    1. Fazer um clone do projeto
    2. Entender rotas e configurações do banco de dados no backend
    3. Entender e configurar rotas no frontend
    4. Implantação do backend no heroku e frontend no netlify
## Configurações importantes no backend
#### Perfis de projeto para deploy no Heroku
##### application.properties
      spring.profiles.active=${APP_PROFILE:dev}
      spring.jpa.open-in-view=false
##### application-prod.properties
      spring.datasource.url=${DATABASE_URL}
##### application-dev.properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/flisolgit
      spring.datasource.username=postgres
      spring.datasource.password=admin
      spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
      spring.jpa.hibernate.ddl-auto=create
      spring.jpa.show-sql=true
      spring.jpa.properties.hibernate.format_sql=true
##### system.properties na raiz do projeto p/ Heroku identificar a versão do java usada no projeto
      java.runtime.version=17
##### HEROKU CLI
      heroku -v para ver a versão
      heroku update (para atualizar)
      heroku login para fazer login com a conta Heroku criada
      heroku git:remote -a <nome-do-app-no-heroku> para associar com o repo local
      git remote -v para ver as associações com o github e com heroku
      git subtree push --prefix backend heroku main para fazer a implantação somente a pasta backend do projeto
##### Link do Banco de dados no PostgreSQL
      postgres://usuario:senha@host/ip/endereço:porta/nomedabasededados
## Configurações importantes no frontend
#### Implantação frontend Netlify
##### Deploy
      Definir BASE_URL para o link do APP no HEROKU
      Base directory: frontend
      Build command: yarn build
      Publish directory: frontend/build
      Site settings -> Domain Management: (colocar o nome que você quiser)
      Deploys -> Trigger deploy