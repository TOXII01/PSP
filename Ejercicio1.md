  Conceptos Básicos de JAVA
  ======
  
   Clase
   ------
   
   Una **clase** es básicamente una unidad donde se guardan unos datos y unas operaciones, es una plantilla   donde vamos definiendo la forma que va a tomar un objeto, como va a ser y que operaciones puede realizar.  
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
    Ya está, con esto podemos construir una clase.
   
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
  
  Cuando hablamos de **Objeto** nos referimos a la instancia de una **clase**, es decir, un objeto es de un elemento que esta basado en la clase,que es una plantilla, a la que hace referencia. Los objetos tienen identidad, lo que les distingue de otros objetos de la misma clase(del mismo tipo), un comportamiento(los métodos que pueden hacer) y un estado(los atributos que tienen). 
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
   Encapsulación
   ------
   La encapsulación es la ocultación de información al usuario, es decir, la información no necesaria, solo lo que se haya programado que sea útil para el usuario se mostrará, el funcionamiento interno se oculta ya que no es necesario que el usuario vea como son los procesos internos para cualquier acción que se haga en el programa. Por ello existen 3 niveles de visibilidad **Public**, que indica que se puede usar desde cualquier clase, **Protected** solo se puede usar en el mismo paquete, y **Private**, que sólo sirve para la misma clase.
    Por ejemplo podemos crear  un programa de gestión de empleados, cada empleado tiene su función en la empresa, si queremos pedir datos del empleado, como la función que realizan, el programa nos la mostrará pero las llamadas internas que tiene que hacer no las muestra, desde que se introduce la orden hasta que llega a la clase empleado, al atributo concreto.
   
   Sobrecarga de métodos
   ------
   Se le llama método sobrecargado a los diferentes métodos que pertenecen a una **Clase** y comparten el mismo nombre, esto se puede producir cuando un método sirve para el mismo propósito pero con diferentes tipos de variables. Por ejemplo un método suma, que puede sumar tanto enteros (int), decimales (double) y también la concatenación de cadenas de carácteres (String).
```java
  public int suma(int a, int b) {
    int res = a + b;
    return res;
  }
  public double suma(double a, double b) {
    double res = a + b;
    return res;
  }
  public String suma(String a, String b) {
    String s = a + b;
    return res;
  }    
  public class SumaSobrecargada() {
    suma(3,4);
    suma(5.6,4.1);
    suma("Hola","Mundo");
  }
  /*EN LA SALIDA MOSTRARÁ :
 * 7
 * 10.7
 * HolaMundo
 */
```
   
   Herencia
   ------
 La herencia se da cuando hay clases que derivan de otras básicamente, en Java extienden de clases superiores que las engloban, hereda los atributos y los métodos, y se pueden crear los propios de la clase, anteriormente hemos hablado de la encapsulación de datos, entre los tipos de visibilidad se encontraba el **Protected** que es que va a tomar la clase general que va a heredar. Para que podamos hacer referencia a esa clase necesitamos que la clase heredada extienda a la clase general pero con un ejemplo lo veremos mejor.
```java
    //CLASE PRINCIPAL
    public class Persona {
      protected String DNI;
      protected String nombre;
      protected int edad;
      
      public void comer() {}
      public void dormir() {}
      public void andar() {}
      }
      
      //CLASE HEREDADA
      public class Alumno extends Persona { //INDICAMOS LA CLASE DE LA QUE TOMA REFERENCIA
        private int NIA;
        private String clase;
        private ArrayList<int> notas;
        
        public Alumno() {
        super(); //ESTO HACE QUE HEREDE LOS ATRIBUTOS DE PERSONA
        }
        public void hacerExamen() {}
        public void estudiar() {}
        public void irClase() {}
     }
```
   Polimorfismo
   ------
  El polimorfismo viene ligado con la herencia, al final se trata de implementar métodos desde la clase principal a las heredadas, para ello se necesita que la clase padre sea **abstracta** y tenga métodos **abstractos** y las clases hijas lo implementen acorde a sus especificaciones.Es una manera de jerarquizar un patrón de comportamiento a una serie de objetos de la misma clase. Y la clase padre no se puede instanciar, solo se pueden crear objetos de las clases derivadas/heredadas, también hay que tener en mente que los métodos abstractos que se creen en la clase principal deben implementarse **obligatoriamente** en las clases hijas.
