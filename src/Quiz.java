
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
/**
 *
 * @author Gustavo Henrique
 */
public class Quiz implements ActionListener{
	
    String[] questoes = 	{
								"Which company created Java?",
								"Which year was Java created?",
								"What was Java originally called?",
								"Who is credited with creating Java?"
							};
    String[][] opcoes = 	{
								{"Sun Microsystems","Starbucks","Microsoft","Alphabet"},
								{"1989","1996","1972","1492"},
								{"Apple","Latte","Oak","Koffing"},
								{"Steve Jobs","Bill Gates","James Gosling","Mark Zuckerburg"}
							};
    char[] resposta_certa = 		{
								'A',
								'B',
								'C',
								'C'
							};

    char guess;
    char resposta;
    int index;
    int correct_guesses =0;
    int total_questoes = questoes.length;
    int resultado;
    int time=10;
        
    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton botaoA = new JButton();
    JButton botaoB = new JButton();
    JButton botaoC = new JButton();
    JButton botaoD = new JButton();
    JLabel pergunta_labelA = new JLabel();
    JLabel pergunta_labelB = new JLabel();
    JLabel pergunta_labelC = new JLabel();
    JLabel pergunta_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel time_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField porcentagem = new JTextField();
    
    Timer timer = new Timer(1000, new ActionListener() {
		
    @Override
    public void actionPerformed(ActionEvent e) {
	time--;
	time_left.setText(String.valueOf(time));
    if(time<=0) {
	displayAnswer();
    }
}
    
    public Quiz() {
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(650,650);
	frame.getContentPane().setBackground(new Color(50,50,50));
	frame.setLayout(null);
	frame.setResizable(false);
		
	textfield.setBounds(0,0,650,50);
	textfield.setBackground(new Color(25,25,25));
	textfield.setForeground(new Color(25,255,0));
	textfield.setFont(new Font("Ink Free",Font.BOLD,30));
	textfield.setBorder(BorderFactory.createBevelBorder(1));
	textfield.setHorizontalAlignment(JTextField.CENTER);
	textfield.setEditable(false);
		
	textarea.setBounds(0,50,650,50);
	textarea.setLineWrap(true);
	textarea.setWrapStyleWord(true);
	textarea.setBackground(new Color(25,25,25));
	textarea.setForeground(new Color(25,255,0));
	textarea.setFont(new Font("MV Boli",Font.BOLD,25));
	textarea.setBorder(BorderFactory.createBevelBorder(1));
	textarea.setEditable(false);
	
	botaoA.setBounds(0,100,100,100);
	botaoA.setFont(new Font("MV Boli",Font.BOLD,35));
	botaoA.setFocusable(false);
	botaoA.addActionListener(this);
	botaoA.setText("A");
		
	botaoB.setBounds(0,200,100,100);
	botaoB.setFont(new Font("MV Boli",Font.BOLD,35));
	botaoB.setFocusable(false);
	botaoB.addActionListener(this);
	botaoB.setText("B");
	
	botaoC.setBounds(0,300,100,100);
	botaoC.setFont(new Font("MV Boli",Font.BOLD,35));
	botaoC.setFocusable(false);
	botaoC.addActionListener(this);
	botaoC.setText("C");
		
	botaoD.setBounds(0,400,100,100);
	botaoD.setFont(new Font("MV Boli",Font.BOLD,35));
	botaoD.setFocusable(false);
	botaoD.addActionListener(this);
	botaoD.setText("D");
		
	pergunta_labelA.setBounds(125,100,500,100);
	pergunta_labelA.setBackground(new Color(50,50,50));
	pergunta_labelA.setForeground(new Color(25,255,0));
	pergunta_labelA.setFont(new Font("MV Boli",Font.PLAIN,35));
		
	pergunta_labelB.setBounds(125,200,500,100);
	pergunta_labelB.setBackground(new Color(50,50,50));
	pergunta_labelB.setForeground(new Color(25,255,0));
	pergunta_labelB.setFont(new Font("MV Boli",Font.PLAIN,35));
		
	pergunta_labelC.setBounds(125,300,500,100);
	pergunta_labelC.setBackground(new Color(50,50,50));
	pergunta_labelC.setForeground(new Color(25,255,0));
	pergunta_labelC.setFont(new Font("MV Boli",Font.PLAIN,35));
		
	pergunta_labelD.setBounds(125,400,500,100);
	pergunta_labelD.setBackground(new Color(50,50,50));
	pergunta_labelD.setForeground(new Color(25,255,0));
	pergunta_labelD.setFont(new Font("MV Boli",Font.PLAIN,35));
		
	time_left.setBounds(535,510,100,100);
	time_left.setBackground(new Color(25,25,25));
	time_left.setForeground(new Color(255,0,0));
	time_left.setFont(new Font("Ink Free",Font.BOLD,60));
	time_left.setBorder(BorderFactory.createBevelBorder(1));
	time_left.setOpaque(true);
	time_left.setHorizontalAlignment(JTextField.CENTER);
	time_left.setText(String.valueOf(time));
		
	time_label.setBounds(535,475,100,25);
	time_label.setBackground(new Color(50,50,50));
	time_label.setForeground(new Color(255,0,0));
	time_label.setFont(new Font("MV Boli",Font.PLAIN,16));
	time_label.setHorizontalAlignment(JTextField.CENTER);
	time_label.setText("timer >:D");
		
	number_right.setBounds(225,225,200,100);
	number_right.setBackground(new Color(25,25,25));
	number_right.setForeground(new Color(25,255,0));
	number_right.setFont(new Font("Ink Free",Font.BOLD,50));
	number_right.setBorder(BorderFactory.createBevelBorder(1));
	number_right.setHorizontalAlignment(JTextField.CENTER);
	number_right.setEditable(false);
		
	porcentagem.setBounds(225,325,200,100);
	porcentagem.setBackground(new Color(25,25,25));
	porcentagem.setForeground(new Color(25,255,0));
	porcentagem.setFont(new Font("Ink Free",Font.BOLD,50));
	porcentagem.setBorder(BorderFactory.createBevelBorder(1));
	porcentagem.setHorizontalAlignment(JTextField.CENTER);
	porcentagem.setEditable(false);
		
	frame.add(time_label);
	frame.add(time_left);
	frame.add(pergunta_labelA);
	frame.add(pergunta_labelB);
	frame.add(pergunta_labelC);
	frame.add(pergunta_labelD);
	frame.add(botaoA);
	frame.add(botaoB);
	frame.add(botaoC);
	frame.add(botaoD);
	frame.add(textarea);
	frame.add(textfield);
	frame.setVisible(true);
        
        proxima_questao();
    }
    
    public void proxima_questao() {
		
	if(index>=total_questoes) {
            resultado();
            }
        else {
            textfield.setText("Questão "+(index+1));
            textarea.setText(questoes[index]);
            pergunta_labelA.setText(opcoes[index][0]);
            pergunta_labelB.setText(opcoes[index][1]);
            pergunta_labelC.setText(opcoes[index][2]);
            pergunta_labelD.setText(opcoes[index][3]);
            timer.start()
            }
    }
    @Override
    public void actionPerformed(ActionEvent ae){
		
	botaoA.setEnabled(false);
	botaoB.setEnabled(false);
	botaoC.setEnabled(false);
	botaoD.setEnabled(false);
			
	if(ae.getSource()==botaoA) {
            resposta= 'A';
	if(resposta == resposta_certa[index]) {
             correct_guesses++;
            }
	}
	if(ae.getSource()==botaoB) {
            resposta= 'B';
	if(resposta == resposta_certa[index]) {
            correct_guesses++;
            }
	}
	if(ae.getSource()==botaoC) {
            resposta= 'C';
	if(resposta == resposta_certa[index]) {
            correct_guesses++;
            }
	}
	if(ae.getSource()==botaoD) {
            resposta= 'D';
	if(resposta == resposta_certa[index]) {
            correct_guesses++;
            }
	}
        displayAnswer();
	}
    
    
    public void displayAnswer() {
		
	timer.stop();
		
	botaoA.setEnabled(false);
	botaoB.setEnabled(false);
	botaoC.setEnabled(false);
	botaoD.setEnabled(false);
		
	if(resposta_certa[index] != 'A')
            pergunta_labelA.setForeground(new Color(255,0,0));
	if(resposta_certa[index] != 'B')
            pergunta_labelB.setForeground(new Color(255,0,0));
	if(resposta_certa[index] != 'C')
            pergunta_labelC.setForeground(new Color(255,0,0));
	if(resposta_certa[index] != 'D')
            pergunta_labelD.setForeground(new Color(255,0,0));
		
	Timer pause = new Timer(2000, new ActionListener() {
			
	@Override
	public void actionPerformed(ActionEvent e) {
				
            pergunta_labelA.setForeground(new Color(25,255,0));
            pergunta_labelB.setForeground(new Color(25,255,0));
            pergunta_labelC.setForeground(new Color(25,255,0));
            pergunta_labelD.setForeground(new Color(25,255,0));
				
            resposta = ' ';
            time=10;
            time_left.setText(String.valueOf(time));
            botaoA.setEnabled(true);
            botaoB.setEnabled(true);
            botaoC.setEnabled(true);
            botaoD.setEnabled(true);
		index++;
            proxima_questao();
            }
        }
                          
            pause.setRepeats(false);
            pause.start();
    }
    
    public void resultado(){
		
	botaoA.setEnabled(false);
	botaoB.setEnabled(false);
	botaoC.setEnabled(false);
	botaoD.setEnabled(false);
		
	resultado = (int)((correct_guesses/(double)total_questoes)*100);
		
	textfield.setText("RESULTADO!");
	textarea.setText("");
	pergunta_labelA.setText("");
	pergunta_labelB.setText("");
	pergunta_labelC.setText("");
	pergunta_labelD.setText("");
		
	number_right.setText("("+correct_guesses+"/"+total_questoes+")");
	porcentagem.setText(resultado+"%");
	
	frame.add(number_right);
	frame.add(porcentagem);
	
	}
    }
    
            

    

