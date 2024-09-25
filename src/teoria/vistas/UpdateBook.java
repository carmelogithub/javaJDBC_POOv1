package teoria.vistas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateBook {
    public static void main(String[] args){
        String actualizar= "UPDATE libros SET precio = ? WHERE id = ?";//consulta paramétrica
        Connection conn = null;
        try {
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/a_biblioteca","root","");
            PreparedStatement ps= conn.prepareStatement(actualizar);
            Scanner sc= new Scanner(System.in);
            System.out.println("Dime el id del libro que quieres actualizar: ");
            int id_libro = sc.nextInt();
            ps.setInt(2, id_libro);
            System.out.println("Dime el nuevo precio: ");
            double nuevo_precio = sc.nextDouble();
            ps.setDouble(1, nuevo_precio);
            int libros_actualizados = ps.executeUpdate();
            if (libros_actualizados<=0){
                System.out.println("No se ha actualizado ningún libro porque ese código no existe");
            }else{
                System.out.println("Se han actualizado "+libros_actualizados+" libros");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }//cierra main
}
