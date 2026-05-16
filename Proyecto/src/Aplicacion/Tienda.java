package Aplicacion;
import Clases.Bicicletas;
import Clases.CrossCountry;
import Clases.Downhill;
import Utilerias.ent;
import java.util.ArrayList;

public class Tienda {

    public static void main(String[] args) {
        // Tus arreglos base bien definidos
        String [] marcas = {"Trek", "Specialized", "Alubike", "Santa Cruz"};
        ArrayList<Bicicletas> inventario = new ArrayList<>();
        
        // Opciones para el menú principal
        Object[] opcionesMenu = {
            "1. Registrar Bicicleta Downhill", 
            "2. Registrar Bicicleta Cross Country", 
            "3. Mostrar Inventario", 
            "4. Salir"
        };
        
        String seleccion;

        do {
            seleccion = ent.leerOpcion("Selecciona una acción a realizar:", "MENÚ TIENDA", opcionesMenu);
            
            if (seleccion == null) {
                seleccion = "4. Salir";
            }

            switch (seleccion) {
                case "1. Registrar Bicicleta Downhill":
                    // 1. Elegir Marca de forma controlada
                    String marcaDH = ent.leerOpcion("Selecciona la marca:", "MARCAS DISPONIBLES", marcas);
                    if (marcaDH == null) break; // Por si cancela la selección

                    // 2. Filtrar modelos de Downhill según la marca elegida
                    String[] modelosDH;
                    switch (marcaDH) {
                        case "Trek":          modelosDH = new String[]{"Session"}; break;
                        case "Specialized":   modelosDH = new String[]{"Demo"}; break;
                        case "Santa Cruz":    modelosDH = new String[]{"V10"}; break;
                        case "Alubike":       modelosDH = new String[]{"No maneja DH (Elige Recreativa)"}; break;
                        default:              modelosDH = new String[]{"Genérico DH"};
                    }
                    
                    String modeloDH = ent.leerOpcion("Selecciona el modelo:", "MODELOS DOWNHILL", modelosDH);
                    if (modeloDH == null) break;

                    // Resto de datos comunes
                    String materialDH = ent.leerCadena("Ingresa el material del cuadro:");
                    double precioDH = ent.leerDouble("Ingresa el precio:");
                    
                    // Datos específicos de Downhill
                    String tipoLlanta = ent.leerCadena("Ingresa el tipo de llanta:");
                    String recorrido = ent.leerCadena("Ingresa el recorrido de la suspensión (ej: 200mm):");
                    
                    // Registro en el inventario
                    inventario.add(new Downhill(tipoLlanta, recorrido, marcaDH, modeloDH, materialDH, precioDH));
                    ent.imprimir("¡Bicicleta Downhill registrada con éxito!");
                    break;

                case "2. Registrar Bicicleta Cross Country":
                    // 1. Elegir Marca de forma controlada
                    String marcaXC = ent.leerOpcion("Selecciona la marca:", "MARCAS DISPONIBLES", marcas);
                    if (marcaXC == null) break;

                    // 2. Filtrar modelos de Cross Country según la marca elegida
                    String[] modelosXC;
                    switch (marcaXC) {
                        case "Trek":          modelosXC = new String[]{"Supercaliber", "Procaliber", "Top Fuel"}; break;
                        case "Specialized":   modelosXC = new String[]{"Epic", "Epic Hardtail", "Chisel"}; break;
                        case "Alubike":       modelosXC = new String[]{"XTA 1.0", "XTA 2.0", "XTA 3.0", "Sierra"}; break;
                        case "Santa Cruz":    modelosXC = new String[]{"Blur", "Highball"}; break;
                        default:              modelosXC = new String[]{"Genérico XC"};
                    }
                    
                    String modeloXC = ent.leerOpcion("Selecciona el modelo:", "MODELOS CROSS COUNTRY", modelosXC);
                    if (modeloXC == null) break;

                    // Resto de datos comunes
                    String materialXC = ent.leerCadena("Ingresa el material del cuadro:");
                    double precioXC = ent.leerDouble("Ingresa el precio:");
                    
                    // Datos específicos de Cross Country
                    int peso = ent.leerEntero("Ingresa el peso aproximado (en kg):");
                    String susBloqueo = ent.leerCadena("¿Tiene suspensión de bloqueo? (Sí/No):");
                    
                    // Registro en el inventario
                    inventario.add(new CrossCountry(peso, susBloqueo, marcaXC, modeloXC, materialXC, precioXC));
                    ent.imprimir("¡Bicicleta Cross Country registrada con éxito!");
                    break;

                case "3. Mostrar Inventario":
                    if (inventario.isEmpty()) {
                        ent.imprimir("El inventario está vacío.");
                    } else {
                        // Ofrecemos un filtro extra para ver el inventario de una marca o todo entero
                        String[] opcionesFiltro = {"Mostrar Todo", "Filtrar por Marca"};
                        String filtro = ent.leerOpcion("¿Cómo deseas visualizar el inventario?", "VISUALIZAR", opcionesFiltro);
                        
                        if (filtro == null) break;

                        if (filtro.equals("Mostrar Todo")) {
                            ent.imprimir("--- INVENTARIO COMPLETO ---");
                            for (Bicicletas b : inventario) {
                                b.mostrarDatos(); 
                            }
                        } else {
                            String marcaAFiltrar = ent.leerOpcion("Selecciona la marca que deseas buscar:", "BUSCAR MARCA", marcas);
                            if (marcaAFiltrar == null) break;

                            ent.imprimir("--- INVENTARIO DE LA MARCA: " + marcaAFiltrar.toUpperCase() + " ---");
                            boolean encontro = false;
                            
                            for (Bicicletas b : inventario) {
                                // Aquí comparamos la marca almacenada con la seleccionada
                                if (b.getMarca().equalsIgnoreCase(marcaAFiltrar)) {
                                    b.mostrarDatos();
                                    encontro = true;
                                }
                            }
                            if (!encontro) {
                                ent.imprimir("No hay bicicletas registradas de la marca " + marcaAFiltrar + ".");
                            }
                        }
                    }
                    break;
                    
                case "4. Salir":
                    ent.imprimir("Saliendo del sistema de la tienda. ¡Hasta luego!");
                    break;
            }

        } while (!seleccion.equals("4. Salir"));
    }
}