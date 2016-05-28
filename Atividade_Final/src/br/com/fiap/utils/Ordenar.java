package br.com.fiap.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import twitter4j.Status;

public class Ordenar {

	
	public void ordernarData(List<Status> lista){
		
		Collections.sort(lista, new Comparator<Status>() {

			@Override
			public int compare(Status o1, Status o2) {
				return o1.getCreatedAt().compareTo(o2.getCreatedAt());
			}
		});
			
	}
	
	public void ordernarNomes(List<Status> lista){
	
	Collections.sort(lista, new Comparator<Status>() {

		@Override
		public int compare(Status o1, Status o2) {
			return o1.getUser().getScreenName().compareTo(o2.getUser().getScreenName());
		}
	});
	}
	
}
