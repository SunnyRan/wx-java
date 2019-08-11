package com.github.binarywang.demo.wx.mp.controller;

import com.github.binarywang.demo.wx.mp.model.TemplateMessageData;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: weixin-java-mp-demo-springboot
 * @description:
 * @author: Arnold
 * @create: 2019-08-11 15:16
 **/

@AllArgsConstructor
@Controller
@RequestMapping("/wx/template/message/{appid}")
public class WxTemplateMessageController {
    private final WxMpService wxService;


    @RequestMapping("/send")
    public String send(@PathVariable String appid,
                     @RequestParam(name = "toUser", required = false) String toUser,
                     @RequestParam(name = "templateId", required = false) String templateId,
                     @RequestParam(name = "url", required = false) String url,
                     @RequestBody List<TemplateMessageData> data) throws WxErrorException {
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
            .toUser(toUser)
            .templateId(templateId)
            .url(url)
            .build();
        data.forEach(info->{
            templateMessage.addData(new WxMpTemplateData(info.getName(),info.getValue(),info.getColor()));
        });

        return this.wxService.switchoverTo(appid).getTemplateMsgService().sendTemplateMsg(templateMessage);

    }
}
