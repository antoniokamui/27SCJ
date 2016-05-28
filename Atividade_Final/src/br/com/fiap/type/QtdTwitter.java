package br.com.fiap.type;

import java.time.LocalDate;

public class QtdTwitter {
	
	private LocalDate data;
	private int qtdTweetsDia;
	private int qtdRETweetsDia;
	private int qtdFavoDia;
	private String qtdTweetsDiaTXT;
	private String qtdRETweetsDiaTXT;
	private String qtdFavoDiaTXT;
	
	
	public int getQtdTweetsDia() {
		return qtdTweetsDia;
	}
	public void setQtdTweetsDia(int qtdTweetsDia) {
		this.qtdTweetsDia = qtdTweetsDia;
	}
	public int getQtdRETweetsDia() {
		return qtdRETweetsDia;
	}
	public void setQtdRETweetsDia(int qtdRETweetsDia) {
		this.qtdRETweetsDia = qtdRETweetsDia;
	}
	public int getQtdFavoDia() {
		return qtdFavoDia;
	}
	public void setQtdFavoDia(int qtdFavoDia) {
		this.qtdFavoDia = qtdFavoDia;
	}
	public String getQtdTweetsDiaTXT() {
		return qtdTweetsDiaTXT;
	}
	public void setQtdTweetsDiaTXT(String qtdTweetsDiaTXT) {
		this.qtdTweetsDiaTXT = qtdTweetsDiaTXT;
	}
	public String getQtdRETweetsDiaTXT() {
		return qtdRETweetsDiaTXT;
	}
	public void setQtdRETweetsDiaTXT(String qtdRETweetsDiaTXT) {
		this.qtdRETweetsDiaTXT = qtdRETweetsDiaTXT;
	}
	public String getQtdFavoDiaTXT() {
		return qtdFavoDiaTXT;
	}
	public void setQtdFavoDiaTXT(String qtdFavoDiaTXT) {
		this.qtdFavoDiaTXT = qtdFavoDiaTXT;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	

}
