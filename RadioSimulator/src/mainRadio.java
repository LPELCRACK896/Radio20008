import java.util.Scanner;
/**
 * @author Luis Gonzalez 
 * @author Diego Ruiz
 *
 */
public class mainRadio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int opcion, opcionAV, numNuevaFav, numFav;
    String str1;
    boolean on;
    
    //Se inicializa el objeto radio
    radio rd = new radio();

    opcion=0;
    while (opcion != 6){
      System.out.println("___________________________\n");
      System.out.println("MENU DE OPCIONES:");
      System.out.println("1. Prender/apagar el radio");
      System.out.println("2. Cambiar de frecuencia AM a FM a AM");
      System.out.println("3. Avanzar/retroceder dial de las emisoras");
      System.out.println("4. Guardar emisora a favoritos");
      System.out.println("5. Seleccionar una emisora de favoritos");
      System.out.println("6. Salir");
      System.out.println("___________________________\n");
      System.out.print("Ingrese su respuesta: ");
      opcion = scan.nextInt();
      scan.nextLine();

      /*Para saber si el radio puede realizar sus funciones es necesario que este encendido
      *Por tanto, se revisa su estado
      */
      on = rd.getEstado();

      if(opcion==1){   
        rd.botonEncendido();
        System.out.println("Se utilizo el boton de encendido");
      }
    
      else if(opcion==2){   
        //Cambio de FM a AM o AM a FM
        if(on==true){
          str1 = rd.cambiarDeFmAAm();
          System.out.println(str1);
        }
        //Radio apagado
        else {
          System.out.println("El radio no esta encendido");
        }
      }

      else if(opcion==3){
        //Se debe saber la direccion en la que el usuario desea ir   
        System.out.println("Desea ");
        System.out.println("1. Avanzar");
        System.out.println("2. Retroceder");
        System.out.print("Ingrese su respuesta: ");
        opcionAV = scan.nextInt();
        scan.nextLine();;

        //Adelantar el dial
        if((on==true)&&(opcionAV==1)){
          System.out.println(rd.cambiarEmisora(1,0));
        }
        //Retroceder el dial
        else if((on==true)&&(opcionAV==2)){
          System.out.println(rd.cambiarEmisora(-1,0));
        }
        //Radio apagado
        else {
          System.out.println("El radio no esta encendido");
        }
      }

      else if(opcion==4){
        //Se pide la posicion en la que desea guardar el numero
        
        System.out.println("Ingrese el numero en el que desea guardar la emisora. Recuerde que los espacios abarcan del 1-12.");
        System.out.print("Ingrese su respuesta: ");
        numNuevaFav = scan.nextInt();
        scan.nextLine();

        //Guardar emisora
        if(on==true){
          System.out.println(rd.GuardarComoFavorita(rd.getEmisoraEnReproduccion(), numNuevaFav));
        }
        //Radio apagado
        else {
          System.out.println("El radio no esta encendido");
        }
      }

      else if(opcion==5){   
        System.out.println("Ingrese el numero de la estacion favorita.");
        System.out.print("Ingrese su respuesta: ");
        numFav = scan.nextInt();
        scan.nextLine();

        //Guardar emisora
        if(on==true){
          System.out.println(rd.cambiarEmisora(numFav));
        }
        //Radio apagado
        else {
          System.out.println("El radio no esta encendido");
        }
      }
    }
    System.out.println("Gracias por usar el programa de radio.");
	}
}
