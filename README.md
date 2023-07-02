# Tech challenge

## Documentação das APIs

### Servidor local
`http://localhost:8080`

### Endereços
O endpoint tem como objetivo cadastrar novos endereços em nosso sistema. 

```http
POST /api/enderecos
```

### body

```json
{
  "cidade": "string",
  "estado": "string",
  "numero": "string",
  "bairro": "string",
  "rua": "string",
  "cep": "string"
}
```

### response

```json
{
  "cidade": "string",
  "estado": "string",
  "numero": "string",
  "bairro": "string",
  "rua": "string",
  "cep": "string"
}
```

### Descrição de cada campo
| campo | descrição |
| :--- | :--- |
| cidade | `nome da cidade` |
| estado | `nome do estado` |
| numero | `número da residência` |
| bairro | `nome do bairro` |
| rua | `nome da rua` |
| cep | `formato permitido: 00000-000` |

## Gestão de pessoas
O endpoint tem como objetivo fazer o cadastro dos usuários em nosso sistema

```http
POST /api/pessoas
```

Segue abaixo o body que deve ser enviado se a pessoa não tiver dependentes, e o response com dependentes retornando `null`
### body
```json
{
  "nome": "string",
  "nascimento": "string (ano-mes-dia)",
  "genero": "string",
  "cpf": "string (000.000.000-00 ou 00000000000)"
}
```


### response
```json
{
  "cpf": "string",
  "nome": "string",
  "nascimento": "string",
  "genero": "string",
  "dependentes": null,
  "dataDeCadastro": "string"
}
```

Segue abaixo o body que deve ser enviado com todos os dependentes da pessoa, e o response retornando todos os dados dos dependentes
### body
```json
{
  "nome": "string",
  "nascimento": "string (ano-mes-dia)",
  "genero": "string",
  "cpf": "string (000.000.000-00 ou 00000000000)",
  "dependentes": [{
    "nome": "string",
    "nascimento": "ano-mes-dia",
    "genero": "string",
    "cpf": "string (000.000.000-00 ou 00000000000)"
  }]
}
```

### response
```json
{
  "cpf": "string (000.000.000-00 ou 00000000000)",
  "nome": "string",
  "nascimento": "string (ano-mes-dia)",
  "genero": "string",
  "dependentes": [{
    "cpf": "string (000.000.000-00 ou 00000000000)",
    "nome": "string",
    "nascimento": "string (ano-mes-dia)",
    "genero": "string"
  }],
  "dataDeCadastro": "ano-mes-dia"
}
```

### Descrição de cada campo
| campo | descrição |
| :--- | :--- |
| nome | `nome` |
| data | `formato permitido: ano-mes-dia` |
| genero | `genero` |
| cpf | `formato permitido: 000.000.000-00 ou 00000000000 (sem pontos ou traço)` |
| dependentes | `dependentes de pessoa` |
| dataDeCadastro | `Data em que a pessoa foi cadastrada em nosso sistema` |

## Eletrodomésticos
O endpoint tem como objetivo cadastrar os eletrodomésticos dos usuários em nosso sistema

```http
POST /api/eletrodomesticos
```

### body
```json
{
  "nome": "string",
  "modelo": "string",
  "potencia": "number",
  "volts": "number",
  "marca": "string",
  "eficienciaEnergetica": {
    "classificacao": "string",
    "consumoEnergetico": "number",
    "porcentagemDeEconomia": "number"
  }
}
```

### response
```json
{
  "nome": "string",
  "modelo": "string",
  "potencia": "number",
  "volts": "number",
  "marca": "string",
  "eficienciaEnergetica": {
    "consumoEnergetico": "number",
    "classificacao": "string",
    "porcentagemDeEconomia": "number"
  },
  "dataDeCadastro": "string"
}
```

### Descrição de cada campo
| campo | descrição |
| :--- | :--- |
| nome | `nome` |
| modelo | `modelo` |
| potencia | `potência em watts do aparelho, por exemplo: 1800, 300, 600` |
| volts | `voltagem utilizada para ligar o aparelho, por exemplo: 220, 110, 127 etc...` |
| marca | `marca` |
| classificacao | `A letra que está relacionada ao aparelho na tabela de de eficiência energetica do Inmetro, só será permitido uma das seguintes classificações: A, B, C, D, E, F ou G` |
| consumoEnergetico | `consumo energético (KWh/mês) que está inserido na tabela de eficiência energetica do Inmetro` |
| porcentagemDeEconomia | `Porcentagem de economia do aparelho, por exemplo 10, 20, 30. Esse campo é utilizado para os modelos fabricados antes de 2021`
| dataDeCadastro | `Data em que foi cadastrado o eletrodoméstico` | 

