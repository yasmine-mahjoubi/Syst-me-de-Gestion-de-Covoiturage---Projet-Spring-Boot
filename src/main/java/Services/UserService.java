package Services;

import Entity.User;
import Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    // Injection du repository via le constructeur
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Méthode pour ajouter un utilisateur
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Méthode pour récupérer tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Méthode pour récupérer un utilisateur par ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Méthode pour supprimer un utilisateur par ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

