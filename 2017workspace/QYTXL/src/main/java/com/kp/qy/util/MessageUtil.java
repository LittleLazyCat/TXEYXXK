package com.kp.qy.util;

import com.kp.qy.pojo.resp.TextMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * 消息工具类
 *
 * @author sunlight
 */
public class MessageUtil {
    /**
     * 返回消息类型：文本
     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";

    /**
     * 返回消息类型：音乐
     */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

    /**
     * 返回消息类型：图文
     */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";

    /**
     * 请求消息类型：文本
     */
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";

    /**
     * 请求消息类型：图片
     */
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

    /**
     * 请求消息类型：链接
     */
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    /**
     * 请求消息类型：地理位置
     */
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

    /**
     * 请求消息类型：音频
     */
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

    /**
     * 请求消息类型：推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    /**
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：unsubscribe(取消订阅)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    public static final String EVENT_TYPE_CLICK = "click";


    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    public static final String EVENT_TYPE_VIEW = "view";

    /**
     * 解析微信发来的请求（XML）
     *
     * @param msg
     * @return
     * @throws Exception
     */

    public static Map<String, String> parseXml(String msg) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();

        // 从request中取得输入流
        // InputStream inputStream = new
        // ByteArrayInputStream(msg.getBytes("UTF-8"));
        StringReader sr = new StringReader(msg);
        InputSource is = new InputSource(sr);

        // 读取输入流
        // SAXReader reader = new SAXReader();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(is);
        // 得到xml根元素
        Element root = document.getDocumentElement();

        // 获得信息类型
        NodeList nodelist_msgType = root.getElementsByTagName("MsgType");
        String msgType = nodelist_msgType.item(0).getTextContent();
        map.put("MsgType", msgType);
        // 获得信息接收人
        NodeList nodelist_toUserName = root.getElementsByTagName("ToUserName");
        String toUserName = nodelist_toUserName.item(0).getTextContent();
        map.put("ToUserName", toUserName);
        // 获得信息发送人
        NodeList nodelist_fromUserName = root.getElementsByTagName("FromUserName");
        String fromUserName = nodelist_fromUserName.item(0).getTextContent();
        map.put("FromUserName", fromUserName);

        // 获得企业应用ID
        NodeList nodelist_agentid = root.getElementsByTagName("AgentID");
        String agentid = nodelist_agentid.item(0).getTextContent();
        map.put("AgentID", agentid);
        // 文本消息
        if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            // 获得文本消息内容
            NodeList nodelist_content = root.getElementsByTagName("Content");
            String content = nodelist_content.item(0).getTextContent();
            map.put("Content", content);
            // 获得消息ID
            NodeList nodelist_msgId = root.getElementsByTagName("MsgId");
            String msgId = nodelist_msgId.item(0).getTextContent();
            map.put("MsgId", msgId);
        }
        // 图片消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {

        }
        // 地理位置消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {

        }
        // 链接消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {

        }
        // 音频消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {

        }
        // 事件推送
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {

            // 获得事件类型
            NodeList nodelist_event = root.getElementsByTagName("Event");
            String eventType = nodelist_event.item(0).getTextContent();
            map.put("Event", eventType);
            // 自定义菜单点击事件
            if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_VIEW)||eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_CLICK)) {
                // 事件KEY值，与创建自定义菜单时指定的KEY值对应
                NodeList nodelist_eventKey = root.getElementsByTagName("EventKey");
                String eventKey = nodelist_eventKey.item(0).getTextContent();
                map.put("EventKey", eventKey);

            }

        }

        return map;
    }

    /**
     * 文本消息对象转换成xml
     *
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String textMessageToXml(TextMessage textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /**
     * 扩展xstream，使其支持CDATA块
     *
     * @date 2013-05-19
     */
    private static XStream xstream = new XStream(new XppDriver() {
        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @Override
                @SuppressWarnings("rawtypes")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                @Override
                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });
}
