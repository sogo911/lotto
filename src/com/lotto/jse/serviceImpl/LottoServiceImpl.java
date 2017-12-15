package com.lotto.jse.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lotto.jse.domain.LottoBean;
import com.lotto.jse.service.LottoService;

public class LottoServiceImpl implements LottoService{
	
	private List<LottoBean> lottos;
	public LottoServiceImpl() {
		lottos = new ArrayList<LottoBean>();
	}

	@Override
	public void receiveMoney(LottoBean bean) {
		LottoBean lotto = null;
		if(Integer.parseInt(bean.getMoney()) > 5000) {
			bean.setMoney("5000");
		}
		String res = "";
		for(int i = 0 ; i < Integer.parseInt(bean.getMoney())/1000; i++) {
			lotto = new LottoBean();
			int[] t = createLotto();
			res += t[i]+",";
			lotto.setNum(res+"\n");
			lottos.add(lotto);
//			int[] arr = new int[6];
//			for(int j = 1; j <= 6 ; j++) {
//				arr[i] = (int)(Math.random()*45)+1;
//			}
//			for(int j = 1; j <= 6 ; j++) {
//				System.out.println(arr[j]+"\t");
//			}
//			System.out.println();
		}
	}
	
	public int[] createLotto() {
		int[] lotto = new int [6];
		for(int i = 0; i < 6 ; i++) {
			int num = (int)(Math.random()*45)+1;
			boolean exist = false;
			for(int j = 0; j < lotto.length; j++) {
				if(num == lotto[j]) {
					exist = true;
					break;
				}
			}
			if(exist) {
				i--;
				continue;
			}else {
				lotto[i]=num;
			}
		}
		Arrays.sort(lotto);
		for(int i = 0; i < 0; i++) {
			System.out.println(lotto[i]);
		}
		return lotto;
	} 

	@Override
	public List<LottoBean> showLottos() {
		return lottos;
	}
}