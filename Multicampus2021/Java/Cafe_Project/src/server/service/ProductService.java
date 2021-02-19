package server.service;

import java.util.ArrayList;

import common.entity.ProductDTO;
import common.util.CafeException;
import server.dao.ProductDAO;

public class ProductService {
	// 왜 하는일도 없이 전달만?? 나중에 확장성을 위해 좋음. 
	// 다른 연산을 하거나 다른 서버와의 연동을 하는 역할. 
	
	ProductDAO pdao;
	
	public ProductService() throws CafeException { // 어떤 exception인지 ui쪽에서 알도록 하기 위해 try-catch하지 않음!
		pdao = new ProductDAO(); 
		// -> 수명이 같은 객체! (클래스 다이어그램에서 실선으로 표시)*/
	}

	public void insertProduct(ProductDTO p) throws CafeException {
		pdao.insertProduct(p);
		
	}

	public ArrayList<ProductDTO> selectProduct() throws CafeException {
		return pdao.selectProduct(); // 위임, delegate pattern 
		
	}

	public String selectProduct(String prodCode) throws CafeException {
		return pdao.selectProduct(prodCode);
		
	}
	

}
