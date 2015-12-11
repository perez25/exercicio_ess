package ServiceBetAPITest.models;

import ServiceBetAPITest.Observer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Apostador implements Observer{

	private String email;
	private double betESScoins;
	private String name;
	private  BufferedReader in;
	private  PrintStream out = null;

	public Apostador(String name, String email, double betESScoins) {
		this.email = email;
		this.name = name;
		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.out = System.out;
	}

	public Apostador() {
		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.out = System.out;
	}

	public String getEmail() {
		return email;
	}

	public double getBetESScoins() {
		return betESScoins;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBetESScoins(double betESScoins) {
		this.betESScoins = betESScoins;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Apostador{" +
				"email='" + email + '\'' +
				", betESScoins=" + betESScoins +
				", name='" + name + '\'' +
				'}';
	}

	@Override
	public void update(String notificacao) {


		System.out.println("\nApostador(" + this.name + "):" + notificacao + "\n");
	}


	// Views de Apostador

	public void viewCreateApostador(){

		String readinput;
		this.out.print("Introduza os seguintes dados de Apostador: (Nome, email, montante betESScoins\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			this.setName(tokens[0]);
			this.setEmail(tokens[1]);
			this.setBetESScoins(Double.parseDouble(tokens[2]));
			this.viewApostador();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void viewUpdateApostadpr(Apostador apostador){

		String readinput;
		this.out.print("Introduza novos dados de Apostador: (Nome("+ this.name +"), email("+this.email+"), montante betESScoins("+ this.betESScoins+")\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			apostador.setName(tokens[0]);
			apostador.setEmail(tokens[1]);
			apostador.setBetESScoins(Double.parseDouble(tokens[2]));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void viewDeleteApostador(){
		this.out.println("Remover Apostador"+this.viewApostador());

	}

	public String viewApostador(){

		String view;
		view = new String ("Apostador{" + "email='" + email +  ", betESScoins=" + betESScoins + ", name='" + name + '\'' + '}');
		this.out.println(view);
		return view;

	}

}