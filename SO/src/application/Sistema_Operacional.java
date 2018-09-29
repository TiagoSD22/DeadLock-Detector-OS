package application;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class Sistema_Operacional implements Runnable{
	public int tempo_checagem;
	public boolean rodar = false;
	private FXML_Menu_Controlador controlador;
	private Grafo<Vertice> grafo;
	private LocalTime instante;
	private String info;
	
	public Sistema_Operacional(int delta_t){
		tempo_checagem = delta_t;
	}
	
	public void set_Delta_t(int delta_t){
		tempo_checagem = delta_t;
	}
	
	public void set_Grafo(Grafo<Vertice> grafo){
		this.grafo = grafo;
	}
	
	public void Parar_Rodar(boolean valor){
		rodar = valor;
	}
	
	public void set_Controller(FXML_Menu_Controlador controlador){
		this.controlador = controlador;
	}

	@Override
	public void run() {
		while(true) {
			while(rodar){
				try {
					TimeUnit.SECONDS.sleep(tempo_checagem);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(grafo.Possui_Ciclos()){
					controlador.Mostrar_Dialogo_Info(true);
					info = "Ocorreu DEADLOCK!\n  |            Processos em CICLO: ";
					for(int i = 0; i < grafo.ciclos.size(); i++){
						for(int j = 0; j < grafo.ciclos.get(i).size(); j++){
							if(grafo.ciclos.get(i).get(j).tipo == "PROCESSO"){
								info = info.concat("\n  |   \t\t" + grafo.ciclos.get(i).get(j).nome + "(Id: " + String.valueOf(grafo.ciclos.get(i).get(j).id) + ")");
								controlador.Mostrar_Informacoes_Ciclo(grafo.ciclos.get(i).get(j), "DEADLOCK");
							}
						}
					}
					grafo.Encontrar_Vertices_Impedidos();
					if(!grafo.impedidos.isEmpty()){
						info = info.concat("\n  |            Processos IMPEDIDOS: ");
						boolean tem_processo = false;
						for(int i = 0; i < grafo.impedidos.size(); i++){
							if(grafo.impedidos.get(i).tipo == "PROCESSO"){
								tem_processo = true;
								info = info.concat("\n  |   \t\t" + grafo.impedidos.get(i).nome + "(Id: " + String.valueOf(grafo.impedidos.get(i).id) + ")");
								controlador.Mostrar_Informacoes_Ciclo(grafo.impedidos.get(i), "IMPEDIDO");
							}
						}
						if(!tem_processo)
							info = info.concat("Nenhum");
					}
					grafo.Encontrar_Vertices_Livres();
					if(!grafo.livres.isEmpty()){
						info = info.concat("\n  |            Processos LIVRES: ");
						boolean tem_processo = false;
						for(int i = 0; i < grafo.livres.size(); i++){
							if(grafo.livres.get(i).tipo == "PROCESSO"){
								tem_processo = true;
								info = info.concat("\n  |   \t\t" + grafo.livres.get(i).nome + "(Id: " + String.valueOf(grafo.livres.get(i).id) + ")");
								controlador.Mostrar_Informacoes_Ciclo(grafo.livres.get(i), "LIVRE");
							}
						}
						if(!tem_processo)
							info = info.concat("Nenhum");
					}
					instante = LocalTime.now();
					controlador.Atualizar_Log(instante,info);
				}
				else{
					controlador.Mostrar_Dialogo_Info(false);
					info = "Não há DEADLOCK!";
					instante = LocalTime.now();
					controlador.Atualizar_Log(instante,info);
					for(Vertice v : grafo.vizinhos.keySet()){
						if(v.tipo == "PROCESSO")
							controlador.Mostrar_Informacoes_Ciclo(v, "LIVRE");
					}
				}
			}
			while(!rodar) {
				try {
					TimeUnit.MILLISECONDS.sleep(100);;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
