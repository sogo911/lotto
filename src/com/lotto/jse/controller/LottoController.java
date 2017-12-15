package com.lotto.jse.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.lotto.jse.constants_pool.Value;
import com.lotto.jse.domain.LottoBean;
import com.lotto.jse.service.LottoService;
import com.lotto.jse.serviceImpl.LottoServiceImpl;

public class LottoController {
	public static void main(String[] args) {
		LottoService lottoService = new LottoServiceImpl();
		LottoBean lotto = new LottoBean();
		while(true) {
			switch (JOptionPane.showInputDialog(Value.MENU)){
			//case 
			case "0":
				JOptionPane.showMessageDialog(null, "시스템 종료");
				return;
			case "1":
				lotto.setMoney(
						JOptionPane.showInputDialog("1회당 1000원 단위로 입력하세요."));
						lottoService.receiveMoney(lotto);
				break;
			case "2":
				String message = lottoService.showLottos().toString();
				JOptionPane.showMessageDialog(null, 
						lottoService.showLottos());
				break;
			case "3":
				File f = new File("C:\\Users\\1027\\jse\\elclipse\\Workspace\\lotto\\lotto.txt");
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter(f));
					bw.write("로또번호 : 1 2 3 4 5 6");
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						bw.flush();
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			}
		}
	}
}
