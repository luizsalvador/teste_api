# teste_api
Projeto que valida o cadastro, edição e exclusão de um usuário, via API, utilizando como ferramenta o Rest Assured/Junit/Mavin. 

## Pré-requisitos:
JDK do java 8 -  https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html

Eclipse IDE for Java Developers - https://www.eclipse.org/downloads/packages/

## Como abrir e executar o projeto:

Após clonar o projeto do git;

Verificar se o plugin "m2" está instalado, em: help > About Eclipse; 

![image](https://user-images.githubusercontent.com/55900972/118418176-b6e46f00-b68d-11eb-9054-47551f68e4d5.png)

Importar o projeto: file > import

Selecionar o Maven > Existing maven Project 

![image](https://user-images.githubusercontent.com/55900972/118418333-6f121780-b68e-11eb-8f36-e2be186e41b8.png)

Informar a pasta onde foi clonado o repositório 

![image](https://user-images.githubusercontent.com/55900972/118418532-26a72980-b68f-11eb-8d20-42f7e7190622.png)

Para executar os testes basta clicar com o botão direito em cima da class "UsuarioTest" > Run as > JUinit Test

![image](https://user-images.githubusercontent.com/55900972/118418647-987f7300-b68f-11eb-8a77-98196591b1a8.png)


## Estrutura do projeto

src/main/java

package = comuns - onde estão localizados as class que são comuns aos testes.

package = test - onde estão localizados os cenários de testes de API.

OBS: 

Este projeto é apenas de testes de API, portanto ele está localizado na pasta "main", pois não existem os códigos da aplicação.

Os testes invocam as API do ServeRest que é um servidor REST que simula uma loja virtual - https://serverest.dev criado por Paulo Gonçalves.

![image](https://user-images.githubusercontent.com/55900972/118372190-bad99980-b586-11eb-8a42-a7f5d8550974.png)


## Objetivo do teste de API
Validar o cadastro, edição e exclusão de um usuário, via API

Existem 6 testes:

![image](https://user-images.githubusercontent.com/55900972/118373270-515c8980-b58c-11eb-99dc-dcff9c85258c.png)


test001 - Realiza o cadastro de um usuário - método: POST

test002 - Validar se o usuário foi inserido no banco - método: GET 

test003 - Realiza a edição de um usuário - método: PUT

test004 - Validar se o usuário foi editado corretamente - método: GET 

test005 - Realiza a exclusão de um usuário - método: DELETE

test006-  Validar se o usuário não está mais no banco - método: GET

![image](https://user-images.githubusercontent.com/55900972/118410196-9c49d000-b664-11eb-8251-a152f8dd8f6c.png)

Conforme são executados os cenários de testes, serão demonstrados os nomes dos usuários cadastrados, editados e excluídos.

A suíte de teste pode ser executada a qualquer momento, pois sempre será cadastrado um novo usuário e este será editado e logo após excluído. Portanto, caso ocorra a falha/erro durante a execução de algum cenário, a suíte de teste deverá ser reiniciada. Esta foi a estratégias escolhida, levando em consideração dois itens:

1° - O banco reinicia a cada 3 horas, fazendo o restore com os dados originais, portanto caso a suíte de testes falhe, os usuários serão apagados com o restore. 

2° - Os cenários foram colocados em uma só suite de teste (class), pois caso ocorra um erro na API que realiza o POST, todas as suítes falharão para o cadastro de usuário. Por este motivo foi utilizado uma única suíte e não várias suítes.

