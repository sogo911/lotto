package com.lotto.jse.service;

import java.util.List;

import com.lotto.jse.domain.LottoBean;

public interface LottoService {
	public void receiveMoney(LottoBean bean);
	public List<LottoBean> showLottos();
	public int[] createLotto();
}
