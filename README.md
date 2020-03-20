# Exercício Prático - Viridis

Projeto relativo ao processo seletivo para posição em desenvolvimento de software na Viridis.

---

## API Gestão de Ativos Industriais

---

**1. Requerimentos**:

- JDK 8
- PostgreSQL (username=postgres, password=1234, acessível pela porta 5432)

**2. Gerar JAR**

Vá ao root folder - onde o pom.xml está - e execute o comando:

`./mvnw package -Dmaven.test.skip=true`

Um novo arquivo `exercicio-0.0.1-SNAPSHOT.jar` deverá ter sido criado em `exercicio/target`.


**3. Rodando a aplicação**

Execute:

`./mvnw spring-boot:run`


A aplicação será criada e ficará acessível pela `url` `localhost:8080`.

Devido a não haver endpoint de criação para a entidade Equipamento, é necessário que um ou mais equipamentos sejam criados via SQL, para poderem ser associados às ordens de manutenção.
O nome da tabela é `equipamento`, e suas colunas são `id` e `nome`.

A API pode ser testada através da Swagger UI acessível pela `url` `localhost:8080/swagger-ui.html`

---

## Considerações Finais

Foi um prazer e uma boa experiência de aprendizado participar deste processo seletivo, pois além de exercitar minhas habilidades, pude utilizar novas ferramentas pela primeira vez.

---

## Autor

**Bernardo Costa Bastos de Oliveira** 

