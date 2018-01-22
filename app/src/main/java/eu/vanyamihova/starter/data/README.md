## Data Layer

This module should hold everything related to data persistence and Android. Here we will find
DAOs, ORMs, SharedPreferences, network related stuff like Retrofit services and similar. 

#### Communication
- It can use and reference models from the **domain-layer**
- It can not have a reference to a model class that belongs from the **presentation-layer**
