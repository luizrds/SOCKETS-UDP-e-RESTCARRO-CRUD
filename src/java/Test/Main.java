/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author RaelH
 */
import DAO.CarroDAO;
import model.carro;
import java.util.Scanner;

/**
 *
 * @author RaelH
 */
public class Main {
    public static void main(String[] args) {

    Main m = new Main();
        m.menu();
    }

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public void menu() {

        System.out.println("1) Cadastrar Carro");
        System.out.println("2) Listar Todos Carros");
        System.out.println("3) Excluir Carro");
        System.out.println("4) Alterar Carro");
        System.out.println("5) Sair");
        System.out.print("Opção: ");
        int op = getScanner().nextInt();

        switch (op) {

            case 1:
                add_carro();
            case 2:
                listar_carro();
            case 3:
                excluir_carro();
            case 4:
                alterar_carro();
            case 5:
                System.exit(0);
            default:
                System.out.println("Digite uma opção valida!");
                menu();
        }
    }

    private void add_carro() {

        System.out.print("\nDigite o modelo: ");
        String modelo = getScanner().nextLine();
        System.out.print("Digite a cor: ");
        String cor = getScanner().nextLine();
        System.out.print("Digite a ano: ");
        int ano = getScanner().nextInt();
        System.out.print("Digite a preço: ");
        float preco = getScanner().nextFloat();
        
        
        //Instanciei um carro, normal...
        carro c = new carro (modelo, cor, ano ,preco);

        //Instanciando a classe DAO do Animal, chamando o metodo add_animal e passando como parametro o animal
        //criado acima
        CarroDAO cdao = new CarroDAO();
        cdao.add_carro(c);

        menu();
    }

    public void listar_carro() {

        //Instanciando a classe DAO do animal
        CarroDAO cdao = new CarroDAO();

        System.out.println("\t\n--- Todos os carros ---\n");

        //Passando um for no arraylist que o metodo mostrar_carros retorna
        for (carro c : cdao.mostrar_carro()) {
            System.out.println("ID do carro: " + c.getId());
            System.out.println("Modelo: " + c.getModelo());
            System.out.println("cor: " + c.getCor());
            System.out.println("Ano: " + c.getAno());
            System.out.println("Preço: " + c.getPreco());
        }
        menu();
    }

    public void excluir_carro() {

        CarroDAO cdao = new CarroDAO();

        System.out.print("\nDigite o número id para excluir: ");
        int id_carro = getScanner().nextInt();

        //Metodo que remove o carro pelo numero do chassi
        cdao.delete_carro(id_carro);
        menu();

    }

    public void alterar_carro() {

        //Tem varias forma de fazer essa alteração, escolhi encontrar o carro  chamando o metodo achar_carro da classe DAO, 
        //mostrar ele, e dar a liberdade de alterar todas as informações, em seguida passando essas novas informaçoes
        //pro metodos altera_carro da classe CarroDAO
        CarroDAO cdao = new CarroDAO();

        System.out.print("\nDigite o número do id para alterar: ");
        int id_carro = getScanner().nextInt();

        carro c = cdao.achar_carro(id_carro);

        System.out.println("\nAlterando Informações do Ccarro: \n");
        System.out.println("Modelo: "     + c.getModelo());
        System.out.println("Cor " + c.getCor());
        System.out.println("Ano " + c.getAno());
        System.out.println("Preço " + c.getPreco());
        
        System.out.println("Digite as novas informações: \n");

        System.out.print("Modelo: ");
        String modelo = getScanner().nextLine();
        System.out.print("Cor: ");
        String cor = getScanner().nextLine();
        System.out.print("Ano: ");
        int ano = getScanner().nextInt();
        System.out.print("Preço: ");
        float preco = getScanner().nextFloat();
        
        //Passando como parametro as informações e o numero do chassi do carro que foi digitado e posteriormente encontrado
        cdao.alterar_carro(id_carro, modelo, cor, ano, preco);
        menu();
    }

    private void alterar_Carro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void excluir_Carro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listar_Carro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void add_Carro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
