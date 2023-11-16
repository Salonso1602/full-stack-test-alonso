# Supuestos  
- Datos en los excels que no están completos (tal definido en código, en los importers), se consideran inválidos/incompletos, por lo que se omiten.  
- Se toma un acercamiento BackendForFrontend, ya que se supone que un sistema como el planteado (BI y gestión de RRHH) se define en varios sistemas independientes que se deben reunir en un back único para servir el front. Para esto se trata de separar en capas el back para que el repositorio o los servicios se puedan redefinir en un sistema real.  

# Decisiones/Notas  
- El proceso de importar datos utiliza una cadena de responsabilidad donde cada vinculo revisa si puede crear las entidades que le corresponden y las guarda en bd, este proceso es caro a nivel de procesamiento tanto para BD como para la API, por lo que se plantea como proceso batch a programarse para conjuntos de datos grandes.  
- Se utilizan únicamente un sub-grupo de datos de los determinados como relevantes (los que se consideran necesarios para representar las entidades)  
- Por cuestiones de poco tiempo, no se pudo implementar autenticación plenamente, por lo que es un pendiente. Se planea un sistema basado en roles dado el enfoque planteado en la letra de como cada usuario puede acceder unicamente a sus dependientes (gerente) y a todos los empleados (director).  
- Los datos a importarse se deben agregar en la carpeta "data" de la api, y dar su nombre en el endpoint creado. Los importadores de datos esperan ciertos headers para identificar que representa cada dato.  
- Se prioriza el desarrollo de back, ya que es el area que mas me interesa. Se realiza una demo simple para front pues de todas formas tengo conocimientos full-stack.  
- Se containerizan todos los componentes por facilidad de transporte, despliegue y reproducción.  
- Se decide documentar la API con Swagger, ya que da una interfaz clara del contrato expuesto por la API, y facilita testeo.
