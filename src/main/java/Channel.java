import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

public class Channel{

    @XmlElement(name = "title")
    String title;

    @XmlElement(name = "description")
    String description;

    @XmlElement(name = "item")
    public List<Item> items = new ArrayList<>();

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


