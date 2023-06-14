import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class LerDados {
    public static void main(String[] args){
        String SQLconsultarDados = "SELECT * FROM automovel";
        String driver = "jdbc:postgresql://localhost/SistemaAutomoveis";
        Statement st = null;
        ResultSet result = null;
        
        try (Connection conn = DriverManager.getConnection(driver, "postgres", "1234")) {
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
            
            System.out.println("Lendo dados da tabela...");
            st = conn.createStatement();
            result = st.executeQuery(SQLconsultarDados);
            
            while(result.next()){
                System.out.println("-----------------");
                System.out.println("Modelo: " + result.getString(1));
                System.out.println("Marca: " + result.getString(2));
                System.out.println("Ano: " + result.getInt(3));
                System.out.println("Cor: " + result.getString(4));
                System.out.println();
            }
        }catch(SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
