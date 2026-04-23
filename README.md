# Projeto TI

## Descrição

Este é um sistema de gerenciamento de chamados, equipamentos e usuários desenvolvido em Java. O projeto utiliza uma arquitetura MVC (Model-View-Controller) com camadas de serviço e DAO para acesso a dados. A interface gráfica é construída com Swing, e a persistência é gerenciada via JPA.

## Funcionalidades

- Gerenciamento de usuários
- Gerenciamento de equipamentos
- Sistema de chamados/tickets
- Consultas e visualizações

## Tecnologias Utilizadas

- **Linguagem**: Java
- **Framework de Interface**: Swing
- **Persistência**: JPA (Java Persistence API)
- **Build Tool**: Ant
- **IDE**: NetBeans
- **Banco de Dados**: Configurado via `db.properties` e `persistence.xml`

## Estrutura do Projeto

```
src/
├── br/ulbra/
│   ├── controller/     # Controladores da aplicação
│   ├── dao/           # Data Access Objects e implementações
│   ├── model/         # Modelos de dados (entidades)
│   ├── service/       # Camada de serviços
│   └── view/          # Interfaces gráficas (Swing)
├── db.properties      # Configurações do banco de dados
build/
├── classes/           # Arquivos compilados
nbproject/             # Configurações do NetBeans
test/                  # Testes
```

## Pré-requisitos

- JDK 8 ou superior instalado
- NetBeans IDE
- Banco de dados compatível com JPA (ex: MySQL, PostgreSQL)

## Instalação e Configuração

1. **Clone ou baixe o projeto**:
   ```
   git clone <url-do-repositorio>
   ```

2. **Abra no NetBeans**:
   - Abra o NetBeans IDE
   - Selecione "File" > "Open Project"
   - Navegue até a pasta do projeto e selecione-o

3. **Configure o banco de dados**:
   - Edite o arquivo `src/db.properties` com suas configurações de banco
   - Verifique o `src/META-INF/persistence.xml` para configurações JPA

4. **Build o projeto**:
   - No NetBeans, clique com o botão direito no projeto
   - Selecione "Build" ou use o comando Ant: `ant compile`

## Como Executar

1. **Via NetBeans**:
   - Clique com o botão direito no projeto
   - Selecione "Run"

2. **Via linha de comando**:
   ```
   ant run
   ```

## Desenvolvimento

- As classes principais estão organizadas em pacotes:
  - `model`: Entidades JPA
  - `dao`: Interfaces e implementações para acesso a dados
  - `service`: Lógica de negócio
  - `controller`: Controladores da aplicação
  - `view`: Interfaces gráficas

## Contribuição

Para contribuir com o projeto:
1. Faça um fork do repositório
2. Crie uma branch para sua feature
3. Commit suas mudanças
4. Push para a branch
5. Abra um Pull Request

## Licença

Este projeto está sob a licença [MIT](LICENSE). Consulte o arquivo LICENSE para mais detalhes.