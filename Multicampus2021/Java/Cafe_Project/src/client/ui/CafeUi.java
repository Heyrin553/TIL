package client.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import common.entity.MemberDTO;
import common.entity.OrderDTO;
import common.entity.ProductDTO;
import common.util.CafeException;
import server.service.MemberService;
import server.service.OrderService;
import server.service.ProductService;


public class CafeUi extends Frame{
	MemberService mservice; 
	ProductService pService;
	OrderService oService;
	
	TextField tf_memId, tf_memName,tf_phone,tf_prodCode,tf_prodName,tf_prodPrice, tf_orderMem, tf_orderProd, tf_orderQuan;
	Button btn_memInsert,btn_memUpdate,btn_memSelect,btn_memDelete,btn_prodInsert,btn_prodUpdate,btn_prodSelect,btn_prodDelete;
	Button btn_order;
	TextArea ta_mem,ta_prod, ta_order;
	
	
			
	@Override
	public void setVisible(boolean b) {
		try {
			mservice = new MemberService();
			pService = new ProductService();
			oService = new OrderService();
		} catch (CafeException e1) {
			System.out.println(e1.getMessage() + ": 시스템 종료");
			System.exit(0);
		}
		
		
		
		// 종료 버튼 핸들링
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// 1행 3열의 레이아웃 
		setLayout(new GridLayout(1,3,20,0));
		memberPanel(); // 고객패널
		productPanel();	// 상품패널
		ordersPanel(); // 주문패널 
		
		setLocation(200,300);
		pack();
		eventProcess();
		setMemberList();
		setProductList();
		super.setVisible(b); // 화면 띄우기 
	}
	
	
	private void setProductList() {
		try {
			ArrayList<ProductDTO> list = pService.selectProduct();
			ta_prod.setText(""); // 내용 추가하기 전 ta 비우기 
			for(ProductDTO p:list) {
				ta_prod.append(p.getProdCode()+"\t"+p.getProdName()+"\t"+p.getPrice()+"\n");
			}
		} catch (CafeException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}

	private void setMemberList() {
		// 화면 뜨자마자 모든 고객 리스트가 보이도록 하는 메소드
		 try {
			ArrayList<MemberDTO> list = mservice.selectMember();
			ta_mem.setText(""); // 내용 추가하기 전 ta 비우기 
			for(MemberDTO m:list) {
				ta_mem.append(m.getMemId()+"\t"+m.getName()+"\t"+m.getmDate()+"\t"+m.getPhone()+"\t"+m.getPoint()+"\n");
			}
		} catch (CafeException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	
	private void ordersPanel() { // 주문패널 선언
		Panel ordersPanel=new Panel();
		Panel ordersPanel_sub1=new Panel();
		Panel ordersPanel_sub2=new Panel();
		Panel ordersPanel_sub3=new Panel();
		tf_orderMem=new TextField(20);
		tf_orderProd=new TextField(20);
		tf_orderQuan=new TextField(20);
		btn_order=new Button("주문하기");
		ta_order=new TextArea();
	
		add(ordersPanel);
		ordersPanel.setLayout(new GridLayout(3,1,0,20));
		ordersPanel_sub3.add(ta_order);
		ordersPanel.add(ordersPanel_sub3);
		ordersPanel.add(ordersPanel_sub1);
		ordersPanel.add(ordersPanel_sub2);
		ordersPanel_sub1.setLayout(new GridLayout(3,3,0,10));	

		// 라벨 붙이기 
		ordersPanel_sub1.add(new Label("        고객명"));		
		ordersPanel_sub1.add(tf_orderMem);
//		ordersPanel_sub1.add(new Label());
		ordersPanel_sub1.add(new Label("        상품명"));		
		ordersPanel_sub1.add(tf_orderProd);
//		ordersPanel_sub1.add(new Label());
		ordersPanel_sub1.add(new Label("        수량"));
		ordersPanel_sub1.add(tf_orderQuan);
//		ordersPanel_sub1.add(new Label());
		
		ordersPanel_sub2.add(btn_order);
		ordersPanel.setBackground(new Color(204,170,100));
		
		btn_order.setPreferredSize(new Dimension(80,80));
	}
	
	private void productPanel() { // 상품패널 선언
		Panel productPanel=new Panel();
		Panel productPanel_sub1=new Panel();
		Panel productPanel_sub2=new Panel();
		Panel productPanel_sub3=new Panel();
		tf_prodCode=new TextField(20);
		tf_prodName=new TextField(20);
		tf_prodPrice=new TextField(20);
		btn_prodInsert=new Button("등록");
		btn_prodUpdate=new Button("수정");
		btn_prodSelect=new Button("조회");
		btn_prodDelete=new Button("삭제");
		ta_prod=new TextArea();
	
		add(productPanel);
		productPanel.setLayout(new GridLayout(3,1,0,20));
		productPanel_sub3.add(ta_prod);
		productPanel.add(productPanel_sub3);
		productPanel.add(productPanel_sub1);
		productPanel.add(productPanel_sub2);
		productPanel_sub1.setLayout(new GridLayout(3,3,0,10));	

		productPanel_sub1.add(new Label("        상품 코드"));		
		productPanel_sub1.add(tf_prodCode);
		productPanel_sub1.add(new Label());
		productPanel_sub1.add(new Label("        상품명"));
		productPanel_sub1.add(tf_prodName);
		productPanel_sub1.add(new Label());
		productPanel_sub1.add(new Label("        가격"));
		productPanel_sub1.add(tf_prodPrice);
		productPanel_sub1.add(new Label());
		productPanel_sub2.add(btn_prodInsert);
		productPanel_sub2.add(btn_prodUpdate);
		productPanel_sub2.add(btn_prodSelect);
		productPanel_sub2.add(btn_prodDelete);
		productPanel.setBackground(new Color(204,204,051));
		
		btn_prodInsert.setPreferredSize(new Dimension(80,80));
		btn_prodUpdate.setPreferredSize(new Dimension(80,80));
		btn_prodSelect.setPreferredSize(new Dimension(80,80));
		btn_prodDelete.setPreferredSize(new Dimension(80,80));
	}
	
	private void memberPanel() { // 고객패널 선언
		Panel memberPanel=new Panel();
		Panel memberPanel_sub1=new Panel();
		Panel memberPanel_sub2=new Panel();
		Panel memberPanel_sub3=new Panel();
		tf_memId=new TextField(20);
		tf_memName=new TextField(20);
		tf_phone=new TextField(20);
		btn_memInsert=new Button("가입");
		btn_memUpdate=new Button("수정");
		btn_memSelect=new Button("조회");
		btn_memDelete=new Button("삭제");
		ta_mem=new TextArea();
		
		add(memberPanel);
		memberPanel.setLayout(new GridLayout(3,1,0,20));
		memberPanel_sub3.add(ta_mem);
		memberPanel.add(memberPanel_sub3);
		memberPanel.add(memberPanel_sub1);
		memberPanel.add(memberPanel_sub2);
		memberPanel_sub1.setLayout(new GridLayout(3,3,0,10));	

		memberPanel_sub1.add(new Label("        고객 ID"));		
		memberPanel_sub1.add(tf_memId);
		memberPanel_sub1.add(new Label());
		memberPanel_sub1.add(new Label("        고객명"));
		memberPanel_sub1.add(tf_memName);
		memberPanel_sub1.add(new Label());
		memberPanel_sub1.add(new Label("        전화번호"));
		memberPanel_sub1.add(tf_phone);
		memberPanel_sub1.add(new Label());
		memberPanel_sub2.add(btn_memInsert);
		memberPanel_sub2.add(btn_memUpdate);
		memberPanel_sub2.add(btn_memSelect);
		memberPanel_sub2.add(btn_memDelete);
		memberPanel.setBackground(new Color(204,153,102));
		
		btn_memInsert.setPreferredSize(new Dimension(80,80));
		btn_memUpdate.setPreferredSize(new Dimension(80,80));
		btn_memSelect.setPreferredSize(new Dimension(80,80));
		btn_memDelete.setPreferredSize(new Dimension(80,80));
	}

	
	private void eventProcess() {
		// 주문
		btn_order.addActionListener(e -> {
			String memId = tf_memId.getText();
			String prodCode = tf_prodCode.getText();
			int quantity = Integer.parseInt(tf_orderQuan.getText());
			OrderDTO o = new OrderDTO(quantity, memId, prodCode, "kiosk");
			try {
				int orderNo = oService.insertOrder(o);
				if(orderNo>0) {
					JOptionPane.showMessageDialog(CafeUi.this, "주문 완료: 주문번호 [ " +orderNo+"]");
				}else {
					JOptionPane.showMessageDialog(CafeUi.this, "다시 주문해 주세요");
				}
			} catch (CafeException e1) {
				JOptionPane.showMessageDialog(CafeUi.this, e1.getMessage());
			}
			
		});
		
		// 상품 조회
		btn_prodSelect.addActionListener(e -> {
			String prodCode = tf_prodCode.getText();
			try {
				String prodName = pService.selectProduct(prodCode);
				if(prodName == null) {
					JOptionPane.showMessageDialog(CafeUi.this, "상품 코드를 확인해 주세요");
				}else {
					tf_orderProd.setText(prodName);
//					JOptionPane.showMessageDialog(CafeUi.this, prodName+"님 조회 되셨습니다.");
				}				
			} catch (CafeException e1) {
				JOptionPane.showMessageDialog(CafeUi.this, e1.getMessage());
			}
		}
	);
		
		// 상품 등록
		btn_prodInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String prodCode = tf_prodCode.getText();
				String prodName = tf_prodName.getText();
				int price = Integer.parseInt(tf_prodPrice.getText());
				// 텍스트필드로 받아오기 때문에 숫자를 입력해도 String으로 받아옴. 스트링을 int로 바꿔주는 작업 필요 
				ProductDTO p = new ProductDTO(prodCode, prodName, price);
				
				try {
					
					pService.insertProduct(p);
					setProductList();
					// 가입완료후 tf입력내용 사라지도록
					tf_prodCode.setText("");
					tf_prodName.setText("");
					tf_phone.setText("");
					
					JOptionPane.showMessageDialog(CafeUi.this, "상품이 등록되었습니다.");
				} catch (CafeException e1) {
					JOptionPane.showMessageDialog(CafeUi.this, e1.getMessage());
				}
			}
		});
		
		// 조회
		btn_memSelect.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String memId= tf_memId.getText();
				try {
					String memName = mservice.selectMember(memId);
					if(memName == null) {
						JOptionPane.showMessageDialog(CafeUi.this, "고객 ID를 확인해 주세요");
					}else {
						tf_orderMem.setText(memName);
						JOptionPane.showMessageDialog(CafeUi.this, memId+"님 조회 되셨습니다.");
					}
				} catch (CafeException e1) {
					JOptionPane.showMessageDialog(CafeUi.this, e1.getMessage());
				}
			}
		});
		
		btn_memInsert.addActionListener(new ActionListener() {
			// 가입 버튼을 누를 때마다 멤버서비스 객체가 생성되면 너무많은 객체가 생김. 위에서 선언하고 생성하도록
			@Override
			public void actionPerformed(ActionEvent e) {
				// 가입
				String memId= tf_memId.getText();
				String memName=tf_memName.getText();
				String phone=tf_phone.getText();
				Date now=new Date();
				MemberDTO m=new MemberDTO(memId,memName,now,phone); // 회원객체생성
				System.out.println(m); 
				try { // 오버라이드 메소드여서 throw못함??
					mservice.insertMember(m); // 회원정보를 insert하는 메소드수행
					setMemberList();
					// 가입완료후 tf입력내용 사라지도록
					tf_memId.setText("");
					tf_memName.setText("");
					tf_phone.setText("");
					JOptionPane.showMessageDialog(CafeUi.this, "가입 되셨습니다.");
				} catch (CafeException e1) {
					JOptionPane.showMessageDialog(CafeUi.this, e1.getMessage()); // CafeException을 돌려줌! 
				}
				
			}
		});
		
	}

}