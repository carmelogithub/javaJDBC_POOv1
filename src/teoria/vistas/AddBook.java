package teoria.vistas;

import teoria.model.Libro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddBook {

public static void main(String[]args){
    //añadir un nuevo. insert
    //registrar el conector
    Connection conn = null;
    try {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/a_biblioteca","root","");
        Libro libro1 = new Libro(0, "La Colmena", "Cela", 74.95);
        String insertar="INSERT INTO libros (titulo, autor, precio) VALUES ('"+libro1.getTitulo()+"','"+libro1.getAutor()+"',"+libro1.getPrecio()+")";

        Statement stmt = conn.createStatement();
        int libros_nuevos = stmt.executeUpdate(insertar);
        
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }finally {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

}//cierra la clase
