package com.fruit.core;

import java.text.DateFormat;
import java.util.Date;

import com.fruit.core.utils.DateUtil;

/**
 * 
 * @author jzx
 * @date 2016-21-31 9:03:08
 * 
 *       新年新气象
 * @update date 2017-1-3
 */
public enum System {

	DATE_TIME {
		@Override
		String getInfo() {
			return DateFormat.getDateInstance().format(new Date());
		}
	},
	DATE_TIME_YYYY_MM_DD {
		@Override
		String getInfo() {
			return DateUtil.format(new Date(), DateUtil.yyyyMMdd);
		}
	},
	DATE_TIME_YYYYMMDDHHMMSS {
		@Override
		String getInfo() {
			return DateUtil.format(new Date(), DateUtil.yyyyMMddHHmmss);
		}
	};

	abstract String getInfo();
}
