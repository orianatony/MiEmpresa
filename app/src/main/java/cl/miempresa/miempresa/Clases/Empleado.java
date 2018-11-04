package cl.miempresa.miempresa.Clases;

public class Empleado {


    private int id;
    private String nombre;
    private String cargo;
    private String correo;
    private int avatar;

    public Empleado() {
    }

    public Empleado(int id,String nombre, String cargo, String correo,int avatar) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.correo = correo;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString(){
        return this.getNombre();
    }
}
