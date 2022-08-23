<p>Controlador de sonda espacial.</p>
O código implemtado funciona como um backend para se controlar uma sonda espacial.<br>
Você pode considerar que já existe uma sonda pousada em um planeta e enviar comandos para ela se mover.<br>
Nesse caso, já existe um planeta salvo no banco de dados e uma sonda, sendo YYZ e Saturno o nome da sonda e do planeta, respectivamente.<br>
É possível também criar uma nova sonda e um novo planeta. 
Existindo a sonda e o planeta, você poderá enviar comandos para que ela se movimente.<br>
Esses comandos são: L: vira a sonda para a esquerda, R: vira a sonda para a direita e M: que faz a sonda se mover para frente.<br>
A sonda executará os comandos desde que eles sejam válidos.<br>
Para que um comando seja válido, a sonda não deverá passar por nenhum ponto onde já exista outra sonda o ocupando.<br>
A sonda calcula o movimento antes de executá-lo e não o fará se caso estiver fora dos limites do planeta.
<p> Testes unitários </p>
Os testes foram implementados para a camada Controller, Repository e ServiceImpl.
Em resumo são testados os endpoints, os métodos de persistência no banco e de busca de registros e os métodos mais importantes para se mover a sonda.

<p>Planeta</p>
Planeta é um objeto que contém nome, dimensão x e dimensão y e uma lista de regiões.
Para se criar um novo planeta é necessário que se envie na requisição um objeto json com os atributos da entidade Planeta.<br>

<p>Região</p>
Região é um objeto que contém o nome do planeta a qual ela pertence, posição X e posição Y.<br>
Essa região, quando existente, indica que uma sonda está parada ali.<br>
<p>Sonda</p>
Sonda é um objeto que contém seu nome, a direção que ela aponta(Norte "N", Sul "S", Leste "E", Oeste "W".<br>
Também contém os comandos que ela executará, a posição X e Y que ela se movimentará<br>
e suas posições de pouso X e Y.<br>
<p>ComandoDTO</p>
DTO para envio de comandos para a sonda. Este comando contém:<br>
nome da sonda, nome do planeta, comando, posição atual e posição final.<br>
posição atual e posição final não necessários para preenchimento.
<p>PousoDTO</p>
DTO que possui região de pouso x, região de pouso y, nome do planeta, nome da sonda e direção<br>
O atributo direção deve ser preenchido com os pontos cardeais "N","S","E","W". <br>


<p>Build and Run</p>
Essa é uma aplicação Spring Boot, Java 18, Maven.<br>
Basta configurar SDK com java 18, definir o método ControladorDeSondaEspacialApplication como método da classe principal.<br>
e executar clean e install do Maven.<br>


