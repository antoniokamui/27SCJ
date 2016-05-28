package br.com.fiap.bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.type.QtdTwitter;
import br.com.fiap.utils.Conexao;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class BuscaTwitter {
 
	private List<Status> listaStatus;
	private	int quantidadeTweetsTotal = 0;
	private int quantidadeRETweetsTotal = 0;
	private int quantidadeFavoritacaoTotal = 0;
	private QueryResult result;
	private ZoneId zona;
	private Query query;
	private LocalDate dataHJ;
	private DateTimeFormatter formatoTwitter;
	private DateTimeFormatter formatoBR;
	private int diasSince;
	private LocalDate dataSince;
	
	
	public BuscaTwitter(){
		diasSince = 7;
		dataHJ = LocalDate.now();
	    formatoTwitter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatoBR = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		dataHJ.minusDays(diasSince);
		dataHJ.format(formatoTwitter);
		dataSince = dataHJ.minusDays(diasSince);
	}
	
	

	
	
	public List<Status> buscarTwiiter(String rashTag, LocalDate dataSince, Twitter twitter){
		query = new Query(rashTag);
		query.setSince(String.valueOf(dataSince));
		listaStatus = new ArrayList<>();
		try{
		result = twitter.search(query);
		while (result.hasNext()) {
			listaStatus.addAll(result.getTweets());
			query = result.nextQuery();
			for (Status status : result.getTweets()) {
				quantidadeTweetsTotal++;
				quantidadeRETweetsTotal+=status.getRetweetCount();
				quantidadeFavoritacaoTotal+= status.getFavoriteCount();
				
			
			}
			result = twitter.search(query);
		}
		}
		 catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Tag #java9: De "+dataSince );
		System.out.println( quantidadeTweetsTotal + " TWEETS TOTAL ");
		System.out.println(quantidadeRETweetsTotal+" RETWEETS TOTAL");
		System.out.println(quantidadeFavoritacaoTotal+ " FAVORITACOES  TOTAL");
		System.out.println("\n");
		
		return listaStatus;
		
	}

	
	public List<QtdTwitter> qtdTweetsPorDia(List<Status> listaStatus) throws Exception{
		
		List<QtdTwitter> lista = new ArrayList<>();
		ZoneId zona =  ZoneId.systemDefault();
		Conexao conn = new Conexao();
		Twitter twitter = conn.conectarTwitter("ewd", "sdfsdf", "dsfvsfs", "sfsdf");
	
		Status statusPost = twitter.updateStatus("Termino da Atividade Final, do professor @michelpf");
		String mensagem = null;
		
		for(int i= 0; i <= 7 ; i++){	
			int qtdTweetsDia = 0;
			int qtdRETweetsDia = 0;
			int qtdFavoDia = 0;
			QtdTwitter qtd = new QtdTwitter();
			
			
			for(Status status : listaStatus){
			
				LocalDate dataDoTweet = status.getCreatedAt().toInstant().atZone(zona).toLocalDate();
				
				if(ChronoUnit.DAYS.between(dataDoTweet, getDataSince()) == 0){
					qtdTweetsDia++;
					qtdRETweetsDia += status.getRetweetCount();
					qtdFavoDia += status.getFavoriteCount();
				}
				
			}
			
			System.out.println(mensagem = "Dia " + dataSince.format(formatoBR));
			System.out.println(qtdTweetsDia + " TWEETS");
			System.out.println(qtdRETweetsDia + " RETWEETS");
			System.out.println(qtdFavoDia + " FAVORITACOES");
			System.out.println("\n");
			
			qtd.setData(dataSince);
			qtd.setQtdTweetsDia(qtdTweetsDia);
			qtd.setQtdRETweetsDia(qtdRETweetsDia);
			qtd.setQtdFavoDia(qtdFavoDia);
			qtd.setQtdFavoDiaTXT(qtdTweetsDia + " TWEETS");
			qtd.setQtdRETweetsDiaTXT(qtdRETweetsDia + " RETWEETS");
			qtd.setQtdFavoDiaTXT(qtdFavoDia + " FAVORITACOES");
			
			lista.add(qtd);
			
			
			setDataSince(dataHJ.minusDays(diasSince = diasSince - 1));
			
			mensagem = mensagem + " " + qtdTweetsDia + " TWEETS, " + qtdRETweetsDia + " RETWEETS, "+ qtdFavoDia + " FAVORITACOES";
			
			statusPost = twitter.updateStatus(mensagem +" professor @michelpf");
			
		}
		
		
		return lista;
	}

	
	
	
	


	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	public LocalDate getDataHJ() {
		return dataHJ;
	}
	public void setDataHJ(LocalDate dataHJ) {
		this.dataHJ = dataHJ;
	}
	public DateTimeFormatter getFormatoTwitter() {
		return formatoTwitter;
	}
	public void setFormatoTwitter(DateTimeFormatter formatoTwitter) {
		this.formatoTwitter = formatoTwitter;
	}
	public DateTimeFormatter getFormatoBR() {
		return formatoBR;
	}
	public void setFormatoBR(DateTimeFormatter formatoBR) {
		this.formatoBR = formatoBR;
	}
	public int getDiasSince() {
		return diasSince;
	}
	public void setDiasSince(int diasSince) {
		this.diasSince = diasSince;
	}
	public List<Status> getListaStatus() {
		return listaStatus;
	}
	public void setListaStatus(List<Status> listaStatus) {
		this.listaStatus = listaStatus;
	}
	public int getQuantidadeTweetsTotal() {
		return quantidadeTweetsTotal;
	}
	public void setQuantidadeTweetsTotal(int quantidadeTweetsTotal) {
		this.quantidadeTweetsTotal = quantidadeTweetsTotal;
	}
	public int getQuantidadeRETweetsTotal() {
		return quantidadeRETweetsTotal;
	}
	public void setQuantidadeRETweetsTotal(int quantidadeRETweetsTotal) {
		this.quantidadeRETweetsTotal = quantidadeRETweetsTotal;
	}
	public int getQuantidadeFavoritacaoTotal() {
		return quantidadeFavoritacaoTotal;
	}
	public void setQuantidadeFavoritacaoTotal(int quantidadeFavoritacaoTotal) {
		this.quantidadeFavoritacaoTotal = quantidadeFavoritacaoTotal;
	}
	public QueryResult getResult() {
		return result;
	}
	public void setResult(QueryResult result) {
		this.result = result;
	}
	public ZoneId getZona() {
		return zona;
	}
	public void setZona(ZoneId zona) {
		this.zona = zona;
	}
	public Query getQuery() {
		return query;
	}
	public void setQuery(Query query) {
		this.query = query;
	}





	public LocalDate getDataSince() {
		return dataSince;
	}





	public void setDataSince(LocalDate dataSince) {
		this.dataSince = dataSince;
	}
	
	
	
}
