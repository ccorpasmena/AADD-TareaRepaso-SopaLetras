package es.iesjandula.sopa_letras.models;

/**
 * Nos indica las coordenadas en cuanto a fila y columna
 */
public class Coordenadas
{
	/**
	 * Corrdenada fila
	 */
	private int fila;

	/**
	 * Coordenada Columna
	 */
	private int columna;

	/**
	 * sentido natural o inverso
	 */
	private boolean sentidoNatural;

	/**
	 * @param fila           coordenada de la fila
	 * @param columna        coordenada de la columna
	 * @param sentidoNatural sentido natural inverso
	 */
	public Coordenadas(int fila, int columna, boolean sentidoNatural)
	{
		this.fila = fila;
		this.columna = columna;
		this.sentidoNatural = sentidoNatural;
	}

	/**
	 * @return the fila nos devuelve la fila de la coordenada
	 */
	public int getFila()
	{
		return this.fila;
	}

	/**
	 * @return the columna nos devuelve la columna de las coordenadas
	 */
	public int getColumna()
	{
		return this.columna;
	}

	/**
	 * @return the sentidoNatural nos devuelve el sentido natural o inverso
	 */
	public boolean isSentidoNatural()
	{
		return this.sentidoNatural;
	}

	public boolean isCorrecta()
	{
		boolean correcto = true;

		if (this.fila < 0 || this.fila > Integer.MAX_VALUE)
		{
			correcto = false;
		}

		if (this.columna < 0 || this.columna > Integer.MAX_VALUE)
		{
			correcto = false;
		}

		return correcto;
	}

}
