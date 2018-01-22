# Overview

This is starter template for writing Android apps using **Clean architecture**. It supports 
**API 16 and above**.

## Clean architecture

The project has three separated layers:

###Data Layer

This module should hold everything related to data persistence and Android. Here we will find
DAOs, ORMs, SharedPreferences, network related stuff like Retrofit services and similar. 
It can use and reference models from the **domain-layer**. But it can not have a reference 
to model class that belongs from the **presentation-layer**.

###Domain Layer

Business rules: all the logic happens in this layer. All the interactors (use cases) 
implementations, entities, repositories interfaces are here as well. All the external 
components use interfaces when connecting to the business objects (device interfaces). **It 
can not have a reference to model class that belongs to other layers.** 

###Presentation Layer

This module should hold all the classes related to the Android UI such as presenters, 
controllers, custom view models, adapters and views. It supports MVP pattern. It can use and 
reference models from the **domain-layer**. It can not have a reference to model class that 
belongs from the **data-layer**.


## Libraries included

 - [Android Support Library] for backwards compatibility
 - [Butterknife] for view injection
 - [Retrofit] for network code.
 - [JUnit] and [Mockito] for testing.
 - [Room] for managing local database.
 - [RxJava] for reactive programming.
 - [Leakcanary] for memory leak detection (only in DEBUG mode).
 - [GSON] for converting Java Objects into their JSON representation.
 - [LiveData] and [ViewModel] from Android Architecture Components.
 - [Dagger 2] for injection.


[Android Support Library]: <https://developer.android.com/tools/support-library/index.html>
[Butterknife]: <https://github.com/JakeWharton/butterknife>
[Retrofit]: <https://square.github.io/retrofit/>
[Mockito]: <http://site.mockito.org/>
[JUnit]: <https://github.com/junit-team/junit/wiki/Download-and-Install>
[Room]: <https://developer.android.com/topic/libraries/architecture/room.html>
[RxJava]: <https://github.com/ReactiveX/RxAndroid>
[Leakcanary]: <https://github.com/square/leakcanary>
[GSON]: <https://github.com/google/gson>
[LiveData]: <https://developer.android.com/topic/libraries/architecture/livedata.html>
[ViewModel]: <https://developer.android.com/topic/libraries/architecture/viewmodel.html>
[Dagger 2]: <https://google.github.io/dagger/android.html>
[Android-CleanArchitecture]: <https://github.com/android10/Android-CleanArchitecture>
