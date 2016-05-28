package br.com.fiap.utils;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class Conexao {

	public Twitter conectarTwitter(String token, String tokenSecret, String consumerKey, String consumerSecret)
			throws Exception {
		Twitter twitter = null;
		try {
			ConfigurationBuilder builder = new ConfigurationBuilder();

			builder.setOAuthConsumerKey(consumerKey);
			builder.setOAuthConsumerSecret(consumerSecret);
			Configuration configuracao = builder.build();

			TwitterFactory factory = new TwitterFactory(configuracao);
			twitter = factory.getInstance();
			AccessToken tokenAcesso = loadAccessToken(token, tokenSecret);
			twitter.setOAuthAccessToken(tokenAcesso);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro no metodo conectarTwitter() ");
		}
		return twitter;
	}

	private static AccessToken loadAccessToken(String token, String tokenSecret) {

		return new AccessToken(token, tokenSecret);
	}

}
