# appGrupo5Consumidor

Proyecto consumidor RabbitMQ - Grupo 5.

## Versiones solicitadas
- Java 25
- Spring Boot 4.1.1
- Spring Cloud 2025.1.3
- Maven

## RabbitMQ
- Queue: `Grupo5Queue`
- Exchange: `Grupo5Exchange`
- Routing Key: `Grupo5Routing`

## Flujo
1. Escucha `Grupo5Queue`.
2. Recibe un String de numeros separados por `;`.
3. Convierte el String a `Integer[]`.
4. Ordena usando `MergeSortService`.
5. Espera 20 segundos.
6. Imprime la lista ordenada en consola.

## Ejecucion
1. Tener RabbitMQ ejecutandose en `localhost:5672`.
2. Abrir el proyecto en IntelliJ IDEA.
3. Configurar Project SDK/JDK 25.
4. Recargar Maven.
5. Ejecutar `AppGrupo5ConsumidorApplication`.
