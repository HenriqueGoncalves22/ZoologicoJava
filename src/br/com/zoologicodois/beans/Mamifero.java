package br.com.zoologicodois.beans;

public class Mamifero extends Animal{
	public int getMesesGestacao() {
		return mesesGestacao;
	}

	public void setMesesGestacao(int mesesGestacao) {
		this.mesesGestacao = mesesGestacao;
	}

	private int mesesGestacao;
}
