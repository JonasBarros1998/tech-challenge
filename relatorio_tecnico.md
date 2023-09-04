# Relatório técnico 

## Image geral do relacionamento entre as tabelas

![diagrama de relacionamento](https://firebasestorage.googleapis.com/v0/b/app-english-class.appspot.com/o/Diagrama_de_relacionamento.png?alt=media&token=6cd8cbe2-eb4c-4b7d-bc2e-355550ebb8ec)

## Descrição de cada tabela

- **Usuario e Pessoas** (um para um). Cada pessoa deverá ter um usuário associado
- **Usuario e Endereco** (um para muitos) Um usuario pode ter muitos endereços, mas um endereço só pode ter um usuário relacionado
- **Usuario e Eletrodomesticos e Eletrodomesticos_Usuarios** (tabela de join) (muitos para muitos). Muitos usuários podem utilizar o mesmo eletrodomesticos e os eletrodomesticos podem ser utilizados por muitos usuários
- **Pessoa e Relacionamento** (Um para muitos). Uma pessoa pode ter muitos relacionamentos/dependentes familiares

## Desafios encontrados durante o desenvolvimento

### Relacionamento entre Pessoa e Dependentes
Antes de iniciar o desenvolvimento, testei 3 formas de fazer o relacionamento entre pessoa e dependente
1. Arvore hierárquica: Útil para diversos casos como por exemplo, estruturas de pasta, empresa e departamento, porém para casos com relacionamento familiar obtive alguns problemas para saber o topo da árvore hierárquica e também com o passar do tempo a consulta começa a ficar muito complexa e dificultando a manutenção do código e resoluções de erros
2. Relacionamento de muitos para muitos com tabela de join: Também útil para diversos casos, mas não para relacionameto familiar. Quando utilizei esse relacionamento, tive que criar uma tabela para dependente, duplicando assim os dados entre Pessoa e Dependente para que posteriormente adicionar suas chaves primarias na tabela de join. Porém nesse caso ficaria complexo eu passar um dependente para o todo da árvore e também estaria deixando duas tabelas com praticamente os mesmos dados entre Pessoa e Dependente, que no caso de relacionamento familiar onde dependente também é uma pessoa não seria muito interessante.
3. Nesse terceiro teste foi a melhor forma para criar relacionamentos familiares e também é a forma que estou utilizando no código. Tive que criar uma tabela Pessoa onde ficariam armazenadas todas as pessoas, independentemente se ela está no topo da árvore ou se ela é um dependente, afinal em nosso cenário um dependente também é uma pessoa. Criei também uma tabela chamada relacionamento, onde a uma coluna chamada de superior que irá armazenar o CPF da pessoa no qual é a superior daquela que está na coluna dependente. Também existe uma terceira coluna chamada parentesco, onde estão armazenados o tipo de parentesco do dependente em relação ao seu superior.

### record vs classes
Durante o desenvolvimento, iniciei utilizando apenas o **record** para construir as minhas DTOs. Mas conforme fui avançando precisei substituir de **record** para **class** porque precisei utilizar outros construtores dentro classe da mesma classe, sem ter que ficar fazendo if e else ou ficar enviando null ao construtor do record. 

### Estrutura do projeto
Criei um projeto utilizando uma estrutura semelhante ao DDD conforme aprendido na fase 2, mas modifiquei alguns pontos para melhor se adaptar ao meu cenário de uso.

1. Pacote de `Aplicacao`: Onde estão a junção entre o meu domínio e da minha infraestrutura e regras de negócio
2. Pacote de `Domain`: Onde estão as minhas entidades e as minhas regras de negócio. Adicionei como regra de negócio o cálculo do consumo de energia por hora de uso.
3. Pacote `Infra`: Onde fica a comunicação entre o banco e a minha aplicação.
4. Pacote `View`: Onde enviamos ou recebemos as informações dos usuários externos ou de sistema externos, nesse pacote também estão as DTOs
5. Pacote `util`: Onde estão as classes que identificam algum erro e formata de uma forma inteligível ao utilizados 

## Ferramentas utilizadas
- Docker para subir o banco de dados postgresql



