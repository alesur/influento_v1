package com.influencer.management.app.controller;

import com.influencer.management.app.model.dao.*;
import com.influencer.management.app.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * This Controller manages operations with Influencer
 *
 * @influencerList shows the list of existing influencers
 * @view Get method, shows a prefilled form with the actual information of the Influencer {id}
 * @editget Get method, shows Influencer's form for editing
 * @addReview Post method, adds review  for the Influencer {id}
 * @assignProduct Post method, assigns products for the Influencer {id}
 * @deleteReview Get method, deletes a review
 * @addDayContacted Post method, adds the date of contact with Influencer
 * @deleteDayContacted Get method, deletes the date of contact
 * @deleteAssignedProduct Get method, deletes assigned product
 * @editpost Post method, performs the update of the influencer and his personal details
 * @showFormForAdd Get method, shows a form to create a new influencer
 * @delete Get method, performs the deletion of the influencer by {id}
 */

@Controller
@RequestMapping("/influencer")
public class InfluencerController {

    @Autowired
    private InfluencerRepository influencerRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private PersonalDetailsReposiroty personalDetailsReposiroty;

    @Autowired
    private InstagramProfileRepository instagramProfileReposiroty;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private DayContactedRepository dayContactedRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AssignedProductsRepository assignedProductsRepository;

    @GetMapping()
    public String influencerList(Model model) {
        List<Influencer> influencers = influencerRepository.findAll();
        List<DayContacted> dayContacted = dayContactedRepository.findAll();
        model.addAttribute("influencer", influencers);
        model.addAttribute("dayContacted", dayContacted);
        return "influencer.html";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {

        Influencer influencer = influencerRepository.getOne(id);
        Country country = countryRepository.getOne(id);
        PersonalDetails personalDetails = personalDetailsReposiroty.getOne(id);
        InstagramProfile instagramProfile = instagramProfileReposiroty.getOne(id);
        List<Product> productList = productRepository.findAll();
        AssignedProducts productassign = assignedProductsRepository.getOne(id);


        Review review = new Review();
        DayContacted dayContacted = new DayContacted();


        model.addAttribute("influencer", influencer);
        model.addAttribute("country", country);
        model.addAttribute("personalDetails", personalDetails);
        model.addAttribute("instagramProfile", instagramProfile);
        model.addAttribute("review", review);
        model.addAttribute("dayContacted", dayContacted);
        model.addAttribute("product", productList);
        model.addAttribute("productassign", productassign);

        return "influencer-view.html";
    }


    @GetMapping("/edit/{id}")
    public String editget(@PathVariable int id, Model model) {

        List<Country> countryList = countryRepository.findAll();
        Influencer influencer = influencerRepository.getOne(id);
        PersonalDetails personalDetails = personalDetailsReposiroty.getOne(id);
        InstagramProfile instagramProfile = instagramProfileReposiroty.getOne(id);

        model.addAttribute("influencer", influencer);
        model.addAttribute("country", countryList);
        model.addAttribute("personalDetails", personalDetails);
        model.addAttribute("instagramProfile", instagramProfile);

        return "influencer-edit.html";
    }

    @PostMapping("/view/{id}/addReview")
    public String addReview(@ModelAttribute("review") Review theReview, @PathVariable int id) {
        Influencer influencer = influencerRepository.getOne(id);
        theReview.setId(0);
        theReview.setInfluencerf(influencer);
        reviewRepository.save(theReview);
        return "redirect:/influencer/view/{id}";
    }

    @PostMapping("/view/{id}/assignProduct")
    public String assignProduct(@ModelAttribute("assignedProducts") AssignedProducts assignedProducts, @PathVariable int id) {
        Influencer influencer = influencerRepository.getOne(id);
        assignedProducts.setId(0);
        assignedProducts.setInfluencer(influencer);
        assignedProductsRepository.save(assignedProducts);
        return "redirect:/influencer/view/{id}";
    }

    @GetMapping("/view/{influID}/deleteReview/{reviewId}")
    public String deleteReview(@PathVariable int influID, @PathVariable("reviewId") int reviewId) {
        reviewRepository.deleteById(reviewId);
        return "redirect:/influencer/view/{influID}";
    }

    @PostMapping("/view/{id}/addDayContacted")
    public String addDayContacted(@ModelAttribute("dayContacted") DayContacted theDayContacted, @PathVariable int id) {
        Influencer influencer = influencerRepository.getOne(id);
        theDayContacted.setId(0);
        theDayContacted.setInfluencer(influencer);
        dayContactedRepository.save(theDayContacted);
        return "redirect:/influencer/view/{id}";
    }

    @GetMapping("/view/{influID}/deleteDay/{dayId}")
    public String deleteDayContacted(@PathVariable int influID, @PathVariable("dayId") int dayId) {
        dayContactedRepository.deleteById(dayId);
        return "redirect:/influencer/view/{influID}";
    }

    @GetMapping("/view/{influID}/deleteAssignedProduct/{productId}")
    public String deleteAssignedProduct(@PathVariable int influID, @PathVariable("productId") int productId) {
        assignedProductsRepository.deleteById(productId);
        return "redirect:/influencer/view/{influID}";
    }

    @PostMapping("/edit")
    public String editpost(@Valid Influencer influencer, PersonalDetails personalDetails, InstagramProfile instagramProfile) {

        influencer.setInstagramProfile(instagramProfile);
        influencer.setPersonalDetails(personalDetails);

        influencerRepository.save(influencer);
//        personalDetailsReposiroty.save(personalDetails);
//        instagramProfileReposiroty.save(instagramProfile);

        return "redirect:/influencer";
    }

    @GetMapping("/add")
    public String showFormForAdd(Model model) {


        Influencer influencer = new Influencer();
        PersonalDetails personalDetails = new PersonalDetails();
        InstagramProfile instagramProfile = new InstagramProfile();
        List<Country> countryList = countryRepository.findAll();

        model.addAttribute("influencer", influencer);
        model.addAttribute("personalDetails", personalDetails);
        model.addAttribute("instagramProfile", instagramProfile);
        model.addAttribute("country", countryList);

        return "influencer-add.html";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("influencerId") int id) {

        influencerRepository.deleteById(id);
//        personalDetailsReposiroty.deleteById(id);
//        instagramProfileReposiroty.deleteById(id);
//        reviewRepository.deleteAll();

        return "redirect:/influencer";

    }
}
