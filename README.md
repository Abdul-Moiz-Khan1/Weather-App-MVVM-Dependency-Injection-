
# Weather App (MVVM + Dependency Injection)

A clean, maintainable Android weather app built using Kotlin, XML layouts, MVVM architecture, Dependency Injection(Hilt), and a weather API. Displays current weather with offline caching and clear UI separation.

## Description

This app fetches and displays real-time weather data using a remote API and caches results locally for offline access. Designed with MVVM in mind, the codebase is modular, testable, and leverages DI for cleaner dependency management.
        
## Goal

    a. Present current weather information based on user location.
    b. Decouple UI, business logic, and data-fetching using MVVM.
    c. Implement offline caching with Room Database.
    d. Introduce DI to simplify component management and testing.
## Core Features

        a. Current Weather Display (temperature, humidity, condition, icon)
        b. Location-Aware (GPS or manual city selection)
        c. Offline Caching with local persistence
        d. MVVM Architecture
        e. Dependency Injection for repositories, APIs, ViewModels


## Technologies Used

        1. MVVM for ViewModel + LiveData/Flow
        2. DI using hilt
        3. Remote Fetching for Retrofit + OkHttp
        4. Local Caching for Room 
        5. Coroutines For async operations
        6. Data Binding/View Binding XML-based UI wiring

## Working

1. User Location: App fetches user’s current location

2. ViewModel Requests Data: The WeatherViewModel calls a Repository.

3. Data Source Decision:

        a. If offline or local data exists, retrieve cache.

        b. Otherwise, fetch fresh data from the weather API.

        c. Repository Fetches/Caches

        d. Retrieves data from API via Retrofit.

        e. Stores response in local database (Room).

        f. Returns data to ViewModel.

4. ViewModel Updates UI: 
Exposes data via LiveData or StateFlow for the Activity/Fragment to observe and render.

5. Dependency Injection: 
All services (API, Dao, Repository) are provided via DI (Hilt/Dagger).

## Screenshots
Following are the screenshots showing UI and flow of app 

<p align="center">
<img width="250" height="500" alt="weather_splash" src="https://github.com/user-attachments/assets/92f17c0b-7581-46f0-83e1-3135a0f91ccb" />
</p>

<p align="center">
<img width="250" height="500" alt="weather_main" src="https://github.com/user-attachments/assets/8b7d3aae-d2b8-44c4-b227-77fc5fd3d0c4" />
</p>








