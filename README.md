# Tech challenge Fase 2

## Como iniciar a aplicaçao

#### pré-requisitos
- Java 17
- Docker (Para executar o banco de dados)

#### Clone o repositório
- clone o repositório `git clone git@github.com:JonasBarros1998/tech-challenge.git`
- mude para branch `git checkout techchallange-fase-2`. (**a branch `main` está com o conteúdo da fase 1 do techchallange**)

#### baixe as dependencias do projeto
```
mvn install
```

#### Criação do container docker
- Na aplicação existe um arquivo chamado `Dockerfile` no qual está configurado para criação da imagem do banco de dados. Portanto digite o comando abaixo para criar a imagem. **Verifique se esteja dentro da pasta raiz da aplicação antes de executar o comando abaixo**
```
docker build -t jonasbarros/techchallange -f database.dockerfile .
```

- Após a imagem ser criada, crie um container com o nosso banco de dados postgreSQL. 
```
docker run --name techchallange -p 5432:5432 jonasbarros/techchallange
```

- Teste a conexão com o container no **DBeaver** ou no próprio **intellij**, para isso segue as credencias de acesso e o nome da database que já foram configuradas durante a inicialização do container. Versão do banco de dados e as variaveis de ambiente utilizadas são encontradas no arquivo `database.dockerfile`
```
senha: abc1234
usuario: jonas
database: techchallange
```

#### Inicie a aplicação
- servidor de acesso local `http://localhost:8080`
```
mvn spring-boot:run
```
- Ao iniciar a aplicação, ela irá criará automaticamente as tabelas e os relacionamentos. Mais informações no arquivo

`tech-challenge/src/main/resources/application.yml`

## Documentação das APIs

### Usuarios
O endpoint tem objetivo de incluir novos usuários na aplicação

```http
POST /api/usuarios
```
- body
```json
{
  "email": "jonas@outlook.com"
}
```

#### Descrição dos campos
| campo | descrição |
| :--- | :--- |
| email | `email do usuario` |



### Endereços
O endpoint tem como objetivo cadastrar novos endereços em nosso sistema. 

```http
POST /api/enderecos
```

- body
```json
{
  "cidade": "São Paulo",
  "estado": "SP",
  "numero": "100",
  "bairro": "Bairro de teste",
  "rua": "Rua ABCD",
  "cep": "94020-080",
  "usuario": {
    "id": "ID_USUARIO"
  }
}
```

### response

```json
{
  "cidade": "São Paulo",
  "estado": "SP",
  "numero": "100",
  "bairro": "Bairro de teste",
  "rua": "Rua ABCD",
  "cep": "94020-080",
  "usuario": {
    "id": "ID_USUARIO"
  }
}
```

