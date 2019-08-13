package com.github.binarywang.demo.wx.mp.handler;

import com.github.binarywang.demo.wx.mp.builder.TextBuilder;
import com.github.binarywang.demo.wx.mp.utils.JsonUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceHttpClientImpl;
import me.chanjar.weixin.mp.bean.WxMpSemanticQuery;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpSemanticQueryResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {

    private WxMpServiceHttpClientImpl wx = new WxMpServiceHttpClientImpl();

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
//        try {
//            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
//                && weixinService.getKefuService().kfOnlineList()
//                .getKfOnlineList().size() > 0) {
//                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
//                    .fromUser(wxMessage.getToUser())
//                    .toUser(wxMessage.getFromUser()).build();
//            }
//
//        } catch (WxErrorException e) {
//            e.printStackTrace();
//        }

        String str = "发单";
        String address = wxMessage.getContent();
        String content = "";
        if (StringUtils.startsWith(address, "发单")) {
            address = address.replaceFirst("发单", "");
            WxMpSemanticQuery wxMpSemanticQuery = new WxMpSemanticQuery();
            wxMpSemanticQuery.setQuery(address);
            wxMpSemanticQuery.setCategory("LOC_POI");
            wxMpSemanticQuery.setLatitude(121.76F);
            wxMpSemanticQuery.setLongitude(31.05F);
            wxMpSemanticQuery.setCity("上海");
            wxMpSemanticQuery.setAppid("wxafcb7752886aa01b");
            wxMpSemanticQuery.setUid(wxMessage.getFromUser());

            WxMpSemanticQueryResult result = null;
            try {
                result = wx.semanticQuery(wxMpSemanticQuery);
            } catch (WxErrorException e) {
                e.printStackTrace();
            }
            //TODO 组装回复消息
             content = "收到信息内容：" + JsonUtils.toJson(result);
        }

        return new TextBuilder().build(content, wxMessage, weixinService);

    }


}
