### ESCOPO USUÁRIO
## Cenário 1: Criar usuário com sucesso 

**Objetivo:** Criar um novo usuário. 
- Passo 1: Enviar uma requisição POST para cadastrar um novo usuário com os seguintes dados no seguinte formato.
-- Exemplo Request Body 
```json
{ 
  "nome": "AndreaFA", 
  "email": "andrea@gmail.com", 
  "password": "123456", 
  "administrador": "true" 
}
```

- Passo 2: Validar se a resposta tem código de status HTTP 201 Created. 
- Passo 3: Verificar se a mensagem de sucesso é "Cadastro realizado com sucesso".
-- Exemplo Response Body:
```json
{ 
  "message": "Cadastro realizado com sucesso", 
  "_id": "jogDKFjha92824hg" 
}
```

**- Resultado Esperado:** O usuário é criado com sucesso e a resposta inclui o código de status 201 e a mensagem de sucesso. 

## Cenário 2: Verificar se o usuário foi criado 

**Objetivo:** Validar a busca, pelo nome, do usuário criado. 

- Passo 1: Realizar uma requisição GET para buscar o usuário com o nome "AndreaFA". 

-- Exemplo Request URL: https://serverest.dev/usuarios?nome=AndreaFA 

- Passo 2: Validar se a resposta tem código de status HTTP 200 OK. 

- Passo 3: Validar que a quantidade de usuários retornados não seja nula. 

-- Exemplo Response Body: 
```json
{ 
  "quantidade": 1, 
  "usuarios": [ 
    { 
      "nome": "AndreaFA", 
      "email": "andrea@gmail.com", 
      "password": "123456", 
      "administrador": "true", 
      "_id": "TO5RFsQ3TEU6JeNK" 
    } 
  ] 
}
```
**- Resultado Esperado:** O usuário "AndreaFA" é encontrado com sucesso e os detalhes da busca são retornados corretamente.

### ESCOPO PRODUTO
## Cenário 1: Criar Produto com Sucesso

**Objetivo:** Criar um novo produto.

- Passo 1: Logar usuário para obter o token de autenticação. Para logar envie uma requisição POST, com o email e a senha do usuário. O token é retornado no campo authorization.

-- Exemplo Request Body:
```json
{
  "email": "andrigo@gmail.com",
  "password": "654321"
}
```
-- Exemplo Response Body:
```json
{
  "message": "Login realizado com sucesso",
  "authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImFuZHJpZ29AZ21haWwuY29tIiwicGFzc3dvcmQiOiI2NTQzMjEiLCJpYXQiOjE3MzgwMjI1NTAsImV4cCI6MTczODAyMzE1MH0.vOqj490Wvb0MLRt9BYIy_lcxwMFEMaBZWyuGOzMiySc"
}
```

- Passo 2: Enviar uma requisição POST, com o token do usuário, para cadastrar um novo produto com os seguintes dados no seguinte formato. 

-- Exemplo Request Body:
```json
{ 
  "descricao": "Lego Classic Caixa De Festa Criativa", 
  "nome": "Lego Classic", 
  "preco": 519, 
  "quantidade": 1 
}
```
- Passo 3: Validar se a resposta tem código de status HTTP 201 Created.
  
- Passo 4: Verificar se a mensagem de sucesso é "Cadastro realizado com sucesso".
-- Exemplo Response Body:
```json
{
  "message": "Cadastro realizado com sucesso", 
  "_id": "jogDKFjha92824hg"
}
``` 
**- Resultado Esperado:** O produto é criado com sucesso e a resposta inclui o código de status 201 e a mensagem de sucesso.

## Cenário 2: Verificar se o produto foi criado

**Objetivo:** Validar a busca, pelo nome, do produto criado.

- Passo 1: Realizar uma requisição GET para buscar o produto com o nome "Lego Classic".

-- Exemplo Request URL: https://serverest.dev/produto?nome=Lego%20Classic

- Passo 2: Validar se a resposta tem código de status HTTP 200 OK.
  
- Passo 3: Validar que a quantidade de produtos retornados não seja nula.
- -- Exemplo Response Body:
```json
{ 
  "quantidade": 1, 
  "produtos": [ 
    { 
      "nome": "Lego Classic", 
      "descricao": "Lego Classic Caixa De Festa Criativa", 
      "preco": 519, 
      "quantidade": 1, 
      "_id": "TO5RFsQ3TEU6JeNK"
    } 
  ] 
}
```

**- Resultado Esperado:** O produto "Lego Classic" é encontrado com sucesso e os detalhes são retornados corretamente.
