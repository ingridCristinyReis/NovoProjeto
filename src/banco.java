import java.util.Scanner;

public class banco {
	public static void main(String[] args) {
//		Gerente gerente1 = new Gerente();
//
//		gerente1.nomeGerente = "Marcos";
//		gerente1.salarioGerente = 1000;
//
//		System.out.println("Gerente: " + gerente1.nomeGerente);
//		System.out.println("Salário do gerente " + gerente1.nomeGerente + " é: " + gerente1.salarioGerente);
//
//		System.out.println("Digite 1 para aumento de 10% do salário ou 2 para aumento maior de salário: ");
//		Scanner teclado = new Scanner(System.in);
//		int num = teclado.nextInt();
//
//		if (num == 1) {
//			gerente1.aumentoSalarial();
//			System.out.println(gerente1.salarioGerente + "\n");
//		} else {
//			gerente1.aumentoSalarial(Math.random() * 50);
//			System.out.println(gerente1.salarioGerente + "\n");
//		}
//// Abaixo será sobre a tranferencia que será feita entre contas
//		System.out.println("Realizando tranferência entre contas da mesma ag. \n");
//		Agencia a = new Agencia(1234);
//
//		Conta origem = new Conta(a);
//		origem.saldo = 1000;
//		System.out.println("Saldo da primeira conta: " + origem.saldo);
//
//		Conta destino = new Conta(a);
//		destino.saldo = 1000;
//		System.out.println("Saldo da segunda conta: " + destino.saldo);
//
//		System.out.println("---------------------------------------------------");
//
//		System.out.println("Realizando a transferencia");
//		origem.transfere(destino, 500);
//
//		System.out.println("---------------------------------------------------");
//
//		System.out.println("Saldo da primeira conta: " + origem.saldo);
//		System.out.println("Saldo da segunda conta: " + destino.saldo);

		System.out.println("---------------------------------------------------");
		
		Funcionario funcionario1 = new Funcionario();
		funcionario1.nomeFuncionario="Ingrid";
		System.out.println("Funcionário(a): " + funcionario1.nomeFuncionario + ", recebe " + funcionario1.vRDiario + " de VR diário");
		System.out.println("---------------------------------------------------");
		
		Funcionario.vRDiario = 20;
		System.out.println("Atulização do VR diário dos funcionários: \n Antigo valor do VR: " + Funcionario.vRDiario);
		Funcionario.aumentoVR(50);
		System.out.println("Atulização do VR diário dos funcionários: \n Novo valor do VR: " + Funcionario.vRDiario);

	}
}

class Pessoa {
	public String rg;
	public int cpf;

	public Pessoa(String rg) {
		this.rg = rg;
	}

	public Pessoa(int cpf) {
		this.cpf = cpf;
	}
}

class Conta {
	public Agencia agencia;
	public double saldo;
	public double limite;

	public Conta(Agencia agencia) {
		this.agencia = agencia;
	}

	public Conta(Agencia agencia, double limite) {
		this.agencia = agencia;
		this.limite = limite;
	}

	void deposita(double valor) {
		this.saldo += valor;
	}

	double exibeSaldoComLimite() {
		return this.saldo + this.limite;
	}

	void imprimeExtrato() {
		this.imprimeExtrato(15);
	}

	void imprimeExtrato(int dias) {
		System.out.println("Extrato do últimos " + dias + " dias");
	}

	public void transfere(Conta destino, double valor) {
		this.saldo -= valor;
		destino.saldo += valor;
	}
}

class CartaoDeCredito {
	public int numero;

	public CartaoDeCredito(int numero) {
		this.numero = numero;
	}
}

class Agencia {
	public int numero;

	public Agencia(int numero) {
		this.numero = numero;
	}
}

class Gerente {
	public String nomeGerente;
	public double salarioGerente;

	public void aumentoSalarial() {
		this.aumentoSalarial(10);
	}

	public void aumentoSalarial(double percentual) {
		this.salarioGerente += (this.salarioGerente * (percentual / 100));
	}
}
class Funcionario {
	public String nomeFuncionario;
	public double salarioFuncionario;
	public static double vRDiario = 25;
	
	static void aumentoVR (double percentual) {
		Funcionario.vRDiario += (Funcionario.vRDiario * (percentual/100));
	}
}