package teoria.transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class tran1 {

    public static void main(String[] args) {
        // TODO code application logic here
        //insertar un nuevo libro + modificar el precio de otro libro

        String insertar= "INSERT INTO libros VALUES (null,?, ?, ?)";
        String actualizar= "UPDATE libros SET precio=? WHERE id=?";
        Connection conn=null;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/a_biblioteca", "root", "");
            conn.setAutoCommit(false);//desactivar el autocommit
            PreparedStatement ps= conn.prepareStatement(insertar);
            Scanner sc= new Scanner(System.in);
            System.out.println("Introduce el título del libro");
            String titulo= sc.nextLine();
            ps.setString(1, titulo);
            System.out.println("Introduce el autor del libro");
            String autor= sc.nextLine();
            ps.setString(2, autor);
            System.out.println("Introduce el precio del libro");
            double precio= sc.nextDouble();
            ps.setDouble(3, precio);
            int libro_insertado= ps.executeUpdate();//ejecuta el query si autocommit es true
            System.out.println("Libro insertado: "+libro_insertado);

            ps= conn.prepareStatement(actualizar);
            System.out.println("Introduce el id del libro a modificar");
            int id= sc.nextInt();
            ps.setInt(2, id);
            System.out.println("Introduce el nuevo precio del libro");
            double nuevo_precio= sc.nextDouble();
            ps.setDouble(1, nuevo_precio);
            int libro_actualizado= ps.executeUpdate();
            System.out.println("Libro actualizado: "+libro_actualizado);

            conn.commit();//confirmar la transacción cuando las dos consultas se realizan correctamente
            System.out.println("Transacción realizada con éxito");

        } catch (SQLException e) {
           System.out.println("Algo ha fallado");
            try {
                conn.rollback();//deshacer la transacción
                System.out.println("Transacción deshecha");
            } catch (SQLException ex) {
                System.out.println("No se ha podido deshacer la transacción");
            }

        }
    }//cierra main

}//cierra clase
