//Classes necessárias para uso de Banco de dados
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;
public class Filmes {
    public static void cadastrarFilmes() throws SQLException{
        ConexaoMySQL.getConexaoMySQL(); // abrindo conexão
        Connection connection = ConexaoMySQL.getConexaoMySQL();
        Statement stm = connection.createStatement(); 
         //Criando a tabela filmes se não existir
        stm.execute("CREATE TABLE IF NOT EXISTS tbl_filmes (id INT AUTO_INCREMENT primary key NOT NULL, nome varchar(50) NOT NULL, descricao varchar(2000), ano INT NOT NULL)");
        stm.execute("REPLACE INTO tbl_filmes (id, nome, descricao, ano) VALUES ('1','As aventuras de pi','Genero Aventura','2012'), ('2','Naufrago','Genero Drama','2000'), ('3','Tubarao','Genero Suspense','1975'), ('4','Mar em Furia','Genero Drama','1991'), ('5','Titanic','Genero Romance','1997'), ('6','Poseidon','Genero Aventura','2006'), ('7','Noe','Genero Drama','2014'), ('8','Capitao Phillips','Genero Açao','2013'), ('9','Mestre dos Mares','Genero Aventura','2003'), ('10','Mar Aberto','Genero Terror','2003'), ('11','SOS Mulheres ao Mar','Genero Romance','2014'), ('12','Meu passado me condena','Genero Comedia','2013'), ('13','A Pequena Sereia','Genero Infantil','2008'), ('14','Piratas do Caribe','Genero Aventura','2003'), ('15','Flipper','Genero Infantil','1996'), ('16','Popeye','Genero Infantil','1980'), ('17','Procurando Nemo','Genero Infantil','2003'), ('18','O Espanta Tubarões','Genero Infantil','2004'),('19','Bob Esponja um herói fora dagua','Genero Infantil','2015'),('20','O Mar nao este pra peixe','Genero Infantil','2006')");
        System.out.println("Filmes Cadastrados");
    }
    public static void filtrarPagina1(int qtdFilmes) throws SQLException{
        System.out.println("Você escolheu acessar " + qtdFilmes + " filmes" );
        System.out.println("Aqui estão eles" );
        ConexaoMySQL.getConexaoMySQL(); // abrindo conexão
        Connection connection = ConexaoMySQL.getConexaoMySQL();
        Statement stm = connection.createStatement(); 
        String selectFilmes = "SELECT id, nome, descricao, ano FROM tbl_filmes LIMIT 0, " + qtdFilmes; // Variavel que concatena os filmes que serão exibidos no SELECT do sql
        stm.execute(selectFilmes);
        ResultSet rst = stm.getResultSet(); // exibir os itens escolhido pelo usuario no console
            while(rst.next()){
                Integer id = rst.getInt("id");
                System.out.println(id);
                String nome = rst.getString("nome");
                System.out.println(nome);
                String descricao = rst.getString("descricao");
                System.out.println(descricao);
                Integer ano = rst.getInt("ano");
                System.out.println(ano);
            }
    }
    public static void filtrarPagina2(int qtdFilmes) throws SQLException{
      System.out.println("Você escolheu acessar " + qtdFilmes + " filmes" );
      System.out.println("Aqui estão eles" );
      ConexaoMySQL.getConexaoMySQL(); // abrindo conexão
      Connection connection = ConexaoMySQL.getConexaoMySQL();
      Statement stm = connection.createStatement(); 
      String selectFilmes = "SELECT id, nome, descricao, ano FROM tbl_filmes LIMIT 10, " + qtdFilmes; // Variavel que concatena os filmes que serão exibidos no SELECT do sql
      stm.execute(selectFilmes);
      ResultSet rst = stm.getResultSet(); //exibir os itens escolhido pelo usuario no console
          while(rst.next()){
              Integer id = rst.getInt("id");
              System.out.println(id);
              String nome = rst.getString("nome");
              System.out.println(nome);
              String descricao = rst.getString("descricao");
              System.out.println(descricao);
              Integer ano = rst.getInt("ano");
              System.out.println(ano);
          }
  }
    public static void menu() {
    System.out.println("Qual pagina você quer filtrar?");
    System.out.println("[1] Pagína 1");
    System.out.println("[2] Pagína 2");
    System.out.println("[0] Para sair do programa");
    System.out.print("> ");
   } 
   public static void main(String[] args) throws SQLException {
    Integer pagina;
    cadastrarFilmes();
    Scanner scan = new Scanner(System.in);
    do {
      menu();
      pagina = scan.nextInt();
      System.out.println("Quantos filmes você quer acessar?");
      System.out.println("> ");
      Integer qtdFilmes = scan.nextInt();
      switch (pagina) {
        case 0:
            System.out.println("Você selecionou sair da aplicação");
            scan.close();
            System.exit(0); // fecha aplicação
          break;
        case 1:
            System.out.println("Você selecionou filtrar pagina 1");
            filtrarPagina1(qtdFilmes);
          break;
        case 2:
            System.out.println("Você selecionou filtrar pagina 2 ");
            filtrarPagina2(qtdFilmes);
          break;
    default:
            System.out.println("O número escolhido é inválido! Digite um número entre 0 a 2.");
}
    }while(pagina != 0);
  ConexaoMySQL.FecharConexao(); // fechando conexao
}  
}
