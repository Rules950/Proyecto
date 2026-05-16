package Aplicacion;
import Clases.*;
import Utilerias.ent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TiendaMTB {

    public static void main(String[] args) {
        String opc = "";
        String modelo = "";
        double precio = 0;
        int peso = 0;
        String MaterialCuadro = "";
        String [] opcs = {"Registrat Bicicleta de Downhill","Registrar Bicileta de CrossCountry","Mostrat el Inventario", "Salir"}; 
        String [] marcas = {"Trek","Specialized","Santa Cruz"};
        String [] llantas = {"2.1 in","2.4 in","2.35 in","2.6 in"};
        String [] cuadros = {"Aluminio","Fibra de carbono"};
        String [] recorrido = {"100mm a 120mm","130mm a 170mm","180mm a 200mm"};
        
        ArrayList<Bicicletas> inventario = new ArrayList<>();//Este Arraylist va a servir para que nos ayude 
                                                             //a guardar las bicicletas que vayamos agregando
        
        do{
            opc = ent.leerOpcion("Que desea realizar", "Opciones", opcs);
            
            if (opc==null || opc.equals(opcs[3]))
                break;
            
            if (opc.equals(opcs[0])) {//Bicis de Downhill
                String marca = ent.leerOpcion("Elige la marca", "Marcas", marcas);
                
                if (marca.equals(marcas[0])) {//Trek
                     modelo = ent.leerOpcion("Que modelo", "Modelo", new Object[] {"Session","Slash"}); 
                } else if (marca.equals(marcas[1])) {//Specialized
                     modelo = ent.leerOpcion("Que modelo", "Modelo", new Object[] {"Demo","Status 160"}); 
                } else if (marca.equals(marcas[2])) {//Santa Cruz
                     modelo = ent.leerOpcion("Que modelo", "Modelo", new Object[] {"V10","Nomad"}); 
                } //FIN MDE LOS IF PARA ELEGIR EL MODELO      
                 
                MaterialCuadro = ent.leerOpcion(opc, marca, cuadros);
                
                String tipoLlanta = ent.leerOpcion("Tiopos de llanta", "Llantas", llantas);
                
                String recorridoSus =  ent.leerOpcion("Elige el recorrido de la suspension", "Recorrido", recorrido);
                boolean error;
                do{                   
                   try{//esta excepcion es para que pongan un precio valido
                      error = false;
                      precio = ent.leerDouble("Ingresa el precio de la Bicicleta" + marca + " " + modelo ); 
                   } catch(NumberFormatException err){
                      ent.imprimir("Ingresa un numero valido");
                      error = true;
                   }
                }while(error);
                Downhill dw = new Downhill(tipoLlanta,recorridoSus,marca,modelo,MaterialCuadro,precio);
                inventario.add(dw);//Aqui agrega la bicleta al array
                dw.mostrarDatos();
            } //Fin del if de de las bicis de Downhill
            
            else if (opc.equals(opcs[1])) { //Bicis XC
                String marca = ent.leerOpcion("Elige la marca", "Marcas", marcas);
                
                if (marca.equals(marcas[0])) {//Trek
                     modelo = ent.leerOpcion("Que modelo", "Modelo", new Object[] {"Supercaliper","Marlin"});
                } else if (marca.equals(marcas[1])) {//specialized
                     modelo = ent.leerOpcion("Que modelo", "Modelo", new Object[] {"Epic","Chisel"});
                } else if (marca.equals(marcas[2])){//Santa Cruz
                     modelo = ent.leerOpcion("Que modelo", "Modelo", new Object[] {"Blur","Highball"});
                }
                
                String SusBloqueo = ent.leerOpcion("¿La bici tiene bloqeo de suspension?", "Suspensios", new Object [] {"Si","No"});
                
                MaterialCuadro = ent.leerOpcion(opc, marca, cuadros);
                boolean error;
                do {     //Excepcion para que el precio se un numero valido              
                   try {
                      error = false;
                      precio = ent.leerDouble("Ingresa el precio de la Bicicleta " + marca + " " + modelo); 
                   } catch(NumberFormatException err) {
                      ent.imprimir("Ingresa un número válido para el precio");
                      error = true;
                   }
                } while(error);
                do {   //Excepcion para que el peso este bien                
                   try {
                      error = false;
                      peso = ent.leerEntero("Ingresa el peso de la Bici en KG");
                   } catch(NumberFormatException err) {
                      ent.imprimir("Ingresa un número entero válido para el peso");
                      error = true;
                   }
                } while(error);
                
                CrossCountry xc = new CrossCountry (peso,SusBloqueo,marca,modelo,MaterialCuadro,precio);
                inventario.add(xc);
                xc.mostrarDatos();
            }//Fin de bicis de XC
            
            else if(opc.equals(opcs[2])){
                
                FileOutputStream fos = null;
                PrintWriter pw;
                try {          
                    fos = new FileOutputStream("Inventario.txt", true); 
                } catch (FileNotFoundException ex) { }
                
                pw = new PrintWriter(fos);
                for (int i = 0; i < inventario.size(); i++) {
                    Bicicletas b = inventario.get(i);
                    pw.println("Bici: " + b.getMarca() + " " + b.getModelo() + " $" + b.getPrecio());
                }
                pw.close();
                          
                java.io.FileReader fr = null;
                java.io.BufferedReader br = null;
                try {
                    fr = new java.io.FileReader("Inventario.txt");
                } catch (FileNotFoundException ex) { }
                
                br = new java.io.BufferedReader(fr);
                String cadena, cad = "";
                try {
                    cadena = br.readLine();
                    while (cadena != null) {
                        cad = cad + cadena + "\n";
                        cadena = br.readLine();
                    }
                    ent.imprimir(cad); 
                    br.close();
                    fr.close();
                } catch (IOException ex) { }
                        
            }//Fin del mostrar inventario
                /*FileOutputStream fos = null;
                PrintWriter pw;
                try {          
                 fos = new FileOutputStream("Inventario.txt", true);
                } catch (FileNotFoundException ex) {
                }
                 pw = new PrintWriter(fos);
                int cad = 0;
                 pw.write(cad);
                 pw.close();
                try {
                fos.close();
                } catch (IOException ex) {
                }
            }//Fin del mostrar inventario*/
                   
        }while(!opc.equals(opcs[3]));
    }
    
}
