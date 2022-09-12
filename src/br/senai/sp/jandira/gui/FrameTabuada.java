package br.senai.sp.jandira.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.senai.sp.jandira.model.Tabuada;

public class FrameTabuada {

	public String titulo;
	public int largura; 
	public int altura;
	
	public void criarTela() {
		
		JFrame tela = new JFrame();
		
		tela.setTitle(titulo);
		tela.setSize(largura, altura);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);

		Container painel = tela.getContentPane();
		painel.setBackground(new Color(0,100,0));

 
		//obter instancia do conteiner da jannela
		Container painel1 = tela.getContentPane();
		
		
		
		JLabel labelTabuada = new JLabel();
		labelTabuada.setBounds(60,10,900,30);
		labelTabuada.setText("Tabuada 1.0");
		labelTabuada.setForeground(Color.RED);
		labelTabuada.setFont(new Font ("Cooper black", Font.BOLD,30));
		
		JLabel labelmultiplicando = new JLabel();
		labelmultiplicando.setBounds(50,55,900,10);
		labelmultiplicando.setText("multiplicando:");
		labelmultiplicando.setForeground(Color.black);
		
		
		JTextField textmultiplicando = new JTextField();
		textmultiplicando.setBounds(180, 50, 100, 25);
		
		JLabel labelminimultiplicando = new JLabel();
		labelminimultiplicando.setBounds(10,105,150,10);
		labelminimultiplicando.setText("minimo multiplicador:");
		labelminimultiplicando.setForeground(Color.black);
		
		JTextField textminimultiplicando = new JTextField();
		textminimultiplicando.setBounds(180, 100, 100, 25);
		
		JLabel labelMaximomultiplicador = new JLabel();
		labelMaximomultiplicador.setBounds(10,155,150,10);
		labelMaximomultiplicador.setText("maximo multiplicador:");
		labelMaximomultiplicador.setForeground(Color.black);
		
		
		JTextField textMaximomultiplicador = new JTextField();
		textMaximomultiplicador.setBounds(180, 150, 100, 25);
		
		JButton buttoncalcular = new JButton();
		buttoncalcular.setBounds(10, 255, 150, 30);
		buttoncalcular.setText("calcular");
		buttoncalcular.setForeground(new Color(0,100,0));
		buttoncalcular.setBackground(Color.black);
		
		JButton buttonlimpar = new JButton();
		buttonlimpar.setBounds(200, 255, 150, 30);
		buttonlimpar.setText("limpar");
		buttonlimpar.setBackground(Color.black);
		buttonlimpar.setForeground(new Color(0,100,0));
		
		JLabel labelresultado = new JLabel();
		labelresultado.setBounds(10,300,100,10);
		labelresultado.setText("Resultado");
		labelresultado.setForeground(Color.black);

		
		JList<String> lista = new JList<String>();
		JScrollPane scroll = new JScrollPane(lista);
		
		scroll.setBounds(10, 320, 350, 200);
		
		buttoncalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tabuada tabuada = new Tabuada();
				if(textMaximomultiplicador.getText().isEmpty() || textminimultiplicando.getText().isEmpty() || textmultiplicando.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Faltam valores","ERRO",JOptionPane.ERROR_MESSAGE);
					
				}else {
					tabuada.multiplicado = Integer.parseInt(textmultiplicando.getText());
					tabuada.maxMultiplicador = Integer.parseInt(textMaximomultiplicador.getText());
					tabuada.minMultiplicador = Integer.parseInt(textminimultiplicando.getText());
				}
				if(tabuada.maxMultiplicador < tabuada.minMultiplicador) {
					
					JOptionPane.showMessageDialog(null, "minimo multiplicador maior que  o maximo multiplicador","ERRO",JOptionPane.ERROR_MESSAGE);
					
				}else {
					
					String[] resultados = tabuada.getTabuada();
					lista.setListData(resultados);
					scroll.setVisible(true);
					
				}
			}
		});
		

		
		buttonlimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
				
				textmultiplicando.setText("");
				textMaximomultiplicador.setText("");
				textminimultiplicando.setText("");
				scroll.setVisible(false);
				
				
				

				
			}
		
		
		}); {
		
		textmultiplicando.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				textmultiplicando.setText(textmultiplicando.getText().replaceAll("[^0-9]", ""));
				if(textmultiplicando.getText().length()> 9) {
				
					JOptionPane.showMessageDialog(null, "Valor excedido", "ERRO",JOptionPane.ERROR_MESSAGE);
					textmultiplicando.setText(textmultiplicando.getText().replaceAll("[0-9]", ""));
					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		textminimultiplicando.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				textminimultiplicando.setText(textminimultiplicando.getText().replaceAll("[^0-9]", ""));
				if(textminimultiplicando.getText().length()> 9) {
				
					JOptionPane.showMessageDialog(null, "Valor excedido", "ERRO",JOptionPane.ERROR_MESSAGE);
					textminimultiplicando.setText(textminimultiplicando.getText().replaceAll("[0-9]", ""));
					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		textMaximomultiplicador.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				textMaximomultiplicador.setText(textMaximomultiplicador.getText().replaceAll("[^0-9]", ""));
				if(textMaximomultiplicador.getText().length()> 9) {
				
					JOptionPane.showMessageDialog(null, "Valor excedido", "ERRO",JOptionPane.ERROR_MESSAGE);
					textMaximomultiplicador.setText(textMaximomultiplicador.getText().replaceAll("[0-9]", ""));
					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		

			

		
		
		
		
		
		
		//painel de controle!!!
		painel1.add(labelTabuada);
		painel1.add(labelmultiplicando);
		painel1.add(textmultiplicando);
		painel1.add(labelminimultiplicando);
		painel1.add(textminimultiplicando);
		painel1.add(labelMaximomultiplicador);
		painel1.add(textMaximomultiplicador);
		painel1.add(buttoncalcular);
		painel1.add(buttonlimpar);
		painel1.add(labelresultado);
		painel1.add(scroll);
		
	
		
		
		
		
		
		
		tela.setVisible(true);

}}}
