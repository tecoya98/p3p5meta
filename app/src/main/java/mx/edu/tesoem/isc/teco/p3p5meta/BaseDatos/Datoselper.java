package mx.edu.tesoem.isc.teco.p3p5meta.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Datoselper extends SQLiteOpenHelper {
    private static Datoselper datoselper=null;
    private static String NOMBREBD="bdAgenda";
    private static int VERSION_BD=1;

    public static class tabladatos{
        public static String TABLA="tbAgenda";
        public static String COLUMNA_ID="Id";
        public static  String COMLUMNA_NOMBRE="Nombre";
        public static  String COMLUMNA_EDAD="Edad";
        public static  String COMLUMNA_CORREO="Correo";

    }
    public static final String CONSULTA_CREAR_TABLA="create table "+
            tabladatos.TABLA+"("+tabladatos.COLUMNA_ID+"integer not null primary key autoincrement,"+
            tabladatos.COMLUMNA_NOMBRE+"varchar,"+ tabladatos.COMLUMNA_EDAD+"integer,"+
            tabladatos.COMLUMNA_CORREO+"varchar);";
    public static final String CONSULTA_ELIMINAR_TABLA="drop table if exists "+tabladatos.TABLA;

    public static Datoselper getInstance(Context context){
        if (datoselper==null){
            datoselper=new Datoselper(context.getApplicationContext());
        }return datoselper;
    }

    public Datoselper(Context context){
        super(context,NOMBREBD,null,VERSION_BD);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CONSULTA_CREAR_TABLA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CONSULTA_ELIMINAR_TABLA);
        onCreate(db);
    }
}