### Descrição de cada campo
| campo | descrição |
| :--- | :--- |
| id | `id do endereco no formato UUID` |
| cidade | `nome da cidade` |
| estado | `nome do estado` |
| numero | `número da residência` |
| bairro | `nome do bairro` |
| rua | `nome da rua` |
| cep | `formato permitido: 00000-000` |
| usuario.id | `Após a inserção do usuário, insira o ID dele nesse campo` como cadastrar [usuários](https://github.com/JonasBarros1998/tech-challenge/edit/techchallange-fase-2/README.md#baixe-as-dependencias-do-projeto) | 

#### Pesquisar todos os endereços

```http
GET /api/enderecos
```
Retorna uma lista de endereços que foram incluídos na aplicação

```json
[
  {
    "id": "79cf6814-4474-437c-94fa-b4951a9d6954",
    "cep": "94020-080",
    "estado": "SP",
    "rua": "Rua ABCD",
    "numero": "100",
    "bairro": "Bairro de teste",
    "cidade": "São Paulo"
  },
  {
    "id": "2e52185d-2406-4370-881d-b6aa10e0168a",
    "cep": "94020-080",
    "estado": "SP",
    "rua": "Rua ABCD",
    "numero": "100",
    "bairro": "Bairro de teste",
    "cidade": "São Paulo"
  }
]
```

#### Pesquisar endereço por ID

```http
GET /api/enderecos/ENDERECO_ID
```

```json
[
  {
    "id": "79cf6814-4474-437c-94fa-b4951a9d6954",
    "cep": "94020-080",
    "estado": "SP",
    "rua": "Rua ABCD",
    "numero": "100",
    "bairro": "Bairro de teste",
    "cidade": "São Paulo"
  },
]
```

#### Pesquisar endereço por bairro, rua, cidade ou estado.

O retorno dessas rota serão exatamente iguais, mudando apenas os `query parameters`

```http
GET /api/enderecos?bairro=NOME_DO_BAIRRO
```
```http
GET /api/enderecos?rua=NOME_DA_RUA
```
```http
GET /api/enderecos?cidade=NOME_DA_CIDADE
```
```http
GET /api/enderecos?estado=NOME_DO_ESTADO
```

#### Examplo de retorno das rotas acima
```json
[
  {
    "id": "79cf6814-4474-437c-94fa-b4951a9d6954",
    "cep": "94020-080",
    "estado": "SP",
    "rua": "Rua ABCD",
    "numero": "100",
    "bairro": "Bairro de teste",
    "cidade": "São Paulo"
  },
]
```

#### Pesquisar endereço por CPF da pessoa
- endpoint para cumprir os item 9 do tech challange, onde diz o seguinte: "Essa API deve ser capaz de identificar as pessoas associadas a cada endereço e vice-versa" 
- Antes de executar essa URL, verifique se já cadastrou os clientes e relacionou o usuário ao cliente cadastrado, mais informações em [cadastrar clientes]()
- A API irá retornar uma lista incluindo o usuário relacionado aquele endereço, consultando a partir do CPF da pessoa
  
```http
GET /api/enderecos?cpf=CPF_DO_CLIENTE
```

##### retorno da API 

```json
[
  {
    "id": "79cf6814-4474-437c-94fa-b4951a9d6954",
    "cep": "94020-080",
    "estado": "SP",
    "rua": "Rua ABCD",
    "numero": "100",
    "bairro": "Bairro de teste",
    "cidade": "São Paulo",
    "usuario": {
      "email": "jonas@outlook.com",
      "id": "5cfb8984-77c3-4800-8144-b75a62353573"
    }
  },
  {
    "id": "2e52185d-2406-4370-881d-b6aa10e0168a",
    "cep": "94020-080",
    "estado": "SP",
    "rua": "Rua ABCD",
    "numero": "100",
    "bairro": "Bairro de teste",
    "cidade": "São Paulo",
    "usuario": {
      "email": "jonas@outlook.com",
      "id": "5cfb8984-77c3-4800-8144-b75a62353573"
    }
  }
]
```

#### Pesquisar a pessoa a partir do ID do seu endereço
- endpoint para cumprir os item 9 de Enderecos do tech challange, onde diz o seguinte: "Essa API deve ser capaz de identificar as pessoas associadas a cada endereço e vice-versa" 
- Antes de executar essa URL, verifique se já cadastrou os clientes e relacionou o usuário ao cliente cadastrado, mais informações em [cadastrar clientes]()
- A API irá retornar uma lista com o nome das pessoas relacionada ao endereço consultado

```http
GET /api/enderecos/ENDERECO_ID/pessoas
```

```json
[
  {
    "cpf": "36979184008",
    "nome": "Jonas",
    "nascimento": "2023-09-03",
    "genero": "Masculino"
  }
]
```

#### Editar endereço
- Edita apenas o endereço, utilizando o ID do endereço, mais informação sobre a descriação de cada campo: [descrição](https://github.com/JonasBarros1998/tech-challenge/edit/techchallange-fase-2/README.md#tech-challenge-fase-2)

```http
PUT /api/enderecos/ENDERECO_ID
```

```json
{
  "cidade": "São Paulo",
  "estado": "SP",
  "numero": "61",
  "bairro": "Bairro 123",
  "rua": "rua para teste",
  "cep": "94020-070"
}
```

#### Remover endereço
- É retornado uma resposta vazia, com status HTTP 204

```http
DELETE /api/enderecos/ENDERECO_ID
```


## Pessoas
O endpoint tem como objetivo fazer o cadastro dos usuários em nosso sistema

#### Cadastrar uma pessoa e seus dependentes

```http
POST /api/pessoas
```

```json
{
  "nome": "Jonas",
  "cpf": "36979184008",
  "genero": "Masculino",
  "nascimento": "1985-06-27",
  "usuarioID": "5cfb8984-77c3-4800-8144-b75a62353573",
  "relacionamento": [
    {
      "nome": "Jonas 2",
      "parentesco": "sobrinho",
      "genero": "Masculino",
      "nascimento": "2012-01-27",
      "cpf": "15863220015",
      "usuarioID": "9fdfcce8-85b3-4f28-990b-53581eca6a3e"
    }
  ]
}
```

| campo | descrição |
| :--- | :--- |
| nome | `nome do cliente` |
| cpf | `cpf do cliente` |
| genero | `genero do cliente` |
| nascimento | `data de nascimento do cliente. Formato permitido: yyyy-mm-dd` |
| usuarioID | `id do usuario no formato UUID` [mais informações]() |
| relacionamento.nome | `nome do dependente` |
| relacionamento.parentesco | `tipo de parentesco, podendo ser filho, esposa, sobrinho, marido etc...` |
| relacionamento.genero | `genero do dependente` |
| relacionamento.nascimento | `data de nascimento do dependente. Formato permitido: yyyy-mm-dd` |
| relacionamento.cpf | `cpf do cliente` |
| relacionamento.usuarioID | `id do usuario no formato UUID` [mais informações]() |


#### Pesquisar por dependentes
- A partir do ID de um superior, ou seja, a pessoa que esteja na raiz da árvore, é possível consultar todos os seus dependentes

```http
GET /api/pessoas/ID_PESSOA_SUPERIOR/dependentes
```

- Ao pesquisar deve retornar um json no formato abaixo, listando todos os seus dependentes

```json
[
  {
    "cpf": "15863220015",
    "nome": "Junior",
    "nascimento": "2012-01-27",
    "genero": "Masculino",
    "dataDeCadastro": "2023-09-03",
    "grauDeParentesco": [
      {
        "parentesco": "sobrinho"
      }
    ]
  }
]
```

#### Pesquisar por nome e por genero

- Nessa pesquisa é possível consultar todas as pessoas por nome ou genero
  
```http
GET /api/pessoas?genero=TIPO_DO_GENERO
```
```http
GET /api/pessoas?nome=NOME_DA_PESSOA
```

- Ambos os endpoint retornam o mesmo json de acordo com a consulta
```json
[
  {
  "cpf": "15863220015",
  "nome": "Junior",
  "nascimento": "2012-01-27",
  "genero": "Masculino"
  }
]
```

#### Pesquisar por parentesco
- Com esse endpoint é possível fazer relacionamentos familiares entre os membros da casa

```http
GET /api/pessoas/ID_DO_SUPERIOR/parentesco?tipo=TIPO_DE_PARENTESCO
```

- Retorno do endpoint
``` json
[
  {
    "cpf": "15863220015",
    "nome": "Junior",
    "nascimento": "2013-01-27",
    "genero": "Masculino",
    "dataDeCadastro": "2023-09-03",
    "grauDeParentesco": [
      {
        "parentesco": "filho"
      }
    ]
  }
]
```

#### Editar uma pessoa
- Com essa API é possível editar qualquer informação relacionada a pessoa

```http
PUT /api/pessoas/PESSOA_CPF
```
  
- body
```json
{
  "nome": "Junior",
  "nascimento": "2013-01-27",
  "genero": "Masculino"
}
```

- retorno
```json
{
  "cpf": "15863220015",
  "nome": "Junior",
  "nascimento": "2013-01-27",
  "genero": "Masculino"
}
```

#### Remover uma pessoa
- O retorno do endpoint é o tipo 204

```http
PUT /api/pessoas/PESSOA_CPF
```


## Eletrodomésticos


#### Cadastrar um novo eletrodomestico
- O endpoint tem como objetivo cadastrar os eletrodomésticos dos usuários em nosso sistema

```http
POST /api/eletrodomesticos
```

- body
```json
{
  "nome": "Galedeira",
  "modelo": "1234",
  "potencia": 900,
  "volts": 220,
  "marca": "Brastemp",
  "eficienciaEnergetica": {
  "classificacao": "A",
  "consumoEnergetico": 200,
  "porcentagemDeEconomia": 10
},
  "usuarios": [
  {
    "id": "c5cba95f-2b97-40e0-8dd6-d782d6b0b3a3"
  },
  {
    "id": "d1bc66e7-105c-4493-a7ca-3b96c56a357a"
  }
 ]
}
```

- Descrição de cada campo
| campo | descrição |
| :--- | :--- |
| nome | `nome` |
| modelo | `modelo` |
| potencia | `potência em watts do aparelho, por exemplo: 1800, 300, 600` |
| volts | `voltagem utilizada para ligar o aparelho, por exemplo: 220, 110, 127 etc...` |
| marca | `marca` |
| classificacao | `A letra que está relacionada ao aparelho na tabela de de eficiência energetica do Inmetro, só será permitido uma das seguintes classificações: A, B, C, D, E, F ou G` |
| consumoEnergetico | `consumo energético por hora` |
| porcentagemDeEconomia | `Campo opcional. Porcentagem de economia do aparelho, por exemplo 10, 20, 30. Esse campo é utilizado para os modelos fabricados antes de 2021`
| dataDeCadastro | `Data em que foi cadastrado o eletrodoméstico` |
| usuarios.id | `envie os IDs usuários que utilizam esse aparelho` |

- retorno do endpoint
```json
{
  "nome": "Galadeira",
  "modelo": "1234",
  "potencia": 900,
  "volts": 220,
  "marca": "Brastemp",
  "eficienciaEnergetica": {
  "consumoEnergetico": 200,
  "classificacao": "A"
},
  "usuarios": [
    {
      "id": "5cfb8984-77c3-4800-8144-b75a62353573"
    },
    {
      "id": "9fdfcce8-85b3-4f28-990b-53581eca6a3e"
    }
  ],
  "dataDeCadastro": "2023-09-03"
}
```

#### Adicionar novos usuário aos eletrodomesticos

```http
GET /api/eletrodomesticos/usuario/ELETRODOMESTICO_ID
```

- body
```json
{
  "usuario": "USUARIO_ID"
}
```

#### Editar eletrodomesticos
- É possível editar qualquer informação sobre o eletrodomestico

- body
```json
{
  "nome": "Geladeira",
  "modelo": "1234 abcd",
  "potencia": 900,
  "volts": 110,
  "marca": "Brastemp",
  "eficienciaEnergetica": {
    "classificacao": "A",
    "consumoEnergetico": 50,
    "porcentagemDeEconomia": 10
  }
}
```

- retorno do endpoint
```json
{
  "nome": "Celular",
  "modelo": "Xiaomi 123",
  "potencia": 900,
  "volts": 110,
  "marca": "Xiaomi",
  "eficienciaEnergetica": {
    "consumoEnergetico": 50,
    "classificacao": "A",
    "porcentagemDeEconomia": 10
  },
  "dataDeCadastro": "2023-09-03"
}
```

#### Calcular o consumo de energia eletrica com base no tempo de uso
- Utilizado para cumprir o item 9 da API de eletrodomestico do tech challange, onde diz o seguinte: "A API de gestão de eletrodomésticos deve ser capaz de identificar os consumos de energia dos aparelhos eletrônicos cadastrados, com base no tempo de uso reportado pelo adaptador".

```http
PUT /api/eletrodomesticos/df3066d0-2fda-4136-aa5b-f815717e23b3/consumo
```

- body
```json
{
  "tempoDeUso": "01:30:00"
}
```

- retorno do endpoint
```json
{
  "tempoDeUso": "01:30:00",
  "consumoEnergeticoPorHora": 75.000
}
```

#### Pesquisar por nome, potência e modelo
- As urls abaixo, tem intuito de pesquisar por nome, potência e modelo. O retorno da API é o mesmo para todos os endpoint, mudando apenas o tipo da pesquisa
  
```http
GET /api/eletrodomesticos?nome=NOME_DO_APARELHO
```
```http
GET /api/eletrodomesticos/potencia?de=MINIMO_DA_POTENCIA&ate=MAXIMO_DA_POTENCIA
```
```http
GET /api/eletrodomesticos?modelo=MODELO_DO_ELETRODOMESTICO
```

- descrição dos endpoint
| campo | descrição |
| :--- | :--- |
| `de` | minimo de potencia que gostaria de filtrar | 

| `ate` | maximo de potencia que gostaria de filtrar |

- body
```json
[
  {
    "nome": "frigobar",
    "modelo": "1234",
    "potencia": 900.00,
    "volts": 220.00,
    "marca": "Brastemp",
    "eficienciaEnergetica": {
    "consumoEnergetico": 200.00,
    "classificacao": "A"
    },
    "dataDeCadastro": "2023-09-03"
  }
]
```




























