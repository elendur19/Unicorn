package hr.croz.unicorn.controller;

import hr.croz.unicorn.model.Action;
import hr.croz.unicorn.model.Article;
import hr.croz.unicorn.service.ActionService;
import hr.croz.unicorn.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/action")
@Slf4j
public class ActionController {
    private final ActionService actionService;

    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @GetMapping
    public ResponseEntity<List<Action>> getAllActions() {
        try {
            return ResponseEntity.ok().body(actionService.getAll());
        } catch (Exception e) {
            log.error("getAllArticles...Error while getting all articles", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Action> saveNewAction(@RequestBody Action action) {
        try {
            return ResponseEntity.ok().body(actionService.save(action));
        } catch (Exception e) {
            log.error("saveNewArticle...Error while saving new article", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
