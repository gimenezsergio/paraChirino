package entidades;

public class ObraSocial {
private String nombre;
private String id;

    public ObraSocial(String pnombre) {
        setNombre(pnombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "{ Nombre: " + getNombre() + " Id: " + getId() + " }";
    }
}
