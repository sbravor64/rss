import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Items{
    @XmlElement(name="item")
    List<Item> itemList;
}
