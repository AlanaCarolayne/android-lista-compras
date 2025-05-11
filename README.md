# 🛒 Lista de Compras

## 📌 Sobre o Projeto:
#### Um aplicativo de lista de compras desenvolvido em Kotlin

#### #### Esse projeto foi desenvolvido durante as aulas do curso **Android Kotlin Developer**, ministrado pelo professor [Ewerton Carreira](https://github.com/carreiras), para colocar em prática os conceitos sobre


## ⚙️ Funcionalidades:
- ✅ Adicionar novos itens à lista de compras
- 🗑️ Remover itens existentes da lista


## 📸 Telas do projeto:

## 🛠 Tecnologias e ferramentas utilizadas:

<div align="center">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/androidstudio/androidstudio-original-wordmark.svg" width="90" align="center"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kotlin/kotlin-original-wordmark.svg" width="90" align="center"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/sqlite/sqlite-original-wordmark.svg" width="90" />

</div>

## 📦 Dependências e plugins:
#### Plugins-> kotlin("kapt"): Usado para habilitar o processamento de anotações, necessário para o Room. 
#### RecyclerView: Responsavel por criar listas dinamicas e lidar com páginação automatica dentro do app
```kotlin
implementation("androidx.recyclerview:recyclerview:1.3.2")
```
#### Room Runtime: Biblioteca principal do Room para acessar e manipular o banco de dados SQLite
```kotlin
implementation("androidx.room:room-runtime:2.4.1")
implementation("androidx.room:room-ktx:2.4.1")
kapt("androidx.room:room-compiler:2.4.1")
``` 
#### Lifecycle - LiveData: Para lidar com "dados vivos", ou seja, para lidar com mudanças que ocorrem no bancod e dados da aplicaçãoe m tempo real
```kotlin
implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
```

#### AppCompat: Para a retrocompatibilidade (capacidade de se adaptar as versões anteriores)
```kotlin
implementation("androidx.appcompat:appcompat:1.4.1")
```
#### Activity KTX: manipulação de activities
```kotlin
implementation("androidx.activity:activity-ktx:1.7.0")
```
#### Coroutines: Para fazer chamadas assíncronas sem bloquear a UI
```kotlin
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
```

## 🤝 Contribuição:
#### Contribuições são bem-vindas! Se você tem alguma ideia ou encontrou um bug, sinta-se à vontade para abrir uma issue ou enviar um pull request. 

