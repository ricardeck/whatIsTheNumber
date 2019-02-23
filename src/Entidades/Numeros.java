package Entidades;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Numeros implements Runnable {
	Socket client;
	int numRand;
	int tentativas;

	public Numeros(Socket client) {
		this.client = client;
		Random r = new Random();
		numRand = r.nextInt(101);
		tentativas = 5;
	}

	@Override
	public void run() {
		try {
			Scanner in = new Scanner(this.client.getInputStream());
			PrintWriter out = new PrintWriter(this.client.getOutputStream(), true);
			out.println("Adivinhe o numero");
			while (true) {
				int num = Integer.parseInt(in.nextLine());
				if (num == numRand) {
					out.println("Voce ganhou");
					break;
				}
				if (tentativas <= 0) {
					out.println("Voce perdeu");
					out.println("O numero era " + numRand);
					break;
				}
				else if (num > numRand) {
					out.println("Chute mais baixo" + " - Tentativas Restantes = " + tentativas);
					tentativas--;
				}
				else if (num < numRand){
						out.println("Chute mais alto" + " - Tentativas Restantes = " + tentativas);
						tentativas--;
					}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}