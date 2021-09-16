import java.util.Scanner;

public class banco {
	public static void main(String[] args) {
		Gerente gerente1 = new Gerente();

		gerente1.setNomeGerente("Marcos");
		gerente1.setSalarioGerente(1000);

		System.out.println("Gerente: " + gerente1.getNomeGerente());
		System.out.println("Salário do gerente " + gerente1.getNomeGerente() + " é: " + gerente1.getSalarioGerente());

		System.out.println("Digite 1 para aumento de 10% do salário ou 2 para aumento maior de salário: ");
		Scanner teclado = new Scanner(System.in);
		int num = teclado.nextInt();

		if (num == 1) {
			gerente1.aumentoSalarial();
			System.out.println(gerente1.getSalarioGerente() + "\n");
		} else {
			gerente1.aumentoSalarial(Math.random() * 50);
			System.out.println(gerente1.getSalarioGerente() + "\n");
		}
// Abaixo será sobre a tranferencia que será feita entre contas
		System.out.println("Realizando tranferência entre contas da mesma ag. \n");
		Agencia a = new Agencia(1234);

		Conta origem = new Conta(a);
		origem.setSaldo(1000);
		System.out.println("Saldo da primeira conta: " + origem.getSaldo());

		Conta destino = new Conta(a);
		destino.setSaldo(1000);
		System.out.println("Saldo da segunda conta: " + destino.getSaldo());

		System.out.println("---------------------------------------------------");

		System.out.println("Realizando a transferencia");
		origem.transfere(destino, 500);

		System.out.println("---------------------------------------------------");

		System.out.println("Saldo da primeira conta: " + origem.getSaldo());
		System.out.println("Saldo da segunda conta: " + destino.getSaldo());

		System.out.println("---------------------------------------------------");

		Funcionario funcionario1 = new Funcionario();
		funcionario1.setNomeFuncionario("Ingrid");
		System.out.println("Funcionário(a): " + funcionario1.getNomeFuncionario() + ", recebe " + funcionario1.vRDiario
				+ " de VR diário");
		System.out.println("---------------------------------------------------");

		Funcionario.vRDiario = 20;
		System.out.println("Atulização do VR diário dos funcionários: \n Antigo valor do VR: " + Funcionario.vRDiario);
		Funcionario.aumentoVR(50);
		System.out.println("Atulização do VR diário dos funcionários: \n Novo valor do VR: " + Funcionario.vRDiario);

	}
}

class Pessoa {
	private String rg;
	private int cpf;

	private Pessoa(String rg) {
		this.rg = rg;
	}

	private Pessoa(int cpf) {
		this.cpf = cpf;
	}
}

class Conta {
	private Agencia agencia;
	private double saldo;
	private double limite;

	public Conta(Agencia agencia) {
		this.agencia = agencia;
	}

	public Conta(Agencia agencia, double limite) {
		this.agencia = agencia;
		this.limite = limite;
	}

	void deposita(double valor) {
		this.setSaldo(this.getSaldo() + valor);
	}

	double exibeSaldoComLimite() {
		return this.getSaldo() + this.limite;
	}

	void imprimeExtrato() {
		this.imprimeExtrato(15);
	}

	void imprimeExtrato(int dias) {
		System.out.println("Extrato do últimos " + dias + " dias");
	}

	public void transfere(Conta destino, double valor) {
		this.setSaldo(this.getSaldo() - valor);
		destino.setSaldo(destino.getSaldo() + valor);
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}

class CartaoDeCredito {
	private int numero;

	public CartaoDeCredito(int numero) {
		this.numero = numero;
	}
}

class Agencia {
	private int numero;

	public Agencia(int numero) {
		this.numero = numero;
	}
}

class Gerente {
	private String nomeGerente;
	private double salarioGerente;

	public void aumentoSalarial() {
		this.aumentoSalarial(10);
	}

	public void aumentoSalarial(double percentual) {
		this.setSalarioGerente(this.getSalarioGerente() + (this.getSalarioGerente() * (percentual / 100)));
	}

	public String getNomeGerente() {
		return nomeGerente;
	}

	public void setNomeGerente(String nomeGerente) {
		this.nomeGerente = nomeGerente;
	}

	public double getSalarioGerente() {
		return salarioGerente;
	}

	public void setSalarioGerente(double salarioGerente) {
		this.salarioGerente = salarioGerente;
	}
}

class Funcionario {
	private String nomeFuncionario;
	private double salarioFuncionario;
	public static double vRDiario = 25;

	static void aumentoVR(double percentual) {
		Funcionario.vRDiario += (Funcionario.vRDiario * (percentual / 100));
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
}