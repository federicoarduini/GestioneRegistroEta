import java.io.Serializable;

public class NomeEta implements Serializable
{
	private String nome;
	private int eta;
	
	public NomeEta(String nome, int eta)
	{
		this.nome = nome;
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}

	public int getEta() {
		return eta;
	}
	
	public void incrementaEta()
	{
		this.eta++;
	}
	
	public String toString()
	{
		String s = this.getNome() + ", " + this.getEta() + " anni\n";
		return s;
	}
}
