import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConexionRSS {
    static List<Channel> channels;

    public static void main(String[] args) throws IOException, JAXBException {

        List<String> urlList = new ArrayList<>();
        urlList.add("https://e00-elmundo.uecdn.es/elmundo/rss/espana.xml");
        urlList.add("http://ep00.epimg.net/rss/elpais/portada.xml");

        rssConnect(urlList);
    }

    static void rssConnect(List<String> urls) throws IOException, JAXBException {
        for (String urlR: urls) {
            URL url = new URL(urlR);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.addRequestProperty("User-Agent", "Mozilla/4.76");
            InputStream is = http.getInputStream();
            JAXBContext jaxbContext = JAXBContext.newInstance(RSS.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            channels = ((RSS)jaxbUnmarshaller.unmarshal(is)).channelList;

            channels.stream().forEach(System.out::println);
        }
    }

}
