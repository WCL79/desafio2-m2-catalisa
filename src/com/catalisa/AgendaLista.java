package com.catalisa;
/*
Cadastro de contatos

Os alunos devem criar um programa para gerenciar uma lista de contatos, cada contato tem nome, telefone e email.
Nenhum programa final deve ser aplicado a uma lista de contatos cadastrados

Entrega mínima

sistema permite, via terminal, inserir pelo menos 1 contato em uma lista e retorno o mesmo na tela

Entrega média

O sistema permite adicionar mais de um contato e apresenta um menu para decidir
se deve adicionar mais usuários ou encerrar o programa

Entrega máxima

O sistema permite excluir um contato usando como parâmetro o e-mail e
 não permite inserir um contato com o e-mail repetido.
 */
import java.util.*;
import java.util.stream.Stream;

public class AgendaLista {

    public static String readLine(){
        return new Scanner(System.in).nextLine();
    }
    public static void showData(String text){
        System.out.println(text);
    }
    public static void main(String[] args) {
        Map<String, List<String>> contactMail = new HashMap<>();
        boolean go = true;

        showData("Agenda de contatos");

        String choice;

        do {
            showData("Digite ADD para adicionar contato.\nDigite EX para excluir um contato.\nDigite S para sair e mostrar todos os contatos.");
            choice = readLine();

            if (choice.equalsIgnoreCase("ADD")) {
                showData("Nome do contato: ");
                String name = readLine();

                showData("E-mail: ");
                String email = readLine();

                if (!contactMail.containsKey(email)) {
                    showData("Telefone: ");
                    String phone = readLine();

                    contactMail.put(email, Arrays.asList(name, phone, email));
                    showData("Contato adicionado.");
                } else {
                    showData("E-mail existente!");
                }
            } else if (choice.equalsIgnoreCase("EX")) {
                showData("Informe o e-mail para execluir contato");
                String email = readLine();

                if (contactMail.containsKey(email)) {
                    contactMail.remove(email);
                    showData("Contato removido.");
                } else {
                    showData("E-mail não existente!");
                }
            } else if (choice.equalsIgnoreCase("S")) {
                go = false;
            }
        } while(go);
        Stream.of(contactMail.toString()).forEach(System.out :: println);
    }

}