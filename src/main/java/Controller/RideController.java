package Controller;

import Entity.Ride;
import Services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/rides")
public class RideController {

    @Autowired
    private RideService rideService;

    // Afficher le formulaire pour créer un trajet
    @GetMapping("/create")
    public String showCreateRideForm(Model model) {
        model.addAttribute("ride", new Ride()); // Ajoute un objet Ride vide pour le formulaire
        return "createRide"; // Correspond au fichier createRide.html
    }

    // Enregistrer un nouveau trajet
    @PostMapping("/create")
    public String createRide(@ModelAttribute Ride ride, Model model) {
        Ride savedRide = rideService.saveRide(ride);
        model.addAttribute("ride", savedRide);
        model.addAttribute("message", "Trajet créé avec succès !");
        return "rideDetails"; // Affiche les détails du trajet après la création
    }

    // Afficher les détails d'un trajet par ID
    @GetMapping("/{id}")
    public String getRideById(@PathVariable Long id, Model model) {
        Ride ride = rideService.getRideById(id);
        model.addAttribute("ride", ride);
        return "rideDetails"; // Correspond au fichier rideDetails.html
    }

    // Afficher tous les trajets
    @GetMapping
    public String getAllRides(Model model) {
        List<Ride> rides = rideService.getAllRides();
        model.addAttribute("rides", rides);
        return "allRides"; // Correspond au fichier allRides.html
    }

    // Afficher le formulaire pour mettre à jour un trajet
    @GetMapping("/{id}/update")
    public String showUpdateRideForm(@PathVariable Long id, Model model) {
        Ride ride = rideService.getRideById(id);
        model.addAttribute("ride", ride);
        return "updateRide"; // Correspond au fichier updateRide.html
    }

    // Mettre à jour un trajet existant
    @PostMapping("/{id}/update")
    public String updateRide(@PathVariable Long id, @ModelAttribute Ride ride, Model model) {
        Ride updatedRide = rideService.updateRide(id, ride);
        model.addAttribute("ride", updatedRide);
        model.addAttribute("message", "Trajet mis à jour avec succès !");
        return "rideDetails";
    }

    // Supprimer un trajet
    @GetMapping("/{id}/delete")
    public String deleteRide(@PathVariable Long id, Model model) {
        rideService.deleteRide(id);
        model.addAttribute("message", "Trajet supprimé avec succès !");
        return "redirect:/rides"; // Redirige vers la liste de tous les trajets
    }

    // Recherche de trajets
    @GetMapping("/search")
    public String searchRides(
            @RequestParam(required = false) String departure,
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) Double maxPrice,
            Model model) {

        List<Ride> rides = rideService.searchRides(departure, destination, date, maxPrice);
        model.addAttribute("rides", rides);
        return "SearchRides"; // Correspond au fichier SearchRides.html
    }
}
