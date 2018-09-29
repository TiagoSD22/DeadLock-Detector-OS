package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Relogio implements Runnable{
	
	private FXML_Menu_Controlador controller;
	public boolean rodar = true;
	
	public Relogio(){
	}
	
	public void set_Controller(FXML_Menu_Controlador controller){
		this.controller = controller;
	}
	
	public void Parar_Rodar(boolean valor){
		rodar = valor;
	}
	
	@Override
	public void run() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
		while(rodar){
			Calendar data_atual = Calendar.getInstance();
			controller.Atualizar_Data_Hora(String.valueOf(dateFormat.format(data_atual.getTime())),String.valueOf(horaFormat.format(data_atual.getTime())));
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
