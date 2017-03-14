package org.hz.realtime.transfer.message.assemble.detail.imp;

import java.io.UnsupportedEncodingException;

import org.hz.realtime.common.sequence.utils.secret.RSAUtils;
import org.hz.realtime.transfer.message.assemble.detail.AssembleSignBase;
import org.hz.realtime.transfer.message.util.ParamsUtil;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.zcbspay.platform.hz.realtime.message.bean.CMS316Bean;
import com.zcbspay.platform.hz.realtime.message.common.MessageBean;

@Service("assembleSignBase316")
public class AssembleSignBase316 implements AssembleSignBase {

    @Override
    public String signatureElement(MessageBean bean) {
        String signature = null;
        CMS316Bean msgBodyBean = (CMS316Bean) bean.getCNAPSMessageBean();
        String msgBody = JSONObject.toJSONString(msgBodyBean);
        try {
            signature = RSAUtils.sign(msgBody.getBytes("utf-8"), ParamsUtil.getInstance().getPrivateKey());
        }
        catch (UnsupportedEncodingException e) {
            // TODO mxwtodo
            e.printStackTrace();
        }
        catch (Exception e) {
            // TODO mxwtodo
            e.printStackTrace();
        }
        return signature;
    }

}