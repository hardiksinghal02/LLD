package com.parkinglot.entities;

import com.lld.entity.AbstractEntity;
import com.parkinglot.enums.BookingStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Booking extends AbstractEntity<Booking> {
    private final String id;
    private final String numberPlate;
    private final String spotId;
    private final Long entryTime;
    @Setter
    private BookingStatus status;

    public Booking(String id,
                   String numberPlate,
                   String spotId,
                   Long entryTime,
                   BookingStatus status) {
        this.id = id;
        this.numberPlate = numberPlate;
        this.spotId = spotId;
        this.entryTime = entryTime;
        this.status = status;
    }

    public static BookingBuilder builder() {
        return new BookingBuilder();
    }

    public static class BookingBuilder {
        private String id;
        private String numberPlate;
        private String spotId;
        private Long entryTime;
        private BookingStatus status;

        public BookingBuilder id(String id) {
            this.id = id;
            return this;
        }

        public BookingBuilder numberPlate(String numberPlate) {
            this.numberPlate = numberPlate;
            return this;
        }

        public BookingBuilder spotId(String spotId) {
            this.spotId = spotId;
            return this;
        }

        public BookingBuilder entryTime(Long entryTime) {
            this.entryTime = entryTime;
            return this;
        }

        public BookingBuilder status(BookingStatus status) {
            this.status = status;
            return this;
        }

        public Booking build() {
            return new Booking(id, numberPlate, spotId, entryTime, status);
        }
    }

    @Override
    public Booking clone() {
        return new Booking(id, numberPlate, spotId, entryTime, status);
    }
}
