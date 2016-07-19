package registro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



public class DataBaseManager {
	public static final String TABLE_NAME="palabra";
	public static final String CN_PALABRA1="palabra1";
	public static final String CN_PALABRA2="palabra2";
	public static final String CN_PALABRA3="palabra3";
	public static final String CN_SILABA1="silaba1";
	public static final String CN_SILABA2="silaba2";
	public static final String CN_SILABA3="silaba3";
	public static final String CN_SILABA4="silaba4";
	public static final String CN_ID="id";
	private DbHelper midb;
	private SQLiteDatabase db;
	

	/*
	 create table contactos(
	 	_id integer primary key autoincrement,
	 	nombre text not full,
	 	telefono text	
	  	); 
	 */
	public static final String CREATE_TABLE="create table "+TABLE_NAME+"("
			+CN_ID+"integer,"
			+CN_PALABRA1+" text,"
			+CN_PALABRA2+" text,"
			+CN_PALABRA3+" text,"
			+CN_SILABA1+" text,"
			+CN_SILABA2+" text,"
			+CN_SILABA3+" text,"
			+CN_SILABA4+" text);";
			
	public DataBaseManager(Context context) {
		midb=new DbHelper(context);
        db=midb.getWritableDatabase();
        
	}
	public ContentValues generarContent(String nombre,String telefono){
		ContentValues valores=new ContentValues();
		valores.put(CN_PALABRA1, nombre);
		valores.put(CN_PALABRA2, telefono);
		return valores;
		
	}
	public void insertar(String nombre,String telefono){
	
		db.insert(TABLE_NAME,CN_PALABRA1 , this.generarContent(nombre, telefono));
		
	
	}
	public void insertar2(String nombre,String telefono){
		//INSERT INTO contactos values(null,"Carlos","9999");
		db.execSQL("INSERT INTO "+TABLE_NAME+" values(null,'"+nombre+"','"+telefono+"');");
		 
	}
	public void insertarr(int id,String palabra1,String palabra2,String palabra3,String silaba1,String silaba2,String silaba3,String silaba4){
		//INSERT INTO contactos values(null,"Carlos","9999");
		db.execSQL("INSERT INTO "+TABLE_NAME+" values("+id+",'"
														    +palabra1+"','"
														    +palabra2+"','"
														    +palabra3+"','"
														    +silaba1+"','"
														    +silaba2+"','"
														    +silaba3+"','"
														    +silaba4+"');"
														    
				);
	
		 
	}
	public Cursor cargarCursorContactos(){
		String[] columnas=new String[]{CN_PALABRA1,CN_PALABRA2,CN_PALABRA3,CN_SILABA1,CN_SILABA2,CN_SILABA3,CN_SILABA4};
		return db.query(TABLE_NAME,columnas,null,null,null,null,null);
		
		
		
	}
	public void eliminar(){
		db.delete(TABLE_NAME, null, null); 
		
		
	}
	/*public void eliminar(String nombre){
		db.delete(TABLE_NAME, CN_NAME+"=?", new String[]{nombre}); 
		
		
	}
	
	public void eliminarMultiple(String nom1,String nom2){
		//db.delete(table, whereClause, whereArgs)
		db.delete(TABLE_NAME, CN_NAME+"IN(?,?)", new String[]{nom1,nom2}); 
	}
	public void modificarTelefono(String nombre,String nuevoTelefono){
		//
		db.update(TABLE_NAME, generarContent(nombre,nuevoTelefono),CN_NAME+"=?",new String[]{nombre});
		
	}
	public Cursor cargarCursorContactos(){
		String[] columnas=new String[]{CN_ID,CN_NAME,CN_PHONE};
		return db.query(TABLE_NAME,columnas,null,null,null,null,null);
		
		
		
	}
	public Cursor BuscarContacto(String nombre){
		String[] columnas=new String[]{CN_ID,CN_NAME,CN_PHONE};
		return db.query(TABLE_NAME,columnas,CN_NAME+"=?",new String[]{nombre},null,null,null);
		
	}*/
}
