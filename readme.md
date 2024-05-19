# Práctica de Java con Spring Boot: Consulta de Personajes de Rick and Morty

## Descripción del Proyecto

Este proyecto es una aplicación web construida con Spring Boot que permite consultar información sobre los personajes de la serie "Rick and Morty" realizando consultas a la api https://rickandmortyapi.com. La aplicación ofrece varias funcionalidades, incluyendo la búsqueda de personajes por nombre y episodio, la obtención de imágenes de personajes específicos, y el registro de las búsquedas realizadas por los usuarios.

## Funcionalidades

### 1. Buscar Personajes por Nombre y Episodio

La aplicación permite buscar personajes de "Rick and Morty" mediante diferentes criterios.

### 2. Obtener la Imagen de un Personaje Específico

Puedes obtener la imagen de un personaje específico utilizando su ID. 


### 3. Mostrar las Búsquedas Realizadas por un Usuario

La aplicación registra las búsquedas de personajes que los usuarios realizan. Puedes ver todas las búsquedas relacionadas a personajes realizadas por cualquier usuario.


### 4. Mostrar las Búsquedas Realizadas por un Usuario Específico

Además de mostrar todas las búsquedas, puedes filtrar las búsquedas realizadas por un usuario específico.

## Endpoints Resumen

| Endpoint                                        | Descripción                                           |
|-------------------------------------------------|-------------------------------------------------------|
| `GET /characters`                               | Devuelve todos los personajes                         |
| `GET /characters/name?name={name}`              | Devuelve personajes cuyo nombre contiene `{name}`     |
| `GET /characters/episode/{episodeId}`           | Devuelve personajes que aparecen en el episodio `{episodeId}` |
| `GET /characters/image/{characterId}`           | Devuelve la imagen del personaje con ID `{characterId}` |
| `GET /searches`                                 | Devuelve todas las búsquedas de personajes            |
| `GET /searches/user/{userId}`                   | Devuelve las búsquedas del usuario con ID `{userId}`  |


## Conclusión

Esta práctica proporciona una forma interactiva de explorar los personajes de "Rick and Morty" mediante una API RESTful construida con Spring Boot. Además, permite rastrear y visualizar las búsquedas de los usuarios, ofreciendo una funcionalidad útil para análisis y monitoreo.



