import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {
    public static void main(String[] args){
        String SQLcriarTabela = "CREATE TABLE automovel ("+"modelo VARCHAR(60), marca VARCHAR(60), ano int, cor VARCHAR(60))";
        String driver = "jdbc:postgresql://localhost/SistemaAutomoveis";
        Statement st = null;
        
        try (Connection conn = DriverManager.getConnection(driver, "postgres", "1234")){
            if(conn!=null){
                System.out.println("Connected to the database!");
            }else{
                System.out.println("Failed to make connection!");
            }
            System.out.println("Criando dados da tabela, aguarde...");
            st = conn.createStatement();
            st.executeUpdate(SQLcriarTabela);
            System.out.println("Tabela criada c/ sucesso!");
            st.close();
            conn.close();
    }catch(SQLException e){      
        System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    }
  }
}
