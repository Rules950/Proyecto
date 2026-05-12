package Utilerias;
import javax.swing.JOptionPane;
public class ent {
    public static int leerEntero(String mensaje){//metodo
        int valor;
        
        valor=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        return valor;
    }//cierre metodo
    
    public static void imprimir(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
    public static double leerDouble(String mensaje){//metodo
        double valor;
        valor=Double.parseDouble(JOptionPane.showInputDialog(mensaje));
        return valor;
    }//cierre metodo
    
    public static char leerCaracter(String mensaje){//metodo
        char car;
        car=JOptionPane.showInputDialog(mensaje).charAt(0);
        return car;
    }//cierre metodo
    
    public static String leerCadena(String mensaje){//metodo
        String cad;
        cad=JOptionPane.showInputDialog(mensaje);
        return cad;
    }//cierre metodo
    public static String leerOpcion(String msg, String pestana, Object [] a ){
        String dato;
        
        dato=(String)JOptionPane.showInputDialog (null, msg , pestana , JOptionPane.INFORMATION_MESSAGE , null , a , null );
        
        return dato;
    }
    public static int leerEnteroRango (String mensaje, int min , int  max){
        
        int valor;
        
        do{
            valor=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            
        }while (valor<min || valor>max);
        
        
        return valor;
        
    }
    
}
