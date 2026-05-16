package Clases;
import Utilerias.ent;
public class CrossCountry extends Bicicletas{
    int peso;
    String SusBloqueo;
    
    public CrossCountry(){
        super();
    }
    
    public CrossCountry(int peso, String SusBloqueo, String marca, String modelo, String MaterialCuadro, double precio) {
        super(marca, modelo, MaterialCuadro, precio);
        this.peso = peso;
        this.SusBloqueo = SusBloqueo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getSusBloqueo() {
        return SusBloqueo;
    }

    public void setSusBloqueo(String SusBloqueo) {
        this.SusBloqueo = SusBloqueo;
    }
    @Override 
    public void mostrarDatos(){
        String cad =  "CrossCountry\n" + "Peso: " + peso + 
                      "\nSuspension de Bloqueo: " + SusBloqueo;
        super.mostrarDatos();
        ent.imprimir(cad);
        
    }
}
