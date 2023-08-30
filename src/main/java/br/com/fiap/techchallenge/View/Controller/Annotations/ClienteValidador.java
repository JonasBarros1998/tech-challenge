package br.com.fiap.techchallenge.View.Controller.Annotations;

import br.com.fiap.techchallenge.domain.Entidades.Cliente;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.request.ServletWebRequest;
import jakarta.servlet.HttpMethodConstraintElement;

@Component
@RequestScope
public class ClienteValidador {

	@Autowired
	private HttpServletRequest request;

	public ClienteValidador() {
		System.out.println(">>> v " +  request.getMethod());
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println(">>> v " +  request.getMethod());
		return true;
	}


	/*
	@Override
	public void initialize(IClienteValidador annotation) {
		ConstraintValidator.super.initialize(annotation);
	}

	/**@apiNote
	 * Metodo de validacao
	 * <p>
	 * A validação apenas será ativada quando a requisicao ser do tipo `POST`

	@Override
	public boolean isValid(Cliente cliente, ConstraintValidatorContext context) {

		if (this.request.getMethod().equals("POST") && cliente == null) {
			return false;
		}

		return true;
	}*/

}
