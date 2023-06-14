import java.util.Scanner;

public class SistemaCadastro {
    static String driverJDBC = "org.postgresql.Driver";
    public static void main(String[] args) {
        try{
            System.out.println("Carregando driver JDBC...");
            Class.forName(driverJDBC);
            System.out.println("Driver Carregado!");
        }catch(ClassNotFoundException e){
            System.out.printf("Falha no carregamento. %s", e);
        }
        
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        while(opcao != 6){
            System.out.println("---Sistema de Cadastro de Automóveis AutoPrime---");
            System.out.println("Informe a opção desejada: ");
            System.out.println("1: Criar uma tabela 'automoveis' no Banco de Dados caso não exista");
            System.out.println("2: Ler os dados da tabela");
            System.out.println("3: Inserir ou Atualizar dados");
            System.out.println("4: Apagar Dados");
            System.out.println("5: Mostrar todos os carros que foram fabricados após 2010");
            System.out.println("6: Sair");
            System.out.println("Informe a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcao){
                case 1:
                    CriarTabela.main(args);
                    break;
                case 2:
                    LerDados.main(args);
                    break;
                case 3:
                    AtualizarDados.main(args);
                    break;
                case 4:
                    ApagarDados.main(args);
                    break;
                case 5:
                    Mostrar2010.main(args);
                    break;
                case 6:
                    System.out.println("fechando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            System.out.printf("\n");
        }
    }
}
