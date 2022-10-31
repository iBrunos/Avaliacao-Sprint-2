//Classes necessárias para uso de Banco de dados //
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Produtos {
  public static void menu() {
        System.out.println("[1] Cadastrar os produtos");
        System.out.println("[2] Atualizar produto 1");
        System.out.println("[3] Excluir produto 2");
        System.out.println("[0] Sair da aplicação");
        System.out.print("> ");
}
  public static void cadastrarProdutos() throws SQLException{
  ConexaoMySQL.getConexaoMySQL(); // abrindo conexão
  Connection connection = ConexaoMySQL.getConexaoMySQL();
  Statement stm = connection.createStatement();
  //Criando a tabela produtos se não existir
  stm.execute("CREATE TABLE IF NOT EXISTS tbl_produtos(id INT AUTO_INCREMENT primary key NOT NULL, nome varchar(50) NOT NULL, descricao varchar(2000), quantidade INT, preco DECIMAL ) ");
  stm.execute("INSERT INTO tbl_produtos (id, nome, descricao, quantidade, preco) VALUES ('1','Livro de java','sem manchas e 1 mês de uso', '1','50.00' ),('2','Livro de Spring Boot','com manchas e 4 mês de uso', '2','35.00' ), ('3','Livro de HTML e CSS','Branquinho e 2 semanas de uso', '3','75.00')");
  System.out.println("3 produtos foram cadastrados no banco de dados");
}
  public static void atualizarProduto() throws SQLException {
  Connection connection2 = ConexaoMySQL.getConexaoMySQL();
  Statement stm2 = connection2.createStatement();
  stm2.execute("UPDATE tbl_produtos SET preco = 100 WHERE id='1'");
  ConexaoMySQL.FecharConexao();
  System.out.println("O produto 1 foi atualizado no banco");
}
  public static void deletarProduto() throws SQLException {
  Connection connection3 = ConexaoMySQL.getConexaoMySQL();
  Statement stm3 = connection3.createStatement();
  stm3.execute("DELETE FROM tbl_produtos WHERE id='2'");
  System.out.println("O produto 2 foi excluido no banco");
}
    public static void main(String[] args) throws SQLException {
      int resposta;
      Scanner scan = new Scanner(System.in);
      do {
        menu();
       resposta = scan.nextInt();
        switch (resposta) {
          case 0:
              System.out.println("Você selecionou sair da aplicação");
              scan.close();
              System.exit(0); // fecha aplicação
            break;
          case 1:
              System.out.println("Você selecionou cadastrar os produtos");
              cadastrarProdutos();
            break;
          case 2:
              System.out.println("Você selecionou atualizar produto 1 ");
              atualizarProduto();
            break;
          case 3:
              System.out.println("Você selecionou Excluir produto 2");
              deletarProduto();
              break;
      default:
              System.out.println("O número escolhido é inválido! Digite um número entre 0 a 3.");
  }
      }while(resposta != 0);
    ConexaoMySQL.FecharConexao(); // fechando conexao
  }  
  
}