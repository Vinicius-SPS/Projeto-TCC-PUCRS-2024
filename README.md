# Projeto de Desenvolvimento Tecnológico para o Curso de Desenvolvimento Fullstack da PUCRS

## Descrição
Esse é o projeto de desenvolvimento tecnológico para o Curso de Desenvolvimento Fullstack da PUCRS. A versão atual a ser entregue representa um MVP do projeto com algumas das funcionalidades essenciais 
para a utilização.


## Objetivo do Projeto e Público alvo
O objetivo do projeto é entregar uma solução tecnológica que visa facilitar jogadores casuais e competitivos a encontrarem outras pessoas para jogarem juntos.

## Funcionalidades Entregues
Essa versão do MVP está entregando:
  1. Login
  2. Cadastro de usuário
  3. Criação de perfil
  4. Busca por usuário
  5. Chat
  6. Recuperação de senha

## Requisitos 
Para a aplicação funcionar, é preciso criar um novo projeto no Firebase, habilitar os serviços Firebase Authentication e o Firestore Database. No Firestore Database, é preciso editar as Regras do banco de dados para hablitar a escrita e edição de dados. Para isso, é preciso utilizar o seguinte trecho:
```
rules_version = '2';

service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, write: if true;
    }
  }
}

```
Por fim, é preciso adicionar o projeto android ao projeto no Firebase, baixar o google-services.json e colocá-lo na pasta app no projeto android.
