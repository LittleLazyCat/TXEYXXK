package com.txey.wxgzh.zyqd.utils;


import com.txey.wxgzh.zyqd.entity.Inpatient;

public class Security {

    /**
     * 判断查询信息是否真实
     *
     * @param inpatient
     *            住院病人
     * @param idInfo
     *          身份证号或者手机号
     * @return boolean
     */
    public boolean checkIdentity(Inpatient inpatient, String idInfo){
        String sfzh = inpatient.getSfzh();
        sfzh = sfzh.substring(sfzh.length()-6,sfzh.length());
        String jtdh = inpatient.getJtdh();
        jtdh = jtdh.substring(jtdh.length()-6,jtdh.length());

        if(sfzh.equals(idInfo)||jtdh.equals(idInfo)){
            return true;
        }else
        {
            return false;
        }

    }
}
