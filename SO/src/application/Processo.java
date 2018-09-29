package application;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.*;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Processo implements Runnable{
	public Image img;
	public int id,delta_ts,delta_tu;
	public String nome;
	public List<Recurso> recursos_disponiveis = new ArrayList<Recurso>();
	public List<Recurso> recursos_usados = new ArrayList<Recurso>();
	public Vertice vertice;
	public Grafo<Vertice> grafo;
	public boolean rodar = true;
	private FXML_Menu_Controlador controlador;
	private LocalTime instante;
	private int tempo = 0;
	private Recurso recurso_atual,recurso_bloqueador;
	private List<Integer> tempos_utilizacao_recursos = new ArrayList<Integer>();
	public Semaphore s = new Semaphore(0);
	public boolean bloqueado = false;
	
	public Processo(int id, String nome, Image img, int delta_ts, int delta_tu, List<Recurso> recursos, Grafo<Vertice> grafo){
		this.id = id;
		this.nome = nome;
		this.img = img;
		this.delta_ts = delta_ts;
		this.delta_tu = delta_tu;
		for(Recurso r : recursos)
			recursos_disponiveis.add(r);
		this.grafo = grafo;
		vertice = new Vertice(this.id,this.nome,"PROCESSO");
	}
	
	public void set_Controller(FXML_Menu_Controlador controlador){
		this.controlador = controlador;
	}
	
	public void Parar_Rodar(boolean valor){
		rodar = valor;
		if(recurso_bloqueador != null){
			recurso_bloqueador.Remover_Solicitacao(this.id, this.s);
			recurso_bloqueador = null;
			this.s.release();
		}
	}
	
	public void Finalizar(){
		for(Recurso r : recursos_usados){
			controlador.Desenhar_Aresta(this.vertice, r.vertice, 180, false);
			r.Liberar();
		}
		tempos_utilizacao_recursos.clear();
		recursos_usados.clear();
		grafo.Remover(this.vertice);
	}
	
	public void Solicitar_Recurso(){
		if(rodar){
			recurso_atual = recursos_disponiveis.get(new Random().nextInt(recursos_disponiveis.size()));
			controlador.Atualizar_Log(instante, "Processo " + nome + "(Id: " + id + ") solicitou o recurso " + recurso_atual.nome + "(Id: " + recurso_atual.id + ").");
			if(recurso_atual.s.availablePermits() == 0){
				controlador.Mostrar_Status_Processo(this.id,"STATUS: BLOQUEADO", Color.BLUE);
				controlador.Atualizar_Log(instante, "Processo " + nome + "(Id: " + id + ") foi BLOQUEADO!");
				recurso_bloqueador = recurso_atual;
				bloqueado = true;
			}
			grafo.add(this.vertice, recurso_atual.vertice);
			controlador.setar_Imagem_Recurso_Processo(this.id,recursos_usados.size() + 1, recurso_atual.img, 0.6);
			controlador.Desenhar_Aresta(this.vertice, recurso_atual.vertice, 0, true);
			if(bloqueado){
				recurso_atual.Adicionar_Solicitacao(this.id, this.s);
				try {
					s.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(!rodar)return;
			recurso_atual.Requisitar(this.id, this.s);
			recurso_atual.Remover_Solicitacao(this.id, this.s);
			bloqueado = false;
			recurso_bloqueador = null;
			controlador.Desenhar_Aresta(this.vertice, recurso_atual.vertice, 180, true);
			grafo.Remover(this.vertice, recurso_atual.vertice);
			grafo.add(recurso_atual.vertice, this.vertice);
			tempos_utilizacao_recursos.add(delta_tu);
			instante = LocalTime.now();
			controlador.Atualizar_Log(instante, "Processo " + nome + "(Id: " + id + ") está utilizando o recurso " + recurso_atual.nome + "(Id: " + recurso_atual.id + ").");
			controlador.Mostrar_Status_Processo(this.id,"STATUS: RODANDO", Color.BLACK);
			recursos_disponiveis.remove(recurso_atual);
			recursos_usados.add(recurso_atual);
			controlador.setar_Imagem_Recurso_Processo(this.id,recursos_usados.size(), recurso_atual.img, 1.0);
			controlador.Mostrar_Tempo_Recurso(this.id,tempos_utilizacao_recursos.size(), delta_tu);
		}
	}
	
	public void Liberar_Recurso(){
		recursos_usados.get(0).Liberar();
		grafo.Remover(recursos_usados.get(0).vertice, this.vertice);
		tempos_utilizacao_recursos.remove(0);
		controlador.Desenhar_Aresta(this.vertice, recursos_usados.get(0).vertice, 180, false);
		controlador.Atualizar_Log(instante, "Processo " + nome + "(Id: " + id + ") liberou o recurso " +recursos_usados.get(0).nome + "(Id: " + recursos_usados.get(0).id + ").");
		recursos_disponiveis.add(recursos_usados.get(0));
		recursos_usados.remove(0);
	}
	
	@Override
	public void run(){
		while(rodar){
			try {
				TimeUnit.SECONDS.sleep(1);
				tempo++;
				if(!tempos_utilizacao_recursos.isEmpty()){
					for(int i = 0; i < tempos_utilizacao_recursos.size(); i++){
						controlador.Mostrar_Tempo_Recurso(this.id, i + 1, tempos_utilizacao_recursos.get(i));
						tempos_utilizacao_recursos.set(i, tempos_utilizacao_recursos.get(i) - 1);
						controlador.Mostrar_Tempo_Recurso(this.id, i + 1, tempos_utilizacao_recursos.get(i));
						if(tempos_utilizacao_recursos.get(i) <= 0){
							controlador.Andar_Lista_Recursos_Imagens_Processo(this.id);
							if(tempos_utilizacao_recursos.size() > 1){
								tempos_utilizacao_recursos.set(1, tempos_utilizacao_recursos.get(1) - 1);
								controlador.Mostrar_Tempo_Recurso(this.id, 1, tempos_utilizacao_recursos.get(1));
							}
							instante = LocalTime.now();
							Liberar_Recurso();
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(tempo % delta_ts == 0)
				if(!recursos_disponiveis.isEmpty()){
					instante = LocalTime.now();
					Solicitar_Recurso();
				}
		}
		controlador.Encerrar_Processo(this.id);
	}
}
