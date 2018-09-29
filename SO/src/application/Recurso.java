package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import javafx.scene.image.Image;

public class Recurso {
	public Image img;
	public String nome;
	public int id;
	public Semaphore s;
	public Vertice vertice;
	public List<Integer> solicitacoes = new ArrayList<Integer>();
	private Map<Integer,Semaphore> map = new HashMap<Integer,Semaphore>();
	
	public Recurso(int id,String nome,Image img){
		this.img = img;
		this.nome = nome;
		this.id = id;
		s = new Semaphore(1);
		vertice = new Vertice(this.id,this.nome,"RECURSO");
	}
	
	public void Requisitar(int id, Semaphore s){
		Adicionar_Solicitacao(id, s);
		try {
			this.s.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void Adicionar_Solicitacao(int id, Semaphore s){
		solicitacoes.add(id);
		map.put(id, s);
	}
	
	public void Remover_Solicitacao(int id, Semaphore s){
		map.remove(id);
		int index = 0;
		while(index < solicitacoes.size() && solicitacoes.get(index) != id)
			index++;
		solicitacoes.remove(index);
	}
	
	public void Liberar(){
		s.release();
		if(!solicitacoes.isEmpty()){
			map.get(solicitacoes.get(0)).release();
			map.remove(solicitacoes.get(0));
			solicitacoes.remove(0);
		}
	}
}
