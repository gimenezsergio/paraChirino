package entidades;

public class Turno {
private String id;
private String paciente;
private String grilla;
private String desde;
private String hasta;
    public Turno(String ppaciente, String pgrilla, String pdesde, String phasta) {
        setPaciente(ppaciente);
        setGrilla(pgrilla);
        setDesde(pdesde);
        setHasta(phasta);
    }

    @Override
    public String toString() {
        return "{ " + "paciente :" + paciente + ", Grilla: " + grilla + ", desde: " + desde + ", hasta: " + hasta + " }";
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getGrilla() {
        return grilla;
    }

    public void setGrilla(String grilla) {
        this.grilla = grilla;
    }
}
