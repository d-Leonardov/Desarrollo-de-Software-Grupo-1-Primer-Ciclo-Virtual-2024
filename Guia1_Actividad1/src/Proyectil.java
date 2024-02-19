public class Proyectil {
	
    private double velocidad;
    private double ángulo;
    
    public Proyectil(double velocidad, double ángulo) {
        this.velocidad = velocidad;
        this.ángulo = ángulo;
    }
    
    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getÁngulo() {
        return ángulo;
    }

    public void setÁngulo(double ángulo) {
        this.ángulo = ángulo;
    }
}

