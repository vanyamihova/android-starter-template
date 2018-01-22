## Domain Layer

Business rules: all the logic happens in this layer. All the interactors (use cases) 
implementations, entities, repositories interfaces are here as well. All the external 
components use interfaces when connecting to the business objects (device interfaces).

#### Communication
**It can not have a reference to a model class that belongs to other layers.** 
