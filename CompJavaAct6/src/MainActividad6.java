import java.util.InputMismatchException;
import java.util.Scanner;

public class MainActividad6
{
    public static void main(String[] args) throws java.io.IOException   //Metodo main
    {
        Estudiante estudiante = new Estudiante();                           //Objeto de clase estudiante con el que trabajará el programa
        ingresarNombreYCalificaciones(estudiante);                          //Se registra el nombre y las calificaciones del estudiante
        float promedio = obtenerPromedio(estudiante.getCalificaciones());   //Se obtiene el promedio en base a las calificaciones del estudiante
        char calificacionFinal = asignarCalificacionFinal(promedio);        //Se asigna una letra de la calificación final en base al promedio obtenido
        imprimirResultados(estudiante, promedio, calificacionFinal);        //Se imprimen todos los datos del alumno (Nombre, calificaciones, promedio y calificación final)
    }

    public static void ingresarNombreYCalificaciones(Estudiante estudiante) throws java.io.IOException   //Metodo encargado del ingreso de datos al proggrama (nombre de estudiantes y calificaciones)
    {
        Scanner intro = new Scanner(System.in);      //Scanner que permite la entrada de datos al programa
        boolean nombreValido = false, calificacionesValidas = false;     //Verifican si el nombre ingresado es valido al igual que las calificaciones

        do  //Este ciclo se repetirá hasta que el nombre ingresado cumpla con las reglas: Ningun caracter especial ni numeros, únicamente letras y espacios permitidos (añadida la letra ñ)
        {
            System.out.print("-----\nIngrese el nombre del estudiante: ");
            estudiante.setNombre(intro.nextLine());

            if(!estudiante.getNombre().matches("^[a-zA-ZñÑ ]+$") || estudiante.getNombre().isBlank())   //Si el nombre no cumple el regex o si esta vacio, se envia error y se pide que se ingrese de nuevo
            {
                System.out.print("-----\nEl nombre ingresado es invalido o esta vacio, favor de intentar de nuevo\n\nPresione ENTER para continuar . . .");
                System.in.read();
                System.out.println();
            }

            else
            {
                nombreValido = true;
            }
        }
        while(!nombreValido);

        //Se define el iterador
        byte i = 0;

        do      //Este ciclo se repetirá hasta que todas las calificaciones hayan sido captadas por el sistema
        {
            try
            {
                System.out.print("-----\nIngrese la calificación " + (i+1) + " del estudiante " + estudiante.getNombre() + ": ");
                float temp = intro.nextFloat();     //Se guarda en una variable temporal antes de guardarse en el arreglo de calificaciones

                if(temp < 0 || temp > 100)  //La calificacion debe ser un valor de entre el 0 al 100, de lo contrario se volverá a pedir
                {
                    System.out.print("-----\nLa calificación unicamente puede tener un valor dentro del rango del 0 al 100, favor de intentar de nuevo\n\nPresione ENTER para continuar . . .");
                    System.in.read();
                    System.out.println();
                }

                else    //El valor es aceptado y guardado en el arrglo
                {
                    estudiante.getCalificaciones()[i] = temp;
                    i++;
                }

                if(i == 5)  //Una vez se hayan llenado todos los campos del arreglo de calificaciones, se puede  proseguir
                {
                    calificacionesValidas = true;
                }
            }

            catch(InputMismatchException a)     //Si lo ingresado no puede convertirse a float, se genera un InputMismatchException y se pide que se ingresen nuevamente los valores
            {
                System.out.print("-----\nEl valor ingresado no puede ser transformado a un numero, favor de intentar de nuevo\n\nPresione ENTER para continuar . . .");
                System.in.read();
                System.out.println();
                intro.next();
            }
        }
        while(!calificacionesValidas);

    }

    public static float obtenerPromedio(float [] calificaciones)        //Se calcula el promedio en base a un arreglo proporcionado de calificaciones
    {
        float promedio = 0;     //Variable definida

        for(byte i = 0; i < 5; i++)     //
        {
            promedio += calificaciones[i];
        }

        promedio /= calificaciones.length;

        return promedio;
    }

    public static char asignarCalificacionFinal(float promedio)     //Método que asigna la calificación final de un estudiante en base a su promedio
    {
        char calificacionFinal;

        if(promedio >= 91)      //Esto abarca todos los valores que vayan desde el numero 91 hasta el 100
        {
            calificacionFinal = 'A';
        }

        else if (promedio < 91 && promedio >=81)    //Abarca desde el numero 81 hasta el numero 90.999...
        {
            calificacionFinal = 'B';
        }

        else if (promedio < 81 && promedio >=71)    //Abarca desde el numero 71 hasta el numero 80.999...
        {
            calificacionFinal = 'C';
        }

        else if (promedio < 71 && promedio >=61)    //Abarca desde el numero 61 hasta el numero 70.999...
        {
            calificacionFinal = 'D';
        }

        else if (promedio < 61 && promedio >=51)    //Abarca desde el numero 51 hasta el numero 60.999...
        {
            calificacionFinal = 'E';
        }

        else                                        //Cualquier número menor a 50.999... entra aquí
        {
            calificacionFinal = 'F';
        }

        return calificacionFinal;   //Se envia la calificación final
    }

    public static void imprimirResultados(Estudiante estudianteCompleto, float promedio, char calificacionFinal)   //Se imprimen todos los valores de las variables
    {
        System.out.println("-----\nNombre del estudiante = " + estudianteCompleto.getNombre());
        System.out.println("Calificación 1 = " + estudianteCompleto.getCalificaciones()[0]);
        System.out.println("Calificación 2 = " + estudianteCompleto.getCalificaciones()[1]);
        System.out.println("Calificación 3 = " + estudianteCompleto.getCalificaciones()[2]);
        System.out.println("Calificación 4 = " + estudianteCompleto.getCalificaciones()[3]);
        System.out.println("Calificación 5 = " + estudianteCompleto.getCalificaciones()[4]);
        System.out.println("Promedio = " + promedio);
        System.out.println("Calificacion Final = " + calificacionFinal);
    }

}