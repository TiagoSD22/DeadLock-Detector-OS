package application;

import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXML_Menu_Controlador implements Initializable {
	@FXML
	private AnchorPane tela_principal;
	@FXML
	private ScrollPane detalhes_scroll_pane;
	@FXML
	private Group detalhes_group;
	@FXML
	private Tab tab_grafo,tab_detalhes,tab_logs;
	@FXML
	private Button minimizar,fechar,power,add,gerenciadorx,gerenciador_processosx,confirmar_recurso,configuracao,confirmar_intervalo,intervalox,start,som,voltar_menu,novo_processo_bt,finalizar_processo_bt,confirmar_processo,remover_recurso,proximo,anterior,pular;
	@FXML
	private ImageView loki_icon,mic,menu_bg,loading,recurso1,recurso2,recurso3,recurso4,recurso5,recurso6,recurso7,recurso8,recurso9,recurso10,grafo_recurso1,grafo_recurso2,grafo_recurso3,grafo_recurso4,grafo_recurso5,grafo_recurso6,grafo_recurso7,grafo_recurso8,grafo_recurso9,grafo_recurso10,grafo_processo1,grafo_processo2,grafo_processo3,grafo_processo4,grafo_processo5,grafo_processo6,grafo_processo7,grafo_processo8,grafo_processo9,grafo_processo10,com_som_img,sem_som_img;
	@FXML
	private Pane main_window,gerenciador_window,notification_pane,configurar_intervalo,novo_processo_window,grafo_pane;
	@FXML
	private Pane processo1_pane,processo2_pane,processo3_pane,processo4_pane,processo5_pane,processo6_pane,processo7_pane,processo8_pane,processo9_pane,processo10_pane;
	@FXML
	private ImageView processo1,processo2,processo3,processo4,processo5,processo6,processo7,processo8,processo9,processo10,p1_pane,p2_pane,p3_pane,p4_pane,p5_pane,p6_pane,p7_pane,p8_pane,p9_pane,p10_pane;
	@FXML
	private ImageView processo1_recurso1,processo1_recurso2,processo1_recurso3,processo1_recurso4,processo1_recurso5,processo1_recurso6,processo1_recurso7,processo1_recurso8,processo1_recurso9,processo1_recurso10;
	@FXML
	private ImageView processo2_recurso1,processo2_recurso2,processo2_recurso3,processo2_recurso4,processo2_recurso5,processo2_recurso6,processo2_recurso7,processo2_recurso8,processo2_recurso9,processo2_recurso10;
	@FXML
	private ImageView processo3_recurso1,processo3_recurso2,processo3_recurso3,processo3_recurso4,processo3_recurso5,processo3_recurso6,processo3_recurso7,processo3_recurso8,processo3_recurso9,processo3_recurso10;
	@FXML
	private ImageView processo4_recurso1,processo4_recurso2,processo4_recurso3,processo4_recurso4,processo4_recurso5,processo4_recurso6,processo4_recurso7,processo4_recurso8,processo4_recurso9,processo4_recurso10;
	@FXML
	private ImageView processo5_recurso1,processo5_recurso2,processo5_recurso3,processo5_recurso4,processo5_recurso5,processo5_recurso6,processo5_recurso7,processo5_recurso8,processo5_recurso9,processo5_recurso10;
	@FXML
	private ImageView processo6_recurso1,processo6_recurso2,processo6_recurso3,processo6_recurso4,processo6_recurso5,processo6_recurso6,processo6_recurso7,processo6_recurso8,processo6_recurso9,processo6_recurso10;
	@FXML
	private ImageView processo7_recurso1,processo7_recurso2,processo7_recurso3,processo7_recurso4,processo7_recurso5,processo7_recurso6,processo7_recurso7,processo7_recurso8,processo7_recurso9,processo7_recurso10;
	@FXML
	private ImageView processo8_recurso1,processo8_recurso2,processo8_recurso3,processo8_recurso4,processo8_recurso5,processo8_recurso6,processo8_recurso7,processo8_recurso8,processo8_recurso9,processo8_recurso10;
	@FXML
	private ImageView processo9_recurso1,processo9_recurso2,processo9_recurso3,processo9_recurso4,processo9_recurso5,processo9_recurso6,processo9_recurso7,processo9_recurso8,processo9_recurso9,processo9_recurso10;
	@FXML
	private ImageView processo10_recurso1,processo10_recurso2,processo10_recurso3,processo10_recurso4,processo10_recurso5,processo10_recurso6,processo10_recurso7,processo10_recurso8,processo10_recurso9,processo10_recurso10;
	@FXML
	private ImageView processo1_recurso1_aresta,processo1_recurso2_aresta,processo1_recurso3_aresta,processo1_recurso4_aresta,processo1_recurso5_aresta,processo1_recurso6_aresta,processo1_recurso7_aresta,processo1_recurso8_aresta,processo1_recurso9_aresta,processo1_recurso10_aresta;
	@FXML
	private ImageView processo2_recurso1_aresta,processo2_recurso2_aresta,processo2_recurso3_aresta,processo2_recurso4_aresta,processo2_recurso5_aresta,processo2_recurso6_aresta,processo2_recurso7_aresta,processo2_recurso8_aresta,processo2_recurso9_aresta,processo2_recurso10_aresta;
	@FXML
	private ImageView processo3_recurso1_aresta,processo3_recurso2_aresta,processo3_recurso3_aresta,processo3_recurso4_aresta,processo3_recurso5_aresta,processo3_recurso6_aresta,processo3_recurso7_aresta,processo3_recurso8_aresta,processo3_recurso9_aresta,processo3_recurso10_aresta;
	@FXML
	private ImageView processo4_recurso1_aresta,processo4_recurso2_aresta,processo4_recurso3_aresta,processo4_recurso4_aresta,processo4_recurso5_aresta,processo4_recurso6_aresta,processo4_recurso7_aresta,processo4_recurso8_aresta,processo4_recurso9_aresta,processo4_recurso10_aresta;
	@FXML
	private ImageView processo5_recurso1_aresta,processo5_recurso2_aresta,processo5_recurso3_aresta,processo5_recurso4_aresta,processo5_recurso5_aresta,processo5_recurso6_aresta,processo5_recurso7_aresta,processo5_recurso8_aresta,processo5_recurso9_aresta,processo5_recurso10_aresta;
	@FXML
	private ImageView processo6_recurso1_aresta,processo6_recurso2_aresta,processo6_recurso3_aresta,processo6_recurso4_aresta,processo6_recurso5_aresta,processo6_recurso6_aresta,processo6_recurso7_aresta,processo6_recurso8_aresta,processo6_recurso9_aresta,processo6_recurso10_aresta;
	@FXML
	private ImageView processo7_recurso1_aresta,processo7_recurso2_aresta,processo7_recurso3_aresta,processo7_recurso4_aresta,processo7_recurso5_aresta,processo7_recurso6_aresta,processo7_recurso7_aresta,processo7_recurso8_aresta,processo7_recurso9_aresta,processo7_recurso10_aresta;
	@FXML
	private ImageView processo8_recurso1_aresta,processo8_recurso2_aresta,processo8_recurso3_aresta,processo8_recurso4_aresta,processo8_recurso5_aresta,processo8_recurso6_aresta,processo8_recurso7_aresta,processo8_recurso8_aresta,processo8_recurso9_aresta,processo8_recurso10_aresta;
	@FXML
	private ImageView processo9_recurso1_aresta,processo9_recurso2_aresta,processo9_recurso3_aresta,processo9_recurso4_aresta,processo9_recurso5_aresta,processo9_recurso6_aresta,processo9_recurso7_aresta,processo9_recurso8_aresta,processo9_recurso9_aresta,processo9_recurso10_aresta;
	@FXML
	private ImageView processo10_recurso1_aresta,processo10_recurso2_aresta,processo10_recurso3_aresta,processo10_recurso4_aresta,processo10_recurso5_aresta,processo10_recurso6_aresta,processo10_recurso7_aresta,processo10_recurso8_aresta,processo10_recurso9_aresta,processo10_recurso10_aresta;
	@FXML
	private Label processo1_nome,processo1_id,processo1_ts,processo1_tu;
	@FXML
	private Label processo2_nome,processo2_id,processo2_ts,processo2_tu;
	@FXML
	private Label processo3_nome,processo3_id,processo3_ts,processo3_tu;
	@FXML
	private Label processo4_nome,processo4_id,processo4_ts,processo4_tu;
	@FXML
	private Label processo5_nome,processo5_id,processo5_ts,processo5_tu;
	@FXML
	private Label processo6_nome,processo6_id,processo6_ts,processo6_tu;
	@FXML
	private Label processo7_nome,processo7_id,processo7_ts,processo7_tu;
	@FXML
	private Label processo8_nome,processo8_id,processo8_ts,processo8_tu;
	@FXML
	private Label processo9_nome,processo9_id,processo9_ts,processo9_tu;
	@FXML
	private Label processo10_nome,processo10_id,processo10_ts,processo10_tu;
	@FXML
	private Label processo1_recurso1_tu,processo1_recurso2_tu,processo1_recurso3_tu,processo1_recurso4_tu,processo1_recurso5_tu,processo1_recurso6_tu,processo1_recurso7_tu,processo1_recurso8_tu,processo1_recurso9_tu,processo1_recurso10_tu;
	@FXML
	private Label processo2_recurso1_tu,processo2_recurso2_tu,processo2_recurso3_tu,processo2_recurso4_tu,processo2_recurso5_tu,processo2_recurso6_tu,processo2_recurso7_tu,processo2_recurso8_tu,processo2_recurso9_tu,processo2_recurso10_tu;
	@FXML
	private Label processo3_recurso1_tu,processo3_recurso2_tu,processo3_recurso3_tu,processo3_recurso4_tu,processo3_recurso5_tu,processo3_recurso6_tu,processo3_recurso7_tu,processo3_recurso8_tu,processo3_recurso9_tu,processo3_recurso10_tu;
	@FXML
	private Label processo4_recurso1_tu,processo4_recurso2_tu,processo4_recurso3_tu,processo4_recurso4_tu,processo4_recurso5_tu,processo4_recurso6_tu,processo4_recurso7_tu,processo4_recurso8_tu,processo4_recurso9_tu,processo4_recurso10_tu;
	@FXML
	private Label processo5_recurso1_tu,processo5_recurso2_tu,processo5_recurso3_tu,processo5_recurso4_tu,processo5_recurso5_tu,processo5_recurso6_tu,processo5_recurso7_tu,processo5_recurso8_tu,processo5_recurso9_tu,processo5_recurso10_tu;
	@FXML
	private Label processo6_recurso1_tu,processo6_recurso2_tu,processo6_recurso3_tu,processo6_recurso4_tu,processo6_recurso5_tu,processo6_recurso6_tu,processo6_recurso7_tu,processo6_recurso8_tu,processo6_recurso9_tu,processo6_recurso10_tu;
	@FXML
	private Label processo7_recurso1_tu,processo7_recurso2_tu,processo7_recurso3_tu,processo7_recurso4_tu,processo7_recurso5_tu,processo7_recurso6_tu,processo7_recurso7_tu,processo7_recurso8_tu,processo7_recurso9_tu,processo7_recurso10_tu;
	@FXML
	private Label processo8_recurso1_tu,processo8_recurso2_tu,processo8_recurso3_tu,processo8_recurso4_tu,processo8_recurso5_tu,processo8_recurso6_tu,processo8_recurso7_tu,processo8_recurso8_tu,processo8_recurso9_tu,processo8_recurso10_tu;
	@FXML
	private Label processo9_recurso1_tu,processo9_recurso2_tu,processo9_recurso3_tu,processo9_recurso4_tu,processo9_recurso5_tu,processo9_recurso6_tu,processo9_recurso7_tu,processo9_recurso8_tu,processo9_recurso9_tu,processo9_recurso10_tu;
	@FXML
	private Label processo10_recurso1_tu,processo10_recurso2_tu,processo10_recurso3_tu,processo10_recurso4_tu,processo10_recurso5_tu,processo10_recurso6_tu,processo10_recurso7_tu,processo10_recurso8_tu,processo10_recurso9_tu,processo10_recurso10_tu;
	@FXML
	private Label processo1_status,processo2_status,processo3_status,processo4_status,processo5_status,processo6_status,processo7_status,processo8_status,processo9_status,processo10_status;
	@FXML
	private TabPane gerenciador_main_window;
	@FXML
	private TextField recurso_id,recurso_nome,intervalo_deltat,processo_id,processo_nome,processo_ts,processo_tu;
	@FXML
	private TextArea historico;
	@FXML
	private ListView<String> recurso_imagem,processo_imagem;
	@FXML
	private Label texto_notificacao,data,hora,dialogo_info;
	
	private ImageView power_on,power_off,minimizar_foco,minimizar_n_foco,fechar_foco,fechar_n_foco,add_img,start_img,gerenciador_close,confirmar_recurso_icone,configuracao_close,confirmar_configuracao_icone,voltar_menu_img,fechar_gerenciador_processos_img, confirmar_processo_img;
	private Image desktop,desktop_erro,boot1,boot2,load_icon,os_icon,shut_down,main_program;
	private boolean ligado = false,com_som = true,modo_remocao = false,tem_campos_vazios = false,dead_lock = false,tutorial = true;
	private MediaPlayer startup,off,novo_dispositivo_reconhecido,dispositivo_removido,erro,confirmar_tempo,remocao;
	private Timeline booting,desligando,notificacao;
	private int n_recursos = 0,n_processos = 0, n_campos_vazios = 0,passo_tutorial = 0;
	private final DropShadow contorno_bloqueado = new DropShadow( 30, Color.RED);
	private final DropShadow contorno_impedido = new DropShadow( 30, Color.BLUE);
	private final Image lixo = new Image(getClass().getResource("/Fontes/Imagens/lixo.png").toExternalForm());
	private ImageCursor remover = new ImageCursor(lixo);
	private final Image audio_img = new Image(getClass().getResource("/Fontes/Imagens/Recursos/audio.png").toExternalForm());
	private final Image cd_img = new Image(getClass().getResource("/Fontes/Imagens/Recursos/cd.png").toExternalForm());
	private final Image documento_img = new Image(getClass().getResource("/Fontes/Imagens/Recursos/documento.png").toExternalForm());
	private final Image hd_img = new Image(getClass().getResource("/Fontes/Imagens/Recursos/hd.png").toExternalForm());
	private final Image imagem_img = new Image(getClass().getResource("/Fontes/Imagens/Recursos/imagem.png").toExternalForm());
	private final Image impressora_img = new Image(getClass().getResource("/Fontes/Imagens/Recursos/impressora.png").toExternalForm());
	private final Image microfone_img = new Image(getClass().getResource("/Fontes/Imagens/Recursos/microfone.png").toExternalForm());
	private final Image speaker_img = new Image(getClass().getResource("/Fontes/Imagens/Recursos/speaker.png").toExternalForm());
	private final Image usb_img = new Image(getClass().getResource("/Fontes/Imagens/Recursos/USB.png").toExternalForm());
	private final Image webcam_img = new Image(getClass().getResource("/Fontes/Imagens/Recursos/webcam.png").toExternalForm());
	
	private Image[] lista_de_imagens = {audio_img,cd_img,documento_img,hd_img,imagem_img,impressora_img,microfone_img,speaker_img,usb_img,webcam_img};
	
	private final Image bioshock_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/bioshock.png").toExternalForm());
	private final Image chrome_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/chrome.png").toExternalForm());
	private final Image code_blocks_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/code_blocks.png").toExternalForm());
	private final Image cup_head_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/cuphead.png").toExternalForm());
	private final Image ds_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/ds.png").toExternalForm());
	private final Image eclipse_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/eclipse.png").toExternalForm());
	private final Image edge_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/edge.png").toExternalForm());
	private final Image gimp_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/gimp.png").toExternalForm());
	private final Image java_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/java.png").toExternalForm());
	private final Image media_player_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/media_player.png").toExternalForm());
	private final Image mozilla_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/mozilla.png").toExternalForm());
	private final Image photo_shop_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/photo_shop.png").toExternalForm());
	private final Image power_point_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/power_point.png").toExternalForm());
	private final Image python_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/python.png").toExternalForm());
	private final Image safari_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/safari.png").toExternalForm());
	private final Image steam_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/steam.png").toExternalForm());
	private final Image stremio_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/stremio.png").toExternalForm());
	private final Image utorrent_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/utorrent.png").toExternalForm());
	private final Image vlc_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/vlc.png").toExternalForm());
	private final Image writer_img = new Image(getClass().getResource("/Fontes/Imagens/Processos/writer.png").toExternalForm());
	
	private Image[] lista_de_imagens_processos = {bioshock_img,chrome_img,code_blocks_img,cup_head_img,ds_img,eclipse_img,
										  	      edge_img,gimp_img,java_img,media_player_img,mozilla_img,photo_shop_img,power_point_img,
										  	      python_img,safari_img,steam_img,stremio_img,utorrent_img,vlc_img,writer_img};
	
	private final Image rosto1 = new Image(getClass().getResource("/Fontes/Imagens/Faces/beemo1.jpg").toExternalForm());
	private final Image rosto2 = new Image(getClass().getResource("/Fontes/Imagens/Faces/beemo2.jpg").toExternalForm());
	private final Image rosto3 = new Image(getClass().getResource("/Fontes/Imagens/Faces/beemo3.jpg").toExternalForm());
	private final Image rosto4 = new Image(getClass().getResource("/Fontes/Imagens/Faces/beemo0.png").toExternalForm());
	private final Image rosto5 = new Image(getClass().getResource("/Fontes/Imagens/Faces/beemo4.jpg").toExternalForm());
	private final Image rosto6 = new Image(getClass().getResource("/Fontes/Imagens/Faces/beemo5.jpg").toExternalForm());
	private final Image rosto7 = new Image(getClass().getResource("/Fontes/Imagens/Faces/beemo6.jpg").toExternalForm());
	private final Image rosto8 = new Image(getClass().getResource("/Fontes/Imagens/Faces/beemo7.png").toExternalForm());
	private Image[] rostos_dead_lock = {rosto1,rosto2,rosto3};
	private Image[] rostos_normal = {rosto4,rosto5,rosto6,rosto7};
	
	private String[] frases_dead_lock = {"Oh não, aconteceu aquela coisa feia! Os pobres processos estão travados...",
										 "Minha nossa, olha o que aconteceu! DEADLOCK!!",
										 "Eita bit do céu, agora travou foi tudo!",
										 "Eu não consigo nem olhar pra esse DEADLOCK feioso!",
										 "Eu odeio quando acontece isso, esses processos esperando para sempre um pelo outro, tsc tsc tsc...",
										 "Eu sabia que ia dar m**** uma hora ou outra, olha aí o DEADLOCK!",
										 "Esses processos em DEADLOCK estão mais travados do que o time do Ceará.(risos...)"};
	
	private String[] frases_normal = {"Tudo está indo bem por aqui até o momento!",
									  "Sem DEADLOCK por enquanto, senhor!",
									  "Eu adoro ver esses processos lindões rodando normalmente!",
									  "Ainda bem que não tem nenhum processo travado, odiaria ter que ver isso!",
									  "As coisas estão seguindo como deveriam, tudo normal ate agora.",
									  "Olha, vou te contar, se continuar assim, eu vou ficar muito feliz!",
									  "Tudo rodando lindamente, igual ao Fortaleza jogando na série B. (risos...)"};
	
	private String[] frases_dead_lock_desfeito = {"Ufa, o DEADLOCK se desfez, ainda bem. Até um outro dia!",
												  "Acabamos de jeito com o DEADLOCK, agora tudo vai ficar bem, espero...",
												  "Já pensou se eu não tivesse essa função de matar um processo? A gente ia ter que esperar os processos voluntariamente cederem seus recursos! rsrs",
												  "Matador de DEADLOCKs na parada, colocando as coisas para funcionarem! Tudo bem agora.",
												  "O malvado do DEADLOCK foi embora, agora os processos podem rodar."};
	
	private String[] frases_dead_lock_continua = {"Você sabia que eu posso matar um processo e desfazer esse DEADLOCK,sabia?",
												  "Que tal se a gente desfizer esse DEADLOCK? Ele está me incomodando um pouco...",
												  "Eu sei que você quer esperar os processos resolverem o DEADLOCK entre si e tal, mas isso NÃO vai rolar, chapa, finaliza logo alguém aí!",
												  "Eu já te avisei que deu DEADLOCK, ou você só não viu ainda?",
												  "Estou achando que você ainda não percebeu que tá tudo travado aqui parceiro, olha esse DEADLOCK louco aí!",
												  "Se você não desfizer esse DEADLOCK agora eu mesmo vou! ...mentira, eu não posso fazer isso sozinho, você tem que clicar naquele botãozinho escrito Finalizar Processo",
												  "Já viu esse botão Finalizar Processo? Clica nele, coisas legais acontecem quando você clica, tipo, acabar com esse DEADLOCK, experimenta!"};
	
	private String[]  frases_sem_processos = {"Está indo tudo bem, mas já era de se esperar...",
											   "Você deveria experimentar esse botão Novo Processso, quem sabe ficaria mais divertido por aqui.",
											   "Sabe, eu não vou ter DEADLOCK para detectar se não houver nenhum processo!",
											   "Adiciona alguns processos ai,amigão, vai ser legal, vai por mim.",
											   "Tudo normal e chato, sem DEADLOCKS e nem processos."};
	
	private Semaphore mutex = new Semaphore(1);
	private Sistema_Operacional so;
	private Thread Sistema;
	private Recurso recurso_atual_selecionado;
	private List<Recurso> recursos = new ArrayList<Recurso>();
	private List<Processo> processos = new ArrayList<Processo>();
	private Grafo<Vertice> grafo = new Grafo<Vertice>();
	
	private FXML_Menu_Controlador controlador;
	
	public FXML_Menu_Controlador() {
	}
	
	public void set_Controlador(FXML_Menu_Controlador controlador){
		this.controlador = controlador;
	}
	
	public void Fechar_Janela(){
		Platform.runLater(()->{
		Platform.exit();
		System.exit(0);});
	}
	
	public void Minimizar_Janela(){
		Stage tela = (Stage)minimizar.getScene().getWindow();
		tela.setIconified(true);
	}
	
	public void Setar_Imagens(){
		minimizar_n_foco = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/minimizar.png").toExternalForm()));
		minimizar_n_foco.setFitWidth(minimizar.getWidth());
		minimizar_n_foco.setFitHeight(minimizar.getHeight());
		minimizar.setBackground(null);
		minimizar.setGraphic(minimizar_n_foco);
		
		minimizar_foco = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/minimizar_foco.png").toExternalForm()));
		minimizar_foco.setFitWidth(minimizar.getWidth());
		minimizar_foco.setFitHeight(minimizar.getHeight());
		
		fechar_n_foco = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/fechar.png").toExternalForm()));
		fechar_n_foco.setFitWidth(fechar.getWidth());
		fechar_n_foco.setFitHeight(fechar.getHeight());
		fechar.setBackground(null);
		fechar.setGraphic(fechar_n_foco);
		
		fechar_foco = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/fechar_foco.png").toExternalForm()));
		fechar_foco.setFitWidth(fechar.getWidth());
		fechar_foco.setFitHeight(fechar.getHeight());
		
		power_off = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/power0.png").toExternalForm()));
		power_off.setFitWidth(power.getWidth());
		power_off.setFitHeight(power.getHeight());
		power.setBackground(null);
		power.setGraphic(power_off);
		
		add_img = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/add.png").toExternalForm()));
		add_img.setFitHeight(add.getHeight());
		add_img.setFitWidth(add.getWidth());
		add.setBackground(null);
		add.setGraphic(add_img);
		
		start_img = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/start.png").toExternalForm()));
		start_img.setFitHeight(start.getHeight());
		start_img.setFitWidth(start.getWidth());
		start.setBackground(null);
		start.setGraphic(start_img);
		
		power_on = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/power2.png").toExternalForm()));
		power_on.setFitWidth(power.getWidth());
		power_on.setFitHeight(power.getHeight());
		
		confirmar_recurso_icone = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/ok.png").toExternalForm()));
		confirmar_recurso_icone.setFitWidth(confirmar_recurso.getWidth());
		confirmar_recurso_icone.setFitHeight(confirmar_recurso.getHeight());
		confirmar_recurso.setBackground(null);
		confirmar_recurso.setGraphic(confirmar_recurso_icone);
		
		confirmar_configuracao_icone = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/ok.png").toExternalForm()));
		confirmar_configuracao_icone.setFitWidth(confirmar_intervalo.getWidth());
		confirmar_configuracao_icone.setFitHeight(confirmar_intervalo.getHeight());
		confirmar_intervalo.setBackground(null);
		confirmar_intervalo.setGraphic(confirmar_configuracao_icone);
		
		boot1 = new Image(getClass().getResource("/Fontes/Imagens/boot.png").toExternalForm());
		boot2 = new Image(getClass().getResource("/Fontes/Imagens/boot2.png").toExternalForm());
		shut_down = new Image(getClass().getResource("/Fontes/Imagens/shut_down.png").toExternalForm());
		
		//load_icon = new Image(getClass().getResource("/Fontes/Imagens/load.gif").toExternalForm());
		load_icon = null;
		
		os_icon = new Image(getClass().getResource("/Fontes/Imagens/os_icon.png").toExternalForm());
		desktop = new Image(getClass().getResource("/Fontes/Imagens/desktop.jpg").toExternalForm());
		desktop_erro = new Image(getClass().getResource("/Fontes/Imagens/desktop_erro.jpg").toExternalForm());
		main_program = new Image(getClass().getResource("/Fontes/Imagens/main_program.png").toExternalForm());
		
		gerenciador_close = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/x.png").toExternalForm()));
		gerenciador_close.setFitWidth(gerenciadorx.getWidth());
		gerenciador_close.setFitHeight(gerenciadorx.getHeight());
		gerenciadorx.setBackground(null);
		gerenciadorx.setGraphic(gerenciador_close);
		
		voltar_menu_img = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/x.png").toExternalForm()));
		voltar_menu_img.setFitWidth(voltar_menu.getWidth());
		voltar_menu_img.setFitHeight(voltar_menu.getHeight());
		voltar_menu.setBackground(null);
		voltar_menu.setGraphic(voltar_menu_img);
		
		com_som_img = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/sound.png").toExternalForm()));
		com_som_img.setFitWidth(som.getWidth());
		com_som_img.setFitHeight(som.getHeight());
		som.setBackground(null);
		som.setGraphic(com_som_img);
		
		sem_som_img = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/no_sound.png").toExternalForm()));
		sem_som_img.setFitWidth(som.getWidth());
		sem_som_img.setFitHeight(som.getHeight());
		
		configuracao_close = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/x.png").toExternalForm()));
		configuracao_close.setFitWidth(intervalox.getWidth());
		configuracao_close.setFitHeight(intervalox.getHeight());
		intervalox.setBackground(null);
		intervalox.setGraphic(configuracao_close);
		
		fechar_gerenciador_processos_img = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/x.png").toExternalForm()));
		fechar_gerenciador_processos_img.setFitWidth(gerenciador_processosx.getWidth());
		fechar_gerenciador_processos_img.setFitHeight(gerenciador_processosx.getHeight());
		gerenciador_processosx.setBackground(null);
		gerenciador_processosx.setGraphic(fechar_gerenciador_processos_img);
		
		confirmar_processo_img = new ImageView(new Image(getClass().getResource("/Fontes/Imagens/ok.png").toExternalForm()));
		confirmar_processo_img.setFitWidth(confirmar_processo.getWidth());
		confirmar_processo_img.setFitHeight(confirmar_processo.getHeight());
		confirmar_processo.setBackground(null);
		confirmar_processo.setGraphic(confirmar_processo_img);
		
		Carregar_Boot();
		Carregar_Desligamento();
	}
	
	public void Boot_Screen(){
		loading.setVisible(true);
		power.setVisible(false);
		booting.play();
	}
	
	public void Desligar(){
		power.setVisible(false);
		gerenciador_window.setVisible(false);
		loading.setVisible(true);
		add.setVisible(false);
		start.setVisible(false);
		configurar_intervalo.setVisible(false);
		som.setVisible(false);
		notificacao.stop();
		confirmar_tempo.stop();
		erro.stop();
		novo_dispositivo_reconhecido.stop();
		notification_pane.setVisible(false);
		recurso1.setVisible(false);
		recurso2.setVisible(false);
		recurso3.setVisible(false);
		recurso4.setVisible(false);
		recurso5.setVisible(false);
		recurso6.setVisible(false);
		recurso7.setVisible(false);
		recurso8.setVisible(false);
		recurso9.setVisible(false);
		recurso10.setVisible(false);
		data.setVisible(false);
		hora.setVisible(false);
		gerenciador_main_window.setVisible(false);
		voltar_menu.setVisible(false);
		voltar_menu.setDisable(true);
		off.play();
		desligando.play();
		menu_bg.setImage(shut_down);
	}
	
	public void Ligar_Desligar(){
		if(!this.ligado){
			this.ligado = true;
			menu_bg.setLayoutX(0);
			menu_bg.setLayoutY(0);
			menu_bg.setFitWidth(750);
			menu_bg.setFitHeight(530);
			minimizar.setTranslateX(390);
			minimizar.setTranslateY(-160);
			fechar.setTranslateX(390);
			fechar.setTranslateY(-157);
			power.setTranslateX(-194);
			power.setTranslateY(172);
			startup.play();
			Boot_Screen();
		}
		else{
			this.ligado = false;
			Desligar();
		}
	}
	
	public void Entrou_Minimizar(){
		minimizar.setGraphic(minimizar_foco);
	}
	
	public void Saiu_Minimizar(){
		minimizar.setGraphic(minimizar_n_foco);
	}
	
	public void Entrou_Fechar(){
		fechar.setGraphic(fechar_foco);
	}
	
	public void Saiu_Fechar(){
		fechar.setGraphic(fechar_n_foco);
	}
	
	public void Carregar_Desktop(){
		power.setVisible(true);
		power.setGraphic(power_on);
		loading.setVisible(false);
		menu_bg.setImage(desktop);
		add.setVisible(true);
		data.setVisible(true);
		hora.setVisible(true);
		configuracao.setVisible(true);
		configuracao.setBackground(null);
		start.setVisible(true);
		start.setBackground(null);
		som.setVisible(true);
	}
	
	public void Entrou_Configuracao(){
		configuracao.setBorder(new Border(new BorderStroke(Color.DARKCYAN, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		power.setBorder(null);
		start.setBorder(null);
		add.setBorder(null);
	}
	
	public void Saiu_Configuracao(){
		configuracao.setBorder(null);
	}
	
	public void Add_Foco(){
		add.setBorder(new Border(new BorderStroke(Color.DARKCYAN, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		power.setBorder(null);
		start.setBorder(null);
		configuracao.setBorder(null);
	}
	
	public void Tirar_Add_Foco(){
		add.setBorder(null);
	}
	
	public void Start_Foco(){
		start.setBorder(new Border(new BorderStroke(Color.DARKCYAN, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		power.setBorder(null);
		add.setBorder(null);
		configuracao.setBorder(null);
	}
	
	public void Tirar_Start_Foco(){
		start.setBorder(null);
	}
	
	public void Power_Foco(){
		if(this.ligado){
			power.setBorder(new Border(new BorderStroke(Color.DARKCYAN, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			add.setBorder(null);
			start.setBorder(null);
			configuracao.setBorder(null);
		}
		else{
			power.setOpacity(1.0);
		}
	}
	
	public void Som_Foco(){
		som.setBorder(new Border(new BorderStroke(Color.DARKCYAN, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}
	
	public void Tirar_Som_Foco(){
		som.setBorder(null);
	}
	
	public void Tirar_Power_Foco(){
		power.setBorder(null);
		if(!this.ligado){
			power.setOpacity(0.7);
		}
	}
	
	public void Carregar_Boot(){
		booting = new Timeline(
				new KeyFrame(Duration.seconds(0), 
						new KeyValue(menu_bg.imageProperty(),boot1),
						new KeyValue(loading.imageProperty(),load_icon)),
				new KeyFrame(Duration.seconds(5.6), 
						new KeyValue(menu_bg.imageProperty(),boot2),
						new KeyValue(loading.imageProperty(),os_icon),
						new KeyValue(loading.translateXProperty(),-10)),
				new KeyFrame(Duration.seconds(8.5), 
						new KeyValue(menu_bg.imageProperty(),boot2),
						new KeyValue(loading.imageProperty(),os_icon),
						new KeyValue(loading.translateXProperty(),-10))
				
		);
		
		booting.setCycleCount(1);
		booting.setOnFinished(event -> Carregar_Desktop());
	}
	
	public void Carregar_Desligamento(){
		desligando = new Timeline(
				new KeyFrame(Duration.seconds(0), 
						new KeyValue(menu_bg.imageProperty(),shut_down),
						new KeyValue(loading.imageProperty(),load_icon)),
				new KeyFrame(Duration.seconds(3), 
						new KeyValue(menu_bg.imageProperty(),shut_down),
						new KeyValue(loading.imageProperty(),load_icon))
		);
		
		desligando.setCycleCount(1);
		desligando.setOnFinished(event -> Fechar_Janela());
	}
	
	public void Fechar_Gerenciador(){
		gerenciador_window.setVisible(false);
		gerenciador_window.setDisable(true);
		recurso_nome.clear();
		recurso_nome.setBorder(null);
		recurso_id.setText(String.valueOf(n_recursos + 1));
		recurso_id.setBorder(null);
		recurso_imagem.scrollTo(0);
		recurso_imagem.getSelectionModel().clearSelection();
		recurso_imagem.setBorder(null);
		add.setBackground(null);
		menu_bg.setImage(desktop);
	}
	
	public void Adicionar_Recurso(){
		if(n_recursos < 10){
			if(gerenciador_window.isVisible()){
				gerenciador_window.setVisible(false);
				add.setStyle("-fx-background-color: rgba(127, 156, 193, .6);");
				menu_bg.setImage(desktop);
			}
			else{
				add.setStyle("-fx-background-color: null;");
				gerenciador_window.setVisible(true);
				gerenciador_window.setDisable(false);
				menu_bg.setImage(desktop);
			}
		}
		else{
			Mostrar_Notificacao("Não é possível adicionar novos recursos!");
			erro.seek(Duration.seconds(0));
			erro.play();
			menu_bg.setImage(desktop_erro);
		}
	}
	
	public void Atualizar_Area_de_Trabalho(){
		switch (n_recursos) {
		case 1:
			recurso1.setImage(recursos.get(0).img);
			recurso1.setFitWidth(50);
			recurso1.setFitWidth(50);
			break;
		case 2:
			recurso2.setImage(recursos.get(1).img);
			recurso2.setFitWidth(50);
			recurso2.setFitWidth(50);
			break;
		case 3:
			recurso3.setImage(recursos.get(2).img);
			recurso3.setFitWidth(50);
			recurso3.setFitWidth(50);
			break;
		case 4:
			recurso4.setImage(recursos.get(3).img);
			recurso4.setFitWidth(50);
			recurso4.setFitWidth(50);
			break;
		case 5:
			recurso5.setImage(recursos.get(4).img);
			recurso5.setFitWidth(50);
			recurso5.setFitWidth(50);
			break;
		case 6:
			recurso6.setImage(recursos.get(5).img);
			recurso6.setFitWidth(50);
			recurso6.setFitWidth(50);
			break;
		case 7:
			recurso7.setImage(recursos.get(6).img);
			recurso7.setFitWidth(50);
			recurso7.setFitWidth(50);
			break;
		case 8:
			recurso8.setImage(recursos.get(7).img);
			recurso8.setFitWidth(50);
			recurso8.setFitWidth(50);
			break;
		case 9:
			recurso9.setImage(recursos.get(8).img);
			recurso9.setFitWidth(50);
			recurso9.setFitWidth(50);
			break;
		case 10:
			recurso10.setImage(recursos.get(9).img);
			recurso10.setFitWidth(50);
			recurso10.setFitWidth(50);
			break;
		default:
			break;
		}
	}
	
	public boolean Validar_Recurso_Unico(short id){
		short i;
		for(i = 0; i < n_recursos; i++){
			if(recursos.get(i).id == id){
				return false;
			}
		}
		return true;
	}
	
	public void Confirmar_Novo_Recurso(){
		if(!recurso_nome.getText().toString().isEmpty() && Expressao_Numerica(recurso_id.getText()) && !recurso_id.getText().toString().isEmpty() && recurso_imagem.getSelectionModel().getSelectedIndex() >= 0){
			if(Validar_Recurso_Unico(Short.valueOf(recurso_id.getText().toString()))){
				recursos.add(new Recurso(Short.valueOf(recurso_id.getText().toString()), recurso_nome.getText().toString(),lista_de_imagens[recurso_imagem.getSelectionModel().getSelectedIndex()]));
				Fechar_Gerenciador();
				menu_bg.setImage(desktop);
				Mostrar_Notificacao("Novo recurso reconhecido " + "'" + recursos.get(n_recursos).nome + "'");
				novo_dispositivo_reconhecido.seek(Duration.seconds(0));
				novo_dispositivo_reconhecido.play();
				n_recursos++;
				Atualizar_Area_de_Trabalho();
				recurso_id.setText(String.valueOf(n_recursos + 1));
			}
			else{
				recurso_id.setBorder(new Border(new BorderStroke(Color.RED, 
			            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
				Mostrar_Notificacao("O id digitado já existe!");
				erro.seek(Duration.seconds(0));
				erro.play();
				menu_bg.setImage(desktop_erro);
			}
		}
		else{
			if(recurso_id.getText().toString().isEmpty() || !Expressao_Numerica(recurso_id.getText())){
				recurso_id.setBorder(new Border(new BorderStroke(Color.RED, 
			            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			}
			if(recurso_nome.getText().toString().isEmpty()){
				recurso_nome.setBorder(new Border(new BorderStroke(Color.RED, 
			            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			}
			if(recurso_imagem.getSelectionModel().getSelectedIndex() < 0){
				recurso_imagem.setBorder(new Border(new BorderStroke(Color.RED, 
			            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			}
			Mostrar_Notificacao("Reveja os campos em vermelho!");
			erro.seek(Duration.seconds(0));
			erro.play();
			menu_bg.setImage(desktop_erro);
		}
	}
	
	public void Desmarcar_Campo_Id(){
		recurso_id.setBorder(null);
	}
	
	public void Desmarcar_Campo_Nome(){
		recurso_nome.setBorder(null);
	}
	
	public void Desmarcar_Campo_Imagem(){
		recurso_imagem.setBorder(null);
	}
	
	public void Carregar_Lista_Imagens_Recursos(){
        ObservableList<String> items =FXCollections.observableArrayList (
                "Música", "Leitora de Disco", "Documento", "HD", "Imagem", "Impressora", "Microfone", "Speaker", "USB", "Webcam");
        recurso_imagem.setItems(items);
        
        recurso_imagem.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                imageView.setFitHeight(50);
            	imageView.setFitWidth(50);
            	imageView.setPreserveRatio(true);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if(name.equals("Música")){
                        imageView.setImage(lista_de_imagens[0]);
                	}
                    else if(name.equals("Leitora de Disco")){
                        imageView.setImage(lista_de_imagens[1]);
                    }
                    else if(name.equals("Documento")){
                        imageView.setImage(lista_de_imagens[2]);
                    }
                    else if(name.equals("HD")){
                        imageView.setImage(lista_de_imagens[3]);
                    }
                    else if(name.equals("Imagem")){
                        imageView.setImage(lista_de_imagens[4]);
                    }
                    else if(name.equals("Impressora")){
                        imageView.setImage(lista_de_imagens[5]);
                    }
                    else if(name.equals("Microfone")){
                        imageView.setImage(lista_de_imagens[6]);
                    }
                    else if(name.equals("Speaker")){
                        imageView.setImage(lista_de_imagens[7]);
                    }
                    else if(name.equals("USB")){
                        imageView.setImage(lista_de_imagens[8]);
                    }
                    else if(name.equals("Webcam")){
                        imageView.setImage(lista_de_imagens[9]);
                    }
                    setGraphic(imageView);
                    setPrefWidth(50);
                    setPrefHeight(50);
                }
            }
        });
        
        recurso_imagem.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                recurso_imagem.setBorder(null);
                if(gerenciador_window.isVisible())
                	recurso_nome.setText(recurso_imagem.getItems().get(recurso_imagem.getSelectionModel().getSelectedIndex()));
            }
        });
	}
	
	public void Carregar_Lista_Imagens_Processos(){
        ObservableList<String> items =FXCollections.observableArrayList (
        		"Bioshock","Chrome","Code Blocks","Cuphead","Dark Souls","Eclipse",
		  	      "Microsoft Edge","Gimp","Java VM","Media Player","Mozilla Firefox","Photoshop","Power Point",
		  	      "Python","Safari","Steam","Stremio","uTorrent","VLC","Writer");
        processo_imagem.setItems(items);
      
        processo_imagem.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                imageView.setFitHeight(50);
            	imageView.setFitWidth(50);
            	imageView.setPreserveRatio(true);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if(name.equals("Bioshock")){
                        imageView.setImage(lista_de_imagens_processos[0]);
                	}
                    else if(name.equals("Chrome")){
                        imageView.setImage(lista_de_imagens_processos[1]);
                    }
                    else if(name.equals("Code Blocks")){
                        imageView.setImage(lista_de_imagens_processos[2]);
                    }
                    else if(name.equals("Cuphead")){
                        imageView.setImage(lista_de_imagens_processos[3]);
                    }
                    else if(name.equals("Dark Souls")){
                        imageView.setImage(lista_de_imagens_processos[4]);
                    }
                    else if(name.equals("Eclipse")){
                        imageView.setImage(lista_de_imagens_processos[5]);
                    }
                    else if(name.equals("Microsoft Edge")){
                        imageView.setImage(lista_de_imagens_processos[6]);
                    }
                    else if(name.equals("Gimp")){
                        imageView.setImage(lista_de_imagens_processos[7]);
                    }
                    else if(name.equals("Java VM")){
                        imageView.setImage(lista_de_imagens_processos[8]);
                    }
                    else if(name.equals("Media Player")){
                        imageView.setImage(lista_de_imagens_processos[9]);
                    }
                    else if(name.equals("Mozilla Firefox")){
                        imageView.setImage(lista_de_imagens_processos[10]);
                    }
                    else if(name.equals("Photoshop")){
                        imageView.setImage(lista_de_imagens_processos[11]);
                    }
                    else if(name.equals("Power Point")){
                        imageView.setImage(lista_de_imagens_processos[12]);
                    }
                    else if(name.equals("Python")){
                        imageView.setImage(lista_de_imagens_processos[13]);
                    }
                    else if(name.equals("Safari")){
                        imageView.setImage(lista_de_imagens_processos[14]);
                    }
                    else if(name.equals("Steam")){
                        imageView.setImage(lista_de_imagens_processos[15]);
                    }
                    else if(name.equals("Stremio")){
                        imageView.setImage(lista_de_imagens_processos[16]);
                    }
                    else if(name.equals("uTorrent")){
                        imageView.setImage(lista_de_imagens_processos[17]);
                    }
                    else if(name.equals("VLC")){
                        imageView.setImage(lista_de_imagens_processos[18]);
                    }
                    else if(name.equals("Writer")){
                        imageView.setImage(lista_de_imagens_processos[19]);
                    }
                    setGraphic(imageView);
                    setPrefWidth(50);
                    setPrefHeight(50);
                }
            }
        });
        
        processo_imagem.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                processo_imagem.setBorder(null);
                if(novo_processo_window.isVisible())
                	processo_nome.setText(processo_imagem.getItems().get(processo_imagem.getSelectionModel().getSelectedIndex()));
            }
        });
	}
	
	public boolean Expressao_Numerica(String texto){
		for(char c : texto.toCharArray()){
			if(c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
	
	public void Caregar_Notificacao(){
		notificacao = new Timeline(
						new KeyFrame(Duration.seconds(0), 
								new KeyValue(notification_pane.visibleProperty(),true),
								new KeyValue(notification_pane.opacityProperty(),0.8)),
						new KeyFrame(Duration.seconds(4), 
								new KeyValue(notification_pane.visibleProperty(),true),
								new KeyValue(notification_pane.opacityProperty(),0.0)),
						new KeyFrame(Duration.seconds(5), 
								new KeyValue(notification_pane.visibleProperty(),false),
								new KeyValue(notification_pane.opacityProperty(),0.0))
					  );
		notificacao.setCycleCount(1);
	}
	
	public void Mostrar_Notificacao(String texto){
		if(notificacao.getStatus().equals(Animation.Status.RUNNING)){
			notificacao.stop();
		}
		texto_notificacao.setText(texto);
		notificacao.play();
	}
	
	public void Fechar_Configuracao_Intervalo(){
		configurar_intervalo.setVisible(false);
		intervalo_deltat.setBorder(null);
		intervalo_deltat.setText(String.valueOf(1));
		menu_bg.setImage(desktop);
	}
	
	public void Configurar_Intervalo(){
		if(configurar_intervalo.isVisible()){
			configurar_intervalo.setVisible(false);
		}
		else{
			configurar_intervalo.setVisible(true);
			menu_bg.setImage(desktop);
		}
	}
	
	public void Confirmar_Intervalo(){
		if(!intervalo_deltat.getText().toString().isEmpty() && Expressao_Numerica(intervalo_deltat.getText())){
			so.set_Delta_t(Integer.valueOf(intervalo_deltat.getText().toString()));
			Mostrar_Notificacao("Tempo para detecção ajustado para " + so.tempo_checagem + "s.");
			confirmar_tempo.seek(Duration.seconds(0));
			confirmar_tempo.play();
			intervalo_deltat.setBorder(null);
			configurar_intervalo.setVisible(false);
			menu_bg.setImage(desktop);
		}
		else{
			intervalo_deltat.setBorder(new Border(new BorderStroke(Color.RED, 
		            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			Mostrar_Notificacao("Digite um valor de tempo válido e inteiro!");
			erro.seek(Duration.seconds(0));
			erro.play();
			menu_bg.setImage(desktop_erro);
		}
	}
	
	public void Atualizar_Data_Hora(String data, String hora){
		Platform.runLater(() -> {
			this.data.setText(data);
			this.hora.setText(hora);
		});
	}
	
	public void Iniciar_Analise(){
		if(n_recursos == 0){
			Mostrar_Notificacao("Adicione recursos primeiro!");
			erro.seek(Duration.seconds(0));
			erro.play();
			menu_bg.setImage(desktop_erro);
			Add_Foco();
		}
		else if(so.tempo_checagem == 0){
			Mostrar_Notificacao("Configure o tempo de detecção primeiro!");
			erro.seek(Duration.seconds(0));
			erro.play();
			menu_bg.setImage(desktop_erro);
			Entrou_Configuracao();
		}
		else{
			Fechar_Gerenciador();
			Fechar_Configuracao_Intervalo();
			n_processos = 0;
			menu_bg.setImage(main_program);
			add.setDisable(true);
			start.setDisable(true);
			configuracao.setDisable(true);
			gerenciador_main_window.setVisible(true);
			gerenciador_main_window.setDisable(false);
			recurso1.setVisible(false);
			recurso2.setVisible(false);
			recurso3.setVisible(false);
			recurso4.setVisible(false);
			recurso5.setVisible(false);
			recurso6.setVisible(false);
			recurso7.setVisible(false);
			recurso8.setVisible(false);
			recurso9.setVisible(false);
			recurso10.setVisible(false);
			detalhes_scroll_pane.setContent(detalhes_group);
			detalhes_scroll_pane.setPannable(true);
			detalhes_scroll_pane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
			historico.setStyle("-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; ");
			notificacao.jumpTo(notificacao.getTotalDuration());
			n_campos_vazios = 0;
			tem_campos_vazios = false;
			processo_id.setText("1");
			Mostrar_Tutorial();
		}
	}
	
	public static void adicionarTexto(TextArea ta, String texto) {
        double scrollTop = ta.getScrollTop();
        ta.setText(ta.getText() + texto);
        ta.setScrollTop(scrollTop);
    }
	
	public void Atualizar_Log(LocalTime instante, String texto){
		Platform.runLater(() -> {
			adicionarTexto(historico,"[" + String.format("%02d", instante.getHour()) + ":" + String.format("%02d", instante.getMinute()) + ":" + String.format("%02d", instante.getSecond()) + "] --> " + texto + "\n");
		});
	}
	
	public void Novo_Processo(){
		novo_processo_window.setVisible(true);
		novo_processo_window.setDisable(false);
		novo_processo_bt.setVisible(false);
		novo_processo_bt.setDisable(true);
		finalizar_processo_bt.setVisible(false);
		finalizar_processo_bt.setDisable(true);
		if(tem_campos_vazios) {
			int index = 0;
			while(processos.get(index).id != -1)
				index++;
			processo_id.setText(String.valueOf(index + 1));
		}
	}
	
	public void Fechar_Gerenciador_Processos(){
		novo_processo_window.setVisible(false);
		novo_processo_window.setDisable(true);
		novo_processo_bt.setVisible(true);
		novo_processo_bt.setDisable(false);
		Desmarcar_Processo_ts();
		Desmarcar_Processo_id();
		Desmarcar_Processo_nome();
		Desmarcar_Processo_tu();
		if(n_processos > 0){
			finalizar_processo_bt.setVisible(true);
			finalizar_processo_bt.setDisable(false);
			processo_imagem.getSelectionModel().clearSelection();
		}
	}
	
	public boolean Validar_Processo_Unico(int id){
		short i;
		for(i = 0; i < n_processos; i++){
			if(processos.get(i).id == id){
				return false;
			}
		}
		return true;
	}
	
	public void Desmarcar_Processo_id(){
		processo_id.setBorder(null);
	}
	
	public void Desmarcar_Processo_tu(){
		processo_tu.setBorder(null);
	}
	
	public void Desmarcar_Processo_ts(){
		processo_ts.setBorder(null);
	}
	
	public void Desmarcar_Processo_nome(){
		processo_nome.setBorder(null);
	}
	
	public void Confirmar_Novo_Processo(){
		if(!processo_nome.getText().toString().isEmpty() && Expressao_Numerica(processo_tu.getText()) && !processo_tu.getText().toString().isEmpty() && Expressao_Numerica(processo_ts.getText()) && !processo_ts.getText().toString().isEmpty() && Expressao_Numerica(processo_id.getText()) && !processo_id.getText().toString().isEmpty() && processo_imagem.getSelectionModel().getSelectedIndex() >= 0 && Integer.valueOf(processo_ts.getText().toString()) > 0 && Integer.valueOf(processo_tu.getText().toString()) > 0){
			if(Validar_Processo_Unico(Short.valueOf(processo_id.getText().toString()))){
				if(!tem_campos_vazios){
					processos.add(new Processo(Integer.valueOf(processo_id.getText().toString()), processo_nome.getText().toString(),lista_de_imagens_processos[processo_imagem.getSelectionModel().getSelectedIndex()],Integer.valueOf(processo_ts.getText().toString()), Integer.valueOf(processo_tu.getText().toString()),recursos,grafo));
					processos.get(n_processos).set_Controller(controlador);
					Thread p = new Thread(processos.get(n_processos));
					p.start();
					Setar_Imagens_Grafo(n_processos + 1);
					Mostrar_Notificacao("Novo processo iniciado" + "'" + processos.get(n_processos).nome + "'");
					processo_id.setText(String.valueOf(n_processos + 2));
				}
				else{
					int index = 0;
					while(processos.get(index).id != -1)
						index++;
					grafo.Remover(processos.get(index).vertice);
					processos.set(index,new Processo(Integer.valueOf(processo_id.getText().toString()), processo_nome.getText().toString(),lista_de_imagens_processos[processo_imagem.getSelectionModel().getSelectedIndex()],Integer.valueOf(processo_ts.getText().toString()), Integer.valueOf(processo_tu.getText().toString()),recursos,grafo));
					processos.get(index).set_Controller(controlador);
					Thread p = new Thread(processos.get(index));
					p.start();
					Setar_Imagens_Grafo(index + 1);
					Mostrar_Notificacao("Novo processo iniciado" + "'" + processos.get(index).nome + "'");
					try {
						mutex.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					n_campos_vazios--;
					if(n_campos_vazios <= 0 || n_processos == processos.size()) {
						tem_campos_vazios = false;
						processo_id.setText(String.valueOf(n_processos + 2));
					}
					else {
						while(index < processos.size() && processos.get(index).id != -1)
							index++;
						processo_id.setText(String.valueOf(index + 1));
					}
					mutex.release();
				}
				Fechar_Gerenciador_Processos();
				LocalTime instante = LocalTime.now();
				Atualizar_Log(instante, "Processo " + processos.get(n_processos).nome + "(Id: " + processos.get(n_processos).id + ") iniciado.");
				grafo.add(processos.get(n_processos).vertice);
				n_processos++;
				Atualizar_Detalhes();
				if(n_processos == 1){
					finalizar_processo_bt.setVisible(true);
					finalizar_processo_bt.setDisable(false);
				}
				else if(n_processos == 10){
					novo_processo_bt.setVisible(false);
					novo_processo_bt.setDisable(true);
				}
				processo_nome.clear();
				processo_ts.clear();
				processo_tu.clear();
				processo_imagem.getSelectionModel().select(0);
			}
			else{
				processo_id.setBorder(new Border(new BorderStroke(Color.RED, 
			            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
				Mostrar_Notificacao("O id digitado já existe!");
			}
		}
		else{
			if(processo_id.getText().toString().isEmpty() || !Expressao_Numerica(processo_id.getText())){
				processo_id.setBorder(new Border(new BorderStroke(Color.RED, 
			            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			}
			if(processo_ts.getText().toString().isEmpty() || !Expressao_Numerica(processo_ts.getText())){
				processo_ts.setBorder(new Border(new BorderStroke(Color.RED, 
			            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			}
			if(processo_tu.getText().toString().isEmpty() || !Expressao_Numerica(processo_tu.getText())){
				processo_tu.setBorder(new Border(new BorderStroke(Color.RED, 
			            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			}
			if(processo_nome.getText().toString().isEmpty()){
				processo_nome.setBorder(new Border(new BorderStroke(Color.RED, 
			            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			}
			if(processo_imagem.getSelectionModel().getSelectedIndex() < 0){
				processo_imagem.setBorder(new Border(new BorderStroke(Color.RED, 
			            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			}
			Mostrar_Notificacao("Reveja os campos em vermelho!");
		}
	}
	
	public void Finalizar_Processo(){
		if(!modo_remocao){
			modo_remocao = true;
			novo_processo_bt.setVisible(false);
			novo_processo_bt.setDisable(true);
			finalizar_processo_bt.setText("Cancelar");
			finalizar_processo_bt.getScene().setCursor(remover);
		}
		else{
			modo_remocao = false;
			novo_processo_bt.setVisible(true);
			novo_processo_bt.setDisable(false);
			finalizar_processo_bt.setText("Finalizar Processo");
			finalizar_processo_bt.getScene().setCursor(Cursor.DEFAULT);
		}
	}
	
	public void Abrir_Tab_Detalhes(){
		if(modo_remocao){
			modo_remocao = false;
			tab_detalhes.getTabPane().getScene().setCursor(Cursor.DEFAULT);
			novo_processo_bt.setVisible(true);
			novo_processo_bt.setDisable(false);
			finalizar_processo_bt.setText("Finalizar Processo");
		}
	}
	
	public void Abrir_Tab_Logs(){
		if(modo_remocao){
			modo_remocao = false;
			tab_logs.getTabPane().getScene().setCursor(Cursor.DEFAULT);
			novo_processo_bt.setVisible(true);
			novo_processo_bt.setDisable(false);
			finalizar_processo_bt.setText("Finalizar Processo");
		}
	}
	
	public void Encerrar_Processo(int id){
		int index = 0;
		//if(id != -1) {
			while(processos.get(index).id != id)
				index++;
			switch (index) {
			case 0:
				Matar_Processo1();
				break;
			case 1:
				Matar_Processo2();
				break;
			case 2:
				Matar_Processo3();
				break;
			case 3:
				Matar_Processo4();
				break;
			case 4:
				Matar_Processo5();
				break;
			case 5:
				Matar_Processo6();
				break;
			case 6:
				Matar_Processo7();
				break;
			case 7:
				Matar_Processo8();
				break;
			case 8:
				Matar_Processo9();
				break;
			case 9:
				Matar_Processo10();
				break;
			default:
				break;
			}
		//}
	}
	
	public void Finalizar_Processo1(){
		if(modo_remocao && processos.get(0).id != -1)
			processos.get(0).Parar_Rodar(false);
	}
	
	public void Matar_Processo1(){
		Platform.runLater(() -> {
			Atualizar_Log(LocalTime.now(),"Processo " + processos.get(0).nome + "(Id: " + processos.get(0).id + ") finalizado com sucesso!");
			processos.get(0).Finalizar();
			grafo_processo1.setImage(null);
			processo_id.setText(String.valueOf(processos.get(0).id));
			processos.get(0).id = -1;
			try {
				mutex.acquire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			n_processos--;
			mutex.release();
			if(n_processos == 0){
				modo_remocao = false;
				finalizar_processo_bt.setVisible(false);
				finalizar_processo_bt.setDisable(true);
				if(!novo_processo_bt.isVisible()){
					novo_processo_bt.setVisible(true);
					novo_processo_bt.setDisable(false);
					finalizar_processo_bt.setText("Finalizar Processo");
				}
				finalizar_processo_bt.getScene().setCursor(Cursor.DEFAULT);
			}
			tem_campos_vazios = true;
			n_campos_vazios++;
			processo1_pane.setVisible(false);
			grafo_processo1.setEffect(null);
			processo1_recurso1_aresta.setVisible(false);
			processo1_recurso2_aresta.setVisible(false);
			processo1_recurso3_aresta.setVisible(false);
			processo1_recurso4_aresta.setVisible(false);
			processo1_recurso5_aresta.setVisible(false);
			processo1_recurso6_aresta.setVisible(false);
			processo1_recurso7_aresta.setVisible(false);
			processo1_recurso8_aresta.setVisible(false);
			processo1_recurso9_aresta.setVisible(false);
			processo1_recurso10_aresta.setVisible(false);
			remocao.seek(Duration.seconds(0));
			remocao.play();
			Atualizar_Detalhes();
		});
	}
	
	public void Finalizar_Processo2(){
		if(modo_remocao && processos.get(1).id != -1)
			processos.get(1).Parar_Rodar(false);
	}
	
	public void Matar_Processo2(){
		Platform.runLater(() -> {
			Atualizar_Log(LocalTime.now(),"Processo " + processos.get(1).nome + "(Id: " + processos.get(1).id + ") finalizado com sucesso!");
			processos.get(1).Finalizar();
			grafo_processo2.setImage(null);
			processo_id.setText(String.valueOf(processos.get(1).id));
			processos.get(1).id = -1;
			try {
				mutex.acquire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			n_processos--;
			mutex.release();
			if(n_processos == 0){
				modo_remocao = false;
				finalizar_processo_bt.setVisible(false);
				finalizar_processo_bt.setDisable(true);
				if(!novo_processo_bt.isVisible()){
					novo_processo_bt.setVisible(true);
					novo_processo_bt.setDisable(false);
					finalizar_processo_bt.setText("Finalizar Processo");
				}
				finalizar_processo_bt.getScene().setCursor(Cursor.DEFAULT);
			}
			tem_campos_vazios = true;
			n_campos_vazios++;
			processo2_pane.setVisible(false);
			grafo_processo2.setEffect(null);
			processo2_recurso1_aresta.setVisible(false);
			processo2_recurso2_aresta.setVisible(false);
			processo2_recurso3_aresta.setVisible(false);
			processo2_recurso4_aresta.setVisible(false);
			processo2_recurso5_aresta.setVisible(false);
			processo2_recurso6_aresta.setVisible(false);
			processo2_recurso7_aresta.setVisible(false);
			processo2_recurso8_aresta.setVisible(false);
			processo2_recurso9_aresta.setVisible(false);
			processo2_recurso10_aresta.setVisible(false);
			remocao.seek(Duration.seconds(0));
			remocao.play();
			Atualizar_Detalhes();
		});
	}
	
	public void Finalizar_Processo3(){
		if(modo_remocao && processos.get(2).id != -1)
			processos.get(2).Parar_Rodar(false);
	}
	
	public void Matar_Processo3(){
		Platform.runLater(() -> {
			Atualizar_Log(LocalTime.now(),"Processo " + processos.get(2).nome + "(Id: " + processos.get(2).id + ") finalizado com sucesso!");
			processos.get(2).Finalizar();
			grafo_processo3.setImage(null);
			processo_id.setText(String.valueOf(processos.get(2).id));
			processos.get(2).id = -1;
			try {
				mutex.acquire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			n_processos--;
			mutex.release();
			if(n_processos == 0){
				modo_remocao = false;
				finalizar_processo_bt.setVisible(false);
				finalizar_processo_bt.setDisable(true);
				if(!novo_processo_bt.isVisible()){
					novo_processo_bt.setVisible(true);
					novo_processo_bt.setDisable(false);
					finalizar_processo_bt.setText("Finalizar Processo");
				}
				finalizar_processo_bt.getScene().setCursor(Cursor.DEFAULT);
			}
			tem_campos_vazios = true;
			n_campos_vazios++;
			processo3_pane.setVisible(false);
			grafo_processo3.setEffect(null);
			processo3_recurso1_aresta.setVisible(false);
			processo3_recurso2_aresta.setVisible(false);
			processo3_recurso3_aresta.setVisible(false);
			processo3_recurso4_aresta.setVisible(false);
			processo3_recurso5_aresta.setVisible(false);
			processo3_recurso6_aresta.setVisible(false);
			processo3_recurso7_aresta.setVisible(false);
			processo3_recurso8_aresta.setVisible(false);
			processo3_recurso9_aresta.setVisible(false);
			processo3_recurso10_aresta.setVisible(false);
			remocao.seek(Duration.seconds(0));
			remocao.play();
			Atualizar_Detalhes();
		});
	}
	
	public void Finalizar_Processo4(){
		if(modo_remocao && processos.get(3).id != -1)
			processos.get(3).Parar_Rodar(false);
	}
	
	public void Matar_Processo4(){
		Platform.runLater(() -> {
			Atualizar_Log(LocalTime.now(),"Processo " + processos.get(3).nome + "(Id: " + processos.get(3).id + ") finalizado com sucesso!");
			processos.get(3).Finalizar();
			grafo_processo4.setImage(null);
			processo_id.setText(String.valueOf(processos.get(3).id));
			processos.get(3).id = -1;
			try {
				mutex.acquire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			n_processos--;
			mutex.release();
			if(n_processos == 0){
				modo_remocao = false;
				finalizar_processo_bt.setVisible(false);
				finalizar_processo_bt.setDisable(true);
				if(!novo_processo_bt.isVisible()){
					novo_processo_bt.setVisible(true);
					novo_processo_bt.setDisable(false);
					finalizar_processo_bt.setText("Finalizar Processo");
				}
				finalizar_processo_bt.getScene().setCursor(Cursor.DEFAULT);
			}
			tem_campos_vazios = true;
			n_campos_vazios++;
			processo4_pane.setVisible(false);
			grafo_processo4.setEffect(null);
			processo4_recurso1_aresta.setVisible(false);
			processo4_recurso2_aresta.setVisible(false);
			processo4_recurso3_aresta.setVisible(false);
			processo4_recurso4_aresta.setVisible(false);
			processo4_recurso5_aresta.setVisible(false);
			processo4_recurso6_aresta.setVisible(false);
			processo4_recurso7_aresta.setVisible(false);
			processo4_recurso8_aresta.setVisible(false);
			processo4_recurso9_aresta.setVisible(false);
			processo4_recurso10_aresta.setVisible(false);
			remocao.seek(Duration.seconds(0));
			remocao.play();
			Atualizar_Detalhes();
		});
	}
	
	public void Finalizar_Processo5(){
		if(modo_remocao && processos.get(4).id != -1)
			processos.get(4).Parar_Rodar(false);
	}
	
	public void Matar_Processo5(){
		Platform.runLater(() -> {
			Atualizar_Log(LocalTime.now(),"Processo " + processos.get(4).nome + "(Id: " + processos.get(4).id + ") finalizado com sucesso!");
			processos.get(4).Finalizar();
			grafo_processo5.setImage(null);
			processo_id.setText(String.valueOf(processos.get(4).id));
			processos.get(4).id = -1;
			try {
				mutex.acquire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			n_processos--;
			mutex.release();
			if(n_processos == 0){
				modo_remocao = false;
				finalizar_processo_bt.setVisible(false);
				finalizar_processo_bt.setDisable(true);
				if(!novo_processo_bt.isVisible()){
					novo_processo_bt.setVisible(true);
					novo_processo_bt.setDisable(false);
					finalizar_processo_bt.setText("Finalizar Processo");
				}
				finalizar_processo_bt.getScene().setCursor(Cursor.DEFAULT);
			}
			tem_campos_vazios = true;
			n_campos_vazios++;
			processo5_pane.setVisible(false);
			grafo_processo5.setEffect(null);
			processo5_recurso1_aresta.setVisible(false);
			processo5_recurso2_aresta.setVisible(false);
			processo5_recurso3_aresta.setVisible(false);
			processo5_recurso4_aresta.setVisible(false);
			processo5_recurso5_aresta.setVisible(false);
			processo5_recurso6_aresta.setVisible(false);
			processo5_recurso7_aresta.setVisible(false);
			processo5_recurso8_aresta.setVisible(false);
			processo5_recurso9_aresta.setVisible(false);
			processo5_recurso10_aresta.setVisible(false);
			remocao.seek(Duration.seconds(0));
			remocao.play();
			Atualizar_Detalhes();
		});
	}
	
	public void Finalizar_Processo6(){
		if(modo_remocao && processos.get(5).id != -1)
			processos.get(5).Parar_Rodar(false);
	}
	
	public void Matar_Processo6(){
		Platform.runLater(() -> {
			Atualizar_Log(LocalTime.now(),"Processo " + processos.get(5).nome + "(Id: " + processos.get(5).id + ") finalizado com sucesso!");
			processos.get(5).Finalizar();
			grafo_processo6.setImage(null);
			processo_id.setText(String.valueOf(processos.get(5).id));
			processos.get(5).id = -1;
			try {
				mutex.acquire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			n_processos--;
			mutex.release();
			if(n_processos == 0){
				modo_remocao = false;
				finalizar_processo_bt.setVisible(false);
				finalizar_processo_bt.setDisable(true);
				if(!novo_processo_bt.isVisible()){
					novo_processo_bt.setVisible(true);
					novo_processo_bt.setDisable(false);
					finalizar_processo_bt.setText("Finalizar Processo");
				}
				finalizar_processo_bt.getScene().setCursor(Cursor.DEFAULT);
			}
			tem_campos_vazios = true;
			n_campos_vazios++;
			processo6_pane.setVisible(false);
			grafo_processo6.setEffect(null);
			processo6_recurso1_aresta.setVisible(false);
			processo6_recurso2_aresta.setVisible(false);
			processo6_recurso3_aresta.setVisible(false);
			processo6_recurso4_aresta.setVisible(false);
			processo6_recurso5_aresta.setVisible(false);
			processo6_recurso6_aresta.setVisible(false);
			processo6_recurso7_aresta.setVisible(false);
			processo6_recurso8_aresta.setVisible(false);
			processo6_recurso9_aresta.setVisible(false);
			processo6_recurso10_aresta.setVisible(false);
			remocao.seek(Duration.seconds(0));
			remocao.play();
			Atualizar_Detalhes();
		});
	}
	
	public void Finalizar_Processo7(){
		if(modo_remocao && processos.get(6).id != -1)
			processos.get(6).Parar_Rodar(false);
	}
	
	public void Matar_Processo7(){
		Platform.runLater(() -> {
			Atualizar_Log(LocalTime.now(),"Processo " + processos.get(6).nome + "(Id: " + processos.get(6).id + ") finalizado com sucesso!");
			processos.get(6).Finalizar();
			grafo_processo7.setImage(null);
			processo_id.setText(String.valueOf(processos.get(6).id));
			processos.get(6).id = -1;
			try {
				mutex.acquire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			n_processos--;
			mutex.release();
			if(n_processos == 0){
				modo_remocao = false;
				finalizar_processo_bt.setVisible(false);
				finalizar_processo_bt.setDisable(true);
				if(!novo_processo_bt.isVisible()){
					novo_processo_bt.setVisible(true);
					novo_processo_bt.setDisable(false);
					finalizar_processo_bt.setText("Finalizar Processo");
				}
				finalizar_processo_bt.getScene().setCursor(Cursor.DEFAULT);
			}
			tem_campos_vazios = true;
			n_campos_vazios++;
			processo7_pane.setVisible(false);
			grafo_processo7.setEffect(null);
			processo7_recurso1_aresta.setVisible(false);
			processo7_recurso2_aresta.setVisible(false);
			processo7_recurso3_aresta.setVisible(false);
			processo7_recurso4_aresta.setVisible(false);
			processo7_recurso5_aresta.setVisible(false);
			processo7_recurso6_aresta.setVisible(false);
			processo7_recurso7_aresta.setVisible(false);
			processo7_recurso8_aresta.setVisible(false);
			processo7_recurso9_aresta.setVisible(false);
			processo7_recurso10_aresta.setVisible(false);
			remocao.seek(Duration.seconds(0));
			remocao.play();
			Atualizar_Detalhes();
		});
	}
	
	public void Finalizar_Processo8(){
		if(modo_remocao && processos.get(7).id != -1)
			processos.get(7).Parar_Rodar(false);
	}
	
	public void Matar_Processo8(){
		Platform.runLater(() -> {
			Atualizar_Log(LocalTime.now(),"Processo " + processos.get(7).nome + "(Id: " + processos.get(7).id + ") finalizado com sucesso!");
			processos.get(7).Finalizar();
			grafo_processo8.setImage(null);
			processo_id.setText(String.valueOf(processos.get(7).id));
			processos.get(7).id = -1;
			try {
				mutex.acquire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			n_processos--;
			mutex.release();
			if(n_processos == 0){
				modo_remocao = false;
				finalizar_processo_bt.setVisible(false);
				finalizar_processo_bt.setDisable(true);
				if(!novo_processo_bt.isVisible()){
					novo_processo_bt.setVisible(true);
					novo_processo_bt.setDisable(false);
					finalizar_processo_bt.setText("Finalizar Processo");
				}
				finalizar_processo_bt.getScene().setCursor(Cursor.DEFAULT);
			}
			tem_campos_vazios = true;
			n_campos_vazios++;
			processo8_pane.setVisible(false);
			grafo_processo8.setEffect(null);
			processo8_recurso1_aresta.setVisible(false);
			processo8_recurso2_aresta.setVisible(false);
			processo8_recurso3_aresta.setVisible(false);
			processo8_recurso4_aresta.setVisible(false);
			processo8_recurso5_aresta.setVisible(false);
			processo8_recurso6_aresta.setVisible(false);
			processo8_recurso7_aresta.setVisible(false);
			processo8_recurso8_aresta.setVisible(false);
			processo8_recurso9_aresta.setVisible(false);
			processo8_recurso10_aresta.setVisible(false);
			remocao.seek(Duration.seconds(0));
			remocao.play();
			Atualizar_Detalhes();
		});
	}
	
	public void Finalizar_Processo9(){
		if(modo_remocao && processos.get(8).id != -1)
			processos.get(8).Parar_Rodar(false);
	}
	
	public void Matar_Processo9(){
		Platform.runLater(() -> {
			Atualizar_Log(LocalTime.now(),"Processo " + processos.get(8).nome + "(Id: " + processos.get(8).id + ") finalizado com sucesso!");
			processos.get(8).Finalizar();
			grafo_processo9.setImage(null);
			processo_id.setText(String.valueOf(processos.get(8).id));
			processos.get(8).id = -1;
			try {
				mutex.acquire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			n_processos--;
			mutex.release();
			if(n_processos == 0){
				modo_remocao = false;
				finalizar_processo_bt.setVisible(false);
				finalizar_processo_bt.setDisable(true);
				if(!novo_processo_bt.isVisible()){
					novo_processo_bt.setVisible(true);
					novo_processo_bt.setDisable(false);
					finalizar_processo_bt.setText("Finalizar Processo");
				}
				finalizar_processo_bt.getScene().setCursor(Cursor.DEFAULT);
			}
			tem_campos_vazios = true;
			n_campos_vazios++;
			processo9_pane.setVisible(false);
			grafo_processo9.setEffect(null);
			processo9_recurso1_aresta.setVisible(false);
			processo9_recurso2_aresta.setVisible(false);
			processo9_recurso3_aresta.setVisible(false);
			processo9_recurso4_aresta.setVisible(false);
			processo9_recurso5_aresta.setVisible(false);
			processo9_recurso6_aresta.setVisible(false);
			processo9_recurso7_aresta.setVisible(false);
			processo9_recurso8_aresta.setVisible(false);
			processo9_recurso9_aresta.setVisible(false);
			processo9_recurso10_aresta.setVisible(false);
			remocao.seek(Duration.seconds(0));
			remocao.play();
			Atualizar_Detalhes();
		});
	}
	
	public void Finalizar_Processo10(){
		if(modo_remocao && processos.get(9).id != -1)
			processos.get(9).Parar_Rodar(false);
	}
	
	public void Matar_Processo10(){
		Platform.runLater(() -> {
			Atualizar_Log(LocalTime.now(),"Processo " + processos.get(9).nome + "(Id: " + processos.get(9).id + ") finalizado com sucesso!");
			processos.get(9).Finalizar();
			grafo_processo10.setImage(null);
			processo_id.setText(String.valueOf(processos.get(9).id));
			processos.get(9).id = -1;
			try {
				mutex.acquire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			n_processos--;
			mutex.release();
			if(n_processos == 0){
				modo_remocao = false;
				finalizar_processo_bt.setVisible(false);
				finalizar_processo_bt.setDisable(true);
				if(!novo_processo_bt.isVisible()){
					novo_processo_bt.setVisible(true);
					novo_processo_bt.setDisable(false);
					finalizar_processo_bt.setText("Finalizar Processo");
				}
				finalizar_processo_bt.getScene().setCursor(Cursor.DEFAULT);
			}
			tem_campos_vazios = true;
			n_campos_vazios++;
			processo10_pane.setVisible(false);
			grafo_processo10.setEffect(null);
			processo10_recurso1_aresta.setVisible(false);
			processo10_recurso2_aresta.setVisible(false);
			processo10_recurso3_aresta.setVisible(false);
			processo10_recurso4_aresta.setVisible(false);
			processo10_recurso5_aresta.setVisible(false);
			processo10_recurso6_aresta.setVisible(false);
			processo10_recurso7_aresta.setVisible(false);
			processo10_recurso8_aresta.setVisible(false);
			processo10_recurso9_aresta.setVisible(false);
			processo10_recurso10_aresta.setVisible(false);
			remocao.seek(Duration.seconds(0));
			remocao.play();
			Atualizar_Detalhes();
		});
	}
	
	public void Foco_Processo1(){
		if(modo_remocao)
			grafo_processo1.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Processo1(){
		grafo_processo1.setOpacity(1.0);
	}
	
	public void Foco_Processo2(){
		if(modo_remocao)
			grafo_processo2.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Processo2(){
		grafo_processo2.setOpacity(1.0);
	}
	
	public void Foco_Processo3(){
		if(modo_remocao)
			grafo_processo3.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Processo3(){
		grafo_processo3.setOpacity(1.0);
	}
	
	public void Foco_Processo4(){
		if(modo_remocao)
			grafo_processo4.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Processo4(){
		grafo_processo4.setOpacity(1.0);
	}
	
	public void Foco_Processo5(){
		if(modo_remocao)
			grafo_processo5.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Processo5(){
		grafo_processo5.setOpacity(1.0);
	}
	
	public void Foco_Processo6(){
		if(modo_remocao)
			grafo_processo6.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Processo6(){
		grafo_processo6.setOpacity(1.0);
	}
	
	public void Foco_Processo7(){
		if(modo_remocao)
			grafo_processo7.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Processo7(){
		grafo_processo7.setOpacity(1.0);
	}
	
	public void Foco_Processo8(){
		if(modo_remocao)
			grafo_processo8.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Processo8(){
		grafo_processo8.setOpacity(1.0);
	}
	
	public void Foco_Processo9(){
		if(modo_remocao)
			grafo_processo9.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Processo9(){
		grafo_processo9.setOpacity(1.0);
	}
	
	public void Foco_Processo10(){
		if(modo_remocao)
			grafo_processo10.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Processo10(){
		grafo_processo10.setOpacity(1.0);
	}
	
	public void Foco_Recurso_1(){
		recurso1.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Recurso_1(){
		recurso1.setOpacity(1.0);
		remover_recurso.setVisible(false);
		remover_recurso.setDisable(true);
	}
	
	public void Foco_Recurso_2(){
		recurso2.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Recurso_2(){
		recurso2.setOpacity(1.0);
		remover_recurso.setVisible(false);
		remover_recurso.setDisable(true);
	}
	
	public void Foco_Recurso_3(){
		recurso3.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Recurso_3(){
		recurso3.setOpacity(1.0);
		remover_recurso.setVisible(false);
		remover_recurso.setDisable(true);
	}
	
	public void Foco_Recurso_4(){
		recurso4.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Recurso_4(){
		recurso4.setOpacity(1.0);
		remover_recurso.setVisible(false);
		remover_recurso.setDisable(true);
	}
	
	public void Foco_Recurso_5(){
		recurso5.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Recurso_5(){
		recurso5.setOpacity(1.0);
		remover_recurso.setVisible(false);
		remover_recurso.setDisable(true);
	}
	
	public void Foco_Recurso_6(){
		recurso6.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Recurso_6(){
		recurso6.setOpacity(1.0);
		remover_recurso.setVisible(false);
		remover_recurso.setDisable(true);
	}
	
	public void Foco_Recurso_7(){
		recurso7.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Recurso_7(){
		recurso7.setOpacity(1.0);
		remover_recurso.setVisible(false);
		remover_recurso.setDisable(true);
	}
	
	public void Foco_Recurso_8(){
		recurso8.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Recurso_8(){
		recurso8.setOpacity(1.0);
		remover_recurso.setVisible(false);
		remover_recurso.setDisable(true);
	}
	
	public void Foco_Recurso_9(){
		recurso9.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Recurso_9(){
		recurso9.setOpacity(1.0);
		remover_recurso.setVisible(false);
		remover_recurso.setDisable(true);
	}
	
	public void Foco_Recurso_10(){
		recurso10.setOpacity(0.5);
	}
	
	public void Tirar_Foco_Recurso_10(){
		recurso10.setOpacity(1.0);
		remover_recurso.setVisible(false);
		remover_recurso.setDisable(true);
	}
	
	public void Atualizar_Detalhes(){
		int n = 0,m = 0;
		for(Processo p : processos){
			n++;
			if(p.id != -1){
				m++; 
				switch (n) {
				case 1:
					processo1_pane.setVisible(true);
					processo1_id.setText(String.valueOf(p.id));
					processo1.setPreserveRatio(true);
					processo1.setImage(p.img);
					processo1_nome.setText(p.nome);
					processo1_ts.setText(String.valueOf(p.delta_ts));
					processo1_tu.setText(String.valueOf(p.delta_tu));
					processo2_pane.setVisible(false);
					processo3_pane.setVisible(false);
					processo4_pane.setVisible(false);
					processo5_pane.setVisible(false);
					processo6_pane.setVisible(false);
					processo7_pane.setVisible(false);
					processo8_pane.setVisible(false);
					processo9_pane.setVisible(false);
					processo10_pane.setVisible(false);
					break;
				case 2:
					processo2_pane.setVisible(true);
					processo2_id.setText(String.valueOf(p.id));
					processo2.setPreserveRatio(true);
					processo2.setImage(p.img);
					processo2_nome.setText(p.nome);
					processo2_ts.setText(String.valueOf(p.delta_ts));
					processo2_tu.setText(String.valueOf(p.delta_tu));
					processo2_pane.setTranslateY(120 * (m - 1));
					processo3_pane.setVisible(false);
					processo4_pane.setVisible(false);
					processo5_pane.setVisible(false);
					processo6_pane.setVisible(false);
					processo7_pane.setVisible(false);
					processo8_pane.setVisible(false);
					processo9_pane.setVisible(false);
					processo10_pane.setVisible(false);
					break;
				case 3:
					processo3_pane.setVisible(true);
					processo3_id.setText(String.valueOf(p.id));
					processo3.setPreserveRatio(true);
					processo3.setImage(p.img);
					processo3_nome.setText(p.nome);
					processo3_ts.setText(String.valueOf(p.delta_ts));
					processo3_tu.setText(String.valueOf(p.delta_tu));
					processo3_pane.setTranslateY(120 * (m - 1));
					processo4_pane.setVisible(false);
					processo5_pane.setVisible(false);
					processo6_pane.setVisible(false);
					processo7_pane.setVisible(false);
					processo8_pane.setVisible(false);
					processo9_pane.setVisible(false);
					processo10_pane.setVisible(false);
					break;
				case 4:
					processo4_pane.setVisible(true);
					processo4_id.setText(String.valueOf(p.id));
					processo4.setPreserveRatio(true);
					processo4.setImage(p.img);
					processo4_nome.setText(p.nome);
					processo4_ts.setText(String.valueOf(p.delta_ts));
					processo4_tu.setText(String.valueOf(p.delta_tu));
					processo4_pane.setTranslateY(120 * (m - 1));
					processo5_pane.setVisible(false);
					processo6_pane.setVisible(false);
					processo7_pane.setVisible(false);
					processo8_pane.setVisible(false);
					processo9_pane.setVisible(false);
					processo10_pane.setVisible(false);
					break;
				case 5:
					processo5_pane.setVisible(true);
					processo5_id.setText(String.valueOf(p.id));
					processo5.setPreserveRatio(true);
					processo5.setImage(p.img);
					processo5_nome.setText(p.nome);
					processo5_ts.setText(String.valueOf(p.delta_ts));
					processo5_tu.setText(String.valueOf(p.delta_tu));
					processo5_pane.setTranslateY(120 * (m - 1));
					processo6_pane.setVisible(false);
					processo7_pane.setVisible(false);
					processo8_pane.setVisible(false);
					processo9_pane.setVisible(false);
					processo10_pane.setVisible(false);
					break;
				case 6:
					processo6_pane.setVisible(true);
					processo6_id.setText(String.valueOf(p.id));
					processo6.setPreserveRatio(true);
					processo6.setImage(p.img);
					processo6_nome.setText(p.nome);
					processo6_ts.setText(String.valueOf(p.delta_ts));
					processo6_tu.setText(String.valueOf(p.delta_tu));
					processo6_pane.setTranslateY(120 * (m - 1));
					processo7_pane.setVisible(false);
					processo8_pane.setVisible(false);
					processo9_pane.setVisible(false);
					processo10_pane.setVisible(false);
					break;
				case 7:
					processo7_pane.setVisible(true);
					processo7_id.setText(String.valueOf(p.id));
					processo7.setPreserveRatio(true);
					processo7.setImage(p.img);
					processo7_nome.setText(p.nome);
					processo7_ts.setText(String.valueOf(p.delta_ts));
					processo7_tu.setText(String.valueOf(p.delta_tu));
					processo7_pane.setTranslateY(120 * (m - 1));
					processo8_pane.setVisible(false);
					processo9_pane.setVisible(false);
					processo10_pane.setVisible(false);
					break;
				case 8:
					processo8_pane.setVisible(true);
					processo8_id.setText(String.valueOf(p.id));
					processo1.setPreserveRatio(true);
					processo8.setImage(p.img);
					processo8_nome.setText(p.nome);
					processo8_ts.setText(String.valueOf(p.delta_ts));
					processo8_tu.setText(String.valueOf(p.delta_tu));
					processo8_pane.setTranslateY(120 * (m - 1));
					processo9_pane.setVisible(false);
					processo10_pane.setVisible(false);
					break;
				case 9:
					processo9_pane.setVisible(true);
					processo9_id.setText(String.valueOf(p.id));
					processo9.setPreserveRatio(true);
					processo9.setImage(p.img);
					processo9_nome.setText(p.nome);
					processo9_ts.setText(String.valueOf(p.delta_ts));
					processo9_tu.setText(String.valueOf(p.delta_tu));
					processo9_pane.setTranslateY(120 * (m - 1));
					processo10_pane.setVisible(false);
					break;
				case 10:
					processo10_pane.setVisible(true);
					processo10_id.setText(String.valueOf(p.id));
					processo10.setPreserveRatio(true);
					processo10.setImage(p.img);
					processo10_nome.setText(p.nome);
					processo10_ts.setText(String.valueOf(p.delta_ts));
					processo10_tu.setText(String.valueOf(p.delta_tu));
					processo10_pane.setTranslateY(120 * (m - 1));
					break;
				default:
					break;
			}
		}
		else{ 
			switch (n) {
			case 1:
				processo1_recurso1.setImage(null);
				processo1_recurso1_tu.setText("");
				processo1_recurso2.setImage(null);
				processo1_recurso2_tu.setText("");
				processo1_recurso3.setImage(null);
				processo1_recurso3_tu.setText("");
				processo1_recurso4.setImage(null);
				processo1_recurso4_tu.setText("");
				processo1_recurso5.setImage(null);
				processo1_recurso5_tu.setText("");
				processo1_recurso6.setImage(null);
				processo1_recurso6_tu.setText("");
				processo1_recurso7.setImage(null);
				processo1_recurso7_tu.setText("");
				processo1_recurso8.setImage(null);
				processo1_recurso8_tu.setText("");
				processo1_recurso9.setImage(null);
				processo1_recurso9_tu.setText("");
				processo1_recurso10.setImage(null);
				processo1_recurso10_tu.setText("");
				processo1.setEffect(null);
				processo1_status.setText("");
				processo1_status.setTextFill(Color.BLACK);
				p1_pane.setEffect(null);
				break;
			case 2:
				processo2_recurso1.setImage(null);
				processo2_recurso1_tu.setText("");
				processo2_recurso2.setImage(null);
				processo2_recurso2_tu.setText("");
				processo2_recurso3.setImage(null);
				processo2_recurso3_tu.setText("");
				processo2_recurso4.setImage(null);
				processo2_recurso4_tu.setText("");
				processo2_recurso5.setImage(null);
				processo2_recurso5_tu.setText("");
				processo2_recurso6.setImage(null);
				processo2_recurso6_tu.setText("");
				processo2_recurso7.setImage(null);
				processo2_recurso7_tu.setText("");
				processo2_recurso8.setImage(null);
				processo2_recurso8_tu.setText("");
				processo2_recurso9.setImage(null);
				processo2_recurso9_tu.setText("");
				processo2_recurso10.setImage(null);
				processo2_recurso10_tu.setText("");
				processo2.setEffect(null);
				processo2_status.setText("");
				processo2_status.setTextFill(Color.BLACK);
				p2_pane.setEffect(null);
				break;
			case 3:
				processo3_recurso1.setImage(null);
				processo3_recurso1_tu.setText("");
				processo3_recurso2.setImage(null);
				processo3_recurso2_tu.setText("");
				processo3_recurso3.setImage(null);
				processo3_recurso3_tu.setText("");
				processo3_recurso4.setImage(null);
				processo3_recurso4_tu.setText("");
				processo3_recurso5.setImage(null);
				processo3_recurso5_tu.setText("");
				processo3_recurso6.setImage(null);
				processo3_recurso6_tu.setText("");
				processo3_recurso7.setImage(null);
				processo3_recurso7_tu.setText("");
				processo3_recurso8.setImage(null);
				processo3_recurso8_tu.setText("");
				processo3_recurso9.setImage(null);
				processo3_recurso9_tu.setText("");
				processo3_recurso10.setImage(null);
				processo3_recurso10_tu.setText("");
				processo3.setEffect(null);
				processo3_status.setText("");
				processo3_status.setTextFill(Color.BLACK);
				p3_pane.setEffect(null);
				break;
			case 4:
				processo4_recurso1.setImage(null);
				processo4_recurso1_tu.setText("");
				processo4_recurso2.setImage(null);
				processo4_recurso2_tu.setText("");
				processo4_recurso3.setImage(null);
				processo4_recurso3_tu.setText("");
				processo4_recurso4.setImage(null);
				processo4_recurso4_tu.setText("");
				processo4_recurso5.setImage(null);
				processo4_recurso5_tu.setText("");
				processo4_recurso6.setImage(null);
				processo4_recurso6_tu.setText("");
				processo4_recurso7.setImage(null);
				processo4_recurso7_tu.setText("");
				processo4_recurso8.setImage(null);
				processo4_recurso8_tu.setText("");
				processo4_recurso9.setImage(null);
				processo4_recurso9_tu.setText("");
				processo4_recurso10.setImage(null);
				processo4_recurso10_tu.setText("");
				processo4.setEffect(null);
				processo4_status.setText("");
				processo4_status.setTextFill(Color.BLACK);
				p4_pane.setEffect(null);
				break;
			case 5:
				processo5_recurso1.setImage(null);
				processo5_recurso1_tu.setText("");
				processo5_recurso2.setImage(null);
				processo5_recurso2_tu.setText("");
				processo5_recurso3.setImage(null);
				processo5_recurso3_tu.setText("");
				processo5_recurso4.setImage(null);
				processo5_recurso4_tu.setText("");
				processo5_recurso5.setImage(null);
				processo5_recurso5_tu.setText("");
				processo5_recurso6.setImage(null);
				processo5_recurso6_tu.setText("");
				processo5_recurso7.setImage(null);
				processo5_recurso7_tu.setText("");
				processo5_recurso8.setImage(null);
				processo5_recurso8_tu.setText("");
				processo5_recurso9.setImage(null);
				processo5_recurso9_tu.setText("");
				processo5_recurso10.setImage(null);
				processo5_recurso10_tu.setText("");
				processo5.setEffect(null);
				processo5_status.setText("");
				processo5_status.setTextFill(Color.BLACK);
				p5_pane.setEffect(null);
				break;
			case 6:
				processo6_recurso1.setImage(null);
				processo6_recurso1_tu.setText("");
				processo6_recurso2.setImage(null);
				processo6_recurso2_tu.setText("");
				processo6_recurso3.setImage(null);
				processo6_recurso3_tu.setText("");
				processo6_recurso4.setImage(null);
				processo6_recurso4_tu.setText("");
				processo6_recurso5.setImage(null);
				processo6_recurso5_tu.setText("");
				processo6_recurso6.setImage(null);
				processo6_recurso6_tu.setText("");
				processo6_recurso7.setImage(null);
				processo6_recurso7_tu.setText("");
				processo6_recurso8.setImage(null);
				processo6_recurso8_tu.setText("");
				processo6_recurso9.setImage(null);
				processo6_recurso9_tu.setText("");
				processo6_recurso10.setImage(null);
				processo6_recurso10_tu.setText("");
				processo6.setEffect(null);
				processo6_status.setText("");
				processo6_status.setTextFill(Color.BLACK);
				p6_pane.setEffect(null);
				break;
			case 7:
				processo7_recurso1.setImage(null);
				processo7_recurso1_tu.setText("");
				processo7_recurso2.setImage(null);
				processo7_recurso2_tu.setText("");
				processo7_recurso3.setImage(null);
				processo7_recurso3_tu.setText("");
				processo7_recurso4.setImage(null);
				processo7_recurso4_tu.setText("");
				processo7_recurso5.setImage(null);
				processo7_recurso5_tu.setText("");
				processo7_recurso6.setImage(null);
				processo7_recurso6_tu.setText("");
				processo7_recurso7.setImage(null);
				processo7_recurso7_tu.setText("");
				processo7_recurso8.setImage(null);
				processo7_recurso8_tu.setText("");
				processo7_recurso9.setImage(null);
				processo7_recurso9_tu.setText("");
				processo7_recurso10.setImage(null);
				processo7_recurso10_tu.setText("");
				processo7.setEffect(null);
				processo7_status.setText("");
				processo7_status.setTextFill(Color.BLACK);
				p7_pane.setEffect(null);
				break;
			case 8:
				processo8_recurso1.setImage(null);
				processo8_recurso1_tu.setText("");
				processo8_recurso2.setImage(null);
				processo8_recurso2_tu.setText("");
				processo8_recurso3.setImage(null);
				processo8_recurso3_tu.setText("");
				processo8_recurso4.setImage(null);
				processo8_recurso4_tu.setText("");
				processo8_recurso5.setImage(null);
				processo8_recurso5_tu.setText("");
				processo8_recurso6.setImage(null);
				processo8_recurso6_tu.setText("");
				processo8_recurso7.setImage(null);
				processo8_recurso7_tu.setText("");
				processo8_recurso8.setImage(null);
				processo8_recurso8_tu.setText("");
				processo8_recurso9.setImage(null);
				processo8_recurso9_tu.setText("");
				processo8_recurso10.setImage(null);
				processo8_recurso10_tu.setText("");
				processo8.setEffect(null);
				processo8_status.setText("");
				processo8_status.setTextFill(Color.BLACK);
				p8_pane.setEffect(null);
				break;
			case 9:
				processo9_recurso1.setImage(null);
				processo9_recurso1_tu.setText("");
				processo9_recurso2.setImage(null);
				processo9_recurso2_tu.setText("");
				processo9_recurso3.setImage(null);
				processo9_recurso3_tu.setText("");
				processo9_recurso4.setImage(null);
				processo9_recurso4_tu.setText("");
				processo9_recurso5.setImage(null);
				processo9_recurso5_tu.setText("");
				processo9_recurso6.setImage(null);
				processo9_recurso6_tu.setText("");
				processo9_recurso7.setImage(null);
				processo9_recurso7_tu.setText("");
				processo9_recurso8.setImage(null);
				processo9_recurso8_tu.setText("");
				processo9_recurso9.setImage(null);
				processo9_recurso9_tu.setText("");
				processo9_recurso10.setImage(null);
				processo9_recurso10_tu.setText("");
				processo9.setEffect(null);
				processo9_status.setText("");
				processo9_status.setTextFill(Color.BLACK);
				p9_pane.setEffect(null);
				break;
			case 10:
				processo10_recurso1.setImage(null);
				processo10_recurso1_tu.setText("");
				processo10_recurso2.setImage(null);
				processo10_recurso2_tu.setText("");
				processo10_recurso3.setImage(null);
				processo10_recurso3_tu.setText("");
				processo10_recurso4.setImage(null);
				processo10_recurso4_tu.setText("");
				processo10_recurso5.setImage(null);
				processo10_recurso5_tu.setText("");
				processo10_recurso6.setImage(null);
				processo10_recurso6_tu.setText("");
				processo10_recurso7.setImage(null);
				processo10_recurso7_tu.setText("");
				processo10_recurso8.setImage(null);
				processo10_recurso8_tu.setText("");
				processo10_recurso9.setImage(null);
				processo10_recurso9_tu.setText("");
				processo10_recurso10.setImage(null);
				processo10_recurso10_tu.setText("");
				processo10.setEffect(null);
				processo10_status.setText("");
				processo10_status.setTextFill(Color.BLACK);
				p10_pane.setEffect(null);
				break;
			default:
				break;
			}	
		}
	}
}
	
	public void setar_Imagem_Recurso_Processo1(int n_recurso, Image img, double opacidade){
		switch (n_recurso) {
		case 1:
			processo1_recurso1.setImage(img);
			processo1_recurso1.setOpacity(opacidade);
			break;
		case 2:
			processo1_recurso2.setImage(img);
			processo1_recurso2.setOpacity(opacidade);
			break;
		case 3:
			processo1_recurso3.setImage(img);
			processo1_recurso3.setOpacity(opacidade);
			break;
		case 4:
			processo1_recurso4.setImage(img);
			processo1_recurso4.setOpacity(opacidade);
			break;
		case 5:
			processo1_recurso5.setImage(img);
			processo1_recurso5.setOpacity(opacidade);
			break;
		case 6:
			processo1_recurso6.setImage(img);
			processo1_recurso6.setOpacity(opacidade);
			break;
		case 7:
			processo1_recurso7.setImage(img);
			processo1_recurso7.setOpacity(opacidade);
			break;
		case 8:
			processo1_recurso8.setImage(img);
			processo1_recurso8.setOpacity(opacidade);
			break;
		case 9:
			processo1_recurso9.setImage(img);
			processo1_recurso9.setOpacity(opacidade);
			break;
		case 10:
			processo1_recurso10.setImage(img);
			processo1_recurso10.setOpacity(opacidade);
			break;
		default:
			break;
		}
	}
	
	public void setar_Imagem_Recurso_Processo2(int n_recurso, Image img, double opacidade){
		switch (n_recurso) {
		case 1:
			processo2_recurso1.setImage(img);
			processo2_recurso1.setOpacity(opacidade);
			break;
		case 2:
			processo2_recurso2.setImage(img);
			processo2_recurso2.setOpacity(opacidade);
			break;
		case 3:
			processo2_recurso3.setImage(img);
			processo2_recurso3.setOpacity(opacidade);
			break;
		case 4:
			processo2_recurso4.setImage(img);
			processo2_recurso4.setOpacity(opacidade);
			break;
		case 5:
			processo2_recurso5.setImage(img);
			processo2_recurso5.setOpacity(opacidade);
			break;
		case 6:
			processo2_recurso6.setImage(img);
			processo2_recurso6.setOpacity(opacidade);
			break;
		case 7:
			processo2_recurso7.setImage(img);
			processo2_recurso7.setOpacity(opacidade);
			break;
		case 8:
			processo2_recurso8.setImage(img);
			processo2_recurso8.setOpacity(opacidade);
			break;
		case 9:
			processo2_recurso9.setImage(img);
			processo2_recurso9.setOpacity(opacidade);
			break;
		case 10:
			processo2_recurso10.setImage(img);
			processo2_recurso10.setOpacity(opacidade);
			break;
		default:
			break;
		}
	}
	
	public void setar_Imagem_Recurso_Processo3(int n_recurso, Image img, double opacidade){
		switch (n_recurso) {
		case 1:
			processo3_recurso1.setImage(img);
			processo3_recurso1.setOpacity(opacidade);
			break;
		case 2:
			processo3_recurso2.setImage(img);
			processo3_recurso2.setOpacity(opacidade);
			break;
		case 3:
			processo3_recurso3.setImage(img);
			processo3_recurso3.setOpacity(opacidade);
			break;
		case 4:
			processo3_recurso4.setImage(img);
			processo3_recurso4.setOpacity(opacidade);
			break;
		case 5:
			processo3_recurso5.setImage(img);
			processo3_recurso5.setOpacity(opacidade);
			break;
		case 6:
			processo3_recurso6.setImage(img);
			processo3_recurso6.setOpacity(opacidade);
			break;
		case 7:
			processo3_recurso7.setImage(img);
			processo3_recurso7.setOpacity(opacidade);
			break;
		case 8:
			processo3_recurso8.setImage(img);
			processo3_recurso8.setOpacity(opacidade);
			break;
		case 9:
			processo3_recurso9.setImage(img);
			processo3_recurso9.setOpacity(opacidade);
			break;
		case 10:
			processo3_recurso10.setImage(img);
			processo3_recurso10.setOpacity(opacidade);
			break;
		default:
			break;
		}
	}
	
	public void setar_Imagem_Recurso_Processo4(int n_recurso, Image img, double opacidade){
		switch (n_recurso) {
		case 1:
			processo4_recurso1.setImage(img);
			processo4_recurso1.setOpacity(opacidade);
			break;
		case 2:
			processo4_recurso2.setImage(img);
			processo4_recurso2.setOpacity(opacidade);
			break;
		case 3:
			processo4_recurso3.setImage(img);
			processo4_recurso3.setOpacity(opacidade);
			break;
		case 4:
			processo4_recurso4.setImage(img);
			processo4_recurso4.setOpacity(opacidade);
			break;
		case 5:
			processo4_recurso5.setImage(img);
			processo4_recurso5.setOpacity(opacidade);
			break;
		case 6:
			processo4_recurso6.setImage(img);
			processo4_recurso6.setOpacity(opacidade);
			break;
		case 7:
			processo4_recurso7.setImage(img);
			processo4_recurso7.setOpacity(opacidade);
			break;
		case 8:
			processo4_recurso8.setImage(img);
			processo4_recurso8.setOpacity(opacidade);
			break;
		case 9:
			processo4_recurso9.setImage(img);
			processo4_recurso9.setOpacity(opacidade);
			break;
		case 10:
			processo4_recurso10.setImage(img);
			processo4_recurso10.setOpacity(opacidade);
			break;
		default:
			break;
		}
	}
	
	public void setar_Imagem_Recurso_Processo5(int n_recurso, Image img, double opacidade){
		switch (n_recurso) {
		case 1:
			processo5_recurso1.setImage(img);
			processo5_recurso1.setOpacity(opacidade);
			break;
		case 2:
			processo5_recurso2.setImage(img);
			processo5_recurso2.setOpacity(opacidade);
			break;
		case 3:
			processo5_recurso3.setImage(img);
			processo5_recurso3.setOpacity(opacidade);
			break;
		case 4:
			processo5_recurso4.setImage(img);
			processo5_recurso4.setOpacity(opacidade);
			break;
		case 5:
			processo5_recurso5.setImage(img);
			processo5_recurso5.setOpacity(opacidade);
			break;
		case 6:
			processo5_recurso6.setImage(img);
			processo5_recurso6.setOpacity(opacidade);
			break;
		case 7:
			processo5_recurso7.setImage(img);
			processo5_recurso7.setOpacity(opacidade);
			break;
		case 8:
			processo5_recurso8.setImage(img);
			processo5_recurso8.setOpacity(opacidade);
			break;
		case 9:
			processo5_recurso9.setImage(img);
			processo5_recurso9.setOpacity(opacidade);
			break;
		case 10:
			processo5_recurso10.setImage(img);
			processo5_recurso10.setOpacity(opacidade);
			break;
		default:
			break;
		}
	}
	
	public void setar_Imagem_Recurso_Processo6(int n_recurso, Image img,double opacidade){
		switch (n_recurso) {
		case 1:
			processo6_recurso1.setImage(img);
			processo6_recurso1.setOpacity(opacidade);
			break;
		case 2:
			processo6_recurso2.setImage(img);
			processo6_recurso2.setOpacity(opacidade);
			break;
		case 3:
			processo6_recurso3.setImage(img);
			processo6_recurso3.setOpacity(opacidade);
			break;
		case 4:
			processo6_recurso4.setImage(img);
			processo6_recurso4.setOpacity(opacidade);
			break;
		case 5:
			processo6_recurso5.setImage(img);
			processo6_recurso5.setOpacity(opacidade);
			break;
		case 6:
			processo6_recurso6.setImage(img);
			processo6_recurso6.setOpacity(opacidade);
			break;
		case 7:
			processo6_recurso7.setImage(img);
			processo6_recurso7.setOpacity(opacidade);
			break;
		case 8:
			processo6_recurso8.setImage(img);
			processo6_recurso8.setOpacity(opacidade);
			break;
		case 9:
			processo6_recurso9.setImage(img);
			processo6_recurso9.setOpacity(opacidade);
			break;
		case 10:
			processo6_recurso10.setImage(img);
			processo6_recurso10.setOpacity(opacidade);
			break;
		default:
			break;
		}
	}
	
	public void setar_Imagem_Recurso_Processo7(int n_recurso, Image img, double opacidade){
		switch (n_recurso) {
		case 1:
			processo7_recurso1.setImage(img);
			processo7_recurso1.setOpacity(opacidade);
			break;
		case 2:
			processo7_recurso2.setImage(img);
			processo7_recurso2.setOpacity(opacidade);
			break;
		case 3:
			processo7_recurso3.setImage(img);
			processo7_recurso3.setOpacity(opacidade);
			break;
		case 4:
			processo7_recurso4.setImage(img);
			processo7_recurso4.setOpacity(opacidade);
			break;
		case 5:
			processo7_recurso5.setImage(img);
			processo7_recurso5.setOpacity(opacidade);
			break;
		case 6:
			processo7_recurso6.setImage(img);
			processo7_recurso6.setOpacity(opacidade);
			break;
		case 7:
			processo7_recurso7.setImage(img);
			processo7_recurso7.setOpacity(opacidade);
			break;
		case 8:
			processo7_recurso8.setImage(img);
			processo7_recurso8.setOpacity(opacidade);
			break;
		case 9:
			processo7_recurso9.setImage(img);
			processo7_recurso9.setOpacity(opacidade);
			break;
		case 10:
			processo7_recurso10.setImage(img);
			processo7_recurso10.setOpacity(opacidade);
			break;
		default:
			break;
		}
	}
	
	public void setar_Imagem_Recurso_Processo8(int n_recurso, Image img, double opacidade){
		switch (n_recurso) {
		case 1:
			processo8_recurso1.setImage(img);
			processo8_recurso1.setOpacity(opacidade);
			break;
		case 2:
			processo8_recurso2.setImage(img);
			processo8_recurso2.setOpacity(opacidade);
			break;
		case 3:
			processo8_recurso3.setImage(img);
			processo8_recurso3.setOpacity(opacidade);
			break;
		case 4:
			processo8_recurso4.setImage(img);
			processo8_recurso4.setOpacity(opacidade);
			break;
		case 5:
			processo8_recurso5.setImage(img);
			processo8_recurso5.setOpacity(opacidade);
			break;
		case 6:
			processo8_recurso6.setImage(img);
			processo8_recurso6.setOpacity(opacidade);
			break;
		case 7:
			processo8_recurso7.setImage(img);
			processo8_recurso7.setOpacity(opacidade);
			break;
		case 8:
			processo8_recurso8.setImage(img);
			processo8_recurso8.setOpacity(opacidade);
			break;
		case 9:
			processo8_recurso9.setImage(img);
			processo8_recurso9.setOpacity(opacidade);
			break;
		case 10:
			processo8_recurso10.setImage(img);
			processo8_recurso10.setOpacity(opacidade);
			break;
		default:
			break;
		}
	}
	
	public void setar_Imagem_Recurso_Processo9(int n_recurso, Image img, double opacidade){
		switch (n_recurso) {
		case 1:
			processo9_recurso1.setImage(img);
			processo9_recurso1.setOpacity(opacidade);
			break;
		case 2:
			processo9_recurso2.setImage(img);
			processo9_recurso2.setOpacity(opacidade);
			break;
		case 3:
			processo9_recurso3.setImage(img);
			processo9_recurso3.setOpacity(opacidade);
			break;
		case 4:
			processo9_recurso4.setImage(img);
			processo9_recurso4.setOpacity(opacidade);
			break;
		case 5:
			processo9_recurso5.setImage(img);
			processo9_recurso5.setOpacity(opacidade);
			break;
		case 6:
			processo9_recurso6.setImage(img);
			processo9_recurso6.setOpacity(opacidade);
			break;
		case 7:
			processo9_recurso7.setImage(img);
			processo9_recurso7.setOpacity(opacidade);
			break;
		case 8:
			processo9_recurso8.setImage(img);
			processo9_recurso8.setOpacity(opacidade);
			break;
		case 9:
			processo9_recurso9.setImage(img);
			processo9_recurso9.setOpacity(opacidade);
			break;
		case 10:
			processo9_recurso10.setImage(img);
			processo9_recurso10.setOpacity(opacidade);
			break;
		default:
			break;
		}
	}
	
	public void setar_Imagem_Recurso_Processo10(int n_recurso, Image img, double opacidade){
		switch (n_recurso) {
		case 1:
			processo10_recurso1.setImage(img);
			processo10_recurso1.setOpacity(opacidade);
			break;
		case 2:
			processo10_recurso2.setImage(img);
			processo10_recurso2.setOpacity(opacidade);
			break;
		case 3:
			processo10_recurso3.setImage(img);
			processo10_recurso3.setOpacity(opacidade);
			break;
		case 4:
			processo10_recurso4.setImage(img);
			processo10_recurso4.setOpacity(opacidade);
			break;
		case 5:
			processo10_recurso5.setImage(img);
			processo10_recurso5.setOpacity(opacidade);
			break;
		case 6:
			processo10_recurso6.setImage(img);
			processo10_recurso6.setOpacity(opacidade);
			break;
		case 7:
			processo10_recurso7.setImage(img);
			processo10_recurso7.setOpacity(opacidade);
			break;
		case 8:
			processo10_recurso8.setImage(img);
			processo10_recurso8.setOpacity(opacidade);
			break;
		case 9:
			processo10_recurso9.setImage(img);
			processo10_recurso9.setOpacity(opacidade);
			break;
		case 10:
			processo10_recurso10.setImage(img);
			processo10_recurso10.setOpacity(opacidade);
			break;
		default:
			break;
		}
	}
	
	public void setar_Imagem_Recurso_Processo(int id_processo, int n_recurso, Image img, double opacidade){
		int index = 0;
		while(processos.get(index).id != id_processo)
			index++;
		switch (index) {
		case 0:
			Platform.runLater(() -> {setar_Imagem_Recurso_Processo1(n_recurso, img,opacidade);});
			break;
		case 1:
			Platform.runLater(() -> {setar_Imagem_Recurso_Processo2(n_recurso, img,opacidade);});
			break;
		case 2:
			Platform.runLater(() -> {setar_Imagem_Recurso_Processo3(n_recurso, img,opacidade);});
			break;
		case 3:
			Platform.runLater(() -> {setar_Imagem_Recurso_Processo4(n_recurso, img,opacidade);});
			break;
		case 4:
			Platform.runLater(() -> {setar_Imagem_Recurso_Processo5(n_recurso, img,opacidade);});
			break;
		case 5:
			Platform.runLater(() -> {setar_Imagem_Recurso_Processo6(n_recurso, img,opacidade);});
			break;
		case 6:
			Platform.runLater(() -> {setar_Imagem_Recurso_Processo7(n_recurso, img,opacidade);});
			break;
		case 7:
			Platform.runLater(() -> {setar_Imagem_Recurso_Processo8(n_recurso, img,opacidade);});
			break;
		case 8:
			Platform.runLater(() -> {setar_Imagem_Recurso_Processo9(n_recurso, img,opacidade);});
			break;
		case 9:
			Platform.runLater(() -> {setar_Imagem_Recurso_Processo10(n_recurso, img,opacidade);});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Tempo_Recurso_Processo1(int n_recurso, int tempo){
		switch (n_recurso) {
		case 1:
			Platform.runLater(() ->{
				processo1_recurso1_tu.setText(String.valueOf(tempo));
			});
			break;
		case 2:
			Platform.runLater(() ->{
				processo1_recurso2_tu.setText(String.valueOf(tempo));
			});
			break;
		case 3:
			Platform.runLater(() ->{
				processo1_recurso3_tu.setText(String.valueOf(tempo));
			});
			break;
		case 4:
			Platform.runLater(() ->{
				processo1_recurso4_tu.setText(String.valueOf(tempo));
			});
			break;
		case 5:
			Platform.runLater(() ->{
				processo1_recurso5_tu.setText(String.valueOf(tempo));
			});
			break;
		case 6:
			Platform.runLater(() ->{
				processo1_recurso6_tu.setText(String.valueOf(tempo));
			});
			break;
		case 7:
			Platform.runLater(() ->{
				processo1_recurso7_tu.setText(String.valueOf(tempo));
			});
			break;
		case 8:
			Platform.runLater(() ->{
				processo1_recurso8_tu.setText(String.valueOf(tempo));
			});
			break;
		case 9:
			Platform.runLater(() ->{
				processo1_recurso9_tu.setText(String.valueOf(tempo));
			});
			break;
		case 10:
			Platform.runLater(() ->{
				processo1_recurso10_tu.setText(String.valueOf(tempo));
			});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Tempo_Recurso_Processo2(int n_recurso, int tempo){
		switch (n_recurso) {
		case 1:
			Platform.runLater(() ->{
				processo2_recurso1_tu.setText(String.valueOf(tempo));
			});
			break;
		case 2:
			Platform.runLater(() ->{
				processo2_recurso2_tu.setText(String.valueOf(tempo));
			});
			break;
		case 3:
			Platform.runLater(() ->{
				processo2_recurso3_tu.setText(String.valueOf(tempo));
			});
			break;
		case 4:
			Platform.runLater(() ->{
				processo2_recurso4_tu.setText(String.valueOf(tempo));
			});
			break;
		case 5:
			Platform.runLater(() ->{
				processo2_recurso5_tu.setText(String.valueOf(tempo));
			});
			break;
		case 6:
			Platform.runLater(() ->{
				processo2_recurso6_tu.setText(String.valueOf(tempo));
			});
			break;
		case 7:
			Platform.runLater(() ->{
				processo2_recurso7_tu.setText(String.valueOf(tempo));
			});
			break;
		case 8:
			Platform.runLater(() ->{
				processo2_recurso8_tu.setText(String.valueOf(tempo));
			});
			break;
		case 9:
			Platform.runLater(() ->{
				processo2_recurso9_tu.setText(String.valueOf(tempo));
			});
			break;
		case 10:
			Platform.runLater(() ->{
				processo2_recurso10_tu.setText(String.valueOf(tempo));
			});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Tempo_Recurso_Processo3(int n_recurso, int tempo){
		switch (n_recurso) {
		case 1:
			Platform.runLater(() ->{
				processo3_recurso1_tu.setText(String.valueOf(tempo));
			});
			break;
		case 2:
			Platform.runLater(() ->{
				processo3_recurso2_tu.setText(String.valueOf(tempo));
			});
			break;
		case 3:
			Platform.runLater(() ->{
				processo3_recurso3_tu.setText(String.valueOf(tempo));
			});
			break;
		case 4:
			Platform.runLater(() ->{
				processo3_recurso4_tu.setText(String.valueOf(tempo));
			});
			break;
		case 5:
			Platform.runLater(() ->{
				processo3_recurso5_tu.setText(String.valueOf(tempo));
			});
			break;
		case 6:
			Platform.runLater(() ->{
				processo3_recurso6_tu.setText(String.valueOf(tempo));
			});
			break;
		case 7:
			Platform.runLater(() ->{
				processo3_recurso7_tu.setText(String.valueOf(tempo));
			});
			break;
		case 8:
			Platform.runLater(() ->{
				processo3_recurso8_tu.setText(String.valueOf(tempo));
			});
			break;
		case 9:
			Platform.runLater(() ->{
				processo3_recurso9_tu.setText(String.valueOf(tempo));
			});
			break;
		case 10:
			Platform.runLater(() ->{
				processo3_recurso10_tu.setText(String.valueOf(tempo));
			});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Tempo_Recurso_Processo4(int n_recurso, int tempo){
		switch (n_recurso) {
		case 1:
			Platform.runLater(() ->{
				processo4_recurso1_tu.setText(String.valueOf(tempo));
			});
			break;
		case 2:
			Platform.runLater(() ->{
				processo4_recurso2_tu.setText(String.valueOf(tempo));
			});
			break;
		case 3:
			Platform.runLater(() ->{
				processo4_recurso3_tu.setText(String.valueOf(tempo));
			});
			break;
		case 4:
			Platform.runLater(() ->{
				processo4_recurso4_tu.setText(String.valueOf(tempo));
			});
			break;
		case 5:
			Platform.runLater(() ->{
				processo4_recurso5_tu.setText(String.valueOf(tempo));
			});
			break;
		case 6:
			Platform.runLater(() ->{
				processo4_recurso6_tu.setText(String.valueOf(tempo));
			});
			break;
		case 7:
			Platform.runLater(() ->{
				processo4_recurso7_tu.setText(String.valueOf(tempo));
			});
			break;
		case 8:
			Platform.runLater(() ->{
				processo4_recurso8_tu.setText(String.valueOf(tempo));
			});
			break;
		case 9:
			Platform.runLater(() ->{
				processo4_recurso9_tu.setText(String.valueOf(tempo));
			});
			break;
		case 10:
			Platform.runLater(() ->{
				processo4_recurso10_tu.setText(String.valueOf(tempo));
			});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Tempo_Recurso_Processo5(int n_recurso, int tempo){
		switch (n_recurso) {
		case 1:
			Platform.runLater(() ->{
				processo5_recurso1_tu.setText(String.valueOf(tempo));
			});
			break;
		case 2:
			Platform.runLater(() ->{
				processo5_recurso2_tu.setText(String.valueOf(tempo));
			});
			break;
		case 3:
			Platform.runLater(() ->{
				processo5_recurso3_tu.setText(String.valueOf(tempo));
			});
			break;
		case 4:
			Platform.runLater(() ->{
				processo5_recurso4_tu.setText(String.valueOf(tempo));
			});
			break;
		case 5:
			Platform.runLater(() ->{
				processo5_recurso5_tu.setText(String.valueOf(tempo));
			});
			break;
		case 6:
			Platform.runLater(() ->{
				processo5_recurso6_tu.setText(String.valueOf(tempo));
			});
			break;
		case 7:
			Platform.runLater(() ->{
				processo5_recurso7_tu.setText(String.valueOf(tempo));
			});
			break;
		case 8:
			Platform.runLater(() ->{
				processo5_recurso8_tu.setText(String.valueOf(tempo));
			});
			break;
		case 9:
			Platform.runLater(() ->{
				processo5_recurso9_tu.setText(String.valueOf(tempo));
			});
			break;
		case 10:
			Platform.runLater(() ->{
				processo5_recurso10_tu.setText(String.valueOf(tempo));
			});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Tempo_Recurso_Processo6(int n_recurso, int tempo){
		switch (n_recurso) {
		case 1:
			Platform.runLater(() ->{
				processo6_recurso1_tu.setText(String.valueOf(tempo));
			});
			break;
		case 2:
			Platform.runLater(() ->{
				processo6_recurso2_tu.setText(String.valueOf(tempo));
			});
			break;
		case 3:
			Platform.runLater(() ->{
				processo6_recurso3_tu.setText(String.valueOf(tempo));
			});
			break;
		case 4:
			Platform.runLater(() ->{
				processo6_recurso4_tu.setText(String.valueOf(tempo));
			});
			break;
		case 5:
			Platform.runLater(() ->{
				processo6_recurso5_tu.setText(String.valueOf(tempo));
			});
			break;
		case 6:
			Platform.runLater(() ->{
				processo6_recurso6_tu.setText(String.valueOf(tempo));
			});
			break;
		case 7:
			Platform.runLater(() ->{
				processo6_recurso7_tu.setText(String.valueOf(tempo));
			});
			break;
		case 8:
			Platform.runLater(() ->{
				processo6_recurso8_tu.setText(String.valueOf(tempo));
			});
			break;
		case 9:
			Platform.runLater(() ->{
				processo6_recurso9_tu.setText(String.valueOf(tempo));
			});
			break;
		case 10:
			Platform.runLater(() ->{
				processo6_recurso10_tu.setText(String.valueOf(tempo));
			});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Tempo_Recurso_Processo7(int n_recurso, int tempo){
		switch (n_recurso) {
		case 1:
			Platform.runLater(() ->{
				processo7_recurso1_tu.setText(String.valueOf(tempo));
			});
			break;
		case 2:
			Platform.runLater(() ->{
				processo7_recurso2_tu.setText(String.valueOf(tempo));
			});
			break;
		case 3:
			Platform.runLater(() ->{
				processo7_recurso3_tu.setText(String.valueOf(tempo));
			});
			break;
		case 4:
			Platform.runLater(() ->{
				processo7_recurso4_tu.setText(String.valueOf(tempo));
			});
			break;
		case 5:
			Platform.runLater(() ->{
				processo7_recurso5_tu.setText(String.valueOf(tempo));
			});
			break;
		case 6:
			Platform.runLater(() ->{
				processo7_recurso6_tu.setText(String.valueOf(tempo));
			});
			break;
		case 7:
			Platform.runLater(() ->{
				processo7_recurso7_tu.setText(String.valueOf(tempo));
			});
			break;
		case 8:
			Platform.runLater(() ->{
				processo7_recurso8_tu.setText(String.valueOf(tempo));
			});
			break;
		case 9:
			Platform.runLater(() ->{
				processo7_recurso9_tu.setText(String.valueOf(tempo));
			});
			break;
		case 10:
			Platform.runLater(() ->{
				processo7_recurso10_tu.setText(String.valueOf(tempo));
			});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Tempo_Recurso_Processo8(int n_recurso, int tempo){
		switch (n_recurso) {
		case 1:
			Platform.runLater(() ->{
				processo8_recurso1_tu.setText(String.valueOf(tempo));
			});
			break;
		case 2:
			Platform.runLater(() ->{
				processo8_recurso2_tu.setText(String.valueOf(tempo));
			});
			break;
		case 3:
			Platform.runLater(() ->{
				processo8_recurso3_tu.setText(String.valueOf(tempo));
			});
			break;
		case 4:
			Platform.runLater(() ->{
				processo8_recurso4_tu.setText(String.valueOf(tempo));
			});
			break;
		case 5:
			Platform.runLater(() ->{
				processo8_recurso5_tu.setText(String.valueOf(tempo));
			});
			break;
		case 6:
			Platform.runLater(() ->{
				processo8_recurso6_tu.setText(String.valueOf(tempo));
			});
			break;
		case 7:
			Platform.runLater(() ->{
				processo8_recurso7_tu.setText(String.valueOf(tempo));
			});
			break;
		case 8:
			Platform.runLater(() ->{
				processo8_recurso8_tu.setText(String.valueOf(tempo));
			});
			break;
		case 9:
			Platform.runLater(() ->{
				processo8_recurso9_tu.setText(String.valueOf(tempo));
			});
			break;
		case 10:
			Platform.runLater(() ->{
				processo8_recurso10_tu.setText(String.valueOf(tempo));
			});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Tempo_Recurso_Processo9(int n_recurso, int tempo){
		switch (n_recurso) {
		case 1:
			Platform.runLater(() ->{
				processo9_recurso1_tu.setText(String.valueOf(tempo));
			});
			break;
		case 2:
			Platform.runLater(() ->{
				processo9_recurso2_tu.setText(String.valueOf(tempo));
			});
			break;
		case 3:
			Platform.runLater(() ->{
				processo9_recurso3_tu.setText(String.valueOf(tempo));
			});
			break;
		case 4:
			Platform.runLater(() ->{
				processo9_recurso4_tu.setText(String.valueOf(tempo));
			});
			break;
		case 5:
			Platform.runLater(() ->{
				processo9_recurso5_tu.setText(String.valueOf(tempo));
			});
			break;
		case 6:
			Platform.runLater(() ->{
				processo9_recurso6_tu.setText(String.valueOf(tempo));
			});
			break;
		case 7:
			Platform.runLater(() ->{
				processo9_recurso7_tu.setText(String.valueOf(tempo));
			});
			break;
		case 8:
			Platform.runLater(() ->{
				processo9_recurso8_tu.setText(String.valueOf(tempo));
			});
			break;
		case 9:
			Platform.runLater(() ->{
				processo9_recurso9_tu.setText(String.valueOf(tempo));
			});
			break;
		case 10:
			Platform.runLater(() ->{
				processo9_recurso10_tu.setText(String.valueOf(tempo));
			});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Tempo_Recurso_Processo10(int n_recurso, int tempo){
		switch (n_recurso) {
		case 1:
			Platform.runLater(() ->{
				processo10_recurso1_tu.setText(String.valueOf(tempo));
			});
			break;
		case 2:
			Platform.runLater(() ->{
				processo10_recurso2_tu.setText(String.valueOf(tempo));
			});
			break;
		case 3:
			Platform.runLater(() ->{
				processo10_recurso3_tu.setText(String.valueOf(tempo));
			});
			break;
		case 4:
			Platform.runLater(() ->{
				processo10_recurso4_tu.setText(String.valueOf(tempo));
			});
			break;
		case 5:
			Platform.runLater(() ->{
				processo10_recurso5_tu.setText(String.valueOf(tempo));
			});
			break;
		case 6:
			Platform.runLater(() ->{
				processo10_recurso6_tu.setText(String.valueOf(tempo));
			});
			break;
		case 7:
			Platform.runLater(() ->{
				processo10_recurso7_tu.setText(String.valueOf(tempo));
			});
			break;
		case 8:
			Platform.runLater(() ->{
				processo10_recurso8_tu.setText(String.valueOf(tempo));
			});
			break;
		case 9:
			Platform.runLater(() ->{
				processo10_recurso9_tu.setText(String.valueOf(tempo));
			});
			break;
		case 10:
			Platform.runLater(() ->{
				processo10_recurso10_tu.setText(String.valueOf(tempo));
			});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Tempo_Recurso(int id_processo, int n_recurso, int tempo){
		int index = 0;
		while(processos.get(index).id != id_processo)
			index++;
		switch (index) {
		case 0:
			Mostrar_Tempo_Recurso_Processo1(n_recurso, tempo);
			break;
		case 1:
			Mostrar_Tempo_Recurso_Processo2(n_recurso, tempo);
			break;
		case 2:
			Mostrar_Tempo_Recurso_Processo3(n_recurso, tempo);
			break;
		case 3:
			Mostrar_Tempo_Recurso_Processo4(n_recurso, tempo);
			break;
		case 4:
			Mostrar_Tempo_Recurso_Processo5(n_recurso, tempo);
			break;
		case 5:
			Mostrar_Tempo_Recurso_Processo6(n_recurso, tempo);
			break;
		case 6:
			Mostrar_Tempo_Recurso_Processo7(n_recurso, tempo);
			break;
		case 7:
			Mostrar_Tempo_Recurso_Processo8(n_recurso, tempo);
			break;
		case 8:
			Mostrar_Tempo_Recurso_Processo9(n_recurso, tempo);
			break;
		case 9:
			Mostrar_Tempo_Recurso_Processo10(n_recurso, tempo);
			break;
		default:
			break;
		}
	}
	
	public void Andar_Lista_Recursos_Imagens_Processo1(){
		processo1_recurso1.setImage(processo1_recurso2.getImage());
		processo1_recurso2.setImage(processo1_recurso3.getImage());
		processo1_recurso3.setImage(processo1_recurso4.getImage());
		processo1_recurso4.setImage(processo1_recurso5.getImage());
		processo1_recurso5.setImage(processo1_recurso6.getImage());
		processo1_recurso6.setImage(processo1_recurso7.getImage());
		processo1_recurso7.setImage(processo1_recurso8.getImage());
		processo1_recurso8.setImage(processo1_recurso9.getImage());
		processo1_recurso9.setImage(processo1_recurso10.getImage());
		processo1_recurso10.setImage(null);
	}
	
	public void Andar_Lista_Recursos_Imagens_Processo2(){
		processo2_recurso1.setImage(processo2_recurso2.getImage());
		processo2_recurso2.setImage(processo2_recurso3.getImage());
		processo2_recurso3.setImage(processo2_recurso4.getImage());
		processo2_recurso4.setImage(processo2_recurso5.getImage());
		processo2_recurso5.setImage(processo2_recurso6.getImage());
		processo2_recurso6.setImage(processo2_recurso7.getImage());
		processo2_recurso7.setImage(processo2_recurso8.getImage());
		processo2_recurso8.setImage(processo2_recurso9.getImage());
		processo2_recurso9.setImage(processo2_recurso10.getImage());
		processo2_recurso10.setImage(null);
	}
	
	public void Andar_Lista_Recursos_Imagens_Processo3(){
		processo3_recurso1.setImage(processo3_recurso2.getImage());
		processo3_recurso2.setImage(processo3_recurso3.getImage());
		processo3_recurso3.setImage(processo3_recurso4.getImage());
		processo3_recurso4.setImage(processo3_recurso5.getImage());
		processo3_recurso5.setImage(processo3_recurso6.getImage());
		processo3_recurso6.setImage(processo3_recurso7.getImage());
		processo3_recurso7.setImage(processo3_recurso8.getImage());
		processo3_recurso8.setImage(processo3_recurso9.getImage());
		processo3_recurso9.setImage(processo3_recurso10.getImage());
		processo3_recurso10.setImage(null);
	}
	
	public void Andar_Lista_Recursos_Imagens_Processo4(){
		processo4_recurso1.setImage(processo4_recurso2.getImage());
		processo4_recurso2.setImage(processo4_recurso3.getImage());
		processo4_recurso3.setImage(processo4_recurso4.getImage());
		processo4_recurso4.setImage(processo4_recurso5.getImage());
		processo4_recurso5.setImage(processo4_recurso6.getImage());
		processo4_recurso6.setImage(processo4_recurso7.getImage());
		processo4_recurso7.setImage(processo4_recurso8.getImage());
		processo4_recurso8.setImage(processo4_recurso9.getImage());
		processo4_recurso9.setImage(processo4_recurso10.getImage());
		processo4_recurso10.setImage(null);
	}
	
	public void Andar_Lista_Recursos_Imagens_Processo5(){
		processo5_recurso1.setImage(processo5_recurso2.getImage());
		processo5_recurso2.setImage(processo5_recurso3.getImage());
		processo5_recurso3.setImage(processo5_recurso4.getImage());
		processo5_recurso4.setImage(processo5_recurso5.getImage());
		processo5_recurso5.setImage(processo5_recurso6.getImage());
		processo5_recurso6.setImage(processo5_recurso7.getImage());
		processo5_recurso7.setImage(processo5_recurso8.getImage());
		processo5_recurso8.setImage(processo5_recurso9.getImage());
		processo5_recurso9.setImage(processo5_recurso10.getImage());
		processo5_recurso10.setImage(null);
	}
	
	public void Andar_Lista_Recursos_Imagens_Processo6(){
		processo6_recurso1.setImage(processo6_recurso2.getImage());
		processo6_recurso2.setImage(processo6_recurso3.getImage());
		processo6_recurso3.setImage(processo6_recurso4.getImage());
		processo6_recurso4.setImage(processo6_recurso5.getImage());
		processo6_recurso5.setImage(processo6_recurso6.getImage());
		processo6_recurso6.setImage(processo6_recurso7.getImage());
		processo6_recurso7.setImage(processo6_recurso8.getImage());
		processo6_recurso8.setImage(processo6_recurso9.getImage());
		processo6_recurso9.setImage(processo6_recurso10.getImage());
		processo6_recurso10.setImage(null);
	}
	
	public void Andar_Lista_Recursos_Imagens_Processo7(){
		processo7_recurso1.setImage(processo7_recurso2.getImage());
		processo7_recurso2.setImage(processo7_recurso3.getImage());
		processo7_recurso3.setImage(processo7_recurso4.getImage());
		processo7_recurso4.setImage(processo7_recurso5.getImage());
		processo7_recurso5.setImage(processo7_recurso6.getImage());
		processo7_recurso6.setImage(processo7_recurso7.getImage());
		processo7_recurso7.setImage(processo7_recurso8.getImage());
		processo7_recurso8.setImage(processo7_recurso9.getImage());
		processo7_recurso9.setImage(processo7_recurso10.getImage());
		processo7_recurso10.setImage(null);
	}
	
	public void Andar_Lista_Recursos_Imagens_Processo8(){
		processo8_recurso1.setImage(processo8_recurso2.getImage());
		processo8_recurso2.setImage(processo8_recurso3.getImage());
		processo8_recurso3.setImage(processo8_recurso4.getImage());
		processo8_recurso4.setImage(processo8_recurso5.getImage());
		processo8_recurso5.setImage(processo8_recurso6.getImage());
		processo8_recurso6.setImage(processo8_recurso7.getImage());
		processo8_recurso7.setImage(processo8_recurso8.getImage());
		processo8_recurso8.setImage(processo8_recurso9.getImage());
		processo8_recurso9.setImage(processo8_recurso10.getImage());
		processo8_recurso10.setImage(null);
	}
	
	public void Andar_Lista_Recursos_Imagens_Processo9(){
		processo9_recurso1.setImage(processo9_recurso2.getImage());
		processo9_recurso2.setImage(processo9_recurso3.getImage());
		processo9_recurso3.setImage(processo9_recurso4.getImage());
		processo9_recurso4.setImage(processo9_recurso5.getImage());
		processo9_recurso5.setImage(processo9_recurso6.getImage());
		processo9_recurso6.setImage(processo9_recurso7.getImage());
		processo9_recurso7.setImage(processo9_recurso8.getImage());
		processo9_recurso8.setImage(processo9_recurso9.getImage());
		processo9_recurso9.setImage(processo9_recurso10.getImage());
		processo9_recurso10.setImage(null);
	}
	
	public void Andar_Lista_Recursos_Imagens_Processo10(){
		processo10_recurso1.setImage(processo10_recurso2.getImage());
		processo10_recurso2.setImage(processo10_recurso3.getImage());
		processo10_recurso3.setImage(processo10_recurso4.getImage());
		processo10_recurso4.setImage(processo10_recurso5.getImage());
		processo10_recurso5.setImage(processo10_recurso6.getImage());
		processo10_recurso6.setImage(processo10_recurso7.getImage());
		processo10_recurso7.setImage(processo10_recurso8.getImage());
		processo10_recurso8.setImage(processo10_recurso9.getImage());
		processo10_recurso9.setImage(processo10_recurso10.getImage());
		processo10_recurso10.setImage(null);
	}
	
	public void Andar_Lista_Tempos_Recursos1(){
		Platform.runLater(() ->{processo1_recurso1_tu.setText(processo1_recurso2_tu.getText());});
		Platform.runLater(() ->{processo1_recurso2_tu.setText(processo1_recurso3_tu.getText());});
		Platform.runLater(() ->{processo1_recurso3_tu.setText(processo1_recurso4_tu.getText());});
		Platform.runLater(() ->{processo1_recurso4_tu.setText(processo1_recurso5_tu.getText());});
		Platform.runLater(() ->{processo1_recurso5_tu.setText(processo1_recurso6_tu.getText());});
		Platform.runLater(() ->{processo1_recurso6_tu.setText(processo1_recurso7_tu.getText());});
		Platform.runLater(() ->{processo1_recurso7_tu.setText(processo1_recurso8_tu.getText());});
		Platform.runLater(() ->{processo1_recurso8_tu.setText(processo1_recurso9_tu.getText());});
		Platform.runLater(() ->{processo1_recurso9_tu.setText(processo1_recurso10_tu.getText());});
		Platform.runLater(() ->{processo1_recurso10_tu.setText("");});
	}
	
	public void Andar_Lista_Tempos_Recursos2(){
		Platform.runLater(() ->{processo2_recurso1_tu.setText(processo2_recurso2_tu.getText());});
		Platform.runLater(() ->{processo2_recurso2_tu.setText(processo2_recurso3_tu.getText());});
		Platform.runLater(() ->{processo2_recurso3_tu.setText(processo2_recurso4_tu.getText());});
		Platform.runLater(() ->{processo2_recurso4_tu.setText(processo2_recurso5_tu.getText());});
		Platform.runLater(() ->{processo2_recurso5_tu.setText(processo2_recurso6_tu.getText());});
		Platform.runLater(() ->{processo2_recurso6_tu.setText(processo2_recurso7_tu.getText());});
		Platform.runLater(() ->{processo2_recurso7_tu.setText(processo2_recurso8_tu.getText());});
		Platform.runLater(() ->{processo2_recurso8_tu.setText(processo2_recurso9_tu.getText());});
		Platform.runLater(() ->{processo2_recurso9_tu.setText(processo2_recurso10_tu.getText());});
		Platform.runLater(() ->{processo2_recurso10_tu.setText("");});
	}
	
	public void Andar_Lista_Tempos_Recursos3(){
		Platform.runLater(() ->{processo3_recurso1_tu.setText(processo3_recurso2_tu.getText());});
		Platform.runLater(() ->{processo3_recurso2_tu.setText(processo3_recurso3_tu.getText());});
		Platform.runLater(() ->{processo3_recurso3_tu.setText(processo3_recurso4_tu.getText());});
		Platform.runLater(() ->{processo3_recurso4_tu.setText(processo3_recurso5_tu.getText());});
		Platform.runLater(() ->{processo3_recurso5_tu.setText(processo3_recurso6_tu.getText());});
		Platform.runLater(() ->{processo3_recurso6_tu.setText(processo3_recurso7_tu.getText());});
		Platform.runLater(() ->{processo3_recurso7_tu.setText(processo3_recurso8_tu.getText());});
		Platform.runLater(() ->{processo3_recurso8_tu.setText(processo3_recurso9_tu.getText());});
		Platform.runLater(() ->{processo3_recurso9_tu.setText(processo3_recurso10_tu.getText());});
		Platform.runLater(() ->{processo3_recurso10_tu.setText("");});
	}
	
	public void Andar_Lista_Tempos_Recursos4(){
		Platform.runLater(() ->{processo4_recurso1_tu.setText(processo4_recurso2_tu.getText());});
		Platform.runLater(() ->{processo4_recurso2_tu.setText(processo4_recurso3_tu.getText());});
		Platform.runLater(() ->{processo4_recurso3_tu.setText(processo4_recurso4_tu.getText());});
		Platform.runLater(() ->{processo4_recurso4_tu.setText(processo4_recurso5_tu.getText());});
		Platform.runLater(() ->{processo4_recurso5_tu.setText(processo4_recurso6_tu.getText());});
		Platform.runLater(() ->{processo4_recurso6_tu.setText(processo4_recurso7_tu.getText());});
		Platform.runLater(() ->{processo4_recurso7_tu.setText(processo4_recurso8_tu.getText());});
		Platform.runLater(() ->{processo4_recurso8_tu.setText(processo4_recurso9_tu.getText());});
		Platform.runLater(() ->{processo4_recurso9_tu.setText(processo4_recurso10_tu.getText());});
		Platform.runLater(() ->{processo4_recurso10_tu.setText("");});
	}
	
	public void Andar_Lista_Tempos_Recursos5(){
		Platform.runLater(() ->{processo5_recurso1_tu.setText(processo5_recurso2_tu.getText());});
		Platform.runLater(() ->{processo5_recurso2_tu.setText(processo5_recurso3_tu.getText());});
		Platform.runLater(() ->{processo5_recurso3_tu.setText(processo5_recurso4_tu.getText());});
		Platform.runLater(() ->{processo5_recurso4_tu.setText(processo5_recurso5_tu.getText());});
		Platform.runLater(() ->{processo5_recurso5_tu.setText(processo5_recurso6_tu.getText());});
		Platform.runLater(() ->{processo5_recurso6_tu.setText(processo5_recurso7_tu.getText());});
		Platform.runLater(() ->{processo5_recurso7_tu.setText(processo5_recurso8_tu.getText());});
		Platform.runLater(() ->{processo5_recurso8_tu.setText(processo5_recurso9_tu.getText());});
		Platform.runLater(() ->{processo5_recurso9_tu.setText(processo5_recurso10_tu.getText());});
		Platform.runLater(() ->{processo5_recurso10_tu.setText("");});
	}
	
	public void Andar_Lista_Tempos_Recursos6(){
		Platform.runLater(() ->{processo6_recurso1_tu.setText(processo6_recurso2_tu.getText());});
		Platform.runLater(() ->{processo6_recurso2_tu.setText(processo6_recurso3_tu.getText());});
		Platform.runLater(() ->{processo6_recurso3_tu.setText(processo6_recurso4_tu.getText());});
		Platform.runLater(() ->{processo6_recurso4_tu.setText(processo6_recurso5_tu.getText());});
		Platform.runLater(() ->{processo6_recurso5_tu.setText(processo6_recurso6_tu.getText());});
		Platform.runLater(() ->{processo6_recurso6_tu.setText(processo6_recurso7_tu.getText());});
		Platform.runLater(() ->{processo6_recurso7_tu.setText(processo6_recurso8_tu.getText());});
		Platform.runLater(() ->{processo6_recurso8_tu.setText(processo6_recurso9_tu.getText());});
		Platform.runLater(() ->{processo6_recurso9_tu.setText(processo6_recurso10_tu.getText());});
		Platform.runLater(() ->{processo6_recurso10_tu.setText("");});
	}
	
	public void Andar_Lista_Tempos_Recursos7(){
		Platform.runLater(() ->{processo7_recurso1_tu.setText(processo7_recurso2_tu.getText());});
		Platform.runLater(() ->{processo7_recurso2_tu.setText(processo7_recurso3_tu.getText());});
		Platform.runLater(() ->{processo7_recurso3_tu.setText(processo7_recurso4_tu.getText());});
		Platform.runLater(() ->{processo7_recurso4_tu.setText(processo7_recurso5_tu.getText());});
		Platform.runLater(() ->{processo7_recurso5_tu.setText(processo7_recurso6_tu.getText());});
		Platform.runLater(() ->{processo7_recurso6_tu.setText(processo7_recurso7_tu.getText());});
		Platform.runLater(() ->{processo7_recurso7_tu.setText(processo7_recurso8_tu.getText());});
		Platform.runLater(() ->{processo7_recurso8_tu.setText(processo7_recurso9_tu.getText());});
		Platform.runLater(() ->{processo7_recurso9_tu.setText(processo7_recurso10_tu.getText());});
		Platform.runLater(() ->{processo7_recurso10_tu.setText("");});
	}
	
	public void Andar_Lista_Tempos_Recursos8(){
		Platform.runLater(() ->{processo8_recurso1_tu.setText(processo8_recurso2_tu.getText());});
		Platform.runLater(() ->{processo8_recurso2_tu.setText(processo8_recurso3_tu.getText());});
		Platform.runLater(() ->{processo8_recurso3_tu.setText(processo8_recurso4_tu.getText());});
		Platform.runLater(() ->{processo8_recurso4_tu.setText(processo8_recurso5_tu.getText());});
		Platform.runLater(() ->{processo8_recurso5_tu.setText(processo8_recurso6_tu.getText());});
		Platform.runLater(() ->{processo8_recurso6_tu.setText(processo8_recurso7_tu.getText());});
		Platform.runLater(() ->{processo8_recurso7_tu.setText(processo8_recurso8_tu.getText());});
		Platform.runLater(() ->{processo8_recurso8_tu.setText(processo8_recurso9_tu.getText());});
		Platform.runLater(() ->{processo8_recurso9_tu.setText(processo8_recurso10_tu.getText());});
		Platform.runLater(() ->{processo8_recurso10_tu.setText("");});
	}
	
	public void Andar_Lista_Tempos_Recursos9(){
		Platform.runLater(() ->{processo9_recurso1_tu.setText(processo9_recurso2_tu.getText());});
		Platform.runLater(() ->{processo9_recurso2_tu.setText(processo9_recurso3_tu.getText());});
		Platform.runLater(() ->{processo9_recurso3_tu.setText(processo9_recurso4_tu.getText());});
		Platform.runLater(() ->{processo9_recurso4_tu.setText(processo9_recurso5_tu.getText());});
		Platform.runLater(() ->{processo9_recurso5_tu.setText(processo9_recurso6_tu.getText());});
		Platform.runLater(() ->{processo9_recurso6_tu.setText(processo9_recurso7_tu.getText());});
		Platform.runLater(() ->{processo9_recurso7_tu.setText(processo9_recurso8_tu.getText());});
		Platform.runLater(() ->{processo9_recurso8_tu.setText(processo9_recurso9_tu.getText());});
		Platform.runLater(() ->{processo9_recurso9_tu.setText(processo9_recurso10_tu.getText());});
		Platform.runLater(() ->{processo9_recurso10_tu.setText("");});
	}
	
	public void Andar_Lista_Tempos_Recursos10(){
		Platform.runLater(() ->{processo10_recurso1_tu.setText(processo10_recurso2_tu.getText());});
		Platform.runLater(() ->{processo10_recurso2_tu.setText(processo10_recurso3_tu.getText());});
		Platform.runLater(() ->{processo10_recurso3_tu.setText(processo10_recurso4_tu.getText());});
		Platform.runLater(() ->{processo10_recurso4_tu.setText(processo10_recurso5_tu.getText());});
		Platform.runLater(() ->{processo10_recurso5_tu.setText(processo10_recurso6_tu.getText());});
		Platform.runLater(() ->{processo10_recurso6_tu.setText(processo10_recurso7_tu.getText());});
		Platform.runLater(() ->{processo10_recurso7_tu.setText(processo10_recurso8_tu.getText());});
		Platform.runLater(() ->{processo10_recurso8_tu.setText(processo10_recurso9_tu.getText());});
		Platform.runLater(() ->{processo10_recurso9_tu.setText(processo10_recurso10_tu.getText());});
		Platform.runLater(() ->{processo10_recurso10_tu.setText("");});
	}
	
	public void Andar_Lista_Recursos_Imagens_Processo(int id_processo){
		int index = 0;
		while(processos.get(index).id != id_processo)
			index++;
		switch (index) {
		case 0:
			Platform.runLater(() -> {Andar_Lista_Recursos_Imagens_Processo1();});
			Andar_Lista_Tempos_Recursos1();
			break;
		case 1:
			Platform.runLater(() -> {Andar_Lista_Recursos_Imagens_Processo2();});
			Andar_Lista_Tempos_Recursos2();
			break;
		case 2:
			Platform.runLater(() -> {Andar_Lista_Recursos_Imagens_Processo3();});
			Andar_Lista_Tempos_Recursos3();
			break;
		case 3:
			Platform.runLater(() -> {Andar_Lista_Recursos_Imagens_Processo4();});
			Andar_Lista_Tempos_Recursos4();
			break;
		case 4:
			Platform.runLater(() -> {Andar_Lista_Recursos_Imagens_Processo5();});
			Andar_Lista_Tempos_Recursos5();
			break;
		case 5:
			Platform.runLater(() -> {Andar_Lista_Recursos_Imagens_Processo6();});
			Andar_Lista_Tempos_Recursos6();
			break;
		case 6:
			Platform.runLater(() -> {Andar_Lista_Recursos_Imagens_Processo7();});
			Andar_Lista_Tempos_Recursos7();
			break;
		case 7:
			Platform.runLater(() -> {Andar_Lista_Recursos_Imagens_Processo8();});
			Andar_Lista_Tempos_Recursos8();
			break;
		case 8:
			Platform.runLater(() -> {Andar_Lista_Recursos_Imagens_Processo9();});
			Andar_Lista_Tempos_Recursos9();
			break;
		case 9:
			Platform.runLater(() -> {Andar_Lista_Recursos_Imagens_Processo10();});
			Andar_Lista_Tempos_Recursos10();
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Status_Processo1(String status, Color cor){
		Platform.runLater(() -> {processo1_status.setText(status);});
		Platform.runLater(() -> {processo1_status.setTextFill(cor);});
	}
	
	public void Mostrar_Status_Processo2(String status, Color cor){
		Platform.runLater(() -> {processo2_status.setText(status);});
		Platform.runLater(() -> {processo2_status.setTextFill(cor);});
	}
	
	public void Mostrar_Status_Processo3(String status, Color cor){
		Platform.runLater(() -> {processo3_status.setText(status);});
		Platform.runLater(() -> {processo3_status.setTextFill(cor);});
	}
	
	public void Mostrar_Status_Processo4(String status, Color cor){
		Platform.runLater(() -> {processo4_status.setText(status);});
		Platform.runLater(() -> {processo4_status.setTextFill(cor);});
	}
	
	public void Mostrar_Status_Processo5(String status, Color cor){
		Platform.runLater(() -> {processo5_status.setText(status);});
		Platform.runLater(() -> {processo5_status.setTextFill(cor);});
	}
	
	public void Mostrar_Status_Processo6(String status, Color cor){
		Platform.runLater(() -> {processo6_status.setText(status);});
		Platform.runLater(() -> {processo6_status.setTextFill(cor);});
	}
	
	public void Mostrar_Status_Processo7(String status, Color cor){
		Platform.runLater(() -> {processo7_status.setText(status);});
		Platform.runLater(() -> {processo7_status.setTextFill(cor);});
	}
	
	public void Mostrar_Status_Processo8(String status, Color cor){
		Platform.runLater(() -> {processo8_status.setText(status);});
		Platform.runLater(() -> {processo8_status.setTextFill(cor);});
	}
	
	public void Mostrar_Status_Processo9(String status, Color cor){
		Platform.runLater(() -> {processo9_status.setText(status);});
		Platform.runLater(() -> {processo9_status.setTextFill(cor);});
	}
	
	public void Mostrar_Status_Processo10(String status, Color cor){
		Platform.runLater(() -> {processo10_status.setText(status);});
		Platform.runLater(() -> {processo10_status.setTextFill(cor);});
	}
	
	public void Mostrar_Status_Processo(int id_processo, String status, Color cor){
		int index = 0;
		while(processos.get(index).id != id_processo)
			index++;
		switch (index) {
		case 0:
			Mostrar_Status_Processo1(status, cor);
			break;
		case 1:
			Mostrar_Status_Processo2(status, cor);
			break;
		case 2:
			Mostrar_Status_Processo3(status, cor);
			break;
		case 3:
			Mostrar_Status_Processo4(status, cor);
			break;
		case 4:
			Mostrar_Status_Processo5(status, cor);
			break;
		case 5:
			Mostrar_Status_Processo6(status, cor);
			break;
		case 6:
			Mostrar_Status_Processo7(status, cor);
			break;
		case 7:
			Mostrar_Status_Processo8(status, cor);
			break;
		case 8:
			Mostrar_Status_Processo9(status, cor);
			break;
		case 9:
			Mostrar_Status_Processo10(status, cor);
			break;
		default:
			break;
		}
	}
	
	public void Setar_Imagens_Grafo(int indice){
		switch (indice) {
		case 1:
			grafo_processo1.setImage(processos.get(0).img);
			break;
		case 2:
			grafo_processo2.setImage(processos.get(1).img);
			break;
		case 3:
			grafo_processo3.setImage(processos.get(2).img);
			break;
		case 4:
			grafo_processo4.setImage(processos.get(3).img);
			break;
		case 5:
			grafo_processo5.setImage(processos.get(4).img);
			break;
		case 6:
			grafo_processo6.setImage(processos.get(5).img);
			break;
		case 7:
			grafo_processo7.setImage(processos.get(6).img);
			break;
		case 8:
			grafo_processo8.setImage(processos.get(7).img);
			break;
		case 9:
			grafo_processo9.setImage(processos.get(8).img);
			break;
		case 10:
			grafo_processo10.setImage(processos.get(9).img);
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Informacoes_Ciclo_Processo1(String status){
		switch (status) {
		case "LIVRE":
			Platform.runLater(() -> {grafo_processo1.setEffect(null);});
			Platform.runLater(() -> {processo1.setEffect(null);});
			Platform.runLater(() -> {
				if(processo1_status.getText().equals("STATUS: DEADLOCK")){
					if(!processos.get(0).bloqueado){
						processo1_status.setText("STATUS: RODANDO");
						processo1_status.setTextFill(Color.BLACK);
					}
					else{
						processo1_status.setText("STATUS: BLOQUEADO");
						processo1_status.setTextFill(Color.BLUE);
					}
				}
				if(processo1_status.getText().equals("STATUS: IMPEDIDO")){
					if(!processos.get(0).bloqueado){
						processo1_status.setText("STATUS: RODANDO");
					processo1_status.setTextFill(Color.BLACK);
					}
					else{
						processo1_status.setText("STATUS: BLOQUEADO");
						processo1_status.setTextFill(Color.BLUE);
					}
				}
			});
			Platform.runLater(() -> {processo1_status.setTextFill(Color.BLACK);});
			Platform.runLater(() -> {p1_pane.setEffect(null);});
			break;
		case "DEADLOCK":
			Platform.runLater(() -> {grafo_processo1.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo1.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo1_status.setText("STATUS: DEADLOCK");});
			Platform.runLater(() -> {processo1_status.setTextFill(Color.RED);});
			Platform.runLater(() -> {p1_pane.setEffect(contorno_bloqueado);});
			break;	
		case "IMPEDIDO":
			Platform.runLater(() -> {grafo_processo1.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo1.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo1_status.setText("STATUS: IMPEDIDO");});
			Platform.runLater(() -> {processo1_status.setTextFill(Color.BLUE);});
			Platform.runLater(() -> {p1_pane.setEffect(contorno_impedido);});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Informacoes_Ciclo_Processo2(String status){
		switch (status) {
		case "LIVRE":
			Platform.runLater(() -> {grafo_processo2.setEffect(null);});
			Platform.runLater(() -> {processo2.setEffect(null);});
			Platform.runLater(() -> {
				if(processo2_status.getText().equals("STATUS: DEADLOCK")){
					if(!processos.get(1).bloqueado){
						processo2_status.setText("STATUS: RODANDO");
						processo2_status.setTextFill(Color.BLACK);
					}
					else{
						processo2_status.setText("STATUS: BLOQUEADO");
						processo2_status.setTextFill(Color.BLUE);
					}
				}
				if(processo2_status.getText().equals("STATUS: IMPEDIDO")){
					if(!processos.get(1).bloqueado){
						processo2_status.setText("STATUS: RODANDO");
						processo2_status.setTextFill(Color.BLACK);
					}
					else{
						processo2_status.setText("STATUS: BLOQUEADO");
						processo2_status.setTextFill(Color.BLUE);
					}
				}
			});
			Platform.runLater(() -> {processo2_status.setTextFill(Color.BLACK);});
			Platform.runLater(() -> {p2_pane.setEffect(null);});
			break;
		case "DEADLOCK":
			Platform.runLater(() -> {grafo_processo2.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo2.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo2_status.setText("STATUS: DEADLOCK");});
			Platform.runLater(() -> {processo2_status.setTextFill(Color.RED);});
			Platform.runLater(() -> {p2_pane.setEffect(contorno_bloqueado);});
			break;	
		case "IMPEDIDO":
			Platform.runLater(() -> {grafo_processo2.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo2.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo2_status.setText("STATUS: IMPEDIDO");});
			Platform.runLater(() -> {processo2_status.setTextFill(Color.BLUE);});
			Platform.runLater(() -> {p2_pane.setEffect(contorno_impedido);});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Informacoes_Ciclo_Processo3(String status){
		switch (status) {
		case "LIVRE":
			Platform.runLater(() -> {grafo_processo3.setEffect(null);});
			Platform.runLater(() -> {processo3.setEffect(null);});
			Platform.runLater(() -> {
				if(processo3_status.getText().equals("STATUS: DEADLOCK")){
					if(!processos.get(2).bloqueado){
						processo3_status.setText("STATUS: RODANDO");
						processo3_status.setTextFill(Color.BLACK);
					}
					else{
						processo3_status.setText("STATUS: BLOQUEADO");
						processo3_status.setTextFill(Color.BLUE);
					}
				}
				if(processo3_status.getText().equals("STATUS: IMPEDIDO")){
					if(!processos.get(2).bloqueado){
						processo3_status.setText("STATUS: RODANDO");
						processo3_status.setTextFill(Color.BLACK);
					}
					else{
						processo3_status.setText("STATUS: BLOQUEADO");
						processo3_status.setTextFill(Color.BLUE);
					}
				}
			});
			Platform.runLater(() -> {processo3_status.setTextFill(Color.BLACK);});
			Platform.runLater(() -> {p3_pane.setEffect(null);});
			break;
		case "DEADLOCK":
			Platform.runLater(() -> {grafo_processo3.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo3.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo3_status.setText("STATUS: DEADLOCK");});
			Platform.runLater(() -> {processo3_status.setTextFill(Color.RED);});
			Platform.runLater(() -> {p3_pane.setEffect(contorno_bloqueado);});
			break;	
		case "IMPEDIDO":
			Platform.runLater(() -> {grafo_processo3.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo3.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo3_status.setText("STATUS: IMPEDIDO");});
			Platform.runLater(() -> {processo3_status.setTextFill(Color.BLUE);});
			Platform.runLater(() -> {p3_pane.setEffect(contorno_impedido);});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Informacoes_Ciclo_Processo4(String status){
		switch (status) {
		case "LIVRE":
			Platform.runLater(() -> {grafo_processo4.setEffect(null);});
			Platform.runLater(() -> {processo4.setEffect(null);});
			Platform.runLater(() -> {
				if(processo4_status.getText().equals("STATUS: DEADLOCK")){
					if(!processos.get(3).bloqueado){
						processo4_status.setText("STATUS: RODANDO");
						processo4_status.setTextFill(Color.BLACK);
					}
					else{
						processo4_status.setText("STATUS: BLOQUEADO");
						processo4_status.setTextFill(Color.BLUE);
					}
				}
				if(processo4_status.getText().equals("STATUS: IMPEDIDO")){
					if(!processos.get(3).bloqueado){
						processo4_status.setText("STATUS: RODANDO");
						processo4_status.setTextFill(Color.BLACK);
					}
					else{
						processo4_status.setText("STATUS: BLOQUEADO");
						processo4_status.setTextFill(Color.BLUE);
					}
				}
			});
			Platform.runLater(() -> {processo4_status.setTextFill(Color.BLACK);});
			Platform.runLater(() -> {p4_pane.setEffect(null);});
			break;
		case "DEADLOCK":
			Platform.runLater(() -> {grafo_processo4.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo4.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo4_status.setText("STATUS: DEADLOCK");});
			Platform.runLater(() -> {processo4_status.setTextFill(Color.RED);});
			Platform.runLater(() -> {p4_pane.setEffect(contorno_bloqueado);});
			break;	
		case "IMPEDIDO":
			Platform.runLater(() -> {grafo_processo4.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo4.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo4_status.setText("STATUS: IMPEDIDO");});
			Platform.runLater(() -> {processo4_status.setTextFill(Color.BLUE);});
			Platform.runLater(() -> {p4_pane.setEffect(contorno_impedido);});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Informacoes_Ciclo_Processo5(String status){
		switch (status) {
		case "LIVRE":
			Platform.runLater(() -> {grafo_processo5.setEffect(null);});
			Platform.runLater(() -> {processo5.setEffect(null);});
			Platform.runLater(() -> {
				if(processo5_status.getText().equals("STATUS: DEADLOCK")){
					if(!processos.get(4).bloqueado){
						processo5_status.setText("STATUS: RODANDO");
						processo5_status.setTextFill(Color.BLACK);
					}
					else{
						processo5_status.setText("STATUS: BLOQUEADO");
						processo5_status.setTextFill(Color.BLUE);
					}
				}
				if(processo5_status.getText().equals("STATUS: IMPEDIDO")){
					if(!processos.get(4).bloqueado){
						processo5_status.setText("STATUS: RODANDO");
						processo5_status.setTextFill(Color.BLACK);
					}
					else{
						processo5_status.setText("STATUS: BLOQUEADO");
						processo5_status.setTextFill(Color.BLUE);
					}
				}
			});
			Platform.runLater(() -> {processo5_status.setTextFill(Color.BLACK);});
			Platform.runLater(() -> {p5_pane.setEffect(null);});
			break;
		case "DEADLOCK":
			Platform.runLater(() -> {grafo_processo5.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo5.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo5_status.setText("STATUS: DEADLOCK");});
			Platform.runLater(() -> {processo5_status.setTextFill(Color.RED);});
			Platform.runLater(() -> {p5_pane.setEffect(contorno_bloqueado);});
			break;	
		case "IMPEDIDO":
			Platform.runLater(() -> {grafo_processo5.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo5.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo5_status.setText("STATUS: IMPEDIDO");});
			Platform.runLater(() -> {processo5_status.setTextFill(Color.BLUE);});
			Platform.runLater(() -> {p5_pane.setEffect(contorno_impedido);});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Informacoes_Ciclo_Processo6(String status){
		switch (status) {
		case "LIVRE":
			Platform.runLater(() -> {grafo_processo6.setEffect(null);});
			Platform.runLater(() -> {processo6.setEffect(null);});
			Platform.runLater(() -> {
				if(processo6_status.getText().equals("STATUS: DEADLOCK")){
					if(!processos.get(5).bloqueado){
						processo6_status.setText("STATUS: RODANDO");
						processo6_status.setTextFill(Color.BLACK);
					}
					else{
						processo6_status.setText("STATUS: BLOQUEADO");
						processo6_status.setTextFill(Color.BLUE);
					}
				}
				if(processo6_status.getText().equals("STATUS: IMPEDIDO")){
					if(!processos.get(5).bloqueado){
						processo6_status.setText("STATUS: RODANDO");
						processo6_status.setTextFill(Color.BLACK);
					}
					else{
						processo6_status.setText("STATUS: BLOQUEADO");
						processo6_status.setTextFill(Color.BLUE);
					}
				}
			});
			Platform.runLater(() -> {processo6_status.setTextFill(Color.BLACK);});
			Platform.runLater(() -> {p6_pane.setEffect(null);});
			break;
		case "DEADLOCK":
			Platform.runLater(() -> {grafo_processo6.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo6.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo6_status.setText("STATUS: DEADLOCK");});
			Platform.runLater(() -> {processo6_status.setTextFill(Color.RED);});
			Platform.runLater(() -> {p6_pane.setEffect(contorno_bloqueado);});
			break;	
		case "IMPEDIDO":
			Platform.runLater(() -> {grafo_processo6.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo6.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo6_status.setText("STATUS: IMPEDIDO");});
			Platform.runLater(() -> {processo6_status.setTextFill(Color.BLUE);});
			Platform.runLater(() -> {p6_pane.setEffect(contorno_impedido);});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Informacoes_Ciclo_Processo7(String status){
		switch (status) {
		case "LIVRE":
			Platform.runLater(() -> {grafo_processo7.setEffect(null);});
			Platform.runLater(() -> {processo7.setEffect(null);});
			Platform.runLater(() -> {
				if(processo7_status.getText().equals("STATUS: DEADLOCK")){
					if(!processos.get(6).bloqueado){
						processo7_status.setText("STATUS: RODANDO");
						processo7_status.setTextFill(Color.BLACK);
					}
					else{
						processo7_status.setText("STATUS: BLOQUEADO");
						processo7_status.setTextFill(Color.BLUE);
					}
					
				}
				if(processo7_status.getText().equals("STATUS: IMPEDIDO")){
					if(!processos.get(6).bloqueado){
						processo7_status.setText("STATUS: RODANDO");
						processo7_status.setTextFill(Color.BLACK);
					}
					else{
						processo7_status.setText("STATUS: BLOQUEADO");
						processo7_status.setTextFill(Color.BLUE);
					}
				}
			});
			Platform.runLater(() -> {processo7_status.setTextFill(Color.BLACK);});
			Platform.runLater(() -> {p7_pane.setEffect(null);});
			break;
		case "DEADLOCK":
			Platform.runLater(() -> {grafo_processo7.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo7.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo7_status.setText("STATUS: DEADLOCK");});
			Platform.runLater(() -> {processo7_status.setTextFill(Color.RED);});
			Platform.runLater(() -> {p7_pane.setEffect(contorno_bloqueado);});
			break;	
		case "IMPEDIDO":
			Platform.runLater(() -> {grafo_processo7.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo7.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo7_status.setText("STATUS: IMPEDIDO");});
			Platform.runLater(() -> {processo7_status.setTextFill(Color.BLUE);});
			Platform.runLater(() -> {p7_pane.setEffect(contorno_impedido);});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Informacoes_Ciclo_Processo8(String status){
		switch (status) {
		case "LIVRE":
			Platform.runLater(() -> {grafo_processo8.setEffect(null);});
			Platform.runLater(() -> {processo8.setEffect(null);});
			Platform.runLater(() -> {
				if(processo8_status.getText().equals("STATUS: DEADLOCK")){
					if(!processos.get(7).bloqueado){
						processo8_status.setText("STATUS: RODANDO");
						processo8_status.setTextFill(Color.BLACK);
					}
					else{
						processo8_status.setText("STATUS: BLOQUEADO");
						processo8_status.setTextFill(Color.BLUE);
					}
				}
				if(processo8_status.getText().equals("STATUS: IMPEDIDO")){
					if(!processos.get(7).bloqueado){
						processo8_status.setText("STATUS: RODANDO");
						processo8_status.setTextFill(Color.BLACK);
					}
					else{
						processo8_status.setText("STATUS: BLOQUEADO");
						processo8_status.setTextFill(Color.BLUE);
					}
				}
			});
			Platform.runLater(() -> {processo8_status.setTextFill(Color.BLACK);});
			Platform.runLater(() -> {p8_pane.setEffect(null);});
			break;
		case "DEADLOCK":
			Platform.runLater(() -> {grafo_processo8.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo8.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo8_status.setText("STATUS: DEADLOCK");});
			Platform.runLater(() -> {processo8_status.setTextFill(Color.RED);});
			Platform.runLater(() -> {p8_pane.setEffect(contorno_bloqueado);});
			break;	
		case "IMPEDIDO":
			Platform.runLater(() -> {grafo_processo8.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo8.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo8_status.setText("STATUS: IMPEDIDO");});
			Platform.runLater(() -> {processo8_status.setTextFill(Color.BLUE);});
			Platform.runLater(() -> {p8_pane.setEffect(contorno_impedido);});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Informacoes_Ciclo_Processo9(String status){
		switch (status) {
		case "LIVRE":
			Platform.runLater(() -> {grafo_processo9.setEffect(null);});
			Platform.runLater(() -> {processo9.setEffect(null);});
			Platform.runLater(() -> {
				if(processo9_status.getText().equals("STATUS: DEADLOCK")){
					if(!processos.get(8).bloqueado){
						processo9_status.setText("STATUS: RODANDO");
						processo9_status.setTextFill(Color.BLACK);
					}
					else{
						processo9_status.setText("STATUS: BLOQUEADO");
						processo9_status.setTextFill(Color.BLUE);
					}
				}
				if(processo9_status.getText().equals("STATUS: IMPEDIDO")){
					if(!processos.get(8).bloqueado){
						processo9_status.setText("STATUS: RODANDO");
						processo9_status.setTextFill(Color.BLACK);
					}
					else{
						processo9_status.setText("STATUS: BLOQUEADO");
						processo9_status.setTextFill(Color.BLUE);
					}
				}
			});
			Platform.runLater(() -> {processo9_status.setTextFill(Color.BLACK);});
			Platform.runLater(() -> {p9_pane.setEffect(null);});
			break;
		case "DEADLOCK":
			Platform.runLater(() -> {grafo_processo9.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo9.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo9_status.setText("STATUS: DEADLOCK");});
			Platform.runLater(() -> {processo9_status.setTextFill(Color.RED);});
			Platform.runLater(() -> {p9_pane.setEffect(contorno_bloqueado);});
			break;	
		case "IMPEDIDO":
			Platform.runLater(() -> {grafo_processo9.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo9.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo9_status.setText("STATUS: IMPEDIDO");});
			Platform.runLater(() -> {processo9_status.setTextFill(Color.BLUE);});
			Platform.runLater(() -> {p9_pane.setEffect(contorno_impedido);});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Informacoes_Ciclo_Processo10(String status){
		switch (status) {
		case "LIVRE":
			Platform.runLater(() -> {grafo_processo10.setEffect(null);});
			Platform.runLater(() -> {processo10.setEffect(null);});
			Platform.runLater(() -> {
				if(processo10_status.getText().equals("STATUS: DEADLOCK")){
					if(!processos.get(9).bloqueado){
						processo10_status.setText("STATUS: RODANDO");
						processo10_status.setTextFill(Color.BLACK);
					}
					else{
						processo10_status.setText("STATUS: BLOQUEADO");
						processo10_status.setTextFill(Color.BLUE);
					}
				}
				if(processo10_status.getText().equals("STATUS: IMPEDIDO")){
					if(!processos.get(9).bloqueado){
						processo10_status.setText("STATUS: RODANDO");
						processo10_status.setTextFill(Color.BLACK);
					}
					else{
						processo10_status.setText("STATUS: BLOQUEADO");
						processo10_status.setTextFill(Color.BLUE);
					}
				}
			});
			Platform.runLater(() -> {processo10_status.setTextFill(Color.BLACK);});
			Platform.runLater(() -> {p10_pane.setEffect(null);});
			break;
		case "DEADLOCK":
			Platform.runLater(() -> {grafo_processo10.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo10.setEffect(contorno_bloqueado);});
			Platform.runLater(() -> {processo10_status.setText("STATUS: DEADLOCK");});
			Platform.runLater(() -> {processo10_status.setTextFill(Color.RED);});
			Platform.runLater(() -> {p10_pane.setEffect(contorno_bloqueado);});
			break;	
		case "IMPEDIDO":
			Platform.runLater(() -> {grafo_processo10.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo10.setEffect(contorno_impedido);});
			Platform.runLater(() -> {processo10_status.setText("STATUS: IMPEDIDO");});
			Platform.runLater(() -> {processo10_status.setTextFill(Color.BLUE);});
			Platform.runLater(() -> {p10_pane.setEffect(contorno_impedido);});
			break;
		default:
			break;
		}
	}
	
	public void Mostrar_Informacoes_Ciclo(Vertice v, String status){
		int index = 0;
		while(index < processos.size() && !processos.get(index).vertice.equals(v))
			index++;
		switch (index) {
		case 0:
			Mostrar_Informacoes_Ciclo_Processo1(status);
			break;
		case 1:
			Mostrar_Informacoes_Ciclo_Processo2(status);
			break;
		case 2:
			Mostrar_Informacoes_Ciclo_Processo3(status);
			break;
		case 3:
			Mostrar_Informacoes_Ciclo_Processo4(status);
			break;
		case 4:
			Mostrar_Informacoes_Ciclo_Processo5(status);
			break;
		case 5:
			Mostrar_Informacoes_Ciclo_Processo6(status);
			break;
		case 6:
			Mostrar_Informacoes_Ciclo_Processo7(status);
			break;
		case 7:
			Mostrar_Informacoes_Ciclo_Processo8(status);
			break;
		case 8:
			Mostrar_Informacoes_Ciclo_Processo9(status);
			break;
		case 9:
			Mostrar_Informacoes_Ciclo_Processo10(status);
			break;
		default:
			break;
		}
	}
	
	public void Desenhar_Aresta_Processo1(int id_recurso, double rotacao, boolean visivel){
		int index = 0;
		while(recursos.get(index).id != id_recurso)
			index++;
		switch (index) {
		case 0:
			Platform.runLater(() -> {processo1_recurso1_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo1_recurso1_aresta.setRotate(rotacao + processo1_recurso1_aresta.getRotate());});
			break;
		case 1:
			Platform.runLater(() -> {processo1_recurso2_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo1_recurso2_aresta.setRotate(rotacao + processo1_recurso2_aresta.getRotate());});
			break;
		case 2:
			Platform.runLater(() -> {processo1_recurso3_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo1_recurso3_aresta.setRotate(rotacao + processo1_recurso3_aresta.getRotate());});
			break;
		case 3:
			Platform.runLater(() -> {processo1_recurso4_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo1_recurso4_aresta.setRotate(rotacao + processo1_recurso4_aresta.getRotate());});
			break;
		case 4:
			Platform.runLater(() -> {processo1_recurso5_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo1_recurso5_aresta.setRotate(rotacao + processo1_recurso5_aresta.getRotate());});
			break;
		case 5:
			Platform.runLater(() -> {processo1_recurso6_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo1_recurso6_aresta.setRotate(rotacao + processo1_recurso6_aresta.getRotate());});
			break;
		case 6:
			Platform.runLater(() -> {processo1_recurso7_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo1_recurso7_aresta.setRotate(rotacao + processo1_recurso7_aresta.getRotate());});
			break;
		case 7:
			Platform.runLater(() -> {processo1_recurso8_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo1_recurso8_aresta.setRotate(rotacao + processo1_recurso8_aresta.getRotate());});
			break;
		case 8:
			Platform.runLater(() -> {processo1_recurso9_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo1_recurso9_aresta.setRotate(rotacao + processo1_recurso9_aresta.getRotate());});
			break;
		case 9:
			Platform.runLater(() -> {processo1_recurso10_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo1_recurso10_aresta.setRotate(rotacao + processo1_recurso10_aresta.getRotate());});
			break;
		default:
			break;
		}
	}
	
	public void Desenhar_Aresta_Processo2(int id_recurso, double rotacao, boolean visivel){
		int index = 0;
		while(recursos.get(index).id != id_recurso)
			index++;
		switch (index) {
		case 0:
			Platform.runLater(() -> {processo2_recurso1_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo2_recurso1_aresta.setRotate(rotacao + processo2_recurso1_aresta.getRotate());});
			break;
		case 1:
			Platform.runLater(() -> {processo2_recurso2_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo2_recurso2_aresta.setRotate(rotacao + processo2_recurso2_aresta.getRotate());});
			break;
		case 2:
			Platform.runLater(() -> {processo2_recurso3_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo2_recurso3_aresta.setRotate(rotacao + processo2_recurso3_aresta.getRotate());});
			break;
		case 3:
			Platform.runLater(() -> {processo2_recurso4_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo2_recurso4_aresta.setRotate(rotacao + processo2_recurso4_aresta.getRotate());});
			break;
		case 4:
			Platform.runLater(() -> {processo2_recurso5_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo2_recurso5_aresta.setRotate(rotacao + processo2_recurso5_aresta.getRotate());});
			break;
		case 5:
			Platform.runLater(() -> {processo2_recurso6_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo2_recurso6_aresta.setRotate(rotacao + processo2_recurso6_aresta.getRotate());});
			break;
		case 6:
			Platform.runLater(() -> {processo2_recurso7_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo2_recurso7_aresta.setRotate(rotacao + processo2_recurso7_aresta.getRotate());});
			break;
		case 7:
			Platform.runLater(() -> {processo2_recurso8_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo2_recurso8_aresta.setRotate(rotacao + processo2_recurso8_aresta.getRotate());});
			break;
		case 8:
			Platform.runLater(() -> {processo2_recurso9_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo2_recurso9_aresta.setRotate(rotacao + processo2_recurso9_aresta.getRotate());});
			break;
		case 9:
			Platform.runLater(() -> {processo2_recurso10_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo2_recurso10_aresta.setRotate(rotacao + processo2_recurso10_aresta.getRotate());});
			break;
		default:
			break;
		}
	}
	
	public void Desenhar_Aresta_Processo3(int id_recurso, double rotacao, boolean visivel){
		int index = 0;
		while(recursos.get(index).id != id_recurso)
			index++;
		switch (index) {
		case 0:
			Platform.runLater(() -> {processo3_recurso1_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo3_recurso1_aresta.setRotate(rotacao + processo3_recurso1_aresta.getRotate());});
			break;
		case 1:
			Platform.runLater(() -> {processo3_recurso2_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo3_recurso2_aresta.setRotate(rotacao + processo3_recurso2_aresta.getRotate());});
			break;
		case 2:
			Platform.runLater(() -> {processo3_recurso3_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo3_recurso3_aresta.setRotate(rotacao + processo3_recurso3_aresta.getRotate());});
			break;
		case 3:
			Platform.runLater(() -> {processo3_recurso4_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo3_recurso4_aresta.setRotate(rotacao + processo3_recurso4_aresta.getRotate());});
			break;
		case 4:
			Platform.runLater(() -> {processo3_recurso5_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo3_recurso5_aresta.setRotate(rotacao + processo3_recurso5_aresta.getRotate());});
			break;
		case 5:
			Platform.runLater(() -> {processo3_recurso6_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo3_recurso6_aresta.setRotate(rotacao + processo3_recurso6_aresta.getRotate());});
			break;
		case 6:
			Platform.runLater(() -> {processo3_recurso7_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo3_recurso7_aresta.setRotate(rotacao + processo3_recurso7_aresta.getRotate());});
			break;
		case 7:
			Platform.runLater(() -> {processo3_recurso8_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo3_recurso8_aresta.setRotate(rotacao + processo3_recurso8_aresta.getRotate());});
			break;
		case 8:
			Platform.runLater(() -> {processo3_recurso9_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo3_recurso9_aresta.setRotate(rotacao + processo3_recurso9_aresta.getRotate());});
			break;
		case 9:
			Platform.runLater(() -> {processo3_recurso10_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo3_recurso10_aresta.setRotate(rotacao + processo3_recurso10_aresta.getRotate());});
			break;
		default:
			break;
		}
	}
	
	public void Desenhar_Aresta_Processo4(int id_recurso, double rotacao, boolean visivel){
		int index = 0;
		while(recursos.get(index).id != id_recurso)
			index++;
		switch (index) {
		case 0:
			Platform.runLater(() -> {processo4_recurso1_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo4_recurso1_aresta.setRotate(rotacao + processo4_recurso1_aresta.getRotate());});
			break;
		case 1:
			Platform.runLater(() -> {processo4_recurso2_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo4_recurso2_aresta.setRotate(rotacao + processo4_recurso2_aresta.getRotate());});
			break;
		case 2:
			Platform.runLater(() -> {processo4_recurso3_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo4_recurso3_aresta.setRotate(rotacao + processo4_recurso3_aresta.getRotate());});
			break;
		case 3:
			Platform.runLater(() -> {processo4_recurso4_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo4_recurso4_aresta.setRotate(rotacao + processo4_recurso4_aresta.getRotate());});
			break;
		case 4:
			Platform.runLater(() -> {processo4_recurso5_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo4_recurso5_aresta.setRotate(rotacao + processo4_recurso5_aresta.getRotate());});
			break;
		case 5:
			Platform.runLater(() -> {processo4_recurso6_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo4_recurso6_aresta.setRotate(rotacao + processo4_recurso6_aresta.getRotate());});
			break;
		case 6:
			Platform.runLater(() -> {processo4_recurso7_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo4_recurso7_aresta.setRotate(rotacao + processo4_recurso7_aresta.getRotate());});
			break;
		case 7:
			Platform.runLater(() -> {processo4_recurso8_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo4_recurso8_aresta.setRotate(rotacao + processo4_recurso8_aresta.getRotate());});
			break;
		case 8:
			Platform.runLater(() -> {processo4_recurso9_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo4_recurso9_aresta.setRotate(rotacao + processo4_recurso9_aresta.getRotate());});
			break;
		case 9:
			Platform.runLater(() -> {processo4_recurso10_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo4_recurso10_aresta.setRotate(rotacao + processo4_recurso10_aresta.getRotate());});
			break;
		default:
			break;
		}
	}
	
	public void Desenhar_Aresta_Processo5(int id_recurso, double rotacao, boolean visivel){
		int index = 0;
		while(recursos.get(index).id != id_recurso)
			index++;
		switch (index) {
		case 0:
			Platform.runLater(() -> {processo5_recurso1_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo5_recurso1_aresta.setRotate(rotacao + processo5_recurso1_aresta.getRotate());});
			break;
		case 1:
			Platform.runLater(() -> {processo5_recurso2_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo5_recurso2_aresta.setRotate(rotacao + processo5_recurso2_aresta.getRotate());});
			break;
		case 2:
			Platform.runLater(() -> {processo5_recurso3_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo5_recurso3_aresta.setRotate(rotacao + processo5_recurso3_aresta.getRotate());});
			break;
		case 3:
			Platform.runLater(() -> {processo5_recurso4_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo5_recurso4_aresta.setRotate(rotacao + processo5_recurso4_aresta.getRotate());});
			break;
		case 4:
			Platform.runLater(() -> {processo5_recurso5_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo5_recurso5_aresta.setRotate(rotacao + processo5_recurso5_aresta.getRotate());});
			break;
		case 5:
			Platform.runLater(() -> {processo5_recurso6_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo5_recurso6_aresta.setRotate(rotacao + processo5_recurso6_aresta.getRotate());});
			break;
		case 6:
			Platform.runLater(() -> {processo5_recurso7_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo5_recurso7_aresta.setRotate(rotacao + processo5_recurso7_aresta.getRotate());});
			break;
		case 7:
			Platform.runLater(() -> {processo5_recurso8_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo5_recurso8_aresta.setRotate(rotacao + processo5_recurso8_aresta.getRotate());});
			break;
		case 8:
			Platform.runLater(() -> {processo5_recurso9_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo5_recurso9_aresta.setRotate(rotacao + processo5_recurso9_aresta.getRotate());});
			break;
		case 9:
			Platform.runLater(() -> {processo5_recurso10_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo5_recurso10_aresta.setRotate(rotacao + processo5_recurso10_aresta.getRotate());});
			break;
		default:
			break;
		}
	}
	
	public void Desenhar_Aresta_Processo6(int id_recurso, double rotacao, boolean visivel){
		int index = 0;
		while(recursos.get(index).id != id_recurso)
			index++;
		switch (index) {
		case 0:
			Platform.runLater(() -> {processo6_recurso1_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo6_recurso1_aresta.setRotate(rotacao + processo6_recurso1_aresta.getRotate());});
			break;
		case 1:
			Platform.runLater(() -> {processo6_recurso2_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo6_recurso2_aresta.setRotate(rotacao + processo6_recurso2_aresta.getRotate());});
			break;
		case 2:
			Platform.runLater(() -> {processo6_recurso3_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo6_recurso3_aresta.setRotate(rotacao + processo6_recurso3_aresta.getRotate());});
			break;
		case 3:
			Platform.runLater(() -> {processo6_recurso4_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo6_recurso4_aresta.setRotate(rotacao + processo6_recurso4_aresta.getRotate());});
			break;
		case 4:
			Platform.runLater(() -> {processo6_recurso5_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo6_recurso5_aresta.setRotate(rotacao + processo6_recurso5_aresta.getRotate());});
			break;
		case 5:
			Platform.runLater(() -> {processo6_recurso6_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo6_recurso6_aresta.setRotate(rotacao + processo6_recurso6_aresta.getRotate());});
			break;
		case 6:
			Platform.runLater(() -> {processo6_recurso7_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo6_recurso7_aresta.setRotate(rotacao + processo6_recurso7_aresta.getRotate());});
			break;
		case 7:
			Platform.runLater(() -> {processo6_recurso8_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo6_recurso8_aresta.setRotate(rotacao + processo6_recurso8_aresta.getRotate());});
			break;
		case 8:
			Platform.runLater(() -> {processo6_recurso9_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo6_recurso9_aresta.setRotate(rotacao + processo6_recurso9_aresta.getRotate());});
			break;
		case 9:
			Platform.runLater(() -> {processo6_recurso10_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo6_recurso10_aresta.setRotate(rotacao + processo6_recurso10_aresta.getRotate());});
			break;
		default:
			break;
		}
	}
	
	public void Desenhar_Aresta_Processo7(int id_recurso, double rotacao, boolean visivel){
		int index = 0;
		while(recursos.get(index).id != id_recurso)
			index++;
		switch (index) {
		case 0:
			Platform.runLater(() -> {processo7_recurso1_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo7_recurso1_aresta.setRotate(rotacao + processo7_recurso1_aresta.getRotate());});
			break;
		case 1:
			Platform.runLater(() -> {processo7_recurso2_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo7_recurso2_aresta.setRotate(rotacao + processo7_recurso2_aresta.getRotate());});
			break;
		case 2:
			Platform.runLater(() -> {processo7_recurso3_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo7_recurso3_aresta.setRotate(rotacao + processo7_recurso3_aresta.getRotate());});
			break;
		case 3:
			Platform.runLater(() -> {processo7_recurso4_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo7_recurso4_aresta.setRotate(rotacao + processo7_recurso4_aresta.getRotate());});
			break;
		case 4:
			Platform.runLater(() -> {processo7_recurso5_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo7_recurso5_aresta.setRotate(rotacao + processo7_recurso5_aresta.getRotate());});
			break;
		case 5:
			Platform.runLater(() -> {processo7_recurso6_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo7_recurso6_aresta.setRotate(rotacao + processo7_recurso6_aresta.getRotate());});
			break;
		case 6:
			Platform.runLater(() -> {processo7_recurso7_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo7_recurso7_aresta.setRotate(rotacao + processo7_recurso7_aresta.getRotate());});
			break;
		case 7:
			Platform.runLater(() -> {processo7_recurso8_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo7_recurso8_aresta.setRotate(rotacao + processo7_recurso8_aresta.getRotate());});
			break;
		case 8:
			Platform.runLater(() -> {processo7_recurso9_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo7_recurso9_aresta.setRotate(rotacao + processo7_recurso9_aresta.getRotate());});
			break;
		case 9:
			Platform.runLater(() -> {processo7_recurso10_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo7_recurso10_aresta.setRotate(rotacao + processo7_recurso10_aresta.getRotate());});
			break;
		default:
			break;
		}
	}
	
	public void Desenhar_Aresta_Processo8(int id_recurso, double rotacao, boolean visivel){
		int index = 0;
		while(recursos.get(index).id != id_recurso)
			index++;
		switch (index) {
		case 0:
			Platform.runLater(() -> {processo8_recurso1_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo8_recurso1_aresta.setRotate(rotacao + processo8_recurso1_aresta.getRotate());});
			break;
		case 1:
			Platform.runLater(() -> {processo8_recurso2_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo8_recurso2_aresta.setRotate(rotacao + processo8_recurso2_aresta.getRotate());});
			break;
		case 2:
			Platform.runLater(() -> {processo8_recurso3_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo8_recurso3_aresta.setRotate(rotacao + processo8_recurso3_aresta.getRotate());});
			break;
		case 3:
			Platform.runLater(() -> {processo8_recurso4_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo8_recurso4_aresta.setRotate(rotacao + processo8_recurso4_aresta.getRotate());});
			break;
		case 4:
			Platform.runLater(() -> {processo8_recurso5_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo8_recurso5_aresta.setRotate(rotacao + processo8_recurso5_aresta.getRotate());});
			break;
		case 5:
			Platform.runLater(() -> {processo8_recurso6_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo8_recurso6_aresta.setRotate(rotacao + processo8_recurso6_aresta.getRotate());});
			break;
		case 6:
			Platform.runLater(() -> {processo8_recurso7_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo8_recurso7_aresta.setRotate(rotacao + processo8_recurso7_aresta.getRotate());});
			break;
		case 7:
			Platform.runLater(() -> {processo8_recurso8_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo8_recurso8_aresta.setRotate(rotacao + processo8_recurso8_aresta.getRotate());});
			break;
		case 8:
			Platform.runLater(() -> {processo8_recurso9_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo8_recurso9_aresta.setRotate(rotacao + processo8_recurso9_aresta.getRotate());});
			break;
		case 9:
			Platform.runLater(() -> {processo8_recurso10_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo8_recurso10_aresta.setRotate(rotacao + processo8_recurso10_aresta.getRotate());});
			break;
		default:
			break;
		}
	}
	
	public void Desenhar_Aresta_Processo9(int id_recurso, double rotacao, boolean visivel){
		int index = 0;
		while(recursos.get(index).id != id_recurso)
			index++;
		switch (index) {
		case 0:
			Platform.runLater(() -> {processo9_recurso1_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo9_recurso1_aresta.setRotate(rotacao + processo9_recurso1_aresta.getRotate());});
			break;
		case 1:
			Platform.runLater(() -> {processo9_recurso2_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo9_recurso2_aresta.setRotate(rotacao + processo9_recurso2_aresta.getRotate());});
			break;
		case 2:
			Platform.runLater(() -> {processo9_recurso3_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo9_recurso3_aresta.setRotate(rotacao + processo9_recurso3_aresta.getRotate());});
			break;
		case 3:
			Platform.runLater(() -> {processo9_recurso4_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo9_recurso4_aresta.setRotate(rotacao + processo9_recurso4_aresta.getRotate());});
			break;
		case 4:
			Platform.runLater(() -> {processo9_recurso5_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo9_recurso5_aresta.setRotate(rotacao + processo9_recurso5_aresta.getRotate());});
			break;
		case 5:
			Platform.runLater(() -> {processo9_recurso6_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo9_recurso6_aresta.setRotate(rotacao + processo9_recurso6_aresta.getRotate());});
			break;
		case 6:
			Platform.runLater(() -> {processo9_recurso7_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo9_recurso7_aresta.setRotate(rotacao + processo9_recurso7_aresta.getRotate());});
			break;
		case 7:
			Platform.runLater(() -> {processo9_recurso8_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo9_recurso8_aresta.setRotate(rotacao + processo9_recurso8_aresta.getRotate());});
			break;
		case 8:
			Platform.runLater(() -> {processo9_recurso9_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo9_recurso9_aresta.setRotate(rotacao + processo9_recurso9_aresta.getRotate());});
			break;
		case 9:
			Platform.runLater(() -> {processo9_recurso10_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo9_recurso10_aresta.setRotate(rotacao + processo9_recurso10_aresta.getRotate());});
			break;
		default:
			break;
		}
	}
	
	public void Desenhar_Aresta_Processo10(int id_recurso, double rotacao, boolean visivel){
		int index = 0;
		while(recursos.get(index).id != id_recurso)
			index++;
		switch (index) {
		case 0:
			Platform.runLater(() -> {processo10_recurso1_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo10_recurso1_aresta.setRotate(rotacao + processo10_recurso1_aresta.getRotate());});
			break;
		case 1:
			Platform.runLater(() -> {processo10_recurso2_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo10_recurso2_aresta.setRotate(rotacao + processo10_recurso2_aresta.getRotate());});
			break;
		case 2:
			Platform.runLater(() -> {processo10_recurso3_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo10_recurso3_aresta.setRotate(rotacao + processo10_recurso3_aresta.getRotate());});
			break;
		case 3:
			Platform.runLater(() -> {processo10_recurso4_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo10_recurso4_aresta.setRotate(rotacao + processo10_recurso4_aresta.getRotate());});
			break;
		case 4:
			Platform.runLater(() -> {processo10_recurso5_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo10_recurso5_aresta.setRotate(rotacao + processo10_recurso5_aresta.getRotate());});
			break;
		case 5:
			Platform.runLater(() -> {processo10_recurso6_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo10_recurso6_aresta.setRotate(rotacao + processo10_recurso6_aresta.getRotate());});
			break;
		case 6:
			Platform.runLater(() -> {processo10_recurso7_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo10_recurso7_aresta.setRotate(rotacao + processo10_recurso7_aresta.getRotate());});
			break;
		case 7:
			Platform.runLater(() -> {processo10_recurso8_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo10_recurso8_aresta.setRotate(rotacao + processo10_recurso8_aresta.getRotate());});
			break;
		case 8:
			Platform.runLater(() -> {processo10_recurso9_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo10_recurso9_aresta.setRotate(rotacao + processo10_recurso9_aresta.getRotate());});
			break;
		case 9:
			Platform.runLater(() -> {processo10_recurso10_aresta.setVisible(visivel);});
			Platform.runLater(() -> {processo10_recurso10_aresta.setRotate(rotacao + processo10_recurso10_aresta.getRotate());});
			break;
		default:
			break;
		}
	}
	
	public void Desenhar_Aresta(Vertice processo, Vertice recurso, double rotacao, boolean visivel){
		if(processo.id != -1){
		int index = 0;
		while(index < processos.size() && processos.get(index).id != processo.id)
			index++;
		if(index > processos.size()) return;
		switch (index) {
		case 0:
			Desenhar_Aresta_Processo1(recurso.id, rotacao, visivel);
			break;
		case 1:
			Desenhar_Aresta_Processo2(recurso.id, rotacao, visivel);
			break;
		case 2:
			Desenhar_Aresta_Processo3(recurso.id, rotacao, visivel);
			break;
		case 3:
			Desenhar_Aresta_Processo4(recurso.id, rotacao, visivel);
			break;
		case 4:
			Desenhar_Aresta_Processo5(recurso.id, rotacao, visivel);
			break;
		case 5:
			Desenhar_Aresta_Processo6(recurso.id, rotacao, visivel);
			break;	
		case 6:
			Desenhar_Aresta_Processo7(recurso.id, rotacao, visivel);
			break;	
		case 7:
			Desenhar_Aresta_Processo8(recurso.id, rotacao, visivel);
			break;
		case 8:
			Desenhar_Aresta_Processo9(recurso.id, rotacao, visivel);
			break;
		case 9:
			Desenhar_Aresta_Processo10(recurso.id, rotacao, visivel);
			break;
		default:
			break;
		}
		}
	}
	
	public void Ajustar_Arestas_Processo6(){
		processo6_recurso1_aresta = new ImageView();
		processo6_recurso1_aresta.setFitWidth(10);
		processo6_recurso1_aresta.setFitHeight(processo5_recurso10_aresta.getFitHeight());
		processo6_recurso1_aresta.setLayoutX(processo5_recurso10_aresta.getLayoutX() - 4 * 60);
		processo6_recurso1_aresta.setLayoutY(processo5_recurso10_aresta.getLayoutY());
		processo6_recurso1_aresta.setRotate(-processo5_recurso10_aresta.getRotate());
		processo6_recurso1_aresta.setImage(processo5_recurso1_aresta.getImage());
		processo6_recurso1_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo6_recurso1_aresta);
		
		processo6_recurso2_aresta = new ImageView();
		processo6_recurso2_aresta.setFitWidth(10);
		processo6_recurso2_aresta.setFitHeight(processo5_recurso9_aresta.getFitHeight());
		processo6_recurso2_aresta.setLayoutX(processo5_recurso9_aresta.getLayoutX() - 3 * 60);
		processo6_recurso2_aresta.setLayoutY(processo5_recurso9_aresta.getLayoutY());
		processo6_recurso2_aresta.setRotate(-processo5_recurso9_aresta.getRotate());
		processo6_recurso2_aresta.setImage(processo5_recurso2_aresta.getImage());
		processo6_recurso2_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo6_recurso2_aresta);
		
		processo6_recurso3_aresta = new ImageView();
		processo6_recurso3_aresta.setFitWidth(10);
		processo6_recurso3_aresta.setFitHeight(processo5_recurso8_aresta.getFitHeight());
		processo6_recurso3_aresta.setLayoutX(processo5_recurso8_aresta.getLayoutX() - 2 * 60);
		processo6_recurso3_aresta.setLayoutY(processo5_recurso8_aresta.getLayoutY());
		processo6_recurso3_aresta.setRotate(-processo5_recurso8_aresta.getRotate());
		processo6_recurso3_aresta.setImage(processo5_recurso3_aresta.getImage());
		processo6_recurso3_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo6_recurso3_aresta);
		
		processo6_recurso4_aresta = new ImageView();
		processo6_recurso4_aresta.setFitWidth(10);
		processo6_recurso4_aresta.setFitHeight(processo5_recurso7_aresta.getFitHeight());
		processo6_recurso4_aresta.setLayoutX(processo5_recurso7_aresta.getLayoutX() - 1 * 60);
		processo6_recurso4_aresta.setLayoutY(processo5_recurso7_aresta.getLayoutY());
		processo6_recurso4_aresta.setRotate(-processo5_recurso7_aresta.getRotate());
		processo6_recurso4_aresta.setImage(processo5_recurso4_aresta.getImage());
		processo6_recurso4_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo6_recurso4_aresta);
		
		processo6_recurso5_aresta = new ImageView();
		processo6_recurso5_aresta.setFitWidth(10);
		processo6_recurso5_aresta.setFitHeight(processo5_recurso6_aresta.getFitHeight());
		processo6_recurso5_aresta.setLayoutX(processo5_recurso6_aresta.getLayoutX());
		processo6_recurso5_aresta.setLayoutY(processo5_recurso6_aresta.getLayoutY());
		processo6_recurso5_aresta.setRotate(-processo5_recurso6_aresta.getRotate());
		processo6_recurso5_aresta.setImage(processo5_recurso5_aresta.getImage());
		processo6_recurso5_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo6_recurso5_aresta);
		
		processo6_recurso6_aresta = new ImageView();
		processo6_recurso6_aresta.setFitWidth(10);
		processo6_recurso6_aresta.setFitHeight(processo5_recurso5_aresta.getFitHeight());
		processo6_recurso6_aresta.setLayoutX(processo5_recurso5_aresta.getLayoutX() + 1 * 60);
		processo6_recurso6_aresta.setLayoutY(processo5_recurso5_aresta.getLayoutY());
		processo6_recurso6_aresta.setRotate(-processo5_recurso5_aresta.getRotate());
		processo6_recurso6_aresta.setImage(processo5_recurso6_aresta.getImage());
		processo6_recurso6_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo6_recurso6_aresta);
		
		processo6_recurso7_aresta = new ImageView();
		processo6_recurso7_aresta.setFitWidth(10);
		processo6_recurso7_aresta.setFitHeight(processo5_recurso4_aresta.getFitHeight());
		processo6_recurso7_aresta.setLayoutX(processo5_recurso4_aresta.getLayoutX() + 2 * 60);
		processo6_recurso7_aresta.setLayoutY(processo5_recurso4_aresta.getLayoutY());
		processo6_recurso7_aresta.setRotate(-processo5_recurso4_aresta.getRotate());
		processo6_recurso7_aresta.setImage(processo5_recurso7_aresta.getImage());
		processo6_recurso7_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo6_recurso7_aresta);
		
		processo6_recurso8_aresta = new ImageView();
		processo6_recurso8_aresta.setFitWidth(10);
		processo6_recurso8_aresta.setFitHeight(processo5_recurso3_aresta.getFitHeight());
		processo6_recurso8_aresta.setLayoutX(processo5_recurso3_aresta.getLayoutX() + 3 * 60);
		processo6_recurso8_aresta.setLayoutY(processo5_recurso3_aresta.getLayoutY());
		processo6_recurso8_aresta.setRotate(-processo5_recurso3_aresta.getRotate());
		processo6_recurso8_aresta.setImage(processo5_recurso8_aresta.getImage());
		processo6_recurso8_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo6_recurso8_aresta);
		
		processo6_recurso9_aresta = new ImageView();
		processo6_recurso9_aresta.setFitWidth(10);
		processo6_recurso9_aresta.setFitHeight(processo5_recurso2_aresta.getFitHeight());
		processo6_recurso9_aresta.setLayoutX(processo5_recurso2_aresta.getLayoutX() + 4 * 60);
		processo6_recurso9_aresta.setLayoutY(processo5_recurso2_aresta.getLayoutY());
		processo6_recurso9_aresta.setRotate(-processo5_recurso2_aresta.getRotate());
		processo6_recurso9_aresta.setImage(processo5_recurso9_aresta.getImage());
		processo6_recurso9_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo6_recurso9_aresta);
		
		processo6_recurso10_aresta = new ImageView();
		processo6_recurso10_aresta.setFitWidth(10);
		processo6_recurso10_aresta.setFitHeight(processo5_recurso1_aresta.getFitHeight());
		processo6_recurso10_aresta.setLayoutX(processo5_recurso1_aresta.getLayoutX() + 5 * 60);
		processo6_recurso10_aresta.setLayoutY(processo5_recurso1_aresta.getLayoutY());
		processo6_recurso10_aresta.setRotate(-processo5_recurso1_aresta.getRotate());
		processo6_recurso10_aresta.setImage(processo5_recurso10_aresta.getImage());
		processo6_recurso10_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo6_recurso10_aresta);
	}
	
	public void Ajustar_Arestas_Processo7(){
		processo7_recurso1_aresta = new ImageView();
		processo7_recurso1_aresta.setFitWidth(10);
		processo7_recurso1_aresta.setFitHeight(processo4_recurso10_aresta.getFitHeight());
		processo7_recurso1_aresta.setLayoutX(processo4_recurso10_aresta.getLayoutX() - 3 * 60);
		processo7_recurso1_aresta.setLayoutY(processo4_recurso10_aresta.getLayoutY());
		processo7_recurso1_aresta.setRotate(-processo4_recurso10_aresta.getRotate());
		processo7_recurso1_aresta.setImage(processo4_recurso1_aresta.getImage());
		processo7_recurso1_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo7_recurso1_aresta);
		
		processo7_recurso2_aresta = new ImageView();
		processo7_recurso2_aresta.setFitWidth(10);
		processo7_recurso2_aresta.setFitHeight(processo4_recurso9_aresta.getFitHeight());
		processo7_recurso2_aresta.setLayoutX(processo4_recurso9_aresta.getLayoutX() - 2 * 60);
		processo7_recurso2_aresta.setLayoutY(processo4_recurso9_aresta.getLayoutY());
		processo7_recurso2_aresta.setRotate(-processo4_recurso9_aresta.getRotate());
		processo7_recurso2_aresta.setImage(processo4_recurso2_aresta.getImage());
		processo7_recurso2_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo7_recurso2_aresta);
		
		processo7_recurso3_aresta = new ImageView();
		processo7_recurso3_aresta.setFitWidth(10);
		processo7_recurso3_aresta.setFitHeight(processo4_recurso8_aresta.getFitHeight());
		processo7_recurso3_aresta.setLayoutX(processo4_recurso8_aresta.getLayoutX() - 1 * 60);
		processo7_recurso3_aresta.setLayoutY(processo4_recurso8_aresta.getLayoutY());
		processo7_recurso3_aresta.setRotate(-processo4_recurso8_aresta.getRotate());
		processo7_recurso3_aresta.setImage(processo4_recurso3_aresta.getImage());
		processo7_recurso3_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo7_recurso3_aresta);
		
		processo7_recurso4_aresta = new ImageView();
		processo7_recurso4_aresta.setFitWidth(10);
		processo7_recurso4_aresta.setFitHeight(processo4_recurso7_aresta.getFitHeight());
		processo7_recurso4_aresta.setLayoutX(processo4_recurso7_aresta.getLayoutX());
		processo7_recurso4_aresta.setLayoutY(processo4_recurso7_aresta.getLayoutY());
		processo7_recurso4_aresta.setRotate(-processo4_recurso7_aresta.getRotate());
		processo7_recurso4_aresta.setImage(processo4_recurso4_aresta.getImage());
		processo7_recurso4_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo7_recurso4_aresta);
		
		processo7_recurso5_aresta = new ImageView();
		processo7_recurso5_aresta.setFitWidth(10);
		processo7_recurso5_aresta.setFitHeight(processo4_recurso6_aresta.getFitHeight());
		processo7_recurso5_aresta.setLayoutX(processo4_recurso6_aresta.getLayoutX() + 60);
		processo7_recurso5_aresta.setLayoutY(processo4_recurso6_aresta.getLayoutY());
		processo7_recurso5_aresta.setRotate(-processo4_recurso6_aresta.getRotate());
		processo7_recurso5_aresta.setImage(processo4_recurso5_aresta.getImage());
		processo7_recurso5_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo7_recurso5_aresta);
		
		processo7_recurso6_aresta = new ImageView();
		processo7_recurso6_aresta.setFitWidth(10);
		processo7_recurso6_aresta.setFitHeight(processo4_recurso5_aresta.getFitHeight());
		processo7_recurso6_aresta.setLayoutX(processo4_recurso5_aresta.getLayoutX() + 2 * 60);
		processo7_recurso6_aresta.setLayoutY(processo4_recurso5_aresta.getLayoutY());
		processo7_recurso6_aresta.setRotate(-processo4_recurso5_aresta.getRotate());
		processo7_recurso6_aresta.setImage(processo4_recurso6_aresta.getImage());
		processo7_recurso6_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo7_recurso6_aresta);
		
		processo7_recurso7_aresta = new ImageView();
		processo7_recurso7_aresta.setFitWidth(10);
		processo7_recurso7_aresta.setFitHeight(processo4_recurso4_aresta.getFitHeight());
		processo7_recurso7_aresta.setLayoutX(processo4_recurso4_aresta.getLayoutX() + 3 * 60);
		processo7_recurso7_aresta.setLayoutY(processo4_recurso4_aresta.getLayoutY());
		processo7_recurso7_aresta.setRotate(-processo4_recurso4_aresta.getRotate());
		processo7_recurso7_aresta.setImage(processo4_recurso7_aresta.getImage());
		processo7_recurso7_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo7_recurso7_aresta);
		
		processo7_recurso8_aresta = new ImageView();
		processo7_recurso8_aresta.setFitWidth(10);
		processo7_recurso8_aresta.setFitHeight(processo4_recurso3_aresta.getFitHeight());
		processo7_recurso8_aresta.setLayoutX(processo4_recurso3_aresta.getLayoutX() + 4 * 60);
		processo7_recurso8_aresta.setLayoutY(processo4_recurso3_aresta.getLayoutY());
		processo7_recurso8_aresta.setRotate(-processo4_recurso3_aresta.getRotate());
		processo7_recurso8_aresta.setImage(processo4_recurso8_aresta.getImage());
		processo7_recurso8_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo7_recurso8_aresta);
		
		processo7_recurso9_aresta = new ImageView();
		processo7_recurso9_aresta.setFitWidth(10);
		processo7_recurso9_aresta.setFitHeight(processo4_recurso2_aresta.getFitHeight());
		processo7_recurso9_aresta.setLayoutX(processo4_recurso2_aresta.getLayoutX() + 5 * 60);
		processo7_recurso9_aresta.setLayoutY(processo4_recurso2_aresta.getLayoutY());
		processo7_recurso9_aresta.setRotate(-processo4_recurso2_aresta.getRotate());
		processo7_recurso9_aresta.setImage(processo4_recurso9_aresta.getImage());
		processo7_recurso9_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo7_recurso9_aresta);
		
		processo7_recurso10_aresta = new ImageView();
		processo7_recurso10_aresta.setFitWidth(10);
		processo7_recurso10_aresta.setFitHeight(processo4_recurso1_aresta.getFitHeight());
		processo7_recurso10_aresta.setLayoutX(processo4_recurso1_aresta.getLayoutX() + 6 * 60);
		processo7_recurso10_aresta.setLayoutY(processo4_recurso1_aresta.getLayoutY());
		processo7_recurso10_aresta.setRotate(-processo4_recurso1_aresta.getRotate());
		processo7_recurso10_aresta.setImage(processo4_recurso10_aresta.getImage());
		processo7_recurso10_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo7_recurso10_aresta);
	}
	
	public void Ajustar_Arestas_Processo8(){
		processo8_recurso1_aresta = new ImageView();
		processo8_recurso1_aresta.setFitWidth(10);
		processo8_recurso1_aresta.setFitHeight(processo3_recurso10_aresta.getFitHeight());
		processo8_recurso1_aresta.setLayoutX(processo3_recurso10_aresta.getLayoutX() - 2 * 60);
		processo8_recurso1_aresta.setLayoutY(processo3_recurso10_aresta.getLayoutY());
		processo8_recurso1_aresta.setRotate(-processo3_recurso10_aresta.getRotate());
		processo8_recurso1_aresta.setImage(processo3_recurso1_aresta.getImage());
		processo8_recurso1_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo8_recurso1_aresta);
		
		processo8_recurso2_aresta = new ImageView();
		processo8_recurso2_aresta.setFitWidth(10);
		processo8_recurso2_aresta.setFitHeight(processo3_recurso9_aresta.getFitHeight());
		processo8_recurso2_aresta.setLayoutX(processo3_recurso9_aresta.getLayoutX() - 1 * 60);
		processo8_recurso2_aresta.setLayoutY(processo3_recurso9_aresta.getLayoutY());
		processo8_recurso2_aresta.setRotate(-processo3_recurso9_aresta.getRotate());
		processo8_recurso2_aresta.setImage(processo3_recurso2_aresta.getImage());
		processo8_recurso2_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo8_recurso2_aresta);
		
		processo8_recurso3_aresta = new ImageView();
		processo8_recurso3_aresta.setFitWidth(10);
		processo8_recurso3_aresta.setFitHeight(processo3_recurso8_aresta.getFitHeight());
		processo8_recurso3_aresta.setLayoutX(processo3_recurso8_aresta.getLayoutX());
		processo8_recurso3_aresta.setLayoutY(processo3_recurso8_aresta.getLayoutY());
		processo8_recurso3_aresta.setRotate(-processo3_recurso8_aresta.getRotate());
		processo8_recurso3_aresta.setImage(processo3_recurso3_aresta.getImage());
		processo8_recurso3_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo8_recurso3_aresta);
		
		processo8_recurso4_aresta = new ImageView();
		processo8_recurso4_aresta.setFitWidth(10);
		processo8_recurso4_aresta.setFitHeight(processo3_recurso7_aresta.getFitHeight());
		processo8_recurso4_aresta.setLayoutX(processo3_recurso7_aresta.getLayoutX() + 60);
		processo8_recurso4_aresta.setLayoutY(processo3_recurso7_aresta.getLayoutY());
		processo8_recurso4_aresta.setRotate(-processo3_recurso7_aresta.getRotate());
		processo8_recurso4_aresta.setImage(processo3_recurso4_aresta.getImage());
		processo8_recurso4_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo8_recurso4_aresta);
		
		processo8_recurso5_aresta = new ImageView();
		processo8_recurso5_aresta.setFitWidth(10);
		processo8_recurso5_aresta.setFitHeight(processo3_recurso6_aresta.getFitHeight());
		processo8_recurso5_aresta.setLayoutX(processo3_recurso6_aresta.getLayoutX() + 2 * 60);
		processo8_recurso5_aresta.setLayoutY(processo3_recurso6_aresta.getLayoutY());
		processo8_recurso5_aresta.setRotate(-processo3_recurso6_aresta.getRotate());
		processo8_recurso5_aresta.setImage(processo3_recurso5_aresta.getImage());
		processo8_recurso5_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo8_recurso5_aresta);
		
		processo8_recurso6_aresta = new ImageView();
		processo8_recurso6_aresta.setFitWidth(10);
		processo8_recurso6_aresta.setFitHeight(processo3_recurso5_aresta.getFitHeight());
		processo8_recurso6_aresta.setLayoutX(processo3_recurso5_aresta.getLayoutX() + 3 * 60);
		processo8_recurso6_aresta.setLayoutY(processo3_recurso5_aresta.getLayoutY());
		processo8_recurso6_aresta.setRotate(-processo3_recurso5_aresta.getRotate());
		processo8_recurso6_aresta.setImage(processo3_recurso6_aresta.getImage());
		processo8_recurso6_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo8_recurso6_aresta);
		
		processo8_recurso7_aresta = new ImageView();
		processo8_recurso7_aresta.setFitWidth(10);
		processo8_recurso7_aresta.setFitHeight(processo3_recurso4_aresta.getFitHeight());
		processo8_recurso7_aresta.setLayoutX(processo3_recurso4_aresta.getLayoutX() + 4 * 60);
		processo8_recurso7_aresta.setLayoutY(processo3_recurso4_aresta.getLayoutY());
		processo8_recurso7_aresta.setRotate(-processo3_recurso4_aresta.getRotate());
		processo8_recurso7_aresta.setImage(processo3_recurso7_aresta.getImage());
		processo8_recurso7_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo8_recurso7_aresta);
		
		processo8_recurso8_aresta = new ImageView();
		processo8_recurso8_aresta.setFitWidth(10);
		processo8_recurso8_aresta.setFitHeight(processo3_recurso3_aresta.getFitHeight());
		processo8_recurso8_aresta.setLayoutX(processo3_recurso3_aresta.getLayoutX() + 5 * 60);
		processo8_recurso8_aresta.setLayoutY(processo3_recurso3_aresta.getLayoutY());
		processo8_recurso8_aresta.setRotate(-processo3_recurso3_aresta.getRotate());
		processo8_recurso8_aresta.setImage(processo3_recurso8_aresta.getImage());
		processo8_recurso8_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo8_recurso8_aresta);
		
		processo8_recurso9_aresta = new ImageView();
		processo8_recurso9_aresta.setFitWidth(10);
		processo8_recurso9_aresta.setFitHeight(processo3_recurso2_aresta.getFitHeight());
		processo8_recurso9_aresta.setLayoutX(processo3_recurso2_aresta.getLayoutX() + 6 * 60);
		processo8_recurso9_aresta.setLayoutY(processo3_recurso2_aresta.getLayoutY());
		processo8_recurso9_aresta.setRotate(-processo3_recurso2_aresta.getRotate());
		processo8_recurso9_aresta.setImage(processo3_recurso9_aresta.getImage());
		processo8_recurso9_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo8_recurso9_aresta);
		
		processo8_recurso10_aresta = new ImageView();
		processo8_recurso10_aresta.setFitWidth(10);
		processo8_recurso10_aresta.setFitHeight(processo3_recurso1_aresta.getFitHeight());
		processo8_recurso10_aresta.setLayoutX(processo3_recurso1_aresta.getLayoutX() + 7 * 60);
		processo8_recurso10_aresta.setLayoutY(processo3_recurso1_aresta.getLayoutY());
		processo8_recurso10_aresta.setRotate(-processo3_recurso1_aresta.getRotate());
		processo8_recurso10_aresta.setImage(processo3_recurso10_aresta.getImage());
		processo8_recurso10_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo8_recurso10_aresta);
	}
	
	public void Ajustar_Arestas_Processo9(){
		processo9_recurso1_aresta = new ImageView();
		processo9_recurso1_aresta.setFitWidth(10);
		processo9_recurso1_aresta.setFitHeight(processo2_recurso10_aresta.getFitHeight());
		processo9_recurso1_aresta.setLayoutX(processo2_recurso10_aresta.getLayoutX() - 1 * 60);
		processo9_recurso1_aresta.setLayoutY(processo2_recurso10_aresta.getLayoutY());
		processo9_recurso1_aresta.setRotate(-processo2_recurso10_aresta.getRotate());
		processo9_recurso1_aresta.setImage(processo2_recurso1_aresta.getImage());
		processo9_recurso1_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo9_recurso1_aresta);
		
		processo9_recurso2_aresta = new ImageView();
		processo9_recurso2_aresta.setFitWidth(10);
		processo9_recurso2_aresta.setFitHeight(processo2_recurso9_aresta.getFitHeight());
		processo9_recurso2_aresta.setLayoutX(processo2_recurso9_aresta.getLayoutX());
		processo9_recurso2_aresta.setLayoutY(processo2_recurso9_aresta.getLayoutY());
		processo9_recurso2_aresta.setRotate(-processo2_recurso9_aresta.getRotate());
		processo9_recurso2_aresta.setImage(processo2_recurso2_aresta.getImage());
		processo9_recurso2_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo9_recurso2_aresta);
		
		processo9_recurso3_aresta = new ImageView();
		processo9_recurso3_aresta.setFitWidth(10);
		processo9_recurso3_aresta.setFitHeight(processo2_recurso8_aresta.getFitHeight());
		processo9_recurso3_aresta.setLayoutX(processo2_recurso8_aresta.getLayoutX() + 60);
		processo9_recurso3_aresta.setLayoutY(processo2_recurso8_aresta.getLayoutY());
		processo9_recurso3_aresta.setRotate(-processo2_recurso8_aresta.getRotate());
		processo9_recurso3_aresta.setImage(processo2_recurso3_aresta.getImage());
		processo9_recurso3_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo9_recurso3_aresta);
		
		processo9_recurso4_aresta = new ImageView();
		processo9_recurso4_aresta.setFitWidth(10);
		processo9_recurso4_aresta.setFitHeight(processo2_recurso7_aresta.getFitHeight());
		processo9_recurso4_aresta.setLayoutX(processo2_recurso7_aresta.getLayoutX() + 2 * 60);
		processo9_recurso4_aresta.setLayoutY(processo2_recurso7_aresta.getLayoutY());
		processo9_recurso4_aresta.setRotate(-processo2_recurso7_aresta.getRotate());
		processo9_recurso4_aresta.setImage(processo2_recurso4_aresta.getImage());
		processo9_recurso4_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo9_recurso4_aresta);
		
		processo9_recurso5_aresta = new ImageView();
		processo9_recurso5_aresta.setFitWidth(10);
		processo9_recurso5_aresta.setFitHeight(processo2_recurso6_aresta.getFitHeight());
		processo9_recurso5_aresta.setLayoutX(processo2_recurso6_aresta.getLayoutX() + 3 * 60);
		processo9_recurso5_aresta.setLayoutY(processo2_recurso6_aresta.getLayoutY());
		processo9_recurso5_aresta.setRotate(-processo2_recurso6_aresta.getRotate());
		processo9_recurso5_aresta.setImage(processo2_recurso5_aresta.getImage());
		processo9_recurso5_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo9_recurso5_aresta);
		
		processo9_recurso6_aresta = new ImageView();
		processo9_recurso6_aresta.setFitWidth(10);
		processo9_recurso6_aresta.setFitHeight(processo2_recurso5_aresta.getFitHeight());
		processo9_recurso6_aresta.setLayoutX(processo2_recurso5_aresta.getLayoutX() + 4 * 60);
		processo9_recurso6_aresta.setLayoutY(processo2_recurso5_aresta.getLayoutY());
		processo9_recurso6_aresta.setRotate(-processo2_recurso5_aresta.getRotate());
		processo9_recurso6_aresta.setImage(processo2_recurso6_aresta.getImage());
		processo9_recurso6_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo9_recurso6_aresta);
		
		processo9_recurso7_aresta = new ImageView();
		processo9_recurso7_aresta.setFitWidth(10);
		processo9_recurso7_aresta.setFitHeight(processo2_recurso4_aresta.getFitHeight());
		processo9_recurso7_aresta.setLayoutX(processo2_recurso4_aresta.getLayoutX() + 5 * 60);
		processo9_recurso7_aresta.setLayoutY(processo2_recurso4_aresta.getLayoutY());
		processo9_recurso7_aresta.setRotate(-processo2_recurso4_aresta.getRotate());
		processo9_recurso7_aresta.setImage(processo2_recurso7_aresta.getImage());
		processo9_recurso7_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo9_recurso7_aresta);
		
		processo9_recurso8_aresta = new ImageView();
		processo9_recurso8_aresta.setFitWidth(10);
		processo9_recurso8_aresta.setFitHeight(processo2_recurso3_aresta.getFitHeight());
		processo9_recurso8_aresta.setLayoutX(processo2_recurso3_aresta.getLayoutX() + 6 * 60);
		processo9_recurso8_aresta.setLayoutY(processo2_recurso3_aresta.getLayoutY());
		processo9_recurso8_aresta.setRotate(-processo2_recurso3_aresta.getRotate());
		processo9_recurso8_aresta.setImage(processo2_recurso8_aresta.getImage());
		processo9_recurso8_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo9_recurso8_aresta);
		
		processo9_recurso9_aresta = new ImageView();
		processo9_recurso9_aresta.setFitWidth(10);
		processo9_recurso9_aresta.setFitHeight(processo2_recurso2_aresta.getFitHeight());
		processo9_recurso9_aresta.setLayoutX(processo2_recurso2_aresta.getLayoutX() + 7 * 60);
		processo9_recurso9_aresta.setLayoutY(processo2_recurso2_aresta.getLayoutY());
		processo9_recurso9_aresta.setRotate(-processo2_recurso2_aresta.getRotate());
		processo9_recurso9_aresta.setImage(processo2_recurso9_aresta.getImage());
		processo9_recurso9_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo9_recurso9_aresta);
		
		processo9_recurso10_aresta = new ImageView();
		processo9_recurso10_aresta.setFitWidth(10);
		processo9_recurso10_aresta.setFitHeight(processo2_recurso1_aresta.getFitHeight());
		processo9_recurso10_aresta.setLayoutX(processo2_recurso1_aresta.getLayoutX() + 8 * 60);
		processo9_recurso10_aresta.setLayoutY(processo2_recurso1_aresta.getLayoutY());
		processo9_recurso10_aresta.setRotate(-processo2_recurso1_aresta.getRotate());
		processo9_recurso10_aresta.setImage(processo2_recurso10_aresta.getImage());
		processo9_recurso10_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo9_recurso10_aresta);
	}
	
	public void Ajustar_Arestas_Processo10(){
		processo10_recurso1_aresta = new ImageView();
		processo10_recurso1_aresta.setFitWidth(10);
		processo10_recurso1_aresta.setFitHeight(processo1_recurso10_aresta.getFitHeight());
		processo10_recurso1_aresta.setLayoutX(processo1_recurso10_aresta.getLayoutX());
		processo10_recurso1_aresta.setLayoutY(processo1_recurso10_aresta.getLayoutY());
		processo10_recurso1_aresta.setRotate(-processo1_recurso10_aresta.getRotate());
		processo10_recurso1_aresta.setImage(processo1_recurso1_aresta.getImage());
		processo10_recurso1_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo10_recurso1_aresta);
		
		processo10_recurso2_aresta = new ImageView();
		processo10_recurso2_aresta.setFitWidth(10);
		processo10_recurso2_aresta.setFitHeight(processo1_recurso9_aresta.getFitHeight());
		processo10_recurso2_aresta.setLayoutX(processo1_recurso9_aresta.getLayoutX() + 60);
		processo10_recurso2_aresta.setLayoutY(processo1_recurso9_aresta.getLayoutY());
		processo10_recurso2_aresta.setRotate(-processo1_recurso9_aresta.getRotate());
		processo10_recurso2_aresta.setImage(processo1_recurso2_aresta.getImage());
		processo10_recurso2_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo10_recurso2_aresta);
		
		processo10_recurso3_aresta = new ImageView();
		processo10_recurso3_aresta.setFitWidth(10);
		processo10_recurso3_aresta.setFitHeight(processo1_recurso8_aresta.getFitHeight());
		processo10_recurso3_aresta.setLayoutX(processo1_recurso8_aresta.getLayoutX() + 2 * 60);
		processo10_recurso3_aresta.setLayoutY(processo1_recurso8_aresta.getLayoutY());
		processo10_recurso3_aresta.setRotate(-processo1_recurso8_aresta.getRotate());
		processo10_recurso3_aresta.setImage(processo1_recurso3_aresta.getImage());
		processo10_recurso3_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo10_recurso3_aresta);
		
		processo10_recurso4_aresta = new ImageView();
		processo10_recurso4_aresta.setFitWidth(10);
		processo10_recurso4_aresta.setFitHeight(processo1_recurso7_aresta.getFitHeight());
		processo10_recurso4_aresta.setLayoutX(processo1_recurso7_aresta.getLayoutX() + 3 * 60);
		processo10_recurso4_aresta.setLayoutY(processo1_recurso7_aresta.getLayoutY());
		processo10_recurso4_aresta.setRotate(-processo1_recurso7_aresta.getRotate());
		processo10_recurso4_aresta.setImage(processo1_recurso4_aresta.getImage());
		processo10_recurso4_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo10_recurso4_aresta);
		
		processo10_recurso5_aresta = new ImageView();
		processo10_recurso5_aresta.setFitWidth(10);
		processo10_recurso5_aresta.setFitHeight(processo1_recurso6_aresta.getFitHeight());
		processo10_recurso5_aresta.setLayoutX(processo1_recurso6_aresta.getLayoutX() + 4 * 60);
		processo10_recurso5_aresta.setLayoutY(processo1_recurso6_aresta.getLayoutY());
		processo10_recurso5_aresta.setRotate(-processo1_recurso6_aresta.getRotate());
		processo10_recurso5_aresta.setImage(processo1_recurso5_aresta.getImage());
		processo10_recurso5_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo10_recurso5_aresta);
		
		processo10_recurso6_aresta = new ImageView();
		processo10_recurso6_aresta.setFitWidth(10);
		processo10_recurso6_aresta.setFitHeight(processo1_recurso5_aresta.getFitHeight());
		processo10_recurso6_aresta.setLayoutX(processo1_recurso5_aresta.getLayoutX() + 5 * 60);
		processo10_recurso6_aresta.setLayoutY(processo1_recurso5_aresta.getLayoutY());
		processo10_recurso6_aresta.setRotate(-processo1_recurso5_aresta.getRotate());
		processo10_recurso6_aresta.setImage(processo1_recurso6_aresta.getImage());
		processo10_recurso6_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo10_recurso6_aresta);
		
		processo10_recurso7_aresta = new ImageView();
		processo10_recurso7_aresta.setFitWidth(10);
		processo10_recurso7_aresta.setFitHeight(processo1_recurso4_aresta.getFitHeight());
		processo10_recurso7_aresta.setLayoutX(processo1_recurso4_aresta.getLayoutX() + 6 * 60);
		processo10_recurso7_aresta.setLayoutY(processo1_recurso4_aresta.getLayoutY());
		processo10_recurso7_aresta.setRotate(-processo1_recurso4_aresta.getRotate());
		processo10_recurso7_aresta.setImage(processo1_recurso7_aresta.getImage());
		processo10_recurso7_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo10_recurso7_aresta);
		
		processo10_recurso8_aresta = new ImageView();
		processo10_recurso8_aresta.setFitWidth(10);
		processo10_recurso8_aresta.setFitHeight(processo1_recurso3_aresta.getFitHeight());
		processo10_recurso8_aresta.setLayoutX(processo1_recurso3_aresta.getLayoutX() + 7 * 60);
		processo10_recurso8_aresta.setLayoutY(processo1_recurso3_aresta.getLayoutY());
		processo10_recurso8_aresta.setRotate(-processo1_recurso3_aresta.getRotate());
		processo10_recurso8_aresta.setImage(processo1_recurso8_aresta.getImage());
		processo10_recurso8_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo10_recurso8_aresta);
		
		processo10_recurso9_aresta = new ImageView();
		processo10_recurso9_aresta.setFitWidth(10);
		processo10_recurso9_aresta.setFitHeight(processo1_recurso2_aresta.getFitHeight());
		processo10_recurso9_aresta.setLayoutX(processo1_recurso2_aresta.getLayoutX() + 8 * 60);
		processo10_recurso9_aresta.setLayoutY(processo1_recurso2_aresta.getLayoutY());
		processo10_recurso9_aresta.setRotate(-processo1_recurso2_aresta.getRotate());
		processo10_recurso9_aresta.setImage(processo1_recurso9_aresta.getImage());
		processo10_recurso9_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo10_recurso9_aresta);
		
		processo10_recurso10_aresta = new ImageView();
		processo10_recurso10_aresta.setFitWidth(10);
		processo10_recurso10_aresta.setFitHeight(processo1_recurso1_aresta.getFitHeight());
		processo10_recurso10_aresta.setLayoutX(processo1_recurso1_aresta.getLayoutX() + 9 * 60);
		processo10_recurso10_aresta.setLayoutY(processo1_recurso1_aresta.getLayoutY());
		processo10_recurso10_aresta.setRotate(-processo1_recurso1_aresta.getRotate());
		processo10_recurso10_aresta.setImage(processo1_recurso10_aresta.getImage());
		processo10_recurso10_aresta.setVisible(false);
		grafo_pane.getChildren().add(processo10_recurso10_aresta);
	}
	
	public void Ajustar_Arestas(){
		Ajustar_Arestas_Processo6();
		Ajustar_Arestas_Processo7();
		Ajustar_Arestas_Processo8();
		Ajustar_Arestas_Processo9();
		Ajustar_Arestas_Processo10();
		novo_processo_window.toFront();
	}
	
	public void Voltar_Menu(){
		remocao.setVolume(0.0);
		for(Processo p : processos){
			if(p.id != -1){
				p.Parar_Rodar(false);
				Encerrar_Processo(p.id);
			}
		}
		for(Recurso r : recursos){
			grafo.Remover(r.vertice);
		}
		finalizar_processo_bt.setText("Finalizar Processo");
		modo_remocao = false;
		novo_processo_bt.setVisible(true);
		finalizar_processo_bt.getScene().setCursor(Cursor.DEFAULT);
		so.Parar_Rodar(false);
		gerenciador_main_window.setVisible(false);
		gerenciador_main_window.setDisable(true);
		voltar_menu.setVisible(false);
		voltar_menu.setDisable(true);
		menu_bg.setImage(desktop);
		add.setDisable(false);
		start.setDisable(false);
		configuracao.setDisable(false);
		recurso1.setVisible(true);
		recurso2.setVisible(true);
		recurso3.setVisible(true);
		recurso4.setVisible(true);
		recurso5.setVisible(true);
		recurso6.setVisible(true);
		recurso7.setVisible(true);
		recurso8.setVisible(true);
		recurso9.setVisible(true);
		recurso10.setVisible(true);
		historico.clear();
		processo_id.clear();
		processo_nome.clear();
		processo_ts.clear();
		processo_tu.clear();
		processo_imagem.getSelectionModel().select(0);
		Fechar_Gerenciador_Processos();
		loki_icon.setImage(rosto4);
		dialogo_info.setText("");
		tem_campos_vazios = false;
		tutorial = false;
		Platform.runLater(()->{processos.clear();});
	}
	
	public void Configurar_Som(){
		com_som = !com_som;		
		if(com_som){
			som.setGraphic(com_som_img);
			novo_dispositivo_reconhecido.setVolume(1.0);
			dispositivo_removido.setVolume(1.0);
			erro.setVolume(1.0);
			confirmar_tempo.setVolume(1.0);
			remocao.setVolume(1.0);
		}
		else{
			som.setGraphic(sem_som_img);
			novo_dispositivo_reconhecido.setVolume(0.0);
			dispositivo_removido.setVolume(0.0);
			erro.setVolume(0.0);
			confirmar_tempo.setVolume(0.0);
			remocao.setVolume(0.0);
		}
	}
	
	public void Carregar_Audios(){
		startup = new MediaPlayer(new Media(this.getClass().getResource("/Fontes/Sons/startup.mp3").toExternalForm()));
		startup.setCycleCount(1);
		off = new MediaPlayer(new Media(this.getClass().getResource("/Fontes/Sons/logoff.mp3").toExternalForm()));
		off.setCycleCount(1);
		novo_dispositivo_reconhecido = new MediaPlayer(new Media(this.getClass().getResource("/Fontes/Sons/novo_dispositivo_reconhecido.mp3").toExternalForm())); 
		novo_dispositivo_reconhecido.setCycleCount(1);
		dispositivo_removido = new MediaPlayer(new Media(this.getClass().getResource("/Fontes/Sons/dispositivo_removido.mp3").toExternalForm())); 
		dispositivo_removido.setCycleCount(1);
		erro = new MediaPlayer(new Media(this.getClass().getResource("/Fontes/Sons/erro.mp3").toExternalForm())); 
		erro.setCycleCount(1);
		confirmar_tempo = new MediaPlayer(new Media(this.getClass().getResource("/Fontes/Sons/confirmar_tempo.mp3").toExternalForm())); 
		confirmar_tempo.setCycleCount(1);
		remocao = new MediaPlayer(new Media(this.getClass().getResource("/Fontes/Sons/remocao.mp3").toExternalForm())); 
		remocao.setCycleCount(1);
	}
	
	public void Remover_Recurso(){
		Esconder_Remover_Recurso();
		recurso1.setImage(null);
		recurso2.setImage(null);
		recurso3.setImage(null);
		recurso4.setImage(null);
		recurso5.setImage(null);
		recurso6.setImage(null);
		recurso7.setImage(null);
		recurso8.setImage(null);
		recurso9.setImage(null);
		recurso10.setImage(null);
		n_recursos--;
		int aux = n_recursos;
		recursos.remove(recurso_atual_selecionado);
		dispositivo_removido.seek(Duration.seconds(0));
		dispositivo_removido.play();
		Mostrar_Notificacao("Recurso '" + recurso_atual_selecionado.nome + "' removido!");
		for(n_recursos = 1; n_recursos <= aux; n_recursos++)
			Atualizar_Area_de_Trabalho();
		n_recursos = aux;
		recurso1.setOpacity(1.0);
		recurso2.setOpacity(1.0);
		recurso3.setOpacity(1.0);
		recurso4.setOpacity(1.0);
		recurso5.setOpacity(1.0);
		recurso6.setOpacity(1.0);
		recurso7.setOpacity(1.0);
		recurso8.setOpacity(1.0);
		recurso9.setOpacity(1.0);
		recurso10.setOpacity(1.0);
		recurso_id.setText(String.valueOf(n_recursos + 1));
	}
	
	public void Esconder_Remover_Recurso(){
		remover_recurso.setVisible(false);
		remover_recurso.setDisable(true);
		if(n_recursos > 0){
			if(recurso_atual_selecionado.equals(recursos.get(0))){
				Tirar_Foco_Recurso_1();
			}
		}
		if(n_recursos > 1){
			if(recurso_atual_selecionado.equals(recursos.get(1))){
				Tirar_Foco_Recurso_2();
			}
		}
		if(n_recursos  > 2){
			if(recurso_atual_selecionado.equals(recursos.get(2))){
				Tirar_Foco_Recurso_3();
			}
		}
		if(n_recursos > 3){
			if(recurso_atual_selecionado.equals(recursos.get(3))){
				Tirar_Foco_Recurso_4();
			}
		}
		if(n_recursos > 4){
			if(recurso_atual_selecionado.equals(recursos.get(4))){
				Tirar_Foco_Recurso_5();
			}
		}
		if(n_recursos > 5){
			if(recurso_atual_selecionado.equals(recursos.get(5))){
				Tirar_Foco_Recurso_6();
			}
		}
		if(n_recursos > 6){
			if(recurso_atual_selecionado.equals(recursos.get(6))){
				Tirar_Foco_Recurso_7();
			}
		}
		if(n_recursos > 7){
			if(recurso_atual_selecionado.equals(recursos.get(7))){
				Tirar_Foco_Recurso_8();
			}
		}
		if(n_recursos > 8){
			if(recurso_atual_selecionado.equals(recursos.get(8))){
				Tirar_Foco_Recurso_9();
			}
		}
		if(n_recursos > 9){
			if(recurso_atual_selecionado.equals(recursos.get(9))){
				Tirar_Foco_Recurso_10();
			}
		}
	}
	
	public void Mostrar_Botao_Remocao(){
		remover_recurso.setVisible(true);
		remover_recurso.setDisable(false);
		if(recurso_atual_selecionado.equals(recursos.get(0))){
			Foco_Recurso_1();
		}
		else if(recurso_atual_selecionado.equals(recursos.get(1))){
			Foco_Recurso_2();
		}
		else if(recurso_atual_selecionado.equals(recursos.get(2))){
			Foco_Recurso_3();
		}
		else if(recurso_atual_selecionado.equals(recursos.get(3))){
			Foco_Recurso_4();
		}
		else if(recurso_atual_selecionado.equals(recursos.get(4))){
			Foco_Recurso_5();
		}
		else if(recurso_atual_selecionado.equals(recursos.get(5))){
			Foco_Recurso_6();
		}
		else if(recurso_atual_selecionado.equals(recursos.get(6))){
			Foco_Recurso_7();
		}
		else if(recurso_atual_selecionado.equals(recursos.get(7))){
			Foco_Recurso_8();
		}
		else if(recurso_atual_selecionado.equals(recursos.get(8))){
			Foco_Recurso_9();
		}
		else if(recurso_atual_selecionado.equals(recursos.get(9))){
			Foco_Recurso_10();
		}
	}
	
	public void Recurso1_Selecionado(){
		if(recursos.size() > 0){
			recurso_atual_selecionado = recursos.get(0);
			remover_recurso.setTranslateX(0);
			remover_recurso.setTranslateY(0);
			Mostrar_Botao_Remocao();
		}
	}
	
	public void Recurso2_Selecionado(){
		if(recursos.size() > 1){
			recurso_atual_selecionado = recursos.get(1);
			remover_recurso.setTranslateY(50);
			remover_recurso.setTranslateX(0);
			Mostrar_Botao_Remocao();
		}
	}
	
	public void Recurso3_Selecionado(){
		if(recursos.size() > 2){
			recurso_atual_selecionado = recursos.get(2);
			remover_recurso.setTranslateY(2 * 50);
			remover_recurso.setTranslateX(0);
			Mostrar_Botao_Remocao();
		}
	}
	
	public void Recurso4_Selecionado(){
		if(recursos.size() > 3){
			recurso_atual_selecionado = recursos.get(3);
			remover_recurso.setTranslateY(3 * 50);
			remover_recurso.setTranslateX(0);
			Mostrar_Botao_Remocao();
		}
	}
	
	public void Recurso5_Selecionado(){
		if(recursos.size() > 4){
			recurso_atual_selecionado = recursos.get(4);
			remover_recurso.setTranslateY(4 * 50);
			remover_recurso.setTranslateX(0);
			Mostrar_Botao_Remocao();
		}
	}
	
	public void Recurso6_Selecionado(){
		if(recursos.size() > 5){
			recurso_atual_selecionado = recursos.get(5);
			remover_recurso.setTranslateY(5 * 50);
			remover_recurso.setTranslateX(0);
			Mostrar_Botao_Remocao();
		}
	}
	
	public void Recurso7_Selecionado(){
		if(recursos.size() > 6){
			recurso_atual_selecionado = recursos.get(6);
			remover_recurso.setTranslateY(6 * 50);
			remover_recurso.setTranslateX(0);
			Mostrar_Botao_Remocao();
		}
	}
	
	public void Recurso8_Selecionado(){
		if(recursos.size() > 7){
			recurso_atual_selecionado = recursos.get(7);
			remover_recurso.setTranslateY(7 * 50);
			remover_recurso.setTranslateX(0);
			Mostrar_Botao_Remocao();
		}
	}
	
	public void Recurso9_Selecionado(){
		if(recursos.size() > 8){
			recurso_atual_selecionado = recursos.get(8);
			remover_recurso.setTranslateX(50);
			remover_recurso.setTranslateY(0);
			Mostrar_Botao_Remocao();
		}
	}
	
	public void Recurso10_Selecionado(){
		if(recursos.size() > 9){
			recurso_atual_selecionado = recursos.get(9);
			remover_recurso.setTranslateX(50);
			remover_recurso.setTranslateY(50);
			Mostrar_Botao_Remocao();
		}
	}
	
	public void Foco_Remover_Recurso(){
		Mostrar_Botao_Remocao();
	}
	
	public void Mostrar_Dialogo_Info(boolean deadlock) {
		Platform.runLater(() -> {
			if(deadlock) {
				loki_icon.setImage(rostos_dead_lock[new Random().nextInt(rostos_dead_lock.length)]);
				dialogo_info.setTextFill(Color.RED);
				if(this.dead_lock) {
					dialogo_info.setText(frases_dead_lock_continua[new Random().nextInt(frases_dead_lock_continua.length)]);
				}
				else {
					dialogo_info.setText(frases_dead_lock[new Random().nextInt(frases_dead_lock.length)]);
				}
				this.dead_lock = true;
			}
			else {
				loki_icon.setImage(rostos_normal[new Random().nextInt(rostos_normal.length)]);
				dialogo_info.setTextFill(Color.BLUE);
				if(n_processos == 0) {
					dialogo_info.setText(frases_sem_processos[new Random().nextInt(frases_sem_processos.length)]);
				}
				else {
					if(this.dead_lock) {
						dialogo_info.setText(frases_dead_lock_desfeito[new Random().nextInt(frases_dead_lock_desfeito.length)]);
					}
					else {
						dialogo_info.setText(frases_normal[new Random().nextInt(frases_normal.length)]);
					}
				}
				this.dead_lock = false;
			}
		});
	}
	
	public void Passar_Passo_Tutorial() {
		if(passo_tutorial == 12)
			passo_tutorial = 14;
		else
			passo_tutorial++;
		Mostrar_Tutorial();
	}
	
	public void Voltar_Passo_Tutorial() {
		passo_tutorial--;
		Mostrar_Tutorial();
	}
	
	public void Pular_Tutorial() {
		passo_tutorial = 14;
		Mostrar_Tutorial();
	}
	
	public void Clicou_Microfone() {
		passo_tutorial = 13;
		Mostrar_Tutorial();
	}
	
	public void Mostrar_Tutorial() {
		if(!tutorial) {
			passo_tutorial = 14;
		}
		switch (passo_tutorial) {
			case 0:
				tab_detalhes.setDisable(true);
				tab_detalhes.setText("");
				tab_logs.setDisable(true);
				tab_logs.setText("");
				loki_icon.setImage(rosto6);
				dialogo_info.setText("Olá,bem vindo ao SORDEL (Sistema Operacional Reconhecedor de DeadLock). Eu sou "
				+ "Loki, o seu assistente pessoal e vou te explicar sobre as coisas aqui. Se você clicar em próximo a gente"
				+ " continua, mas se você clicar nesse botão feioso escrito Pular, aí eu não vou te explicar nada.");
				novo_processo_bt.setVisible(false);
				novo_processo_bt.setDisable(true);
				break;
			case 1:
				novo_processo_bt.setVisible(false);
				novo_processo_bt.setDisable(true);
				pular.setVisible(false);
				pular.setDisable(true);
				anterior.setVisible(false);
				anterior.setDisable(true);
				loki_icon.setImage(rosto7);
				dialogo_info.setText("Você está no modo de gerenciamento e análise de processos, ou como eu gosto de chamar, minha sala de estar,  aqui é onde eu me divirto assistindo "
				+ "aos processos, vendo o que eles fazem e como se relacionam com os outros processos e os recursos.");
				break;
			case 2:
				loki_icon.setImage(rosto4);
				anterior.setVisible(true);
				anterior.setDisable(false);
				novo_processo_bt.setVisible(true);
				grafo_processo1.setImage(null);
				dialogo_info.setText("Quando quiser adicionar um novo processo clique em Novo Processo.Não tente clicar agora, eu ainda "
				+ "estou no meio do tutorial, você só poderá clicar em alguma coisa que não seja esse botão de Próximo ou Anterior"
				+ " quando eu terminar de te explicar tudo.");
				break;
			case 3:
				loki_icon.setImage(rosto6);
				grafo_processo1.setImage(java_img);
				grafo_recurso1.setImage(null);
				processo1_recurso1_aresta.setVisible(false);
				dialogo_info.setText("Os processos adicionados ficarão visíveis aqui, nesse exemplo, nós temos esse processo Java rodando"
						+ ", ao longo do tempo, os processos irão solicitar recursos...");
				break;
			case 4:
				loki_icon.setImage(rosto7);
				grafo_recurso1.setImage(impressora_img);
				processo1_recurso1_aresta.setVisible(true);
				processo1_recurso1_aresta.setRotate(0.0);
				dialogo_info.setText("Quando um processo solicitar um recurso, será desenhada uma seta desse jeito, indicando que o "
						+ "processo X solicitou o recurso Y.");
				break;
			case 5:
				loki_icon.setImage(rosto6);
				processo1_recurso1_aresta.setRotate(180.0);
				grafo_processo2.setImage(null);
				grafo_recurso2.setImage(null);
				processo2_recurso2_aresta.setVisible(false);
				processo2_recurso2_aresta.setRotate(0.0);
				processo2_recurso1_aresta.setVisible(false);
				grafo_processo3.setImage(null);
				processo3_recurso2_aresta.setVisible(false);
				dialogo_info.setText("Se o recurso estiver disponível, a seta muda de sentido indicando que o processo está em posse "
						+ " do recurso. Até aqui eu acredito que esteja tudo bem. Se sim, clique em próximo para continuarmos.");
				break;
			case 6:
				loki_icon.setImage(rosto7);
				grafo_processo2.setImage(mozilla_img);
				grafo_recurso2.setImage(cd_img);
				processo2_recurso2_aresta.setVisible(true);
				processo2_recurso2_aresta.setRotate(180.0);
				processo2_recurso1_aresta.setVisible(true);
				processo1_recurso2_aresta.setVisible(false);
				grafo_processo3.setImage(ds_img);
				processo3_recurso2_aresta.setVisible(true);
				grafo_processo1.setEffect(null);
				grafo_processo2.setEffect(null);
				grafo_processo3.setEffect(null);
				dialogo_info.setText("Suponha agora que temos mais processos e mais recursos em uma situação como essa, se continuar assim, "
						+ "não teremos problemas, mas se o processo Java solicitar o recurso CD, nós cairemos em uma situação "
						+ "que eu detesto quando acontece...");
				break;
			case 7:
				loki_icon.setImage(rosto1);
				processo1_recurso2_aresta.setVisible(true);
				grafo_processo1.setEffect(contorno_bloqueado);
				grafo_processo2.setEffect(contorno_bloqueado);
				grafo_processo3.setEffect(contorno_impedido);
				finalizar_processo_bt.setVisible(false);
				dialogo_info.setText("...aqui, meu amigo, nós temos um DEADLOCK, isso é horrível, mas infelizmente, inevitável. "
						+ "Quando ele aparecer os processos dentro do ciclo estarão travados e aqueles dependentes de algum recurso dentro do ciclo estarão impedidos."
						+ "Se nada for feito, eles ficarão assim eternamente e eu ficarei muito triste.");
				break;
			case 8:
				loki_icon.setImage(rosto5);
				finalizar_processo_bt.setVisible(true);
				finalizar_processo_bt.setDisable(true);
				grafo_processo2.setImage(mozilla_img);
				processo2_recurso2_aresta.setRotate(180);
				processo2_recurso2_aresta.setVisible(true);
				processo2_recurso1_aresta.setVisible(true);
				grafo_processo1.setEffect(contorno_bloqueado);
				grafo_processo2.setEffect(contorno_bloqueado);
				grafo_processo3.setEffect(contorno_impedido);
				processo3_recurso2_aresta.setRotate(22);
				dialogo_info.setText("Sorte a nossa que eu tenho esse botão mágico Finalizar Processo, quando clicar nele "
						+ "você poderá matar um processo que esteja causando DEADLOCK, eu não gosto muito da ideia de matar, mas "
						+ "nesse caso é necessário para o bem maior.");
				break;
			case 9:
				grafo_processo2.setImage(null);
				processo2_recurso2_aresta.setRotate(0.0);
				processo2_recurso2_aresta.setVisible(false);
				processo2_recurso1_aresta.setVisible(false);
				grafo_processo1.setEffect(null);
				grafo_processo2.setEffect(null);
				grafo_processo3.setEffect(null);
				tab_detalhes.setText("");
				processo3_recurso2_aresta.setRotate(processo3_recurso2_aresta.getRotate() + 180);
				loki_icon.setImage(rosto8);
				dialogo_info.setText("Se matássemos o processo Mozilla, o DEADLOCK acabaria e os demais processos poderiam "
						+ "rodar normalmente e isso é INCRÍVEL!");
				break;
			case 10:
				loki_icon.setImage(rosto6);
				tab_detalhes.setText("Detalhes");
				tab_logs.setText("");
				dialogo_info.setText("Na aba detalhes você tem, como o nome sugere, mais detalhes sobre os processos, bem como "
						+ "os recursos que cada processo está usando e quanto tempo falta para cada recurso ser liberado. "
						+ "Não é tão legal quanto essa aba, mas tem informação úteis.");
				break;
			case 11:
				loki_icon.setImage(rosto7);
				tab_logs.setText("Logs");
				mic.setVisible(false);
				mic.setDisable(true);
				voltar_menu.setVisible(false);
				voltar_menu.setDisable(true);
				dialogo_info.setText("Por último, temos a aba Logs, nela nós podemos ver detalhadamente tudo que aconteceu "
						+ "desde o início da análise, quais processos entraram em DEADLOCK, ou ficaram impedidos, quando cada "
						+ "evento aconteceu, enfim, tudo que rolar aqui você pode conferir lá, é tipo meu diário de anotações.");
				break;
			case 12:
				mic.setVisible(true);
				mic.setDisable(false);
				loki_icon.setImage(rosto6);
				voltar_menu.setVisible(true);
				voltar_menu.setDisable(false);
				dialogo_info.setText("Esqueci de mencionar o botão vermelho com um X lá em cima, se quiser voltar "
						+ " para a área de trabalho para adicionar ou remover recursos é só clicar nele."
						+ " Acho que eu já expliquei tudo que você precisava saber. Clique em próximo, ou clique e segure no "
						+ "ícone do microfone e fale: 'próximo' para começarmos a análise.");
				break;
			case 13:
				mic.setVisible(false);
				mic.setDisable(true);
				loki_icon.setImage(rosto7);
				dialogo_info.setText("Você por um acaso clicou no microfone e falou próximo? (Risos...) Eu não tenho um sistema "
						+ "reconhecedor de voz como minhas amigas Cortana e Siri, eu fui feito em poucos dias, meus desenvolvedores não tiveram tempo de me programar "
						+ "com tais funções, talvez um dia, numa versão aprimorada. Enfim, clique em próximo para começarmos as análises, agora é sério!");
				break;
			case 14:
				mic.setVisible(false);
				mic.setDisable(true);
				tab_detalhes.setDisable(false);
				tab_detalhes.setText("Detalhes");
				tab_logs.setDisable(false);
				tab_logs.setText("Logs");
				loki_icon.setImage(rosto4);
				pular.setVisible(false);
				pular.setDisable(true);
				proximo.setVisible(false);
				proximo.setDisable(true);
				anterior.setVisible(false);
				anterior.setDisable(true);
				novo_processo_bt.setVisible(true);
				novo_processo_bt.setDisable(false);
				finalizar_processo_bt.setVisible(false);
				finalizar_processo_bt.setDisable(false);
				grafo_processo1.setImage(null);
				grafo_processo3.setImage(null);
				processo1_recurso1_aresta.setRotate(0.0);
				processo1_recurso1_aresta.setVisible(false);
				processo1_recurso2_aresta.setVisible(false);
				processo3_recurso2_aresta.setRotate(22);
				processo3_recurso2_aresta.setVisible(false);
				dialogo_info.setFont(new Font("System",18));	
				for(Recurso r : recursos)
					grafo.add(r.vertice);
				if(com_som)
					remocao.setVolume(1.0);
				voltar_menu.setVisible(true);
				voltar_menu.setDisable(false);
				grafo_recurso1.setImage(recurso1.getImage());
				grafo_recurso2.setImage(recurso2.getImage());
				grafo_recurso3.setImage(recurso3.getImage());
				grafo_recurso4.setImage(recurso4.getImage());
				grafo_recurso5.setImage(recurso5.getImage());
				grafo_recurso6.setImage(recurso6.getImage());
				grafo_recurso7.setImage(recurso7.getImage());
				grafo_recurso8.setImage(recurso8.getImage());
				grafo_recurso9.setImage(recurso9.getImage());
				grafo_recurso10.setImage(recurso10.getImage());
				historico.clear();
				dialogo_info.setText("");
				processo_id.setText(String.valueOf(1));
				LocalTime instante = LocalTime.now();
				Atualizar_Log(instante, "Análise iniciada.");
				gerenciador_main_window.getSelectionModel().select(0);
				so.set_Grafo(grafo);
				Ajustar_Arestas();
				so.Parar_Rodar(true);
				break;
			default:
				break;
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Platform.runLater( () -> {Setar_Imagens();});
		Platform.runLater( () -> {menu_bg.requestFocus();});
		
		Carregar_Lista_Imagens_Recursos();
		Carregar_Lista_Imagens_Processos();
		Caregar_Notificacao();
		Carregar_Audios();
		
		so = new Sistema_Operacional(0);
		
		recurso1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MouseButton button = event.getButton();
                if(button==MouseButton.SECONDARY)
                    Recurso1_Selecionado();
            }
        });
		
		recurso2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MouseButton button = event.getButton();
                if(button==MouseButton.SECONDARY)
                    Recurso2_Selecionado();
            }
        });
		
		recurso3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MouseButton button = event.getButton();
                if(button==MouseButton.SECONDARY)
                    Recurso3_Selecionado();
            }
        });
		
		recurso4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MouseButton button = event.getButton();
                if(button==MouseButton.SECONDARY)
                    Recurso4_Selecionado();
            }
        });
		
		recurso5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MouseButton button = event.getButton();
                if(button==MouseButton.SECONDARY)
                    Recurso5_Selecionado();
            }
        });
		
		recurso6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MouseButton button = event.getButton();
                if(button==MouseButton.SECONDARY)
                    Recurso6_Selecionado();
            }
        });
		
		recurso7.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MouseButton button = event.getButton();
                if(button==MouseButton.SECONDARY)
                    Recurso7_Selecionado();
            }
        });
		
		recurso8.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MouseButton button = event.getButton();
                if(button==MouseButton.SECONDARY)
                    Recurso8_Selecionado();
            }
        });
		
		recurso9.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MouseButton button = event.getButton();
                if(button==MouseButton.SECONDARY)
                    Recurso9_Selecionado();
            }
        });
		
		recurso10.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MouseButton button = event.getButton();
                if(button==MouseButton.SECONDARY)
                    Recurso10_Selecionado();
            }
        });
		so.set_Controller(controlador);
		Sistema = new Thread(so);
		Sistema.start();
	}
}
