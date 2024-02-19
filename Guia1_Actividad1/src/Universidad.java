import java.util.Date;

public class Universidad {
	
    private String nombre;
    private String nombreRector;
    private String ciudad;
    private Facultad[] facultades;

    public Universidad(String nombre, String nombreRector, String ciudad) {
        this.nombre = nombre;
        this.nombreRector = nombreRector;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreRector() {
        return nombreRector;
    }

    public void setNombreRector(String nombreRector) {
        this.nombreRector = nombreRector;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Facultad[] getFacultades() {
        return facultades;
    }

    public void setFacultades(Facultad[] facultades) {
        this.facultades = facultades;
    }
}

class Facultad {
    private String nombre;
    private int codigo;
    private Profesor[] profesores;
    private Carrera[] carreras;

    public Facultad(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Profesor[] getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesor[] profesores) {
        this.profesores = profesores;
    }

    public Carrera[] getCarreras() {
        return carreras;
    }

    public void setCarreras(Carrera[] carreras) {
        this.carreras = carreras;
    }
}

class Profesor extends Persona {
    private String profesion;
    private String nacionalidad;
    private double sueldo;
    private Facultad facultad;

    public Profesor(String cedula, String nombre, Date fechaNacimiento, String lugarNacimientoCiudad, String lugarNacimientoDepartamento, String lugarNacimientoPais, String profesion, String nacionalidad, double sueldo) {
        super(cedula, nombre, fechaNacimiento, lugarNacimientoCiudad, lugarNacimientoDepartamento, lugarNacimientoPais);
        this.profesion = profesion;
        this.nacionalidad = nacionalidad;
        this.sueldo = sueldo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }
}

class Carrera {
    private String nombre;
    private int creditosTotales;
    private int semestres;
    private String nivel;
    private Facultad facultad;
    private Estudiante[] estudiantes;
    private Curso[] cursos;

    public Carrera(String nombre, int creditosTotales, int semestres, String nivel) {
        this.nombre = nombre;
        this.creditosTotales = creditosTotales;
        this.semestres = semestres;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditosTotales() {
        return creditosTotales;
    }

    public void setCreditosTotales(int creditosTotales) {
        this.creditosTotales = creditosTotales;
    }

    public int getSemestres() {
        return semestres;
    }

    public void setSemestres(int semestres) {
        this.semestres = semestres;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }
}

class Estudiante extends Persona {
    private String colegioBachillerato;
    private Date fechaIngreso;
    private Carrera[] carreras;

    public Estudiante(String cedula, String nombre, Date fechaNacimiento, String lugarNacimientoCiudad, String lugarNacimientoDepartamento, String lugarNacimientoPais, String colegioBachillerato, Date fechaIngreso) {
        super(cedula, nombre, fechaNacimiento, lugarNacimientoCiudad, lugarNacimientoDepartamento, lugarNacimientoPais);
        this.colegioBachillerato = colegioBachillerato;
        this.fechaIngreso = fechaIngreso;
    }

    public String getColegioBachillerato() {
        return colegioBachillerato;
    }

    public void setColegioBachillerato(String colegioBachillerato) {
        this.colegioBachillerato = colegioBachillerato;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Carrera[] getCarreras() {
        return carreras;
    }

    public void setCarreras(Carrera[] carreras) {
        this.carreras = carreras;
    }
}

class Curso {
    private int codigo;
    private String nombre;
    private int creditos;
    private String salon;
    private String edificio;
    private Profesor[] profesores;
    private Estudiante[] estudiantes;
    private Carrera carrera;

    public Curso(int codigo, String nombre, int creditos, String salon, String edificio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.salon = salon;
        this.edificio = edificio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public Profesor[] getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesor[] profesores) {
        this.profesores = profesores;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}

class Persona {
    private String cedula;
    private String nombre;
    private Date fechaNacimiento;
    private String lugarNacimientoCiudad;
    private String lugarNacimientoDepartamento;
    private String lugarNacimientoPais;

    public Persona(String cedula, String nombre, Date fechaNacimiento, String lugarNacimientoCiudad, String lugarNacimientoDepartamento, String lugarNacimientoPais) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimientoCiudad = lugarNacimientoCiudad;
        this.lugarNacimientoDepartamento = lugarNacimientoDepartamento;
        this.lugarNacimientoPais = lugarNacimientoPais;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimientoCiudad() {
        return lugarNacimientoCiudad;
    }

    public void setLugarNacimientoCiudad(String lugarNacimientoCiudad) {
        this.lugarNacimientoCiudad = lugarNacimientoCiudad;
    }

    public String getLugarNacimientoDepartamento() {
        return lugarNacimientoDepartamento;
    }

    public void setLugarNacimientoDepartamento(String lugarNacimientoDepartamento) {
        this.lugarNacimientoDepartamento = lugarNacimientoDepartamento;
    }

    public String getLugarNacimientoPais() {
        return lugarNacimientoPais;
    }

    public void setLugarNacimientoPais(String lugarNacimientoPais) {
        this.lugarNacimientoPais = lugarNacimientoPais;
    }  
}