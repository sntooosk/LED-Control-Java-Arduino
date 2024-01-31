# Projeto de Controle de LED com Integração Java e Arduino

[<img height="48px" width="48px" alt="Arduino Icon" src="https://skillicons.dev/icons?i=arduino"/>](https://arduino.com)
[<img height="48px" width="48px" alt="Java Icon" src="https://skillicons.dev/icons?i=java"/>](https://apache.com)

Este projeto tem como objetivo criar uma solução de controle remoto para ligar e desligar um LED usando a integração entre um aplicativo Java e um dispositivo Arduino. O sistema permite o controle do LED por meio de uma interface gráfica em Java, que se comunica com o Arduino via conexão serial.

## Componentes do Projeto

### 1. Arduino
O código Arduino (`arduino_led_control.ino`) está localizado no diretório `ArduinoCode`. Ele aguarda comandos do aplicativo Java pela porta serial para ligar ou desligar um LED conectado ao pino 13 do Arduino.

### 2. Java
O aplicativo Java fornece uma interface gráfica simples com botões para ligar e desligar o LED. Utiliza-se a biblioteca RXTX para comunicação serial. O código fonte Java está organizado nas classes `ControlePorta`, `Arduino` e `JFInterface`.

## Configuração do Ambiente

Certifique-se de ajustar as configurações no código Arduino para a porta serial correta. O arquivo `ControlePorta.java` no pacote `br.com.embarcados.comunicacaoserial` no diretório `/src` contém a configuração da porta serial para o aplicativo Java.

## Como Executar

1. Carregue o código Arduino no seu dispositivo.
2. Execute o aplicativo Java após configurar a conexão serial.
3. A interface gráfica será exibida, permitindo o controle do LED por meio dos botões "Ligar" e "Desligar".

## Autor

Este projeto foi desenvolvido por [Juliano].


