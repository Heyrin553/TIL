package client;

import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class ClientUi {
	TextArea ta;
	TextField tf;
	
	public void chatMsg() {
		String msg = tf.getText();
		ta.append(msg+"\n");
		tf.setText("");	
	}


	public void onCreate() { //메인메소드에서 하던 일을 전부 non static으로 이사 
		 // final을 하는것이 좋음 
		Frame f = new Frame("My Chatting");
		Panel psouth = new Panel();
		Panel peast = new Panel();
		Button b1 = new Button("Enter");
		Button btn = new Button("버튼"); 
		Label lbl = new Label("라벨");
		Checkbox chkbox = new Checkbox("체크박스");
		CheckboxGroup chkGroup = new CheckboxGroup(); // 라디오
		Checkbox chk1 = new Checkbox("A", chkGroup, false); // 라디오 A값 추가
		Checkbox chk2 = new Checkbox("B", chkGroup, false); // 라디오 B값 추가
		Checkbox chk3 = new Checkbox("C", chkGroup, true); // 라디오 C값 추가, true는 최초 선택값
		Choice cho = new Choice(); // 콤보박스
		cho.addItem("1번 선택지"); // 콤보박스 추가
		cho.addItem("2번 선택지"); // 콤보박스 추가
		cho.addItem("3번 선택지"); // 콤보박스 추가
		
		
		tf = new TextField(20); //멤버변수에 할당
		ta = new TextArea(); //멤버변수에 할당 
		
		
		//메뉴바 만들기 
		MenuBar mb = new MenuBar();
		Menu file_menu = new Menu("파일");
		Menu edit_menu = new Menu("편집");
		MenuItem open_item = new MenuItem("열기");
		MenuItem save_item = new MenuItem("저장");
				
		file_menu.add(open_item);
		file_menu.add(save_item);
		
		mb.add(file_menu);
		mb.add(edit_menu);
		f.setMenuBar(mb);
		
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				System.out.println("will you open file?");
				FileDialog open = new FileDialog(f, "open", FileDialog.LOAD); //로드창처럼 생긴 거 열기 
				open.setVisible(true);
				
				FileReader fr = null;
				BufferedReader br = null;
				
				try {
					fr = new FileReader(open.getDirectory()+open.getFile());
					br = new BufferedReader(fr);
					String oneLine = "";
					ta.setText(""); // 새 파일 열 때마다 지워지는 효과 
					while((oneLine = br.readLine()) != null) {
						ta.append(oneLine+"\n");
						
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace(); //개발시점에서는 테스트에 도움이 됨. 실행시에는 보안에 나빠 지워야 함! 
				} catch (IOException e) { // 중첩 캐치! 좋은 방법. 
					e.printStackTrace();
				} finally {
					try {
						if(br != null) br.close();
						if(fr != null) fr.close();
					} catch (IOException e) {
						
					}
				}
				
			}
		});
		
		save_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent b) {
				FileDialog save = new FileDialog(f, "save", FileDialog.SAVE); //로드창처럼 생긴 거 열기 
				save.setDirectory("."); //현재 폴더 
				save.setVisible(true);
				
				//비정상 종료시 
				if(save.getFile() == null) return;
				
				//경로+파일명 설정
				String dfName = save.getDirectory() + save.getFile();
				
				
				BufferedWriter fw = null;
				
				try {
					fw = new BufferedWriter(new FileWriter(dfName));
					fw.write(ta.getText());
					
					
					//setTitle(save.getFile()+ "-memo");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
						try {
							if(fw != null) fw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				
			}
		});
		
	
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				}
			});
		
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 채팅 서버 연결  
				
			}
		});
		
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chatMsg();	
			}
		}); //자기 이름을 버리고 슈퍼의 이름을 가져와야 함. 
		
		
		f.add(ta, BorderLayout.CENTER);
		f.add(psouth, BorderLayout.SOUTH);
		psouth.add(tf);
		psouth.add(b1);
		psouth.setBackground(Color.DARK_GRAY);
		
		f.add(peast, BorderLayout.EAST);
		peast.setBackground(Color.GRAY);
		peast.setBounds(0, 0, 150, 250);
		peast.setLayout(null);
		
		btn.setBounds(50, 50, 50, 50);
		lbl.setBounds(50, 100, 50, 50);
		chkbox.setBounds(50, 150, 100, 50);
		chk1.setBounds(50, 200, 25, 50);
		chk2.setBounds(100, 200, 25, 50);
//		chk3.setBounds(150, 200, 25, 50);
		cho.setBounds(50, 250, 70, 50);
		
		peast.add(btn);
		peast.add(lbl);
		peast.add(chkbox);
		peast.add(chk1); // 라디오의 경우에는 만들어준 체크박스 1,2,3을 모두 붙여야 함
		peast.add(chk2);
//		peast.add(chk3);
		peast.add(cho);
	
		//Color bgColor = new Color(5, 24, 56); 
		f.setLocation(800, 200);
		f.setBackground(Color.LIGHT_GRAY);
		f.setSize(500, 600);
		f.setVisible(true);
		
		}

	public static void main(String[] args) {
		ClientUi ui = new ClientUi();
		ui.onCreate();
	
		
   	} //메인 메소드의 끝
		
		} // client Ui 의 끝
