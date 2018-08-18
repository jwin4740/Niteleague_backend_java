package com.winkle.Niteleague.seeds;

import com.winkle.Niteleague.model.Team;
import com.winkle.Niteleague.model.User;
import com.winkle.Niteleague.repository.TeamMemberRepository;
import com.winkle.Niteleague.repository.TeamRepository;
import com.winkle.Niteleague.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.*;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transaction;
import java.io.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Service
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private TeamRepository teamRepository;
    private UserRepository userRepository;
    private TeamMemberRepository teamMemberRepository;
    private Logger log = LogManager.getLogger();
    private SessionFactory hibernateFactory;
    private EntityManagerFactory emf;

    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory emf) {

        this.emf = emf;
    }

    @Autowired
    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        insertTeams();
        insertUsers();

    }

    private void insertTeams() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        String fileName = "src/test/txtfiles/teams.txt";
        ArrayList<String> k = setProps(fileName);
        for (String i : k) {
            Team team = new Team();
            team.setTeamName(i);
            team.setAvatar(i + ".png");
            teamRepository.save(team);


        }
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    private void insertUsers(){
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        String fileName1 = "src/test/txtfiles/usernames.txt";
        String fileName2 = "src/test/txtfiles/names.txt";
        ArrayList<String> k = setProps(fileName1);
        ArrayList<String> l = setProps(fileName2);
//        ArrayList<String> dedup = new ArrayList<>();
//        for(String i : k){
//            int count = 0;
//            for (String j : k){
//                if(Objects.equals(i, j)){
//                    count++;
//                }
//            }
//            if(count < 2){
//                dedup.add(i);
//            }
//        }
//        for(String m : dedup) {
//            System.out.println(m);
//        }
//        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < k.size(); i++){
            User user = new User();
            String tempUsername = k.get(i);
            user.setPSN(makePSN(tempUsername));
            user.setEmailAddress(makeEmail(tempUsername));
            user.setAvatar(tempUsername + ".png");
            user.setTwitter(makeTwitter(tempUsername));
            user.setDOB(generateDOB());
            user.setInstagram(makeINSTAGRAM(tempUsername));
            user.setEpicGames(makeEPIC(tempUsername));
            user.setStream(makeSTREAM(tempUsername));
            user.setUsername(tempUsername);
            user.setXbox(makeXBOX(tempUsername));
            user.setName(l.get(i));
            user.setPassword(randomPassword());
            userRepository.save(user);


        }
        entityManager.getTransaction().commit();
        entityManager.close();


    }






    public static String randomPassword() {
        Random r = new Random();
        StringBuilder passwd = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            int rand = r.nextInt(26) + 97;
            passwd.append(Character.toString((char) rand));
        }
        return passwd.toString();
    }

    private String makeEmail(String name) {
        String[] arr = {"@gmail.com", "@yahoo.com", "@hotmail.com"};
        Random r = new Random();
        return name + arr[r.nextInt(3)];
    }

    private String makePSN(String name) {
        return name + "_PSN";

    }

    private String makeEPIC(String name) {
        return name + "_EPIC";

    }

    private String makeFacebook(String name) {
        return name + "_FB";

    }

    private String makeINSTAGRAM(String name) {
        return name + "_INSTA";
    }

    private String makeTwitter(String name) {
        return "@" + name;
    }

    private String makeXBOX(String name) {
        return name + "_XBOX";
    }

    private String makeSTREAM(String name) {
        return name + "_STREAM";
    }

    private String makeYOUTUBE(String name) {
        return name + "_YOUTUBE";
    }

    private static String generateDOB(){
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1955, 2008);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        String month = String.valueOf(gc.get(gc.MONTH) + 1);
        String day = String.valueOf(gc.get(gc.DAY_OF_MONTH));
        if (gc.get(gc.DAY_OF_MONTH) < 10){
            day = "0" + String.valueOf(gc.get(gc.DAY_OF_MONTH));
        }
        if (gc.get(gc.MONTH) + 1 < 10){
            month = "0" + String.valueOf(gc.get(gc.MONTH) + 1);
        }
        return month + "/" + day + "/" + gc.get(gc.YEAR);
    }
    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }


    private ArrayList<String> setProps(String fileName) {
        // This will reference one line at a time
        String line = null;
        ArrayList<String> l = new ArrayList<>();


        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                l.add(line);
                System.out.println(line);
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }


        return l;


    }
}