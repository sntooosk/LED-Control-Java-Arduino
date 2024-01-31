/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.embarcados.comunicacaoserial;

import javax.swing.JButton;

/**
 * Classe que representa a comunicação com o Arduino.
 *
 * Esta classe utiliza a classe ControlePorta para enviar comandos para o
 * Arduino através da porta serial.
 *
 * @author Juliano
 */
public class Arduino {

    private ControlePorta arduino;

    /**
     * Construtor da classe Arduino. Inicializa a comunicação com a porta serial
     * do Arduino.
     */
    public Arduino() {
        arduino = new ControlePorta("COM4", 9600); // Altere a porta COM e a taxa de baud para as configurações do seu Arduino
    }

    /**
     * Envia o comando para a porta serial do Arduino.
     *
     * @param button - Botão que é clicado na interface Java.
     */
    public void comunicacaoArduino(JButton button) {
        if ("Ligar".equals(button.getActionCommand())) {
            arduino.enviaDados(1); // Envia o comando para ligar ao Arduino
            System.out.println(button.getText()); // Imprime o nome do botão pressionado
        } else if ("Desligar".equals(button.getActionCommand())) {
            arduino.enviaDados(2); // Envia o comando para desligar ao Arduino
            System.out.println(button.getText());
        } else {
            arduino.close(); // Fecha a comunicação com a porta serial
            System.out.println(button.getText()); // Imprime o nome do botão pressionado
        }
    }
}
