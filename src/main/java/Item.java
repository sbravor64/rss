import javax.xml.bind.annotation.XmlElement;

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
