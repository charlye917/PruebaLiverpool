# Shopping Project

https://github.com/charlye917/ShoppingLiverpool/assets/44787787/9eade76f-5b1b-446f-8d83-5d07125ee795

## Introducción
A sample app that display a _"Order books"_, An order book is a record of all the buy and sell orders that have been placed for a particular cryptocurrency pair on a cryptocurrency exchange market.
The order book is typically divided into two sections: one for buy orders and one for sell orders. The orders are recorded in chronological order, from the oldest to the newest. Each order indicates the price and quantity of the cryptocurrency that the buyer or seller wants to buy or sell.
The order book is important because it provides traders with information about the liquidity of the market, as well as the current prices and buying and selling trends for the cryptocurrency in question. Traders can use this information to make informed decisions about when to buy or sell a cryptocurrency and at what price."

## Proyect Structure
The purpose of this project to illustrate the usage of MVVM architecture design pattern that follow the best practices of Clean Architecture using the following technology stack.

1. Clean Architecture
2. MVVM
3. Hilt (Dependency Injection)
4. Live Data, Flow
5. Retrofit
6. Okhttp3
7. AndroidX
8. Glide
9. JetPack Libraries
10. View Binding
11. Coroutines
12. Navigation Component

![Captura de pantalla 2024-04-10 a la(s) 1 30 20 a m](https://github.com/charlye917/ShoppingLiverpool/assets/44787787/fc06ceac-81ba-44bb-ad49-ef5648beef55)


It was decided to use the clean architecture pattern due to its focus on separating the responsibilities of the code in different capabilities and levels of abstraction, with the aim of creating scalable, maintainable and flexible systems, the way to implement it for this project is as follows:

1. Presentation layer: Responsible for displaying the user interface and managing user interaction with the app, using MVVM
2. Domain layer: This layer contains the business logic of the application. Contains business rules and entity classes
3. Data layer: This layer is responsible for obtaining and storing the application data, including access to the local database and remote APIs

For the consume of services, it was decided to use the retrofit library due to its advantages compared to other libraries, among which are its easy integration, the use of its annotations to facilitate the construction of requests and the interpretation of responses, ease of data conversion with the help of the Gson library, its compatibility with OkHttp and its ease of use.

To facilitate data collection through the use of asynchronous programming, it was decided to use LiveData to update the user interface safely and in real time, since in addition to these two advantages it offers us, it helps us by combining it with the data cycle. lifetime of the activity or fragment, which means that the UI update can only be guaranteed when the activity or fragment is in active state.

For obtaining and issuing data, it was decided to use Flow since it allows us to transform and process the data asynchronously.

And as an extra example of its use, it was decided to use RxJava instead of flow for the consumption of one of the services, to see the difference between using this library compared to others

## Libraries

```
agp = "8.3.0"
kotlin = "1.9.23"
coreKtx = "1.12.0"
junit = "4.13.2"
junitVersion = "1.1.5"
espressoCore = "3.5.1"
appcompat = "1.6.1"
material = "1.10.0"
activity = "1.8.0"
constraintlayout = "2.1.4"
retrofitVersion = "2.9.0"
gsonVersion = "2.9.0"
okhttpVersion = "5.0.0-alpha.6"
okhttpUrlconnectionVersion = "4.4.1"
lifecycleVersion = "2.7.0"
coroutinesVersion = "1.7.3"
hiltVersion = "2.48.1"
navVersion = "2.7.7"
glideVersion = "4.14.2"
swipeRefreshVersion = "1.1.0"
multidexVersion = "2.0.1"
```

```
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.material)
  implementation(libs.androidx.activity)
  implementation(libs.androidx.constraintlayout)
  implementation(libs.androidx.swiperefresh)
  
  //RETROFIT
  implementation(libs.gson)
  implementation(libs.retrofit)
  implementation(libs.retrofit.convert)
  
  //OKHTTP
  implementation(libs.okhttp)
  implementation(libs.okhttp.login.interceptor)
  implementation(libs.okhttp.url.conecction)
  
  //VIEWMODEL
  implementation(libs.viewmodel)
  implementation(libs.livedata)
  implementation(libs.savedstate)
  implementation(libs.coroutines)
  
  //HILT
  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)
  
  //NAVIGATION
  implementation(libs.navigation.ui)
  implementation(libs.navigation.fragment)
  
  //Glide
  implementation(libs.glide)
  
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
```


