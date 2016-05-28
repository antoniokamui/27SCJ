package br.com.fiap.main;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.BuscaTwitter;
import br.com.fiap.type.QtdTwitter;
import br.com.fiap.utils.Conexao;
import br.com.fiap.utils.Ordenar;
import twitter4j.Status;
import twitter4j.Twitter;

public class MainObj {

	public static void main(String[] args) {
		
		String consumerKey = "24234";
		String consumerSecret = "234234";
		String token = "234234-234234";
		String tokenSecret = "fdg34234234";
		String rashTag = "#java9";
		Twitter twitter = null;
		BuscaTwitter buscaT = new BuscaTwitter();
		Conexao conn = new Conexao();
		List<Status> listaStatus = new ArrayList<>();
		List<QtdTwitter> listQtdTwitter = new ArrayList<>();
		ZoneId zona =  ZoneId.systemDefault();
		DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dataHJ = LocalDate.now();
		Ordenar ordernar = new Ordenar();
		String mensagem = null;
		Status status;
		
		
		LocalDate dataSince = dataHJ.minusDays(7);
		try{
			twitter = conn.conectarTwitter(token, tokenSecret, consumerKey, consumerSecret);
			System.out.println("Conectado ao Twitter!!!!");
					
			listaStatus = buscaT.buscarTwiiter(rashTag, dataSince, twitter);
			
			listQtdTwitter = buscaT.qtdTweetsPorDia(listaStatus);
		
			ordernar.ordernarNomes(listaStatus);
			System.out.println("Ordenação de nomes ");
			
			System.out.println("Primeiro nome " + listaStatus.get(0).getUser().getName());
			System.out.println("Ultimo nome " + listaStatus.get(listaStatus.size()-1).getUser().getName());
			
			mensagem = "Primeiro nome " + listaStatus.get(0).getUser().getName() + ", " + "Ultimo nome " + listaStatus.get(listaStatus.size()-1).getUser().getName();
			
			status = twitter.updateStatus(mensagem + " @michelpf ");
			ordernar.ordernarData(listaStatus);
			
			System.out.println("Ordenação de data: ");
			String dataMenor = listaStatus.get(0).getCreatedAt().toInstant().atZone(zona).toLocalDate().format(formatoBR);
		    String dataMaior = listaStatus.get(listaStatus.size()-1).getCreatedAt().toInstant().atZone(zona).toLocalDate().format(formatoBR);
			
			
			System.out.println("Menor Data " + dataMenor);
			System.out.println("Maior Data " + dataMaior);
			
			status = twitter.updateStatus( "Menor Data " + dataMenor + ", Maior Data " + dataMaior + " @michelpf ");
			
			status = twitter.updateStatus(" Termino da Atividade Final do professor @michelpf");
			System.out.println("Tweet postado com sucesso! [" + status.getText() + "].");
	
			
		   
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Erro ao executar o programa!");
		}
		

	}

}
