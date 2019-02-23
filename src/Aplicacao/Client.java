package Aplicacao;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			String input = "inicio";
			Socket client = new Socket("", 1234);
			Scanner in = new Scanner(client.getInputStream());
			Scanner inUser = new Scanner(System.in);
			PrintWriter out = new PrintWriter(client.getOutputStream(),true);
			System.out.println(in.nextLine());
			
			while (!input.equals("Voce ganhou")) {
				System.out.print("Digite um numero de 0 a 100:  ");
				out.println(inUser.nextLine());
				System.out.println(input = in.nextLine());
				if(input.equals("Voce perdeu")) {
					System.out.print(input = in.nextLine());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}