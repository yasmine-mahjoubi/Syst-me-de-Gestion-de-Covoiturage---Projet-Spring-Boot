package Services;

import Entity.User;
import Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public User updateUser(Long id, User updatedUser) {
        // Récupérer l'utilisateur existant par ID
        Optional<User> existingUserOpt = userRepository.findById(id);

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();

            // Mettre à jour les champs de l'utilisateur
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setRole(updatedUser.getRole());
            existingUser.setRating(updatedUser.getRating());

            // Sauvegarder les modifications dans la base de données
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("Utilisateur avec l'ID " + id + " non trouvé.");
        }
    }
}

