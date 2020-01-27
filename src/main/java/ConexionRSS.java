import org.w3c.dom.ls.LSOutput;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConexionRSS {

    static List<Channel> channels;

    public static void main(String[] args) throws IOException, JAXBException {
        rssElPais();
        System.out.println();
        System.out.println();
        rssMundo();

    }

    static void rssMundo() throws IOException, JAXBException {
        URL url = new URL("https://e00-elmundo.uecdn.es/elmundo/rss/espana.xml");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.addRequestProperty("User-Agent", "Mozilla/4.76");
        InputStream is = http.getInputStream();
        JAXBContext jaxbContext = JAXBContext.newInstance(Channels.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        channels = ((Channels)jaxbUnmarshaller.unmarshal(is)).channelList;

//        channels.stream().forEach(System.out::println);

    }

    static void rssElPais() throws IOException, JAXBException {
        URL url = new URL("http://ep00.epimg.net/rss/elpais/portada.xml");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.addRequestProperty("User-Agent", "Mozilla/4.76");
        InputStream is = http.getInputStream();
        JAXBContext jaxbContext = JAXBContext.newInstance(Channels.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        channels = ((Channels)jaxbUnmarshaller.unmarshal(is)).channelList;

        List<Item> items = new ArrayList<>();
        channels.forEach(channel -> {
           items.addAll(channel.getItems().stream().filter(item -> item.title.toLowerCase().contains("ue")).collect(Collectors.toList()));
        });


    }

}
