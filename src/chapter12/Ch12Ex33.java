package chapter12;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Search Web
 */
public class Ch12Ex33 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the search term : ");
        String searchTerm = scanner.next();
        System.out.println("Enter the link : ");
        String link = scanner.next();
        crawler(link, searchTerm);
    }

    public static void crawler(String startingUrl, String searchTerm) {
        ArrayList<String> listOfPendingUrls = new ArrayList<>();
        ArrayList<String> listOfTraversedUrls = new ArrayList<>();

        listOfPendingUrls.add(startingUrl);
        while (!listOfPendingUrls.isEmpty() && !listOfTraversedUrls.get(listOfTraversedUrls.size() - 1).equals(searchTerm)) {
            String urlString = listOfPendingUrls.remove(0);
            if (!listOfTraversedUrls.contains(urlString)) {
                listOfTraversedUrls.add(urlString);

                for (String s : getSubUrls(urlString)) {
                    if (!listOfTraversedUrls.contains(s)) {
                        listOfPendingUrls.add(s);
                    }
                }
            }
        }
        System.out.println("The search term " + searchTerm + " was found in " + listOfTraversedUrls.get(listOfTraversedUrls.size() - 1) + " URLs");
    }

    public static ArrayList<String> getSubUrls(String urlString) {
        ArrayList<String> list = new ArrayList<>();
        try {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();
                current = line.indexOf("https:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) {
                        current = line.indexOf("http:", endIndex);
                    } else {
                        current = -1;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return list;
    }
}
