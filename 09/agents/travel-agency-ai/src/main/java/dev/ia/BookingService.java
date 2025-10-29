package dev.ia;

import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.*;

@ApplicationScoped
public class BookingService {

    private final Map<Long, Booking> bookings = new HashMap<>();

    public BookingService() {
        bookings.put(12345L, new Booking(12345L, "John Doe", "Tesouros do Egito",
                LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(2).plusDays(10), BookingStatus.CONFIRMED));
        bookings.put(67890L, new Booking(67890L, "Jane Smith", "Aventura Amazônia",
                LocalDate.now().plusMonths(3), LocalDate.now().plusMonths(3).plusDays(7), BookingStatus.CONFIRMED));
    }

    public Optional<Booking> getBookingDetails(long bookingId) {

        return Optional.ofNullable(bookings.get(bookingId));
    }

    public Optional<Booking> cancelBooking(long bookingId, String customerLastName) {
        if (bookings.containsKey(bookingId)) {
            Booking booking = bookings.get(bookingId);
            if (booking.customerName().endsWith(customerLastName)) {
                Booking cancelledBooking = new Booking(booking.id(), booking.customerName(), booking.destination(),
                        booking.startDate(), booking.endDate(), BookingStatus.CANCELLED);
                bookings.put(bookingId, cancelledBooking);
                return Optional.of(cancelledBooking);
            }
        }
        return Optional.empty();
    }
}