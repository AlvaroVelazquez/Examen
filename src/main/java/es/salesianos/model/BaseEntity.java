package es.salesianos.model;

import org.springframework.stereotype.Component;

@Component
public class BaseEntity {

	
	private Integer cod;

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}
}
