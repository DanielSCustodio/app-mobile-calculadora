package br.com.grupouninter.atividadepratica.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isOpPressed = false;
    //Definindo as variáveis dos componentes do layout
    TextView display;
    //________________________
    Button bt0;
    Button bt00;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;
    Button bt9;
    //________________________
    Button btAdic;
    Button btSub;
    Button btMult;
    Button btDiv;
    Button btIgual;
    Button btPonto;
    //________________________
    Button btDelete;
    Button btLimpar;
    Button btSair;
    //________________________
    boolean verificaOp = false;                                                                         // Responsável por verificar se um botão de operação foi pressionado
    double termo1 = 0;                                                                                 // Armazena o primeiro termo da operação
    int termo2index;                                                                                  // O segundo termo será adicionado através do seu index
    char operacao = 0;                                                                               // Armazena a operação atual;
    boolean pontoPress = false;                                                                     // Variável responsável se o botão de ponto foi pressionado
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciando os componentes do layout
        final TextView display = (TextView) findViewById(R.id.display);

        Button bt00 = (Button) findViewById(R.id.bt00);
        Button bt0 = (Button) findViewById(R.id.bt0);
        Button bt1 = (Button) findViewById(R.id.bt1);
        Button bt2 = (Button) findViewById(R.id.bt2);
        Button bt3 = (Button) findViewById(R.id.bt3);
        Button bt4 = (Button) findViewById(R.id.bt4);
        Button bt5 = (Button) findViewById(R.id.bt5);
        Button bt6 = (Button) findViewById(R.id.bt6);
        Button bt7 = (Button) findViewById(R.id.bt7);
        Button bt8 = (Button) findViewById(R.id.bt8);
        Button bt9 = (Button) findViewById(R.id.bt9);

        Button btAdic = (Button) findViewById(R.id.btAdic);
        Button btSub = (Button) findViewById(R.id.btSub);
        Button btMult = (Button) findViewById(R.id.btMult);
        Button btDiv = (Button) findViewById(R.id.btDiv);
        Button btIgual = (Button) findViewById(R.id.btIgual);
        Button btPonto = (Button) findViewById(R.id.btPonto);

        Button btDelete = (Button) findViewById(R.id.btDelete);
        Button btLimpar = (Button) findViewById(R.id.btLimpar);
        Button btSair = (Button) findViewById(R.id.btSair);


        View.OnClickListener ListenerCalculadora = new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int captura = view.getId();

                String conteudoTela = display.getText().toString();                                 // Conteúdo digitado


                boolean terminaSimbolo = conteudoTela.endsWith("+") || conteudoTela.endsWith("–")
                        || conteudoTela.endsWith("*")|| conteudoTela.endsWith("/")
                        || conteudoTela.endsWith(".") || conteudoTela.endsWith("-");                //Verificando se no visor o último carcater é uma simbolo aritmético  para que não gere erro ao concatenar o botão de adição.

                boolean contemSimbolo = conteudoTela.contains("+") || conteudoTela.contains("–")
                                     || conteudoTela.contains("/") || conteudoTela.contains("*");                               //Verificando se na expresão atual já existe um simbolo aritmético, para não permitir a concatenação de mais um simbolo aritmetico
                switch (captura) {                                                                   //Capturando os dados de entrada do usuário para mostrar no visor
                    case R.id.bt0:

                        display.append("0");                                                         //Mostrandos os valores digitados no visor
                        break;                                                                      //é usado o "append" pois ele faz a concatenação dos caracrteres de forma automática.

                    case R.id.bt00:
                        display.append("00");                                                     
                        break;

                    case R.id.bt1:
                        display.append("1");
                        break;

                    case R.id.bt2:
                        display.append("2");
                        break;

                    case R.id.bt3:
                        display.append("3");
                        break;

                    case R.id.bt4:
                        display.append("4");
                        break;

                    case R.id.bt5:
                        display.append("5");
                        break;

                    case R.id.bt6:
                        display.append("6");
                        break;

                    case R.id.bt7:
                        display.append("7");
                        break;

                    case R.id.bt8:
                        display.append("8");
                        break;

                    case R.id.bt9:
                        display.append("9");
                        break;

                    case R.id.btAdic:
                        if(conteudoTela.equals("") || terminaSimbolo || contemSimbolo){             //Verificando se o visor está vazio para que não gere erro ao concatenar o botão de adição. E  a verificação dos simbolos aritméticos, explicado acima.
                            return;
                        }else{
                            termo2index = display.length() + 1;                                          // Captura tudo que for digitado depois do botão de adição
                            termo1 = Double.parseDouble(conteudoTela);                                  // Recebendo o termo antes do sinal e o convertendo de String(Texto) para Double(Número).
                            display.append("+");                                                       // Concatenando o sinal "+" no visor
                            verificaOp = true;                                                        // Validando que um sinal de operação foi pressionado
                            pontoPress = false;                                                      // Alterando o valor da variavél para que seja possível adicionar ponto "." depois do botão for pressionado
                            operacao = '+';                                                         // Definindo a operação atual como soma
                        }
                    break;

                    case R.id.btSub:
                        if(terminaSimbolo || contemSimbolo){                                        //  Verificação dos simbolos aritméticos, explicado acima.
                            return;
                        }else{
                            if(conteudoTela.equals("")){                                             // Verificando se o visor está vazio para  fazer a escolha de sinalizar um número negativo ou uma opreação de subtração
                                display.append("-");                                                // Como o visor está vazio então será concatenado o sinal para um númepro negativo
                            }else{
                            termo2index = display.length() + 1;                                          // Captura tudo que for digitado depois do botão de subtração
                            termo1 = Double.parseDouble(conteudoTela);                                  // Recebendo o termo antes do sinal e o convertendo de String(Texto) para Double(Número).
                            display.append("–");                                                       // Concatenando o sinal "-" no visor
                            verificaOp = true;                                                        // Validando que um sinal de operação foi pressionado
                            pontoPress = false;                                                      // Alterando o valor da variavél para que seja possível adicionar ponto "." depois do botão for pressionado
                            operacao = '-';                                                         // Definindo a operação atual como subtração
                        }}
                    break;

                    case R.id.btMult:
                        if(conteudoTela.equals("") || terminaSimbolo || contemSimbolo){             //Verificando se o visor está vazio para que não gere erro ao concatenar o botão de adição. E  a verificação dos simbolos aritméticos, explicado acima.
                            return;
                        }else{
                            termo2index = display.length() + 1;                                          // Captura tudo que for digitado depois do botão de multiplicação
                            termo1 = Double.parseDouble(conteudoTela);                                  // Recebendo o termo antes do sinal e o convertendo de String(Texto) para Double(Número).
                            display.append("*");                                                       // Concatenando o sinal "*" no visor
                            verificaOp = true;                                                        // Validando que um sinal de operação foi pressionado
                            pontoPress = false;                                                      // Alterando o valor da variavél para que seja possível adicionar ponto "." depois do botão for pressionado
                            operacao = '*';                                                         // Definindo a operação atual como multiplicação
                        }
                    break;

                    case R.id.btDiv:
                        if(conteudoTela.equals("") || terminaSimbolo || contemSimbolo){             //Verificando se o visor está vazio para que não gere erro ao concatenar o botão de adição. E  a verificação dos simbolos aritméticos, explicado acima.
                            return;
                        }else{
                            termo2index = display.length() + 1;                                          // Captura tudo que for digitado depois do botão de dividisão
                            termo1 = Double.parseDouble(conteudoTela);                                  // Recebendo o termo antes do sinal e o convertendo de String(Texto) para Double(Número).
                            display.append("/");                                                       // Concatenando o sinal "/" no visor
                            verificaOp = true;                                                        // Validando que um sinal de operação foi pressionado
                            pontoPress = false;                                                      // Alterando o valor da variavél para que seja possível adicionar ponto "." depois do botão for pressionado
                            operacao = '/';                                                         // Definindo a operação atual como Divisão
                        }
                    break;

                    case R.id.btIgual:
                        if(terminaSimbolo) {
                            return;
                        }else{
                            if (verificaOp) {                                                             // Verificando se algum botão de operação foi pressionado
                                verificaOp = false;                                                      // Nesse momento  para ser feita outra operação será necessário apertar o botão de alguma operação novamente. Isso não permite que o botão de igual possa operar duas vezes em seguida, causando erro no código
                                pontoPress = true;                                                      //   Passando o valor "false"  para a variável para que não seja permitido colocar  um ponto "." no número que foi resultado da operação.
                                String resultado;                                                      // Variável  responsável por armazenar os resultados
                                String conteudotela = display.getText().toString();                   // Armazenando o conteudo da tela
                                String termo2String = conteudotela.substring(termo2index);           // Tudo que foi digitado depois do botão de adcionar é gravado nessa variável
                                double termo2 = Double.parseDouble(termo2String);                   // Recebendo o termo depois do sinal e o convertendo de String(Texto) para Double(Número).


                                if (operacao == '+') {                                               // Verificando se a variável operação é igual a "+"(somar)
                                    termo2 += termo1;                                               // Somanado o perimeiro termo com o segundo termo e armazenando na variável termo2

                                } else if (operacao == '-') {                                        // Verificando se a variável operação é igual a "-"(diminuir)
                                    termo2 = termo1 - termo2;                                       // Diminuindo o perimeiro termo pelo o segundo termo e armazenando na variável termo2

                                } else if (operacao == '*') {                                        // Verificando se a variável operação é igual a "*"(multiplicar)
                                    termo2 *= termo1;                                               // Multiplicando o perimeiro termo pelo o segundo termo e armazenando na variável termo2

                                } else if (operacao == '/') {                                        // Verificando se a variável operação é igual a "/"(dividir)
                                    if (termo2 == 0) {                                              // Essa condição não permite que o divisor seja zero
                                        return;
                                    }
                                    termo2 = termo1 / termo2;                                       // Dividindo o perimeiro termo pelo o segundo termo e armazenando na variável termo2

                                }

                                resultado = String.valueOf(termo2);                                   // Guardando o resultado da operação em ums String
                                if (resultado.endsWith(".0")) {                                      //verificando se o valor da variável termina com ".0" para elimina-lo depois
                                    resultado = resultado.substring(0, resultado.length() - 2);     // eleminando o ".0"
                                }
                                display.setText(resultado);                                         //Mostrando o resultado no visor
                            }
                         }
                    break;

                    case R.id.btPonto:
                      if((conteudoTela.equals("")|| terminaSimbolo)){                                  //Verificando se o visor está vazio para que não gere erro ao concatenar o botão de ponto "." , e verificando se o ultimo digito não é um simbolo aritmético
                            return;
                        }else {
                            if (!pontoPress) {                                                        // Se o valor da variável for "false" entaõ o ponto "." será concatenado
                                display.append(".");                                                 // Concatenando o "."
                                pontoPress = true;                                                  // Passando o valor "true"  para a variável para que não seja permitido colocar mais de um ponto "." após o número
                            }
                        }
                    break;
                }
            }
        };

        //Criando os listeners dos compoentes
        bt00.setOnClickListener(ListenerCalculadora);
        bt0.setOnClickListener(ListenerCalculadora);
        bt1.setOnClickListener(ListenerCalculadora);
        bt2.setOnClickListener(ListenerCalculadora);
        bt3.setOnClickListener(ListenerCalculadora);
        bt4.setOnClickListener(ListenerCalculadora);
        bt5.setOnClickListener(ListenerCalculadora);
        bt6.setOnClickListener(ListenerCalculadora);
        bt7.setOnClickListener(ListenerCalculadora);
        bt8.setOnClickListener(ListenerCalculadora);
        bt9.setOnClickListener(ListenerCalculadora);
        btAdic.setOnClickListener(ListenerCalculadora);
        btSub.setOnClickListener(ListenerCalculadora);
        btMult.setOnClickListener(ListenerCalculadora);
        btDiv.setOnClickListener(ListenerCalculadora);
        btIgual.setOnClickListener(ListenerCalculadora);
        btPonto.setOnClickListener(ListenerCalculadora);
        btSair.setOnClickListener(ListenerCalculadora);

        //Criação do método de delete / Apaga o último número a ser digitado
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entradaDigitos = display.getText().toString();                                   // Capturando os números digitados
                int capturaTamanho = entradaDigitos.length();                                          // Capturando o tamanho da cadeia de caractere foi digitados e aramzenando na variável
                if (capturaTamanho > 0) {                                                             // Verificando se realmente algum número foi digitado para executar a ação de limpeza
                    entradaDigitos = entradaDigitos.substring(0, capturaTamanho - 1);                // O último elemento a ser digitado está sendo deixado de fora da cadeia de caracteres
                    display.setText(entradaDigitos);                                                // Aqui o visor está sendo atualizado com a cadeia de caracteres menos o último a ser digitado
                }
            }
        });

        //Criação do Método para limpar o visor
        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("");                                                                  //limpando o visor, setando um valor vazio para o visor
                verificaOp = false;                                                                  // Alterando o valor da variavél para que não tenha nenhuma operação presente
                pontoPress = false;                                                                 // Alterando o valor da variavél para que seja possível adicionar ponto "." depois de limpar o visor
            }
        });

        btSair.setOnClickListener(new View.OnClickListener() {                                      // Método para finalizar a Activity
            @Override
            public void onClick(View view) {
                finishAffinity();                                                                   //Finalizando a Acticity
            }
        });
    }
}