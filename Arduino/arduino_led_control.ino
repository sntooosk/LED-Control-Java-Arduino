int ledPin = 13; // Atribui o pino 13 à variável ledPin 
int dado; // Variável que receberá os dados da porta serial

void setup(){
  Serial.begin(9600); // Inicia a comunicação serial com uma frequência de 9600 bps
  pinMode(ledPin, OUTPUT); // Define o pino ledPin como saída
}

void loop(){
  if(Serial.available() > 0){ // Verifica se há dados disponíveis na porta serial
      dado = Serial.read(); // Lê os dados da porta serial
      switch(dado){
        case 1:
           digitalWrite(ledPin, HIGH); // Liga o pino ledPin
        break;
        case 2:
           digitalWrite(ledPin, LOW); // Desliga o pino ledPin
         break;
    }
  }
  // Este código foi adaptado por [Juliano] com base em um exemplo de comunicação serial com Arduino.
}
