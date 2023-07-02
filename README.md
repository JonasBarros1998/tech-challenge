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
| porcentagemDeEconomia | `Campo opcional. Porcentagem de economia do aparelho, por exemplo 10, 20, 30. Esse campo é utilizado para os modelos fabricados antes de 2021`
| dataDeCadastro | `Data em que foi cadastrado o eletrodoméstico` | 

## Exemplo de requisições das APIs

[documentação](https://documenter.getpostman.com/view/23405037/2s93zCXztZ)

