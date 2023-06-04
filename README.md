# Tech challenge

## Endereços
O endpoint tem como objetivo gerenciar o endereços cadastrados em nosso sistema. 

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

| campo | descrição |
| :--- | :--- |
| cidade | `nome da cidade` |
| estado | `nome do estado` |
| numero | `número da residência` |
| bairro | `nome do bairro` |
| rua | `nome da rua` |
| cep | `00000-000` |

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



## Gestão de pessoas
O endpoint tem como objetivo fazer o cadastro e gerenciar os usuários que acessam o nosso sistema

```http
POST /api/pessoas
```
### body

```json
{
  "nome": "string",
  "data": "ano-mes-dia",
  "genero": "string",
  "cpf": "string"
}
```

| campo | descrição |
| :--- | :--- |
| nome | `nome` |
| data | `ano-mes-dia` |
| genero | `genero` |
| cpf | `000.000.000-00` |

### response
```json
{
  "nome": "string",
  "data": "string",
  "genero": "string",
  "cpf": "string"
}
```

## Eletrodomésticos
O endpoint tem como objetivo cadastrar e gerenciar informações dos eletrodomésticos que os usuários cadatram em nosso sistema

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
  "brand": "string",
  "eficienciaEnergetica": {
    "classificacao": "string",
    "comsumoEnergetico": "number"
  }
}
```
| campo | descrição |
| :--- | :--- |
| nome | `nome` |
| modelo | `modelo` |
| potencia | `potencia do aparelho` |
| volts | `voltagem utilizada` |
| marca | `marca` |
| classificacao | `As letras composta na tabela de classificacao do Inmetro, só será permitido uma das seguintes classificações: A, B, C, D, E, F ou G` |
| consumoEnergetico | `consumo energetico que está na tabela de classificação do Inmetro` |

### response
```json
{
  "nome": "string",
  "modelo": "string",
  "potencia": "number",
  "volts": "number",
  "marca": "string",
  "energyEfficiency": {
    "consumoEnergetico": "number",
    "classificacao": "string"
  },
  "dataDeCadastro": "string"
}
```


## Desafios que foram encontrados durante o desenvolvimento e as soluções desenvolvidas

Entendimento das informações relacionadas aos eletrodomésticos que os usuários precisariam para analisar o quanto de energia cada aparelho consome.

Os requisitos mínimos para completar o endpoint de eletrodomésticos do tech challange, deveria conter as seguintes informações: `nome`, `modelo` e `potencia`, porém como 
teriamos a liberdade de adicionar outras informações a nossa classe, adicionei mais 4 campos que na minha opnião são relevantes para um melhor entendimento
de quanto cada aparelho consome. 

Segue abaixo cada campo extra e a descrição do motivo pelo qual adicione

  1° `volts`: Cada cidade utiliza uma voltagem diferente para ligar seus eletrodomésticos, ela pode ser 110 ou 220 volts, portanto adicionar essa voltagem em nosso sistema pode ser importante
  para uma analise futura de consumo energético.
  
  2° `marca`: Dependendo da marca e da qualidade das peças que compõe os eletrodomésticos, ele pode consumir muita ou pouca energia eletrica, então quando o usuário for trocar de aparelho por qualquer
 motivo, ele pode optar por escolher outra marca ou permanecer com a mesma, porque ele já tem todo um histórico de consumo dos aparelho relacionados daquela marca. 
  
  3° `eficienciaEnergetica`: Todos os eletrodomésticos que compramos vem com tabela de eficiência energética em seu manual, então o usuário poderá comparar a eficiẽncia energética calculada pelo 
  sistema com a que está no aparelho feita pela fabricante
  
  4° `dataDeCadastro`: Com o tempo as peças vão se deteriorando e vão consumindo mais energia, então com o passar do tempo o usuário poderá verificar o aumento ou não do consumo de energia do aparelho

Para fazer a modelagem da classe, precisei adicionar o tipo `Enum` para o campo `eficienciaEnergetica`. Adicionei esse tipo porque as letras da tabela de classificação são fixas e raramente sofrem
alterações com o passar do tempo, e também vai trazer clareza aos desenvolvedores que tiverem alterando o modelo de `Eletrodomesticos`








