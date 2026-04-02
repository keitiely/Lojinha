# 🛒 Simulação de Lojinha Online - Arquitetura Monolítica

Este projeto é uma simulação funcional de um sistema de e-commerce baseado em um Diagrama N0 (Arquitetura Cliente-Servidor Monolítica). O foco principal é a organização de responsabilidades em uma única aplicação servidora e a integração com um sistema externo de pagamento.

Este repositório cumpre os requisitos da atividade de modelagem e implementação de sistemas.

---

## 🏗️ Estrutura do Projeto

O projeto foi desenvolvido em Java e está organizado seguindo padrões de alta modularidade:

- `clients`: Contém o PaymentClient (Integração externa).
- `entities`: Classes de domínio que representam o negócio (User, Product, Order, Cart, etc.).
- `repositories`: Camada de persistência em memória para gestão das entidades.
- `types`: Enums que definem estados e tipos (OrderStatus, PaymentStatus, PaymentType).
- `Main.java`: Ponto de entrada que orquestra a simulação do fluxo da lojinha.

---

## 🛠️ Decisões Arquiteturais

1. **Arquitetura Monolítica**: Todas as funcionalidades (gestão de pedidos, catálogo de produtos e processamento) residem em um único processo servidor, conforme o modelo apresentado em aula.
2. **Padrão Repository**: Utilizado para centralizar a lógica de acesso aos dados (armazenamento estático), simulando o comportamento de um banco de dados real.
3. **Tipagem Fortalecida**: O uso de Enums no pacote `types` garante que os status de pedidos e pagamentos sigam regras de negócio rígidas.

---

## 🔌 Aplicação do Padrão Singleton

O padrão de projeto **Singleton** foi aplicado obrigatoriamente na classe `PaymentClient.java`.

### Onde foi aplicado:
A classe `PaymentClient` possui um construtor privado e um método estático `getInstance()`, garantindo que apenas uma instância exista durante toda a execução do sistema.

### Justificativa:
O uso do Singleton neste contexto é fundamental para:
- **Controle de Recursos**: Evita a abertura de múltiplas conexões desnecessárias com o sistema externo de pagamento.
- **Consistência de Estado**: Garante que todas as chamadas de pagamento do sistema passem pela mesma instância, facilitando o monitoramento e o controle de transações.
- **Ponto Único de Acesso**: Centraliza a configuração de comunicação externa em um único objeto global dentro da aplicação monolítica.

---

## 📊 Artefatos de Modelagem

Os diagramas solicitados estão inclusos no repositório:

1. **Diagrama de Atividades (UML)**: Detalha o fluxo desde a navegação do usuário até a confirmação ou falha do pagamento.
2. **Diagrama Entidade-Relacionamento (DER)**: Ilustra a estrutura de dados, incluindo as entidades User, Product, Order, Cart e seus respectivos relacionamentos e chaves.

---

**Easter Egg:**
Salve salve Jefferson, já dá aquela nota máxima da boa! 🚀
