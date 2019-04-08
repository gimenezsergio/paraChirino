package entidades;

public class Grilla {
    private String desde;
    private String hasta;
    private String obraSocial;
    private String medicoId;

    public Grilla(String pMedicoId, String pObraSocial, String pDesde, String pHasta) throws Exception {
        setMedicoId(pMedicoId);
        setObraSocial(pObraSocial);
        setDesde(pDesde);
        setHasta(pHasta);
    }

    @Override
    public String toString() {
        return "{ " + "Medico: " + medicoId + ", Obra Social: " + obraSocial + ", Desde: " + desde + ", Hasta: " + hasta + " }";
    }
    
    

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) throws Exception {
        if (desde == null || desde.isEmpty()){
            throw new Exception("La fecha desde no pued estar vacia.");
        }else{
            this.desde = desde;
        }
        
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) throws Exception {
        if (hasta == null || hasta.isEmpty()){
            throw new Exception("La fecha hasta no puede estar vacia");
        }else{
            this.hasta = hasta;
        }
        
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public String getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(String medicoId) {
        this.medicoId = medicoId;
    }

   
}
