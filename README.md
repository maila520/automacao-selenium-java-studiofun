# 📌 Projeto de Automação de Testes – StudioFun

Este projeto tem como objetivo validar as principais funcionalidades do sistema **StudioFun**, utilizando automação de testes funcionais com **Selenium WebDriver**, **Java** e **JUnit 5**, seguindo o padrão **Page Object Model (POM)**.

---

## 🧪 Casos de Teste Automatizados

### 🔹 Cenário 1: Realizar login com sucesso

**Dado** que o usuário esteja na tela de login  
**E** informe um e-mail válido  
**E** informe uma senha válida  
**Quando** clicar no botão **Entrar**  
**Então** o sistema deve redirecionar o usuário para a página principal (Dashboard)

---

### 🔹 Cenário 2: Recuperação de senha com e-mail válido

**Dado** que o usuário acesse a tela de login  
**E** clique na opção **“Esqueci minha senha”**  
**Quando** informar um e-mail válido e cadastrado  
**E** enviar a solicitação de recuperação  
**Então** o sistema deve exibir uma mensagem de confirmação  
**E** informar que as instruções foram enviadas para o e-mail informado

---

### 🔹 Cenário 3: Tentativa de login com e-mail inválido

**Dado** que o usuário esteja na tela de login  
**E** informe um e-mail inválido  
**E** informe uma senha válida  
**Quando** clicar no botão **Entrar**  
**Então** o sistema deve exibir uma mensagem de alerta informando que o e-mail ou a senha são inválidos

---

### 🔹 Cenário 4: Tentativa de login com senha inválida

**Dado** que o usuário esteja na tela de login  
**E** informe um e-mail válido  
**E** informe uma senha inválida  
**Quando** clicar no botão **Entrar**  
**Então** o sistema deve exibir uma mensagem de alerta informando que o e-mail ou a senha são inválidos

---

## 🛠️ Tecnologias Utilizadas

- Java
- Selenium WebDriver
- JUnit 5
- Maven
- Page Object Model (POM)
- IntelliJ IDEA

---

## 📂 Estrutura do Projeto

- **base**: Configurações base do WebDriver
- **pages**: Page Objects das telas do sistema
- **tests**: Classes de teste automatizado
- **utils** (se aplicável): Métodos auxiliares

---

## ✅ Observações

- Os testes foram desenvolvidos seguindo boas práticas de automação.
- As validações priorizam comportamento do sistema ao invés de textos fixos, tornando os testes mais robustos.
- O projeto está em evolução contínua conforme novos cenários são identificados.
