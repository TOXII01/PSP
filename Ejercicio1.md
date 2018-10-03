  Conceptos Básicos de JAVA
  ======
  
   Clase
   ------
   
   Cuando hablamos de una clase hablamos básicamente de una unidad donde se guardan unos datos y unas operaciones, es una plantilla   donde vamos definiendo la forma que va a tomar un objeto, como va a ser y que operaciones puede realizar.  
   Podemos tomar un ejemplo básico como la clase Persona :   
   ¿Cuales son las caracterísitas que pueden definir a las personas?  
    - Nombre  
    - Edad   
    - DNI...  
    
   Las características que tenemos es lo que en Java se llamaría ATRIBUTO.  
   Y ahora, ¿Qué hacen las personas?  
    -Comer  
    -Dormir  
    -Andar...  
    Estos comportamientos es lo que en Java se llamarían métodos.  
    Ya esta, con esto podemos construir una clase.
   
   ```java
    
    public class Persona() {
        //ATRIBUTOS
      private String dni;
      private String nombre;
      private int edad;
      
        //METODOS
      public void comer() {}
      public void dormir() {}
      public void andar() {}
      }
```
       
   Objeto
   ------
  
  Cuando hablamos de Objeto nos referimos a la instancia de una clase, es decir, un objeto es  de un elemento que esta basado en la clase,que es una plantilla, a la que hace referencia. Los objetos tienen identidad, lo que les distingue de otros objetos de la misma clase(del mismo tipo), un comportamiento(los métodos que pueden hacer) y un estado(los atributos que tienen). 
  Vamos con un ejemplo siguiendo el anterior :  
```java
    //TENEMOS LA CLASE 
    public class Persona() {}
    //Y TENEMOS EL OBJETO
    Persona p = new Persona("12341234F","Toxii01",20);
    //LOS METODOS SE PUEDEN INVOCAR ASÍ
    p.comer();
    p.dormir();
    p.andar();
```
  
   Sobrecarga de métodos
   ------
   Herencia
   ------
   Polimorfismo
   ------
   Interface
   ------



