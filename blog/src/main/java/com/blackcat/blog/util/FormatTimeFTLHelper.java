package com.blackcat.blog.util;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.io.Writer;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * <p> 描述 : Freemaker格式化时间戳为指定日期
 * 示例 : <@formatTime unix="${entity.createTime}" pattern="yyyy-MM-dd HH:mm:ss"> </@formatTime>
 * @author : blackcat
 * @date  : 2020/3/11 18:24
*/
public class FormatTimeFTLHelper implements TemplateDirectiveModel {
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Override
    public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        if (body == null) {
            throw new TemplateModelException("自定义标签必须有内容，即自定义开始标签与结束标签之间必须有内容");
        }
        Writer out = env.getOut();
        TemplateScalarModel scalarModel = (TemplateScalarModel) params.get("unix");
        if (null == scalarModel) {
            return;
        }
        TemplateScalarModel pattern = (TemplateScalarModel) params.get("pattern");
        String asString;
        if (pattern == null) {
            asString = DATE_TIME_PATTERN;
        } else {
            asString = pattern.getAsString();
        }
        // TODO LocalDateTime转换 没找到确切的解决方法 暂时代替
        String value=scalarModel.getAsString().replace("T"," ");
        DateTimeFormatter dtf =   DateTimeFormatter.ofPattern(asString);
        out.write(dtf.format(dtf.parse(value)));
        body.render(out);
    }
}
