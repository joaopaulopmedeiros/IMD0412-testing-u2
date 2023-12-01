# Poker

## Objetivo
Implementação de ranking para poker.

## Como
Há uma análise de cada mão (conjunto de cartas de entrada).

Prezando pelo princípio de *separation of concerns*, a classe `Mao.java` apenas orquestra o fluxo de ranking, utilizando a dependência `AnalisadorMao.java`, que possui a responsabilidade de entender regras de poker, por conseguinte, afirmando coisas como "há um straight flush".

Optou-se por uma escrita inspirada em higher order functions. Usou-se, também, o recurso de streams em java para simplificar o código.