package br.com.fiap.techchallenge.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Configuration;

public class EntityManagerFabrica {
	private static final EntityManagerFactory FACTORY = Persistence
		.createEntityManagerFactory("techchallange");


	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}
