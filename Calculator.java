package cal;

import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame
{	
	// 공통 필요(색상, 버튼)
	private Color c1 = new Color(230, 230, 230);
	private Color c2 = new Color(240, 240, 240);
	private Color c3 = new Color(250, 250, 250);
	private Color c4 = new Color(138, 186, 224);
	private JButton[] btn;
	
	// 메뉴바
	private JMenuBar mb;	
	private JMenu menu;
	private JLabel norm;
	private JMenu reduce;
	
	// 계산과정 패널
	private JPanel process;
	private JTextField pt;
	
	// 계산결과 패널
	private JPanel result;
	private JTextField rt;
	
	// 메모리 패널
	private JPanel memory;
	private String[] m  = {"MC", "MR", "M+", "M-", "MS" };
	
	// 지우기 패널
	private JPanel erase;
	private String[] e = {"%", "CE", "C", "⌫"};
	
	// 단항연산 패널
	private JPanel unary;
	private String[] u = {"¹/x", "x²", "²√x", "÷"};
	
	
	// 숫자 패널
	private JPanel num;
	private String[] n = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "+/-", "0", "."};
		
	// 사칙연산 패널
	private JPanel fourOper;
	private String[] f = {"X","-", "+", "="};
	
	// 생성자
	public Calculator() 
	{
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(510, 25);
		setSize(440, 800);
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		Container c = getContentPane();
		c.setBackground(c1);
		
		makeMenu();
		makeResult();
		makeProcess();
		makeMemory();
		makeErase();
		makeUnary();
		makeNum();
		makeFourOper();
		
		this.setJMenuBar(mb);
		add(process);
		add(result);
		add(memory);
		add(erase);
		add(unary);
		add(num);
		add(fourOper);
		
		setResizable(false);
		setVisible(true);
	}

	// 메뉴바
	private void makeMenu() 
	{
		  mb = new JMenuBar(); 
		  mb.setOpaque(true);
		  mb.setBackground(c1);
		  
		  menu = new JMenu(" ≡ ");
		  menu.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 19));
		  
		  norm = new JLabel(" 표준 ");
		  norm.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 19));
		  
		  reduce = new JMenu(" # ");
		  reduce.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 19));
		
		  mb.add(menu);
		  mb.add(norm);
		  mb.add(reduce);
	}

	// 계산과정 패널
	private void makeProcess() 
	{
		process = new JPanel();
		process.setLayout(new FlowLayout(FlowLayout.CENTER));
		process.setBackground(c1);
		pt = new JTextField(30);
		pt.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		pt.setBackground(c1);
		pt.setHorizontalAlignment(JTextField.RIGHT);
		process.add(pt);
		process.setPreferredSize(new Dimension(440,40));
	}
	
	// 결과 패널
	private void makeResult() 
	{
		result = new JPanel();
		result.setLayout(new FlowLayout(FlowLayout.CENTER));
		result.setBackground(c1);
		result.setPreferredSize(new Dimension(430,115));
		rt = new JTextField(6);
		rt.setFont(new Font("나눔고딕", Font.BOLD, 70));
		rt.setBackground(c1);
		rt.setHorizontalAlignment(JTextField.RIGHT);
		result.add(rt);
	}
	
	// 메모리 패널
	private void makeMemory()
	{
		memory = new JPanel();
		btn = new JButton[m.length]; // 버튼 생성
		
		memory.setLayout(new GridLayout(1, 5, 1, 1));
		memory.setBackground(c1);
		memory.setPreferredSize(new Dimension(420,40));
		
		for(int i=0; i < m.length; i++) 
		{
			btn[i] = new JButton(m[i]);
			btn[i].setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 12));
			btn[i].setBackground(c1);
			btn[i].setBorderPainted(false);
			if(btn[i].getText() == "MC" || btn[i].getText() == "MR") 
				btn[i].setEnabled(false);
			memory.add(btn[i]);
		}
	}
	
	// 지우기 패널
	private void makeErase()
	{
		erase = new JPanel();
		btn = new JButton[e.length];
		
		erase.setLayout(new GridLayout(1, 4, 1, 1));
		erase.setBackground(c1);
		erase.setPreferredSize(new Dimension(420,80));
		
		for(int i=0; i < e.length; i++) 
		{
			btn[i] = new JButton(e[i]);
			btn[i].setFont(new Font("나눔고딕", Font.PLAIN, 17));
			btn[i].setBackground(c2);
			btn[i].setBorderPainted(false);
			erase.add(btn[i]);
		}
	}
	
	// 단항연산 패널
	private void makeUnary()
	{
		unary = new JPanel();
		btn = new JButton[u.length];
		
		unary.setLayout(new GridLayout(1, 4, 1, 1));
		unary.setBackground(c1);
		unary.setPreferredSize(new Dimension(420,80));
			
		for(int i=0; i < u.length; i++) 
		{
			btn[i] = new JButton(u[i]);
			btn[i].setFont(new Font("나눔고딕", Font.PLAIN, 17));
			btn[i].setBackground(c2);
			btn[i].setBorderPainted(false);
			unary.add(btn[i]);
			}
		}
	
	// 숫자 패널
	private void makeNum()
	{
		num = new JPanel();
		btn = new JButton[n.length];
		
		num.setLayout(new GridLayout(4, 3, 1, 1));
		num.setBackground(c1);
		num.setPreferredSize(new Dimension(315,340));
		
		for(int i=0; i < n.length; i++) 
		{
			btn[i] = new JButton(n[i]);
			btn[i].setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 18));
			btn[i].setBackground(c3);
			btn[i].setBorderPainted(false);
			num.add(btn[i]);
		}
	}
	
	// 사칙연산 패널
	private void makeFourOper()
	{
		fourOper = new JPanel();
		btn = new JButton[f.length];
		
		fourOper.setLayout(new GridLayout(4, 1, 1, 1));
		fourOper.setBackground(c1);
		fourOper.setPreferredSize(new Dimension(100,340));
		
		for(int i=0; i < f.length; i++) 
		{
			btn[i] = new JButton(f[i]);
			btn[i].setFont(new Font("나눔고딕", Font.PLAIN, 17));
			btn[i].setBorderPainted(false);
			fourOper.add(btn[i]);
			if(btn[i].getText() == "=") 
				btn[i].setBackground(c4);
			else
				btn[i].setBackground(c2);
		}
	}
}
