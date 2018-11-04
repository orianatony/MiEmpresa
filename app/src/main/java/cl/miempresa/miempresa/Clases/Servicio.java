package cl.miempresa.miempresa.Clases;

public class Servicio {

    private int id;
    private String nombre;
    private String descripcion;
    private int avatar;

    public Servicio() {
    }

    public Servicio(int id,String nombre, String descripcion, int avatar) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString(){
        return this.getNombre();
    }
}
