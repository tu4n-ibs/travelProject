package org.example.travelproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import net.sf.jsqlparser.Model;
import org.example.travelproject.model.Booking;
import org.example.travelproject.model.Tour;
import org.example.travelproject.model.User;
import org.example.travelproject.service.Impl.BIllService;
import org.example.travelproject.service.Impl.BookingService;
import org.example.travelproject.service.Impl.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class TravelController {

    @Autowired
    private TourService tourService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private BIllService bIllService;

    @GetMapping("/findAllBook")
    public ModelAndView bookingForm() {
        ModelAndView modelAndView = new ModelAndView("bookingF");
        List<Booking> bookingList = (List<Booking>) bookingService.findAll();
        return modelAndView.addObject("listBooking", bookingList);
    }

    //
    @GetMapping("/bookingF")
    public ModelAndView createBooking(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("createBooking");
        HttpSession session = request.getSession();
        Tour tour = (Tour) session.getAttribute("tour");
        modelAndView.addObject("tour", tour);
        modelAndView.addObject("newBooking", new Booking());
        return modelAndView;
    }

    //
    @GetMapping("/{id}/tourDetail")
    public ModelAndView bookingTour(@PathVariable int id, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("tourDetail");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        modelAndView.addObject("user", user);
        Tour tour = tourService.findById(id).get();
        modelAndView.addObject("tourDetail", tour);
        HttpSession tourSession = request.getSession();
        tourSession.setAttribute("tour", tour);
        return modelAndView;
    }

    //
    @PostMapping("/booking")
    public ModelAndView bookTour(Booking booking, HttpServletRequest request, @RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/travel");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Tour tour = new Tour();
        tour.setId(id);
        booking.setTour(tour);
        booking.setUser(user);
        if (user == null) {
            ModelAndView modelAndView1 = new ModelAndView("redirect:/log");
            return modelAndView1;
        }
        if (booking.getStatus() == null) {
            booking.setStatus("đang chờ xác nhận");
        }
        bookingService.save(booking);
        return modelAndView;
    }

    //
    @GetMapping("/findTourBooked")
    public ModelAndView tourBooked(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("tourBooked");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Booking> bookingList = bookingService.findAllByUserId(user.getId());
        if (bookingList.isEmpty()) {
            modelAndView.addObject("message", "404");
        }
        modelAndView.addObject("booked", bookingList);
        return modelAndView;
    }

    //
    @GetMapping("/findAllTour")
    public ModelAndView findAllTour(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("tourF");
        Page<Tour> tourList = tourService.findAll(pageable);
        return modelAndView.addObject("listTour", tourList);
    }

    //
    @GetMapping("/createTour")
    public ModelAndView createTour() {
        ModelAndView modelAndView = new ModelAndView("createTour");
        modelAndView.addObject("newTour", new Tour());
        return modelAndView;
    }

    //
    @PostMapping("/tour")
    public ModelAndView saveTour(Tour tour) {
        tourService.save(tour);
        ModelAndView modelAndView = new ModelAndView("adminF");
        modelAndView.addObject("tour", new Tour());
        modelAndView.addObject("message", "New tour created successfully");
        return modelAndView;
    }

    //
    @GetMapping("/{id}/updateTour")
    public ModelAndView updateForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("updateTour");
        return modelAndView.addObject("tourUpdate", tourService.findById(id).get());
    }

    //
    @PostMapping("/update")
    public ModelAndView updateTour(Tour tour) {
        ModelAndView modelAndView = new ModelAndView("redirect:/findAllTour");
        tourService.save(tour);
        return modelAndView;
    }

    //
    @GetMapping("/search")
    public ModelAndView searchTour(@RequestParam("keyword") String keyword, @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("travelF");
        Page<Tour> tourList = tourService.findAllByName(pageable, keyword);
        modelAndView.addObject("listTour", tourList);
        return modelAndView;
    }

    //
    @GetMapping("/travel")
    public ModelAndView travelHome(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("travelF");
        Page<Tour> tourList = tourService.findAll(pageable);
        return modelAndView.addObject("listTour", tourList);
    }

    @PostMapping("/deleteBill")
    public ModelAndView deleteBill(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/findAllBook");
        bookingService.remove(id);
        return modelAndView;
    }

    @PostMapping("/cancelBill")
    public ModelAndView cancelBill(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/findTourBooked");
        bookingService.remove(id);
        return modelAndView;
    }
//    @PostMapping("/acceptBill")
//    public ModelAndView acceptBill(@RequestParam("id") int id){
//        ModelAndView modelAndView = new ModelAndView("waitBill");
//        Optional<Booking> booking = bookingService.findById(id);
//        bIllService.save(booking);
//        return modelAndView;
//    }

}
