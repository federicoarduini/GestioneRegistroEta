import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

public class RegistroEtaCompleto
{
	private ArrayList<NomeEta> listaStudenti;
	
	public RegistroEtaCompleto()
	{
		this.listaStudenti = new ArrayList<NomeEta>();
	}
	
	public void leggiFile(String nomefile) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomefile)));
		this.listaStudenti = (ArrayList<NomeEta>) in.readObject();
		in.close();
	}
	
	public void aggiungiStudente(NomeEta ne)
	{
		this.listaStudenti.add(ne);
	}
	
	public Boolean incrementaEta(String nomeStudente)
	{
		for (int i = 0; i < this.listaStudenti.size(); i++)
		{
			if (this.listaStudenti.get(i) != null && this.listaStudenti.get(i).getNome().equals(nomeStudente))
			{
				this.listaStudenti.get(i).incrementaEta();
				return true;
			}
		}
		
		return false;
	}
	
	public void salvaFile(String nomefile) throws FileNotFoundException, IOException
	{
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomefile)));
		out.writeObject(this.listaStudenti);
		out.close();
	}
	
	public String toString()
	{
		String s = "LISTA STUDENTI:\n\n";
	
		for (NomeEta x : this.listaStudenti)
			s += " - " + x.toString();
		
		return s;
	}
}
