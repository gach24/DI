# Enunciado
Vamos a realizar una aplicación que se encargue de gestionar partidos de rugby. La
aplicación no tendrá interfaz gráfico y funcionará en consola. Debes programar y
estructurar la aplicación de la mejor manera que sepas, siempre adaptándose a la
funcionalidad que se indica a continuación.
De cada partido de rugby se almacenará la siguiente información.
- Equipo local (cadena de texto)
- Equipo visitante (cadena de texto)
- División. A seleccionar entre primera, segunda o tercera.
- Resultado (formato número-número, por ejemplo, 23-34).
- Fecha (en formato 30-10-2017).

Se permitirán las siguientes operaciones:
- Alta de un nuevo partido
- Mostrar un listado de partidos
- Borrado de un partido
- Mostrar los partidos ordenados. Se permitirá ordenar por fecha y el orden
podrá ser ascendente o descendente según decida el usuario.
- Mostrar todos los partidos de una división seleccionada (si se selecciona la
primera división solo se mostrarán los partidos de ésta).
- Persistencia de datos
- Al salir de la aplicación los partidos se guardarán en un fichero. Si no existe
se creará.
- Al entrar de nuevo en la aplicación se cargarán los partidos que existan en
el fichero predefinido.