## Ferramentas e tecnologias utilizadas
Java versão 17: Por ser LTS (Long Term Support) consigo utilizar os recursos mais recentes do spring framework. Com a versão 17 também posso utilizar alguns recursos interessantes que podem ser úteis na continuidade do curso, como por exemplo Sealed Classes.

Spring versão 3.1.0: Versão mais recente do spring que tiveram algumas atualizações interessantes, como por exemplo auto-configuration do Spring Autorization Server, e também já é possível a utilização do spring data 2023.0

Maven versão 3.8.6: Como gerenciador de dependências

spring-boot-starter-validation: Para fazer todas as validações necessárias na entrada das requisições dos endpoints.

spring-boot-starter-web: Essa dependência nos traz inúmeras facilidades, como por exemplo trabalhar com aplicações RestFull.

spring-boot-devtools: Atualizações liveReload durante o desenvolvimento do projeto


## Desafios encontrados durante o desenvolvimento e as soluções desenvolvidas

#### Campo de dataDeCadastro para a API de pessoas
Inclui esse campo porque será importante para uma equipe de marketing que deseja fazer campanhas para clientes que estão utilizando os nossos serviços há 1 ano, por exemplo. 
Ou também será útil para entendermos quanto tempo cada cliente passa utilizando os nossos serviços.

#### Entendimento das informações relacionadas aos eletrodomésticos que os usuários precisariam para analisar o quanto de energia cada aparelho consome.

Os requisitos mínimos para completar o endpoint de eletrodomésticos, deveria conter os seguintes campos: `nome`, `modelo` e `potencia`, porém como 
teríamos a liberdade de adicionar outras informações a nossa classe, adicionei mais 4 campos que na minha opinião são relevantes para um melhor entendimento
de quanto cada aparelho consome de energia elétrica.

Segue abaixo cada campo extra e a descrição do motivo pelo no qual adicionei

  1° `volts`: Cada região utiliza uma voltagem diferente para ligar seus eletrodomésticos, ela pode ser 110 ou 220 volts, portanto adicionar essa voltagem em nosso sistema pode ser importante
  para uma análise futura do consumo energético.
  
  2° `marca`: Dependendo da marca e da qualidade das peças que compõem os eletrodomésticos, ele pode consumir muita ou pouca energia elétrica, então quando o usuário for trocar de aparelho por qualquer
 motivo, ele pode optar por escolher outra marca ou permanecer com a mesma, porque ele já tem todo um histórico de consumo dos aparelhos relacionados aquela marca. 
  
  3° `eficienciaEnergetica`: Todos os eletrodomésticos que compramos vem com uma tabela de eficiência energética do Inmetro, então o usuário poderá comparar a eficiẽncia energética que está indicando na etiqueta com o que está sendo calculada pelo sistema.
  Para fazer a modelagem da classe `EficienciaEnergetica`, precisei adicionar o tipo `Enum` para o campo `classificacao`. Adicionei esse tipo porque as letras da tabela de eficiência energetica são fixas e raramente sofrem com alterações (última alteração foi realizada no ano de 2021), e também vai trazer clareza aos desenvolvedores que tiverem fazendo alterações no modelo de `Eletrodomesticos` ou consumindo a API. Para conseguir extrair essas informações e modelar a minha classe, tive que consultar a documentação oficial disponibilizada no [programa brasileiro de etiquetagem](https://www.gov.br/inmetro/pt-br/assuntos/avaliacao-da-conformidade/programa-brasileiro-de-etiquetagem). 
  O campo `porcentagemDeEconomia` é utilizado para aqueles aparelhos fabricados antes de 2021, no qual a tabela de eficiência energética era de um formato diferente do atual. 

  
  4° `dataDeCadastro`: Com o passar do tempo as peças vão se deteriorando e podem consumiar mais energia. Então o usuário poderá verificar o aumento ou não do consumo de energia do aparelho com o passar dos anos.

#### Capturar execptions com o `RestControllerAdvice` do spring

Para capturar as exceptions e retornar o status code e a mensagem correta caso o consumidor da api enviasse um campo faltante ou com um tipo incorreto, eu poderia fazer essa verificação no próprio controller mas optei por criar duas classes `ErroForm` e `ValidacaoHandler` para capturar cada exception e retornar a mensagem e o status code corretos ao consumidor. 
Dentro da classe `ValidacaoHandler` adicionei os métodos com as Exceptions que gostaria de capturar e as mensagens personalizadas, para que o consumidor consiga entender o motivo que ocasionou aquele erro.


#### Validação de CPF
Para validar o CPF optei por utilizar as anotações do hibernate ao invés de criar uma classe personalizada com as regras necessárias para validação do CPF.

## Exemplo de requisições das APIs

[documentação](https://documenter.getpostman.com/view/23405037/2s93zCXztZ)

