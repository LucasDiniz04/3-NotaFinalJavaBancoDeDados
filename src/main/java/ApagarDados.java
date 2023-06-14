import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ApagarDados {
    public static void main(String[] args){
        String SQLexcluirDados = "DELETE from automovel";
        String driver = "jdbc:postgresql://localhost/SistemaAutomoveis";
        Statement st = null;
        
        try (Connection conn = DriverManager.getConnection(driver, "postgres", "1234")){
            if(conn != null){
                System.out.println("Connected to the Database!");
            }else{
                System.out.println("Failed to make connection!");
            }
            System.out.println("Excluindo dados...");
            st = conn.createStatement();
            st.executeUpdate(SQLexcluirDados);
            System.out.println("Dados Excluidos!");
            st.close();
            conn.close();
    }catch(SQLException e){
        System.err.format("SQL State: %s\n%s" , e.getSQLState(), e.getMessage());
        }
    }
}