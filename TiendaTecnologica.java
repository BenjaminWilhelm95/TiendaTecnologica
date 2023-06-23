import java.util.ArrayList;
import java.util.List;

public class TiendaTecnologica {
    private String nombre;
    private String direccion;
    private Catalogo catalogo;

    private List<Cliente> clientes;
    private List<DispositivoTecnologico> dispositivos;

    public TiendaTecnologica(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.catalogo = new Catalogo();
        this.clientes = new ArrayList<>();
        this.dispositivos = new ArrayList<>();
    }

    public void agregarDispositivo(DispositivoTecnologico dispositivo) {
        dispositivos.add(dispositivo);
    }

    public void agregarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        } else {
            System.out.println("El cliente ya existe en la tienda.");
        }
    }

    public String obtenerInfoDispositivo(DispositivoTecnologico dispositivo) {
        return dispositivo.getEspecificacionesCompletas();
    }

    public List<DispositivoTecnologico> buscarPorMarca(String marca) {
        List<DispositivoTecnologico> resultados = new ArrayList<>();
        for (DispositivoTecnologico dispositivo : dispositivos) {
            if (dispositivo.getMarca().equals(marca)) {
                resultados.add(dispositivo);
            }
        }
        return resultados;
    }

    public List<DispositivoTecnologico> buscarPorModeloYTipo(String modelo, String tipo) {
        List<DispositivoTecnologico> resultados = new ArrayList<>();
        for (DispositivoTecnologico dispositivo : dispositivos) {
            if (dispositivo.getModelo().equals(modelo) && dispositivo.getTipo().equals(tipo)) {
                resultados.add(dispositivo);
            }
        }
        return resultados;
    }

    public static void main(String[] args) {
        TiendaTecnologica tienda = new TiendaTecnologica("Mi Tienda Tecnológica", "Calle Principal 123");

        Cliente cliente1 = new Cliente("Juan", "Pérez", "juan@example.com", "987654321", "Soltero", "Lima");
        Cliente cliente2 = new Cliente("María", "Gómez", "maria@example.com", "123456789", "Casada", "Lima");

        tienda.agregarCliente(cliente1);
        tienda.agregarCliente(cliente2);

        DesktopComputer computadora1 = new DesktopComputer("Dell", "8GB", "1TB", "Intel Core i5", "Inspiron", 2021, 999.99, 10);
        Notebook notebook1 = new Notebook("HP", "16GB", "512GB", "Intel Core i7", "Pavilion", 2022, 1299.99, 5);
        Tablet tablet1 = new Tablet("Apple", "4GB", "128GB", "Apple A12 Bionic", "iPad", 2020, 599.99, 3);

        tienda.agregarDispositivo(computadora1);
        tienda.agregarDispositivo(notebook1);
        tienda.agregarDispositivo(tablet1);

        List<DispositivoTecnologico> resultadosMarca = tienda.buscarPorMarca("HP");
        System.out.println("Resultados de búsqueda por marca:");
        for (DispositivoTecnologico dispositivo : resultadosMarca) {
            System.out.println(dispositivo.getEspecificacionesCompletas());
        }

        List<DispositivoTecnologico> resultadosModeloTipo = tienda.buscarPorModeloYTipo("Inspiron", "Computadora de Escritorio");
        System.out.println("Resultados de búsqueda por modelo y tipo:");
        for (DispositivoTecnologico dispositivo : resultadosModeloTipo) {
            System.out.println(dispositivo.getEspecificacionesCompletas());
        }
    }
}

class Cliente {
    private String nombre;
    private String apellido;
    private String correo;
    private String numeroContacto;
    private String estadoCivil;
    private String ciudad;

    public Cliente(String nombre, String apellido, String correo, String numeroContacto, String estadoCivil, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.numeroContacto = numeroContacto;
        this.estadoCivil = estadoCivil;
        this.ciudad = ciudad;
    }
}

class DispositivoTecnologico {
    private String marca;
    private String RAM;
    private String almacenamiento;
    private String procesador;
    private String modelo;
    private int año;
    private double precio;
    private int stock;

    public DispositivoTecnologico(String marca, String RAM, String almacenamiento, String procesador, String modelo, int año, double precio, int stock) {
        this.marca = marca;
        this.RAM = RAM;
        this.almacenamiento = almacenamiento;
        this.procesador = procesador;
        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return "";
    }

    public String getEspecificacionesCompletas() {
        return "Marca: " + marca + ", RAM: " + RAM + ", Almacenamiento: " + almacenamiento + ", Procesador: " + procesador + ", Modelo: " + modelo +
                ", Año: " + año + ", Precio: " + precio + ", Stock: " + stock;
    }
}

class DesktopComputer extends DispositivoTecnologico {
    private String tarjetaVideo;
    private String fuentePoder;
    private String chasis;
    private Pantalla pantalla;

    public DesktopComputer(String marca, String RAM, String almacenamiento, String procesador, String modelo, int año, double precio, int stock) {
        super(marca, RAM, almacenamiento, procesador, modelo, año, precio, stock);
    }

    @Override
    public String getTipo() {
        return "Computadora de Escritorio";
    }
}

class Notebook extends DispositivoTecnologico {
    private String resolucionPantalla;
    private String tipoTeclado;
    private String capacidadBateria;

    public Notebook(String marca, String RAM, String almacenamiento, String procesador, String modelo, int año, double precio, int stock) {
        super(marca, RAM, almacenamiento, procesador, modelo, año, precio, stock);
    }

    @Override
    public String getTipo() {
        return "Notebook";
    }
}

class Tablet extends DispositivoTecnologico {
    private String resolucionPantalla;
    private List<String> accesorios;

    public Tablet(String marca, String RAM, String almacenamiento, String procesador, String modelo, int año, double precio, int stock) {
        super(marca, RAM, almacenamiento, procesador, modelo, año, precio, stock);
    }

    @Override
    public String getTipo() {
        return "Tablet";
    }
}

class Pantalla {
    private String marca;
    private String modelo;
    private int año;

    public Pantalla(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }
}

class Catalogo {
    // Agregar el catálogo de dispositivos tecnológicos (por ejemplo, agregar dispositivos, buscar por marca, modelo, etc.)
}
