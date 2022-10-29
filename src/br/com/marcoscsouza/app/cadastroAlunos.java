package br.com.marcoscsouza.app;

import java.util.Locale;
import java.util.Scanner;

public class cadastroAlunos {
	private static Scanner sc = new Scanner(System.in);
	private static String menuOption;
	private static final int STUDENTS = 100;
	private static int idx = 0;

	private static String[] names = new String[STUDENTS];
	private static float[] note1 = new float[STUDENTS];
	private static float[] note2 = new float[STUDENTS];

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		System.out.println("Bem Vindo!!!");
		System.out.println("teste performance 1 - Cadastro de alunos");

		showMenu();

		sc.close();

	}

	private static void showMenu() {
		int idStudent = 0;

		do {
			System.out.println("");
			System.out.println("Escolha uma das opções abaixo:");
			System.out.println("[1] Registrar as notas de um novo aluno");
			System.out.println("[2] Consultar boletim de um aluno");
			System.out.println("[3] Consultar notas da turma");
			System.out.println("[4] Sair");
			System.out.println("");

			System.out.print("Escolha: ");
			menuOption = sc.next();

			switch (menuOption) {
			case "1":
				register();
				break;
			case "2":
				System.out.print("Escolha o código do aluno: ");
				idStudent = sc.nextInt();

				if (idStudent >= 0 && idStudent < idx) {
					print(idStudent);

				} else {
					System.out.println("Aluno não cadastrado!");
				}
				break;
			case "3":
				print();
				break;
			case "4":
				break;
			default:
				System.out.println("Opção inválida, tente novamente!");
			}

		} while (!"4".equalsIgnoreCase(menuOption));

		System.out.println("Obrigado por utilizar nosso app, volte sempre!");
	}

	private static void register() {
		System.out.println("cadastrar novo aluno!");
		System.out.println("quantidade de alunos: " + idx);

		if (idx < STUDENTS) {
			System.out.print("Informe o nome do aluno: ");
			names[idx] = sc.next();

			System.out.print("Informe a primeira nota: ");
			note1[idx] = convertFloatLocale(sc.next());

			System.out.print("Informe a segunda nota: ");
			note2[idx] = convertFloatLocale(sc.next());

			System.out.println("aluno cadastrado com sucesso!");
			idx++;

		} else {
			System.out.println("Voce não pode cadastrar mais alunos!");

		}

	}

	private static void print() {
		if (idx == 0) {
			System.out.println("Não há alunos cadastrados!");
			return;
		}
		System.out.println("Alunos cadastrados: ");
		for (int i = 0; i < STUDENTS; i++) {
			if (names[i] != null) {
				print(i);

			}
		}

	}

	private static void print(int option) {
		System.out.println("\nCodigo: " + option + "\nNome: " + names[option] + "\nNota 1: " + note1[option]
				+ "\nNota 2: " + note2[option]);
		System.out.println(calc(note1[option], note2[option]));

	}

	private static float convertFloatLocale(String num) {
		return Float.parseFloat(num.replace(",", "."));
	}

	private static String calc(float n1, float n2) {

		float average = (n1 + n2) / 2;

		if (average < 4) {
			return "Média final: " + average + "\nSituação: Reprovado";
		} else if (average >= 7) {
			return "Média final: " + average + "\nSituação: Aprovado";
		} else {
			return "Média final: " + average + "\nSituação: Prova Final";
		}

	}

}
