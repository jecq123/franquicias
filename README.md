# Proyecto Spring Boot - Java 17

Este proyecto es una aplicación desarrollada en Spring Boot con Java 17. A continuación, los pasos para ejecutarlo en tu entorno local.

---

## Requisitos Previos
Antes de ejecutar la aplicación, asegúrate de tener instalado:

- [Java 17](https://adoptium.net/)
- [Gradle](https://gradle.org/)


---

## Como Ejecutar la Aplicacion

### Clonar el Repositorio

git clone https://github.com/jecq123/franquicias.git

para ejecutarlo se puede pueden seguir los siguientes pasos
# Limpiar y construir la aplicación
./gradlew clean build -x test

# Ejecutar la aplicación
java -jar build/libs/mi-aplicacion-0.0.1-SNAPSHOT.jar

# O si prefieres puedes ejecutarlo desde gradle
./gradlew bootRun

 Tambien es facil ejecutarlo utilizando intellij, simplemente dandole click derecho y ejecutar a la clase principal

---

# Terraform
Se implemento terraform desde el siguiente repositorio https://github.com/jecq123/nequi_iac

En el se ejecutaron la mayoria de los servicios que se necesitan para desplegar la aplicacion en aws,
tambien la base de datos que tambien se utiliza en el desarrollo local. Se creo un pipeline en github para ejecutarlo

---

# Dockerfile

Se creo el dockerfile para poder desplegar el proyecto en dockerl, de la misma manera que en el paso anterior 
se creo un pipelien de github para desplegarlo en la infra de aws, pero no se alcanzo a completar exitosamente

---

# Uso
Los consumos de la aplicacion se pueden observar en las clases FranquiciaControlador, ProductoControlador y SucursalControlador, 
en ellos tenemos todos los endpoints pedidos en el ejercicio.

Se accede a traves de los siguientes endpoints para la creacion, al crearlo nos devuelve el id, que podemos usarlo para crear los otros objetos

POST
http://localhost:8080/franquicias
body: {
"nombre":"franquicia1"
}

POST
http://localhost:8080/sucursales
body: {
"nombre":"sucursal1",
"franquiciaId":idFranquicia
}

POST
http://localhost:8080/productos
body: {
"nombre":"producto1",
"sucursalId":idSucursal
}

Se accede a traves de los siguientes endpoints para la modificacion de nombre

PUT
http://localhost:8080/franquicias/nombre/{id}
body: {
"nombre":"franquicia2"
}

PUT
http://localhost:8080/sucursales/nombre/{id}
body: {
"nombre":"nombre2"
}

PUT
http://localhost:8080/productos/nombre/{id}
body: {
"nombre":"producto2"
}

El siguiente endpoint para borrar

DELETE
http://localhost:8080/productos/{id}

El siguiente endpoint para modificar stock

PUT
http://localhost:8080/productos/modificar-stock
body: {
"productoId":{id},
"nuevoStock":30
}


Y el ultimo endpoint para la consulta de los productos con mas stock por sucursal de una franquicia en especifico

GET
http://localhost:8080/productos/mayor-stock/franquicia/{id}



