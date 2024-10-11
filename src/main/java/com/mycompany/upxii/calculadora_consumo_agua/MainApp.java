package com.mycompany.upxii.calculadora_consumo_agua;

import com.mycompany.upxii.calculadora_consumo_agua.Classes.Consumo;
import com.mycompany.upxii.calculadora_consumo_agua.Classes.Empresa;
import com.mycompany.upxii.calculadora_consumo_agua.Classes.Usuario;
import com.mycompany.upxii.calculadora_consumo_agua.DAO.ConsumoDAO;
import com.mycompany.upxii.calculadora_consumo_agua.DAO.EmpresaDAO;
import com.mycompany.upxii.calculadora_consumo_agua.DAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {

    public static void main(String args[]) throws SQLException {
        Usuario u = new Usuario();
        Scanner scanner = new Scanner(System.in);
        int opt = 1;
        
        boolean acesso = false;

        while (opt == 1) {
            System.out.print("1 - Cadastrar \n2 - Entrar \nResposta: ");
            opt = scanner.nextInt();

            if (opt == 1) {
                System.out.println("----- Cadastro -----");

                System.out.print("Digite um nome para o seu usuario: ");
                String login = scanner.next();

                System.out.print("Qual o seu nome (real): ");
                String nome = scanner.next();

                System.out.print("Coloque o seu email: ");
                String email = scanner.next();

                System.out.print("Crie uma senha: ");
                String senha = scanner.next();

                System.out.print("Qual a empresa que cuida do seu consumo de água \n 1 - Sabesp \n 2 - Saneaqua \nResposta: ");
                int empresaID = scanner.nextInt();

                u.setNome(nome);
                u.setEmail(email);
                u.setSenha(senha);
                u.setEmpresa(empresaID);
                u.setLogin(login);

                new UsuarioDAO().cadastrarUsuario(u);
            } else {
                System.out.println("----- Entrar -----");

                System.out.print("Usuário: ");
                String login = scanner.next();

                System.out.print("Senha: ");
                String senha = scanner.next();

                u.setLogin(login);
                u.setSenha(senha);

                acesso = new UsuarioDAO().loginUsuario(u);

                if (acesso) {
                    System.out.println("Acesso liberado!");
                } else {
                    System.out.println("Usuário ou senha incorretos!");
                }
            }

        }
        
        while (opt > 0){
            Usuario userJaLogado = new UsuarioDAO().userLogadoInfo(u);
            if(acesso == true){
                System.out.println("-------------------------------------------------");
                System.out.println("Olá, " + userJaLogado.getNome() + ". Essa é a sua área para gerenciar, adicionar ou remover seus consumos");
                System.out.println("-------------------------------------------------");
                
                System.out.println("Vamos começar! O que deseja fazer?\n");
                System.out.print("0 - Sair do programa \n1 - Adicionar consumo \n2 - Remover consumo \n3 - Editar consumo \n4 - Gerenciar consumo / realizar média \nResposta: ");
                opt = scanner.nextInt();
                
                switch (opt) {
                    case 0:
                        break;
                    
                    case 1:
                        System.out.println("------- Adicionar consumo -------\n");
                        
                        System.out.print("Quantidade em litros (Ex: 5): ");
                        int qtd_litros = scanner.nextInt();
                        
                        System.out.print("Descrição (Ex: Lavando carro): ");
                        String desc = scanner.next();
                        
                        Consumo c = new Consumo(qtd_litros, desc);
                        
                        new ConsumoDAO().adicionaConsumo(c, userJaLogado); //Passa como atributo um objeto CONSUMO e um objeto USUARIO (Ja logado)
                        
                        System.out.println("\nAdicionado com sucesso!\n");
                        break;
                    default:
                        throw new AssertionError();
                }
               
            }else{
                System.out.println("Seu acesso está negado! tente realizar o login ou reinicie o programa");
                break;
            }
        }
        

        //-------------------------------------------------------------------------
        /*
        // Cria uma instância de EmpresaDAO
        EmpresaDAO eDAO = new EmpresaDAO();

        // Obtém a empresa pelo ID
        Empresa empresa = eDAO.obterEmpresaPorId(empresaID);

        // Verifica se a empresa foi encontrada
        if (empresa != null) {
            // Exibe as informações da empresa
            System.out.println("Nome da Empresa: " + empresa.getNome());
            System.out.println("Tarifa Fixa: R$ " + empresa.getTarifaFixa());
            System.out.println("Faixa 1 Tarifa: R$ " + empresa.getFaixa1Tarifa());
            System.out.println("Faixa 2 Tarifa: R$ " + empresa.getFaixa2Tarifa());
            System.out.println("Faixa 3 Tarifa: R$ " + empresa.getFaixa3Tarifa());
            System.out.println("Data da Última Atualização: " + empresa.getDataUltimaAtualizacao());
        } else {
            System.out.println("Empresa não encontrada com o ID: " + empresaID);
        }
        
        //-------------------------------------------------------------------------
        
         */
    }
}
