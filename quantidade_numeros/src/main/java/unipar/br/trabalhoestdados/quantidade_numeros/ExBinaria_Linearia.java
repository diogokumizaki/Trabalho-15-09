/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package unipar.br.trabalhoestdados.quantidade_numeros;

// Desenvolva um programa que solicite ao usuario para informar a quantidade de numeros que ira cadastrar, 
//apos solicite para informar os mesmos. Nesse aplicativo deverá ter um menu para selecionar o tipo de pesquisa 
//que deseja fazer, linear ou binaria. Para efetuar
//a pesquisa solicite qual numero a ser pesquisado, coloque-os em ordem crescente e faça a pesquisa seleciona e exiba o usuario o resultado.


import java.util.Arrays;
import java.util.Scanner;

public class ExBinaria_Linearia {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a quantidade de números que deseja cadastrar: ");
        int quantidade = scanner.nextInt();

        int[] numeros = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Informe o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        Arrays.sort(numeros);

        System.out.print("Digite o número que deseja pesquisar: ");
        int numeroPesquisado = scanner.nextInt();

        System.out.println("Selecione o tipo de pesquisa:");
        System.out.println("1 - Pesquisa Linear");
        System.out.println("2 - Pesquisa Binária");
        int tipoPesquisa = scanner.nextInt();

        int resultado = -1;

        if (tipoPesquisa == 1) {
            resultado = pesquisaLinear(numeros, numeroPesquisado);
        } else if (tipoPesquisa == 2) {
            resultado = pesquisaBinaria(numeros, numeroPesquisado);
        } else {
            System.out.println("Tipo de pesquisa inválido.");
            return;
        }

        if (resultado == -1) {
            System.out.println("O número " + numeroPesquisado + " não foi encontrado na lista.");
        } else {
            System.out.println("O número " + numeroPesquisado + " foi encontrado na posição " + resultado + ".");
        }

        scanner.close();
    }

    public static int pesquisaLinear(int[] lista, int numero) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == numero) {
                return i;
            }
        }
        return -1;
    }

    public static int pesquisaBinaria(int[] lista, int numero) {
        int inicio = 0;
        int fim = lista.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (lista[meio] == numero) {
                return meio;
            } else if (lista[meio] < numero) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }
}
