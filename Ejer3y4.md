# Ejercicios Java/Tester  

## Ejercicio 3  
Construir la mejor consulta SQL para obtener todos los registros de una tabla llamada "Ciudadanos" que cumplan con las siguientes condiciones:  
- el "Nombre" empieza con las siguientes letras "Ped" o "San"  
- el "Apellido" sea de menos de 15 caracteres  

``` sql
SELECT *
FROM Ciudadanos C
WHERE (C.Nombre LIKE 'Ped%' OR C.Nombre LIKE 'San%')
AND LENGTH(C.Apellido) < 15;
```

## Ejercicio 4  
Construir la mejor consulta SQL para obtener todos los nombres ("Nombre") únicos existentes en la tabla "Ciudadanos" y devolverlos ordenados alfabéticamente.   

``` sql
SELECT DISTINCT C.Nombre
FROM Ciudadanos C
ORDER BY C.Nombre ASC;
```
