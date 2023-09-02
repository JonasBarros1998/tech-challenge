package br.com.fiap.techchallenge.View.Controller.Annotations;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

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
