# Factory-method pattern
```
.
├── pizza                           // Product
│     ├── chicago_chees_pizza.go
│     ├── chicago_veggie_pizza.go
│     ├── ny_cheese_pizza.go
│     ├── ny_veggie_pizza.go
│     └── pizza.go
│
├── pizzastore                      // Creator
│     ├── chicago_pizza_store.go
│     ├── ny_pizza_store.go
│     └── pizza_store.go
│
├── go.mod
└── main.go
```

# Abstract Factory pattern
```
.
├── cheese
│      ├── cheese.go
│      ├── mozzarella_cheese.go
│      └── parmesan_cheese.go
├── dough
│      ├── dough.go
│      ├── thick_dough.go
│      └── thin_dough.go
├── sauce
│      ├── marinara_sauce.go
│      ├── plum_tomato_sauce.go
│      └── sauce.go
│
├── pizza
│      ├── cheese_pizza.go
│      ├── pizza.go
│      └── veggie_pizza.go
│
├── pizzafactory
│      ├── chicago_pizza_ingredient_factory.go
│      ├── ny_pizza_ingredient_factory.go
│      └── pizza_ingredient_factory.go
│
├── pizzastore
│      ├── chicago_pizza_store.go
│      ├── ny_pizza_store.go
│      └── pizza_store.go
│
├── go.mod
└── main.go
```