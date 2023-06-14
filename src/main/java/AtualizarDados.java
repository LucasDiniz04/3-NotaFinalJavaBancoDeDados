import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarDados {
    public static void main(String[] args) {
        String SQLinserirDados = "INSERT INTO automovel (modelo, marca, ano, cor) VALUES (?, ?, ?, ?)";
        String driver = "jdbc:postgresql://localhost/SistemaAutomoveis";

        try (Connection conn = DriverManager.getConnection(driver, "postgres", "1234")) {
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

            System.out.println("Informe os dados do automóvel:");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            System.out.print("Ano: ");
            int ano = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            System.out.print("Cor: ");
            String cor = scanner.nextLine();

            PreparedStatement pstmt = conn.prepareStatement(SQLinserirDados);
            pstmt.setString(1, modelo);
            pstmt.setString(2, marca);
            pstmt.setInt(3, ano);
            pstmt.setString(4, cor);

            System.out.println("Atualizando dados na tabela...");
            pstmt.executeUpdate();
            System.out.println("Dados Inseridos!");

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}