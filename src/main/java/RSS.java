import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "rss")
@XmlAccessorType(XmlAccessType.PROPERTY)
class RSS {
    @XmlElement(name="channel")
    List<Channel> channelList;


    //    public void setChannelList(List<Channel> channelList) {
//        this.channelList = channelList;
//    }
//
//    void addChannel(Channel c){
//        channelList.add(c);
//    };
}
