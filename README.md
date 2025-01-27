# Transaction Tracker

Transaction Tracker é um aplicativo desenvolvido em Java com Spring Boot para gerenciar e rastrear transações financeiras. O projeto foi criado como um sistema completo com backend funcional e pronto para integração com um frontend futuro.

## Funcionalidades

- **Gerenciamento de Contas**: Criação, leitura, atualização e exclusão de contas.
- **Segurança**: Implementado com autenticação básica usando Spring Security.
- **Exceções Customizadas**: Manipulação centralizada de erros com mensagens claras.
- **Estrutura Modular**: Código organizado para escalabilidade e manutenibilidade.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.2**
- **Spring Security**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Swagger (OpenAPI)**

## Endpoints Disponíveis

Os endpoints podem ser testados utilizando ferramentas como Insomnia ou Postman. Para documentar e testar, acesse:
- `http://localhost:8080/swagger-ui.html` (se configurado corretamente).

### Endpoints Principais

1. **/api/contas**
    - `GET /api/contas`: Lista todas as contas.
    - `POST /api/contas`: Cria uma nova conta.
    - `GET /api/contas/{id}`: Retorna os detalhes de uma conta específica.
    - `PUT /api/contas/{id}`: Atualiza uma conta existente.
    - `DELETE /api/contas/{id}`: Exclui uma conta.

2. **Autenticação**
    - Usuário: `admin`
    - Senha: `admin123`

## Pré-requisitos

- **JDK 17+**
- **Maven 3.8+**
- **MySQL** (configuração no arquivo `application.properties`)

## Configuração e Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/jojoabs/transaction-tracker.git
   cd transaction-tracker
   ```

2. Configure o banco de dados no arquivo `src/main/resources/application.properties`. Atualize as propriedades de conexão com o MySQL, como exemplo:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/transaction_tracker
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Compile e execute o projeto:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. Acesse o sistema em:
    - API: `http://localhost:8080`

## Estrutura do Projeto

Abaixo está um resumo da estrutura do projeto:

```
transaction-tracker/
├── src/main/java/com/example/transaction_tracker
│   ├── config/                # Configurações como segurança
│   ├── controller/            # Controladores da API REST
│   ├── dto/                   # Objetos de Transferência de Dados (DTOs)
│   ├── exception/             # Manipuladores de exceções customizadas
│   ├── model/                 # Modelos ou entidades JPA
│   ├── repository/            # Interfaces para acesso ao banco de dados
│   ├── service/               # Lógica de negócios
│   └── util/                  # Classes utilitárias
├── src/main/resources/
│   ├── application.properties # Configurações de ambiente
│   └── static/                # Arquivos estáticos (opcional para frontend)
├── src/test/java/             # Testes unitários e de integração
└── pom.xml                    # Arquivo de configuração do Maven
```

## Funcionalidades Futuras (Opcional)

- Adicionar suporte a relatórios financeiros.
- Categorizar transações e contas.
- Implementar autenticação OAuth2 ou JWT para maior segurança.
- Criar um frontend integrado para maior usabilidade.

## Contribuindo

Sinta-se à vontade para contribuir com o projeto. Para isso:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature ou correção:
   ```bash
   git checkout -b minha-feature
   ```
3. Envie seu PR para análise.

## Licença

Este projeto está licenciado sob a **MIT License**. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

---

Se precisar de algo mais para ajustar, é só avisar! 😊
