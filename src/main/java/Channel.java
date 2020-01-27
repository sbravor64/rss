import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "rss")
@XmlAccessorType(XmlAccessType.PROPERTY)
class Channels{
    @XmlElement(name="channel")
    List<Channel> channelList;

    public List<Channel> getChannelList() {
        return channelList;
    }
}

class Item{
    @XmlElement(name = "title")
    String title;

    @XmlElement(name = "category")
    String category;

    @XmlElement(name = "description")
    String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}' + "\n";
    }
}

public class Channel {

    @XmlElement(name = "title")
    String title;

    @XmlElement(name = "description")
    String description;

    @XmlElement(name = "item")
    private List<Item> items = new ArrayList<>();

    @Override
    public String toString() {
        return "Channel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", items=" + items +
                '}';
    }

    public List<Item> getItems() {
        return items;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}


