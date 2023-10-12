# Registro de Cambios
## [1.0.32] - 12/10/2023 (Juandb1507)

- Se agregaron las variables para valores iniciales al Dashboard Principal
- Se colocó en el tabbedPane de MainInterface

## [1.0.31] - 11/10/2023 (Sebasr22)

- Se agrego dias restantes a la interfaz de Nintendo y el PM ya lo actualiza al igual que el director. Al igual que en Bethesda.

## [1.0.30] - 11/10/2023 (Juandb1507)

- Lógica Director
- Link Director con Nintendo y Bethesda
- Correcciones varias

## [1.0.29] - 11/10/2023 (Sebasr22)

- Se corrigio algo en PM que hacia que no se cambiara el estado despues del primer dia.

## [1.0.28] - 11/10/2023 (Sebasr22)

- PM ya en Nintendo y Bethesda

## [1.0.29] - 11/10/2023 (Sebasr22)

- Se corrigio algo en PM que hacia que no se cambiara el estado despues del primer dia.

## [1.0.28] - 11/10/2023 (Sebasr22)

- PM ya en Nintendo y Bethesda

## [1.0.27] - 11/10/2023 (Sebasr22)

-- Finalizacion de la clase PM.

## [1.0.26] - 11/10/2023 (Sebasr22)

- Fix error en el integrador, listo en ambas interfaz. 

## [1.0.25] - 11/10/2023 (Sebasr22)

- Se agrego integreador a Nintendo. 

## [1.0.24] - 11/10/2023 (Sebasr22)

- Cambios en los desarrolladores y ajustes de valores segun mi carnet a la clase nintendo.

## [1.0.23] - 11/10/2023 (Sebasr22)

- Finalizacion de la clase de integrador y se vinculo con la interfaz Bethesda.
- Cambios en todos los desarrolladores para actualizar los valores de las cantidades desarrolladas en la interfaz.

## [1.0.22] - 10/10/2023 (Juandb1507)

- Creación de las variables diasParaEntrega, ganancia, juegosGenerados, juegosDLCGenerados de Nintendo y Bethesda.
- Creación estadoDirector, estadoPM, faltasPM, descontadoPM  (Nintendo y Bethesda)


## [1.0.21] - 09/10/2023 (Juandb1507)

- Se realizó la clase Nintendo, NintendoStudio y se conectaron entre sí.
- Se completó la lógica faltante en los distintos desarrolladores (Relacionada al estudio Nintendo).
- Background, logos e iconos para los Dashboard de Nintendo y Bethesda.


## [1.0.20] - 08/10/2023 (Juandb1507)

- Corrección lógica generarSprite en DesarrolladorSprites


## [1.0.19] - 08/10/2023 (Sebasr22)

- Link de Desarrollador Logica con BethesdaStudio y Bethesda(UI)
- Link de Desarrollador Sprites con BethesdaStudio y Bethesda(UI)

## [1.0.18] - 08/10/2023 (Juandb1507)

- Creación de un hilo "Funciones" para registrar el paso de cada día y actualizar valores en UI.

## [1.0.17] - 08/10/2023 (Juandb1507)

- Desarrollo completo de la clase DesarrolladoresDLC.
- Link de DesarrolladoresDLC con BethesdaStudio y Bethesda(UI).
- Se añadió el fondo y logotipo a la UI de Bethesda.

## [1.0.16] - 07/10/2023 (Juandb1507)

- Desarrollo de la lógica del método Stop para los hilos Desarrolladores


## [1.0.15] - 07/10/2023 (Juandb1507)

- Desarrollador Nivel
- Desarrollador Naarrativa
- Bethesda UI

## [1.0.14] - 07/10/2023 (Sebasr22)

- Desarrollador Sprites (Falta agregar la logica de los estudios)
- Desarrollador Logica (Falta agregar la logica de los estudios)

## [1.0.13] - 07/10/2023 (Juandb1507)

- Se corrigió la lógica para almacenar el totalPay de los trabajadores.

## [1.0.12] - 07/10/2023 (Sebasr22)

- Se finalizo la clase integrador, falta agregarle los drives de los otros desarrolladores
  y agregarlo tambien al metodo de generar juego. (Falta la logica de los DLC)

## [1.0.11] - 07/10/2023 (Juandb1507)

- Se hicieron cambios en Desarrollador Narrativa agregando contador de guiones en drive.
- Se almacenan en un array los desarrolladores creados.
- Lógica para eliminar a un desarrollador del array reducir la cantidad en el spinner
- Se vizualiza en UI de Bethesda el espaciio ocupado en Drive
- Creación de Desarrollador Narrativa segun el parametro inicial del spinner. 

## [1.0.10] - 07/10/2023 (Sebasr22)

- Se hicieron cambios en Desarrollador de narrativa (Elimine parametros innecesarios)
- Ya el main tiene una base de:
    - Se crea una lista de desarrolladores de narrativa, donde se va guardando cada nuevo hilo de Desarrollador
      de narrativa, con el nombre del hilo, aparecen mas datos que supongo que es:
      (Numero del hilo, nombre del hilo, un numero que no se que es, archivo desde donde se crea)
      De esta manera podemos manejar cuando se quiera agregar y eliminar trabajadores. 
    - Es la base estructurada que se trabajara no desde el main, si no desde el archivo donde queramos
      realizar esas operaciones. 

## [1.0.9] - 06/10/2023 (Juandb1507)

- Cambios interfaz Bethesda y TabbedPane del Dashboard principal.
- Lógica de creación de hilos.

## [1.0.8] - 05/10/2023 (Sebasr22)

- Se agregaron los pagos a los desarrolladores de narrativa.

## [1.0.7] - 05/10/2023 (Sebasr22)

- Ya el drive es general no importa el numero de desarrolladores. 

## [1.0.6] - 05/10/2023 (Sebasr22)

- Se agregaron los pagos a los desarrolladores de narrativa.

## [1.0.5] - 05/10/2023 (Sebasr22)

- Ya funciona desarrollador de narrativa, falta agregar los pagos, pero ya funciona
  la generacion de guiones y el drive.

## [1.0.4] - 02/10/2023 (Juandb1507)

-Creación de las clases de desarrolladores 
-Creación de la clase Director, Project , Studio, Funciones e Integrador
- Inicio del Main Dashboard

## [1.0.3] - 30/09/2023 (Sebasr22)

- Eliminacion del archivo general Empleado.
- Inicio del archivo Desarrollador Narrativa.

## [1.0.2] - 30/09/2023 (Sebasr22)

- Creacion de archivos de interfaces.

## [1.0.1] - 18/09/2023 (Sebasr22)

- Creacion de carpetas para un mejor manejo de archivos.
- Creacion de clase Empleado.

## [1.0.0] - 17/09/2023 (Sebasr22)

- Creacion del proyecto.


