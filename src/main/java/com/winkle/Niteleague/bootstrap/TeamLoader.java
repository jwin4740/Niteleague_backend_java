package com.winkle.Niteleague.bootstrap;
import com.winkle.Niteleague.model.Team;
import com.winkle.Niteleague.repository.TeamRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
@Component
public class TeamLoader implements ApplicationListener<ContextRefreshedEvent> {


    private TeamRepository teamRepository;

    private Logger log = LogManager.getLogger();
//    private Logger log = Logger.getLogger(TeamLoader.class);

    @Autowired
    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Team team = new Team();
        team.setTeamName("Burr");
        team.setAvatar("somethingg.png");
        teamRepository.save(team);

        log.info("Saved Shirt - id: " + team.getId());
    }
}