**1) Etapa II**

**2) Etapa III - Automação de Teste Web II**
Nesta terceira etapa, queremos aprofundar nosso entendimento e compreender como seria sua construção em métodos de validação. 

### Aplicação alvo: [trivago.com.br](https://www.trivago.com.br)

Descreva e automatize o seguinte fluxo: 

1. Acessar o site
2. Pesquise por Manaus
3. Ordene as opções listadas por “Avaliações e Sugestões”
4. Verifique o primeiro nome da lista
5. Verifique a avaliação
6. Verifique o valor


## DESCRIÇÃO DO FLUXO

**Objetivo:**  
Validar a funcionalidade de busca de destino e exibição de resultados do site Trivago.  

### Pontos chave:
- **Pesquisa pelo destino:** Manaus  
- **Ordenação do resultado por:** Avaliações e Sugestões  
- **Verificação das informações recebidas no primeiro resultado:**  
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

---

### Resultado esperado:
- O sistema deve executar cada etapa sem erros, apresentando as informações corretas de acordo com os critérios definidos.  
- **Validações finais:**  
  - Nome do hotel, avaliação e valor do primeiro resultado devem corresponder aos valores previamente configurados nos dados esperados.  
