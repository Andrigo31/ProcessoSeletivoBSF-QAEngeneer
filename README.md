## Cenário 1: Criar usuário com sucesso 

Objetivo: Criar um novo usuário. 
- Passo 1: Enviar uma requisição POST para cadastrar um novo usuário com os seguintes dados no seguinte formato: 
Exemplo Request Body 
```json
{ 
  "nome": "Andrigo", 
  "email": "andrigo@gmail.com", 
  "password": "654321", 
  "administrador": "true" 
}
```

- Passo 2: Validar se a resposta tem código de status HTTP 201 Created. 
- Passo 3: Verificar se a mensagem de sucesso é "Cadastro realizado com sucesso". 
Exemplo Response Body:
```json
{ 
  “message”: “Cadastro realizado com sucesso”, 
  “_id”: “jogDKFjha92824hg” 
}
```

- Resultado Esperado: O usuário é criado com sucesso e a resposta inclui o código de status 201 e a mensagem de sucesso. 
