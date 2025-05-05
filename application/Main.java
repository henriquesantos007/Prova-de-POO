/*
 * Alunos: Allan Gabriel da Cunha Vascolcelos (20240009142) & Luiz Henrique Santos da Graça (20240008261)
 * Desafio: Sistema de Pagamento de Funcionários
 */

package sistema_de_pagamentos_de_funcionario.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sistema_de_pagamentos_de_funcionario.entities.Assalariado;
import sistema_de_pagamentos_de_funcionario.entities.Comissionado;
import sistema_de_pagamentos_de_funcionario.entities.Horista;
import sistema_de_pagamentos_de_funcionario.entities.Funcionario;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Lista para guardar todos os funcionários que serão cadastrados.
        List<Funcionario> funcionarios = new ArrayList<>();

        int numFuncionario = 0;

        // Tratamento para a quandtidade de funcionarios cadastráveis. Não pode ser menor ou igual a 0.
        while (true){
            System.out.print("Informe quantos funcionários deseja cadastrar: ");
            numFuncionario = sc.nextInt();
            if (numFuncionario <= 0){
                System.out.println("\nEntrada inválida! Informe um número maior que 0!\n");
            }else{
                break;
            }
        }  


        // Laço para o cadástro.
        for (int i = 1; i <= numFuncionario;  i++){
            System.out.printf("\nFuncionário #%d:", i);
            System.out.print("\nNome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            String id = "";

            // Garante que o ID não seja negativo ou menor que zero e que tenha 5 dígitos
            while (true){
                System.out.print("ID de 5 dígitos: ");
                id = sc.next();
                int numInteiro = Integer.parseInt(id);
                if (id.length() != 5 || numInteiro < 0){
                    System.out.println("\nEntrada inválida! Informe um ID válido!\n");
                }else{
                    break;
                }
            }


            // Garante que o usuário informe uma letra maiúscula com a inicial de cada classe que extende o tipo funcionário
            char tipoFunc = ' ';
            while (true){
                System.out.print("Tipo do funcionario [H/C/A]: ");
                tipoFunc = sc.next().charAt(0);
                tipoFunc = Character.toUpperCase(tipoFunc);  
                if (tipoFunc == 'H' || tipoFunc == 'C' || tipoFunc == 'A'){
                    break;
                }else{
                    System.out.println("Entrada Inválida! Informe 'H', 'C' ou 'A'!");
                }
            }
            
            // Instância de um Funcionário Horista
            if (tipoFunc == 'H'){
                System.out.print("Horas trabalhadas: ");
                int horasTrabalhadas = sc.nextInt();
                System.out.print("Valor por hora: R$");
                Double valorPorHora = sc.nextDouble();

                Horista horista = new Horista(nome, id, horasTrabalhadas, valorPorHora);

                funcionarios.add(horista);
            }else if (tipoFunc == 'A'){ // Instância de um Funcionário Assalariado
                System.out.print("Salário base: R$: ");
                Double salario_base = sc.nextDouble();

                Assalariado assalariado  = new Assalariado(nome, id, salario_base);

                funcionarios.add(assalariado);
            }else if (tipoFunc == 'C'){// Instância de um Funcionário Comissionado
                System.out.print("Total de ventas R$: ");
                Double total_de_vendas = sc.nextDouble();

                Double percentual_comicao;

                // Garante que o usuário informe uma comiisão de 0 à 100;
                while(true){
                    System.out.print("Percentual de comissão [0% - 100%]: ");
                    percentual_comicao = sc.nextDouble();
                    if (percentual_comicao > 100 || percentual_comicao < 0){
                        System.out.println("Entrada Inválida!! Informe um número inteiro de 0 à 100!");
                    }
                    break;
                }

                Comissionado comissionado  = new Comissionado(nome, id, percentual_comicao, total_de_vendas);

                funcionarios.add(comissionado);
            }
        }

        // Exibe o salário de cada funcionário adicionado na lista de funcionários
        System.out.println("\n\nFOLHA SALARIAL:");
        for(Funcionario func : funcionarios){
            System.out.println(func.toString());
        }

        sc.close();
    }
}