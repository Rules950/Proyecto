package Clases;
import Utilerias.ent;
public class Downhill extends Bicicletas {
    String tipoLlanta, recorridoSus;

    public Downhill() {
        super();    
    }
    
    public Downhill(String tipoLlanta, String recorridoSus, String marca, String modelo, String MaterialCuadro, double precio) {
        super(marca, modelo, MaterialCuadro, precio);
        this.tipoLlanta = tipoLlanta;
        this.recorridoSus = recorridoSus;
    }

    public String getTipoLlanta() {
        return tipoLlanta;
    }

    public void setTipoLlanta(String tipoLlanta) {
        this.tipoLlanta = tipoLlanta;
    }

    public String getRecorridoSus() {
        return recorridoSus;
    }

    public void setRecorridoSus(String recorridoSus) {
        this.recorridoSus = recorridoSus;
    }
    @Override 
    public void mostrarDatos(){
        String cad =  "Downhill\n" + "tipo de llanta: " + tipoLlanta + 
                      "\nRecorrido de la Suspencion: " + recorridoSus;
        super.mostrarDatos();
        ent.imprimir(cad);
        
    }
    
}
