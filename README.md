# teste_API
Projeto que valida o cadastro, edição e exclusão de um usuário, via API, utilizando como ferramenta o Rest Assured/Junit. 

# Pré-requisitos:
JDK do java 8 -  https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html

Eclipse IDE for Java Developers - https://www.eclipse.org/downloads/packages/

# Estrutura do projeto

src/main/java

package = comuns - onde estão localizados as classe que são comuns aos testes.

package = test - onde estão localizados os cenários de testes de API.

OBS: 

Este projeto é apenas de testes de API, portanto ele está localizado na pasta "main", pois não existe os codidos da aplicação.

Os testes invocam as API do ServeRest que é um servidor REST que simula uma loja virtua - https://serverest.dev criado por Paulo Gonçalves.

![image](https://user-images.githubusercontent.com/55900972/118372190-bad99980-b586-11eb-8a42-a7f5d8550974.png)


# Objetivo do teste de API
Validar o cadastro, edição e exclusão de um usuário, via API

Exitem 6 testes:

![image](https://user-images.githubusercontent.com/55900972/118373270-515c8980-b58c-11eb-99dc-dcff9c85258c.png)


test001 - Realiza o cadastro de um usuário - método: POST

test002 - Valida se o usuário foi inserido no banco - método: GET 

test003 - Realiza a edição de um usuário - método: PUT

test004 - Valida se o usuário foi editado corretamente - método: GET 

test005 - Realiza a exclusão de um usuário - método: DELETE

test006-  Valida se o usuário não está mais no banco - método: GET

![image](https://user-images.githubusercontent.com/55900972/118410196-9c49d000-b664-11eb-8251-a152f8dd8f6c.png)

Conforme são executados os cenários de testes, serão demonstrados os nomes dos usuários cadastrados, editados e excluídos.

A suíte de teste pode ser executada a qualquer momento, pois sempre será cadastrado um novo usuário e este será editado e logo após excluído. Portanto, caso ocorra a falha/erro durante a execução de algum cenário, a suíte de teste deverá ser reiniciada. Esta foi a estratégias escolhida, levando em consideração dois itens:

1° - O banco reinicia a cada 3 horas, fazendo o restore com os dados originais, portanto caso a suíte de testes falhe, os usuários serão apagados com o restore. 

2° - Os cenários foram colocados em uma só suite de teste (class), pois caso ocorra um erro na API que realiza o POST, todas as suítes falharão para o cadastro de usuário. 

