public class Fecha {
	
    private int año;
    private int mes;
    private int día;
    
    public Fecha(int año, int mes, int día) {
        this.año = año;
        this.mes = mes;
        this.día = día;
    }
    
    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDía() {
        return día;
    }

    public void setDía(int día) {
        this.día = día;
    }
}
