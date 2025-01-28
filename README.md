### 1) Etapa II - Automação de Teste Web I
Nesta segunda etapa, queremos iniciar nosso entendimento sobre seu domínio de automação de testes Web.

### Aplicação alvo: buscacep.correios.com.br

Descreva e automatize os seguintes cenários:

1. Realizar a busca com o valor “69005-040”;
2. Realizar a busca com o valor “Lojas Bemol”;

---

**DESCRIÇÃO DOS CENÁRIOS**

**Cenário 1: Buscar endereço com o CEP "69005-040".**
- Passo 1: Acessar a página inicial do site https://buscacep.correios.com.br.
- Passo 2: Localizar o campo de entrada de CEP ou endereço.
- Passo 3: Inserir o valor "69005-040" no campo de CEP ou endereço.
- Passo 4: Clicar no botão para realizar a busca.
- Passo 5: Aguardar a resposta da página, que deve exibir o endereço correspondente ao CEP informado.
- Passo 6: Validar se o endereço retornado é "Rua Miranda Leão".
#### - Resultado Esperado: O sistema deve retornar o endereço "Rua Miranda Leão".

  
**Cenário 2: Buscar endereço com o valor “Lojas Bemol”**
- Passo 1: Acessar a página inicial do site https://buscacep.correios.com.br.
- Passo 2: Localizar o campo de entrada de CEP ou endereço.
- Passo 3: Inserir o nome "Lojas Bemol" no campo de CEP ou endereço.
- Passo 4: Clicar no botão para realizar a busca.
- Passo 5: Aguardar a resposta da página, que deve exibir um endereço relacionado ao nome "Lojas Bemol".
- Passo 6: Validar se o endereço retornado é "Rua Miranda Leão, 41 Lojas Bemol".
#### - Resultado Esperado: O sistema deve retornar o endereço "Rua Miranda Leão, 41 Lojas Bemol".

---
### 2) Etapa III - Automação de Teste Web II
Nesta terceira etapa, queremos aprofundar nosso entendimento e compreender como seria sua construção em métodos de validação. 

### Aplicação alvo: [trivago.com.br](https://www.trivago.com.br)

Descreva e automatize o seguinte fluxo: 

1. Acessar o site
2. Pesquise por Manaus
3. Ordene as opções listadas por “Avaliações e Sugestões”
4. Verifique o primeiro nome da lista
5. Verifique a avaliação
6. Verifique o valor


**DESCRIÇÃO DO FLUXO**

**Objetivo:**  
Validar a funcionalidade de busca de destino e exibição de resultados do site Trivago.  

**Pontos chave:**
- Pesquisa pelo destino: Manaus  
- Ordenação do resultado por: Avaliações e Sugestões  
- Verificação das informações recebidas no primeiro resultado:  
  - Nome do hotel  
  - Valor  
  - Avaliação  

---

### Passo-a-passo do Fluxo:

1. **Acessar o site:**  
   - Iniciar o navegador, limpar os cookies e carregar a URL [trivago.com.br](http://www.trivago.com.br).  
   - **Retorno esperado:** A exibição da página inicial.  

2. **Pesquisar pelo destino "Manaus":**  
   - A automação deve clicar no campo de busca, digitar "Manaus" e clicar em "Pesquisar".  
   - **Retorno esperado:** A aplicação deve exibir a lista de hotéis em Manaus.  

3. **Ordenar a lista retornada por "Avaliação e Sugestões":**  
   - A automação clica na combobox de "Ordenar por" e seleciona a opção "Avaliação e Sugestões".  
   - **Retorno esperado:** A aplicação Trivago reorganiza os resultados com base na ordenação escolhida.  

4. **Verificar o nome do primeiro hotel da lista:**  
   - A automação deverá capturar o primeiro nome do hotel da lista e validar se é **"Rede Andrade Amazônia"**.  

5. **Verificar a avaliação do primeiro hotel da lista:**  
   - A automação deverá capturar a avaliação do primeiro hotel da lista e validar se é **"7.5"**.  

6. **Verificar o valor do primeiro hotel da lista:**  
   - A automação deverá capturar o valor do primeiro hotel da lista e validar se é **"R$78"**.  

### Resultado esperado:
- O sistema deve executar cada etapa sem erros, apresentando as informações corretas de acordo com os critérios definidos.  
- **Validações finais:**  
  - Nome do hotel, avaliação e valor do primeiro resultado devem corresponder aos valores previamente configurados nos dados esperados.  
