package es.iesjandula.sopa_letras.controllers;

import es.iesjandula.sopa_letras.models.Coordenadas;

/**
 * Esta clase crea una sopa de letras
 */
public class SopaLetras
{
	/**
	 * Crea una tabla bidimensional
	 */
	private char[][] sopaletras;

	/**
	 * Este constructor inicializa el array dimensional
	 * 
	 * @param dimensiones dimensiona el array
	 */
	public SopaLetras(int dimensiones)
	{
		if (dimensiones <= 0)
		{
			throw new RuntimeException("Dimensiones incorrectas");
		}

		this.sopaletras = new char[dimensiones][dimensiones];

		for (int i = 0; i < sopaletras.length; i++)
		{
			for (int j = 0; j < sopaletras[i].length; j++)
			{
				this.sopaletras[i][j] = '*';
			}
		}
	}

	/**
	 * Coloca una palabra en sentido horizontal
	 * 
	 * @param palabra    que se desea colocar
	 * @param coordenada que se desea indicar
	 */
	public void colocarPalabraHorizontal(String palabra, Coordenadas coordenada)
	{
		if (palabra == null || palabra.isEmpty())
		{
			throw new RuntimeException("Hay que introducir una palabra válida");
		}

		if (coordenada == null || !coordenada.isCorrecta())
		{
			throw new RuntimeException("Hay que introducir una coordenada válida");
		}

		if (coordenada.isSentidoNatural())
		{
			if (palabra.length() + coordenada.getColumna() > sopaletras.length)
			{
				throw new RuntimeException("La palabra " + palabra + " tiene una tamaño " + palabra.length()
						+ " mayor al tamaño de la tabla " + this.sopaletras.length + " en orden natural ");
			}

			for (int i = 0; i < palabra.length(); i++)
			{
				sopaletras[coordenada.getFila()][coordenada.getColumna() + i] = palabra.charAt(i);
			}

		} else
		{
			if (coordenada.getColumna() - palabra.length() + 1 < 0)
			{
				throw new RuntimeException("La palabra " + palabra + " tiene una tamaño " + palabra.length()
						+ " mayor que el minimo de la tabla en orden inverso");
			}

			for (int i = 0; i < palabra.length(); i++)
			{
				sopaletras[coordenada.getFila()][coordenada.getColumna() - i] = palabra.charAt(i);
			}
		}
	}

	/**
	 * Coloca una palabra en sentido vertical
	 * 
	 * @param palabra    que se desea colocar
	 * @param coordenada que se desea indicar
	 */
	public void colocarPalabraVertical(String palabra, Coordenadas coordenada)
	{
		if (palabra == null || palabra.isEmpty())
		{
			throw new RuntimeException("Hay que introducir una palabra válida");
		}

		if (coordenada == null || !coordenada.isCorrecta())
		{
			throw new RuntimeException("Hay que introducir una coordenada válida");
		}

		if (coordenada.isSentidoNatural())
		{
			// Sentido natural: de arriba hacia abajo
			if (palabra.length() + coordenada.getFila() > sopaletras.length)
			{
				throw new RuntimeException("La palabra " + palabra + " tiene tamaño " + palabra.length()
						+ " y no cabe en la tabla de tamaño " + this.sopaletras.length + " desde la fila "
						+ coordenada.getFila() + " en sentido natural");
			}

			for (int i = 0; i < palabra.length(); i++)
			{
				sopaletras[coordenada.getFila() + i][coordenada.getColumna()] = palabra.charAt(i);
			}
		} else
		{
			// Sentido inverso: de abajo hacia arriba
			if (coordenada.getFila() - palabra.length() + 1 < 0)
			{
				throw new RuntimeException("La palabra " + palabra + " tiene tamaño " + palabra.length()
						+ " y no cabe en la tabla de tamaño " + this.sopaletras.length + " desde la fila "
						+ coordenada.getFila() + " en sentido inverso");
			}

			for (int i = 0; i < palabra.length(); i++)
			{
				sopaletras[coordenada.getFila() - i][coordenada.getColumna()] = palabra.charAt(i);
			}
		}

	}

	public void imprimir()
	{
		for (int i = 0; i < sopaletras.length; i++)
		{
			for (int j = 0; j < sopaletras[i].length; j++)
			{
				System.out.print(sopaletras[i][j] + " ");
			}
			System.out.println();
		}

	}

}