# Microserviços de Pagamentos
O que é
--
> Este é um "micro" microserviço para gerenciamento de pagamentos.

Como funciona
--
Todas as requisições precisam receber o content type json
```
Content-Type: application/json
```

## Endpoints

### Save
Método: POST
> http://localhost:8080/payment/save

Enviar um json como este abaixo:
```
{
    "id": 10,
    "cartao": 70707070,
    "validade": "10/10/2019",
    "valor": 500.00,
    "bandeira": "Master Card"
}
```

O retorno deste envio será a url de busca por id
```
{
    "URL": "http://localhost:8080/payment/findById/0"
}
```

### FindById
Método: GET
> http://localhost:8080/payment/finById/:id

Busque os pagamentos passando um id na url. O retorno será o objeto existente
```
{
    "Payment": {
        "id": 0,
        "cartao": 70707070,
        "validade": "10/10/2019",
        "valor": 123,
        "bandeira": "Teste"
    }
}
```

### Update
Método: POST
> http://localhost:8080/payment/update/:id

Atualize os dados de pagamentos. Envie um objeto com os dados de pagamento
```
{
    "id": 10,
    "cartao": 70707070,
    "validade": "10/10/2019",
    "valor": 500.00,
    "bandeira": "Master Card"
}
```

Retorna a url para retornar os dados do pagamento
```
{
    "Mensagem": "Payment atualizado!",
    "Url": "http://localhost:8080/payment/findById/0"
}
```

### Delete
Método POST
> http://localhost:8080/payment/delete/:id

Remova um pagamento passando o id pela a url
```
{
    "Mensagem": "Payment: 0 removido!"
}
```
