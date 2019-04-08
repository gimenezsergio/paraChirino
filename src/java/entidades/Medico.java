package entidades;

public class Medico {

    private String nombre;
    private String id;

    public Medico(String pnombre) throws Exception {
        setNombre(pnombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("El nombre no puede estar vacio");
        } else {
            this.nombre = nombre;
        }
    }

    @Override
    public String toString() {
        return "{ Nombre: " + getNombre() + " Id: " + getId() + " }";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
