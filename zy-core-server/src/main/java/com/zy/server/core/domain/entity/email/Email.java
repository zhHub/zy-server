package com.zy.server.core.domain.entity.email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * fileName: Email
 * create: 2021-5-29 21:25
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "email 信息")
public class Email {
    @ApiModelProperty(value = "发件人")
    private String from;
    
    @ApiModelProperty(value = "收件人")
    private List<String> to;
    
    @ApiModelProperty(value = "抄送人")
    private List<String> cc;
    
    @ApiModelProperty(value = "密件抄送")
    private List<String> bcc;
    
    @ApiModelProperty(value = "发送日期")
    private Date sentDate;
    
    @ApiModelProperty(value = "邮件标题")
    private String subject;
    
    @ApiModelProperty(value = "邮件内容")
    private String text;
    
    @ApiModelProperty(value = "是否使用模板，默认否")
    private Boolean templateFlag = Boolean.FALSE;
    
    @ApiModelProperty(value = "是否使用默认内容类型（“text/plain”）为HTML邮件应用内容类型 “text/html”,默认是")
    private Boolean htmlFlag = Boolean.TRUE;
    
    @ApiModelProperty(value = "HTML 模板标识 code")
    private String templateCode;
    
    @ApiModelProperty(value = "模板内容")
    private HashMap<String, String> templateText = new HashMap<>();
    
    @ApiModelProperty(value = "附件")
    private List<String> attachmentPath;
}
