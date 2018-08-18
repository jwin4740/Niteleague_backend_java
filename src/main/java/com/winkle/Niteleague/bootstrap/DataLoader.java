package com.winkle.Niteleague.bootstrap;

import com.winkle.Niteleague.model.Team;
import com.winkle.Niteleague.repository.TeamMemberRepository;
import com.winkle.Niteleague.repository.TeamRepository;
import com.winkle.Niteleague.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private TeamRepository teamRepository;
    private UserRepository userRepository;
    private TeamMemberRepository teamMemberRepository;
    private Logger log = LogManager.getLogger();

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

    private void insertTeams() {
        String fileName = "src/test/txtfiles/teams.txt";
        ArrayList<String> k = setProps(fileName);
        for (String i : k) {
            Team team = new Team();
            team.setTeamName(i);
            team.setAvatar(i + ".png");
            teamRepository.save(team);

            log.info("Saved team");
        }

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