```java
    //CLASE PRINCIPAL
    public abstract class Persona {
      public abstact void oficio();
      public void come() {
        System.out.println("Soy persona, por tanto si (Clase Principal)");
      }
     }
     //CLASES HEREDADAS
     public class Medico extends Persona {
      private String dept;
      public void oficio() {
       System.out.println("Soy medico");
      }
      public void come() {
        System.out.println("Tengo guardia, no puedo");
      }
     }
     public class Estudiante extends Persona {
      private String clase;
      public void oficio() {
        System.out.println("Ninguno, soy estudiante");
      }
      /*
      Si omitimos este método ira a la clase padre.
      public void come() {
        System.out.println("Es la hora del patio, voy a comer");
      }
      */
     }
    //MAIN
    public class Main {
      public static void main(String[] args {
        
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        
        listaPersonas.add(new Medico("6666666","Pepe",35,"Cirujano General");
        listaPersonas.add(new Estudiante("333333","Galileo",18,"2DAM");
        
        
        for(Persona p : listaPersonas) {
          System.out.println("DNI : " + p.getDNI() + "\nNOMBRE : " + p.getNombre()  
          + "\nCome : " + p.come() + "\nOficio : " + p.oficio());  
          
          /* Los resultados que saldrian :
              Para el primero :
                DNI:6666666
                NOMBRE:Pepe
                Come: Tengo guardia, no puedo
                Oficio:Soy medico
              Para el segundo : 
                DNI:3333333
                NOMBRE:Galileo
                Come:Soy persona, por tanto si
                Oficio:Ninguno, soy estudiante
                
```
    
   
   Interface
   ------
   Una interface es una clase totalmente abstracta que no se puede implementar de ninguna manera, solo contiene métodos abstractos de los que si se puede hacer instancia. Sirven para definir la forma que debe tomar una clase, en la interface no se pueden crer atributos a menos que sean estaticos o constantes finales. La palabra clave en interface es  **implements** que es como el **extends** en herencia, liga la interface con la clase.
  
```java
      //INTERFACE
      public interface accionPersona {
      //SE PUEDE OMITIR "public abstract" ya que la interface por si misma es pública y abstracta.
        public abstract void comer();
        void dormir();
        void andar();
      }
      //CLASE PRINCIPAL
      public abstract class Persona implements accionPersona {
        protected String DNI;
        protected String nombre;
        protected int edad;
      
        public Persona() {
        }
        public Persona(String DNI, String nombre, int edad) {
         this.DNI = DNI;
         this.nombre = nombre;
         this.edad = edad;
        }
        //IMPLEMENTACION DE LOS MÉTODOS DE LA INTERFACE
         public void dormir() {
          System.out.println("Esta dormido");
         }
         public void comer() {
          System.out.println("Esta comiendo");
         }
         public void andar() {
          System.out.println("Esta andando");
         }
        }
        //CLASE HIJA/HEREDADA
        public Medico extends Persona {
          private String dept;
          //REDEFINIENDO EL METODO DE LA INTERFACE.
           public void comer() {
            System.out.println("No puedo (Clase Medico)");
           }
         }
         //MAIN
         public class Main {
          public static void main(String[] args) {
            Persona p = new Medico("66666666","Pepe",35,"Cirugia General");
            p.comer();
            p.andar();
            p.dormir();
            
           }
          }
          /*
          *La salida imprime :
          * No puedo(Clase Medico)
          * Esta andado
          * Esta dormido
          */
        
```
