package teoria.vistas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBook {

    public static void main(String[] args){

        System.out.println("Dime el id del libro que quieres borrar: ");
        Scanner sc = new Scanner(System.in);
        int id_libro=sc.nextInt();
        String eliminar="DELETE FROM libros WHERE id="+id_libro;

        try(Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/a_biblioteca","root","")){
            PreparedStatement ps = conexion.prepareStatement(eliminar);
            int libros_eliminados = ps.executeUpdate();
            if (libros_eliminados<=0){
                System.out.println("No se ha eliminado ningún libro porque ese código no existe");
            }else{
                System.out.println("Se han eliminado "+libros_eliminados+" libros");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }//cierra main

}//cierra clase
