2) Etapa III - Automação de Teste Web II
Nesta terceira etapa, queremos aprofundar nosso entendimento e compreender como seria sua construção em métodos de validação. 

Aplicação alvo: trivago.com.br 
Descreva e automatize o seguinte fluxo: 

1 - Acessar o site; 
2 - Pesquise por Manaus; 
3 - Ordene as opções listadas por “Avaliações e Sugestões”; 
4 - Verifique o primeiro nome da lista; 
5 - Verifique a avaliação; 
6 - Verifique o valor;


DESCRIÇÃO DO FLUXO:

Validar a funcionalidade de busca de destino e exibição de resultados do site Trivago. Pontos chave:
- Pesquisa pelo destino: Manaus
- Ordenação do resultado por: Avaliações e Sugestões
- Verificação das informações recebidas no primeiro resultado: nome do hotel, valor e avaliação.

Passo-a-passo do Fluxo:
1. Acessar o site:
- Iniciar o navegador, limpar os cookies e carregar a url http://www.trivago.com.br.
- O retorno esperado é a exibição da página inicial.

2. Pesquisar pelo destino "Manaus":
- A automação deve clicar no campo de busca, digitar "Manaus" e clicar em "Pesquisar".
- A aplicação deve exibir a lista de hotéis em Manaus.

3. Ordenar a lista retornada por "Avaliação e Sugestões"
- A automação clica na combobox de "Ordenar por" e seleciona a opção "Avaliação e Sugestões".
- A aplicação Trivago reorganizará os resultados com base na ordenação escolhida.

4. Verificar o nome do primeiro hotel da lista:
- A automação deverá capturar o primeiro nome do hotel da lista e deverá validar se é "Rede Andrade Amazônia"

5. Verificar a avaliação do primeiro hotel da lista:
- A automação deverá capturar a avaliação do primeiro hotel da lista e deverá validar se é "7.5"

6. Verificar o valor do primeiro hotel da lista:
- A automação deverá capturar o valor do primeiro hotel da lista e deverá validar se é "R$78"

7. Resultado esperado: 
- O sistema deve executar cada etapa sem erros, apresentando as informações corretas de acordo com os critérios definidos.
- Ao final do teste: O nome do hotel, avaliação e valor do primeiro resultado devem corresponder aos valores previamente configurados nos dados esperados.
