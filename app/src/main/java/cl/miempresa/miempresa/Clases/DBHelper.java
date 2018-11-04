package cl.miempresa.miempresa.Clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "empresa";
    private static final int DB_VERSION = 1;

    //TABLA EMPLEADO
    private static final String EMPLEADO_TABLA_NOMBRE = "empleado";
    private static final String EMPLEADO_COLUMNA_ID = "id";
    private static final String EMPLEADO_COLUMNA_NOMBRE = "nombre";
    private static final String EMPLEADO_COLUMNA_CORREO = "correo";
    private static final String EMPLEADO_COLUMNA_CARGO = "cargo";
    private static final String EMPLEADO_COLUMNA_AVATAR = "avatar";

    private static final String EMPLEADO_CREAR_TABLA=   "CREATE TABLE " + EMPLEADO_TABLA_NOMBRE + " (" +
                                                            EMPLEADO_COLUMNA_ID + " INTEGER PRIMARY KEY," +
                                                            EMPLEADO_COLUMNA_NOMBRE + " TEXT,"+
                                                            EMPLEADO_COLUMNA_CARGO + " TEXT," +
                                                            EMPLEADO_COLUMNA_CORREO + " TEXT," +
                                                            EMPLEADO_COLUMNA_AVATAR + " INTEGER " +
                                                        ")";
    private static final String EMPLEADO_BORRAR_TABLA = "DROP TABLE IF EXISTS " + EMPLEADO_TABLA_NOMBRE;

    //TABLA SERVICIO
    private static final String SERVICIO_TABLA_NOMBRE = "servicio";
    private static final String SERVICIO_COLUMNA_ID = "id";
    private static final String SERVICIO_COLUMNA_NOMBRE = "nombre";
    private static final String SERVICIO_COLUMNA_DESCRIPCION = "descripcion";
    private static final String SERVICIO_COLUMNA_AVATAR = "avatar";
    private static final String SERVICIO_CREAR_TABLA=   "CREATE TABLE " + SERVICIO_TABLA_NOMBRE + " (" +
                                                            SERVICIO_COLUMNA_ID + " INTEGER PRIMARY KEY," +
                                                            SERVICIO_COLUMNA_NOMBRE + " TEXT,"+
                                                            SERVICIO_COLUMNA_DESCRIPCION + " TEXT," +
                                                            SERVICIO_COLUMNA_AVATAR + " INTEGER " +
                                                        ")";
    private static final String SERVICIO_BORRAR_TABLA = "DROP TABLE IF EXISTS " + SERVICIO_TABLA_NOMBRE;

    public DBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EMPLEADO_CREAR_TABLA);
        db.execSQL(SERVICIO_CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(EMPLEADO_BORRAR_TABLA);
        db.execSQL(SERVICIO_BORRAR_TABLA);
        onCreate(db);
    }

    /** EMPLEADO **/
    //Inserta registro  Empleado en BD.
    public long crearEmpleado(Empleado empleado){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EMPLEADO_COLUMNA_NOMBRE,empleado.getNombre());
        values.put(EMPLEADO_COLUMNA_CARGO,empleado.getCargo());
        values.put(EMPLEADO_COLUMNA_CORREO,empleado.getCorreo());
        values.put(EMPLEADO_COLUMNA_AVATAR,empleado.getAvatar());

        long empleado_id = db.insert(EMPLEADO_TABLA_NOMBRE,null,values);
        return  empleado_id;
    }

    //Retorna registro  Empleado de BD.
    public Empleado getEmpleado(long empleado_id){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectEmpleado = "SELECT * FROM " + EMPLEADO_TABLA_NOMBRE + " WHERE " + EMPLEADO_COLUMNA_ID + " = " + empleado_id;

        Cursor cursor = db.rawQuery(selectEmpleado,null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        Empleado empleado = new Empleado();
        empleado.setId(cursor.getInt(cursor.getColumnIndex(EMPLEADO_COLUMNA_ID)));
        empleado.setNombre(cursor.getString(cursor.getColumnIndex(EMPLEADO_COLUMNA_NOMBRE)));
        empleado.setCargo(cursor.getString(cursor.getColumnIndex(EMPLEADO_COLUMNA_CARGO)));
        empleado.setCorreo(cursor.getString(cursor.getColumnIndex(EMPLEADO_COLUMNA_CORREO)));
        empleado.setAvatar(cursor.getInt(cursor.getColumnIndex(EMPLEADO_COLUMNA_AVATAR)));
        return  empleado;
    }

    //Actualiza registro  Empleado en BD.
    public int actualizarEmpleado(Empleado empleado){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EMPLEADO_COLUMNA_NOMBRE,empleado.getNombre());
        values.put(EMPLEADO_COLUMNA_CARGO,empleado.getCargo());
        values.put(EMPLEADO_COLUMNA_CORREO,empleado.getCorreo());
        values.put(EMPLEADO_COLUMNA_AVATAR,empleado.getAvatar());

        return db.update(EMPLEADO_TABLA_NOMBRE,values,EMPLEADO_COLUMNA_ID + " = ?",new String[]{String.valueOf(empleado.getId())});
    }

    //Elimina registro  Empleado en BD.
    public void borrarEmpleado(long empleado_id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(EMPLEADO_TABLA_NOMBRE, EMPLEADO_COLUMNA_ID + " = ?", new String[] { String.valueOf(empleado_id) });
    }

    public List<Empleado> getEmpleados(){
        List<Empleado> listaEmpleados = new ArrayList<Empleado>();

        String selectQuery = "SELECT nombre,avatar FROM " + EMPLEADO_TABLA_NOMBRE + " ORDER BY 1 ASC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                Empleado empleado = new Empleado();
                empleado.setId(cursor.getInt(cursor.getColumnIndex(EMPLEADO_COLUMNA_ID)));
                empleado.setNombre(cursor.getString(cursor.getColumnIndex(EMPLEADO_COLUMNA_NOMBRE)));
                empleado.setCargo(cursor.getString(cursor.getColumnIndex(EMPLEADO_COLUMNA_CARGO)));
                empleado.setCorreo(cursor.getString(cursor.getColumnIndex(EMPLEADO_COLUMNA_CORREO)));
                empleado.setAvatar(cursor.getInt(cursor.getColumnIndex(EMPLEADO_COLUMNA_AVATAR)));
                listaEmpleados.add(empleado);
            }while(cursor.moveToNext());
        }

        return listaEmpleados;
    }


    /** SERVICIO **/
    //Inserta registro  Servicio en BD.
    public long crearServicio(Servicio servicio){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SERVICIO_COLUMNA_NOMBRE,servicio.getNombre());
        values.put(SERVICIO_COLUMNA_DESCRIPCION,servicio.getDescripcion());
        values.put(SERVICIO_COLUMNA_AVATAR,servicio.getAvatar());

        long servicio_id = db.insert(SERVICIO_TABLA_NOMBRE,null,values);
        return  servicio_id;
    }

    //Retorna servicio  Servicio de BD.
    public Servicio getServicio(long servicio_id){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectServicio = "SELECT * FROM " + SERVICIO_TABLA_NOMBRE + " WHERE " + SERVICIO_COLUMNA_ID + " = " + servicio_id;

        Cursor cursor = db.rawQuery(selectServicio,null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        Servicio servicio = new Servicio();
        servicio.setId(cursor.getInt(cursor.getColumnIndex(SERVICIO_COLUMNA_ID)));
        servicio.setDescripcion(cursor.getString(cursor.getColumnIndex(SERVICIO_COLUMNA_DESCRIPCION)));
        servicio.setAvatar(cursor.getInt(cursor.getColumnIndex(SERVICIO_COLUMNA_AVATAR)));
        return  servicio;
    }

    //Actualiza registro  Servicio en BD.
    public int actualizarServicio(Servicio servicio){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SERVICIO_COLUMNA_NOMBRE,servicio.getNombre());
        values.put(SERVICIO_COLUMNA_DESCRIPCION,servicio.getDescripcion());
        values.put(SERVICIO_COLUMNA_AVATAR,servicio.getAvatar());

        return db.update(SERVICIO_TABLA_NOMBRE,values,SERVICIO_COLUMNA_ID + " = ?",new String[]{String.valueOf(servicio.getId())});
    }

    //Elimina registro  Servicio en BD.
    public void borrarServicio(long servicio_id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SERVICIO_TABLA_NOMBRE, SERVICIO_COLUMNA_ID + " = ?", new String[] { String.valueOf(servicio_id) });
    }

    public List<Servicio> getServicios(){
        List<Servicio> listaServicios = new ArrayList<Servicio>();

        String selectQuery = "SELECT nombre,avatar FROM " + SERVICIO_TABLA_NOMBRE + " ORDER BY 1 ASC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                Servicio servicio = new Servicio();
                servicio.setId(cursor.getInt(cursor.getColumnIndex(SERVICIO_COLUMNA_ID)));
                servicio.setNombre(cursor.getString(cursor.getColumnIndex(SERVICIO_COLUMNA_NOMBRE)));
                servicio.setDescripcion(cursor.getString(cursor.getColumnIndex(SERVICIO_COLUMNA_DESCRIPCION)));
                servicio.setAvatar(cursor.getInt(cursor.getColumnIndex(EMPLEADO_COLUMNA_AVATAR)));
                listaServicios.add(servicio);
            }while(cursor.moveToNext());
        }

        return listaServicios;
    }
}
