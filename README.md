### Apresentação
  
<p float="left">
<img src="https://tulioalbu.github.io/typewriter_repositorio_de_artigos/Screenshots/Screenshot_20221029_214804.png" width = "140">


Typewriter é um aplicativo para Android Nativo que consome uma API de CRUD de artigos. O código foi construído utilizando conceitos da Arquitetura MVVM (Model-View-ViewModel) e foram utilizadas duas bibliotecas: Retrofit2 para a conexão com a API e o Room para a persistência de dados locais. O layout foi construído em XML.

### Tecnologias utilizadas: 

Kotlin
<div>
XML
<div>
Retrofit2
<div>
Room
<div>
Arquitetura MVVM

### Tela Inicial 

<p float="left">
<img src="https://tulioalbu.github.io/typewriter_repositorio_de_artigos/Screenshots/Screenshot_20221029_214828.png" width = "140">
<img src="https://tulioalbu.github.io/typewriter_repositorio_de_artigos/Screenshots/Screenshot_20221029_215454.png" width = "140">

Após a exibição da tela de Splash Screen, é aberta a Main Activity, onde são exibidas as notícias conseguidas através do GET request na API. Durante o processo de loading ou caso não existam dados cadastrados, o app exibe a mensagem de que não existem artigos para exibir.

O layout da Main Activity exibe uma Recycler View que com inúmeros card views que mostram Título, Resumo e Autor do Artigo, além de um botão para deletar a notícia. O Float Action Button leva para a activity de cadastro de notícias.

### Tela de Cadastro de Artigos

<p float="left">
<img src="https://tulioalbu.github.io/typewriter_repositorio_de_artigos/Screenshots/Screenshot_20221029_214842.png" width = "140">
<img src="https://tulioalbu.github.io/typewriter_repositorio_de_artigos/Screenshots/Screenshot_20221029_215335.png" width = "140">

Esta atividade permite com que o usuário cadastre artigos na API. Nesta tela existem vários elementos de validação seguindo as regras de negócio da aplicação. Os dois primeiros campos possuem contagem e limitação de caracteres, já que o limite é de 70 para o título e 100 para o resumo. No texto não há limite de dígitos. 

Caso o usuário deseje recomeçar a escrever o texto, é possível tocar no EndIcon que permite apagar o que já foi escrito. Para voltar à Main Activity, basta clicar no icon "X" no canto superior esquerdo da tela. O botão "Confirm" salva o que foi escrito na API através de um POST Request.

### Outras validações e mensagem de sucesso

<img src="https://tulioalbu.github.io/typewriter_repositorio_de_artigos/Screenshots/Screenshot_20221029_215131.png" width = "140">
<img src="https://tulioalbu.github.io/typewriter_repositorio_de_artigos/Screenshots/Screenshot_20221029_215540.png" width = "140">

Ainda existem outras validações nesta activity. Caso o usuário digite menos de 30 caracteres no campo de título, de 50 no de resumo e/ou 200 no de texto, o EndIcon do EditText mostra uma exclamação vermelha e não é possível submeter o artigo. Da mesma forma, caso um dos campos esteja vazio, o primeiro deles mostra uma mensagem alertando o usuário.

Caso todas as validações ocorram, o artigo é salvo com sucesso e um toast é exibido na Main Activity.

### Tela de Detalhes
  
<img src="https://github.com/tulioalbu/typewriter_repositorio_de_artigos/blob/main/Screenshots/Screenshot_20221029_215147.png" width = "140">

Ao clicar em uma das notícias da lista na main activity, o usuário é direcionado para uma página de detalhes do artigo, onde é exibido o título, o autor, o texto e a data de registro. 

Caso deseje voltar para página inicial, basta clicar no ícone "X" no canto superior esquerdo da tela. 
