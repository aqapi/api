package pl.kozubek.measuringstation.app.station.model.dto;

/**
 * Obiekt reprezentujący lokalizację geograficzną
 *
 * @param gegrLan długość horyzontalna
 * @param gegrLon długość wertykalna
 */
public record LocalizationDto(Long gegrLan, Long gegrLon) {
}
