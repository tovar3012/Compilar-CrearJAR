# Cómo Compilar y Ejecutar archivos Java desde la Consola

Una vez que lo hayas bajado e instalado correctamente, procede a buscar la ruta de instalación por ejemplo:
  
  > C:\Program Files\Java\jdk1.7.0_02\bin

Esa dirección es la ruta que tendremos que agregar a la variable de entorno Path, para ello debemos ir a:

  > Mi PC -> Click derecho -> Propiedades -> [Pestaña] Opciones Avanzadas -> Variables de Entorno

  > Equipo -> Click derecho -> Propiedades -> Configuración Avanzada del Sistema -> [Pestaña] Opciones Avanzadas -> Variables de Entorno

Buscamos en el cuadro mostrado la variable de nombre Path, presionamos Editar, en el cuadro mostrado, nos vamos hasta el final del texto que ya está escrito y agregamos lo siguiente sin las comillas:

  > ";C:\Program Files\Java\jdk1.7.0_02\bin;"
  
Una vez que hayamos añadido la ruta, presionamos OK, luego nuevamente OK e iniciamos una consola (cmd) y escribimos javac, nos debería salir informacion referente a este comando.

Abrimos el Bloc de Notas (Como saben, no se requiere de un IDE al 100% para programar en Java), y escribimos el siguiente código:

class HolaMundo{
 public static void main(String[] args){
  System.out.println("Hola Mundo!");
 }
}

Luego guardamos el archivo con el nombre "HolaMundo.java", en mi caso lo guardé en la raíz del disco duro, es decir en: 
"C:\HolaMundo.java", para compilarlo ejecutamos la siguiente sentencia:
  >javac HolaMundo.java

Esto nos genera un archivo HolaMundo.class, y para ejecutar el código compilado en la Consola escribimos:

  > java HolaMundo

Muy importante, no se coloca la extensión del archivo (es decir el .class)

# Cómo Crear un Jar con Java desde la Consola

 Para crear los archivos .jar debemos primero crear un Archivo de Manifiesto  en el cual se deberá poner el nombre de la clase que contenga el método main, este archivo en Windows puede ser creado a partir del Bloc de Notas, entonces abrimos el Notepad (Bloc de Notas) y escribimos lo siguiente:

Main-Class: HolaMundo
Sealed: true

*Nótese que no se agrega el .class y que la palabra MAIN-CLASS: es obligatoria.

Donde HolaMundo es el Nombre de la Clase que tiene mi método main, una vez escrito eso lo guardamos con el siguiente nombre en el mismo lugar donde tenemos nuestros archivos .java y .class:

  > temp.mf

Ahora que tenemos todo listo para construir el .jar vamos a la línea de comandos (CMD) y ejecutamos la siguiente sentencia:

  > jar -cf HolaMundo.jar HolaMundo.class


Después de haber ejecutado la sentencia anterior ya tendremos el archivo HolaMundo.jar en nuestro directorio, y contendrá el fichero de manifiesto, la clase o clases que tenga nuestro proyecto, ahora al archivo .jar que tenemos, vamos a modificarlo para indicarle que archivo de manifiesto debe usar, esto con la siguiente sentencia:

  > jar cmf temp.mf HolaMundo.jar HolaMundo.class

Se permiten comodines (por ejemplo, para incluir todos los archivos class de la carpeta o que cumplan con alguna condición dada):

  > jar cmf temp.mf HolaMundo.jar fichero$.class
  > jar cmf temp.mf HolaMundo.jar *.class

Y finalmente ejecutamos nuestro archivo en la línea de comandos con la siguiente llamada:

  > java -jar HolaMundo.jar

Les adjunto una captura de todos los pasos antes mencionados al final del post, para que tengan una mejor idea del Proceso llevado a cabo, les recuerdo que solo empezamos con los archivos:

    HolaMundo.java
    temp.mf

Y a partir de la ejecución de los comandos terminamos con los siguientes archivos:

    HolaMundo.java
    temp.mf
    HolaMundo.class
    HolaMundo.jar

