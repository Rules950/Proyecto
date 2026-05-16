package Clases;
import Utilerias.ent;
public class Bicicletas {
    String marca, modelo, MaterialCuadro;
    double precio;

    public Bicicletas() {
    }
    public Bicicletas(String marca, String modelo, String MaterialCuadro, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.MaterialCuadro = MaterialCuadro;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMaterialCuadro() {
        return MaterialCuadro;
    }

    public void setMaterialCuadro(String MaterialCuadro) {
        this.MaterialCuadro = MaterialCuadro;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void mostrarDatos(){
        String cad = "Marca: " + marca + "\nModelo: " + modelo + 
               "\nMaterial del Cuadro: " + MaterialCuadro + "\nPrecio : $" + precio;
        ent.imprimir(cad);
    }
}
