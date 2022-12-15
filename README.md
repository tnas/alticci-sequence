# Altice Labs Technical Exercise

## Table of contents
* [Description - In Portuguese](#description)

## Description

Deverá ser implementado um serviço REST utilizando uma framework JAVA1 que devolve um
valor da sequência **Alticci**.

Opcionalmente poderá ser implementado um GUI web simples em JavaScript2 para consultar o
serviço.

A sequência Alticci - a(n) - é definida da seguinte forma:

n=0 => a(0) = 0<br>
n=1 => a(1) = 1<br>
n=2 => a(2) = 1<br>
n>2 => a(n) = a(n-3) + a(n-2)

Exemplo dos primeiros valores da sequência:

0<br>
1<br>
1<br>
1<br>
2<br>
2<br>
3<br>
4<br>
5<br>
7<br>
9<br>
[…]

O endpoint a criar será da forma `<baseurl>/alticci/{n}` em que o `{n}` representa o
índice da sequência para o qual pretendemos obter o valor.

O serviço implementado deverá tirar partido de cálculos passados para acelerar cálculos
futuros (caching).

Resposta deverá incluir:

- Código fonte
- Documentação das APIs ReST – formato Open API (Swagger)
- Instruções para execução (em containers ou outra)

Caso existam dúvidas em relação a qualquer ponto que possa influenciar a implementação, o
candidato deverá tomar decisões e avançar de acordo com os pressupostos assumidos (que
devem ser incluídos na resposta ao exercício).
