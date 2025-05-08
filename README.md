# Events

Events is a simple event management system developed in Java with a console-based interface. It allows users to register and manage local events, confirm or cancel participation, and view upcoming events in chronological order. All data is persisted in plain text files to simulate basic storage.

This project was developed as part of a college assignment for the **Information Systems** program at **UniRitter** (Centro Universitário Ritter dos Reis).

The project follows the **MVC (Model-View-Controller)** architectural pattern to separate responsibilities across the application.

## 📝 Description
**EventManagerApp** is a city event management system that allows users to:
- Register their profiles
- View available events
- Confirm or cancel participation
- Persist event data in a file

## 🚀 Features Implemented

### 👤 User Registration
Users can register with the following attributes:
- Name
- Email
- Date of birth

### 🎉 Event Registration (Admin)
Admin can register events with the following attributes:
- Event name
- Location (address)
- Category (e.g., Show, Sports, Party)
- Event date and time
- Event description

### 🏷️ Event Categories
The available event categories are:
- Sports
- Show
- Party
- Exhibition
- Music

###  View and Participate in Events
- Users can view all available events
- ✅ Users can confirm participation in an event
- ❌ Users can cancel participation in an event they've confirmed

### 📅 Upcoming and Past Events
- The system shows both:
  - 🔜 Upcoming events
  - ⏮️ Past events (events that have already occurred)

### ⏰ Event Ordering by Date/Time
- Events are automatically ordered by their date and time
- Nearest upcoming events are displayed first

### 💾 Data Persistence
- All event data is saved to a text file named `events.data`
- Ensures data persistence between system runs

### 📂 File Reading and Writing
- Event data is saved and read from `events.data` file
- Uses object serialization to store and retrieve event information

## Folder Structure

```
EventManagerApp/
├── bin/                          # Compiled files (binaries)
├── lib/                          # External libraries like JUnit
├── src/                          # Source code of the project
│   ├── controller/               # Controllers managing event and user logic
│   │   ├── EventController.java
│   │   └── UserController.java
│   ├── model/                    # Data models, including main classes
│   │   ├── Event.java
│   │   ├── EventCategory.java
│   │   └── User.java
│   ├── util/                     # Utilities for file and data handling
│   │   ├── EventFileHandler.java
│   │   └── Validator.java        # Validation for user inputs
│   └── Main.java                 # Main class with interactive menu
└── events.data                   # Data file to persist events

```


## How to Run

1. Make sure you have Java installed (Java 8 or above).
2. Clone this repository:
   ```bash
   git clone git@github.com:Marcosschwaab/events-UC-sistema-informacao.git
    ```

   `cd events-UC-sistema-informacao`
---
### PT-BR <span>&#x1f1e7;&#x1f1f7;</span>
___
# Eventos

Events é um sistema simples de gerenciamento de eventos desenvolvido em Java, com interface baseada em console. Ele permite que os usuários cadastrem e gerenciem eventos locais, confirmem ou cancelem participação, e visualizem os próximos eventos em ordem cronológica. Todos os dados são persistidos em arquivos de texto simples para simular um armazenamento básico.

Este projeto foi desenvolvido como parte de uma atividade acadêmica da unidade curricular do curso de **Sistemas de Informação** da **UniRitter** (Centro Universitário Ritter dos Reis).

O projeto segue o padrão arquitetural **MVC (Model-View-Controller)** para separar as responsabilidades dentro da aplicação.

Aqui está o texto formatado em **Markdown**, organizado e com emojis em português:

## 📝 Descrição  
O **EventManagerApp** é um sistema de gerenciamento de eventos urbanos que permite aos usuários:  
- 📝 Cadastrar seu perfil  
- 👀 Visualizar eventos disponíveis  
- ✅ Confirmar ou ❌ cancelar participação  
- 💾 Salvar dados dos eventos em um arquivo  

## 🚀 Funcionalidades Implementadas  

### 👤 Cadastro de Usuários  
Os usuários podem se registrar com os seguintes dados:  
- **Nome**  
- **E-mail**  
- **Data de nascimento**  

### 🎉 Cadastro de Eventos (Admin)  
O administrador pode cadastrar eventos com os seguintes atributos:  
- **Nome do evento**  
- **Local (endereço)**  
- **Categoria** (ex.: Show, Esportes, Festa)  
- **Data e hora do evento**  
- **Descrição do evento**  

### 🏷️ Categorias de Eventos  
As categorias disponíveis são:  
- **Esportes**  
- **Show**  
- **Festa**  
- **Exposição**  
- **Música**  

###  Visualização e Participação em Eventos  
- 👁️ Visualizar todos os eventos disponíveis  
- ✅ **Confirmar participação** em um evento  
- ❌ **Cancelar participação** em um evento confirmado  

### 📅 Eventos Futuros e Passados  
- O sistema mostra:  
  - 🔜 **Eventos futuros** (próximos)  
  - ⏮️ **Eventos passados** (já ocorridos)  

### ⏰ Ordenação por Data/Hora  
- Os eventos são **ordenados automaticamente** por data e hora  
- Os eventos mais próximos aparecem primeiro  

### 💾 Persistência de Dados  
- Todos os dados são salvos em um arquivo **`events.data`**  
- Garante que as informações não sejam perdidas ao fechar o sistema  

### 📂 Leitura e Escrita em Arquivo  
- Os dados são salvos e lidos do arquivo **`events.data`**  
- Usa **serialização de objetos** para armazenar e recuperar informações  

## Estrutura de Pastas

```
EventManagerApp/
├── bin/                          
├── lib/                          
├── src/                         
│   ├── controller/              
│   │   ├── EventController.java
│   │   └── UserController.java
│   ├── model/                    
│   │   ├── Event.java
│   │   ├── EventCategory.java
│   │   └── User.java
│   ├── util/                     
│   │   ├── EventFileHandler.java
│   │   └── Validator.java        
│   └── Main.java                 
└── events.data                  

```


## Funcionalidades

- Cadastro de novos usuários
- Criação e listagem de eventos locais com data e hora
- Confirmação ou cancelamento de participação em eventos
- Ordenação automática de eventos por data e hora
- Salvamento e carregamento dos dados usando arquivos `.txt`



## Como Executar

1. Certifique-se de ter o Java instalado (Java 8 ou superior).
2. Clone este repositório:
   ```bash
   git clone git@github.com:Marcosschwaab/events-UC-sistema-informacao.git
    ```

   `cd events-UC-sistema-informacao`
