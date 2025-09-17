package es.iesjandula.sopa_letras;

import es.iesjandula.sopa_letras.controllers.SopaLetras;
import es.iesjandula.sopa_letras.models.Coordenadas;

public class Main
{

	public static void main(String[] args)
	{

		SopaLetras sopa = new SopaLetras(10);
		sopa.colocarPalabraHorizontal("mon", new Coordenadas(0, 0, true));
		sopa.imprimir();

	}

}
