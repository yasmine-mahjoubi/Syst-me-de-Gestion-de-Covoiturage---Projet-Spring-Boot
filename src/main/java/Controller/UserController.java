package Controller;

import Entity.User;
import Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // indique que la classe est un contrôleur Spring qui renvoie
// directement des données au format JSON ou XML en réponse aux requêtes HTTP
//combine les 2 (@Controller et @ResponseBody) évitant d'écrire @ResponseBody sur chaque méthode.
@RequestMapping("/users") //Indique que toutes les requêtes à des endpoints
// commençant par /users doivent être gérées par ce contrôleur.
public class UserController {

    @Autowired
    //avec @Autowired on n'a pas besoin d'instancier les objets avec new
    //car Spring gère l'injection des dépendances automatiquement.
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
        /*grace à @RequestBody: 'user' est construit à partir du JSON envoyé
        dans la requête cad elle permet de mapper le corps
        d'une requête HTTP (JSON, XML, etc.) à un objet Java*/
        //Reçoit un objet JSON via le corps de la requête HTTP POST.
        //Appelle la méthode saveUser du service pour enregistrer l'utilisateur.
        //Retourne une réponse HTTP avec l'objet utilisateur créé.
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
        //Lit l'ID depuis l'URL (exemple : /users/1).
        //Utilise getUserById du service pour trouver l'utilisateur.
        //Retourne l'utilisateur si trouvé.
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
        //Appelle la méthode getAllUsers du service pour récupérer une liste.
        //Retourne cette liste sous forme de réponse HTTP.
    }

    @PutMapping("/{id}") //Utilisée pour mettre à jour une ressource existante.
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
        //Lit l'ID depuis l'URL.
        //Appelle deleteUser dans le service pour supprimer l'utilisateur.
        //Retourne une réponse HTTP vide avec un statut 204 No Content.
    }
}

//@PathVariable Utilisée pour extraire une valeur depuis l'URL et associer
//à un paramètre de méthode.
