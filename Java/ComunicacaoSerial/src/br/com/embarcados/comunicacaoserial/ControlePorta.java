/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.embarcados.comunicacaoserial;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;

/**
 * Classe que controla a comunicação com a porta serial para envio de dados ao
 * Arduino.
 *
 * Esta classe utiliza a biblioteca RXTX para interagir com a porta serial. Ela
 * é responsável por abrir, fechar e enviar dados pela porta serial.
 *
 * @author Juliano
 */
public class ControlePorta {

    private OutputStream serialOut;
    private final int taxa;
    private final String portaCOM;

    /**
     * Construtor da classe ControlePorta.
     *
     * @param portaCOM - Porta COM que será utilizada para enviar os dados para
     * o Arduino.
     * @param taxa - Taxa de transferência da porta serial geralmente é 9600.
     */
    public ControlePorta(String portaCOM, int taxa) {
        this.portaCOM = portaCOM;
        this.taxa = taxa;
        this.initialize();
    }

    /**
     * Método que verifica se a comunicação com a porta serial está ok.
     */
    private void initialize() {
        try {
            // Define uma variável portId do tipo CommPortIdentifier para realizar a comunicação serial
            CommPortIdentifier portId = null;
            try {
                // Tenta verificar se a porta COM informada existe
                portId = CommPortIdentifier.getPortIdentifier(this.portaCOM);
            } catch (NoSuchPortException npe) {
                // Caso a porta COM não exista, exibe um erro 
                JOptionPane.showMessageDialog(null, "Porta COM não encontrada.",
                        "Porta COM", JOptionPane.PLAIN_MESSAGE);
            }
            // Abre a porta COM 
            SerialPort port = (SerialPort) portId.open("Comunicação serial", this.taxa);
            serialOut = port.getOutputStream();
            port.setSerialPortParams(this.taxa, // Taxa de transferência da porta serial 
                    SerialPort.DATABITS_8, // Taxa de 10 bits 8 (envio)
                    SerialPort.STOPBITS_1, // Taxa de 10 bits 1 (recebimento)
                    SerialPort.PARITY_NONE); // Receber e enviar dados
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que fecha a comunicação com a porta serial.
     */
    public void close() {
        try {
            serialOut.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível fechar porta COM.",
                    "Fechar porta COM", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Envia dados pela porta serial.
     *
     * @param opcao - Valor a ser enviado pela porta serial.
     */
    public void enviaDados(int opcao) {
        try {
            serialOut.write(opcao); // Escreve o valor na porta serial para ser enviado
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível enviar o dado. ",
                    "Enviar dados", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
