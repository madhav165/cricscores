import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.lang.NullPointerException;

public class CricketScores {

    public static void main(String []args) {
        try {
            Document doc = Jsoup.connect("http://www.espncricinfo.com/ci/engine/match/index.html?view=live").get();
            String title = doc.title();
            Elements divs1 = doc.getElementsByClass("match-info");
            Elements divs2 = doc.getElementsByClass("innings-info-1");
            Elements divs3 = doc.getElementsByClass("innings-info-2");
            Elements divs4 = doc.getElementsByClass("match-status");
            String s1;
            Document d1;
            MatchObject [] matches = new MatchObject[divs1.size()];
            for (int i = 0; i < divs1.size(); i++) {

                s1 = divs1.eq(i).html();
                d1 = Jsoup.parse(s1);
                matches[i] = new MatchObject();
                matches[i].setDate(d1.getElementsByClass("bold").text());
                matches[i].setStadium(d1.getElementsByClass("match-no").text());

                s1 = divs2.eq(i).html();
                d1 = Jsoup.parse(s1);
                matches[i].setTeam1(d1.getElementsByTag("body").first().ownText());
                matches[i].setScore1(d1.getElementsByClass("bold").text());

                s1 = divs3.eq(i).html();
                d1 = Jsoup.parse(s1);
                matches[i].setTeam2(d1.getElementsByTag("body").first().ownText());
                matches[i].setScore2(d1.getElementsByClass("bold").text());

                s1 = divs4.eq(i).html();
                d1 = Jsoup.parse(s1);
                matches[i].setResult(d1.getElementsByClass("bold").text());
            }
            //System.out.format("%5s%20s%10s%10s%10s%10s%20s%1s", "Date", "Stadium", "Team 1", "Score 1", "Team 2", "Score 2", "Result", "\n");
            //System.out.format("%5s%20s%10s%10s%10s%10s%20s%1s", "------", "------", "------", "------", "------", "------", "------", "\n");
            System.out.println("\n");
            System.out.format("%-45s%-10s%-45s%5s", "-----------------------------------------", "SCORES", "-----------------------------------------", "\n");
            for (int i = 0; i < divs1.size(); i++) {
                //System.out.format("%5s%20s%10s%10s%10s%10s%20s%1s", matches[i].getDate(), matches[i].getStadium(), matches[i].getTeam1(), matches[i].getScore1(), matches[i].getTeam2(), matches[i].getScore2(), matches[i].getResult(),"\n");
                /*System.out.println("Date: " + matches[i].getDate());
                System.out.println("Stadium: " + matches[i].getStadium());
                System.out.println("Team 1: " + matches[i].getTeam1());
                System.out.println("Score 1: " + matches[i].getScore1());
                System.out.println("Team 2: " + matches[i].getTeam2());
                System.out.println("Score 2: " + matches[i].getScore2());
                System.out.println("Result: " + matches[i].getResult());
                System.out.println("-----------------");*/
                System.out.println("\n");
                System.out.format("%-30s%-25s%-30s%-25s%5s", matches[i].getTeam1(), matches[i].getScore1(), matches[i].getTeam2(), matches[i].getScore2(), "\n");

            }
            System.out.println("\n");
            //System.out.println("*Obtained from http://www.espncricinfo.com/ci/engine/match/index.html?view=live\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
} 
