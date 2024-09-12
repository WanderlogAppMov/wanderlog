package org.hign.platform.wanderlog.Hotels.interfaces.rest;

import org.hign.platform.wanderlog.Hotels.application.commandServices.AddHotelCommandService;
import org.hign.platform.wanderlog.Hotels.application.queryServices.GetHotelsQueryService;
import org.hign.platform.wanderlog.Hotels.domain.model.aggregates.Hotel;
import org.hign.platform.wanderlog.Hotels.domain.model.commands.AddHotelCommand;
import org.hign.platform.wanderlog.Hotels.interfaces.rest.resources.HotelResponse;
import org.hign.platform.wanderlog.Hotels.interfaces.rest.transform.HotelResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private AddHotelCommandService addHotelCommandService;

    @Autowired
    private GetHotelsQueryService getHotelsQueryService;

    @GetMapping
    public List<HotelResponse> getHotels() {
        List<Hotel> hotels = getHotelsQueryService.getAllHotels();
        return hotels.stream().map(HotelResponseTransformer::transform).collect(Collectors.toList());
    }

    @PostMapping
    public HotelResponse addHotel(@RequestBody AddHotelCommand command) {
        Hotel hotel = addHotelCommandService.addHotel(command.getHotelName(), command.getCountry(), command.getCity(), command.getStars(), command.getPricePerNight(), command.getContinent());
        return HotelResponseTransformer.transform(hotel);
    }

    // Obtener hoteles por ID de continente
    @GetMapping("/continent/{continentId}")
    public List<HotelResponse> getHotelsByContinentId(@PathVariable Integer continentId) {
        List<Hotel> hotels = getHotelsQueryService.getHotelsByContinentId(continentId);
        return hotels.stream().map(HotelResponseTransformer::transform).collect(Collectors.toList());
    }

    // Obtener hoteles por nombre de continente
    @GetMapping("/continent/name/{continentName}")
    public List<HotelResponse> getHotelsByContinentName(@PathVariable String continentName) {
        List<Hotel> hotels = getHotelsQueryService.getHotelsByContinentName(continentName);
        return hotels.stream().map(HotelResponseTransformer::transform).collect(Collectors.toList());
    }

    // PUT para actualizar un hotel
    @PutMapping("/{hotelId}")
    public HotelResponse updateHotel(@PathVariable Integer hotelId, @RequestBody AddHotelCommand command) {
        Hotel hotel = addHotelCommandService.updateHotel(hotelId, command.getHotelName(), command.getCountry(), command.getCity(), command.getStars(), command.getPricePerNight(), command.getContinent());
        return HotelResponseTransformer.transform(hotel);
    }

    // DELETE para eliminar un hotel
    @DeleteMapping("/{hotelId}")
    public String deleteHotel(@PathVariable Integer hotelId) {
        addHotelCommandService.deleteHotel(hotelId);
        return "Hotel deleted successfully";
    }
}
