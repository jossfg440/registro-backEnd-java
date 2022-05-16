# registro-backEnd-java
El proyecto se realizó siguiendo la implementación de Arquitectura Hexagonal. Esta realizado con java 11, spring boot framework, jpa utiliza base en memoria H2.

Tiene la siguiente extructura:

1) Dominio
Se definió un objecto ClienteDto interactúa con los puertos externos para manejar la persitencia .

2) Core
Aquí se encuentra la lógica de negocio de las operaciones que se van ha manejar para el registro del Cliente.

3) Outbound Ports
En este puerto se maneja la interface que luego se utilizará cuando se implemente la persistencia.

4) Inbound Ports
Se encuentra interface que utilizará los puertos internos en el caso de Rest.

5) Adapter Implementation 
En esta parte se realiza la implementación de la persistencia . Se utiliza JPA.

6) Rest
Se definen los métodos rest con los cuales interactua el Core.
Los servicios rest definidos permiten agregar, eliminar, actualizar el objecto cliente definido anteriormente.



Para ejecutar el proyecto se requiere Spring Tool Suite4 STS y efectuar los siguientes pasos:

1) Clone el proyecto en su maquina local.
2) Abra el IDE Importe el proyecto clonado.
3) Busque el directorio registro-starter y ejecutar Spring Boot App.
