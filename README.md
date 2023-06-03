# Tech challenge


## Endereços
Esse endpoint tem como objetivo gerenciar o endereços que os usuários cadastram em nosso sistema. 

```http
POST /api/adress
```

### body

```json
{
  "city": "string",
  "state": "string",
  "number": "string",
  "neighborhood": "string",
  "street": "string"
}
```

### response

```json
{
  "street": "string",
  "number": "string",
  "neighborhood": "string",
  "city": "string",
  "state": "string"
}
```

## Gestão de pessoas
O endpoint tem como objetivo fazer o cadastro e gerenciar os usuários no nosso sistema

```http
POST /api/people
```
### body

```json
{
  "name": "string",
  "date": "ano-mes-dia",
  "sexualPreference": "string"
}
```

### response
```json
{
  "name": "string",
  "date": "ano-mes-dia",
  "sexualPreference": "string"
}
```


## Eletrodomésticos
O endpoint tem como objetivo cadastrar e gerenciar informações sobre os eletrodomésticos que os usuários adicionam em nosso sistema

```
POST /api/eletrodomesticos
```

### body
```json
{
  "name": "string",
  "model": "string",
  "power": "number",
  "volts": "number",
  "brand": "string",
  "energyEfficiency": "A|B|C|D|E|F|G"
}
```

### response
```
{
  "name": "string",
  "model": "string",
  "power": "number",
  "volts": "number",
  "brand": "string",
  "energyEfficiency": "string"
}
```


