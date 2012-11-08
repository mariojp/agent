package br.com.mariojp.exemplos.missionarioscanibais;

import br.com.mariojp.ai.agent.AbstractState;


/**
 *
 * <p>Title: Agentes Inteligentes</p>
 *
 * <p>Description: Agente de Busca usando o algoritimo A* para resolver o problema dos canibais e missionarios. </p>
 *
 * <p>Copyright: Copyright Ability(c) 2005</p>
 *
 *
 * @author Mario Jorge e Fabio Barreto
 * @version 1.0
 *
 *Classe que representa estados possiveis para solução do problema dos caninais e missionarios
 */
public class Estado extends AbstractState {

    /**
     * Quantidade de Missionarios na margem Esquerda
     */
    private int qtdMissionariosEsquerda = 0;

    /**
     * Quantidade de Canibais na margem Esquerda
     */
    private int qtdCanibaisEsquerda = 0;

    /**
     * Quantidade de Missionarios na margem Direita
     */
    private int qtdMissionariosDireita = 0;

    /**
     * Quantidade de Canibais na margem Direita
     */
    private int qtdCanibaisDireita = 0;

    /**
     * Posição do barco
     */
    private int barcoPosicao = Estado.BARCO_ESQUERDA;


    public static final int BARCO_DIREITA = 1;

    public static final int BARCO_ESQUERDA = 0;

    /**
     *
     */
    public Estado() {
    }
    /**
     *
     * @return int
     */
    public int getBarcoPosicao() {
        return barcoPosicao;
    }

    /**
     *
     * @param barcoPosicao int
     */
    public void setBarcoPosicao(int barcoPosicao) {
        this.barcoPosicao = barcoPosicao;
    }

    /**
     *
     * @return int
     */
    public int getQtdCanibaisDireita() {
        return qtdCanibaisDireita;
    }

    /**
     *
     * @param qtdCanibaisDireita int
     */
    public void setQtdCanibaisDireita(int qtdCanibaisDireita) {
        this.qtdCanibaisDireita = qtdCanibaisDireita;
    }

    /**
     *
     * @return int
     */
    public int getQtdCanibaisEsquerda() {
        return qtdCanibaisEsquerda;
    }

    /**
     *
     * @param qtdCanibaisEsquerda int
     */
    public void setQtdCanibaisEsquerda(int qtdCanibaisEsquerda) {
        this.qtdCanibaisEsquerda = qtdCanibaisEsquerda;
    }

    /**
     *
     * @return int
     */
    public int getQtdMissionariosDireita() {
        return qtdMissionariosDireita;
    }

    /**
     *
     * @param qtdMissionariosDireita int
     */
    public void setQtdMissionariosDireita(int qtdMissionariosDireita) {
        this.qtdMissionariosDireita = qtdMissionariosDireita;
    }

    /**
     *
     * @return int
     */
    public int getQtdMissionariosEsquerda() {
        return qtdMissionariosEsquerda;
    }

    /**
     *
     * @param qtdMissionariosEsquerda int
     */
    public void setQtdMissionariosEsquerda(int qtdMissionariosEsquerda) {
        this.qtdMissionariosEsquerda = qtdMissionariosEsquerda;
    }

    /**
     *
     * @return Object
     */
    public Object clone() {
        Object copia = null;
        try {
			copia = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        return copia;
    }

    /**
     * Compara estados para verificar se são iguais
     * @param arg0 Object
     * @return boolean
     */
    public boolean equals(Object arg0) {
        Estado outro = (Estado) arg0;
        boolean igual = false;
        if(this.barcoPosicao == outro.getBarcoPosicao() &&
           this.qtdCanibaisDireita == outro.getQtdCanibaisDireita() &&
           this.qtdCanibaisEsquerda == outro.getQtdCanibaisEsquerda() &&
           this.qtdMissionariosDireita == outro.getQtdMissionariosDireita() &&
           this.qtdMissionariosEsquerda == outro.getQtdMissionariosEsquerda()) {
            igual = true;
        }
        return igual;
    }

    /**
     * @return String
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Posição do Barco: " +
                  (Estado.BARCO_DIREITA == this.barcoPosicao ? "DIREITA" :
                   "ESQUERDA") + " \n");
        sb.append("Margem Esquerda: \n");
        sb.append("Canibais: " + this.qtdCanibaisEsquerda + "\n");
        sb.append("Missionarios: " + this.qtdMissionariosEsquerda + "\n");
        sb.append("Margem Direita: \n");
        sb.append("Canibais: " + this.qtdCanibaisDireita + "\n");
        sb.append("Missionarios: " + this.qtdMissionariosDireita + "\n");
        return sb.toString();
    }



}
