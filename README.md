# EP1-IAA

### Gabriel Folegatti Santana 9911506
### repositório git: https://github.com/gfolegatti/EP1-IAA
######Este projeto é designado a aula de Introdução a Análise de Algoritmos (ACH2002), ministrada pelo professor Dr. Flávio Coutinho no 2º semestre de 2020.

A classe Image.java já foi fornecida e não foi modificada. As classes Main.java e ImageEx.java foram fornecidas mas
houveram incrementações que se fizeram necessárias para concluir os objetivos do trabalho.

### Main.java
Nesta Classe foi adicionado dois if's com os comandos KOCH_CURVE e REGION_FILL, para chamar as funções que implementam
estas funcionalidades.

### ImageEx.java
Esta classe é a principal que contém as principais funcionalidades de fato implementadas.
As duas principais funções são  
   1) kochCurve
   2) regionFill  

E as restantes serão comentadas mais a frente, são funções auxiliares que auxiliam a desempenhar o objetivo principal.

#### 1. kochCurve
Esta é a função recursiva responsável para realizar a curva koch, solicitada na primeira parte do EP1.
Inicialmente é realizada a condição de parada, como dita o algoritmo comentado no pdf de entrega, caso o segmento
PQ seja menor que o limiar a reta é desenhada.
O tamanho do segmento PQ é calculado pela função `long distanceBetween2Points(int px, int py, int qx, int qy)
` que utiliza os conceitos do Teorema de Pitágoras para calcular a distância entre dois pontos. Foi criado a função
`squared` para facilitar a leitura.

após isto, utiliza-se o conceito de função afim para encontrar pontos num segmento, onde alpha representa o ponto da 
reta em que se deseja encontrar. Estes conceitos são aplicados para encontrar A,C e M. M por sua vez será utilizado
para encontrar o B. O algoritmo para encontrar o ponto B foi calculando o ponto M[Mx,My] e o vetor _u_, que representa
a altura 'h' do triângulo equilátero formado.
Após estes cálculos realiza-se o arredondamento pois a função recebe apenas inteiros e chama-se recursivamente para 
os outros segmentos, respectivamente: PA, AB, BC e CQ. E assim por diante todo o algoritmo se repete até encontrar
um ponto de parada.


#### 2. regionFill
Esta é a função recursiva responsável para realizar o preenchimento de regiões, solicitado na segunda parte do EP1.
O funcionamento deste componente é muito mais simples, ele apenas pinta uma região com a mesma cor de fundo, definida 
por setColor() na classe Main.java, na linha 40.
Dentro do método regionFill, a checagem de parada é apenas se o pixel atual é da mesma cor do que o fundo inicial, 
caso não ele para a pintura naquele local. Caso contrário ele irá pintar o atual e chamar recursivamente
para os quatro vizinhos.

### Testes
As entradas selecionadas estão aí. A 1,2 e 3 foram entregues pelo professor, algumas foram criadas por mim e outras
foram disponibilizadas entre os alunos para testes, por isto haverá algumas semelhanças com outros trabalhos. A entrada
9 estourou a memória, apesar da alocação utilizando o comando -Xss250M, não consegui resolver aqui. No meu computador
não foi possível alocar muito mais memória para rodar pois o S.O não permitia. Utilizo notebook do serviço.

### Compilação 
É necessário compilar a classe Main.java, Image.java e ImageEx.java no programa. 
    `javac Main.java` 
    `javac Image.java` 
    `javac ImageEx.java`

E após isto rodar, passando os parâmetros segundo foi orientado:
    `java ProgPrincipal entrada.txt saida.png`